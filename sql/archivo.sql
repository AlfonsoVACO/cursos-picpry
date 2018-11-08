-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: esccursos
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
 SET FOREIGN_KEY_CHECKS = 0;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `administrador` (
  `idadmin` int(11) NOT NULL AUTO_INCREMENT,
  `clave` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `correo` varchar(40) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `actualizar` binary(60) NOT NULL,
  `registrar` binary(60) NOT NULL,
  `eliminar` binary(60) NOT NULL,
  `img` mediumblob,
  `idrol` int(11) NOT NULL,
  PRIMARY KEY (`idadmin`) USING BTREE,
  KEY `fk_admi_rol` (`idrol`) USING BTREE,
  CONSTRAINT `fk_admi_rol` FOREIGN KEY (`idrol`) REFERENCES `roles` (`idrol`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` VALUES (1,'EASR234FS530','Alfonso','alvaco_1993@hotmail.com','$2a$10$KVQEE7VUVu/BH44zTDwO0OrqNmtHBdqwIxEcCbv.TFnjnfpABYF.q',_binary '1\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0',_binary '1\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0',_binary '1\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0',NULL,1);
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `SP_AUDITA_ADMIN` AFTER UPDATE ON `administrador` FOR EACH ROW BEGIN
	INSERT INTO auditoria (ip,accion,tabla,fecharegistro) values('192.168.1.24','select','administrador',CURRENT_TIMESTAMP());
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `alumno` (
  `idalumno` int(11) NOT NULL AUTO_INCREMENT,
  `matricula` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `telefono` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `direccion` varchar(40) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `cp` char(5) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `img` varchar(120) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `correo` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `estado` binary(60) NOT NULL,
  `keydes` varchar(255) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `idestado` int(11) NOT NULL,
  `idmunicipio` int(11) NOT NULL,
  `idplantel` int(11) NOT NULL,
  `idrol` int(11) NOT NULL,
  `idgrupo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idalumno`) USING BTREE,
  KEY `fk_alum_plan` (`idplantel`) USING BTREE,
  KEY `fk_alum_est` (`idestado`) USING BTREE,
  KEY `fk_alum_rol` (`idrol`) USING BTREE,
  KEY `fk_alum_mun` (`idmunicipio`) USING BTREE,
  KEY `fk_alum_grup` (`idgrupo`),
  CONSTRAINT `fk_alum_est` FOREIGN KEY (`idestado`) REFERENCES `estados` (`idestado`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_alum_grup` FOREIGN KEY (`idgrupo`) REFERENCES `grupo` (`idgrupo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_alum_mun` FOREIGN KEY (`idmunicipio`) REFERENCES `municipios` (`idmunicipio`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_alum_plan` FOREIGN KEY (`idplantel`) REFERENCES `plantel` (`idplantel`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_alum_rol` FOREIGN KEY (`idrol`) REFERENCES `roles` (`idrol`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (1,'ESDAEAEFS32','Daniel','Apellidos',NULL,'Mi direccion','33433',NULL,'alvaco93@gmail.com','$2a$10$KVQEE7VUVu/BH44zTDwO0OrqNmtHBdqwIxEcCbv.TFnjnfpABYF.q',_binary '1\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0',NULL,1,1,1,4,1);
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `archivos`
--

DROP TABLE IF EXISTS `archivos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `archivos` (
  `idarchivo` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `extension` char(4) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `idrecurso` int(11) NOT NULL,
  PRIMARY KEY (`idarchivo`) USING BTREE,
  KEY `fk_arc_rec` (`idrecurso`) USING BTREE,
  CONSTRAINT `fk_arc_rec` FOREIGN KEY (`idrecurso`) REFERENCES `recursos` (`idrecurso`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `archivos`
--

LOCK TABLES `archivos` WRITE;
/*!40000 ALTER TABLE `archivos` DISABLE KEYS */;
/*!40000 ALTER TABLE `archivos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asistencia`
--

DROP TABLE IF EXISTS `asistencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `asistencia` (
  `idasistencia` int(11) NOT NULL AUTO_INCREMENT,
  `asistio` binary(60) NOT NULL,
  `fecha` datetime(6) NOT NULL,
  `idalumno` int(11) NOT NULL,
  `idcurso` int(11) NOT NULL,
  PRIMARY KEY (`idasistencia`) USING BTREE,
  KEY `fk_asis_cur` (`idcurso`) USING BTREE,
  KEY `fk_asis_alum` (`idalumno`) USING BTREE,
  CONSTRAINT `fk_asis_alum` FOREIGN KEY (`idalumno`) REFERENCES `alumno` (`idalumno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_asis_cur` FOREIGN KEY (`idcurso`) REFERENCES `cursos` (`idcurso`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asistencia`
--

LOCK TABLES `asistencia` WRITE;
/*!40000 ALTER TABLE `asistencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `asistencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auditoria`
--

DROP TABLE IF EXISTS `auditoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `auditoria` (
  `idaudita` int(11) NOT NULL AUTO_INCREMENT,
  `ip` char(15) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `accion` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `tabla` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `fecharegistro` datetime(6) NOT NULL,
  PRIMARY KEY (`idaudita`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auditoria`
--

LOCK TABLES `auditoria` WRITE;
/*!40000 ALTER TABLE `auditoria` DISABLE KEYS */;
INSERT INTO `auditoria` VALUES (1,'192.168.1.24','select','administrador','2018-10-22 09:59:14.000000');
/*!40000 ALTER TABLE `auditoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calificacion`
--

DROP TABLE IF EXISTS `calificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `calificacion` (
  `idcalificacion` int(11) NOT NULL AUTO_INCREMENT,
  `estrellas` int(1) NOT NULL,
  `comentario` varchar(255) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `idalumno` int(11) NOT NULL,
  `idcurso` int(11) NOT NULL,
  PRIMARY KEY (`idcalificacion`) USING BTREE,
  KEY `fk_cal_cur` (`idcurso`) USING BTREE,
  KEY `fk_cal_alum` (`idalumno`) USING BTREE,
  CONSTRAINT `fk_cal_alum` FOREIGN KEY (`idalumno`) REFERENCES `alumno` (`idalumno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cal_cur` FOREIGN KEY (`idcurso`) REFERENCES `cursos` (`idcurso`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calificacion`
--

LOCK TABLES `calificacion` WRITE;
/*!40000 ALTER TABLE `calificacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `calificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `categoria` (
  `idcategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idcategoria`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clases`
--

DROP TABLE IF EXISTS `clases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `clases` (
  `idclase` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `idgrupo` int(11) NOT NULL,
  PRIMARY KEY (`idclase`) USING BTREE,
  KEY `fk_clase_grupo` (`idgrupo`) USING BTREE,
  CONSTRAINT `fk_clase_grupo` FOREIGN KEY (`idgrupo`) REFERENCES `grupo` (`idgrupo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clases`
--

LOCK TABLES `clases` WRITE;
/*!40000 ALTER TABLE `clases` DISABLE KEYS */;
/*!40000 ALTER TABLE `clases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentarios`
--

DROP TABLE IF EXISTS `comentarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `comentarios` (
  `idcomentario` int(11) NOT NULL AUTO_INCREMENT,
  `idalumno` int(11) NOT NULL,
  `idcurso` int(11) NOT NULL,
  `comentario` text CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idcomentario`) USING BTREE,
  KEY `fk_come_alum` (`idalumno`) USING BTREE,
  KEY `fk_come_cur` (`idcurso`) USING BTREE,
  CONSTRAINT `fk_come_alum` FOREIGN KEY (`idalumno`) REFERENCES `alumno` (`idalumno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_come_cur` FOREIGN KEY (`idcurso`) REFERENCES `cursos` (`idcurso`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentarios`
--

LOCK TABLES `comentarios` WRITE;
/*!40000 ALTER TABLE `comentarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `comentarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `config` (
  `idconfig` int(11) NOT NULL AUTO_INCREMENT,
  `idplantel` int(11) NOT NULL,
  `idadmin` int(11) NOT NULL,
  `color` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `tipoletra` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `otro` text CHARACTER SET utf8 COLLATE utf8_spanish_ci,
  PRIMARY KEY (`idconfig`) USING BTREE,
  KEY `fk_conf_plan` (`idplantel`) USING BTREE,
  KEY `fk_conf_adm` (`idadmin`) USING BTREE,
  CONSTRAINT `fk_conf_adm` FOREIGN KEY (`idadmin`) REFERENCES `administrador` (`idadmin`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_conf_plan` FOREIGN KEY (`idplantel`) REFERENCES `plantel` (`idplantel`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contacto`
--

DROP TABLE IF EXISTS `contacto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `contacto` (
  `idcontacto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `correo` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `motivo` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `mensaje` text CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `fecha` datetime(6) NOT NULL,
  `estado` int(11) NOT NULL,
  `idplantel` int(11) NOT NULL,
  PRIMARY KEY (`idcontacto`) USING BTREE,
  KEY `fk_cont_plan` (`idplantel`) USING BTREE,
  CONSTRAINT `fk_cont_plan` FOREIGN KEY (`idplantel`) REFERENCES `plantel` (`idplantel`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contacto`
--

LOCK TABLES `contacto` WRITE;
/*!40000 ALTER TABLE `contacto` DISABLE KEYS */;
/*!40000 ALTER TABLE `contacto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso_profesor`
--

DROP TABLE IF EXISTS `curso_profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `curso_profesor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idcurso` int(11) NOT NULL,
  `idprofesor` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk_curp_prof` (`idprofesor`) USING BTREE,
  KEY `fk_curp_cur` (`idcurso`) USING BTREE,
  CONSTRAINT `fk_curp_cur` FOREIGN KEY (`idcurso`) REFERENCES `cursos` (`idcurso`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_curp_prof` FOREIGN KEY (`idprofesor`) REFERENCES `profesor` (`idprofesor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso_profesor`
--

LOCK TABLES `curso_profesor` WRITE;
/*!40000 ALTER TABLE `curso_profesor` DISABLE KEYS */;
/*!40000 ALTER TABLE `curso_profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cursos` (
  `idcurso` int(11) NOT NULL AUTO_INCREMENT,
  `clave` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `cupo` int(10) NOT NULL,
  `cupotemp` int(10) NOT NULL,
  `descripcioncorta` varchar(130) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `descripcionlarga` text CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `costo` decimal(10,2) NOT NULL,
  `img` varchar(110) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `estado` binary(60) NOT NULL,
  `idplantel` int(11) NOT NULL,
  `idhorario` int(11) NOT NULL,
  `idadmin` int(11) NOT NULL,
  `idcategoria` int(11) NOT NULL,
  PRIMARY KEY (`idcurso`) USING BTREE,
  KEY `fk_cur_adm` (`idadmin`) USING BTREE,
  KEY `fk_cur_plan` (`idplantel`) USING BTREE,
  KEY `fk_cur_hor` (`idhorario`) USING BTREE,
  KEY `fk_cur_cat` (`idcategoria`) USING BTREE,
  CONSTRAINT `fk_cur_adm` FOREIGN KEY (`idadmin`) REFERENCES `administrador` (`idadmin`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cur_cat` FOREIGN KEY (`idcategoria`) REFERENCES `categoria` (`idcategoria`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cur_hor` FOREIGN KEY (`idhorario`) REFERENCES `horario` (`idhorario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cur_plan` FOREIGN KEY (`idplantel`) REFERENCES `plantel` (`idplantel`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `empresa` (
  `idempresa` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `telefono` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `contacto` varchar(60) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `telefonocontacto` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idempresa`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estados`
--

DROP TABLE IF EXISTS `estados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `estados` (
  `idestado` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idestado`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estados`
--

LOCK TABLES `estados` WRITE;
/*!40000 ALTER TABLE `estados` DISABLE KEYS */;
INSERT INTO `estados` VALUES (1,'Aguascalientes'),(2,'Morelos');
/*!40000 ALTER TABLE `estados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faltasclase`
--

DROP TABLE IF EXISTS `faltasclase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `faltasclase` (
  `idasistencia` int(11) NOT NULL AUTO_INCREMENT,
  `idalumno` int(11) NOT NULL,
  `idclase` int(11) NOT NULL,
  `tipofalta` smallint(1) NOT NULL,
  `fecha` datetime(6) NOT NULL,
  PRIMARY KEY (`idasistencia`) USING BTREE,
  KEY `fk_faltaclass_clas` (`idclase`) USING BTREE,
  KEY `fk_faltaclass_alum` (`idalumno`) USING BTREE,
  CONSTRAINT `fk_faltaclass_alum` FOREIGN KEY (`idalumno`) REFERENCES `alumno` (`idalumno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_faltaclass_clas` FOREIGN KEY (`idclase`) REFERENCES `clases` (`idclase`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faltasclase`
--

LOCK TABLES `faltasclase` WRITE;
/*!40000 ALTER TABLE `faltasclase` DISABLE KEYS */;
/*!40000 ALTER TABLE `faltasclase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo`
--

DROP TABLE IF EXISTS `grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `grupo` (
  `idgrupo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idgrupo`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo`
--

LOCK TABLES `grupo` WRITE;
/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
INSERT INTO `grupo` VALUES (1,'Grupo 1');
/*!40000 ALTER TABLE `grupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupoprofe`
--

DROP TABLE IF EXISTS `grupoprofe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `grupoprofe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idgrupo` int(11) NOT NULL,
  `idprofesor` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk_grupro_grupo` (`idgrupo`) USING BTREE,
  KEY `fk_grupro_prof` (`idprofesor`) USING BTREE,
  CONSTRAINT `fk_grupro_grupo` FOREIGN KEY (`idgrupo`) REFERENCES `grupo` (`idgrupo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_grupro_prof` FOREIGN KEY (`idprofesor`) REFERENCES `profesor` (`idprofesor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupoprofe`
--

LOCK TABLES `grupoprofe` WRITE;
/*!40000 ALTER TABLE `grupoprofe` DISABLE KEYS */;
INSERT INTO `grupoprofe` VALUES (1,1,1);
/*!40000 ALTER TABLE `grupoprofe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horario`
--

DROP TABLE IF EXISTS `horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `horario` (
  `idhorario` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `fechade` datetime(6) NOT NULL,
  `fechaa` datetime(6) NOT NULL,
  PRIMARY KEY (`idhorario`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horario`
--

LOCK TABLES `horario` WRITE;
/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
/*!40000 ALTER TABLE `horario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libros`
--

DROP TABLE IF EXISTS `libros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `libros` (
  `idlibro` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `autor` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `estatus` binary(60) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `idcurso` int(11) NOT NULL,
  PRIMARY KEY (`idlibro`) USING BTREE,
  KEY `fk_lib_cur` (`idcurso`) USING BTREE,
  CONSTRAINT `fk_lib_cur` FOREIGN KEY (`idcurso`) REFERENCES `cursos` (`idcurso`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libros`
--

LOCK TABLES `libros` WRITE;
/*!40000 ALTER TABLE `libros` DISABLE KEYS */;
/*!40000 ALTER TABLE `libros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `municipios`
--

DROP TABLE IF EXISTS `municipios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `municipios` (
  `idmunicipio` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idmunicipio`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `municipios`
--

LOCK TABLES `municipios` WRITE;
/*!40000 ALTER TABLE `municipios` DISABLE KEYS */;
INSERT INTO `municipios` VALUES (1,'Aguascalientes'),(2,'Tepalcingo');
/*!40000 ALTER TABLE `municipios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notasfinales`
--

DROP TABLE IF EXISTS `notasfinales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `notasfinales` (
  `idnotafinal` int(11) NOT NULL AUTO_INCREMENT,
  `idclase` int(11) NOT NULL,
  `parcial` int(5) NOT NULL,
  `calificacionfinal` double(5,2) NOT NULL,
  `idalumno` int(11) NOT NULL,
  PRIMARY KEY (`idnotafinal`) USING BTREE,
  KEY `fk_nota_clase` (`idclase`) USING BTREE,
  KEY `fk_nota_alum` (`idalumno`) USING BTREE,
  CONSTRAINT `fk_nota_alum` FOREIGN KEY (`idalumno`) REFERENCES `alumno` (`idalumno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_nota_clase` FOREIGN KEY (`idclase`) REFERENCES `clases` (`idclase`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notasfinales`
--

LOCK TABLES `notasfinales` WRITE;
/*!40000 ALTER TABLE `notasfinales` DISABLE KEYS */;
/*!40000 ALTER TABLE `notasfinales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `noticias`
--

DROP TABLE IF EXISTS `noticias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `noticias` (
  `idnoticia` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` longtext CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `fecha` datetime(6) NOT NULL,
  `idplantel` int(11) NOT NULL,
  `idadmin` int(11) NOT NULL,
  PRIMARY KEY (`idnoticia`) USING BTREE,
  KEY `fk_not_plan` (`idplantel`) USING BTREE,
  KEY `fk_not_adm` (`idadmin`) USING BTREE,
  CONSTRAINT `fk_not_adm` FOREIGN KEY (`idadmin`) REFERENCES `administrador` (`idadmin`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_not_plan` FOREIGN KEY (`idplantel`) REFERENCES `plantel` (`idplantel`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `noticias`
--

LOCK TABLES `noticias` WRITE;
/*!40000 ALTER TABLE `noticias` DISABLE KEYS */;
/*!40000 ALTER TABLE `noticias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `otrospagos`
--

DROP TABLE IF EXISTS `otrospagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `otrospagos` (
  `idpago` int(11) NOT NULL AUTO_INCREMENT,
  `concepto` varchar(40) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `monto` double(5,2) NOT NULL,
  `estatus` smallint(1) NOT NULL,
  `referencia` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `idalumno` int(11) NOT NULL,
  `fechapago` datetime(6) NOT NULL,
  PRIMARY KEY (`idpago`) USING BTREE,
  KEY `fk_otro_pag` (`idalumno`) USING BTREE,
  CONSTRAINT `fk_otro_pag` FOREIGN KEY (`idalumno`) REFERENCES `alumno` (`idalumno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `otrospagos`
--

LOCK TABLES `otrospagos` WRITE;
/*!40000 ALTER TABLE `otrospagos` DISABLE KEYS */;
/*!40000 ALTER TABLE `otrospagos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagos`
--

DROP TABLE IF EXISTS `pagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pagos` (
  `idpago` int(11) NOT NULL AUTO_INCREMENT,
  `idalumno` int(11) NOT NULL,
  `idcurso` int(11) NOT NULL,
  `cantidad` decimal(10,2) NOT NULL,
  `estatus` int(1) NOT NULL,
  `folioefectivo` varchar(40) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `tipo` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `fecharegistro` datetime(6) NOT NULL,
  `fechavencimiento` datetime(6) NOT NULL,
  `fechapago` datetime(6) NOT NULL,
  `tiket` varchar(200) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idpago`) USING BTREE,
  KEY `fk_pag_cur` (`idcurso`) USING BTREE,
  KEY `fk_pag_alum` (`idalumno`) USING BTREE,
  CONSTRAINT `fk_pag_alum` FOREIGN KEY (`idalumno`) REFERENCES `alumno` (`idalumno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pag_cur` FOREIGN KEY (`idcurso`) REFERENCES `cursos` (`idcurso`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagos`
--

LOCK TABLES `pagos` WRITE;
/*!40000 ALTER TABLE `pagos` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plantel`
--

DROP TABLE IF EXISTS `plantel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `plantel` (
  `idplantel` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `cd` char(5) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `img` mediumblob,
  `descripcion` text CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `idmunicipio` int(11) NOT NULL,
  `idestado` int(11) NOT NULL,
  `idadmin` int(11) NOT NULL,
  PRIMARY KEY (`idplantel`) USING BTREE,
  KEY `fk_plan_adm` (`idadmin`) USING BTREE,
  KEY `fk_plan_est` (`idestado`) USING BTREE,
  KEY `fk_plan_mun` (`idmunicipio`) USING BTREE,
  CONSTRAINT `fk_plan_adm` FOREIGN KEY (`idadmin`) REFERENCES `administrador` (`idadmin`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_plan_est` FOREIGN KEY (`idestado`) REFERENCES `estados` (`idestado`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_plan_mun` FOREIGN KEY (`idmunicipio`) REFERENCES `municipios` (`idmunicipio`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plantel`
--

LOCK TABLES `plantel` WRITE;
/*!40000 ALTER TABLE `plantel` DISABLE KEYS */;
INSERT INTO `plantel` VALUES (1,'Plantel azcapotzalco','Av. Los coyotes No 23','23767',NULL,'Una des',1,1,1);
/*!40000 ALTER TABLE `plantel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `profesor` (
  `idprofesor` int(11) NOT NULL AUTO_INCREMENT,
  `clave` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `correo` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `actualiza` binary(60) NOT NULL,
  `eliminar` binary(60) NOT NULL,
  `img` mediumblob,
  `idadmin` int(11) NOT NULL,
  `fecharegistro` datetime(6) NOT NULL,
  `idrol` int(11) NOT NULL,
  PRIMARY KEY (`idprofesor`) USING BTREE,
  KEY `fk_prof_adm` (`idadmin`) USING BTREE,
  KEY `fk_prof_rol` (`idrol`) USING BTREE,
  CONSTRAINT `fk_prof_adm` FOREIGN KEY (`idadmin`) REFERENCES `administrador` (`idadmin`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_prof_rol` FOREIGN KEY (`idrol`) REFERENCES `roles` (`idrol`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (1,'SDFDSDESDD','Fernando','Contreras vargas','fer@gmail.com','$2a$10$KVQEE7VUVu/BH44zTDwO0OrqNmtHBdqwIxEcCbv.TFnjnfpABYF.q',_binary '1\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0',_binary '1\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0',NULL,1,'2018-10-21 13:00:06.000000',3);
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyecto`
--

DROP TABLE IF EXISTS `proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `proyecto` (
  `idproyecto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` text CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `estado` smallint(1) NOT NULL,
  `idprofesor` int(11) NOT NULL,
  `idalumno` int(11) NOT NULL,
  `idempresa` int(11) DEFAULT NULL,
  `otraempresa` varchar(60) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `otradireccion` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `otratelefono` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecharegistro` datetime(6) NOT NULL,
  `fechaentrega` datetime(6) NOT NULL,
  `otracontacto` varchar(60) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `otratelefonocontacto` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idproyecto`) USING BTREE,
  KEY `fk_proye_empre` (`idempresa`) USING BTREE,
  KEY `fk_proye_prof` (`idprofesor`) USING BTREE,
  KEY `fk_proye_alum` (`idalumno`) USING BTREE,
  CONSTRAINT `fk_proye_alum` FOREIGN KEY (`idalumno`) REFERENCES `alumno` (`idalumno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_proye_empre` FOREIGN KEY (`idempresa`) REFERENCES `empresa` (`idempresa`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_proye_prof` FOREIGN KEY (`idprofesor`) REFERENCES `profesor` (`idprofesor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyecto`
--

LOCK TABLES `proyecto` WRITE;
/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;
/*!40000 ALTER TABLE `proyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `questions` (
  `idquestion` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `options` text COLLATE utf8_spanish_ci NOT NULL,
  `type` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `message` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `answers` text COLLATE utf8_spanish_ci NOT NULL,
  `idquiz` int(11) NOT NULL,
  PRIMARY KEY (`idquestion`),
  KEY `fk_quez_quiz` (`idquiz`),
  CONSTRAINT `fk_quez_quiz` FOREIGN KEY (`idquiz`) REFERENCES `quiz` (`idquiz`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,'Pregunta 1','Opción 1 c,Opción 2','radio','Una description 1','0',1),(2,'Pregunta 2','Opción 1 c,Opción 2 c,Opción 3','checkbox','Una description 2','0,1',1),(3,'Pregunta 3','Opción 1 c,Opción 2,Opción 3 c,Opción 4','checkbox','Una description 3','0,2',1),(4,'Pregunta 4','Opción 1,Opción 2 c,Opción 3','radio','Una description 4','1',1),(5,'Pregunta 5','Opción 1,Opción 2,Opción 3 c','radio','Una description 5','2',1),(6,'Pregunta 6','Opción 1 c,Opción 2,Opción 3 c','checkbox','Una description 6','0,2',1),(7,'Pregunta 7','Opción 1 c,Opción 2','radio','Una description 1','0',1),(8,'Pregunta 8','Opción 1 c,Opción 2 c,Opción 3','checkbox','Una description 2','0,1',1),(9,'Pregunta 9','Opción 1 c,Opción 2,Opción 3 c,Opción 4','checkbox','Una description 3','0,2',1),(10,'Pregunta 10','Opción 1,Opción 2 c,Opción 3','radio','Una description 4','1',1),(11,'Pregunta 11','Opción 1,Opción 2,Opción 3 c','radio','Una description 5','2',1),(12,'Pregunta 12','Opción 1 c,Opción 2,Opción 3 c','checkbox','Una description 6','0,2',1),(13,'Pregunta 13','Opción 1 c,Opción 2','radio','Una description 1','0',1),(14,'Pregunta 14','Opción 1 c,Opción 2 c,Opción 3','checkbox','Una description 2','0,1',1),(15,'Pregunta 15','Opción 1 c,Opción 2,Opción 3 c,Opción 4','checkbox','Una description 3','0,2',1),(16,'Pregunta 16','Opción 1,Opción 2 c,Opción 3','radio','Una description 4','1',1),(17,'Pregunta 17','Opción 1,Opción 2,Opción 3 c','radio','Una description 5','2',1),(18,'Pregunta 18','Opción 1 c,Opción 2 c,Opción 3','checkbox','Una description 6','0,1',1);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quiz`
--

DROP TABLE IF EXISTS `quiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `quiz` (
  `idquiz` int(11) NOT NULL AUTO_INCREMENT,
  `aleatorio` int(2) NOT NULL,
  `timer` int(2) NOT NULL,
  `ontimer` time DEFAULT NULL,
  `maxquest` int(5) NOT NULL,
  `maxint` int(5) NOT NULL,
  `onmaxint` int(5) DEFAULT NULL,
  `active` binary(255) NOT NULL,
  `idgrupo` int(11) NOT NULL,
  PRIMARY KEY (`idquiz`),
  KEY `fk_quiz_grup` (`idgrupo`),
  CONSTRAINT `fk_quiz_grup` FOREIGN KEY (`idgrupo`) REFERENCES `grupo` (`idgrupo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz`
--

LOCK TABLES `quiz` WRITE;
/*!40000 ALTER TABLE `quiz` DISABLE KEYS */;
INSERT INTO `quiz` VALUES (1,1,1,'13:00:00',10,1,10,_binary '1\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0',1);
/*!40000 ALTER TABLE `quiz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recursos`
--

DROP TABLE IF EXISTS `recursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `recursos` (
  `idrecurso` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` longtext CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `fecha` datetime(6) NOT NULL,
  `idtema` int(11) NOT NULL,
  PRIMARY KEY (`idrecurso`) USING BTREE,
  KEY `fk_recur_tema` (`idtema`) USING BTREE,
  CONSTRAINT `fk_recur_tema` FOREIGN KEY (`idtema`) REFERENCES `temas` (`idtema`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recursos`
--

LOCK TABLES `recursos` WRITE;
/*!40000 ALTER TABLE `recursos` DISABLE KEYS */;
/*!40000 ALTER TABLE `recursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recursotarea`
--

DROP TABLE IF EXISTS `recursotarea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `recursotarea` (
  `idrecurso` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` text CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `archivo` varchar(120) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `tipoarchivo` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `extension` char(3) CHARACTER SET utf8 COLLATE utf8_spanish_ci DEFAULT NULL,
  `idalumno` int(11) NOT NULL,
  `idtarea` int(11) NOT NULL,
  PRIMARY KEY (`idrecurso`) USING BTREE,
  KEY `fk_recur_tarea` (`idtarea`) USING BTREE,
  KEY `fk_recur_alum` (`idalumno`) USING BTREE,
  CONSTRAINT `fk_recur_alum` FOREIGN KEY (`idalumno`) REFERENCES `alumno` (`idalumno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_recur_tarea` FOREIGN KEY (`idtarea`) REFERENCES `tareas` (`idtarea`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recursotarea`
--

LOCK TABLES `recursotarea` WRITE;
/*!40000 ALTER TABLE `recursotarea` DISABLE KEYS */;
/*!40000 ALTER TABLE `recursotarea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registroquiz`
--

DROP TABLE IF EXISTS `registroquiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `registroquiz` (
  `idregistro` int(11) NOT NULL AUTO_INCREMENT,
  `idalumno` int(11) NOT NULL,
  `countquest` int(11) DEFAULT NULL,
  `calificacion` double(8,2) DEFAULT NULL,
  `respuestas` text CHARACTER SET utf8 COLLATE utf8_spanish_ci,
  `timer` time(6) DEFAULT NULL,
  `fechaini` datetime(6) NOT NULL,
  `fechafin` datetime(6) NOT NULL,
  `porcent` double(8,2) DEFAULT NULL,
  `idquiz` int(11) NOT NULL,
  PRIMARY KEY (`idregistro`),
  KEY `fk_regis_alum` (`idalumno`),
  KEY `fk_regis_quiz` (`idquiz`),
  CONSTRAINT `fk_regis_alum` FOREIGN KEY (`idalumno`) REFERENCES `alumno` (`idalumno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_regis_quiz` FOREIGN KEY (`idquiz`) REFERENCES `quiz` (`idquiz`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registroquiz`
--

LOCK TABLES `registroquiz` WRITE;
/*!40000 ALTER TABLE `registroquiz` DISABLE KEYS */;
/*!40000 ALTER TABLE `registroquiz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resetopass`
--

DROP TABLE IF EXISTS `resetopass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `resetopass` (
  `idresetopass` int(11) NOT NULL AUTO_INCREMENT,
  `idalumno` int(11) NOT NULL,
  `token` varchar(64) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `creado` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idresetopass`) USING BTREE,
  KEY `fk_res_alu` (`idalumno`) USING BTREE,
  CONSTRAINT `fk_res_alu` FOREIGN KEY (`idalumno`) REFERENCES `alumno` (`idalumno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resetopass`
--

LOCK TABLES `resetopass` WRITE;
/*!40000 ALTER TABLE `resetopass` DISABLE KEYS */;
/*!40000 ALTER TABLE `resetopass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `roles` (
  `idrol` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` char(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idrol`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_ROOT'),(2,'ROLE_ADMIN'),(3,'ROLE_PROFE'),(4,'ROLE_ALUMN'),(5,'ROLE_VISITOR');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicios`
--

DROP TABLE IF EXISTS `servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `servicios` (
  `idservicio` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `estatus` smallint(1) NOT NULL,
  `idalumno` int(11) NOT NULL,
  `fecha` datetime(6) NOT NULL,
  PRIMARY KEY (`idservicio`) USING BTREE,
  KEY `fk_servi_alum` (`idalumno`) USING BTREE,
  CONSTRAINT `fk_servi_alum` FOREIGN KEY (`idalumno`) REFERENCES `alumno` (`idalumno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicios`
--

LOCK TABLES `servicios` WRITE;
/*!40000 ALTER TABLE `servicios` DISABLE KEYS */;
/*!40000 ALTER TABLE `servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tareas`
--

DROP TABLE IF EXISTS `tareas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tareas` (
  `idtarea` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` text CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `idclase` int(11) NOT NULL,
  PRIMARY KEY (`idtarea`) USING BTREE,
  KEY `fk_tarea_clase` (`idclase`) USING BTREE,
  CONSTRAINT `fk_tarea_clase` FOREIGN KEY (`idclase`) REFERENCES `clases` (`idclase`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tareas`
--

LOCK TABLES `tareas` WRITE;
/*!40000 ALTER TABLE `tareas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tareas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temas`
--

DROP TABLE IF EXISTS `temas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `temas` (
  `idtema` int(255) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` text CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `idcurso` int(11) NOT NULL,
  PRIMARY KEY (`idtema`) USING BTREE,
  KEY `fk_tema_cur` (`idcurso`) USING BTREE,
  CONSTRAINT `fk_tema_cur` FOREIGN KEY (`idcurso`) REFERENCES `cursos` (`idcurso`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temas`
--

LOCK TABLES `temas` WRITE;
/*!40000 ALTER TABLE `temas` DISABLE KEYS */;
/*!40000 ALTER TABLE `temas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videos`
--

DROP TABLE IF EXISTS `videos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `videos` (
  `idvideo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(120) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `idtema` int(11) NOT NULL,
  PRIMARY KEY (`idvideo`) USING BTREE,
  KEY `fk_vide_tema` (`idtema`) USING BTREE,
  CONSTRAINT `fk_vide_tema` FOREIGN KEY (`idtema`) REFERENCES `temas` (`idtema`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videos`
--

LOCK TABLES `videos` WRITE;
/*!40000 ALTER TABLE `videos` DISABLE KEYS */;
/*!40000 ALTER TABLE `videos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-08 17:20:56
SET FOREIGN_KEY_CHECKS = 1;
