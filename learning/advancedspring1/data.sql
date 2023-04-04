INSERT INTO Flight (company_id, flight_type, travel_type, arrival_date, departure_date, back_date, departure_time, arrival_time, back_time, departure_location, arrival_location, flight_duration, connection_duration, aircraft_type)
VALUES 
(1, 'DIRECT', 'ONEWAYTICKET', '2023-04-10', '2023-04-10', NULL, '08:00:00', '10:00:00', NULL, 'Nairobi', 'Mombasa', '02:00:00', NULL, 'Boeing 737'),
(2, 'DIRECT', 'ROUNDTRIP', '2023-04-11', '2023-04-13', '2023-04-15', '10:00:00', '12:00:00', '14:00:00', 'Mombasa', 'Nairobi', '02:00:00', '04:00:00', 'Airbus A320'),
(3, 'CONNECTING', 'ONEWAYTICKET', '2023-04-14', '2023-04-14', NULL, '08:00:00', '10:00:00', NULL, 'Nairobi', 'Dubai', '04:00:00', '02:00:00', 'Boeing 777'),
(4, 'DIRECT', 'ROUNDTRIP', '2023-04-15', '2023-04-17', '2023-04-20', '10:00:00', '12:00:00', '14:00:00', 'Dubai', 'Nairobi', '02:00:00', '04:00:00', 'Airbus A330'),
(5, 'DIRECT', 'ONEWAYTICKET', '2023-04-18', '2023-04-18', NULL, '08:00:00', '10:00:00', NULL, 'Nairobi', 'New York', '12:00:00', NULL, 'Boeing 747'),
(6, 'DIRECT', 'ROUNDTRIP', '2023-04-19', '2023-04-21', '2023-04-23', '10:00:00', '12:00:00', '14:00:00', 'New York', 'Nairobi', '02:00:00', '04:00:00', 'Boeing 777'),
(7, 'CONNECTING', 'ONEWAYTICKET', '2023-04-24', '2023-04-24', NULL, '08:00:00', '10:00:00', NULL, 'Nairobi', 'Paris', '06:00:00', '03:00:00', 'Airbus A350'),
(8, 'DIRECT', 'ROUNDTRIP', '2023-04-25', '2023-04-27', '2023-04-30', '10:00:00', '12:00:00', '14:00:00', 'Paris', 'Nairobi', '02:00:00', '04:00:00', 'Airbus A320');

INSERT INTO InFlightInfo (id, title, description) VALUES
(1, 'In-Flight Entertainment', 'Watch movies, TV shows, and more on your personal screen.'),
(2, 'Duty-Free Shopping', 'Browse our selection of luxury items and souvenirs.'),
(3, 'In-Flight Meals', 'Enjoy a delicious meal prepared by our expert chefs.'),
(4, 'In-Flight Drinks', 'Choose from a variety of beverages, including wine and spirits.'),
(5, 'Comfortable Seating', 'Relax in our comfortable seats with plenty of legroom.'),
(6, 'In-Flight Wi-Fi', 'Stay connected during your flight with our high-speed Wi-Fi.'),
(7, 'In-Flight Magazines', 'Read the latest magazines and newspapers on board.'),
(8, 'In-Flight Music', 'Listen to your favorite music and playlists.'),
(9, 'In-Flight Games', 'Play games and puzzles to pass the time.'),
(10, 'In-Flight Safety', 'Learn about our safety procedures and protocols.'),
(11, 'In-Flight Staff', 'Meet our friendly and professional flight attendants.'),
(12, 'In-Flight Pillow and Blanket', 'Get comfortable and rest during your flight.'),
(13, 'In-Flight Amenities', 'Discover our selection of additional amenities.'),
(14, 'In-Flight Snacks', 'Satisfy your hunger with our selection of snacks.'),
(15, 'In-Flight Beverages', 'Stay hydrated with our selection of beverages.'),
(16, 'In-Flight Reading', 'Read books, newspapers, and magazines on board.'),
(17, 'In-Flight Headphones', 'Listen to your favorite music and movies with our headphones.'),
(18, 'In-Flight Views', 'Enjoy the breathtaking views from your window seat.'),
(19, 'In-Flight Atmosphere', 'Experience the comfortable and relaxing atmosphere on board.'),
(20, 'In-Flight Lighting', 'Adjust the lighting to your preference during your flight.'),
(21, 'In-Flight Temperature', 'Stay comfortable with our adjustable temperature control.'),
(22, 'In-Flight Noise Level', 'Adjust the noise level with our noise-cancelling headphones.'),
(23, 'In-Flight Air Quality', 'Breathe fresh air with our advanced air filtration system.'),
(24, 'In-Flight Restrooms', 'Freshen up in our clean and spacious restrooms.'),
(25, 'In-Flight Hygiene', 'Stay healthy and clean with our hygiene amenities.'),
(26, 'In-Flight Comfort Kits', 'Relax with our selection of comfort kits.'),
(27, 'In-Flight First Aid', 'Get medical assistance from our trained staff.'),
(28, 'In-Flight Pet Care', 'Travel with your furry friends with our pet care services.'),
(29, 'In-Flight Child Care', 'Keep your kids entertained and happy with our child care services.'),
(30, 'In-Flight Accessibility', 'We offer special assistance for passengers with disabilities.');


INSERT INTO CabinDetail (id, cabinClass, baggage, cancellation, rebooking, refund, fare) 
VALUES 
    (1, 'FIRST', '2 bags free', 'Non-refundable', 'Allowed with fee', 'Allowed with fee', '$1000'),
    (2, 'FIRST', '3 bags free', 'Non-refundable', 'Allowed with fee', 'Allowed with fee', '$1200'),
    (3, 'FIRST', '2 bags free', 'Non-refundable', 'Allowed with fee', 'Allowed with fee', '$900'),
    (4, 'BUSINESS', '2 bags free', 'Non-refundable', 'Allowed with fee', 'Allowed with fee', '$800'),
    (5, 'BUSINESS', '3 bags free', 'Non-refundable', 'Allowed with fee', 'Allowed with fee', '$1000'),
    (6, 'BUSINESS', '2 bags free', 'Non-refundable', 'Allowed with fee', 'Allowed with fee', '$700'),
    (7, 'PREMIUM_ECONOMY', '1 bag free', 'Refundable with fee', 'Allowed with fee', 'Allowed with fee', '$500'),
    (8, 'PREMIUM_ECONOMY', '1 bag free', 'Non-refundable', 'Allowed with fee', 'Allowed with fee', '$400'),
    (9, 'PREMIUM_ECONOMY', '1 bag free', 'Refundable with fee', 'Allowed with fee', 'Allowed with fee', '$600'),
    (10, 'ECONOMY', '1 bag free', 'Non-refundable', 'Allowed with fee', 'Allowed with fee', '$200'),
    (11, 'ECONOMY', '1 bag free', 'Non-refundable', 'Allowed with fee', 'Allowed with fee', '$250'),
    (12, 'ECONOMY', '1 bag free', 'Non-refundable', 'Allowed with fee', 'Allowed with fee', '$300'),
    (13, 'FIRST', '2 bags free', 'Refundable with fee', 'Allowed with fee', 'Allowed with fee', '$1500'),
    (14, 'FIRST', '3 bags free', 'Refundable with fee', 'Allowed with fee', 'Allowed with fee', '$1700'),
    (15, 'FIRST', '2 bags free', 'Refundable with fee', 'Allowed with fee', 'Allowed with fee', '$1400'),
    (16, 'BUSINESS', '2 bags free', 'Refundable with fee', 'Allowed with fee', 'Allowed with fee', '$1200'),
    (17, 'BUSINESS', '3 bags free', 'Refundable with fee', 'Allowed with fee', 'Allowed with fee', '$1400'),
    (18, 'BUSINESS', '2 bags free', 'Refundable with fee', 'Allowed with fee', 'Allowed with fee', '$1100'),
    (19, 'PREMIUM_ECONOMY', '1 bag free', 'Refundable with fee', 'Allowed with fee', 'Allowed with fee', '$800'),
    (20, 'PREMIUM_ECONOMY', '1 bag free', 'Non-refundable', 'Allowed with fee', 'Allowed with fee', '$700');


