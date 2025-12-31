#!/bin/bash
# Script to fix Docker 'ContainerConfig' errors by forcing cleanup

echo "Attempting to stop all services..."
# Try proper down first
docker-compose down --remove-orphans || true

echo "Force removing potentially corrupted containers..."
# Manually remove the specific container mentioned in logs and common variants
docker rm -f hotel-booking_backend_1 || true
docker rm -f hotel-booking-backend-1 || true

echo "Cleaning up any other stopped containers..."
docker container prune -f

echo "Docker environment cleanup complete."
echo "You can now try running: docker-compose up --build"
