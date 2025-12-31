package com.hotelbooking.repository;

import com.hotelbooking.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByActiveTrue();

    List<Hotel> findByCityAndActiveTrue(String city);

    List<Hotel> findByStateAndActiveTrue(String state);

    @Query("SELECT h FROM Hotel h WHERE h.active = true AND " +
            "(:city IS NULL OR h.city = :city) AND " +
            "(:minPrice IS NULL OR h.pricePerNight >= :minPrice) AND " +
            "(:maxPrice IS NULL OR h.pricePerNight <= :maxPrice) AND " +
            "(:minRating IS NULL OR h.rating >= :minRating)")
    List<Hotel> searchHotels(
            @Param("city") String city,
            @Param("minPrice") BigDecimal minPrice,
            @Param("maxPrice") BigDecimal maxPrice,
            @Param("minRating") BigDecimal minRating);
}
