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
-- Table structure for table `writtenby`
--

DROP TABLE IF EXISTS `writtenby`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `writtenby` (
  `isbn` int DEFAULT NULL,
  `authorname` varchar(40) DEFAULT NULL,
  KEY `isbn` (`isbn`),
  KEY `authorname` (`authorname`),
  CONSTRAINT `writtenby_ibfk_1` FOREIGN KEY (`isbn`) REFERENCES `book` (`ISBN`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `writtenby_ibfk_2` FOREIGN KEY (`authorname`) REFERENCES `author` (`fullname`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `writtenby`
--

LOCK TABLES `writtenby` WRITE;
/*!40000 ALTER TABLE `writtenby` DISABLE KEYS */;
INSERT INTO `writtenby` VALUES (44,'kathy sierra'),(44,'bert bates'),(45,'andrew stellman'),(45,'jenifer grenne'),(46,'eric freeman'),(46,'elisabeth freeman'),(1,'fujio fujiko'),(2,'fujio fujiko'),(3,'fujio fujiko'),(4,'fujio fujiko'),(5,'fujio fujiko'),(6,'fujio fujiko'),(7,'fujio fujiko'),(8,'fujio fujiko'),(9,'fujio fujiko'),(10,'fujio fujiko'),(11,'satoshi'),(12,'satoshi'),(13,'satoshi'),(14,'satoshi'),(15,'satoshi'),(16,'satoshi'),(17,'satoshi'),(18,'satoshi'),(19,'satoshi'),(20,'satoshi'),(31,'oda eiichiro'),(32,'oda eiichiro'),(33,'oda eiichiro'),(34,'oda eiichiro'),(35,'oda eiichiro'),(36,'oda eiichiro'),(37,'oda eiichiro'),(38,'oda eiichiro'),(39,'oda eiichiro'),(40,'oda eiichiro'),(41,'j.k.rowling'),(42,'j.k.rowling'),(43,'j.k.rowling'),(21,'kishimoto masashi'),(22,'kishimoto masashi'),(23,'kishimoto masashi'),(24,'kishimoto masashi'),(25,'kishimoto masashi'),(26,'kishimoto masashi'),(27,'kishimoto masashi'),(28,'kishimoto masashi'),(29,'kishimoto masashi'),(30,'kishimoto masashi'),(47,'adnan aziz'),(47,'bert bates'),(48,'henrich robson'),(49,'john hack'),(49,'kevin wayne'),(50,'thomas corman'),(51,'eric freeman'),(52,'kevin wayne'),(53,'adnan aziz'),(54,'christ ha'),(55,'christ ha');
/*!40000 ALTER TABLE `writtenby` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-23 15:43:44
