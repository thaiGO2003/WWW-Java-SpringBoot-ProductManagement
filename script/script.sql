/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP DATABASE IF EXISTS `productmanagement`;
CREATE DATABASE IF NOT EXISTS `productmanagement` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `productmanagement`;

DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `category` (`id`, `name`) VALUES
	(1, 'Electronics'),
	(2, 'Clothing'),
	(3, 'Groceries');

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `isActive` bit(1) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` varchar(255) NOT NULL,
  `registerDate` date NOT NULL,
  `categoryId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6i3ku5n5njmijfxwv43ktj2ki` (`categoryId`),
  CONSTRAINT `FK6i3ku5n5njmijfxwv43ktj2ki` FOREIGN KEY (`categoryId`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `product` (`id`, `code`, `description`, `isActive`, `name`, `price`, `registerDate`, `categoryId`) VALUES
	(1, 'PROD-001', 'Description for product 1', b'0', 'Product 1', '346.00', '2024-12-20', 3),
	(2, 'PROD-002', 'Description for product 2', b'1', 'Product 2', '376.00', '2024-12-14', 1),
	(3, 'PROD-003', 'Description for product 3', b'0', 'Product 3', '532.00', '2024-12-14', 2),
	(4, 'PROD-004', 'Description for product 4', b'1', 'Product 4', '322.00', '2024-12-14', 1),
	(5, 'PROD-005', 'Description for product 5', b'0', 'Product 5', '860.00', '2024-12-14', 2),
	(6, 'PROD-006', 'Description for product 6', b'1', 'Product 6', '761.00', '2024-11-21', 3),
	(7, 'PROD-007', 'Description for product 7', b'0', 'Product 7', '845.00', '2024-11-21', 2),
	(8, 'PROD-008', 'Description for product 8', b'1', 'Product 8', '122.00', '2024-12-14', 3),
	(9, 'PROD-009', 'Description for product 9', b'0', 'Product 9', '250.00', '2024-12-20', 2),
	(10, 'PROD-010', 'Description for product 10', b'1', 'Product 10', '606.00', '2024-12-14', 3);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
