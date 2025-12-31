package com.hotelbooking.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class BookingResponse {
    private Long id;
    private Long hotelId;
    private String hotelName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Integer numberOfGuests;
    private Integer numberOfRooms;
    private BigDecimal totalAmount;
    private String status;
    private String bookingReference;
    private String specialRequests;
    private LocalDateTime createdAt;
}
