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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'kiet huynh anh','124,london,england','kiethuynh@gamil.com'),(2,'john tony','125,manchester,england','john@gmail.com'),(3,'tom hank','126,liverpool,england','hank@gmail.com'),(4,'peter shine','127,leicester,england','shine@gamil.com'),(5,'jorse perch','342,manchester,england','perch@gamil.com'),(6,'alex king','232,liverpool,england','kingal@gamil.com'),(7,'van berch','290,london,england','berch@gamil.com'),(8,'john tri','245,brighton,england','johntri@gamil.com'),(9,'roberto march','345,london,england','march@gamil.com'),(10,'tom','19,bolton,england','tom@gmail.com'),(12,'david','20,bolton,england','david@gmail.com'),(13,'elizabet','123,manchester,england','e@gmail.com'),(14,'john','180,liverpool,england','john@gmail.com'),(15,'khang nguyen','2,long an,vietname','khang@gmail.com'),(16,'huynh thanh','10,phu nhuan,vietnam','ramata@gmail.com'),(17,'BookStoreManagement','Ho Chi Minh city','bookstore@gmail.com'),(18,'Nguyen Duy Khang','11, New York, Usa','jucember92@gmail.com'),(19,'Tran Trong thuc','ben tre','keaty@gmail.com'),(20,'Nguyen Le Thanh Tam','Tien Giang','Tam@gmail.com'),(22,'Nguyen Thi Thuy Loan','tp hcm','loan@gmail.com'),(23,'Nguyen Duc Dang Khoi','Nha Trang - Khanh Hoa','dbjvbxjvb@gmail.com');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
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
