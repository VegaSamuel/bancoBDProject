CREATE DATABASE  IF NOT EXISTS `banco` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `banco`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: banco
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombres` varchar(60) NOT NULL,
  `apellido_paterno` varchar(30) NOT NULL,
  `apellido_materno` varchar(30) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `id_domicilio` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_domicilio` (`id_domicilio`),
  CONSTRAINT `clientes_ibfk_1` FOREIGN KEY (`id_domicilio`) REFERENCES `domicilios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Peter','Parker','Smith','2003-12-24',1);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuentas`
--

DROP TABLE IF EXISTS `cuentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuentas` (
  `no_cuenta` int NOT NULL AUTO_INCREMENT,
  `fecha_apertura` date NOT NULL,
  `saldo` float(10,2) NOT NULL,
  `id_clientes` int NOT NULL,
  PRIMARY KEY (`no_cuenta`),
  KEY `id_clientes` (`id_clientes`),
  CONSTRAINT `cuentas_ibfk_1` FOREIGN KEY (`id_clientes`) REFERENCES `clientes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentas`
--

LOCK TABLES `cuentas` WRITE;
/*!40000 ALTER TABLE `cuentas` DISABLE KEYS */;
INSERT INTO `cuentas` VALUES (1,'2020-09-12',500000.00,1);
/*!40000 ALTER TABLE `cuentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `domicilios`
--

DROP TABLE IF EXISTS `domicilios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `domicilios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `calle` varchar(30) NOT NULL,
  `numero` int NOT NULL,
  `colonia` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domicilios`
--

LOCK TABLES `domicilios` WRITE;
/*!40000 ALTER TABLE `domicilios` DISABLE KEYS */;
INSERT INTO `domicilios` VALUES (1,'Mulberry Street',1075,'Groove Street');
/*!40000 ALTER TABLE `domicilios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `retiros`
--

DROP TABLE IF EXISTS `retiros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `retiros` (
  `id_retiro` int NOT NULL AUTO_INCREMENT,
  `monto_retirado` float(10,2) NOT NULL DEFAULT '0.00',
  `folio` int NOT NULL,
  `contraseña` int NOT NULL,
  `cuenta_retiro` int NOT NULL,
  PRIMARY KEY (`id_retiro`),
  KEY `cuenta_retiro` (`cuenta_retiro`),
  CONSTRAINT `retiros_ibfk_1` FOREIGN KEY (`cuenta_retiro`) REFERENCES `cuentas` (`no_cuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `retiros`
--

LOCK TABLES `retiros` WRITE;
/*!40000 ALTER TABLE `retiros` DISABLE KEYS */;
/*!40000 ALTER TABLE `retiros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transferencias`
--

DROP TABLE IF EXISTS `transferencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transferencias` (
  `id_transferencia` int NOT NULL AUTO_INCREMENT,
  `monto_a_transferir` float(10,2) NOT NULL DEFAULT '0.00',
  `cuenta_transfer` int NOT NULL,
  `cuenta_recibo` int NOT NULL,
  PRIMARY KEY (`id_transferencia`),
  KEY `cuenta_transfer` (`cuenta_transfer`),
  KEY `cuenta_recibo` (`cuenta_recibo`),
  CONSTRAINT `transferencias_ibfk_1` FOREIGN KEY (`cuenta_transfer`) REFERENCES `cuentas` (`no_cuenta`),
  CONSTRAINT `transferencias_ibfk_2` FOREIGN KEY (`cuenta_recibo`) REFERENCES `cuentas` (`no_cuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transferencias`
--

LOCK TABLES `transferencias` WRITE;
/*!40000 ALTER TABLE `transferencias` DISABLE KEYS */;
/*!40000 ALTER TABLE `transferencias` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-18 18:40:08

/*Stored Procedure para crear un folio y contraseña aleatorios*/
create procedure randomize(
    folio int,
    contraseña int
)
begin
	update retiro
	set folio = ROUND((RAND() * (10 - 1)) + 1)
	contraseña = ROUND((RAND() * (10 - 1)) + 1)
end


/*Trigger que emplea el procedimiento para crear folios y contraseñas aleatorias*/
delimiter $$
create trigger after_insert_retiro
after insert 
on retiro for each row
begin
    CALL randomize(
		retiros.folio,
        retiros.contraseña
    );
end;

/*Stored Procedure para la acción de transferir dinero de una cuenta a otra*/
GO
create procedure transactiones(
    monto_a_transferir float(10,2),
    cuenta_transfer int,
    cuenta_recibo int
)
begin
    begin transaction;
	begin try
		update transferencias.cuenta_transfer
        SET saldo = saldo - monto_a_transferir
		where cuenta_transfer.id = cuenta_transfer.id
		update transferencias.cuenta_recibo 
        SET saldo = saldo + monto_a_transferir
		where cuenta_recibo.id = cuenta_recibo.id
		commit transaction
	end try
	begin catch
		if saldo <= 0
		begin
			rollback transaction
		end
	end catch
end
GO

/*Trigger que llama al procedimiento de transacción cada que se inserta una transferencia*/
delimiter;
create trigger after_insert_transferencias
after insert
on transferencias for each row
begin
    CALL transactiones(
      transferencias.monto_a_transferir,
      transferencias.cuenta_transfer,
      transferencias.cuenta_recibo
    );
end;