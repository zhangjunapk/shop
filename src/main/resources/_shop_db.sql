-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: shop_db
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.17.10.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `key_table`
--

drop database if exists 'shop_db';

create database 'shop_db';

use 'shop_db';

DROP TABLE IF EXISTS `key_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `key_table` (
  `cat_id` int(11) DEFAULT NULL,
  `param_name` varchar(20) DEFAULT NULL,
  `_key` varchar(20) DEFAULT NULL,
  `cat_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `key_table`
--

LOCK TABLES `key_table` WRITE;
/*!40000 ALTER TABLE `key_table` DISABLE KEYS */;
INSERT INTO `key_table` VALUES (1,'ram','ram','phone'),(1,'rom','rom','phone'),(1,'screen size','screen size','phone'),(1,'range','range','phone');
/*!40000 ALTER TABLE `key_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `parentID` int(11) DEFAULT NULL,
  `link` varchar(500) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'home elastic',NULL,NULL,'menu'),(2,'shuma',NULL,NULL,'menu'),(3,'computer',NULL,NULL,'menu'),(4,'home thing',NULL,NULL,'menu'),(5,'cloth and more',NULL,NULL,'menu'),(6,'beauty',NULL,NULL,'menu'),(7,'watch zb',NULL,NULL,'menu'),(8,'man cloth outdoor',NULL,NULL,'menu'),(9,'car room',NULL,NULL,'menu'),(10,'toy',NULL,NULL,'menu'),(11,'food specil food',NULL,NULL,'menu'),(12,'flower',NULL,NULL,'menu'),(13,'yybj jsqq',NULL,NULL,'menu'),(14,'pic ebook',NULL,NULL,'menu'),(15,'life travel',NULL,NULL,'menu'),(16,'bt bx',NULL,NULL,'menu'),(17,'az wx',NULL,NULL,'menu'),(18,'phone',2,NULL,NULL),(19,'Operator',2,NULL,NULL),(20,'digital',2,NULL,NULL),(21,'computer',3,NULL,NULL),(22,'office',3,NULL,NULL),(23,'TV',1,NULL,'menu_alert_left'),(24,'cool machine',1,NULL,'menu_alert_left'),(25,'quick pay',1,NULL,'menu_alert_top'),(26,'hometown',1,NULL,'menu_alert_top'),(27,'light tv',23,NULL,NULL),(27,'oled tv',23,NULL,NULL),(28,'light cool machine',24,NULL,NULL);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_param`
--

DROP TABLE IF EXISTS `product_param`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_param` (
  `product_id` int(11) DEFAULT NULL,
  `_key` varchar(20) DEFAULT NULL,
  `_value` varchar(200) DEFAULT NULL,
  `cat_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_param`
--

LOCK TABLES `product_param` WRITE;
/*!40000 ALTER TABLE `product_param` DISABLE KEYS */;
INSERT INTO `product_param` VALUES (1,'ram','8G',1),(1,'rom','128G',1),(1,'name','nokia n9',1),(1,'picLink','http://baidu',1),(1,'price','9999',1),(1,'picLink','http://baidu',1),(2,'screen size','6 inch',1),(2,'range','8mm',1);
/*!40000 ALTER TABLE `product_param` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-06 21:00:48
