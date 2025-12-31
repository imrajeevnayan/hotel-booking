package com.hotelbooking.controller;

import com.hotelbooking.dto.PaymentRequest;
import com.hotelbooking.dto.PaymentVerificationRequest;
import com.hotelbooking.model.Payment;
import com.hotelbooking.service.PaymentService;
import com.razorpay.RazorpayException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/create-order")
    public ResponseEntity<Map<String, Object>> createPaymentOrder(@RequestBody PaymentRequest request) {
        try {
            Payment payment = paymentService.createPaymentOrder(request);

            Map<String, Object> response = new HashMap<>();
            response.put("orderId", payment.getRazorpayOrderId());
            response.put("amount", payment.getAmount());
            response.put("currency", "INR");
            response.put("keyId", paymentService.getRazorpayKeyId());

            return ResponseEntity.ok(response);
        } catch (RazorpayException e) {
            throw new RuntimeException("Error creating payment order: " + e.getMessage());
        }
    }

    @PostMapping("/verify")
    public ResponseEntity<Payment> verifyPayment(@RequestBody PaymentVerificationRequest request) {
        try {
            Payment payment = paymentService.verifyPayment(request);
            return ResponseEntity.ok(payment);
        } catch (RazorpayException e) {
            throw new RuntimeException("Error verifying payment: " + e.getMessage());
        }
    }

    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<Payment> getPaymentByBookingId(@PathVariable Long bookingId) {
        return ResponseEntity.ok(paymentService.getPaymentByBookingId(bookingId));
    }
}
