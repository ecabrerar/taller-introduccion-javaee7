-- MySQL dump 10.13  Distrib 5.5.37, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: noticias
-- ------------------------------------------------------
-- Server version	5.5.37-0ubuntu0.12.04.1

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
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorias` (
  `codigo_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) NOT NULL,
  PRIMARY KEY (`codigo_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (2,'Novedades');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudades`
--

DROP TABLE IF EXISTS `ciudades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ciudades` (
  `codigo_ciudad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL,
  `codigo_pais` int(11) NOT NULL,
  PRIMARY KEY (`codigo_ciudad`),
  KEY `fk_ciudades_1` (`codigo_pais`),
  CONSTRAINT `fk_ciudades_1` FOREIGN KEY (`codigo_pais`) REFERENCES `pais` (`codigo_pais`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudades`
--

LOCK TABLES `ciudades` WRITE;
/*!40000 ALTER TABLE `ciudades` DISABLE KEYS */;
INSERT INTO `ciudades` VALUES (7,'La Romana',5),(13,'Santiago ',5),(14,'Santo Domingo',5);
/*!40000 ALTER TABLE `ciudades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `noticias`
--

DROP TABLE IF EXISTS `noticias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `noticias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(5000) NOT NULL,
  `fecha` date NOT NULL,
  `codigo_usuario` int(11) NOT NULL,
  `codigo_ubicacion` int(11) NOT NULL,
  `hora` varchar(12) NOT NULL,
  `tipo_noticia` int(11) NOT NULL,
  `codigo_categoria` int(11) NOT NULL,
  `foto` varchar(1000) DEFAULT NULL,
  `video` varchar(1000) DEFAULT NULL,
  `visitas` int(11) DEFAULT NULL,
  `desc_corta` varchar(150) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_noticias_1` (`codigo_usuario`),
  KEY `fk_noticias_2` (`codigo_ubicacion`),
  KEY `fk_noticias_3` (`tipo_noticia`),
  KEY `fk_noticias_4` (`codigo_categoria`),
  CONSTRAINT `fk_noticias_1` FOREIGN KEY (`codigo_usuario`) REFERENCES `usuarios` (`codigo_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_noticias_2` FOREIGN KEY (`codigo_ubicacion`) REFERENCES `ubicacion` (`codigo_ubicacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_noticias_3` FOREIGN KEY (`tipo_noticia`) REFERENCES `tipo_noticias` (`tipo_noticia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_noticias_4` FOREIGN KEY (`codigo_categoria`) REFERENCES `categorias` (`codigo_categoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `noticias`
--

LOCK TABLES `noticias` WRITE;
/*!40000 ALTER TABLE `noticias` DISABLE KEYS */;
INSERT INTO `noticias` VALUES (1,'																																		Este es el nuevo portal de noticias de la ciudad de santiago de los caballeros....																						','2013-11-30',2,2,'07:49:53',3,2,'','        ',5,'Nuevo Portal de noticia'),(2,'													Diciembre esta a la vuelta de la esquina y los dominicanos se preparan para celebrar las navidades en grandes									\r\nFelicidades !!!						','2013-11-30',2,2,'07:26:24',4,2,'','    ',4,'Llego Diciembre !!'),(3,'																					Diciembre esta a la vuelta de la esquina y los dominicanos se preparan para celebrar las navidades en grandes									\r\nLlegaron las navidades !!!												','2013-11-30',2,2,'07:40:48',4,2,'','      http://www.youtube.com/watch?v=_VrzqHqwp5E',2,'Llego Diciembre !!');
/*!40000 ALTER TABLE `noticias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ocupaciones`
--

DROP TABLE IF EXISTS `ocupaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ocupaciones` (
  `codigo_ocupacion` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) NOT NULL,
  PRIMARY KEY (`codigo_ocupacion`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ocupaciones`
--

LOCK TABLES `ocupaciones` WRITE;
/*!40000 ALTER TABLE `ocupaciones` DISABLE KEYS */;
INSERT INTO `ocupaciones` VALUES (1,'MENSAJERO'),(2,'CHOFER');
/*!40000 ALTER TABLE `ocupaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pais` (
  `codigo_pais` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL,
  PRIMARY KEY (`codigo_pais`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES (4,'VENEZUELA'),(5,'REPUBLICA DOMINICANA'),(6,'HAITI');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesiones`
--

DROP TABLE IF EXISTS `profesiones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesiones` (
  `codigo_profesion` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) NOT NULL,
  PRIMARY KEY (`codigo_profesion`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesiones`
--

LOCK TABLES `profesiones` WRITE;
/*!40000 ALTER TABLE `profesiones` DISABLE KEYS */;
INSERT INTO `profesiones` VALUES (1,'MECANICO INDUSTRIAL'),(2,'INGENIERO EN SISTEMA Y COMPUTACION');
/*!40000 ALTER TABLE `profesiones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_noticias`
--

DROP TABLE IF EXISTS `tipo_noticias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_noticias` (
  `tipo_noticia` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) NOT NULL,
  PRIMARY KEY (`tipo_noticia`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_noticias`
--

LOCK TABLES `tipo_noticias` WRITE;
/*!40000 ALTER TABLE `tipo_noticias` DISABLE KEYS */;
INSERT INTO `tipo_noticias` VALUES (2,'Clasificados'),(3,'Novedades'),(4,'Sociales');
/*!40000 ALTER TABLE `tipo_noticias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ubicacion`
--

DROP TABLE IF EXISTS `ubicacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ubicacion` (
  `codigo_ubicacion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL,
  `codigo_ciudad` int(11) NOT NULL,
  PRIMARY KEY (`codigo_ubicacion`),
  KEY `fk_ubicacion_1` (`codigo_ciudad`),
  CONSTRAINT `fk_ubicacion_1` FOREIGN KEY (`codigo_ciudad`) REFERENCES `ciudades` (`codigo_ciudad`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ubicacion`
--

LOCK TABLES `ubicacion` WRITE;
/*!40000 ALTER TABLE `ubicacion` DISABLE KEYS */;
INSERT INTO `ubicacion` VALUES (2,' Av. Las Carreras #55',7);
/*!40000 ALTER TABLE `ubicacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `codigo_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `correo` varchar(200) NOT NULL,
  `sexo` varchar(20) NOT NULL,
  `identificacion` varchar(50) NOT NULL,
  `codigo_profesion` int(11) NOT NULL,
  `codigo_ocupacion` int(11) NOT NULL,
  `tipo_noticia` int(11) NOT NULL,
  `clave` varchar(50) NOT NULL,
  `codigo_ubicacion` int(11) NOT NULL,
  `usuario_login` varchar(20) NOT NULL,
  `rol` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo_usuario`),
  KEY `fk_usuarios_1` (`codigo_ubicacion`),
  KEY `fk_usuarios_2` (`codigo_profesion`),
  KEY `fk_usuarios_3` (`tipo_noticia`),
  KEY `fk_usuarios_4` (`codigo_ocupacion`),
  CONSTRAINT `fk_usuarios_1` FOREIGN KEY (`codigo_ubicacion`) REFERENCES `ubicacion` (`codigo_ubicacion`),
  CONSTRAINT `fk_usuarios_2` FOREIGN KEY (`codigo_profesion`) REFERENCES `profesiones` (`codigo_profesion`),
  CONSTRAINT `fk_usuarios_3` FOREIGN KEY (`tipo_noticia`) REFERENCES `tipo_noticias` (`tipo_noticia`),
  CONSTRAINT `fk_usuarios_4` FOREIGN KEY (`codigo_ocupacion`) REFERENCES `ocupaciones` (`codigo_ocupacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (2,'Fausto Gonzalez','2013-11-25','1985-10-03','abien_icon_bigger.jpg','fausto.gonzalez@gmail.com','M','031-00000-2',2,1,2,'15d03d63baea5afde2bcbf05b146ca67',2,'faustog','Admin'),(3,'Pedro Perez','0000-00-00','0000-00-00','Anders-Abel.jpg','test@test.com','M','097-0000000-9',1,1,2,'d00c0d2dd6a5f000a1edaa89c5bd2963',2,'pedrop','Editor'),(4,'Fausto Gonzalez','0000-00-00','1985-10-03','dougss.jpg','fausto.gonzalez@gmail.com','M','031-00000-2',2,1,2,'74be16979710d4c4e7c6647856088456',2,'faustog','Admin'),(5,'phamely','0000-00-00','0000-00-00','','prueba@gmail.com','M','',1,1,2,'550e1bafe077ff0b0b67f4e32f29d751',2,'phamelyc','Admin'),(6,'phamely','0000-00-00','0000-00-00','dougss.jpg','prueba@gmail.com','F','',1,1,2,'550e1bafe077ff0b0b67f4e32f29d751',2,'phamelyc','Admin');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-07-05  7:59:15
