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

    const register = async (name, email, password) => {
        try {
            const response = await axios.post('/api/auth/signup', { name, email, password });
            console.log("Signup response:", response.data);

            const { token, ...userData } = response.data;
            const actualToken = token || response.data.accessToken || response.data.token;

            if (actualToken) {
                localStorage.setItem('token', actualToken);
                localStorage.setItem('user', JSON.stringify(userData));
                axios.defaults.headers.common['Authorization'] = `Bearer ${actualToken}`;
                setUser(userData);
                return { success: true };
            } else {
                return { success: false, error: "Signup successful but no token returned. Please login." };
            }

        } catch (error) {
            console.error("Signup error:", error);
            return {
                success: false,
                error: error.response?.data?.message || "Signup failed"
            };
        }
    };

    const logout = () => {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        delete axios.defaults.headers.common['Authorization'];
        setUser(null);
    };

    const loginWithToken = async (token) => {
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;

        try {
            // Fetch user profile to ensure we have user details
            const response = await axios.get('/api/auth/me');
            // The backend returns AuthResponse which includes token and user details
            const { token: newToken, ...userData } = response.data;

            localStorage.setItem('user', JSON.stringify(userData));
            setUser(userData);
            return { success: true };
        } catch (error) {
            console.error("Failed to fetch user profile:", error);
            logout();
            return { success: false, error: "Failed to verify session" };
        }
    };

    return (
        <AuthContext.Provider value={{ user, login, register, loginWithToken, logout, loading }}>
            {!loading && children}
        </AuthContext.Provider>
    );
};

export const useAuth = () => useContext(AuthContext);
