-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: maintenance_db
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `admin_t`
--

DROP TABLE IF EXISTS `admin_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_username` varchar(45) DEFAULT NULL,
  `admin_password` varchar(45) DEFAULT NULL,
  `admin_company` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Fk_com_idx` (`admin_company`),
  CONSTRAINT `Fk_com` FOREIGN KEY (`admin_company`) REFERENCES `company_t` (`company_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_t`
--

LOCK TABLES `admin_t` WRITE;
/*!40000 ALTER TABLE `admin_t` DISABLE KEYS */;
INSERT INTO `admin_t` VALUES (1,'admin','123456','奥坎');
/*!40000 ALTER TABLE `admin_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_t`
--

DROP TABLE IF EXISTS `company_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(65) NOT NULL,
  `company_info` varchar(2048) DEFAULT NULL,
  `company_address` varchar(45) DEFAULT NULL,
  `company_business` varchar(45) DEFAULT NULL,
  `company_phone` varchar(45) DEFAULT NULL,
  `company_time` date DEFAULT NULL,
  PRIMARY KEY (`id`,`company_name`),
  UNIQUE KEY `company_name_UNIQUE` (`company_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_t`
--

LOCK TABLES `company_t` WRITE;
/*!40000 ALTER TABLE `company_t` DISABLE KEYS */;
INSERT INTO `company_t` VALUES (1,'奥坎','文化影视传媒','北京','文化影视传媒','1501745686','2010-05-06');
/*!40000 ALTER TABLE `company_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `device_t`
--

DROP TABLE IF EXISTS `device_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `device_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `device_id` varchar(45) DEFAULT NULL,
  `device_name` varchar(20) DEFAULT NULL,
  `device_type` varchar(8) DEFAULT NULL COMMENT '类型',
  `device_brand` varchar(45) DEFAULT NULL,
  `device_time` datetime DEFAULT NULL,
  `device_info` varchar(128) DEFAULT NULL,
  `device_company` varchar(45) DEFAULT NULL,
  `device_department` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Device_id_UNIQUE` (`device_id`),
  KEY `Fk_comDe_idx` (`device_company`),
  CONSTRAINT `Fk_comDe` FOREIGN KEY (`device_company`) REFERENCES `company_t` (`company_name`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device_t`
--

LOCK TABLES `device_t` WRITE;
/*!40000 ALTER TABLE `device_t` DISABLE KEYS */;
INSERT INTO `device_t` VALUES (1,'1','E40','笔记本电脑','联想','2012-02-09 00:00:00','备注','奥坎','市场'),(2,'2','DellU270','笔记本电脑','戴尔','2015-06-04 00:00:00','备注','奥坎','市场'),(11,'3','E40','笔记本电脑','联想','2017-08-08 16:00:00','备注','奥坎','销售'),(12,'4','DellU270','笔记本电脑','联想','2017-08-09 16:00:00','备注','奥坎','销售'),(13,'5','E41','笔记本电脑','联想','2017-08-10 16:00:00','备注','奥坎','销售'),(14,'6','DellU271','笔记本电脑','联想','2017-08-11 16:00:00','备注','奥坎','销售'),(15,'7','E42','笔记本电脑','联想','2017-08-12 16:00:00','备注','奥坎','市场'),(18,'8','ASUS0211','台式机','华硕','2020-05-15 16:00:00','ingo','奥坎','');
/*!40000 ALTER TABLE `device_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items_t`
--

DROP TABLE IF EXISTS `items_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `items_id` varchar(45) DEFAULT NULL,
  `items_name` varchar(45) DEFAULT NULL,
  `items_type` varchar(45) DEFAULT NULL,
  `items_brand` varchar(45) DEFAULT NULL,
  `items_count` int(11) DEFAULT NULL,
  `items_info` varchar(128) DEFAULT NULL,
  `items_department` varchar(45) DEFAULT NULL,
  `items_company` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Fk_comItems_idx` (`items_company`),
  CONSTRAINT `Fk_comItems` FOREIGN KEY (`items_company`) REFERENCES `company_t` (`company_name`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items_t`
--

LOCK TABLES `items_t` WRITE;
/*!40000 ALTER TABLE `items_t` DISABLE KEYS */;
INSERT INTO `items_t` VALUES (1,'1','A4打印纸','打印纸','森木',10,'备注','市场','奥坎'),(18,'2','纸杯','办公用品','泰兰德',13,'UpUp','','奥坎');
/*!40000 ALTER TABLE `items_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_t`
--

DROP TABLE IF EXISTS `order_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(45) DEFAULT NULL,
  `order_time` datetime DEFAULT NULL,
  `order_address` varchar(45) DEFAULT NULL,
  `order_deviceName` varchar(45) DEFAULT NULL,
  `order_deviceType` varchar(45) DEFAULT NULL,
  `order_info` varchar(45) DEFAULT NULL,
  `order_status` varchar(2) DEFAULT NULL,
  `order_department` varchar(45) DEFAULT NULL,
  `order_company` varchar(45) NOT NULL,
  `order_submitUser` varchar(45) NOT NULL,
  `order_deviceId` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Fk_comOrd_idx` (`order_company`),
  CONSTRAINT `Fk_comOrd` FOREIGN KEY (`order_company`) REFERENCES `company_t` (`company_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_t`
--

LOCK TABLES `order_t` WRITE;
/*!40000 ALTER TABLE `order_t` DISABLE KEYS */;
INSERT INTO `order_t` VALUES (1,'1','2020-02-01 14:20:00','北京','E40','电脑','屏幕损坏','通过','销售','奥坎','1231','3'),(2,'2','2020-03-01 00:00:00','北京','Dell工作站','电脑','无法进入系统','通过','销售','奥坎','1231','4'),(3,'3','2020-05-06 00:00:00','北京','E41','电脑','屏幕损坏','待审','销售','奥坎','1231','5'),(4,'4','2020-05-06 00:00:00','上海','hp打印机','打印机','不出墨','待审','市场','奥坎','1231',''),(5,'202005190000001','2020-05-18 16:21:10','东楼613','DellU270','笔记本电脑','笔记本键盘无反应','待审','销售','奥坎','1231','4');
/*!40000 ALTER TABLE `order_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supervisor_t`
--

DROP TABLE IF EXISTS `supervisor_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supervisor_t` (
  `super_id` int(11) NOT NULL AUTO_INCREMENT,
  `super_username` varchar(15) DEFAULT NULL,
  `super_password` varchar(45) DEFAULT NULL,
  `super_company` varchar(45) DEFAULT NULL,
  `super_department` varchar(45) DEFAULT NULL,
  `super_phone` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`super_id`),
  KEY `Fk_comSu_idx` (`super_company`),
  CONSTRAINT `Fk_comSu` FOREIGN KEY (`super_company`) REFERENCES `company_t` (`company_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supervisor_t`
--

LOCK TABLES `supervisor_t` WRITE;
/*!40000 ALTER TABLE `supervisor_t` DISABLE KEYS */;
INSERT INTO `supervisor_t` VALUES (1,'1001','123456','奥坎','销售','15474756478'),(2,'1002','123456','奥坎','财务','1234512');
/*!40000 ALTER TABLE `supervisor_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `take_list_t`
--

DROP TABLE IF EXISTS `take_list_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `take_list_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `take_list_list_id` varchar(45) DEFAULT NULL,
  `take_list_id` varchar(45) DEFAULT NULL,
  `take_list_name` varchar(45) DEFAULT NULL,
  `take_list_department` varchar(45) DEFAULT NULL,
  `take_list_time` date DEFAULT NULL,
  `take_list_company` varchar(45) DEFAULT NULL,
  `take_list_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Fk_comList_idx` (`take_list_company`),
  CONSTRAINT `Fk_comList` FOREIGN KEY (`take_list_company`) REFERENCES `company_t` (`company_name`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `take_list_t`
--

LOCK TABLES `take_list_t` WRITE;
/*!40000 ALTER TABLE `take_list_t` DISABLE KEYS */;
INSERT INTO `take_list_t` VALUES (11,'20200513000000','1','A4打印纸','市场','2020-05-13','奥坎','耗材'),(12,'20200513000000','1','E40','市场','2020-05-13','奥坎','设备'),(13,'20200513000001','2','DellU270','市场','2020-05-13','奥坎','设备');
/*!40000 ALTER TABLE `take_list_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_t`
--

DROP TABLE IF EXISTS `user_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_t` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_username` varchar(45) DEFAULT NULL,
  `user_password` varchar(45) DEFAULT NULL,
  `user_phone` varchar(11) DEFAULT NULL,
  `user_company` varchar(45) NOT NULL,
  `user_address` varchar(45) DEFAULT NULL,
  `user_info` varchar(512) DEFAULT NULL,
  `user_department` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `Fk_company_idx` (`user_company`),
  CONSTRAINT `Fk_comUser` FOREIGN KEY (`user_company`) REFERENCES `company_t` (`company_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_t`
--

LOCK TABLES `user_t` WRITE;
/*!40000 ALTER TABLE `user_t` DISABLE KEYS */;
INSERT INTO `user_t` VALUES (1,'1231','123456','1@1','奥坎','China','any','销售');
/*!40000 ALTER TABLE `user_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worker_t`
--

DROP TABLE IF EXISTS `worker_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `worker_t` (
  `id` int(11) NOT NULL,
  `worker_id` varchar(45) DEFAULT NULL,
  `worker_name` varchar(5) DEFAULT NULL,
  `worker_password` varchar(45) DEFAULT NULL,
  `worker_takeTime` int(11) DEFAULT NULL,
  `worker_sex` varchar(1) DEFAULT NULL,
  `worker_age` int(3) DEFAULT NULL,
  `worker_rank` varchar(10) DEFAULT NULL,
  `worker_tcol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worker_t`
--

LOCK TABLES `worker_t` WRITE;
/*!40000 ALTER TABLE `worker_t` DISABLE KEYS */;
/*!40000 ALTER TABLE `worker_t` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-19  0:22:52
