package com.hotelbooking.service;

import com.hotelbooking.dto.PaymentRequest;
import com.hotelbooking.dto.PaymentVerificationRequest;
import com.hotelbooking.model.Booking;
import com.hotelbooking.model.Payment;
import com.hotelbooking.repository.BookingRepository;
import com.hotelbooking.repository.PaymentRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final BookingRepository bookingRepository;
    private final BookingService bookingService;

    @Value("${razorpay.key.id}")
    private String razorpayKeyId;

    @Value("${razorpay.key.secret}")
    private String razorpayKeySecret;

    @Transactional
    public Payment createPaymentOrder(PaymentRequest request) throws RazorpayException {
        Booking booking = bookingRepository.findById(request.getBookingId())
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        // Check if payment already exists
        if (paymentRepository.findByBookingId(booking.getId()).isPresent()) {
            throw new RuntimeException("Payment already exists for this booking");
        }

        RazorpayClient razorpayClient = new RazorpayClient(razorpayKeyId, razorpayKeySecret);

        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", booking.getTotalAmount().multiply(java.math.BigDecimal.valueOf(100)).intValue()); // Amount
                                                                                                                     // in
                                                                                                                     // paise
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", booking.getBookingReference());

        Order order = razorpayClient.orders.create(orderRequest);

        Payment payment = new Payment();
        payment.setBooking(booking);
        payment.setAmount(booking.getTotalAmount());
        payment.setStatus(Payment.PaymentStatus.PENDING);
        payment.setMethod(Payment.PaymentMethod.RAZORPAY);
        payment.setRazorpayOrderId(order.get("id"));
        payment.setTransactionId(booking.getBookingReference());

        return paymentRepository.save(payment);
    }

    @Transactional
    public Payment verifyPayment(PaymentVerificationRequest request) throws RazorpayException {
        Payment payment = paymentRepository.findByRazorpayOrderId(request.getRazorpayOrderId())
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        // Verify signature
        JSONObject options = new JSONObject();
        options.put("razorpay_order_id", request.getRazorpayOrderId());
        options.put("razorpay_payment_id", request.getRazorpayPaymentId());
        options.put("razorpay_signature", request.getRazorpaySignature());

        boolean isValidSignature = Utils.verifyPaymentSignature(options, razorpayKeySecret);

        if (isValidSignature) {
            payment.setRazorpayPaymentId(request.getRazorpayPaymentId());
            payment.setRazorpaySignature(request.getRazorpaySignature());
            payment.setStatus(Payment.PaymentStatus.SUCCESS);
            payment.setCompletedAt(LocalDateTime.now());

            // Confirm booking
            bookingService.confirmBooking(payment.getBooking().getId());
        } else {
            payment.setStatus(Payment.PaymentStatus.FAILED);
            throw new RuntimeException("Invalid payment signature");
        }

        return paymentRepository.save(payment);
    }

    public Payment getPaymentByBookingId(Long bookingId) {
        return paymentRepository.findByBookingId(bookingId)
                .orElseThrow(() -> new RuntimeException("Payment not found for booking"));
    }

    public String getRazorpayKeyId() {
        return razorpayKeyId;
    }
}
