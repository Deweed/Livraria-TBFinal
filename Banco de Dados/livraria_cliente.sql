CREATE DATABASE  IF NOT EXISTS `livraria` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `livraria`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: livraria
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) NOT NULL,
  `cpf` char(14) NOT NULL,
  `telefone_cel` varchar(15) NOT NULL,
  `cidade` varchar(30) NOT NULL,
  `estado` char(2) NOT NULL,
  `cep` char(10) NOT NULL,
  `bairro` varchar(80) NOT NULL,
  `rua` varchar(80) NOT NULL,
  `numero` varchar(4) NOT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (46,'1','111.111.111-11','(11) 11111-1111','Brasília','DF','11111-111','1','1','1','1'),(47,'1','111.111.111-11','(11) 11111-1111','Brasília','DF','11111-111','1','1','1','1'),(48,'1','111.111.111-11','(11) 11111-1111','Brasília','DF','11111-111','1','1','1','1'),(49,'ana carolina azevedo','123.456.789-10','(31) 99613-9653','Belo Horizonte','MG','31340-560','Bandeirantes','palermo','1710','ana.santos@gmail.com'),(50,'1','111.111.111-11','(11) 11111-1111','Brasília','DF','11111-111','1','1','1','1'),(51,'1','111.111.111-11','(11) 11111-1111','Brasília','DF','11111-111','1','1','1','1'),(52,'1','111.111.111-11','(11) 11111-1111','Brasília','DF','11111-111','1','1','1','1'),(53,'1','111.111.111-11','(11) 11111-1111','Brasília','DF','11111-111','1','1','1','1'),(54,'1','111.111.111-11','(11) 11111-1111','Brasília','DF','11111-111','1','1','1','1'),(55,'1','111.111.111-11','(11) 11111-1111','Brasília','DF','11111-111','1','1','1','1'),(56,'1','111.111.111-11','(11) 11111-1111','Brasília','DF','11111-111','1','1','1','1'),(57,'1','111.111.111-11','(11) 11111-1111','Brasília','DF','11111-111','1','1','1','1'),(58,'A','777.777.777-77','(77) 77777-7777','Brasília','DF','77777-777','777','77','7','77777'),(59,'A','777.777.777-77','(77) 77777-7777','Brasília','DF','77777-777','777','77','7','77777'),(60,'A','777.777.777-77','(77) 77777-7777','Brasília','DF','77777-777','777','77','7','77777');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-23 18:56:18
