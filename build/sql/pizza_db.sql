CREATE DATABASE  IF NOT EXISTS `pizza_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pizza_db`;
-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: pizza_db
-- ------------------------------------------------------
-- Server version   8.0.16
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
--
-- Table structure for table `article`
--
DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `article` (
  `ID_ARTICLE` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(30) DEFAULT NULL,
  `PRIX` decimal(5,2) DEFAULT NULL,
  `CATEGORY` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID_ARTICLE`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `article`
--
LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'4 Fromages',9.50,'Pizza'),(2,'Margherita',8.50,'Pizza'),(3,'Reine',8.50,'Pizza'),(4,'Napolitaine',9.50,'Pizza'),(5,'Romaine',8.95,'Pizza'),(6,'Calzone',9.50,'Pizza'),(7,'HawaÃ¯enne',10.95,'Pizza'),(8,'Pepperoni',9.50,'Pizza'),(9,'Montagnarde',10.95,'Pizza'),(10,'Pollosa',9.50,'Pizza'),(11,'Saumona',10.95,'Pizza'),(12,'Cola',2.95,'Boisson'),(13,'Orangeade',2.95,'Boisson'),(14,'ThÃ© GlacÃ©',2.95,'Boisson'),(15,'Eau ',1.50,'Boisson'),(16,'Limonade',2.95,'Boisson'),(17,'Binouze',5.95,'Boisson'),(18,'Mozza Sticks',3.95,'EntrÃ©e'),(19,'Burrata',3.95,'EntrÃ©e'),(20,'Salade',4.95,'EntrÃ©e'),(21,'Nuggets',3.95,'EntrÃ©e'),(22,'Glace',3.95,'Dessert'),(23,'Beignet',3.95,'Dessert'),(24,'Pancake',3.95,'Dessert'),(25,'Chti\'ramisu',2.95,'Dessert'),(26,'4 Fromages',9.50,'Pizza'),(27,'Margherita',8.50,'Pizza'),(28,'Reine',8.50,'Pizza'),(29,'Napolitaine',9.50,'Pizza'),(30,'Romaine',8.95,'Pizza'),(31,'Calzone',9.50,'Pizza'),(32,'HawaÃ¯enne',10.95,'Pizza'),(33,'Pepperoni',9.50,'Pizza'),(34,'Montagnarde',10.95,'Pizza'),(35,'Pollosa',9.50,'Pizza'),(36,'Saumona',10.95,'Pizza'),(37,'Cola',2.95,'Boisson'),(38,'Orangeade',2.95,'Boisson'),(39,'ThÃ© GlacÃ©',2.95,'Boisson'),(40,'Eau ',1.50,'Boisson'),(41,'Limonade',2.95,'Boisson'),(42,'Binouze',5.95,'Boisson'),(43,'Mozza Sticks',3.95,'EntrÃ©e'),(44,'Burrata',3.95,'EntrÃ©e'),(45,'Salade',4.95,'EntrÃ©e'),(46,'Nuggets',3.95,'EntrÃ©e'),(47,'Glace',3.95,'Dessert'),(48,'Beignet',3.95,'Dessert'),(49,'Pancake',3.95,'Dessert'),(50,'Chti\'ramisu',2.95,'Dessert');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `commande`
--
DROP TABLE IF EXISTS `commande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `commande` (
  `ID_COMMANDE` int(11) NOT NULL AUTO_INCREMENT,
  `DATE_CMD` date DEFAULT NULL,
  `HEURE` time DEFAULT NULL,
  `ID_CLIENT` int(11) DEFAULT NULL,
  `VALIDATION` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID_COMMANDE`),
  KEY `commande_ibfk_1` (`ID_CLIENT`),
  CONSTRAINT `commande_ibfk_1` FOREIGN KEY (`ID_CLIENT`) REFERENCES `custommer` (`ID_CLIENT`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `commande`
--
LOCK TABLES `commande` WRITE;
/*!40000 ALTER TABLE `commande` DISABLE KEYS */;
INSERT INTO `commande` VALUES (1,'2019-09-10','12:00:00',3,0),(2,'2019-09-10','12:03:00',4,0),(3,'2019-09-10','12:05:00',5,0),(4,'2019-09-10','12:13:00',6,0),(5,'2019-09-10','12:40:00',8,0);
/*!40000 ALTER TABLE `commande` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `commande_article`
--
DROP TABLE IF EXISTS `commande_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `commande_article` (
  `ID_COMMANDE_ARTICLE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_COMMANDE` int(11) NOT NULL,
  `ID_ARTICLE` int(11) NOT NULL,
  `ARTICLE_QUANTITY` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_COMMANDE_ARTICLE`),
  KEY `ID_COMMANDE` (`ID_COMMANDE`),
  KEY `ID_ARTICLE` (`ID_ARTICLE`),
  CONSTRAINT `commande_article_ibfk_1` FOREIGN KEY (`ID_COMMANDE`) REFERENCES `commande` (`ID_COMMANDE`),
  CONSTRAINT `commande_article_ibfk_2` FOREIGN KEY (`ID_ARTICLE`) REFERENCES `article` (`ID_ARTICLE`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `commande_article`
--
LOCK TABLES `commande_article` WRITE;
/*!40000 ALTER TABLE `commande_article` DISABLE KEYS */;
INSERT INTO `commande_article` VALUES (1,1,4,1),(2,1,5,1),(3,1,12,1),(4,1,13,1),(5,2,10,1),(6,2,14,1),(7,3,2,1),(8,3,8,3),(9,3,17,4),(10,3,19,2),(11,3,20,1),(12,3,24,2),(13,4,1,1),(14,4,24,1),(15,5,4,2),(16,5,6,2),(17,5,7,1),(18,5,13,6),(19,5,23,4);
/*!40000 ALTER TABLE `commande_article` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `custommer`
--
DROP TABLE IF EXISTS `custommer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `custommer` (
  `ID_CLIENT` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(30) DEFAULT NULL,
  `PRENOM` varchar(30) DEFAULT NULL,
  `ADRESSE` varchar(100) DEFAULT NULL,
  `NUM_TEL` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ID_CLIENT`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `custommer`
--
LOCK TABLES `custommer` WRITE;
/*!40000 ALTER TABLE `custommer` DISABLE KEYS */;
INSERT INTO `custommer` VALUES (3,'Bodin','Coline','29 Rue Bonte Pollet, 59000 Lille','0236152987'),(4,'Becuwe','ClÃ©ment','57 Rue Christophe Colomb, 59800 Lille','0642398521'),(5,'Callenaere','Charles','23 Rue Ferrer, 59155 Faches-Thumesnil','0198763249'),(6,'Machin','Bidule','2 Rue d\'IÃ©na, 59000 Lille','0695301945'),(7,'NoÃ«l','PÃ¨re','91 Rue MassÃ©na, 59800 Lille','3615'),(8,'Robert','Catherine','37 Rue Bonte Pollet, 59000 Lille','0320925755'),(9,'Bodin','Coline','29 Rue Bonte Pollet, 59000 Lille','0236152987'),(10,'Becuwe','ClÃ©ment','57 Rue Christophe Colomb, 59800 Lille','0642398521'),(11,'Callenaere','Charles','23 Rue Ferrer, 59155 Faches-Thumesnil','0198763249'),(12,'Machin','Bidule','2 Rue d\'IÃ©na, 59000 Lille','0695301945'),(13,'NoÃ«l','PÃ¨re','91 Rue MassÃ©na, 59800 Lille','3615'),(14,'Robert','Catherine','37 Rue Bonte Pollet, 59000 Lille','0320925755');
/*!40000 ALTER TABLE `custommer` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `livraison`
--
DROP TABLE IF EXISTS `livraison`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `livraison` (
  `ID_LIVRAISON` int(11) NOT NULL AUTO_INCREMENT,
  `HEURE_DEPART` time DEFAULT NULL,
  `HEURE_CLIENT` time DEFAULT NULL,
  `HEURE_RETOUR` time DEFAULT NULL,
  `VALIDATION` TINYINT(1) NULL,
  `ID_COMMANDE` int(11) DEFAULT NULL,
  `ID_USER` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_LIVRAISON`),
  KEY `ID_COMMANDE` (`ID_COMMANDE`),
  KEY `ID_USER` (`ID_USER`),
  CONSTRAINT `livraison_ibfk_1` FOREIGN KEY (`ID_COMMANDE`) REFERENCES `commande` (`ID_COMMANDE`),
  CONSTRAINT `livraison_ibfk_2` FOREIGN KEY (`ID_USER`) REFERENCES `users` (`ID_USER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `livraison`
--
LOCK TABLES `livraison` WRITE;
/*!40000 ALTER TABLE `livraison` DISABLE KEYS */;
/*!40000 ALTER TABLE `livraison` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `users`
--
DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `ID_USER` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(30) DEFAULT NULL,
  `MDP` varchar(15) DEFAULT NULL,
  `ROLE` VARCHAR(10) NOT NULL DEFAULT 'ROLE_USER',
  PRIMARY KEY (`ID_USER`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `users`
--
LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1, 'Bodin', 'motDePasseAdmin','ROLE_ADMIN'), (2,'Codeville','Codeville1','ROLE_LIVREUR'),(3,'Canard','Canard1','ROLE_FABRIC'),(4,'Becoue','Becoue1','ROLE_LIVREUR'),(5,'Boudin','Boudin1','ROLE_LIVREUR'),(6,'Podevin','Podevin1','ROLE_LIVREUR');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
-- Dump completed on 2019-09-11 12:15:12