--Database for habesha cloth online shoping 
--CREATE NEW DATABASE
CREATE DATABASE Online_Shopping;
--CREATE TABLE

CREATE TABLE Customer(
 customer_id INT IDENTITY(1,1) PRIMARY KEY,
 username VARCHAR(200) UNIQUE NOT NULL,
 first_name VARCHAR(200) NOT NULL,
 last_name VARCHAR(200)NOT NULL,
 age INT NOT NULL,
 email VARCHAR(255) UNIQUE NOT NULL,
 customer_password VARBINARY(64) NOT NULL,-- varbinary is used for storing hashed passwords because passwords are typically represented as binary data after being hashed.
 phone_number VARCHAR(50) NOT NULL
 );

 CREATE TABLE customer_Address(
 address_id INT IDENTITY(1,1) PRIMARY KEY,
 customer_id INT FOREIGN KEY(customer_id) REFERENCES Customer(customer_id) ON DELETE CASCADE NOT NULL,
 country  VARCHAR(200),
 city  VARCHAR(200),
 postal_code  VARCHAR(200),
 region  VARCHAR(200),
 );

 CREATE TABLE Catagory(
 catagory_id INT IDENTITY(1,1) PRIMARY KEY,
 catagory_name VARCHAR(200),
 );

 CREATE TABLE Product(
 product_id INT IDENTITY(1,1) PRIMARY KEY,
 catagory_id INT FOREIGN  KEY(catagory_id) REFERENCES Catagory(catagory_id) ON DELETE NO ACTION NOT NULL,
 product_name VARCHAR(200) NOT NULL,
 price DECIMAL NOT NULL,
 image_url VARCHAR(200),
 product_description TEXT NOT NULL,
 created_date DATETIME DEFAULT GETDATE() NOT NULL,
 quantity int NOT NULL,

 );
-- Create the balance table
CREATE TABLE balance (
    AMOUNT INT,
    customer_id INT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id) ON DELETE CASCADE
);

-- Insert values into the balance table
INSERT INTO balance (AMOUNT, customer_id)
VALUES (10000, 1),
       (20000, 2),
       (30000, 3),
       (40000, 4),
       (50000, 5),
       (6000, 6),
       (7000, 7),
       (800000, 8),
       (900000, 9);

 CREATE TABLE Cart(
 cart_id INT IDENTITY(1,1) PRIMARY KEY,
 date_added DATETIME DEFAULT GETDATE() NOT NULL,
 );

 CREATE TABLE Cart_Item(
 Cart_Item_id  INT IDENTITY(1,1) PRIMARY KEY,
 customer_id INT FOREIGN KEY(customer_id) REFERENCES Customer(customer_id) ON DELETE CASCADE NOT NULL,
 product_id INT FOREIGN KEY(product_id) REFERENCES Product(product_id) ON DELETE CASCADE NOT NULL,
 cart_id INT FOREIGN KEY(cart_id) REFERENCES Cart(cart_id) ON DELETE CASCADE NOT NULL,
 quantity INT NOT NULL,
 is_active BIT NOT NULL,
 );

 CREATE TABLE Payment(
 payment_id INT IDENTITY(1,1) PRIMARY KEY,
 customer_id INT FOREIGN KEY(customer_id) REFERENCES Customer(customer_id) ON DELETE CASCADE NOT NULL,
 payment_method  VARCHAR(200) NOT NULL,
 amount_paid Decimal NOT NULL,
 created_at  DATETIME DEFAULT GETDATE() NOT NULL,
 );

 CREATE TABLE Customer_order(
 order_id INT IDENTITY(1,1) PRIMARY KEY,
 customer_id INT FOREIGN KEY(customer_id) REFERENCES Customer(customer_id) ON DELETE NO ACTION NOT NULL,
 payment_id INT FOREIGN KEY(payment_id) REFERENCES Payment(payment_id) ON DELETE NO ACTION NOT NULL,
 order_number VARCHAR(200) NOT NULL,
 first_name VARCHAR(200) NOT NULL,
 last_name  VARCHAR(200) NOT NULL,
 phone_number  VARCHAR(200) NOT NULL,
 email  VARCHAR(200) NOT NULL,
 customer_address  VARCHAR(200) NOT NULL,
 postal_code  VARCHAR(200) NOT NULL,
 country  VARCHAR(200) NOT NULL,
 city  VARCHAR(200) NOT NULL,
 order_total  DECIMAL NOT NULL,
 tax  DECIMAL NOT NULL,
 order_status VARCHAR(200) NOT NULL,
 device_ip VARCHAR(200) NOT NULL,
 is_ordered BIT NOT NULL,
 created_at DATETIME DEFAULT GETDATE() NOT NULL,
 );

 CREATE TABLE Order_product(
 order_product_id INT IDENTITY(1,1) PRIMARY KEY,
 order_id INT FOREIGN KEY (order_id) REFERENCES Customer_order(order_id) ON DELETE CASCADE NOT NULL,
 payment_id INT FOREIGN KEY(payment_id) REFERENCES Payment(payment_id) ON DELETE CASCADE NOT NULL,
 product_id INT FOREIGN KEY(product_id) REFERENCES Product(product_id) ON DELETE CASCADE NOT NULL,
 quantity INT NOT NULL,
 product_price DECIMAL NOT NULL,
 ordered BIT NOT NULL,
 created_at DATETIME DEFAULT GETDATE() NOT NULL,
 );

 CREATE  TABLE Message_form(
  message_id  INT IDENTITY(1,1) PRIMARY KEY,
  sender_first_name VARCHAR(200) NOT NULL,
  sender_last_name VARCHAR(200) NOT NULL,  
  sender_email VARCHAR(255) NOT NULL,
  sender_phone_number VARCHAR(255) NOT NULL,
  message_subject TEXT NOT NULL,
  message_body TEXT NOT NULL
 );




 --- Sample Data Insertion


 --- Customer Sample Data
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('Anabelle', 'Farfoot', 'afarfoot0@geocities.com', '779-840-3804', 31, 'afarfoot0', HASHBYTES('SHA2_256', 'dAFgCKp45WkE'));
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('Freddie', 'Aked', 'faked1@issuu.com', '750-791-3740', 56, 'faked1', HASHBYTES('SHA2_256', 'gVd71jM01EjZ'));
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('Tiler', 'Mitkin', 'tmitkin2@google.de', '380-661-0139', 77, 'tmitkin2',  HASHBYTES('SHA2_256', '0Y0QT5g3jTeC12c'));
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('Dionysus', 'Gilhooley', 'dgilhooley3@imageshack.us', '237-335-7553', 38, 'ojosham3',  HASHBYTES('SHA2_256', 'JjTU5W3yZKRUx19E'));
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('Yuma', 'Weerdenburg', 'yweerdenburg4@odnoklassniki.ru', '378-345-7633', 27,'kguilbert2',HASHBYTES('SHA2_256', 'uIDmV71SL30'));
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('Onofredo', 'Skim', 'oskim5@shinystat.com', '222-432-1744', 31, 'oskim5',  HASHBYTES('SHA2_256', 'xFCKF3G9PX5r3'));
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('Devland', 'Oxbe', 'doxbe6@ox.ac.uk', '302-329-3433', 24, 'doxbe6',  HASHBYTES('SHA2_256', 'Wzk7F1pI'));
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('Horton', 'Persent', 'hpersent7@joomla.org', '368-647-6350', 63, 'hpersent7',  HASHBYTES('SHA2_256', '6T4w16Y0f9'));
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('Jane', 'Espinet', 'jespinet8@baidu.com', '812-751-2427', 25, 'jespinet8',  HASHBYTES('SHA2_256', 'RcVTv0N02XD4J'));
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('Shurlock', 'Capineer', 'scapineer9@trellian.com', '905-154-9978', 67, 'scapineer9',  HASHBYTES('SHA2_256', 'WOBEkYY0mS'));
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('Adele', 'Renshaw', 'arenshawa@wikia.com', '690-486-7238', 21, 'arenshawa',  HASHBYTES('SHA2_256', 'XC94X8W0FUVt3g'));
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('Dosi', 'Cully', 'dcullyb@jalbum.net', '495-948-3741', 68, 'dcullyb',  HASHBYTES('SHA2_256', 'l64RuJrDvTS6X1UK'));
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('Claresta', 'Ritmeyer', 'critmeyerc@mapquest.com', '685-580-3579', 56, 'critmeyerc',  HASHBYTES('SHA2_256', 'JDWmDD0XgC51'));
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('Dorice', 'Gilluley', 'dgilluleyd@liveinternet.ru', '178-434-1125', 31, 'dgilluleyd',  HASHBYTES('SHA2_256', '1Xz6bOw6k'));
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('Gretchen', 'Peyntue', 'gpeyntuee@acquirethisname.com', '994-995-9529', 42, 'gpeyntuee',  HASHBYTES('SHA2_256', 'R1X5PX49T3T5x'));
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('D''arcy', 'Enrrico', 'denrricof@theglobeandmail.com', '681-475-9004', 24, 'denrricof',  HASHBYTES('SHA2_256', '9xJ0i5qbFPKlMf'));
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('Verina', 'Aguirre', 'vaguirreg@prlog.org', '118-105-6888', 63, 'vaguirreg',  HASHBYTES('SHA2_256', '55x75zaaO7'));
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('Clemmy', 'Sinkings', 'csinkingsh@artisteer.com', '626-466-8253', 37, 'csinkingsh',  HASHBYTES('SHA2_256', 'Esobq4xyU4Y'));
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('Kristan', 'Byatt', 'kbyatti@ustream.tv', '421-626-6060', 68, 'kbyatti',  HASHBYTES('SHA2_256', 'Br3QhMJs12'));
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('Corny', 'Ebbett', 'cebbettj@freewebs.com', '197-770-2219', 27, 'cebbettj',  HASHBYTES('SHA2_256', 'pK5,6Ko}'));
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('Herbie', 'Osment', 'hosmentk@canalblog.com', '563-849-2390', 18, 'hosmentk',  HASHBYTES('SHA2_256', 'pK5,6Ko}'));
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('Jaclin', 'Snowding', 'jsnowdingl@unicef.org', '289-802-5264', 57, 'jsnowdingl',  HASHBYTES('SHA2_256', 'pK5,6Ko}'));
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('Tedda', 'Bugge', 'tbuggem@twitpic.com', '297-380-2289', 21, 'tbuggem',  HASHBYTES('SHA2_256', 'pK5,6Ko}'));
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('Bryn', 'Simonassi', 'bsimonassin@newsvine.com', '244-282-3455', 64,  'bdaltrey1',HASHBYTES('SHA2_256', 'pK5,6Ko}'));
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('Barbette', 'Gillanders', 'bgillanderso@imdb.com', '543-487-4509', 26, 'obeacon0', HASHBYTES('SHA2_256', 'pK5,6Ko}'));
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('Marty', 'Kuhle', 'mkuhlep@economist.com', '504-550-1755', 33, 'mkuhlep',  HASHBYTES('SHA2_256', 'pK5,6Ko}'));
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('Sharia', 'Martins', 'smartinsq@mashable.com', '687-900-7771', 61, 'smartinsq',  HASHBYTES('SHA2_256', 'pK5,6Ko}'));
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('Bondy', 'Dransfield', 'bdransfieldr@chron.com', '449-941-6997', 28, 'bdransfieldr',  HASHBYTES('SHA2_256', 'pK5,6Ko}'));
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('Nanni', 'Brodeur', 'nbrodeurs@hubpages.com', '369-515-3702', 25, 'nbrodeurs',  HASHBYTES('SHA2_256', 'pK5,6Ko}'));
insert into Customer (first_name, last_name, email, phone_number, age, username, customer_password) values ('Cyndia', 'Gobbett', 'cgobbettt@theatlantic.com', '537-365-7942', 69, 'cgobbettt',  HASHBYTES('SHA2_256', 'pK5,6Ko}'));



---Customer_Address Sample Data


INSERT INTO Customer_Address (customer_id, country, region, city, postal_code)
VALUES
    (1, 'United States', 'California', 'Los Angeles', '90001'),
    (2, 'United Kingdom', 'England', 'London', 'SW1A 1AA'),
    (3, 'Australia', 'New South Wales', 'Sydney', '2000'),
    (4, 'Canada', 'Quebec', 'Montreal', 'H2X 1Y6'),
    (5, 'Germany', 'Bavaria', 'Munich', '80331'),
    (6, 'France', 'Ile-de-France', 'Paris', '75001'),
    (7, 'India', 'Maharashtra', 'Mumbai', '400001'),
    (8, 'Brazil', 'São Paulo', 'São Paulo', '01000-000'),
    (9, 'China', 'Shanghai', 'Shanghai', '200000'),
    (10, 'Japan', 'Tokyo', 'Tokyo', '100-0001'),
    (11, 'United States', 'New York', 'New York City', '10001'),
    (12, 'Canada', 'British Columbia', 'Vancouver', 'V6B 5J3'),
    (13, 'India', 'Tamil Nadu', 'Chennai', '600001'),
    (14, 'Germany', 'Berlin', 'Berlin', '10178'),
    (15, 'Australia', 'Victoria', 'Melbourne', '3000'),
    (16, 'United Kingdom', 'Scotland', 'Edinburgh', 'EH1 1YZ'),
    (17, 'France', 'Provence-Alpes-Côte d''Azur', 'Marseille', '13001'),
    (18, 'China', 'Beijing', 'Beijing', '100000'),
    (19, 'Japan', 'Osaka', 'Osaka', '530-0001'),
    (20, 'Brazil', 'Rio de Janeiro', 'Rio de Janeiro', '20000-000'),
    (21, 'United States', 'Texas', 'Houston', '77001'),
    (22, 'Canada', 'Alberta', 'Calgary', 'T2P 0L1'),
    (23, 'India', 'Karnataka', 'Bangalore', '560001'),
    (24, 'Germany', 'Hamburg', 'Hamburg', '20095'),
    (25, 'Australia', 'Queensland', 'Brisbane', '4000'),
    (26, 'United Kingdom', 'Wales', 'Cardiff', 'CF10 1NS'),
    (27, 'France', 'Auvergne-Rhône-Alpes', 'Lyon', '69001'),
    (28, 'China', 'Guangdong', 'Guangzhou', '510000'),
    (29, 'Japan', 'Hokkaido', 'Sapporo', '060-0001'),
    (30, 'Brazil', 'Brasília', 'Brasília', '70000-000');



---Catagory Sample Data

INSERT INTO Catagory(catagory_name) 
Values
	('Men'),
	('Women'),
	('Kids');


	


--- Product Sample Data

INSERT INTO product (catagory_id, product_name, price, image_url, product_description, quantity)
VALUES
    (1, 'Azure Blossom Habesha Dress', 2500, 'https://pythonanywhere.com/wensal/azure-dress.jpg', 'A stunning azure blue dress with intricate floral patterns.', 50),
    (2, 'Regal Maroon Habesha Libs', 4000, 'https://pythonanywhere.com/wensal/maroon-libs.jpg', 'Elegant maroon traditional attire for men with a touch of royalty.', 30),
    (3, 'Golden Rays Habesha Robe', 1500, 'https://pythonanywhere.com/wensal/golden-robe.jpg', 'A golden-hued robe that adds a radiant glow to any occasion.', 80),
    (1, 'Serenade of Roses Habesha Gown', 3000, 'https://pythonanywhere.com/wensal/rose-gown.jpg', 'A captivating gown adorned with delicate roses, exuding elegance.', 70),
    (2, 'Vintage Velvet Habesha Suit', 5500, 'https://pythonanywhere.com/wensal/velvet-suit.jpg', 'A classic velvet suit in rich tones, perfect for formal occasions.', 20),
    (3, 'Enchanted Vine Habesha Tunic', 1200, 'https://pythonanywhere.com/wensal/vine-tunic.jpg', 'A charming tunic with intricate vine motifs, showcasing traditional craftsmanship.', 90),
	(1, 'Opulent Opal Habesha Dress', 3500, 'https://pythonanywhere.com/wensal/opal-dress.jpg', 'An opulent dress adorned with shimmering opal embellishments, radiating luxury.', 40),
    (2, 'Timeless Elegance Habesha Robe', 2000, 'https://pythonanywhere.com/wensal/elegance-robe.jpg', 'A timeless robe with intricate details, epitomizing elegance and grace.', 60),
    (3, 'Dazzling Dusk Habesha Kemis', 1800, 'https://pythonanywhere.com/wensal/dazzling-kemis.jpg', 'A dazzling kemis in hues of the setting sun, capturing attention with its radiance.', 85),
    (1, 'Regal Saba Habesha Kemis', 2800, 'https://pythonanywhere.com/wensal/saba-kemis.jpg', 'A regal kemis inspired by the beauty of the Saba region, exuding cultural charm.', 55),
    (2, 'Whispering Jasmine Habesha Gown', 4200, 'https://pythonanywhere.com/wensal/jasmine-gown.jpg', 'A captivating gown with delicate jasmine motifs, evoking a sense of enchantment.', 25),
    (3, 'Harmonious Melody Habesha Robe', 2300, 'https://pythonanywhere.com/wensal/melody-robe.jpg', 'A robe adorned with harmonious musical notes, celebrating the rich cultural heritage.', 75),
    (1, 'Silk Essence Habesha Kemis', 3200, 'https://pythonanywhere.com/wensal/silk-kemis.jpg', 'A kemis crafted from the finest silk, showcasing exquisite craftsmanship and luxury.', 45),
    (2, 'Enigmatic Enchantment Habesha Gown', 4700, 'https://pythonanywhere.com/wensal/enigmatic-gown.jpg', 'An enigmatic gown that captures attention with its alluring design and mystique.', 15),
    (3, 'Ivory Serenade Habesha Robe', 1700, 'https://pythonanywhere.com/wensal/ivory-robe.jpg', 'An ivory-colored robe that serenades with its simplicity and elegance.', 95)
	

--- Cart Sample Data
INSERT INTO Cart (date_added)
VALUES (GETDATE());

--- Cart_Item Sample Data
INSERT INTO Cart_Item (customer_id, product_id, cart_id, quantity, is_active)
VALUES
    (1, 2, 9, 4, 1),
    (2, 8, 10, 7, 0),
    (3, 1, 11, 2, 1),
    (4, 12, 11, 9, 0),
    (5, 15, 8, 6, 1),
    (6, 4, 15, 3, 0),
    (7, 10, 12, 8, 1),
    (8, 6, 6, 5, 0),
    (9, 14, 15, 1, 1),
    (10, 5, 13, 7, 0),
    (11, 3, 7, 2, 1),
    (12, 11, 11, 9, 0),
    (13, 9, 8, 4, 1),
    (14, 7, 10, 6, 0),
    (15, 13, 6, 3, 1),
    (16, 15, 9, 8, 0),
    (17, 1, 12, 2, 1),
    (18, 12, 7, 9, 0),
    (19, 8, 13, 6, 1),
    (20, 5, 8, 4, 0),
    (21, 10, 11, 7, 1),
    (22, 4, 6, 5, 0),
    (23, 14, 16, 2, 1),
    (24, 6, 13, 8, 0),
    (25, 3, 7, 1, 1),
    (26, 11, 11, 9, 0),
    (27, 9, 8, 5, 1),
    (28, 7, 10, 3, 0),
    (29, 13, 6, 6, 1),
    (30, 15, 9, 8, 0),
    (30, 2, 12, 3, 1),
    (20, 8, 14, 6, 0),
    (30, 1, 8, 2, 1),
    (14, 12, 11, 9, 0),
    (25, 15, 7, 6, 1),
    (16, 4, 15, 3, 0),
    (7, 10, 6, 7, 1),
    (18, 6, 10, 4, 0),
    (29, 14, 13, 1, 1),
    (20, 5, 8, 7, 0),
    (1, 3, 12, 2, 1),
    (2, 11, 7, 9, 0),
    (23, 9, 11, 4, 1),
    (14, 7, 10, 6, 0),
    (25, 13, 6, 3, 1),
    (6, 15, 9, 8, 0),
    (7, 1, 14, 2, 1),
    (28, 12, 7, 9, 0),
    (19, 8, 12, 6, 1),
    (20, 5, 8, 4, 0),
    (11, 10, 11, 7, 1),
    (2, 4, 6, 5, 0),
    (23, 14, 16, 2, 1),
    (4, 6, 13, 8, 0),
    (25, 3, 7, 1, 1),
    (16, 11, 11, 9, 0),
    (27, 9, 8, 5, 1),
    (8, 7, 10, 3, 0),
    (29, 13, 6, 6, 1),
    (3, 15, 9, 8, 0);


--- Payment Sample Data
	INSERT INTO Payment (customer_id, payment_method, amount_paid, created_at)
VALUES
    (15, 'Credit Card', 5000.75, '2023-09-20 12:34:56'),
    (10, 'Debit Card', 2500.50, '2023-09-19 08:22:10'),
    (28, 'Bank Transfer', 8000.25, '2023-09-18 16:45:30'),
    (5, 'PayPal', 4000.80, '2023-09-17 14:12:05'),
    (20, 'Credit Card', 6000.35, '2023-09-16 09:55:45'),
    (3, 'Debit Card', 3500.60, '2023-09-15 11:10:20'),
    (12, 'Bank Transfer', 9000.15, '2023-09-14 17:30:00'),
    (7, 'PayPal', 2000.70, '2023-09-13 13:25:40'),
    (25, 'Credit Card', 7000.45, '2023-09-12 10:15:25'),
    (2, 'Debit Card', 4500.55, '2023-09-11 15:40:15'),
    (18, 'Bank Transfer', 9500.10, '2023-09-10 18:20:50'),
    (9, 'PayPal', 3000.90, '2023-09-09 07:55:30'),
    (22, 'Credit Card', 5500.25, '2023-09-08 16:10:10'),
    (6, 'Debit Card', 4000.70, '2023-09-07 11:45:55'),
    (14, 'Bank Transfer', 8500.40, '2023-09-06 09:30:35')


--- sample data to customer ordrer
insert into Customer_order (customer_id, payment_id, order_number, first_name, last_name, phone_number, email, customer_address, postal_code, country, city, order_total, tax, order_status, device_ip, is_ordered, created_at) values (27, 12, '2397-941-79', 'Lia', 'Culley', '503-217-7139', 'lculley0@ustream.tv', '66729 Carberry Lane', '97296', 'United States', 'Portland', 9151.4, 1729.82, 'accepted', '965a:e8f7:39ae:9962:deeb:7b5c:a9e8:960c', 0, '10/22/2022');
insert into Customer_order (customer_id, payment_id, order_number, first_name, last_name, phone_number, email, customer_address, postal_code, country, city, order_total, tax, order_status, device_ip, is_ordered, created_at) values (1, 13, '6968-818-29', 'Lucais', 'Syce', '385-864-5353', 'lsyce1@japanpost.jp', '9865 Eastlawn Park', '4825-171', 'Portugal', 'Guimarei', 8273.81, 2397.85, 'declined', 'af52:5625:791a:7990:ce98:7bf3:cd27:a657', 1, '12/17/2022');
insert into Customer_order (customer_id, payment_id, order_number, first_name, last_name, phone_number, email, customer_address, postal_code, country, city, order_total, tax, order_status, device_ip, is_ordered, created_at) values (9, 8, '6303-096-91', 'Husein', 'Orwin', '173-528-3507', 'horwin2@arizona.edu', '585 Montana Hill', '429174', 'Russia', 'Shemursha', 7365.83, 1211.88, 'accepted', '678b:f926:6697:63e0:6a02:e346:73f3:b7ec', 0, '8/27/2023');
insert into Customer_order (customer_id, payment_id, order_number, first_name, last_name, phone_number, email, customer_address, postal_code, country, city, order_total, tax, order_status, device_ip, is_ordered, created_at) values (5, 9, '0740-817-97', 'Mollee', 'Cushelly', '170-200-9318', 'mcushelly3@nasa.gov', '1 Iowa Court', '4825', 'Chile', 'Longaví', 10129.22, 684.75, 'completed', '9fa3:5ec2:e714:9227:a980:18f4:3388:bddb', 1, '8/13/2023');
insert into Customer_order (customer_id, payment_id, order_number, first_name, last_name, phone_number, email, customer_address, postal_code, country, city, order_total, tax, order_status, device_ip, is_ordered, created_at) values (2, 2, '0967-337-26', 'Trever', 'Lampet', '894-479-2262', 'tlampet4@toplist.cz', '6 Arkansas Center', '171', 'Indonesia', 'Garunggang', 6944.17, 3816.79, 'accepted', 'aecc:91e6:e928:a271:249e:9cab:25e5:cf1e', 1, '3/16/2023');
insert into Customer_order (customer_id, payment_id, order_number, first_name, last_name, phone_number, email, customer_address, postal_code, country, city, order_total, tax, order_status, device_ip, is_ordered, created_at) values (15, 12, '3024-699-50', 'Angel', 'Howgill', '414-621-0980', 'ahowgill5@booking.com', '85193 Aberg Way', '7724', 'Afghanistan', 'Mardīān', 7905.57, 3455.52, 'completed', '20c3:7a87:d71a:61a4:aa11:b590:8361:7a04', 0, '7/10/2023');
insert into Customer_order (customer_id, payment_id, order_number, first_name, last_name, phone_number, email, customer_address, postal_code, country, city, order_total, tax, order_status, device_ip, is_ordered, created_at) values (4, 1, '0441-904-37', 'Brandy', 'Goeff', '266-885-6436', 'bgoeff6@nhs.uk', '9 Graceland Park', '4174', 'Mongolia', 'Manhan', 14647.47, 211.0, 'completed', '1ec9:116:ea7b:b48c:cbd9:9c90:606:4edc', 1, '5/3/2023');
insert into Customer_order (customer_id, payment_id, order_number, first_name, last_name, phone_number, email, customer_address, postal_code, country, city, order_total, tax, order_status, device_ip, is_ordered, created_at) values (1, 3, '4862-208-97', 'Bev', 'Klasen', '778-242-9793', 'bklasen7@washington.edu', '5795 Lunder Avenue', '465213', 'Indonesia', 'Krajan Pundungsari', 3583.3, 3179.18, 'pending', '4c9:1971:9afb:47b5:eecf:73bf:a99f:2ef7', 1, '1/17/2023');
insert into Customer_order (customer_id, payment_id, order_number, first_name, last_name, phone_number, email, customer_address, postal_code, country, city, order_total, tax, order_status, device_ip, is_ordered, created_at) values (3, 10, '2069-152-00', 'Amaleta', 'Leakner', '313-543-8149', 'aleakner8@t.co', '6416 Mcbride Plaza', '589 41', 'Sweden', 'Linköping', 13360.81, 1636.53, 'completed', 'a201:e9f3:1b63:cd3f:ba37:c173:7e82:954d', 1, '5/30/2023');
insert into Customer_order (customer_id, payment_id, order_number, first_name, last_name, phone_number, email, customer_address, postal_code, country, city, order_total, tax, order_status, device_ip, is_ordered, created_at) values (25, 12, '5388-551-38', 'Hewitt', 'Duval', '609-492-7763', 'hduval9@dailymotion.com', '421 Derek Junction', '08695', 'United States', 'Trenton', 2286.71, 2365.31, 'declined', '180f:a58:26e5:56db:9ced:55b2:89eb:cf3', 1, '11/19/2022');
insert into Customer_order (customer_id, payment_id, order_number, first_name, last_name, phone_number, email, customer_address, postal_code, country, city, order_total, tax, order_status, device_ip, is_ordered, created_at) values (29, 2, '6463-853-06', 'Steffane', 'Ruane', '317-581-3099', 'sruanea@miitbeian.gov.cn', '550 Ohio Way', '46278', 'United States', 'Indianapolis', 13607.92, 521.35, 'completed', 'df07:190d:8781:ebcc:107d:e707:5402:f3b7', 1, '2/17/2023');
insert into Customer_order (customer_id, payment_id, order_number, first_name, last_name, phone_number, email, customer_address, postal_code, country, city, order_total, tax, order_status, device_ip, is_ordered, created_at) values (29, 2, '5345-273-91', 'Pasquale', 'Renad', '782-761-3639', 'prenadb@about.me', '76350 Sunnyside Trail', '15645', 'Estonia', 'Kiili', 12112.17, 420.79, 'completed', '29b6:7564:7629:2194:14cb:54f1:50c0:62e7', 0, '8/23/2023');
insert into Customer_order (customer_id, payment_id, order_number, first_name, last_name, phone_number, email, customer_address, postal_code, country, city, order_total, tax, order_status, device_ip, is_ordered, created_at) values (12, 11, '2023-859-46', 'Slade', 'Kyberd', '689-643-0254', 'skyberdc@msn.com', '72840 Farragut Trail', '87969', 'Ecuador', 'Naranjal', 5986.79, 3447.83, 'accepted', 'b0f1:ef45:4554:a841:b00e:2326:d4cc:fc63', 0, '8/27/2023');
insert into Customer_order (customer_id, payment_id, order_number, first_name, last_name, phone_number, email, customer_address, postal_code, country, city, order_total, tax, order_status, device_ip, is_ordered, created_at) values (16, 10, '3119-071-60', 'Roshelle', 'Roache', '241-300-2517', 'rroached@over-blog.com', '91 Dawn Drive', '704038', 'Colombia', 'San Marcos', 4478.56, 4202.97, 'accepted', '7e0b:456b:d48a:9f3c:c7eb:e539:9e24:4a30', 0, '9/3/2023');
insert into Customer_order (customer_id, payment_id, order_number, first_name, last_name, phone_number, email, customer_address, postal_code, country, city, order_total, tax, order_status, device_ip, is_ordered, created_at) values (24, 15, '7408-137-66', 'Dunn', 'Dalgleish', '728-475-1196', 'ddalgleishe@nasa.gov', '148 7th Pass', '8795', 'Vietnam', 'Bảo Lộc', 2589.44, 1656.7, 'declined', 'c8dd:93b5:5d32:5d55:44d6:b07f:7524:86f9', 1, '2/27/2023');



--- sample data to order product
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (12, 6, 8, 14, 5397.1, 0, '8/28/2023');
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (12, 11, 4, 1, 9508.7, 1, '11/21/2022');
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (12, 12, 4, 1, 3330.15, 1, '4/24/2023');
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (12, 15, 9, 9, 3464.16, 0, '10/25/2022');
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (7, 7, 5, 1, 5024.31, 1, '12/4/2022');
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (9, 9, 2, 12, 8886.64, 1, '9/30/2022');
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (14, 9, 13, 7, 9478.37, 1, '8/8/2023');
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (8, 11, 12, 8, 11060.74, 0, '9/21/2022');
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (15, 14, 3, 3, 5383.57, 0, '12/26/2022');
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (14, 7, 1, 14, 6300.11, 1, '9/14/2023');
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (11, 1, 10, 2, 2280.2, 1, '10/21/2022');
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (9, 10, 11, 7, 5102.2, 0, '3/21/2023');
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (12, 12, 9, 1, 12010.2, 1, '12/22/2022');
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (7, 7, 4, 15, 11533.24, 0, '4/26/2023');
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (11, 4, 7, 15, 3184.31, 0, '6/18/2023');
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (13, 14, 5, 5, 6950.0, 1, '1/26/2023');
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (15, 4, 1, 13, 11910.48, 0, '5/16/2023');
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (8, 12, 14, 7, 7043.68, 0, '10/14/2022');
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (11, 9, 14, 2, 11809.29, 0, '6/28/2023');
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (10, 1, 10, 14, 10017.18, 0, '11/12/2022');
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (13, 1, 3, 13, 5926.22, 0, '2/13/2023');
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (13, 2, 9, 10, 11257.32, 0, '4/26/2023');
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (6, 14, 1, 10, 8233.23, 1, '3/3/2023');
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (15, 3, 11, 4, 6700.7, 0, '12/24/2022');
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (6, 2, 8, 7, 3023.01, 1, '2/7/2023');
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (11, 3, 12, 9, 4493.92, 1, '5/29/2023');
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (6, 7, 3, 7, 11883.05, 1, '5/12/2023');
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (15, 7, 7, 6, 9060.82, 1, '4/12/2023');
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (13, 4, 7, 10, 7859.85, 1, '7/16/2023');
insert into Order_product (order_id, payment_id, product_id, quantity, product_price, ordered, created_at) values (12, 13, 11, 14, 10588.69, 0, '10/15/2022');




--- Message_form sample data
insert into Message_form (message_subject, message_body, sender_phone_number, sender_email, sender_last_name, sender_first_name) values ('Feedback', 'Can you provide more information about this item?', '110-120-4027', 'ebowra0@examiner.com', 'Bowra', 'Estell');
insert into Message_form (message_subject, message_body, sender_phone_number, sender_email, sender_last_name, sender_first_name) values ('Order Issue', 'I''m having trouble with the checkout process.', '655-578-1382', 'mmaccallam1@webnode.com', 'MacCallam', 'Michaella');
insert into Message_form (message_subject, message_body, sender_phone_number, sender_email, sender_last_name, sender_first_name) values ('Complaint', 'Thank you for your inquiry!', '497-423-4503', 'hmazin2@constantcontact.com', 'Mazin', 'Hamid');
insert into Message_form (message_subject, message_body, sender_phone_number, sender_email, sender_last_name, sender_first_name) values ('Return Request', 'I love your products!', '409-480-7440', 'ydunlea3@bbb.org', 'Dunlea', 'Yolanda');
insert into Message_form (message_subject, message_body, sender_phone_number, sender_email, sender_last_name, sender_first_name) values ('Complaint', 'Thank you for your inquiry!', '284-446-2889', 'yledford4@usnews.com', 'Ledford', 'Yasmeen');


 --SELECT ALL product data
 SELECT  * FROM Product
 

 --SELECT CUSTOMERS BASED ON THEIR AGE  to select the men and women section 
 SELECT * FROM Customer
 WHERE age>20;


 --select price and quantity column from product table
 SELECT price,quantity FROM Product
 where price<4000 and quantity>3;


 --count of products for each unique price value and includes the product count as well as the corresponding price in the result set. The results are grouped by the "price" column.
 select count(*) as "Counted Product", 
 Product.price
 from  Product 
 group by Product.price


 --select product_name and Order Quantity from Product and Order_product tables respectively
SELECT Product.product_name as "Product Name", 
Order_product.quantity as "Order Quantity"
FROM Product, Order_product
where Product.product_id=Order_product.product_id;

--inner join to retrieve the order_id from the "Customer_order" table and the username from the "Customer" table, where the customer_id matches in both tables.
SELECT Customer_order.order_id ,Customer.username 
FROM Customer_order
INNER JOIN Customer ON Customer_order.customer_id = Customer.customer_id
 

 --select the average quantity, the current date and time, the maximum quantity, and the minimum quantity. The result set will contain these calculated values as separate columns.
select AVG(Product.quantity) 
as "Average Quantity", GETDATE() as "Today",
Max(Product.quantity) as "Max QTY",
min(Product.quantity) as "Min QTY"
from 
Product 


-- select  all columns for the products in the "Product" table that belong to the category with the name 'Women'. 
SELECT *
FROM Product
WHERE catagory_id  = (
    SELECT catagory_id
    FROM Catagory
    WHERE catagory_name = 'Women'
);


/*the view named "OnlineShoppingView" is created. It includes columns such as ProductID, ProductName, Price, CategoryName, CustomerName, and OrderDate. 
It combines data from multiple tables: Products, Categories, OrderDetails, Orders, and Customers.*/
CREATE VIEW OnlineShoppingView AS 
SELECT 
	Product.product_id,
	Product.product_name,
	Product.price,
	Catagory.catagory_name,
	Customer.username,
	Customer_order.created_at
FROM 
	Product
	INNER JOIN Catagory ON Product.catagory_id = Catagory.catagory_id
	INNER JOIN Order_product ON Product.product_id = Order_product.product_id
	INNER JOIN Customer_order ON Order_product.order_id = Customer_order.order_id
	INNER JOIN  Customer ON Customer_order.customer_id=Customer.customer_id;
SELECT *
FROM OnlineShoppingView
WHERE username = 'afarfoot0';


--OrderSummaryView
CREATE VIEW OrderSummaryView AS
SELECT 
	Customer_order.order_id,
	Customer.username,
	Customer_order.created_at,
	SUM(Order_product.quantity) AS TotalQuantity,
	SUM(Order_product.quantity*Product.price) AS TotalAmount
FROM 
	Customer_order
	INNER JOIN Customer ON Customer_order.customer_id = Customer.customer_id
	INNER JOIN Order_product ON Customer_order.order_id= Order_product.order_id
	INNER JOIN Product ON Order_product.product_id=Product.product_id
GROUP BY 
	Customer_order.order_id,
	Customer.username,
	Customer_order.created_at;
SELECT *
FROM OrderSummaryView
WHERE username = 'afarfoot0';


--product summary
CREATE PROCEDURE GetProductSummary
AS
BEGIN
    SELECT COUNT(*) AS TotalProducts,
           AVG(price) AS AveragePrice,
           MAX(price) AS MaxPrice,
           MIN(price) AS MinPrice
    FROM Product
END
--product summary using GetProductSummary PROCEDURE
EXEC GetProductSummary


--product detail 
CREATE PROCEDURE GetProductDetails
	@product_id INT
AS 
BEGIN
	SELECT 
		product_id,
		product_name,
		price,
		product_description
	FROM 
		Product
	WHERE product_id=@product_id;
END;
--product detail  using GetProductDetails PROCEDURE
EXECUTE GetProductDetails @product_id = 1;


--add product
CREATE PROCEDURE InsertProduct
    @product_name VARCHAR(100),
    @price DECIMAL(10, 2),
    @product_description TEXT,
    @catagory_id  INT,
	@image_url   VARCHAR(200),
	@quantity INT

AS
BEGIN
    INSERT INTO Product (product_name, price, product_description,catagory_id,image_url,quantity )
    VALUES (@product_name, @price, @product_description,@catagory_id,@image_url,@quantity);
END;

--add product using InsertProduct PROCEDURE
EXECUTE InsertProduct
    @product_name = 'Golden Charm Habesha Set',
    @price = 4800,
    @product_description = 'An elegant golden Habesha set with intricate details and charm.',
    @catagory_id = 2,
	@image_url="https://pythonanywhere.com/wensal/golden-charm-set.jpg",
	@quantity=30;


--update product
CREATE PROCEDURE UpdateProduct
	@product_id INT,
    @product_name VARCHAR(100),
    @price DECIMAL(10, 2),
    @product_description TEXT,
    @catagory_id INT,
    @image_url VARCHAR(200),
	@quantity INT
AS
BEGIN
    UPDATE Product
    SET
        product_name  = @product_name,
        price = @price,
        product_description = @product_description,
        catagory_id =@catagory_id,
        image_url = @image_url,
		quantity = @quantity
    WHERE
         product_id = @product_id;
END;

--upadte product using UpdateProduct PROCEDURE
EXECUTE UpdateProduct
	@product_id =14 ,
    @product_name = 'Fantastic Enchantment Habesha Gown',
    @price = 4700,
    @product_description = 'A Fantastic gown that captures attention with its alluring design and mystique.',
    @catagory_id = 2,
    @image_url = 'https://pythonanywhere.com/wensal/enigmatic-gown.jpg',
	@quantity = 13;

--delete product
CREATE PROCEDURE DeleteProduct
    @product_id INT
AS
BEGIN
    DELETE FROM Product
    WHERE product_id = @product_id;f
END;

--delete product using DeleteProduct PROCEDURE
EXECUTE DeleteProduct
    @product_id = 17;

--add to cart item 
CREATE PROCEDURE AddCartItem
(
    @customer_id INT,
    @product_id INT,
    @cart_id INT,
    @quantity INT,
    @is_active BIT
)
AS
BEGIN
    INSERT INTO Cart_Item (customer_id, product_id, cart_id, quantity, is_active)
    VALUES (@customer_id, @product_id, @cart_id, @quantity, @is_active)
END

-- add to cart item  using AddCartItem PROCEDURE
EXEC AddCartItem @customer_id = 1, @product_id = 18, @cart_id = 1, @quantity = 1, @is_active = 1


--A transaction scenario involves a transaction where an order is processed, payment is recorded, and the quantity of a specific product is decremented. 
BEGIN TRANSACTION;
-- Step 1: Create an order
DECLARE @order_id INT;
INSERT INTO Customer_order (customer_id, payment_id, order_number, first_name, last_name, phone_number, email, customer_address, postal_code, country, city, order_total, tax, order_status, device_ip, is_ordered, created_at)
VALUES (1, 1, 1, 'sale', 'sale', '0978', 'wend',
        'qr123', '1123', 'eth', 'ada', 30000, 23, 'accepted', '126', 0, GETDATE());
SET @order_id = SCOPE_IDENTITY();

-- Step 2: Process payment
DECLARE @payment_id INT;

INSERT INTO Payment (customer_id, payment_method, amount_paid , created_at)
VALUES (1, 'paybal', 5000, GETDATE());

SET @payment_id = SCOPE_IDENTITY();

-- Step 3: Update the payment ID in the order
UPDATE Customer_order
SET payment_id = @payment_id
WHERE order_id = @order_id;

-- Step 4: Decrement the quantity of the product
DECLARE @productID INT = 1; -- Specify the ID of the product you want to decrement the quantity
DECLARE @quantity_decrement INT = 1; -- Specify the quantity to decrement
UPDATE Product
SET quantity = quantity - @quantity_decrement
WHERE product_id = @productID;
COMMIT TRANSACTION;


-- Create the trigger to prevent totalamount update
CREATE TRIGGER prevent_totalamount_update
ON Customer_order
AFTER UPDATE
AS
BEGIN
    IF EXISTS (
        SELECT 1
        FROM inserted i
        JOIN deleted d ON i.order_id = d.order_id
        WHERE i.created_at IS NOT NULL
    )
    BEGIN
        RAISERROR ('TotalAmount cannot be updated after the order has been placed.', 16, 1);
        ROLLBACK;
    END;
END;

-- Attempt to update the TotalAmount column
UPDATE Customer_order
SET order_total = 75.00
WHERE order_id = 1;

EXEC sp_addlogin 'customer_1', '123', 'Online_Shopping'
GRANT SELECT, INSERT, UPDATE, DELETE ON Product TO customer1;
GRANT SELECT ON Catagory TO customer1;
GRANT SELECT ON Customer_order TO customer1;

EXEC sp_addlogin 'Administrator', '1234', 'Online_Shopping'
-- Administrator role permissions
GRANT SELECT, INSERT, UPDATE, DELETE ON Product TO Administrator;
GRANT SELECT, INSERT, UPDATE, DELETE ON Catagory TO Administrator;
GRANT SELECT, INSERT, UPDATE, DELETE ON Customer_order TO Administrator;

EXEC sp_addlogin 'WarehouseStaff', '1234', 'Online_Shopping'
-- WarehouseStaff role permissions
GRANT UPDATE ON Product TO WarehouseStaff;
GRANT UPDATE ON Customer_order TO WarehouseStaff;

EXEC sp_addlogin 'CustomerSupport', '12345', 'Online_Shopping'
-- CustomerSupport role permissions
GRANT SELECT, UPDATE ON Customer TO CustomerSupport;
GRANT SELECT, UPDATE ON Customer_order TO CustomerSupport;
GRANT SELECT, UPDATE ON Message_form TO CustomerSupport;
