-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: my_shop
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `orders_data`
--

DROP TABLE IF EXISTS `orders_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders_data` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'Номер заказа',
  `client_id` int DEFAULT NULL COMMENT 'Идентификатор клиента. Связан с БД user_data',
  `product_id` int DEFAULT NULL COMMENT 'Идентификатор продукта. Связана с БД goods.',
  `product_quantity` int NOT NULL COMMENT 'Кол-во приобретенного товара',
  `order_time` timestamp NOT NULL COMMENT 'Дата и время совершения покупки',
  `order_id` int NOT NULL COMMENT 'Идентификатор заказа',
  PRIMARY KEY (`id`),
  KEY `orders_data_goods_id_fk` (`product_id`),
  KEY `orders_data_user_data_id_fk` (`client_id`),
  CONSTRAINT `orders_data_goods_id_fk` FOREIGN KEY (`product_id`) REFERENCES `goods` (`id`) ON DELETE CASCADE,
  CONSTRAINT `orders_data_user_data_id_fk` FOREIGN KEY (`client_id`) REFERENCES `user_data` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Информация о совершенных покупках';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_data`
--

LOCK TABLES `orders_data` WRITE;
/*!40000 ALTER TABLE `orders_data` DISABLE KEYS */;
INSERT INTO `orders_data` VALUES (1,11,1,2,'2020-04-15 13:17:40',1),(2,11,2,2,'2020-04-15 13:17:40',1),(3,11,4,2,'2020-04-15 15:21:33',2),(4,11,5,2,'2020-04-15 15:21:33',2),(25,11,4,2,'2020-04-17 02:07:21',3),(26,11,1,3,'2020-04-17 02:07:21',3),(27,11,3,1,'2020-04-17 02:07:21',3),(28,11,2,2,'2020-04-17 13:27:38',4),(29,11,5,1,'2020-04-17 13:27:38',4),(30,11,6,1,'2020-04-17 13:27:38',4),(31,11,2,2,'2020-04-17 18:56:20',5),(32,11,5,1,'2020-04-17 18:56:20',5),(33,11,4,1,'2020-04-18 02:24:18',6),(34,11,5,2,'2020-04-18 02:24:18',6),(35,11,6,2,'2020-04-18 02:24:18',6),(36,11,4,1,'2020-04-18 13:59:39',7),(37,11,1,1,'2020-04-18 13:59:39',7),(38,11,4,1,'2020-04-18 14:14:48',8),(39,11,1,1,'2020-04-18 14:14:48',8),(40,11,3,2,'2020-04-18 14:14:48',8),(41,13,4,1,'2020-04-18 14:16:15',9),(42,11,5,1,'2020-04-18 14:40:20',10),(43,11,3,2,'2020-04-18 14:40:20',10),(44,11,4,3,'2020-04-18 17:25:34',11),(45,31,2,3,'2020-04-19 03:28:41',12),(46,31,5,1,'2020-04-19 03:28:41',12);
/*!40000 ALTER TABLE `orders_data` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-19  9:51:51
