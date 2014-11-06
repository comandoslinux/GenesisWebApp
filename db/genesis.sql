-- MySQL dump 10.13  Distrib 5.6.21, for Linux (x86_64)
--
-- Host: localhost    Database: genesis
-- ------------------------------------------------------
-- Server version	5.6.21

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
-- Table structure for table `ALMACEN`
--

DROP TABLE IF EXISTS `ALMACEN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ALMACEN` (
  `codalmacen` varchar(50) NOT NULL,
  `nombre` varchar(150) DEFAULT NULL,
  `descripcion` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`codalmacen`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Inventario donde se guarda todos los productos';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ALMACEN`
--

LOCK TABLES `ALMACEN` WRITE;
/*!40000 ALTER TABLE `ALMACEN` DISABLE KEYS */;
/*!40000 ALTER TABLE `ALMACEN` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ALMACENDETA`
--

DROP TABLE IF EXISTS `ALMACENDETA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ALMACENDETA` (
  `idalmdeta` int(11) NOT NULL,
  `codprdto` varchar(100) NOT NULL,
  `cantidadprdto` double NOT NULL,
  `codalmacen` varchar(50) NOT NULL,
  PRIMARY KEY (`idalmdeta`,`codprdto`),
  KEY `fk_ALMACENDETA_1_idx` (`codalmacen`),
  KEY `fk_ALMACENDETA_2_idx` (`codprdto`),
  CONSTRAINT `fk_ALMACENDETA_1` FOREIGN KEY (`codalmacen`) REFERENCES `ALMACEN` (`codalmacen`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ALMACENDETA_2` FOREIGN KEY (`codprdto`) REFERENCES `PRODUCTO` (`codprdto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Almacen detalle';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ALMACENDETA`
--

LOCK TABLES `ALMACENDETA` WRITE;
/*!40000 ALTER TABLE `ALMACENDETA` DISABLE KEYS */;
/*!40000 ALTER TABLE `ALMACENDETA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `BENEFICIARIO`
--

DROP TABLE IF EXISTS `BENEFICIARIO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BENEFICIARIO` (
  `codbenef` int(11) NOT NULL,
  `nombrebene` varchar(150) NOT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `direccion` varchar(150) DEFAULT NULL,
  `dui` varchar(10) DEFAULT NULL,
  `nit` varchar(17) DEFAULT NULL,
  `contactobene` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`codbenef`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Master Table, administra las personas o instituciones que se';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BENEFICIARIO`
--

LOCK TABLES `BENEFICIARIO` WRITE;
/*!40000 ALTER TABLE `BENEFICIARIO` DISABLE KEYS */;
/*!40000 ALTER TABLE `BENEFICIARIO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DONACION`
--

DROP TABLE IF EXISTS `DONACION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DONACION` (
  `codcorredncn` int(11) NOT NULL,
  `concepto` varchar(150) NOT NULL,
  `fingreso` date NOT NULL,
  `frecepcion` date DEFAULT NULL,
  `codusr` int(11) NOT NULL,
  `coddnte` int(11) NOT NULL,
  `codstddncn` varchar(20) NOT NULL,
  PRIMARY KEY (`codcorredncn`),
  KEY `fk_DONACION_1_idx` (`codstddncn`),
  KEY `fk_DONACION_2_idx` (`coddnte`),
  KEY `fk_DONACION_3_idx` (`codusr`),
  CONSTRAINT `fk_DONACION_1` FOREIGN KEY (`codstddncn`) REFERENCES `ESTDDONACION` (`codstddncn`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_DONACION_2` FOREIGN KEY (`coddnte`) REFERENCES `DONANTE` (`coddnte`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_DONACION_3` FOREIGN KEY (`codusr`) REFERENCES `USUARIO` (`codusr`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Master Table, Administra las donaciones';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DONACION`
--

LOCK TABLES `DONACION` WRITE;
/*!40000 ALTER TABLE `DONACION` DISABLE KEYS */;
/*!40000 ALTER TABLE `DONACION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DONACIONDETA`
--

DROP TABLE IF EXISTS `DONACIONDETA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DONACIONDETA` (
  `codcorrdndeta` int(11) NOT NULL,
  `codprdto` varchar(100) NOT NULL,
  `cantidad` double NOT NULL,
  `vprpdad1` varchar(150) DEFAULT NULL,
  `vprpdad2` varchar(150) DEFAULT NULL,
  `codcorredncn` int(11) NOT NULL,
  `codprpdad` varchar(100) NOT NULL,
  `codstdprdto` varchar(20) NOT NULL,
  `codlote` int(11) NOT NULL,
  PRIMARY KEY (`codcorrdndeta`,`codprdto`),
  KEY `fk_DNCNDETA_2_idx` (`codcorredncn`),
  KEY `fk_DNCNDETA_4_idx` (`codprpdad`),
  KEY `fk_DNCNDETA_3_idx` (`codstdprdto`),
  KEY `fk_DONACIONDETA_1_idx` (`codprdto`),
  KEY `fk_DONACIONDETA_2_idx` (`codlote`),
  CONSTRAINT `fk_DNCNDETA_2` FOREIGN KEY (`codcorredncn`) REFERENCES `DONACION` (`codcorredncn`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_DNCNDETA_3` FOREIGN KEY (`codstdprdto`) REFERENCES `ESTDPRDTO` (`codstdprdto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_DNCNDETA_4` FOREIGN KEY (`codprpdad`) REFERENCES `PROPIEDAD` (`codprpdad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_DONACIONDETA_1` FOREIGN KEY (`codprdto`) REFERENCES `PRODUCTO` (`codprdto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_DONACIONDETA_2` FOREIGN KEY (`codlote`) REFERENCES `LOTE` (`codlote`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Master Table, Detalle de las donaciones';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DONACIONDETA`
--

LOCK TABLES `DONACIONDETA` WRITE;
/*!40000 ALTER TABLE `DONACIONDETA` DISABLE KEYS */;
/*!40000 ALTER TABLE `DONACIONDETA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DONANTE`
--

DROP TABLE IF EXISTS `DONANTE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DONANTE` (
  `coddnte` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `fingreso` date NOT NULL,
  `dui` char(10) DEFAULT NULL,
  `nit` char(17) DEFAULT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  `direccion` varchar(150) DEFAULT NULL,
  `codtpdonante` varchar(20) NOT NULL,
  PRIMARY KEY (`coddnte`),
  KEY `fk_DONANTE_1_idx` (`codtpdonante`),
  CONSTRAINT `fk_DONANTE_1` FOREIGN KEY (`codtpdonante`) REFERENCES `TPDONANTE` (`codtpdonante`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Master Table, guarda la informacion basica de los donantes';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DONANTE`
--

LOCK TABLES `DONANTE` WRITE;
/*!40000 ALTER TABLE `DONANTE` DISABLE KEYS */;
/*!40000 ALTER TABLE `DONANTE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ESTDDONACION`
--

DROP TABLE IF EXISTS `ESTDDONACION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ESTDDONACION` (
  `codstddncn` varchar(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`codstddncn`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Master Table, Administra el estado de la donacion';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ESTDDONACION`
--

LOCK TABLES `ESTDDONACION` WRITE;
/*!40000 ALTER TABLE `ESTDDONACION` DISABLE KEYS */;
/*!40000 ALTER TABLE `ESTDDONACION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ESTDPRDTO`
--

DROP TABLE IF EXISTS `ESTDPRDTO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ESTDPRDTO` (
  `codstdprdto` varchar(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`codstdprdto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Master Table, Administra el estado fisico de los productos o';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ESTDPRDTO`
--

LOCK TABLES `ESTDPRDTO` WRITE;
/*!40000 ALTER TABLE `ESTDPRDTO` DISABLE KEYS */;
/*!40000 ALTER TABLE `ESTDPRDTO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ID_GEN`
--

DROP TABLE IF EXISTS `ID_GEN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ID_GEN` (
  `GEN_NAME` varchar(50) NOT NULL,
  `GEN_VAL` int(11) NOT NULL,
  PRIMARY KEY (`GEN_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ID_GEN`
--

LOCK TABLES `ID_GEN` WRITE;
/*!40000 ALTER TABLE `ID_GEN` DISABLE KEYS */;
INSERT INTO `ID_GEN` VALUES ('user_gen',200);
/*!40000 ALTER TABLE `ID_GEN` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LOTE`
--

DROP TABLE IF EXISTS `LOTE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LOTE` (
  `codlote` int(11) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `descripcion` varchar(150) DEFAULT NULL,
  `fechavencimto` date DEFAULT NULL,
  PRIMARY KEY (`codlote`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Administra en lotes los productos o articulos perecederos';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LOTE`
--

LOCK TABLES `LOTE` WRITE;
/*!40000 ALTER TABLE `LOTE` DISABLE KEYS */;
/*!40000 ALTER TABLE `LOTE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PRODUCTO`
--

DROP TABLE IF EXISTS `PRODUCTO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PRODUCTO` (
  `codprdto` varchar(100) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `descripcion` varchar(150) DEFAULT NULL,
  `codum` varchar(20) NOT NULL,
  PRIMARY KEY (`codprdto`),
  KEY `fk_PRODUCTO_1_idx` (`codum`),
  CONSTRAINT `fk_PRODUCTO_1` FOREIGN KEY (`codum`) REFERENCES `UMEDIDA` (`codum`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Master Table, Productos o articulos a recibir';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRODUCTO`
--

LOCK TABLES `PRODUCTO` WRITE;
/*!40000 ALTER TABLE `PRODUCTO` DISABLE KEYS */;
/*!40000 ALTER TABLE `PRODUCTO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PROPIEDAD`
--

DROP TABLE IF EXISTS `PROPIEDAD`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PROPIEDAD` (
  `codprpdad` varchar(100) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `descripcion` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`codprpdad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Master Table, Describe la propiedad de un articulo: color, p';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROPIEDAD`
--

LOCK TABLES `PROPIEDAD` WRITE;
/*!40000 ALTER TABLE `PROPIEDAD` DISABLE KEYS */;
/*!40000 ALTER TABLE `PROPIEDAD` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ROL`
--

DROP TABLE IF EXISTS `ROL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ROL` (
  `codrol` varchar(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`codrol`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Master Table, Roles para los diferentes usuarios que ingresa';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ROL`
--

LOCK TABLES `ROL` WRITE;
/*!40000 ALTER TABLE `ROL` DISABLE KEYS */;
INSERT INTO `ROL` VALUES ('ADMIN','Administrador','Usuario con todos los privilegios'),('OTRO','Otro','Otro rol'),('USER','Usuario','Usuario con pocos privilegios');
/*!40000 ALTER TABLE `ROL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SALIDA`
--

DROP TABLE IF EXISTS `SALIDA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SALIDA` (
  `codsalida` int(11) NOT NULL,
  `concepto` varchar(150) NOT NULL,
  `fechasalida` date NOT NULL,
  `codbenef` int(11) NOT NULL,
  PRIMARY KEY (`codsalida`),
  KEY `fk_SALIDA_1_idx` (`codbenef`),
  CONSTRAINT `fk_SALIDA_1` FOREIGN KEY (`codbenef`) REFERENCES `BENEFICIARIO` (`codbenef`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Movimiento de producto que esta en el almacen';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SALIDA`
--

LOCK TABLES `SALIDA` WRITE;
/*!40000 ALTER TABLE `SALIDA` DISABLE KEYS */;
/*!40000 ALTER TABLE `SALIDA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SALIDADETA`
--

DROP TABLE IF EXISTS `SALIDADETA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SALIDADETA` (
  `idsalidadeta` int(11) NOT NULL,
  `codprdto` varchar(100) NOT NULL,
  `cantidadprdto` double NOT NULL,
  `codsalida` int(11) NOT NULL,
  PRIMARY KEY (`idsalidadeta`,`codprdto`),
  KEY `fk_SALIDADETA_1_idx` (`codsalida`),
  KEY `fk_SALIDADETA_2_idx` (`codprdto`),
  CONSTRAINT `fk_SALIDADETA_1` FOREIGN KEY (`codsalida`) REFERENCES `SALIDA` (`codsalida`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_SALIDADETA_2` FOREIGN KEY (`codprdto`) REFERENCES `PRODUCTO` (`codprdto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Salida de productos';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SALIDADETA`
--

LOCK TABLES `SALIDADETA` WRITE;
/*!40000 ALTER TABLE `SALIDADETA` DISABLE KEYS */;
/*!40000 ALTER TABLE `SALIDADETA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TPDONANTE`
--

DROP TABLE IF EXISTS `TPDONANTE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TPDONANTE` (
  `codtpdonante` varchar(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`codtpdonante`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Master Table, Tipos de donantes que hacen donaciones';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TPDONANTE`
--

LOCK TABLES `TPDONANTE` WRITE;
/*!40000 ALTER TABLE `TPDONANTE` DISABLE KEYS */;
/*!40000 ALTER TABLE `TPDONANTE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UMEDIDA`
--

DROP TABLE IF EXISTS `UMEDIDA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UMEDIDA` (
  `codum` varchar(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`codum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Master Table, Identifica las unidades de medida de los produ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UMEDIDA`
--

LOCK TABLES `UMEDIDA` WRITE;
/*!40000 ALTER TABLE `UMEDIDA` DISABLE KEYS */;
/*!40000 ALTER TABLE `UMEDIDA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USUARIO`
--

DROP TABLE IF EXISTS `USUARIO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USUARIO` (
  `codusr` int(11) NOT NULL,
  `nombre` varchar(150) DEFAULT NULL,
  `usuario` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `codrol` varchar(20) NOT NULL,
  PRIMARY KEY (`codusr`),
  KEY `fk_USUARIO_1_idx` (`codrol`),
  CONSTRAINT `fk_USUARIO_1` FOREIGN KEY (`codrol`) REFERENCES `ROL` (`codrol`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Master Table, Usuarios que ingresan al sistema';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USUARIO`
--

LOCK TABLES `USUARIO` WRITE;
/*!40000 ALTER TABLE `USUARIO` DISABLE KEYS */;
INSERT INTO `USUARIO` VALUES (1,'Orlando Palencia Belloso','opalencia','ff282e89b66a474a182272cf43dc01aa0a5a654c','ADMIN'),(51,'Fionna Pocasangre ','flara','2789185b5f762fcb37b6f9ca859e2217a28f654e','USER'),(52,'Dalila Sifiro','dsifiro','5f292c097b98bc048bf97e0052e9a247e2a3d417','OTRO');
/*!40000 ALTER TABLE `USUARIO` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-05 22:05:51
