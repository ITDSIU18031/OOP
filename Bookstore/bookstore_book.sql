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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `ISBN` int NOT NULL AUTO_INCREMENT,
  `title` varchar(40) DEFAULT NULL,
  `genre` varchar(15) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `year` int DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `discount_id` int DEFAULT NULL,
  `publisher_name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`ISBN`),
  KEY `publisher_name` (`publisher_name`),
  KEY `discount_id` (`discount_id`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`publisher_name`) REFERENCES `publisher` (`name`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `book_ibfk_2` FOREIGN KEY (`discount_id`) REFERENCES `discount` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `book_chk_1` CHECK ((`amount` >= 0))
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'doremon epsion 1','animate',20,2000,100,1,'tokyo jp'),(2,'doremon epsion 2','animate',20,2000,100,1,'tokyo jp'),(3,'doremon epsion 3','animate',20,2000,100,1,'tokyo jp'),(4,'doremon epsion 4','animate',20,2000,100,1,'tokyo jp'),(5,'doremon epsion 5','animate',20,2000,100,1,'tokyo jp'),(6,'doremon epsion 6','animate',20,2000,100,1,'tokyo jp'),(7,'doremon epsion 7','animate',20,2000,100,1,'tokyo jp'),(8,'doremon epsion 8','animate',20,2000,100,1,'tokyo jp'),(9,'doremon epsion 9','animate',20,2000,100,1,'tokyo jp'),(10,'doremon epsion 10','animate',20,2000,100,1,'tokyo jp'),(11,'pokemon epsion 1','animate',30,2000,100,1,'tokyo jp'),(12,'pokemon epsion 2','animate',30,2000,79,1,'tokyo jp'),(13,'pokemon epsion 3','animate',30,2000,100,1,'tokyo jp'),(14,'pokemon epsion 4','animate',30,2000,100,1,'tokyo jp'),(15,'pokemon epsion 5','animate',30,2000,100,1,'tokyo jp'),(16,'pokemon epsion 6','animate',30,2000,100,1,'tokyo jp'),(17,'pokemon epsion 7','animate',30,2000,100,1,'tokyo jp'),(18,'pokemon epsion 8','animate',30,2000,100,1,'tokyo jp'),(19,'pokemon epsion 9','animate',30,2000,99,1,'tokyo jp'),(20,'pokemon epsion 10','animate',30,2000,100,1,'tokyo jp'),(21,'naruto epsion 1','animate',25,2003,99,1,'animate3d'),(22,'naruto epsion 2','animate',25,2003,100,1,'animate3d'),(23,'naruto epsion 3','animate',25,2003,100,1,'animate3d'),(24,'naruto epsion 4','animate',25,2003,100,1,'animate3d'),(25,'naruto epsion 5','animate',25,2003,100,1,'animate3d'),(26,'naruto epsion 6','animate',25,2003,100,1,'animate3d'),(27,'naruto epsion 7','animate',25,2003,95,1,'animate3d'),(28,'naruto epsion 8','animate',25,2003,100,1,'animate3d'),(29,'naruto epsion 9','animate',25,2003,99,1,'animate3d'),(30,'naruto epsion 10','animate',25,2003,100,1,'animate3d'),(31,'onepiece epsion 1','animate',30,2003,98,1,'ghibi'),(32,'onepiece epsion 2','animate',30,2003,100,1,'ghibi'),(33,'onepiece epsion 3','animate',30,2003,100,1,'ghibi'),(34,'onepiece epsion 4','animate',30,2003,100,1,'ghibi'),(35,'onepiece epsion 5','animate',30,2003,100,1,'ghibi'),(36,'onepiece epsion 6','animate',30,2003,100,1,'ghibi'),(37,'onepiece epsion 7','animate',30,2003,100,1,'ghibi'),(38,'onepiece epsion 8','animate',30,2003,100,1,'ghibi'),(39,'onepiece epsion 9','animate',30,2003,100,1,'ghibi'),(40,'onepiece epsion 10','animate',30,2003,99,1,'ghibi'),(41,'harry potter and dark','fiction',100,2005,80,2,'the witch'),(42,'harry potter and treasure','fiction',100,2005,191,2,'the witch'),(43,'harry potter and magic island','fiction',200,2007,296,2,'the witch'),(44,'head first java','program',200,2009,100,3,'orelily'),(45,'head first c#','program',200,2009,100,3,'orelily'),(46,'head first html','program',200,2009,100,3,'orelily'),(47,'intro algorithm','academic',100,2010,100,4,'academic'),(48,'dive into algorithm','academic',150,2013,200,5,'academic'),(49,'basic algorithm','academic',150,2014,100,4,'academic'),(50,'tony morning','softskill',120,2012,238,6,'economic'),(51,'how to start up','economic',150,2012,234,3,'economic'),(52,'investigate properly','economic',150,2015,238,4,'economic'),(53,'analyze economic','economic',170,2016,200,6,'economic'),(54,'viet cuisine ','food',100,2012,90,4,'the taste'),(55,'100 traditional food in viet ','food',100,2013,109,6,'the taste'),(58,'shin pencil boy','animate',50,1999,20,6,'ghibi'),(59,'shin pencil boy 2','animate',80,2001,25,2,'ghibi'),(60,'shin pencil boy3','animate',200,2002,197,2,'ghibi');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-23 15:43:43
