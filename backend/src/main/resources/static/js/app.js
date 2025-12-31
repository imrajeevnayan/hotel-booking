// ===== Configuration =====
const API_BASE_URL = '/api';
let currentUser = null;
let currentHotel = null;
let allHotels = [];

// ===== Initialize App =====
document.addEventListener('DOMContentLoaded', () => {
    initializeAuth();
    loadHotels();
    setupEventListeners();
    setupNavigation();
    handleOAuth2Redirect();
});

// ===== Authentication =====
function initializeAuth() {
    const token = localStorage.getItem('token');
    if (token) {
        const user = JSON.parse(localStorage.getItem('user'));
        if (user) {
            setCurrentUser(user);
        }
    }
}

function setCurrentUser(user) {
    currentUser = user;
    localStorage.setItem('user', JSON.stringify(user));
    updateUIForAuth();
}

function updateUIForAuth() {
    const navAuth = document.getElementById('navAuth');
    const navUser = document.getElementById('navUser');
    const authRequired = document.querySelectorAll('.auth-required');

    if (currentUser) {
        navAuth.style.display = 'none';
        navUser.style.display = 'block';

        const userName = document.getElementById('userName');
        const userAvatar = document.getElementById('userAvatar');
        userName.textContent = currentUser.name;
        userAvatar.textContent = currentUser.name.charAt(0).toUpperCase();

        authRequired.forEach(el => el.style.display = 'block');
    } else {
        navAuth.style.display = 'flex';
        navUser.style.display = 'none';
        authRequired.forEach(el => el.style.display = 'none');
    }
}

function logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    currentUser = null;
    updateUIForAuth();
    showNotification('Logged out successfully', 'success');
    window.location.hash = '#home';
}

// ===== OAuth2 Redirect Handler =====
function handleOAuth2Redirect() {
    const urlParams = new URLSearchParams(window.location.search);
    const token = urlParams.get('token');

    if (token) {
        localStorage.setItem('token', token);

        // Fetch user details
        fetch(`${API_BASE_URL}/auth/me`, {
            headers: {
                'Authorization': `Bearer ${token}`
            }
        })
            .then(response => response.json())
            .then(user => {
                setCurrentUser(user);
                window.history.replaceState({}, document.title, '/');
                showNotification('Login successful!', 'success');
            })
            .catch(error => {
                console.error('Error fetching user:', error);
                localStorage.removeItem('token');
            });
    }
}

// ===== Event Listeners =====
function setupEventListeners() {
    // Auth modals
    document.getElementById('loginBtn').addEventListener('click', () => openModal('loginModal'));
    document.getElementById('signupBtn').addEventListener('click', () => openModal('signupModal'));
    document.getElementById('logoutBtn').addEventListener('click', logout);

    // Modal close buttons
    document.getElementById('loginClose').addEventListener('click', () => closeModal('loginModal'));
    document.getElementById('signupClose').addEventListener('click', () => closeModal('signupModal'));
    document.getElementById('hotelClose').addEventListener('click', () => closeModal('hotelModal'));
    document.getElementById('bookingClose').addEventListener('click', () => closeModal('bookingModal'));

    // Modal overlays
    document.getElementById('loginOverlay').addEventListener('click', () => closeModal('loginModal'));
    document.getElementById('signupOverlay').addEventListener('click', () => closeModal('signupModal'));
    document.getElementById('hotelOverlay').addEventListener('click', () => closeModal('hotelModal'));
    document.getElementById('bookingOverlay').addEventListener('click', () => closeModal('bookingModal'));

    // Forms
    document.getElementById('loginForm').addEventListener('submit', handleLogin);
    document.getElementById('signupForm').addEventListener('submit', handleSignup);
    document.getElementById('bookingForm').addEventListener('submit', handleBooking);

    // Search
    document.getElementById('searchBtn').addEventListener('click', handleSearch);

    // Filters
    document.querySelectorAll('.filter-btn').forEach(btn => {
        btn.addEventListener('click', (e) => {
            document.querySelectorAll('.filter-btn').forEach(b => b.classList.remove('active'));
            e.target.classList.add('active');
            filterHotels(e.target.dataset.city);
        });
    });

    // Booking form date change
    document.getElementById('bookingCheckIn').addEventListener('change', updateBookingSummary);
    document.getElementById('bookingCheckOut').addEventListener('change', updateBookingSummary);
    document.getElementById('bookingRooms').addEventListener('change', updateBookingSummary);

    // User dropdown
    document.getElementById('userBtn').addEventListener('click', (e) => {
        e.stopPropagation();
        document.getElementById('userDropdown').classList.toggle('active');
    });

    document.addEventListener('click', () => {
        document.getElementById('userDropdown').classList.remove('active');
    });
}

// ===== Navigation =====
function setupNavigation() {
    const navLinks = document.querySelectorAll('.nav-link');

    navLinks.forEach(link => {
        link.addEventListener('click', (e) => {
            e.preventDefault();
            const target = link.getAttribute('href').substring(1);

            navLinks.forEach(l => l.classList.remove('active'));
            link.classList.add('active');

            if (target === 'bookings') {
                loadUserBookings();
            }

            document.getElementById(target).scrollIntoView({ behavior: 'smooth' });
        });
    });

    // Navbar scroll effect
    window.addEventListener('scroll', () => {
        const navbar = document.getElementById('navbar');
        if (window.scrollY > 50) {
            navbar.classList.add('scrolled');
        } else {
            navbar.classList.remove('scrolled');
        }
    });
}

// ===== Modal Functions =====
function openModal(modalId) {
    document.getElementById(modalId).classList.add('active');
    document.body.style.overflow = 'hidden';
}

function closeModal(modalId) {
    document.getElementById(modalId).classList.remove('active');
    document.body.style.overflow = '';
}

// ===== Hotels =====
async function loadHotels() {
    try {
        const response = await fetch(`${API_BASE_URL}/hotels`);
        allHotels = await response.json();
        displayHotels(allHotels);
    } catch (error) {
        console.error('Error loading hotels:', error);
        showNotification('Error loading hotels', 'error');
    }
}

function displayHotels(hotels) {
    const grid = document.getElementById('hotelsGrid');
    grid.innerHTML = '';

    hotels.forEach(hotel => {
        const card = createHotelCard(hotel);
        grid.appendChild(card);
    });
}

function createHotelCard(hotel) {
    const card = document.createElement('div');
    card.className = 'hotel-card';
    card.onclick = () => showHotelDetails(hotel);

    const imageUrl = hotel.images && hotel.images.length > 0
        ? hotel.images[0]
        : 'https://images.unsplash.com/photo-1566073771259-6a8506099945';

    card.innerHTML = `
        <div class="hotel-image">
            <img src="${imageUrl}" alt="${hotel.name}">
            <div class="hotel-rating">${hotel.rating}</div>
        </div>
        <div class="hotel-content">
            <h3 class="hotel-name">${hotel.name}</h3>
            <div class="hotel-location">${hotel.city}, ${hotel.state}</div>
            <p class="hotel-description">${hotel.description}</p>
            <div class="hotel-amenities">
                ${hotel.amenities.slice(0, 3).map(amenity =>
        `<span class="amenity-tag">${amenity}</span>`
    ).join('')}
                ${hotel.amenities.length > 3 ? `<span class="amenity-tag">+${hotel.amenities.length - 3} more</span>` : ''}
            </div>
            <div class="hotel-footer">
                <div>
                    <div class="hotel-price">₹${hotel.pricePerNight.toLocaleString()}</div>
                    <div class="hotel-price-label">per night</div>
                </div>
                <button class="btn btn-primary" onclick="event.stopPropagation(); openBookingModal(${hotel.id})">
                    Book Now
                </button>
            </div>
        </div>
    `;

    return card;
}

function showHotelDetails(hotel) {
    currentHotel = hotel;
    const detailsDiv = document.getElementById('hotelDetails');

    detailsDiv.innerHTML = `
        <div class="hotel-details">
            <div class="hotel-images-gallery">
                ${hotel.images.map(img => `
                    <img src="${img}" alt="${hotel.name}" style="width: 100%; border-radius: 12px; margin-bottom: 16px;">
                `).join('')}
            </div>
            
            <h2 class="modal-title">${hotel.name}</h2>
            <div class="hotel-location" style="font-size: 1.125rem; margin-bottom: 24px;">
                ${hotel.address}, ${hotel.city}, ${hotel.state}, ${hotel.country}
            </div>
            
            <div style="display: flex; gap: 24px; margin-bottom: 24px;">
                <div>
                    <strong>Rating:</strong> ⭐ ${hotel.rating}
                </div>
                <div>
                    <strong>Available Rooms:</strong> ${hotel.availableRooms}
                </div>
            </div>
            
            <p style="margin-bottom: 24px; line-height: 1.8;">${hotel.description}</p>
            
            <h3 style="margin-bottom: 16px;">Amenities</h3>
            <div class="hotel-amenities" style="margin-bottom: 32px;">
                ${hotel.amenities.map(amenity =>
        `<span class="amenity-tag">${amenity}</span>`
    ).join('')}
            </div>
            
            <div style="display: flex; justify-content: space-between; align-items: center; padding: 24px; background: var(--gray-lighter); border-radius: 12px;">
                <div>
                    <div class="hotel-price">₹${hotel.pricePerNight.toLocaleString()}</div>
                    <div class="hotel-price-label">per night</div>
                </div>
                <button class="btn btn-primary" onclick="openBookingModal(${hotel.id})">
                    Book Now
                </button>
            </div>
        </div>
    `;

    openModal('hotelModal');
}

function filterHotels(city) {
    if (city === 'all') {
        displayHotels(allHotels);
    } else {
        const filtered = allHotels.filter(hotel => hotel.city === city);
        displayHotels(filtered);
    }
}

async function handleSearch() {
    const city = document.getElementById('searchCity').value;
    const checkIn = document.getElementById('searchCheckIn').value;
    const checkOut = document.getElementById('searchCheckOut').value;

    if (city) {
        filterHotels(city);
        document.getElementById('hotels').scrollIntoView({ behavior: 'smooth' });
    }
}

// ===== Booking =====
function openBookingModal(hotelId) {
    if (!currentUser) {
        closeModal('hotelModal');
        openModal('loginModal');
        showNotification('Please login to book a hotel', 'warning');
        return;
    }

    const hotel = allHotels.find(h => h.id === hotelId);
    if (!hotel) return;

    currentHotel = hotel;
    document.getElementById('bookingHotelId').value = hotel.id;
    document.getElementById('summaryHotel').textContent = hotel.name;
    document.getElementById('summaryPrice').textContent = `₹${hotel.pricePerNight.toLocaleString()}`;

    // Set min dates
    const today = new Date().toISOString().split('T')[0];
    document.getElementById('bookingCheckIn').min = today;
    document.getElementById('bookingCheckOut').min = today;

    // Pre-fill from search if available
    const searchCheckIn = document.getElementById('searchCheckIn').value;
    const searchCheckOut = document.getElementById('searchCheckOut').value;
    const searchGuests = document.getElementById('searchGuests').value;

    if (searchCheckIn) document.getElementById('bookingCheckIn').value = searchCheckIn;
    if (searchCheckOut) document.getElementById('bookingCheckOut').value = searchCheckOut;
    if (searchGuests) document.getElementById('bookingGuests').value = searchGuests;

    updateBookingSummary();
    closeModal('hotelModal');
    openModal('bookingModal');
}

function updateBookingSummary() {
    const checkIn = document.getElementById('bookingCheckIn').value;
    const checkOut = document.getElementById('bookingCheckOut').value;
    const rooms = parseInt(document.getElementById('bookingRooms').value) || 1;

    if (checkIn && checkOut && currentHotel) {
        const nights = Math.ceil((new Date(checkOut) - new Date(checkIn)) / (1000 * 60 * 60 * 24));
        const total = currentHotel.pricePerNight * nights * rooms;

        document.getElementById('summaryNights').textContent = nights;
        document.getElementById('summaryTotal').textContent = `₹${total.toLocaleString()}`;
    }
}

async function handleBooking(e) {
    e.preventDefault();

    const bookingData = {
        hotelId: parseInt(document.getElementById('bookingHotelId').value),
        checkInDate: document.getElementById('bookingCheckIn').value,
        checkOutDate: document.getElementById('bookingCheckOut').value,
        numberOfGuests: parseInt(document.getElementById('bookingGuests').value),
        numberOfRooms: parseInt(document.getElementById('bookingRooms').value),
        specialRequests: document.getElementById('bookingRequests').value
    };

    try {
        const token = localStorage.getItem('token');
        const response = await fetch(`${API_BASE_URL}/bookings`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            },
            body: JSON.stringify(bookingData)
        });

        if (!response.ok) {
            const error = await response.json();
            throw new Error(error.message || 'Booking failed');
        }

        const booking = await response.json();
        closeModal('bookingModal');

        // Initiate payment
        initiatePayment(booking);

    } catch (error) {
        console.error('Error creating booking:', error);
        showNotification(error.message || 'Error creating booking', 'error');
    }
}

async function initiatePayment(booking) {
    try {
        const token = localStorage.getItem('token');
        const response = await fetch(`${API_BASE_URL}/payments/create-order`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            },
            body: JSON.stringify({
                bookingId: booking.id,
                amount: booking.totalAmount
            })
        });

        const paymentData = await response.json();

        const options = {
            key: paymentData.keyId,
            amount: paymentData.amount * 100,
            currency: paymentData.currency,
            name: 'LuxStay',
            description: `Booking for ${booking.hotelName}`,
            order_id: paymentData.orderId,
            handler: function (response) {
                verifyPayment(response);
            },
            prefill: {
                name: currentUser.name,
                email: currentUser.email
            },
            theme: {
                color: '#6366f1'
            }
        };

        const razorpay = new Razorpay(options);
        razorpay.open();

    } catch (error) {
        console.error('Error initiating payment:', error);
        showNotification('Error initiating payment', 'error');
    }
}

async function verifyPayment(paymentResponse) {
    try {
        const token = localStorage.getItem('token');
        const response = await fetch(`${API_BASE_URL}/payments/verify`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${token}`
            },
            body: JSON.stringify({
                razorpayOrderId: paymentResponse.razorpay_order_id,
                razorpayPaymentId: paymentResponse.razorpay_payment_id,
                razorpaySignature: paymentResponse.razorpay_signature
            })
        });

        if (response.ok) {
            showNotification('Booking confirmed! Payment successful.', 'success');
            loadUserBookings();
            window.location.hash = '#bookings';
        } else {
            throw new Error('Payment verification failed');
        }

    } catch (error) {
        console.error('Error verifying payment:', error);
        showNotification('Payment verification failed', 'error');
    }
}

// ===== User Bookings =====
async function loadUserBookings() {
    if (!currentUser) return;

    try {
        const token = localStorage.getItem('token');
        const response = await fetch(`${API_BASE_URL}/bookings`, {
            headers: {
                'Authorization': `Bearer ${token}`
            }
        });

        const bookings = await response.json();
        displayBookings(bookings);

    } catch (error) {
        console.error('Error loading bookings:', error);
        showNotification('Error loading bookings', 'error');
    }
}

function displayBookings(bookings) {
    const list = document.getElementById('bookingsList');

    if (bookings.length === 0) {
        list.innerHTML = '<p style="text-align: center; color: var(--gray);">No bookings found</p>';
        return;
    }

    list.innerHTML = bookings.map(booking => `
        <div class="booking-card">
            <div class="booking-header">
                <div>
                    <div class="booking-reference">Booking #${booking.bookingReference}</div>
                    <div style="color: var(--gray); margin-top: 4px;">${booking.hotelName}</div>
                </div>
                <span class="booking-status ${booking.status.toLowerCase()}">${booking.status}</span>
            </div>
            
            <div class="booking-details">
                <div class="booking-detail">
                    <div class="booking-detail-label">Check-in</div>
                    <div class="booking-detail-value">${new Date(booking.checkInDate).toLocaleDateString()}</div>
                </div>
                <div class="booking-detail">
                    <div class="booking-detail-label">Check-out</div>
                    <div class="booking-detail-value">${new Date(booking.checkOutDate).toLocaleDateString()}</div>
                </div>
                <div class="booking-detail">
                    <div class="booking-detail-label">Guests</div>
                    <div class="booking-detail-value">${booking.numberOfGuests}</div>
                </div>
                <div class="booking-detail">
                    <div class="booking-detail-label">Rooms</div>
                    <div class="booking-detail-value">${booking.numberOfRooms}</div>
                </div>
                <div class="booking-detail">
                    <div class="booking-detail-label">Total Amount</div>
                    <div class="booking-detail-value">₹${booking.totalAmount.toLocaleString()}</div>
                </div>
            </div>
            
            ${booking.status === 'PENDING' || booking.status === 'CONFIRMED' ? `
                <div class="booking-actions">
                    <button class="btn btn-outline" onclick="cancelBooking(${booking.id})">Cancel Booking</button>
                </div>
            ` : ''}
        </div>
    `).join('');
}

async function cancelBooking(bookingId) {
    if (!confirm('Are you sure you want to cancel this booking?')) return;

    try {
        const token = localStorage.getItem('token');
        const response = await fetch(`${API_BASE_URL}/bookings/${bookingId}`, {
            method: 'DELETE',
            headers: {
                'Authorization': `Bearer ${token}`
            }
        });

        if (response.ok) {
            showNotification('Booking cancelled successfully', 'success');
            loadUserBookings();
        } else {
            throw new Error('Failed to cancel booking');
        }

    } catch (error) {
        console.error('Error cancelling booking:', error);
        showNotification('Error cancelling booking', 'error');
    }
}

// ===== Auth Handlers =====
async function handleLogin(e) {
    e.preventDefault();

    const loginData = {
        email: document.getElementById('loginEmail').value,
        password: document.getElementById('loginPassword').value
    };

    try {
        const response = await fetch(`${API_BASE_URL}/auth/login`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(loginData)
        });

        if (!response.ok) {
            throw new Error('Login failed');
        }

        const data = await response.json();
        localStorage.setItem('token', data.token);
        setCurrentUser({
            id: data.id,
            email: data.email,
            name: data.name,
            role: data.role
        });

        closeModal('loginModal');
        showNotification('Login successful!', 'success');
        document.getElementById('loginForm').reset();

    } catch (error) {
        console.error('Error logging in:', error);
        showNotification('Invalid email or password', 'error');
    }
}

async function handleSignup(e) {
    e.preventDefault();

    const signupData = {
        name: document.getElementById('signupName').value,
        email: document.getElementById('signupEmail').value,
        password: document.getElementById('signupPassword').value,
        phoneNumber: document.getElementById('signupPhone').value
    };

    try {
        const response = await fetch(`${API_BASE_URL}/auth/signup`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(signupData)
        });

        if (!response.ok) {
            const error = await response.json();
            throw new Error(error.message || 'Signup failed');
        }

        const data = await response.json();
        localStorage.setItem('token', data.token);
        setCurrentUser({
            id: data.id,
            email: data.email,
            name: data.name,
            role: data.role
        });

        closeModal('signupModal');
        showNotification('Account created successfully!', 'success');
        document.getElementById('signupForm').reset();

    } catch (error) {
        console.error('Error signing up:', error);
        showNotification(error.message || 'Error creating account', 'error');
    }
}

// ===== Notifications =====
function showNotification(message, type = 'info') {
    const notification = document.createElement('div');
    notification.className = `notification notification-${type}`;
    notification.textContent = message;
    notification.style.cssText = `
        position: fixed;
        top: 100px;
        right: 20px;
        padding: 16px 24px;
        background: ${type === 'success' ? 'var(--success)' : type === 'error' ? 'var(--danger)' : type === 'warning' ? 'var(--warning)' : 'var(--primary)'};
        color: white;
        border-radius: 8px;
        box-shadow: var(--shadow-lg);
        z-index: 3000;
        animation: slideIn 0.3s ease-out;
        font-weight: 500;
    `;

    document.body.appendChild(notification);

    setTimeout(() => {
        notification.style.animation = 'slideOut 0.3s ease-out';
        setTimeout(() => notification.remove(), 300);
    }, 3000);
}

// Add notification animations
const style = document.createElement('style');
style.textContent = `
    @keyframes slideIn {
        from {
            transform: translateX(400px);
            opacity: 0;
        }
        to {
            transform: translateX(0);
            opacity: 1;
        }
    }
    
    @keyframes slideOut {
        from {
            transform: translateX(0);
            opacity: 1;
        }
        to {
            transform: translateX(400px);
            opacity: 0;
        }
    }
`;
document.head.appendChild(style);
