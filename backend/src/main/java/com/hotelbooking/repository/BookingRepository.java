package com.hotelbooking.repository;

import com.hotelbooking.model.Booking;
import com.hotelbooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserOrderByCreatedAtDesc(User user);

    List<Booking> findByUserIdOrderByCreatedAtDesc(Long userId);

    Optional<Booking> findByBookingReference(String bookingReference);

    List<Booking> findByHotelIdOrderByCreatedAtDesc(Long hotelId);
}
