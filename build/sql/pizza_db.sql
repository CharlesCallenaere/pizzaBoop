CREATE DATABASE  IF NOT EXISTS `pizza_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pizza_db`;
-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: pizza_db
-- ------------------------------------------------------
-- Server version	8.0.16

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
  `IMAGE` varchar(100) DEFAULT NULL,
  `NOM` varchar(30) DEFAULT NULL,
  `PRIX` decimal(5,2) DEFAULT NULL,
  `IDCATEGORY` int(11) NOT NULL,
  PRIMARY KEY (`ID_ARTICLE`),
  KEY `category_article_fk_idx` (`IDCATEGORY`),
  CONSTRAINT `category_article_fk` FOREIGN KEY (`IDCATEGORY`) REFERENCES `category_article` (`IDCATEGORY`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'/img/pizza.jpg','4 Fromages',9.50,2),(2,'/img/pizza.jpg','Margherita',8.50,2),(3,'/img/pizza.jpg','Reine',8.50,2),(4,'/img/pizza.jpg','Napolitaine',9.50,2),(5,'/img/pizza.jpg','Romaine',8.95,2),(6,'/img/pizza.jpg','Calzone',9.50,2),(7,'/img/pizza.jpg','Hawaïenne',10.95,2),(8,'/img/pizza.jpg','Pepperoni',9.50,2),(9,'/img/pizza.jpg','Montagnarde',10.95,2),(10,'/img/pizza.jpg','Pollosa',9.50,2),(11,'/img/pizza.jpg','Saumona',10.95,2),(12,'/img/aqua.jpg','Cola',2.95,4),(13,'/img/aqua.jpg','Orangeade',2.95,4),(14,'/img/aqua.jpg','Thé Glacé',2.95,4),(15,'/img/aqua.jpg','Eau ',1.50,4),(16,'/img/aqua.jpg','Limonade',2.95,4),(17,'/img/aqua.jpg','Binouze',5.95,4),(18,'/img/salade.jpg','Mozza Sticks',3.95,1),(19,'/img/salade.jpg','Burrata',3.95,1),(20,'/img/salade.jpg','Salade',4.95,1),(21,'/img/salade.jpg','Nuggets',3.95,1),(22,'/img/cake.jpg','Glace',3.95,3),(23,'/img/cake.jpg','Beignet',3.95,3),(24,'/img/cake.jpg','Pancake',3.95,3),(25,'/img/cake.jpg','Chti\'ramisu',2.95,3);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_article`
--

DROP TABLE IF EXISTS `category_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `category_article` (
  `IDCATEGORY` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(45) NOT NULL,
  PRIMARY KEY (`IDCATEGORY`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_article`
--

LOCK TABLES `category_article` WRITE;
/*!40000 ALTER TABLE `category_article` DISABLE KEYS */;
INSERT INTO `category_article` VALUES (1,'Entrée'),(2,'Pizza'),(3,'Dessert'),(4,'Boisson');
/*!40000 ALTER TABLE `category_article` ENABLE KEYS */;
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
  CONSTRAINT `commande_ibfk_1` FOREIGN KEY (`ID_CLIENT`) REFERENCES `customer` (`ID_CLIENT`)
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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `ID_CLIENT` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(30) DEFAULT NULL,
  `PRENOM` varchar(30) DEFAULT NULL,
  `ADRESSE` varchar(100) DEFAULT NULL,
  `NUM_TEL` varchar(15) DEFAULT NULL,
  `ID_ROLE_USER` int(11) NOT NULL DEFAULT '4',
  PRIMARY KEY (`ID_CLIENT`),
  KEY `role_customer_fk_idx` (`ID_ROLE_USER`),
  CONSTRAINT `role_customer_fk` FOREIGN KEY (`ID_ROLE_USER`) REFERENCES `role_users` (`ID_ROLE_USER`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Bodin','Coline','29 Rue Bonte Pollet, 59000 Lille','0236152987',4),(2,'Becuwe','Clément','57 Rue Christophe Colomb, 59800 Lille','0642398521',4),(3,'Callenaere','Charles','23 Rue Ferrer, 59155 Faches-Thumesnil','0198763249',4),(4,'Machin','Bidule','2 Rue d\'Iena, 59000 Lille','0695301945',4),(5,'Noel','Pere','91 Rue Massena, 59800 Lille','3615',4),(6,'Robert','Catherine','37 Rue Bonte Pollet, 59000 Lille','0320925755',4);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
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
  `VALIDATION` tinyint(1) DEFAULT NULL,
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
-- Table structure for table `role_users`
--

DROP TABLE IF EXISTS `role_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role_users` (
  `ID_ROLE_USER` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_ROLE_USER`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_users`
--

LOCK TABLES `role_users` WRITE;
/*!40000 ALTER TABLE `role_users` DISABLE KEYS */;
INSERT INTO `role_users` VALUES (1,'ADMIN'),(2,'LIVREUR'),(3,'FABRICATION'),(4,'USER');
/*!40000 ALTER TABLE `role_users` ENABLE KEYS */;
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
  `ID_ROLE_USER` int(11) NOT NULL DEFAULT '4',
  PRIMARY KEY (`ID_USER`),
  KEY `role_user_fk_idx` (`ID_ROLE_USER`),
  CONSTRAINT `role_user_fk` FOREIGN KEY (`ID_ROLE_USER`) REFERENCES `role_users` (`ID_ROLE_USER`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Bodin','motDePasseAdmin',1),(2,'Codeville','Codeville1',2),(3,'Canard','Canard1',2),(4,'Becoue','Becoue1',3),(5,'Boudin','Boudin1',3),(6,'Podevin','Podevin1',2);
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

-- Dump completed on 2019-09-14  8:55:58
