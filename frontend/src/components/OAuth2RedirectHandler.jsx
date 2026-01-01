import React, { useEffect } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';

const OAuth2RedirectHandler = () => {
    const { loginWithToken } = useAuth();
    const navigate = useNavigate();
    const location = useLocation();

    useEffect(() => {
        const params = new URLSearchParams(location.search);
        const token = params.get('token');
        const error = params.get('error');

        const handleLogin = async () => {
            if (token) {
                const result = await loginWithToken(token);
                if (result.success) {
                    navigate('/', { replace: true });
                } else {
                    console.error('OAuth2 Login Failed:', result.error);
                    navigate('/login', { state: { error: 'Failed to authenticate with GitHub' } });
                }
            } else {
                console.error('OAuth2 Error:', error);
                navigate('/login', { state: { error: error || 'Login failed' } });
            }
        };

        handleLogin();

    }, [location, navigate, loginWithToken]);

    return (
        <div className="flex items-center justify-center min-h-screen">
            <div className="text-center">
                <h2>Logging you in...</h2>
                <div className="loader"></div>
            </div>
        </div>
    );
};

export default OAuth2RedirectHandler;
