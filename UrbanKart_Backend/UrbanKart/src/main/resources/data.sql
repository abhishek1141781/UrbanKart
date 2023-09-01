

INSERT INTO urbankart.categories (`id`,`category_name`,`description`) VALUES (1,'Mobiles','Mobiles & Accessories');
INSERT INTO urbankart.categories (`id`,`category_name`,`description`) VALUES (2,'Laptops','Laptops & Accessories');
INSERT INTO urbankart.categories(`id`,`category_name`,`description`) VALUES (3,'TV & Appliance','TV & Home Entertainment');



INSERT INTO products (`id`,`description`,`exp_date`,`image_path`,`name`,`price`,`stock`,`category_id`) VALUES (1,'Redmi 12C (Royal Blue, 4GB RAM, 64GB Storage) | High Performance Mediatek Helio G85 | Big 17cm(6.71) HD+ Display with 5000mAh(typ) Battery','2023-12-31','images\\redmi12c.jpg','Redmi 12C',10999,150,1);
INSERT INTO products (`id`,`description`,`exp_date`,`image_path`,`name`,`price`,`stock`,`category_id`) VALUES (2,'realme narzo N55 (Prime Blue, 6GB+128GB) 33W Segment Fastest Charging | Super High-res 64MP Primary AI Camera Colour:Prime Blue Size:6 GB Ram + 128 GB Storage','2024-08-31','images\\realmenarzon55.jpg','Realme narzo N55',12999,300,1);
INSERT INTO products (`id`,`description`,`exp_date`,`image_path`,`name`,`price`,`stock`,`category_id`) VALUES (3,'OnePlus Nord CE 2 Lite 5G (Blue Tide, 6GB RAM, 128GB Storage) Size:6GB RAM, 128GB Storage Colour:Blue Tide','2024-08-31','images\\oneplusnordce3.jpg','OnePlus Nord',17999,150,1);
INSERT INTO products (`id`,`description`,`exp_date`,`image_path`,`name`,`price`,`stock`,`category_id`) VALUES (4,'Motorola razr 40 Ultra (Viva Magenta, 8GB RAM, 256GB Storage) | 3.6" External AMOLED Display | 6.9" AMOLED 165Hz Display | 32MP Selfie Camera 30W Colour:Viva Magenta','2025-08-31','images\\motorolarazr.jpg','Motorola razr',79999,150,1);
INSERT INTO products (`id`,`description`,`exp_date`,`image_path`,`name`,`price`,`stock`,`category_id`) VALUES (5,'Apple iPhone 14 Pro (128 GB) - Space Black Colour:Space Black Size:128 GB','2024-08-31','images\\iphone14pro.jpg','iPhone 14 Pro',119999,150,1);


INSERT INTO products (`id`,`description`,`exp_date`,`image_path`,`name`,`price`,`stock`,`category_id`) VALUES (6,'Acer Aspire Lite 11th Gen Intel Core i3 Premium Metal Laptop (8GB RAM/512GB SD/Windows 11 Home) Full HD Display, Metal Body, Steel Gray, 1.59 Kg','2024-08-31','images\\acer.jpg','Acer Aspire Lite',31999,150,2);
INSERT INTO products (`id`,`description`,`exp_date`,`image_path`,`name`,`price`,`stock`,`category_id`) VALUES (7,'Apple 2021 MacBook Pro (14-inch/35.97 cm, M1 Pro chip with 8‑core CPU and 14‑core GPU, 16GB RAM, 512GB SSD) - Space Grey','2025-08-31','images\\MacBookpro.jpg','MacBook Pro',105990,150,2);
INSERT INTO products (`id`,`description`,`exp_date`,`image_path`,`name`,`price`,`stock`,`category_id`) VALUES (8,'ASUS Vivobook Go 14 (2023), AMD Ryzen 3 7320U, 14-inch (35.56 cm) FHD, Thin & Light Laptop (8GB/512GB SSD/Windows 11/Office 2021/Alexa Built-in/Mixed Black/1.38 kg)','2024-08-31','images\\asus.jpg','ASUS Vivobook Go 14',35990,150,2);

INSERT INTO products (`id`,`description`,`exp_date`,`image_path`,`name`,`price`,`stock`,`category_id`) VALUES (9,'LG 80 cm (32 inches) HD Ready Smart LED TV 32LM563BPTC (Dark Iron Gray)','2023-12-31','images\\lg.jpg','LG TV',13490,150,3);
INSERT INTO products (`id`,`description`,`exp_date`,`image_path`,`name`,`price`,`stock`,`category_id`) VALUES (10,'Acer 80 cm (32 inches) Advanced I Series HD Ready Smart LED Google TV (Black)','2024-08-31','images\\acertv.jpg','Acer TV',11999,300,3);
INSERT INTO products (`id`,`description`,`exp_date`,`image_path`,`name`,`price`,`stock`,`category_id`) VALUES (11,'MI 80 cm (32 inches) 5A Series HD Ready Smart Android LED TV L32M7-5AIN (Black)','2024-08-31','images\\mitv.jpg','MI TV',12499,150,3);
INSERT INTO products (`id`,`description`,`exp_date`,`image_path`,`name`,`price`,`stock`,`category_id`) VALUES (12,'All-New Echo Dot (5th Gen, 2023 release) | Smart speaker with Bigger sound, Motion Detection, Temperature Sensor, Alexa and Bluetooth| White Brand: Amazon','2025-08-31','images\\alexa.jpg','Smart Speaker',5499,150,3);
INSERT INTO products (`id`,`description`,`exp_date`,`image_path`,`name`,`price`,`stock`,`category_id`) VALUES (13,'Roku Streaming Stick 4K 2021 | Streaming Device 4K/HDR/Dolby Vision with Roku Voice Remote and TV Controls Brand: Roku','2024-08-31','images\\roku.jpg','Roku Streaming Stick',6998,150,3);

INSERT INTO products (`id`,`description`,`exp_date`,`image_path`,`name`,`price`,`stock`,`category_id`) VALUES (14,'HP Pavilion 14, 12th Gen Intel Core i5-1235U, 14-inch (35.6 cm), FHD, 16GB DDR4, 512GB SSD, Intel Iris Xe graphics Brand: HP','2023-12-31','images\\HP_PAVILION14.jpg','HP Pavilion 14',66990,150,2);
INSERT INTO products (`id`,`description`,`exp_date`,`image_path`,`name`,`price`,`stock`,`category_id`) VALUES (15,'HP Pavilion Gaming 11th Gen Intel Core i5 15.6"(39.6cm) FHD Gaming Laptop (8GB RAM/512GB SSD/RTX 3050 4GB Graphics/144 Hz/B&O/Windows 10','2024-08-31','images\\hppaviliongaming.jpg','HP Pavilion Gaming',64990,300,2);


INSERT INTO urbankart.users (email, first_name, last_name, mobile_number, password, role)
VALUES ('admin@gmail.com', 'Rama', 'Shah', '1234567890', '$2a$10$zPMOkBow0HyzSmvOeHVDdeL7svvmLxFgToDwFwvzOlcHJXM3f3moO', 'ADMIN');


INSERT INTO urbankart.users (email, first_name, last_name, mobile_number, password, role)
VALUES ('customer@gmail.com', 'Shalini', 'Mitra', '9876543210', '$2a$10$zPMOkBow0HyzSmvOeHVDdeL7svvmLxFgToDwFwvzOlcHJXM3f3moO', 'CUSTOMER');
