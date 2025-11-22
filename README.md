# LuxStay - Hotel Booking System

A full-stack hotel booking application built with Spring Boot and modern web technologies.

## Features

- 🏨 **Hotel Browsing**: Browse and search luxury hotels
- 🔐 **Authentication**: Local signup/login and GitHub OAuth integration
- 📅 **Booking System**: Complete booking workflow with date selection
- 💳 **Payment Integration**: Razorpay payment gateway integration
- 📱 **Responsive Design**: Beautiful, modern UI that works on all devices
- 🎨 **Premium UI**: Stunning design with animations and gradients

## Tech Stack

### Backend
- **Spring Boot 3.2.0** - Java framework
- **PostgreSQL** - Database
- **Spring Security** - Authentication & authorization
- **OAuth2** - GitHub login integration
- **JWT** - Token-based authentication
- **Razorpay SDK** - Payment processing
- **JPA/Hibernate** - ORM

### Frontend
- **HTML5** - Structure
- **CSS3** - Styling with modern features
- **JavaScript (ES6+)** - Interactivity
- **Razorpay Checkout** - Payment UI

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- PostgreSQL 12+
- GitHub OAuth App credentials
- Razorpay account and API keys

## Setup Instructions

### 1. Database Setup

Create a PostgreSQL database:

```sql
CREATE DATABASE hotel_booking_db;
```

### 2. GitHub OAuth Setup

1. Go to [GitHub Developer Settings](https://github.com/settings/developers)
2. Click "New OAuth App"
3. Fill in the details:
   - Application name: `LuxStay Hotel Booking`
   - Homepage URL: `http://localhost:8080`
   - Authorization callback URL: `http://localhost:8080/login/oauth2/code/github`
4. Save the Client ID and Client Secret

### 3. Razorpay Setup

1. Sign up at [Razorpay](https://razorpay.com/)
2. Go to Settings > API Keys
3. Generate Test/Live keys
4. Save the Key ID and Key Secret

### 4. Environment Configuration

Create a `.env` file in the project root (copy from `.env.example`):

```env
DB_URL=jdbc:postgresql://localhost:5432/hotel_booking_db
DB_USERNAME=postgres
DB_PASSWORD=your_postgres_password

GITHUB_CLIENT_ID=your_github_client_id
GITHUB_CLIENT_SECRET=your_github_client_secret

JWT_SECRET=your_jwt_secret_key_minimum_256_bits

RAZORPAY_KEY_ID=your_razorpay_key_id
RAZORPAY_KEY_SECRET=your_razorpay_key_secret
```

Or update `src/main/resources/application.yml` directly.

### 5. Build and Run

```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The application will start at `http://localhost:8080`

## API Endpoints

### Authentication
- `POST /api/auth/signup` - Create new account
- `POST /api/auth/login` - Login with credentials
- `GET /oauth2/authorization/github` - GitHub OAuth login

### Hotels
- `GET /api/hotels` - Get all hotels
- `GET /api/hotels/{id}` - Get hotel by ID
- `GET /api/hotels/search` - Search hotels with filters
- `POST /api/hotels` - Create hotel (admin)
- `PUT /api/hotels/{id}` - Update hotel (admin)
- `DELETE /api/hotels/{id}` - Delete hotel (admin)

### Bookings
- `POST /api/bookings` - Create booking (authenticated)
- `GET /api/bookings` - Get user bookings (authenticated)
- `GET /api/bookings/{id}` - Get booking by ID (authenticated)
- `DELETE /api/bookings/{id}` - Cancel booking (authenticated)

### Payments
- `POST /api/payments/create-order` - Create Razorpay order
- `POST /api/payments/verify` - Verify payment
- `GET /api/payments/booking/{bookingId}` - Get payment by booking

## Project Structure

```
hotel-booking/
├── src/
│   ├── main/
│   │   ├── java/com/hotelbooking/
│   │   │   ├── config/          # Configuration classes
│   │   │   ├── controller/      # REST controllers
│   │   │   ├── dto/             # Data transfer objects
│   │   │   ├── model/           # Entity models
│   │   │   ├── repository/      # JPA repositories
│   │   │   ├── security/        # Security configuration
│   │   │   ├── service/         # Business logic
│   │   │   └── HotelBookingApplication.java
│   │   └── resources/
│   │       ├── static/          # Frontend files
│   │       │   ├── css/
│   │       │   ├── js/
│   │       │   └── index.html
│   │       └── application.yml
│   └── test/
├── pom.xml
└── README.md
```

## Features in Detail

### Authentication
- Local authentication with email/password
- GitHub OAuth2 integration
- JWT token-based session management
- Secure password hashing with BCrypt

### Hotel Management
- Browse hotels with beautiful card layouts
- Filter by city
- Search functionality
- Detailed hotel information with images
- Amenities display
- Rating system

### Booking System
- Date-based booking
- Room availability tracking
- Guest and room count selection
- Special requests support
- Booking reference generation
- Booking history

### Payment Integration
- Razorpay payment gateway
- Secure payment processing
- Payment verification
- Order creation and tracking

### UI/UX
- Modern, responsive design
- Smooth animations and transitions
- Gradient backgrounds
- Glassmorphism effects
- Mobile-friendly interface
- Toast notifications

## Security Features

- CORS configuration
- JWT authentication
- OAuth2 integration
- Password encryption
- SQL injection prevention
- XSS protection

## Testing

Run tests with:

```bash
mvn test
```

## Deployment

### Database
1. Set up PostgreSQL database
2. Update connection details in application.yml

### Application
1. Build the JAR file: `mvn clean package`
2. Run: `java -jar target/hotel-booking-system-1.0.0.jar`

### Environment Variables
Set all required environment variables in your deployment platform.

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

This project is licensed under the MIT License.

## Support

For support, email support@luxstay.com or create an issue in the repository.

## Acknowledgments

- Spring Boot team for the excellent framework
- Razorpay for payment integration
- GitHub for OAuth integration
- Unsplash for hotel images
