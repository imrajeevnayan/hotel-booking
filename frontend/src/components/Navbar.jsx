import React from 'react';
import { Building2, User, Menu } from 'lucide-react';

const Navbar = () => {
    return (
        <nav className="navbar">
            <div className="container navbar-content">
                <div className="logo">
                    <Building2 className="icon" />
                    <span>LuxeStays India</span>
                </div>
                <div className="nav-links">
                    <a href="/" className="active">Home</a>
                    <a href="/bookings">My Bookings</a>
                    <a href="/login" className="btn-primary">
                        <User size={18} /> Sign In
                    </a>
                </div>
                <div className="mobile-menu">
                    <Menu />
                </div>
            </div>
        </nav>
    );
};

export default Navbar;
