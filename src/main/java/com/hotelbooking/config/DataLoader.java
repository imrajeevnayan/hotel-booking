package com.hotelbooking.config;

import com.hotelbooking.model.Hotel;
import com.hotelbooking.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

        private final HotelRepository hotelRepository;

        @Override
        public void run(String... args) throws Exception {
                if (hotelRepository.count() == 0) {
                        loadSampleHotels();
                }
        }

        private void loadSampleHotels() {
                Hotel hotel1 = new Hotel();
                hotel1.setName("Grand Plaza Hotel");
                hotel1.setDescription(
                                "Experience luxury at its finest in the heart of the city. Our Grand Plaza Hotel offers world-class amenities, stunning views, and exceptional service.");
                hotel1.setAddress("123 Main Street");
                hotel1.setCity("Mumbai");
                hotel1.setState("Maharashtra");
                hotel1.setCountry("India");
                hotel1.setZipCode("400001");
                hotel1.setPhoneNumber("+91-22-12345678");
                hotel1.setEmail("info@grandplaza.com");
                hotel1.setRating(BigDecimal.valueOf(4.5));
                hotel1.setTotalRooms(100);
                hotel1.setAvailableRooms(100);
                hotel1.setPricePerNight(BigDecimal.valueOf(5000));
                hotel1.setAmenities(Arrays.asList("WiFi", "Pool", "Gym", "Restaurant", "Spa", "Room Service"));
                hotel1.setImages(Arrays.asList(
                                "https://images.unsplash.com/photo-1566073771259-6a8506099945",
                                "https://images.unsplash.com/photo-1582719478250-c89cae4dc85b"));
                hotel1.setActive(true);

                Hotel hotel2 = new Hotel();
                hotel2.setName("Seaside Resort");
                hotel2.setDescription(
                                "Wake up to the sound of waves at our beautiful beachfront resort. Perfect for a relaxing getaway with family and friends.");
                hotel2.setAddress("456 Beach Road");
                hotel2.setCity("Goa");
                hotel2.setState("Goa");
                hotel2.setCountry("India");
                hotel2.setZipCode("403001");
                hotel2.setPhoneNumber("+91-832-1234567");
                hotel2.setEmail("info@seasideresort.com");
                hotel2.setRating(BigDecimal.valueOf(4.7));
                hotel2.setTotalRooms(75);
                hotel2.setAvailableRooms(75);
                hotel2.setPricePerNight(BigDecimal.valueOf(7500));
                hotel2.setAmenities(Arrays.asList("WiFi", "Beach Access", "Pool", "Restaurant", "Bar", "Water Sports"));
                hotel2.setImages(Arrays.asList(
                                "https://images.unsplash.com/photo-1520250497591-112f2f40a3f4",
                                "https://images.unsplash.com/photo-1571896349842-33c89424de2d"));
                hotel2.setActive(true);

                Hotel hotel3 = new Hotel();
                hotel3.setName("Mountain View Lodge");
                hotel3.setDescription(
                                "Escape to the mountains and enjoy breathtaking views, fresh air, and peaceful surroundings at our cozy lodge.");
                hotel3.setAddress("789 Hill Station Road");
                hotel3.setCity("Shimla");
                hotel3.setState("Himachal Pradesh");
                hotel3.setCountry("India");
                hotel3.setZipCode("171001");
                hotel3.setPhoneNumber("+91-177-1234567");
                hotel3.setEmail("info@mountainviewlodge.com");
                hotel3.setRating(BigDecimal.valueOf(4.3));
                hotel3.setTotalRooms(50);
                hotel3.setAvailableRooms(50);
                hotel3.setPricePerNight(BigDecimal.valueOf(4000));
                hotel3.setAmenities(Arrays.asList("WiFi", "Fireplace", "Restaurant", "Trekking", "Bonfire"));
                hotel3.setImages(Arrays.asList(
                                "https://images.unsplash.com/photo-1542314831-068cd1dbfeeb",
                                "https://images.unsplash.com/photo-1551882547-ff40c63fe5fa"));
                hotel3.setActive(true);

                Hotel hotel4 = new Hotel();
                hotel4.setName("City Center Inn");
                hotel4.setDescription(
                                "Conveniently located in the city center, perfect for business travelers and tourists alike. Modern amenities and comfortable rooms.");
                hotel4.setAddress("321 Business District");
                hotel4.setCity("Bangalore");
                hotel4.setState("Karnataka");
                hotel4.setCountry("India");
                hotel4.setZipCode("560001");
                hotel4.setPhoneNumber("+91-80-12345678");
                hotel4.setEmail("info@citycenterinn.com");
                hotel4.setRating(BigDecimal.valueOf(4.2));
                hotel4.setTotalRooms(80);
                hotel4.setAvailableRooms(80);
                hotel4.setPricePerNight(BigDecimal.valueOf(3500));
                hotel4.setAmenities(Arrays.asList("WiFi", "Conference Room", "Restaurant", "Gym", "Parking"));
                hotel4.setImages(Arrays.asList(
                                "https://images.unsplash.com/photo-1564501049412-61c2a3083791",
                                "https://images.unsplash.com/photo-1596436889106-be35e843f974"));
                hotel4.setActive(true);

                Hotel hotel5 = new Hotel();
                hotel5.setName("Heritage Palace Hotel");
                hotel5.setDescription(
                                "Step back in time at our magnificent heritage palace. Experience royal hospitality with modern comforts in a historic setting.");
                hotel5.setAddress("15 Palace Road");
                hotel5.setCity("Jaipur");
                hotel5.setState("Rajasthan");
                hotel5.setCountry("India");
                hotel5.setZipCode("302001");
                hotel5.setPhoneNumber("+91-141-1234567");
                hotel5.setEmail("info@heritagepalace.com");
                hotel5.setRating(BigDecimal.valueOf(4.8));
                hotel5.setTotalRooms(60);
                hotel5.setAvailableRooms(60);
                hotel5.setPricePerNight(BigDecimal.valueOf(8500));
                hotel5.setAmenities(Arrays.asList("WiFi", "Heritage Tours", "Royal Dining", "Spa", "Cultural Shows",
                                "Pool"));
                hotel5.setImages(Arrays.asList(
                                "https://images.unsplash.com/photo-1618773928121-c32242e63f39",
                                "https://images.unsplash.com/photo-1551882547-ff40c63fe5fa"));
                hotel5.setActive(true);

                Hotel hotel6 = new Hotel();
                hotel6.setName("Riverside Retreat");
                hotel6.setDescription(
                                "Peaceful riverside location perfect for nature lovers. Enjoy serene views, bird watching, and tranquil surroundings.");
                hotel6.setAddress("88 River Bank Road");
                hotel6.setCity("Rishikesh");
                hotel6.setState("Uttarakhand");
                hotel6.setCountry("India");
                hotel6.setZipCode("249201");
                hotel6.setPhoneNumber("+91-135-1234567");
                hotel6.setEmail("info@riversideretreat.com");
                hotel6.setRating(BigDecimal.valueOf(4.4));
                hotel6.setTotalRooms(40);
                hotel6.setAvailableRooms(40);
                hotel6.setPricePerNight(BigDecimal.valueOf(3000));
                hotel6.setAmenities(Arrays.asList("WiFi", "Yoga Classes", "Meditation", "River View",
                                "Organic Restaurant", "Bonfire"));
                hotel6.setImages(Arrays.asList(
                                "https://images.unsplash.com/photo-1571003123894-1f0594d2b5d9",
                                "https://images.unsplash.com/photo-1566073771259-6a8506099945"));
                hotel6.setActive(true);

                Hotel hotel7 = new Hotel();
                hotel7.setName("Metropolitan Luxury Suites");
                hotel7.setDescription(
                                "Ultra-modern luxury suites in the heart of the capital. Premium amenities, rooftop dining, and impeccable service.");
                hotel7.setAddress("42 Connaught Place");
                hotel7.setCity("New Delhi");
                hotel7.setState("Delhi");
                hotel7.setCountry("India");
                hotel7.setZipCode("110001");
                hotel7.setPhoneNumber("+91-11-12345678");
                hotel7.setEmail("info@metropolitanluxury.com");
                hotel7.setRating(BigDecimal.valueOf(4.9));
                hotel7.setTotalRooms(120);
                hotel7.setAvailableRooms(120);
                hotel7.setPricePerNight(BigDecimal.valueOf(12000));
                hotel7.setAmenities(Arrays.asList("WiFi", "Rooftop Bar", "Infinity Pool", "Spa", "Fine Dining",
                                "Concierge", "Valet Parking"));
                hotel7.setImages(Arrays.asList(
                                "https://images.unsplash.com/photo-1582719478250-c89cae4dc85b",
                                "https://images.unsplash.com/photo-1542314831-068cd1dbfeeb"));
                hotel7.setActive(true);

                Hotel hotel8 = new Hotel();
                hotel8.setName("Backpacker's Haven");
                hotel8.setDescription(
                                "Budget-friendly accommodation for backpackers and solo travelers. Clean, safe, and social atmosphere with all basic amenities.");
                hotel8.setAddress("67 Travelers Lane");
                hotel8.setCity("Manali");
                hotel8.setState("Himachal Pradesh");
                hotel8.setCountry("India");
                hotel8.setZipCode("175131");
                hotel8.setPhoneNumber("+91-190-1234567");
                hotel8.setEmail("info@backpackershaven.com");
                hotel8.setRating(BigDecimal.valueOf(4.0));
                hotel8.setTotalRooms(30);
                hotel8.setAvailableRooms(30);
                hotel8.setPricePerNight(BigDecimal.valueOf(1500));
                hotel8.setAmenities(
                                Arrays.asList("WiFi", "Common Kitchen", "Lounge", "Laundry", "Travel Desk", "Bonfire"));
                hotel8.setImages(Arrays.asList(
                                "https://images.unsplash.com/photo-1555854877-bab0e564b8d5",
                                "https://images.unsplash.com/photo-1520250497591-112f2f40a3f4"));
                hotel8.setActive(true);

                Hotel hotel9 = new Hotel();
                hotel9.setName("Lake View Resort & Spa");
                hotel9.setDescription(
                                "Romantic lakeside resort perfect for couples and honeymooners. Stunning sunset views, private balconies, and world-class spa.");
                hotel9.setAddress("23 Lake Palace Road");
                hotel9.setCity("Udaipur");
                hotel9.setState("Rajasthan");
                hotel9.setCountry("India");
                hotel9.setZipCode("313001");
                hotel9.setPhoneNumber("+91-294-1234567");
                hotel9.setEmail("info@lakeviewresort.com");
                hotel9.setRating(BigDecimal.valueOf(4.7));
                hotel9.setTotalRooms(55);
                hotel9.setAvailableRooms(55);
                hotel9.setPricePerNight(BigDecimal.valueOf(9500));
                hotel9.setAmenities(Arrays.asList("WiFi", "Lake View", "Spa", "Candlelight Dining", "Boat Rides",
                                "Pool", "Room Service"));
                hotel9.setImages(Arrays.asList(
                                "https://images.unsplash.com/photo-1571896349842-33c89424de2d",
                                "https://images.unsplash.com/photo-1596436889106-be35e843f974"));
                hotel9.setActive(true);

                Hotel hotel10 = new Hotel();
                hotel10.setName("Business Express Hotel");
                hotel10.setDescription(
                                "Efficient and comfortable hotel designed for business travelers. Fast WiFi, work desks, and meeting facilities.");
                hotel10.setAddress("156 IT Park Road");
                hotel10.setCity("Pune");
                hotel10.setState("Maharashtra");
                hotel10.setCountry("India");
                hotel10.setZipCode("411001");
                hotel10.setPhoneNumber("+91-20-12345678");
                hotel10.setEmail("info@businessexpress.com");
                hotel10.setRating(BigDecimal.valueOf(4.1));
                hotel10.setTotalRooms(90);
                hotel10.setAvailableRooms(90);
                hotel10.setPricePerNight(BigDecimal.valueOf(3200));
                hotel10.setAmenities(Arrays.asList("WiFi", "Business Center", "Meeting Rooms", "Coffee Shop", "Gym",
                                "Airport Shuttle"));
                hotel10.setImages(Arrays.asList(
                                "https://images.unsplash.com/photo-1564501049412-61c2a3083791",
                                "https://images.unsplash.com/photo-1566073771259-6a8506099945"));
                hotel10.setActive(true);

                Hotel hotel11 = new Hotel();
                hotel11.setName("Tropical Paradise Resort");
                hotel11.setDescription(
                                "Exotic tropical resort surrounded by lush greenery and backwaters. Experience authentic Kerala hospitality and cuisine.");
                hotel11.setAddress("99 Backwater Road");
                hotel11.setCity("Alleppey");
                hotel11.setState("Kerala");
                hotel11.setCountry("India");
                hotel11.setZipCode("688001");
                hotel11.setPhoneNumber("+91-477-1234567");
                hotel11.setEmail("info@tropicalparadise.com");
                hotel11.setRating(BigDecimal.valueOf(4.6));
                hotel11.setTotalRooms(45);
                hotel11.setAvailableRooms(45);
                hotel11.setPricePerNight(BigDecimal.valueOf(6500));
                hotel11.setAmenities(Arrays.asList("WiFi", "Backwater View", "Ayurvedic Spa", "Kerala Cuisine",
                                "Houseboat Tours", "Pool"));
                hotel11.setImages(Arrays.asList(
                                "https://images.unsplash.com/photo-1520250497591-112f2f40a3f4",
                                "https://images.unsplash.com/photo-1571003123894-1f0594d2b5d9"));
                hotel11.setActive(true);

                Hotel hotel12 = new Hotel();
                hotel12.setName("Historic Taj View Hotel");
                hotel12.setDescription(
                                "Wake up to views of the magnificent Taj Mahal. Premium location with rooftop restaurant offering stunning monument views.");
                hotel12.setAddress("12 Taj East Gate Road");
                hotel12.setCity("Agra");
                hotel12.setState("Uttar Pradesh");
                hotel12.setCountry("India");
                hotel12.setZipCode("282001");
                hotel12.setPhoneNumber("+91-562-1234567");
                hotel12.setEmail("info@tajviewhotel.com");
                hotel12.setRating(BigDecimal.valueOf(4.5));
                hotel12.setTotalRooms(70);
                hotel12.setAvailableRooms(70);
                hotel12.setPricePerNight(BigDecimal.valueOf(7000));
                hotel12.setAmenities(Arrays.asList("WiFi", "Taj View", "Rooftop Restaurant", "Tour Desk",
                                "Cultural Programs", "Pool"));
                hotel12.setImages(Arrays.asList(
                                "https://images.unsplash.com/photo-1618773928121-c32242e63f39",
                                "https://images.unsplash.com/photo-1582719478250-c89cae4dc85b"));
                hotel12.setActive(true);

                Hotel hotel13 = new Hotel();
                hotel13.setName("Ocean Breeze Resort");
                hotel13.setDescription(
                                "Beachfront luxury resort with private beach access, water sports, and sunset views.");
                hotel13.setAddress("45 Marine Drive");
                hotel13.setCity("Visakhapatnam");
                hotel13.setState("Andhra Pradesh");
                hotel13.setCountry("India");
                hotel13.setZipCode("530001");
                hotel13.setPhoneNumber("+91-891-1234567");
                hotel13.setEmail("info@oceanbreeze.com");
                hotel13.setRating(BigDecimal.valueOf(4.6));
                hotel13.setTotalRooms(85);
                hotel13.setAvailableRooms(85);
                hotel13.setPricePerNight(BigDecimal.valueOf(6800));
                hotel13.setAmenities(
                                Arrays.asList("WiFi", "Private Beach", "Water Sports", "Pool", "Spa", "Restaurant"));
                hotel13.setImages(Arrays.asList("https://images.unsplash.com/photo-1520250497591-112f2f40a3f4",
                                "https://images.unsplash.com/photo-1571896349842-33c89424de2d"));
                hotel13.setActive(true);

                Hotel hotel14 = new Hotel();
                hotel14.setName("Royal Heritage Haveli");
                hotel14.setDescription(
                                "Traditional Rajasthani haveli converted into a boutique hotel with authentic decor.");
                hotel14.setAddress("78 Old City Road");
                hotel14.setCity("Jodhpur");
                hotel14.setState("Rajasthan");
                hotel14.setCountry("India");
                hotel14.setZipCode("342001");
                hotel14.setPhoneNumber("+91-291-1234567");
                hotel14.setEmail("info@royalhaveli.com");
                hotel14.setRating(BigDecimal.valueOf(4.4));
                hotel14.setTotalRooms(25);
                hotel14.setAvailableRooms(25);
                hotel14.setPricePerNight(BigDecimal.valueOf(5500));
                hotel14.setAmenities(Arrays.asList("WiFi", "Heritage Tours", "Traditional Cuisine", "Rooftop Dining",
                                "Cultural Shows"));
                hotel14.setImages(Arrays.asList("https://images.unsplash.com/photo-1618773928121-c32242e63f39",
                                "https://images.unsplash.com/photo-1551882547-ff40c63fe5fa"));
                hotel14.setActive(true);

                Hotel hotel15 = new Hotel();
                hotel15.setName("Tech Park Suites");
                hotel15.setDescription(
                                "Modern hotel near IT parks, perfect for tech professionals and business travelers.");
                hotel15.setAddress("234 Cyber City");
                hotel15.setCity("Hyderabad");
                hotel15.setState("Telangana");
                hotel15.setCountry("India");
                hotel15.setZipCode("500081");
                hotel15.setPhoneNumber("+91-40-12345678");
                hotel15.setEmail("info@techparksuites.com");
                hotel15.setRating(BigDecimal.valueOf(4.2));
                hotel15.setTotalRooms(110);
                hotel15.setAvailableRooms(110);
                hotel15.setPricePerNight(BigDecimal.valueOf(3800));
                hotel15.setAmenities(Arrays.asList("WiFi", "Co-working Space", "Gym", "Restaurant", "Conference Rooms",
                                "Parking"));
                hotel15.setImages(Arrays.asList("https://images.unsplash.com/photo-1564501049412-61c2a3083791",
                                "https://images.unsplash.com/photo-1582719478250-c89cae4dc85b"));
                hotel15.setActive(true);

                Hotel hotel16 = new Hotel();
                hotel16.setName("Garden Paradise Hotel");
                hotel16.setDescription("Lush garden hotel with botanical tours, perfect for nature enthusiasts.");
                hotel16.setAddress("56 Botanical Garden Road");
                hotel16.setCity("Ooty");
                hotel16.setState("Tamil Nadu");
                hotel16.setCountry("India");
                hotel16.setZipCode("643001");
                hotel16.setPhoneNumber("+91-423-1234567");
                hotel16.setEmail("info@gardenparadise.com");
                hotel16.setRating(BigDecimal.valueOf(4.3));
                hotel16.setTotalRooms(40);
                hotel16.setAvailableRooms(40);
                hotel16.setPricePerNight(BigDecimal.valueOf(4200));
                hotel16.setAmenities(Arrays.asList("WiFi", "Garden Tours", "Nature Walks", "Restaurant", "Bonfire",
                                "Library"));
                hotel16.setImages(Arrays.asList("https://images.unsplash.com/photo-1571003123894-1f0594d2b5d9",
                                "https://images.unsplash.com/photo-1566073771259-6a8506099945"));
                hotel16.setActive(true);

                Hotel hotel17 = new Hotel();
                hotel17.setName("Downtown Budget Inn");
                hotel17.setDescription("Affordable accommodation in the city center with basic amenities.");
                hotel17.setAddress("89 Central Market");
                hotel17.setCity("Lucknow");
                hotel17.setState("Uttar Pradesh");
                hotel17.setCountry("India");
                hotel17.setZipCode("226001");
                hotel17.setPhoneNumber("+91-522-1234567");
                hotel17.setEmail("info@downtowninn.com");
                hotel17.setRating(BigDecimal.valueOf(3.8));
                hotel17.setTotalRooms(50);
                hotel17.setAvailableRooms(50);
                hotel17.setPricePerNight(BigDecimal.valueOf(1800));
                hotel17.setAmenities(Arrays.asList("WiFi", "Restaurant", "Room Service", "Parking"));
                hotel17.setImages(Arrays.asList("https://images.unsplash.com/photo-1555854877-bab0e564b8d5",
                                "https://images.unsplash.com/photo-1520250497591-112f2f40a3f4"));
                hotel17.setActive(true);

                Hotel hotel18 = new Hotel();
                hotel18.setName("Luxury Palace Resort");
                hotel18.setDescription(
                                "Ultra-luxury resort with private villas, butler service, and world-class amenities.");
                hotel18.setAddress("1 Palace Avenue");
                hotel18.setCity("Jaisalmer");
                hotel18.setState("Rajasthan");
                hotel18.setCountry("India");
                hotel18.setZipCode("345001");
                hotel18.setPhoneNumber("+91-299-1234567");
                hotel18.setEmail("info@luxurypalace.com");
                hotel18.setRating(BigDecimal.valueOf(5.0));
                hotel18.setTotalRooms(35);
                hotel18.setAvailableRooms(35);
                hotel18.setPricePerNight(BigDecimal.valueOf(18000));
                hotel18.setAmenities(Arrays.asList("WiFi", "Private Villas", "Butler Service", "Spa", "Fine Dining",
                                "Desert Safari", "Pool"));
                hotel18.setImages(Arrays.asList("https://images.unsplash.com/photo-1618773928121-c32242e63f39",
                                "https://images.unsplash.com/photo-1582719478250-c89cae4dc85b"));
                hotel18.setActive(true);

                Hotel hotel19 = new Hotel();
                hotel19.setName("Airport Transit Hotel");
                hotel19.setDescription(
                                "Convenient hotel near airport, perfect for transit passengers and early flights.");
                hotel19.setAddress("Airport Road Terminal 3");
                hotel19.setCity("Mumbai");
                hotel19.setState("Maharashtra");
                hotel19.setCountry("India");
                hotel19.setZipCode("400099");
                hotel19.setPhoneNumber("+91-22-98765432");
                hotel19.setEmail("info@airporttransit.com");
                hotel19.setRating(BigDecimal.valueOf(4.0));
                hotel19.setTotalRooms(95);
                hotel19.setAvailableRooms(95);
                hotel19.setPricePerNight(BigDecimal.valueOf(4500));
                hotel19.setAmenities(Arrays.asList("WiFi", "24/7 Check-in", "Airport Shuttle", "Restaurant", "Gym"));
                hotel19.setImages(Arrays.asList("https://images.unsplash.com/photo-1564501049412-61c2a3083791",
                                "https://images.unsplash.com/photo-1566073771259-6a8506099945"));
                hotel19.setActive(true);

                Hotel hotel20 = new Hotel();
                hotel20.setName("Wellness Retreat Spa");
                hotel20.setDescription("Holistic wellness resort with yoga, meditation, Ayurveda, and detox programs.");
                hotel20.setAddress("12 Wellness Valley");
                hotel20.setCity("Coorg");
                hotel20.setState("Karnataka");
                hotel20.setCountry("India");
                hotel20.setZipCode("571201");
                hotel20.setPhoneNumber("+91-827-1234567");
                hotel20.setEmail("info@wellnessretreat.com");
                hotel20.setRating(BigDecimal.valueOf(4.7));
                hotel20.setTotalRooms(30);
                hotel20.setAvailableRooms(30);
                hotel20.setPricePerNight(BigDecimal.valueOf(8500));
                hotel20.setAmenities(Arrays.asList("WiFi", "Yoga", "Meditation", "Ayurvedic Spa", "Organic Food",
                                "Nature Walks"));
                hotel20.setImages(Arrays.asList("https://images.unsplash.com/photo-1571003123894-1f0594d2b5d9",
                                "https://images.unsplash.com/photo-1520250497591-112f2f40a3f4"));
                hotel20.setActive(true);

                Hotel hotel21 = new Hotel();
                hotel21.setName("Family Fun Resort");
                hotel21.setDescription(
                                "Family-friendly resort with kids club, water park, and entertainment activities.");
                hotel21.setAddress("99 Family Lane");
                hotel21.setCity("Lonavala");
                hotel21.setState("Maharashtra");
                hotel21.setCountry("India");
                hotel21.setZipCode("410401");
                hotel21.setPhoneNumber("+91-214-1234567");
                hotel21.setEmail("info@familyfun.com");
                hotel21.setRating(BigDecimal.valueOf(4.4));
                hotel21.setTotalRooms(100);
                hotel21.setAvailableRooms(100);
                hotel21.setPricePerNight(BigDecimal.valueOf(5500));
                hotel21.setAmenities(
                                Arrays.asList("WiFi", "Kids Club", "Water Park", "Game Room", "Restaurant", "Pool"));
                hotel21.setImages(Arrays.asList("https://images.unsplash.com/photo-1571896349842-33c89424de2d",
                                "https://images.unsplash.com/photo-1596436889106-be35e843f974"));
                hotel21.setActive(true);

                Hotel hotel22 = new Hotel();
                hotel22.setName("Boutique Art Hotel");
                hotel22.setDescription(
                                "Artistic boutique hotel featuring local art, galleries, and creative workshops.");
                hotel22.setAddress("34 Art District");
                hotel22.setCity("Kochi");
                hotel22.setState("Kerala");
                hotel22.setCountry("India");
                hotel22.setZipCode("682001");
                hotel22.setPhoneNumber("+91-484-1234567");
                hotel22.setEmail("info@boutiqueart.com");
                hotel22.setRating(BigDecimal.valueOf(4.5));
                hotel22.setTotalRooms(20);
                hotel22.setAvailableRooms(20);
                hotel22.setPricePerNight(BigDecimal.valueOf(6000));
                hotel22.setAmenities(Arrays.asList("WiFi", "Art Gallery", "Workshops", "Cafe", "Library", "Rooftop"));
                hotel22.setImages(Arrays.asList("https://images.unsplash.com/photo-1555854877-bab0e564b8d5",
                                "https://images.unsplash.com/photo-1582719478250-c89cae4dc85b"));
                hotel22.setActive(true);

                Hotel hotel23 = new Hotel();
                hotel23.setName("Eco Lodge Retreat");
                hotel23.setDescription(
                                "Sustainable eco-lodge with solar power, rainwater harvesting, and organic farming.");
                hotel23.setAddress("67 Green Valley");
                hotel23.setCity("Wayanad");
                hotel23.setState("Kerala");
                hotel23.setCountry("India");
                hotel23.setZipCode("673121");
                hotel23.setPhoneNumber("+91-493-1234567");
                hotel23.setEmail("info@ecolodge.com");
                hotel23.setRating(BigDecimal.valueOf(4.6));
                hotel23.setTotalRooms(18);
                hotel23.setAvailableRooms(18);
                hotel23.setPricePerNight(BigDecimal.valueOf(4800));
                hotel23.setAmenities(Arrays.asList("WiFi", "Organic Farm", "Nature Trails", "Bird Watching",
                                "Eco Tours", "Bonfire"));
                hotel23.setImages(Arrays.asList("https://images.unsplash.com/photo-1571003123894-1f0594d2b5d9",
                                "https://images.unsplash.com/photo-1566073771259-6a8506099945"));
                hotel23.setActive(true);

                Hotel hotel24 = new Hotel();
                hotel24.setName("Casino Luxury Hotel");
                hotel24.setDescription("Upscale hotel with casino, nightclub, and entertainment shows.");
                hotel24.setAddress("88 Entertainment Boulevard");
                hotel24.setCity("Goa");
                hotel24.setState("Goa");
                hotel24.setCountry("India");
                hotel24.setZipCode("403516");
                hotel24.setPhoneNumber("+91-832-9876543");
                hotel24.setEmail("info@casinoluxury.com");
                hotel24.setRating(BigDecimal.valueOf(4.3));
                hotel24.setTotalRooms(150);
                hotel24.setAvailableRooms(150);
                hotel24.setPricePerNight(BigDecimal.valueOf(9500));
                hotel24.setAmenities(
                                Arrays.asList("WiFi", "Casino", "Nightclub", "Pool", "Spa", "Fine Dining", "Shows"));
                hotel24.setImages(Arrays.asList("https://images.unsplash.com/photo-1520250497591-112f2f40a3f4",
                                "https://images.unsplash.com/photo-1571896349842-33c89424de2d"));
                hotel24.setActive(true);

                Hotel hotel25 = new Hotel();
                hotel25.setName("Pilgrimage Rest House");
                hotel25.setDescription("Simple and clean accommodation for pilgrims visiting holy sites.");
                hotel25.setAddress("23 Temple Street");
                hotel25.setCity("Varanasi");
                hotel25.setState("Uttar Pradesh");
                hotel25.setCountry("India");
                hotel25.setZipCode("221001");
                hotel25.setPhoneNumber("+91-542-1234567");
                hotel25.setEmail("info@pilgrimagerest.com");
                hotel25.setRating(BigDecimal.valueOf(3.9));
                hotel25.setTotalRooms(60);
                hotel25.setAvailableRooms(60);
                hotel25.setPricePerNight(BigDecimal.valueOf(1200));
                hotel25.setAmenities(
                                Arrays.asList("WiFi", "Prayer Room", "Simple Meals", "Ganga View", "Tour Assistance"));
                hotel25.setImages(Arrays.asList("https://images.unsplash.com/photo-1555854877-bab0e564b8d5",
                                "https://images.unsplash.com/photo-1520250497591-112f2f40a3f4"));
                hotel25.setActive(true);

                Hotel hotel26 = new Hotel();
                hotel26.setName("Adventure Base Camp");
                hotel26.setDescription("Base camp for trekkers and adventure enthusiasts with gear rental and guides.");
                hotel26.setAddress("45 Mountain Base");
                hotel26.setCity("Leh");
                hotel26.setState("Ladakh");
                hotel26.setCountry("India");
                hotel26.setZipCode("194101");
                hotel26.setPhoneNumber("+91-198-1234567");
                hotel26.setEmail("info@adventurebase.com");
                hotel26.setRating(BigDecimal.valueOf(4.2));
                hotel26.setTotalRooms(25);
                hotel26.setAvailableRooms(25);
                hotel26.setPricePerNight(BigDecimal.valueOf(3500));
                hotel26.setAmenities(Arrays.asList("WiFi", "Gear Rental", "Trekking Guides", "Camping", "Bonfire",
                                "Restaurant"));
                hotel26.setImages(Arrays.asList("https://images.unsplash.com/photo-1542314831-068cd1dbfeeb",
                                "https://images.unsplash.com/photo-1551882547-ff40c63fe5fa"));
                hotel26.setActive(true);

                Hotel hotel27 = new Hotel();
                hotel27.setName("Golf Resort & Spa");
                hotel27.setDescription("Premium golf resort with championship course, spa, and luxury accommodations.");
                hotel27.setAddress("1 Golf Course Road");
                hotel27.setCity("Bengaluru");
                hotel27.setState("Karnataka");
                hotel27.setCountry("India");
                hotel27.setZipCode("560071");
                hotel27.setPhoneNumber("+91-80-98765432");
                hotel27.setEmail("info@golfresort.com");
                hotel27.setRating(BigDecimal.valueOf(4.8));
                hotel27.setTotalRooms(80);
                hotel27.setAvailableRooms(80);
                hotel27.setPricePerNight(BigDecimal.valueOf(11000));
                hotel27.setAmenities(Arrays.asList("WiFi", "Golf Course", "Spa", "Fine Dining", "Pool", "Gym",
                                "Club House"));
                hotel27.setImages(Arrays.asList("https://images.unsplash.com/photo-1566073771259-6a8506099945",
                                "https://images.unsplash.com/photo-1582719478250-c89cae4dc85b"));
                hotel27.setActive(true);

                Hotel hotel28 = new Hotel();
                hotel28.setName("Riverside Camping Resort");
                hotel28.setDescription("Unique camping experience with luxury tents by the riverside.");
                hotel28.setAddress("78 River Camp Road");
                hotel28.setCity("Rishikesh");
                hotel28.setState("Uttarakhand");
                hotel28.setCountry("India");
                hotel28.setZipCode("249304");
                hotel28.setPhoneNumber("+91-135-9876543");
                hotel28.setEmail("info@riversidecamp.com");
                hotel28.setRating(BigDecimal.valueOf(4.1));
                hotel28.setTotalRooms(35);
                hotel28.setAvailableRooms(35);
                hotel28.setPricePerNight(BigDecimal.valueOf(2800));
                hotel28.setAmenities(
                                Arrays.asList("WiFi", "Luxury Tents", "Rafting", "Bonfire", "BBQ", "Adventure Sports"));
                hotel28.setImages(Arrays.asList("https://images.unsplash.com/photo-1571003123894-1f0594d2b5d9",
                                "https://images.unsplash.com/photo-1520250497591-112f2f40a3f4"));
                hotel28.setActive(true);

                Hotel hotel29 = new Hotel();
                hotel29.setName("Colonial Heritage Hotel");
                hotel29.setDescription("Restored colonial-era building with vintage charm and modern amenities.");
                hotel29.setAddress("56 Heritage Lane");
                hotel29.setCity("Kolkata");
                hotel29.setState("West Bengal");
                hotel29.setCountry("India");
                hotel29.setZipCode("700001");
                hotel29.setPhoneNumber("+91-33-12345678");
                hotel29.setEmail("info@colonialheritage.com");
                hotel29.setRating(BigDecimal.valueOf(4.4));
                hotel29.setTotalRooms(45);
                hotel29.setAvailableRooms(45);
                hotel29.setPricePerNight(BigDecimal.valueOf(5200));
                hotel29.setAmenities(Arrays.asList("WiFi", "Heritage Tours", "Library", "Restaurant", "Bar", "Garden"));
                hotel29.setImages(Arrays.asList("https://images.unsplash.com/photo-1618773928121-c32242e63f39",
                                "https://images.unsplash.com/photo-1564501049412-61c2a3083791"));
                hotel29.setActive(true);

                Hotel hotel30 = new Hotel();
                hotel30.setName("Beach Shack Resort");
                hotel30.setDescription("Casual beachfront resort with shacks, water sports, and beach parties.");
                hotel30.setAddress("123 Beach Shack Lane");
                hotel30.setCity("Goa");
                hotel30.setState("Goa");
                hotel30.setCountry("India");
                hotel30.setZipCode("403101");
                hotel30.setPhoneNumber("+91-832-7654321");
                hotel30.setEmail("info@beachshack.com");
                hotel30.setRating(BigDecimal.valueOf(4.0));
                hotel30.setTotalRooms(40);
                hotel30.setAvailableRooms(40);
                hotel30.setPricePerNight(BigDecimal.valueOf(3200));
                hotel30.setAmenities(Arrays.asList("WiFi", "Beach Access", "Water Sports", "Beach Parties",
                                "Restaurant", "Bar"));
                hotel30.setImages(Arrays.asList("https://images.unsplash.com/photo-1520250497591-112f2f40a3f4",
                                "https://images.unsplash.com/photo-1571896349842-33c89424de2d"));
                hotel30.setActive(true);

                Hotel hotel31 = new Hotel();
                hotel31.setName("Snow Peak Lodge");
                hotel31.setDescription("Cozy mountain lodge with skiing, snowboarding, and winter sports facilities.");
                hotel31.setAddress("89 Snow Valley");
                hotel31.setCity("Gulmarg");
                hotel31.setState("Jammu and Kashmir");
                hotel31.setCountry("India");
                hotel31.setZipCode("193403");
                hotel31.setPhoneNumber("+91-194-1234567");
                hotel31.setEmail("info@snowpeak.com");
                hotel31.setRating(BigDecimal.valueOf(4.5));
                hotel31.setTotalRooms(50);
                hotel31.setAvailableRooms(50);
                hotel31.setPricePerNight(BigDecimal.valueOf(7500));
                hotel31.setAmenities(Arrays.asList("WiFi", "Ski Equipment", "Fireplace", "Restaurant", "Hot Tub",
                                "Mountain View"));
                hotel31.setImages(Arrays.asList("https://images.unsplash.com/photo-1542314831-068cd1dbfeeb",
                                "https://images.unsplash.com/photo-1551882547-ff40c63fe5fa"));
                hotel31.setActive(true);

                Hotel hotel32 = new Hotel();
                hotel32.setName("Urban Hostel Hub");
                hotel32.setDescription("Modern hostel with dorms and private rooms, perfect for budget travelers.");
                hotel32.setAddress("234 Backpacker Street");
                hotel32.setCity("Delhi");
                hotel32.setState("Delhi");
                hotel32.setCountry("India");
                hotel32.setZipCode("110016");
                hotel32.setPhoneNumber("+91-11-87654321");
                hotel32.setEmail("info@urbanhostel.com");
                hotel32.setRating(BigDecimal.valueOf(4.1));
                hotel32.setTotalRooms(50);
                hotel32.setAvailableRooms(50);
                hotel32.setPricePerNight(BigDecimal.valueOf(800));
                hotel32.setAmenities(Arrays.asList("WiFi", "Common Kitchen", "Lounge", "Laundry", "Tours", "Cafe"));
                hotel32.setImages(Arrays.asList("https://images.unsplash.com/photo-1555854877-bab0e564b8d5",
                                "https://images.unsplash.com/photo-1520250497591-112f2f40a3f4"));
                hotel32.setActive(true);

                Hotel hotel33 = new Hotel();
                hotel33.setName("Vineyard Estate Hotel");
                hotel33.setDescription("Boutique hotel in a vineyard with wine tasting and gourmet dining.");
                hotel33.setAddress("12 Vineyard Road");
                hotel33.setCity("Nashik");
                hotel33.setState("Maharashtra");
                hotel33.setCountry("India");
                hotel33.setZipCode("422001");
                hotel33.setPhoneNumber("+91-253-1234567");
                hotel33.setEmail("info@vineyardestate.com");
                hotel33.setRating(BigDecimal.valueOf(4.7));
                hotel33.setTotalRooms(28);
                hotel33.setAvailableRooms(28);
                hotel33.setPricePerNight(BigDecimal.valueOf(8800));
                hotel33.setAmenities(Arrays.asList("WiFi", "Wine Tasting", "Vineyard Tours", "Gourmet Restaurant",
                                "Pool", "Spa"));
                hotel33.setImages(Arrays.asList("https://images.unsplash.com/photo-1571896349842-33c89424de2d",
                                "https://images.unsplash.com/photo-1596436889106-be35e843f974"));
                hotel33.setActive(true);

                Hotel hotel34 = new Hotel();
                hotel34.setName("Fort View Heritage");
                hotel34.setDescription(
                                "Historic hotel with views of ancient fort, cultural programs, and traditional cuisine.");
                hotel34.setAddress("45 Fort Road");
                hotel34.setCity("Jhansi");
                hotel34.setState("Uttar Pradesh");
                hotel34.setCountry("India");
                hotel34.setZipCode("284001");
                hotel34.setPhoneNumber("+91-510-1234567");
                hotel34.setEmail("info@fortview.com");
                hotel34.setRating(BigDecimal.valueOf(4.2));
                hotel34.setTotalRooms(35);
                hotel34.setAvailableRooms(35);
                hotel34.setPricePerNight(BigDecimal.valueOf(3600));
                hotel34.setAmenities(Arrays.asList("WiFi", "Fort View", "Cultural Shows", "Traditional Dining",
                                "Museum", "Garden"));
                hotel34.setImages(Arrays.asList("https://images.unsplash.com/photo-1618773928121-c32242e63f39",
                                "https://images.unsplash.com/photo-1582719478250-c89cae4dc85b"));
                hotel34.setActive(true);

                Hotel hotel35 = new Hotel();
                hotel35.setName("Marina Bay Hotel");
                hotel35.setDescription("Modern hotel overlooking marina with yacht club and seafood restaurants.");
                hotel35.setAddress("67 Marina Road");
                hotel35.setCity("Chennai");
                hotel35.setState("Tamil Nadu");
                hotel35.setCountry("India");
                hotel35.setZipCode("600001");
                hotel35.setPhoneNumber("+91-44-12345678");
                hotel35.setEmail("info@marinabay.com");
                hotel35.setRating(BigDecimal.valueOf(4.5));
                hotel35.setTotalRooms(95);
                hotel35.setAvailableRooms(95);
                hotel35.setPricePerNight(BigDecimal.valueOf(6200));
                hotel35.setAmenities(Arrays.asList("WiFi", "Marina View", "Yacht Club", "Seafood Restaurant", "Pool",
                                "Gym"));
                hotel35.setImages(Arrays.asList("https://images.unsplash.com/photo-1566073771259-6a8506099945",
                                "https://images.unsplash.com/photo-1564501049412-61c2a3083791"));
                hotel35.setActive(true);

                Hotel hotel36 = new Hotel();
                hotel36.setName("Spiritual Ashram Stay");
                hotel36.setDescription("Peaceful ashram accommodation with meditation, yoga, and spiritual teachings.");
                hotel36.setAddress("89 Ashram Road");
                hotel36.setCity("Haridwar");
                hotel36.setState("Uttarakhand");
                hotel36.setCountry("India");
                hotel36.setZipCode("249401");
                hotel36.setPhoneNumber("+91-133-1234567");
                hotel36.setEmail("info@ashramstay.com");
                hotel36.setRating(BigDecimal.valueOf(4.3));
                hotel36.setTotalRooms(40);
                hotel36.setAvailableRooms(40);
                hotel36.setPricePerNight(BigDecimal.valueOf(1500));
                hotel36.setAmenities(Arrays.asList("WiFi", "Meditation", "Yoga", "Spiritual Classes", "Simple Meals",
                                "Ganga Aarti"));
                hotel36.setImages(Arrays.asList("https://images.unsplash.com/photo-1571003123894-1f0594d2b5d9",
                                "https://images.unsplash.com/photo-1520250497591-112f2f40a3f4"));
                hotel36.setActive(true);

                Hotel hotel37 = new Hotel();
                hotel37.setName("Luxury Houseboat Hotel");
                hotel37.setDescription("Unique floating hotel experience on traditional Kerala houseboats.");
                hotel37.setAddress("12 Backwater Point");
                hotel37.setCity("Kumarakom");
                hotel37.setState("Kerala");
                hotel37.setCountry("India");
                hotel37.setZipCode("686563");
                hotel37.setPhoneNumber("+91-481-1234567");
                hotel37.setEmail("info@houseboathotel.com");
                hotel37.setRating(BigDecimal.valueOf(4.8));
                hotel37.setTotalRooms(15);
                hotel37.setAvailableRooms(15);
                hotel37.setPricePerNight(BigDecimal.valueOf(12500));
                hotel37.setAmenities(Arrays.asList("WiFi", "Private Houseboat", "Chef Service", "Backwater Cruise",
                                "Fishing", "Sunset Views"));
                hotel37.setImages(Arrays.asList("https://images.unsplash.com/photo-1520250497591-112f2f40a3f4",
                                "https://images.unsplash.com/photo-1571896349842-33c89424de2d"));
                hotel37.setActive(true);

                Hotel hotel38 = new Hotel();
                hotel38.setName("Railway Station Lodge");
                hotel38.setDescription("Convenient budget hotel near railway station for transit travelers.");
                hotel38.setAddress("Station Road");
                hotel38.setCity("Jaipur");
                hotel38.setState("Rajasthan");
                hotel38.setCountry("India");
                hotel38.setZipCode("302006");
                hotel38.setPhoneNumber("+91-141-9876543");
                hotel38.setEmail("info@stationlodge.com");
                hotel38.setRating(BigDecimal.valueOf(3.7));
                hotel38.setTotalRooms(55);
                hotel38.setAvailableRooms(55);
                hotel38.setPricePerNight(BigDecimal.valueOf(1000));
                hotel38.setAmenities(Arrays.asList("WiFi", "24/7 Check-in", "Restaurant", "Parking"));
                hotel38.setImages(Arrays.asList("https://images.unsplash.com/photo-1555854877-bab0e564b8d5",
                                "https://images.unsplash.com/photo-1520250497591-112f2f40a3f4"));
                hotel38.setActive(true);

                Hotel hotel39 = new Hotel();
                hotel39.setName("Rooftop Terrace Hotel");
                hotel39.setDescription("Boutique hotel with stunning rooftop terrace, bar, and city skyline views.");
                hotel39.setAddress("78 Skyline Avenue");
                hotel39.setCity("Mumbai");
                hotel39.setState("Maharashtra");
                hotel39.setCountry("India");
                hotel39.setZipCode("400050");
                hotel39.setPhoneNumber("+91-22-76543210");
                hotel39.setEmail("info@rooftopterrace.com");
                hotel39.setRating(BigDecimal.valueOf(4.6));
                hotel39.setTotalRooms(42);
                hotel39.setAvailableRooms(42);
                hotel39.setPricePerNight(BigDecimal.valueOf(7800));
                hotel39.setAmenities(
                                Arrays.asList("WiFi", "Rooftop Bar", "City Views", "Restaurant", "Pool", "Lounge"));
                hotel39.setImages(Arrays.asList("https://images.unsplash.com/photo-1582719478250-c89cae4dc85b",
                                "https://images.unsplash.com/photo-1564501049412-61c2a3083791"));
                hotel39.setActive(true);

                Hotel hotel40 = new Hotel();
                hotel40.setName("Wildlife Safari Lodge");
                hotel40.setDescription(
                                "Lodge near national park with safari tours and wildlife viewing opportunities.");
                hotel40.setAddress("National Park Gate");
                hotel40.setCity("Ranthambore");
                hotel40.setState("Rajasthan");
                hotel40.setCountry("India");
                hotel40.setZipCode("322001");
                hotel40.setPhoneNumber("+91-746-1234567");
                hotel40.setEmail("info@wildlifesafari.com");
                hotel40.setRating(BigDecimal.valueOf(4.4));
                hotel40.setTotalRooms(32);
                hotel40.setAvailableRooms(32);
                hotel40.setPricePerNight(BigDecimal.valueOf(9000));
                hotel40.setAmenities(Arrays.asList("WiFi", "Safari Tours", "Wildlife Guides", "Restaurant", "Bonfire",
                                "Nature Walks"));
                hotel40.setImages(Arrays.asList("https://images.unsplash.com/photo-1571003123894-1f0594d2b5d9",
                                "https://images.unsplash.com/photo-1566073771259-6a8506099945"));
                hotel40.setActive(true);

                Hotel hotel41 = new Hotel();
                hotel41.setName("Riverside Palace Hotel");
                hotel41.setDescription(
                                "Majestic palace hotel on riverbank with royal architecture and luxury amenities.");
                hotel41.setAddress("1 River Palace Road");
                hotel41.setCity("Udaipur");
                hotel41.setState("Rajasthan");
                hotel41.setCountry("India");
                hotel41.setZipCode("313002");
                hotel41.setPhoneNumber("+91-294-9876543");
                hotel41.setEmail("info@riversidepalace.com");
                hotel41.setRating(BigDecimal.valueOf(4.9));
                hotel41.setTotalRooms(48);
                hotel41.setAvailableRooms(48);
                hotel41.setPricePerNight(BigDecimal.valueOf(15000));
                hotel41.setAmenities(Arrays.asList("WiFi", "Palace Tours", "Royal Dining", "Spa", "Pool", "Boat Rides",
                                "Cultural Shows"));
                hotel41.setImages(Arrays.asList("https://images.unsplash.com/photo-1618773928121-c32242e63f39",
                                "https://images.unsplash.com/photo-1582719478250-c89cae4dc85b"));
                hotel41.setActive(true);

                Hotel hotel42 = new Hotel();
                hotel42.setName("Tech Hub Apartments");
                hotel42.setDescription(
                                "Serviced apartments for long-stay tech professionals with kitchen and workspace.");
                hotel42.setAddress("456 Tech Park");
                hotel42.setCity("Pune");
                hotel42.setState("Maharashtra");
                hotel42.setCountry("India");
                hotel42.setZipCode("411014");
                hotel42.setPhoneNumber("+91-20-87654321");
                hotel42.setEmail("info@techapartments.com");
                hotel42.setRating(BigDecimal.valueOf(4.3));
                hotel42.setTotalRooms(65);
                hotel42.setAvailableRooms(65);
                hotel42.setPricePerNight(BigDecimal.valueOf(4200));
                hotel42.setAmenities(Arrays.asList("WiFi", "Kitchen", "Workspace", "Gym", "Laundry", "Parking",
                                "Co-working"));
                hotel42.setImages(Arrays.asList("https://images.unsplash.com/photo-1564501049412-61c2a3083791",
                                "https://images.unsplash.com/photo-1566073771259-6a8506099945"));
                hotel42.setActive(true);

                Hotel hotel43 = new Hotel();
                hotel43.setName("Sunset Beach Resort");
                hotel43.setDescription(
                                "Romantic beach resort famous for spectacular sunset views and beachfront dining.");
                hotel43.setAddress("99 Sunset Beach");
                hotel43.setCity("Gokarna");
                hotel43.setState("Karnataka");
                hotel43.setCountry("India");
                hotel43.setZipCode("581326");
                hotel43.setPhoneNumber("+91-838-1234567");
                hotel43.setEmail("info@sunsetbeach.com");
                hotel43.setRating(BigDecimal.valueOf(4.5));
                hotel43.setTotalRooms(38);
                hotel43.setAvailableRooms(38);
                hotel43.setPricePerNight(BigDecimal.valueOf(5800));
                hotel43.setAmenities(Arrays.asList("WiFi", "Beach Access", "Sunset Views", "Restaurant", "Water Sports",
                                "Yoga"));
                hotel43.setImages(Arrays.asList("https://images.unsplash.com/photo-1520250497591-112f2f40a3f4",
                                "https://images.unsplash.com/photo-1571896349842-33c89424de2d"));
                hotel43.setActive(true);

                Hotel hotel44 = new Hotel();
                hotel44.setName("Mountain Monastery Stay");
                hotel44.setDescription(
                                "Peaceful monastery guesthouse in the mountains with meditation and simple living.");
                hotel44.setAddress("Monastery Road");
                hotel44.setCity("Dharamshala");
                hotel44.setState("Himachal Pradesh");
                hotel44.setCountry("India");
                hotel44.setZipCode("176215");
                hotel44.setPhoneNumber("+91-189-1234567");
                hotel44.setEmail("info@monasterystay.com");
                hotel44.setRating(BigDecimal.valueOf(4.1));
                hotel44.setTotalRooms(22);
                hotel44.setAvailableRooms(22);
                hotel44.setPricePerNight(BigDecimal.valueOf(1800));
                hotel44.setAmenities(Arrays.asList("WiFi", "Meditation", "Mountain Views", "Simple Meals", "Library",
                                "Prayer Hall"));
                hotel44.setImages(Arrays.asList("https://images.unsplash.com/photo-1542314831-068cd1dbfeeb",
                                "https://images.unsplash.com/photo-1551882547-ff40c63fe5fa"));
                hotel44.setActive(true);

                Hotel hotel45 = new Hotel();
                hotel45.setName("Grand Convention Center Hotel");
                hotel45.setDescription(
                                "Large hotel with convention center, ideal for conferences and corporate events.");
                hotel45.setAddress("Convention Center Road");
                hotel45.setCity("Hyderabad");
                hotel45.setState("Telangana");
                hotel45.setCountry("India");
                hotel45.setZipCode("500032");
                hotel45.setPhoneNumber("+91-40-87654321");
                hotel45.setEmail("info@grandconvention.com");
                hotel45.setRating(BigDecimal.valueOf(4.4));
                hotel45.setTotalRooms(200);
                hotel45.setAvailableRooms(200);
                hotel45.setPricePerNight(BigDecimal.valueOf(5500));
                hotel45.setAmenities(Arrays.asList("WiFi", "Convention Center", "Meeting Rooms", "Restaurant", "Gym",
                                "Pool", "Business Center"));
                hotel45.setImages(Arrays.asList("https://images.unsplash.com/photo-1564501049412-61c2a3083791",
                                "https://images.unsplash.com/photo-1582719478250-c89cae4dc85b"));
                hotel45.setActive(true);

                Hotel hotel46 = new Hotel();
                hotel46.setName("Lakeside Camping Resort");
                hotel46.setDescription("Glamping resort by the lake with luxury tents and outdoor activities.");
                hotel46.setAddress("Lake View Point");
                hotel46.setCity("Nainital");
                hotel46.setState("Uttarakhand");
                hotel46.setCountry("India");
                hotel46.setZipCode("263001");
                hotel46.setPhoneNumber("+91-594-1234567");
                hotel46.setEmail("info@lakesidecamp.com");
                hotel46.setRating(BigDecimal.valueOf(4.3));
                hotel46.setTotalRooms(28);
                hotel46.setAvailableRooms(28);
                hotel46.setPricePerNight(BigDecimal.valueOf(4500));
                hotel46.setAmenities(Arrays.asList("WiFi", "Luxury Tents", "Lake View", "Boating", "Bonfire", "BBQ",
                                "Nature Walks"));
                hotel46.setImages(Arrays.asList("https://images.unsplash.com/photo-1571003123894-1f0594d2b5d9",
                                "https://images.unsplash.com/photo-1520250497591-112f2f40a3f4"));
                hotel46.setActive(true);

                Hotel hotel47 = new Hotel();
                hotel47.setName("City Center Premium Suites");
                hotel47.setDescription("Premium suites in city center with concierge service and luxury amenities.");
                hotel47.setAddress("Central Square");
                hotel47.setCity("Ahmedabad");
                hotel47.setState("Gujarat");
                hotel47.setCountry("India");
                hotel47.setZipCode("380001");
                hotel47.setPhoneNumber("+91-79-12345678");
                hotel47.setEmail("info@citypremium.com");
                hotel47.setRating(BigDecimal.valueOf(4.6));
                hotel47.setTotalRooms(72);
                hotel47.setAvailableRooms(72);
                hotel47.setPricePerNight(BigDecimal.valueOf(6800));
                hotel47.setAmenities(Arrays.asList("WiFi", "Concierge", "Spa", "Restaurant", "Gym", "Pool",
                                "Valet Parking"));
                hotel47.setImages(Arrays.asList("https://images.unsplash.com/photo-1566073771259-6a8506099945",
                                "https://images.unsplash.com/photo-1582719478250-c89cae4dc85b"));
                hotel47.setActive(true);

                Hotel hotel48 = new Hotel();
                hotel48.setName("Desert Camp Luxury");
                hotel48.setDescription("Luxury desert camp with camel safaris, cultural performances, and stargazing.");
                hotel48.setAddress("Desert Dunes");
                hotel48.setCity("Jaisalmer");
                hotel48.setState("Rajasthan");
                hotel48.setCountry("India");
                hotel48.setZipCode("345002");
                hotel48.setPhoneNumber("+91-299-9876543");
                hotel48.setEmail("info@desertcamp.com");
                hotel48.setRating(BigDecimal.valueOf(4.7));
                hotel48.setTotalRooms(24);
                hotel48.setAvailableRooms(24);
                hotel48.setPricePerNight(BigDecimal.valueOf(10500));
                hotel48.setAmenities(Arrays.asList("WiFi", "Luxury Tents", "Camel Safari", "Cultural Shows",
                                "Stargazing", "Traditional Dining"));
                hotel48.setImages(Arrays.asList("https://images.unsplash.com/photo-1618773928121-c32242e63f39",
                                "https://images.unsplash.com/photo-1571896349842-33c89424de2d"));
                hotel48.setActive(true);

                Hotel hotel49 = new Hotel();
                hotel49.setName("Hilltop Retreat Resort");
                hotel49.setDescription("Secluded hilltop resort with panoramic views, perfect for peaceful getaways.");
                hotel49.setAddress("Hilltop Road");
                hotel49.setCity("Munnar");
                hotel49.setState("Kerala");
                hotel49.setCountry("India");
                hotel49.setZipCode("685612");
                hotel49.setPhoneNumber("+91-486-1234567");
                hotel49.setEmail("info@hilltopretreat.com");
                hotel49.setRating(BigDecimal.valueOf(4.5));
                hotel49.setTotalRooms(36);
                hotel49.setAvailableRooms(36);
                hotel49.setPricePerNight(BigDecimal.valueOf(5600));
                hotel49.setAmenities(Arrays.asList("WiFi", "Panoramic Views", "Tea Plantation Tours", "Restaurant",
                                "Bonfire", "Nature Walks"));
                hotel49.setImages(Arrays.asList("https://images.unsplash.com/photo-1542314831-068cd1dbfeeb",
                                "https://images.unsplash.com/photo-1551882547-ff40c63fe5fa"));
                hotel49.setActive(true);

                Hotel hotel50 = new Hotel();
                hotel50.setName("Urban Luxury Residences");
                hotel50.setDescription(
                                "Ultra-modern luxury residences with smart home technology and premium services.");
                hotel50.setAddress("Luxury Lane");
                hotel50.setCity("Bengaluru");
                hotel50.setState("Karnataka");
                hotel50.setCountry("India");
                hotel50.setZipCode("560001");
                hotel50.setPhoneNumber("+91-80-76543210");
                hotel50.setEmail("info@urbanluxury.com");
                hotel50.setRating(BigDecimal.valueOf(4.8));
                hotel50.setTotalRooms(58);
                hotel50.setAvailableRooms(58);
                hotel50.setPricePerNight(BigDecimal.valueOf(13500));
                hotel50.setAmenities(Arrays.asList("WiFi", "Smart Home", "Butler Service", "Spa", "Fine Dining",
                                "Rooftop Pool", "Gym"));
                hotel50.setImages(Arrays.asList("https://images.unsplash.com/photo-1582719478250-c89cae4dc85b",
                                "https://images.unsplash.com/photo-1564501049412-61c2a3083791"));
                hotel50.setActive(true);

                hotelRepository.saveAll(Arrays.asList(
                                hotel1, hotel2, hotel3, hotel4, hotel5, hotel6, hotel7, hotel8, hotel9, hotel10,
                                hotel11, hotel12, hotel13, hotel14, hotel15, hotel16, hotel17, hotel18, hotel19,
                                hotel20,
                                hotel21, hotel22, hotel23, hotel24, hotel25, hotel26, hotel27, hotel28, hotel29,
                                hotel30,
                                hotel31, hotel32, hotel33, hotel34, hotel35, hotel36, hotel37, hotel38, hotel39,
                                hotel40,
                                hotel41, hotel42, hotel43, hotel44, hotel45, hotel46, hotel47, hotel48, hotel49,
                                hotel50));
        }
}
