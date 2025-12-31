-- Hotel Booking System Database Setup
-- Run this script in pgAdmin or psql

-- Create database (run this as postgres user)
CREATE DATABASE hotel_booking_db
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE hotel_booking_db
    IS 'Hotel Booking System Database';

-- Connect to the database
\c hotel_booking_db

-- The tables will be created automatically by Hibernate when you run the application
-- No need to create tables manually

-- Verify database creation
SELECT 'Database created successfully!' as status;
