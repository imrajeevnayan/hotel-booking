import React, { useEffect, useState } from 'react';
import axios from 'axios';
import HotelCard from '../components/HotelCard';
import Navbar from '../components/Navbar';

const Home = () => {
    const [hotels, setHotels] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchHotels = async () => {
            try {
                const response = await axios.get('/api/hotels');
                setHotels(response.data);
            } catch (err) {
                console.error('Error fetching hotels:', err);
                setError('Failed to load hotels. Please try again later.');
            } finally {
                setLoading(false);
            }
        };

        fetchHotels();
    }, []);

    return (
        <div className="app-container">
            <Navbar />
            <header className="hero">
                <div className="hero-overlay"></div>
                <div className="hero-content container">
                    <h1>Experience the Royal India</h1>
                    <p>Discover luxurious stays in the heart of culture and heritage. <br /> Book your perfect getaway today.</p>
                    <div className="search-bar">
                        <input type="text" placeholder="Where do you want to go?" />
                        <button>Search</button>
                    </div>
                </div>
            </header>

            <main className="container main-content">
                <div className="section-header">
                    <h2>Handpicked Hotels for You</h2>
                    <p>{hotels.length} properties found</p>
                </div>

                {loading ? (
                    <div className="loader-container"><div className="loader"></div></div>
                ) : error ? (
                    <div className="error-message">{error}</div>
                ) : (
                    <div className="hotel-grid">
                        {hotels.map(hotel => (
                            <HotelCard key={hotel.id} hotel={hotel} />
                        ))}
                    </div>
                )}
            </main>

            <footer className="footer">
                <div className="container">
                    <p>&copy; 2025 LuxeStays India. All rights reserved.</p>
                </div>
            </footer>
        </div>
    );
};

export default Home;
