import React from 'react';
import { Star, MapPin } from 'lucide-react';

const HotelCard = ({ hotel }) => {
    // Use first image or fallback
    const imageUrl = (hotel.images && hotel.images.length > 0)
        ? hotel.images[0]
        : 'https://images.unsplash.com/photo-1566073771259-6a8506099945?ixlib=rb-4.0.3';

    return (
        <div className="hotel-card">
            <div className="card-image-container">
                <img src={imageUrl} alt={hotel.name} className="card-image" loading="lazy" />
                <div className="rating-badge">
                    <Star size={14} fill="#fbbf24" stroke="none" />
                    <span>{hotel.rating}</span>
                </div>
            </div>
            <div className="card-content">
                <h3 className="card-title">{hotel.name}</h3>
                <div className="card-location">
                    <MapPin size={14} className="location-icon" />
                    {hotel.city}, {hotel.state}
                </div>
                <p className="card-description">{hotel.description?.substring(0, 100)}...</p>
                <div className="card-amenities">
                    {hotel.amenities && hotel.amenities.slice(0, 3).map((amenity, index) => (
                        <span key={index} className="amenity-tag">{amenity}</span>
                    ))}
                </div>
                <div className="card-footer">
                    <div className="price-info">
                        <span className="currency">₹</span>
                        <span className="amount">{hotel.pricePerNight}</span>
                        <span className="period">/night</span>
                    </div>
                    <button className="book-btn">View Details</button>
                </div>
            </div>
        </div>
    );
};

export default HotelCard;
