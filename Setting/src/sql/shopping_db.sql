SET foreign_key_checks = 0;
DROP TABLE IF EXISTS `Customer`;

CREATE TABLE `Customer` (
`customer_num` int NOT NULL AUTO_INCREMENT,
`customer_id` varchar(20) NOT NULL,
`customer_pw` varchar(30) NOT NULL,
`customer_nick` varchar(20) NOT NULL,
`customer_name` varchar(20) NOT NULL,
`customer_birth` date NOT NULL,
`customer_email` varchar(30) DEFAULT NULL,
`customer_date` date NOT NULL,
PRIMARY KEY (`customer_num`)
);

DROP TABLE IF EXISTS `Seller`;

CREATE TABLE `Seller` (
`seller_num` int NOT NULL,
`seller_represent` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
`seller_phone` varchar(20) NOT NULL,
`seller_email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
`seller_registnum` varchar(20) NOT NULL,
`seller_regdate` date DEFAULT NULL,
`seller_stat` varchar(10) NOT NULL,
`seller_appdate` date DEFAULT NULL,
`seller_name` varchar(20) NOT NULL,
PRIMARY KEY (`seller_num`),
FOREIGN KEY (`seller_num`) REFERENCES `Customer` (`customer_num`) ON DELETE CASCADE
);

DROP TABLE IF EXISTS `Category`;

CREATE TABLE `Category` (
`category_num` int NOT NULL AUTO_INCREMENT,
`category_name` varchar(20) NOT NULL,
PRIMARY KEY (`category_num`)
);

DROP TABLE IF EXISTS `Product`;

CREATE TABLE `Product` (
`product_num` int NOT NULL AUTO_INCREMENT,
`product_image` longblob NOT NULL,
`product_name` varchar(40) NOT NULL,
`product_date` date NOT NULL,
`product_price` int NOT NULL,
`product_stock` int NOT NULL,
`product_stat` varchar(10) NOT NULL,
`product_cunum` int NOT NULL,
`product_canum` int NOT NULL,
PRIMARY KEY (`product_num`),
KEY `FK_Category_TO_Product_1` (`product_canum`),
KEY `FK_Seller_TO_Product_1` (`product_cunum`),
FOREIGN KEY (`product_canum`) REFERENCES `Category` (`category_num`),
FOREIGN KEY (`product_cunum`) REFERENCES `Seller` (`seller_num`) ON DELETE CASCADE
);

DROP TABLE IF EXISTS `ShoppingBasket`;

CREATE TABLE `ShoppingBasket` (
`sb_cunum` int NOT NULL,
`sb_count` int NOT NULL,
`sb_prnum` int NOT NULL,
KEY `FK_Custommer_TO_ShoppingBasket_1_idx` (`sb_cunum`),
KEY `FK_Product_TO_ShoppingBasket_1` (`sb_prnum`),
FOREIGN KEY (`sb_cunum`) REFERENCES `Customer` (`customer_num`) ON DELETE CASCADE,
FOREIGN KEY (`sb_prnum`) REFERENCES `Product` (`product_num`) ON DELETE CASCADE
);

DROP TABLE IF EXISTS `Order`;

CREATE TABLE `Order` (
`order_num` varchar(15) NOT NULL,
`order_orderer` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
`order_phonenum` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
`order_address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
`order_request` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
`order_desireddate` date NOT NULL,
`order_cunum` int NOT NULL,
`order_date` date NOT NULL,
PRIMARY KEY (`order_num`),
KEY `FK_Custommer_TO_Order_1` (`order_cunum`),
FOREIGN KEY (`order_cunum`) REFERENCES `Customer` (`customer_num`) ON DELETE CASCADE
);

DROP TABLE IF EXISTS `OrderProduct`;

CREATE TABLE `OrderProduct` (
`orpd_ornum` varchar(15) NOT NULL,
`orpd_count` int NOT NULL,
`orpd_stat` varchar(10) NOT NULL,
`orpd_prnum` int NOT NULL,
KEY `FK_orpd_num_TO_OrderProduct_1_idx` (`orpd_ornum`),
KEY `FK_Product_TO_OrderProduct_1` (`orpd_prnum`),
FOREIGN KEY (`orpd_ornum`) REFERENCES `Order` (`order_num`) ON DELETE CASCADE,
FOREIGN KEY (`orpd_prnum`) REFERENCES `Product` (`product_num`) ON DELETE CASCADE
);

DROP TABLE IF EXISTS `Review`;

CREATE TABLE `Review` (
`review_num` int NOT NULL AUTO_INCREMENT,
`review_post` varchar(200) DEFAULT NULL,
`review_date` date NOT NULL,
`review_star` int NOT NULL,
`review_prnum` int NOT NULL,
`review_cunum` int NOT NULL,
PRIMARY KEY (`review_num`),
KEY `FK_Custommer_TO_Review_1` (`review_cunum`),
KEY `FK_Product_TO_Review_1` (`review_prnum`),
FOREIGN KEY (`review_cunum`) REFERENCES `Customer` (`customer_num`) ON DELETE CASCADE,
FOREIGN KEY (`review_prnum`) REFERENCES `Product` (`product_num`) ON DELETE CASCADE
);
SET foreign_key_checks = 1;