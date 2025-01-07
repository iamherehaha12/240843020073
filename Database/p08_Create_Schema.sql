
--DROP DATABASE IF EXISTS  p08_carrental;
CREATE DATABASE p08_carrental;
USE  p08_carrental;


CREATE TABLE roles (
    role_id INT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(225) UNIQUE NOT NULL
) AUTO_INCREMENT = 1;

CREATE TABLE mode_of_payment (
    mode_id INT AUTO_INCREMENT PRIMARY KEY,
    mode_name VARCHAR(50) NOT NULL
) AUTO_INCREMENT = 1;

CREATE TABLE fuel (
    fuel_id INT AUTO_INCREMENT PRIMARY KEY,
    fuel_type VARCHAR(45) NOT NULL
) AUTO_INCREMENT = 1;

CREATE TABLE city (
    city_id INT AUTO_INCREMENT PRIMARY KEY,
    city_name VARCHAR(100) UNIQUE NOT NULL
) AUTO_INCREMENT = 1;

CREATE TABLE category (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL,
    description TEXT
) AUTO_INCREMENT = 1;

CREATE TABLE status (
    status_id INT AUTO_INCREMENT PRIMARY KEY,
    status_name VARCHAR(45) NOT NULL
) AUTO_INCREMENT = 1;

CREATE TABLE car_manufacturer (
    manufacturer_id INT AUTO_INCREMENT PRIMARY KEY,
    manufacturer_name VARCHAR(45) NOT NULL
) AUTO_INCREMENT = 1;

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    role_id INT NOT NULL,
    FOREIGN KEY (role_id) REFERENCES roles(role_id)
) AUTO_INCREMENT = 1;

CREATE TABLE customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT UNIQUE NOT NULL, 
    city_id INT NOT NULL,
    address VARCHAR(255) NOT NULL,
    adhar_number VARCHAR(25) UNIQUE NOT NULL,
    driving_license_no VARCHAR(20) UNIQUE NOT NULL,
    contact VARCHAR(45) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (city_id) REFERENCES city(city_id)
) AUTO_INCREMENT = 1;

CREATE TABLE car_rental_agency (
    agency_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT UNIQUE NOT NULL, 
    city_id INT NOT NULL,
    address VARCHAR(255) NOT NULL,
    contact VARCHAR(15) NOT NULL,
    gst_no VARCHAR(15) UNIQUE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (city_id) REFERENCES city(city_id)
) AUTO_INCREMENT = 1;

CREATE TABLE car_model (
    model_id INT AUTO_INCREMENT PRIMARY KEY,
    model_name VARCHAR(45) NOT NULL,
    manufacturer_id INT NOT NULL,
    fuel_id INT NOT NULL,
    seat_count INT,
    FOREIGN KEY (manufacturer_id) REFERENCES car_manufacturer(manufacturer_id),
    FOREIGN KEY (fuel_id) REFERENCES fuel(fuel_id)
) AUTO_INCREMENT = 1;

CREATE TABLE car (
    car_id INT AUTO_INCREMENT PRIMARY KEY,
    category_id INT NOT NULL,
    agency_id INT NOT NULL,
    daily_rent DECIMAL(10,2) NOT NULL,
    registration_number VARCHAR(225) UNIQUE NOT NULL,
    kilometers_run INT,
    year_of_purchase INT,
    model_id INT NOT NULL,
    is_available BOOLEAN DEFAULT TRUE,  -- Availability tracking
    FOREIGN KEY (category_id) REFERENCES category(category_id),
    FOREIGN KEY (agency_id) REFERENCES car_rental_agency(agency_id) ON DELETE RESTRICT,
    FOREIGN KEY (model_id) REFERENCES car_model(model_id)
) AUTO_INCREMENT = 1;

CREATE TABLE booking (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    agency_id INT NOT NULL,
    car_id INT NOT NULL,
    booking_date DATE NOT NULL,
    rental_duration INT NOT NULL,
    journey_date DATE NOT NULL,
    status_id INT NOT NULL,
    token_amount DECIMAL(10,0),
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
    FOREIGN KEY (agency_id) REFERENCES car_rental_agency(agency_id),
    FOREIGN KEY (car_id) REFERENCES car(car_id),
    FOREIGN KEY (status_id) REFERENCES status(status_id)
) AUTO_INCREMENT = 1;

CREATE TABLE payment (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    booking_id INT UNIQUE NOT NULL, 
    amount_to_pay DECIMAL(10,2) NOT NULL,
    payment_date DATE NOT NULL,
    mode_id INT NOT NULL,
    FOREIGN KEY (booking_id) REFERENCES booking(booking_id) ON DELETE CASCADE,
    FOREIGN KEY (mode_id) REFERENCES mode_of_payment(mode_id)
) AUTO_INCREMENT = 1;

CREATE TABLE car_availability (
    availability_id INT AUTO_INCREMENT PRIMARY KEY,
    car_id INT NOT NULL,
    availability_date DATE NOT NULL,
    is_available BOOLEAN NOT NULL DEFAULT TRUE,  -- Track car availability by date
    FOREIGN KEY (car_id) REFERENCES car(car_id)
) AUTO_INCREMENT = 1;

select * from booking;