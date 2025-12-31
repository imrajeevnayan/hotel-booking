import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { Building2, User, Menu, LogOut, ChevronDown } from 'lucide-react';
import { useAuth } from '../context/AuthContext';

const Navbar = () => {
    const { user, logout } = useAuth();
    const [isMenuOpen, setIsMenuOpen] = useState(false);
    const [isUserMenuOpen, setIsUserMenuOpen] = useState(false);

    return (
        <nav className="navbar">
            <div className="container navbar-content">
                <Link to="/" className="logo">
                    <Building2 className="icon" />
                    <span>LuxeStays India</span>
                </Link>

                <div className={`nav-links ${isMenuOpen ? 'active' : ''}`}>
                    <Link to="/">Home</Link>
                    {user && <Link to="/bookings">My Bookings</Link>}

                    {user ? (
                        <div className="user-menu-wrapper">
                            <button
                                className="user-menu-btn"
                                onClick={() => setIsUserMenuOpen(!isUserMenuOpen)}
                            >
                                <span className="user-avatar">
                                    {user.name ? user.name.charAt(0).toUpperCase() : 'U'}
                                </span>
                                <span>{user.name}</span>
                                <ChevronDown size={14} />
                            </button>

                            {isUserMenuOpen && (
                                <div className="user-dropdown">
                                    <div className="dropdown-item user-info">
                                        <small>{user.email}</small>
                                    </div>
                                    <button onClick={logout} className="dropdown-item text-red">
                                        <LogOut size={16} /> Logout
                                    </button>
                                </div>
                            )}
                        </div>
                    ) : (
                        <Link to="/login" className="btn-primary">
                            <User size={18} /> Sign In
                        </Link>
                    )}
                </div>

                <div className="mobile-menu" onClick={() => setIsMenuOpen(!isMenuOpen)}>
                    <Menu />
                </div>
            </div>
        </nav>
    );
};

export default Navbar;
