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
-- Temporary view structure for view `reportbill`
--

DROP TABLE IF EXISTS `reportbill`;
/*!50001 DROP VIEW IF EXISTS `reportbill`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `reportbill` AS SELECT 
 1 AS `id`,
 1 AS `name`,
 1 AS `total`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `value`
--

DROP TABLE IF EXISTS `value`;
/*!50001 DROP VIEW IF EXISTS `value`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `value` AS SELECT 
 1 AS `isbn`,
 1 AS `title`,
 1 AS `price`,
 1 AS `realprice`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `report`
--

DROP TABLE IF EXISTS `report`;
/*!50001 DROP VIEW IF EXISTS `report`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `report` AS SELECT 
 1 AS `ISBN`,
 1 AS `title`,
 1 AS `genre`,
 1 AS `price`,
 1 AS `year`,
 1 AS `amount`,
 1 AS `discount_id`,
 1 AS `publisher_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `document`
--

DROP TABLE IF EXISTS `document`;
/*!50001 DROP VIEW IF EXISTS `document`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `document` AS SELECT 
 1 AS `ISBN`,
 1 AS `title`,
 1 AS `genre`,
 1 AS `price`,
 1 AS `year`,
 1 AS `amount`,
 1 AS `discount_id`,
 1 AS `publisher_name`,
 1 AS `authorname`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `soldout`
--

DROP TABLE IF EXISTS `soldout`;
/*!50001 DROP VIEW IF EXISTS `soldout`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `soldout` AS SELECT 
 1 AS `title`,
 1 AS `sum(contain.amount)`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `reportbill`
--

/*!50001 DROP VIEW IF EXISTS `reportbill`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `reportbill` AS select `customer`.`id` AS `id`,`customer`.`name` AS `name`,sum(`contain`.`cost`) AS `total` from ((`bill` join `customer`) join `contain`) where ((`bill`.`id` = `contain`.`billid`) and (`bill`.`customer_id` = `customer`.`id`)) group by `customer`.`name` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `value`
--

/*!50001 DROP VIEW IF EXISTS `value`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `value` AS select `book`.`ISBN` AS `isbn`,`book`.`title` AS `title`,`book`.`price` AS `price`,(`book`.`price` * (1 - `discount`.`percentage`)) AS `realprice` from (`book` join `discount`) where (`book`.`discount_id` = `discount`.`id`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `report`
--

/*!50001 DROP VIEW IF EXISTS `report`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `report` AS select `book`.`ISBN` AS `ISBN`,`book`.`title` AS `title`,`book`.`genre` AS `genre`,`book`.`price` AS `price`,`book`.`year` AS `year`,`book`.`amount` AS `amount`,`book`.`discount_id` AS `discount_id`,`book`.`publisher_name` AS `publisher_name` from `book` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `document`
--

/*!50001 DROP VIEW IF EXISTS `document`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `document` AS select `book`.`ISBN` AS `ISBN`,`book`.`title` AS `title`,`book`.`genre` AS `genre`,`book`.`price` AS `price`,`book`.`year` AS `year`,`book`.`amount` AS `amount`,`book`.`discount_id` AS `discount_id`,`book`.`publisher_name` AS `publisher_name`,`writtenby`.`authorname` AS `authorname` from (`book` join `writtenby` on((`book`.`ISBN` = `writtenby`.`isbn`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `soldout`
--

/*!50001 DROP VIEW IF EXISTS `soldout`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `soldout` AS select `book`.`title` AS `title`,sum(`contain`.`amount`) AS `sum(contain.amount)` from (`book` join `contain`) where (`book`.`ISBN` = `contain`.`isbn`) group by `book`.`title` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-23 15:43:44
