USE p08_carrental;

INSERT INTO roles (role_name) VALUES
('Admin'),
('Customer'),
('Agency');

INSERT INTO mode_of_payment (mode_name) VALUES
('Cash'),
('Credit Card'),
('Debit Card'),
('Online Payment');

INSERT INTO fuel (fuel_type) VALUES
('Petrol'),
('Diesel'),
('Electric'),
('CNG');

INSERT INTO city (city_name) VALUES
('Mumbai'),
('Delhi'),
('Bangalore'),
('Chennai'),
('Kolkata'),
('Hyderabad'),
('Pune'),
('Ahmedabad'),
('Jaipur'),
('Lucknow');

INSERT INTO category (category_name, description) VALUES
('SUV', 'Sport Utility Vehicle'),
('Sedan', 'Standard sedan vehicles'),
('Sports', 'Luxury sports cars'),
('Luxury', 'High-end luxury cars'),
('Convertible', 'Cars with convertible roofs');

INSERT INTO status (status_name) VALUES
('Booked'),
('Available'),
('Unavailable'),
('In Service');

INSERT INTO car_manufacturer (manufacturer_name) VALUES
('Toyota'),
('Honda'),
('Ford'),
('BMW'),
('Audi'),
('Mercedes'),
('Hyundai'),
('Tata'),
('Maruti Suzuki'),
('Nissan');

INSERT INTO users (user_name, password, email, role_id) VALUES
('admin_user', 'admin_pass', 'admin@email.com', 1),
('customer_user', 'customer_pass', 'customer@email.com', 2),
('agency_user', 'agency_pass', 'agency@email.com', 3);

INSERT INTO customer (user_id, city_id, address, adhar_number, driving_license_no, contact) VALUES
(2, 1, 'Mumbai, Maharashtra', '1234-5678-9012', 'DL1234567890', '9876543210');

INSERT INTO car_rental_agency (user_id, city_id, address, contact, gst_no) VALUES
(3, 1, 'Mumbai, Maharashtra', '9876543210', 'GST1234567890');

INSERT INTO car_model (model_name, manufacturer_id, fuel_id, seat_count) VALUES
('Corolla', 1, 1, 5),
('Civic', 2, 1, 5),
('Mustang', 3, 1, 2),
('X5', 4, 1, 5),
('A6', 5, 1, 4),
('Elantra', 6, 1, 5),
('Altroz', 7, 2, 5),
('Swift', 8, 2, 5),
('Micra', 9, 2, 4),
('Sunny', 10, 1, 5);

INSERT INTO car (category_id, agency_id, daily_rent, registration_number, kilometers_run, year_of_purchase, model_id, is_available) VALUES
(1, 1, 1500.00, 'MH01ABC1234', 12000, 2020, 1, TRUE),
(2, 1, 2500.00, 'MH01XYZ5678', 15000, 2021, 2, TRUE),
(3, 1, 4000.00, 'MH01DEF9876', 8000, 2022, 3, TRUE),
(4, 1, 5000.00, 'MH01GHI1357', 5000, 2023, 4, TRUE),
(5, 1, 6000.00, 'MH01JKL2468', 3000, 2024, 5, TRUE),
(1, 1, 1800.00, 'MH02ABC2345', 10000, 2020, 6, TRUE),
(2, 1, 2800.00, 'MH02XYZ6789', 12000, 2021, 7, TRUE),
(3, 1, 4500.00, 'MH02DEF2345', 7000, 2022, 8, TRUE),
(4, 1, 5500.00, 'MH02GHI2468', 6000, 2023, 9, TRUE),
(5, 1, 6500.00, 'MH02JKL1234', 2000, 2024, 10, TRUE);

INSERT INTO booking (customer_id, agency_id, car_id, booking_date, rental_duration, journey_date, status_id, token_amount) VALUES
(1, 1, 1, '2024-12-01', 5, '2024-12-06', 1, 500),
(1, 1, 2, '2024-12-05', 3, '2024-12-08', 1, 1000),
(1, 1, 3, '2024-12-10', 7, '2024-12-17', 2, 1500);

INSERT INTO payment (booking_id, amount_to_pay, payment_date, mode_id) VALUES
(1, 7500.00, '2024-12-01', 3),
(2, 7500.00, '2024-12-05', 2),
(3, 10500.00, '2024-12-10', 4);

INSERT INTO car_availability (car_id, availability_date, is_available) VALUES
(1, '2024-12-06', FALSE),
(2, '2024-12-08', FALSE),
(3, '2024-12-17', TRUE),
(4, '2024-12-06', TRUE),
(5, '2024-12-06', TRUE);
