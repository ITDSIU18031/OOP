-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bookstore
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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `role` varchar(8) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `account_ibfk_1` FOREIGN KEY (`id`) REFERENCES `customer` (`id`),
  CONSTRAINT `account_chk_1` CHECK ((`role` in (_utf8mb4'Customer',_utf8mb4'Staff')))
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'kiethuynh','000fich2d351g9881i092ag48600fea8','Customer'),(2,'johntony','000i6icga0g3b9a065fb69g3f9bjifde','Customer'),(3,'tomhatch','000fich2d351g9881i092ag48600fea8','Customer'),(4,'petershine','000fich2d351g9881i092ag48600fea8','Customer'),(5,'jorseperch','000fich2d351g9881i092ag48600fea8','Customer'),(6,'alexking','000fich2d351g9881i092ag48600fea8','Customer'),(7,'vanberg','000fich2d351g9881i092ag48600fea8','Customer'),(8,'johntri','000fich2d351g9881i092ag48600fea8','Customer'),(9,'david','000fich2d351g9881i092ag48600fea8','Customer'),(10,'tom','000fich2d351g9881i092ag48600fea8','Customer'),(12,'david','000fich2d351g9881i092ag48600fea8','Customer'),(13,'elizabet','000fich2d351g9881i092ag48600fea8','Customer'),(14,'john','000fich2d351g9881i092ag48600fea8','Customer'),(16,'ramata','005b8e4hd003d7g13d21gahai4h2ei7i','Customer'),(17,'admin','0000fb0fd73gej6564e1h462h3f7224g','Staff'),(18,'Khang','003461f81e5gbj520i27djdbdd8ja31h','Customer'),(19,'kattyPrery','0034c5e2f03ca734i98ccb4ai9g0c4ff','Customer'),(20,'ThanhTam','005b8e4hd003d7g13d21gahai4h2ei7i','Customer'),(22,'nttloan','003461f81e5gbj520i27djdbdd8ja31h','Customer'),(23,'khoi','000fich2d351g9881i092ag48600fea8','Customer');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-23 15:43:42
