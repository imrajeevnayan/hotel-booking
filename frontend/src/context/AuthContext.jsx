import React, { createContext, useContext, useState, useEffect } from 'react';
import axios from 'axios';

const AuthContext = createContext(null);

export const AuthProvider = ({ children }) => {
    const [user, setUser] = useState(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const token = localStorage.getItem('token');
        const userData = localStorage.getItem('user');

        if (token && userData) {
            setUser(JSON.parse(userData));
            // Set default axios header
            axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
        }
        setLoading(false);
    }, []);

    const login = async (email, password) => {
        try {
            const response = await axios.post('/api/auth/login', { email, password });
            console.log("Login response:", response.data);

            // Assuming response contains { token, user: { ... } } or similar
            // Adjust based on your actual backend response structure
            // If backend returns just token, you might need to decode it or fetch user profile

            const { token, ...userData } = response.data; // Adjust destructuring as needed
            // If the API returns the token directly in the body (e.g., just a string or {accessToken: ...})
            const actualToken = token || response.data.accessToken || response.data.token;

            if (actualToken) {
                localStorage.setItem('token', actualToken);
                localStorage.setItem('user', JSON.stringify(userData));
                axios.defaults.headers.common['Authorization'] = `Bearer ${actualToken}`;
                setUser(userData);
                return { success: true };
            } else {
                return { success: false, error: "Invalid response from server" };
            }

        } catch (error) {
            console.error("Login error:", error);
            return {
                success: false,
                error: error.response?.data?.message || "Login failed"
            };
        }
    };

    const logout = () => {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        delete axios.defaults.headers.common['Authorization'];
        setUser(null);
    };

    return (
        <AuthContext.Provider value={{ user, login, logout, loading }}>
            {!loading && children}
        </AuthContext.Provider>
    );
};

export const useAuth = () => useContext(AuthContext);
