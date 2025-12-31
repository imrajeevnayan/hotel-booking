package com.hotelbooking.service;

import com.hotelbooking.model.Hotel;
import com.hotelbooking.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    public List<Hotel> getAllHotels() {
        return hotelRepository.findByActiveTrue();
    }

    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + id));
    }

    public List<Hotel> searchHotels(String city, BigDecimal minPrice, BigDecimal maxPrice, BigDecimal minRating) {
        return hotelRepository.searchHotels(city, minPrice, maxPrice, minRating);
    }

    public List<Hotel> getHotelsByCity(String city) {
        return hotelRepository.findByCityAndActiveTrue(city);
    }

    @Transactional
    public Hotel createHotel(Hotel hotel) {
        hotel.setActive(true);
        hotel.setAvailableRooms(hotel.getTotalRooms());
        return hotelRepository.save(hotel);
    }

    @Transactional
    public Hotel updateHotel(Long id, Hotel hotelDetails) {
        Hotel hotel = getHotelById(id);

        hotel.setName(hotelDetails.getName());
        hotel.setDescription(hotelDetails.getDescription());
        hotel.setAddress(hotelDetails.getAddress());
        hotel.setCity(hotelDetails.getCity());
        hotel.setState(hotelDetails.getState());
        hotel.setCountry(hotelDetails.getCountry());
        hotel.setZipCode(hotelDetails.getZipCode());
        hotel.setPhoneNumber(hotelDetails.getPhoneNumber());
        hotel.setEmail(hotelDetails.getEmail());
        hotel.setPricePerNight(hotelDetails.getPricePerNight());
        hotel.setAmenities(hotelDetails.getAmenities());
        hotel.setImages(hotelDetails.getImages());

        return hotelRepository.save(hotel);
    }

    @Transactional
    public void deleteHotel(Long id) {
        Hotel hotel = getHotelById(id);
        hotel.setActive(false);
        hotelRepository.save(hotel);
    }
}
