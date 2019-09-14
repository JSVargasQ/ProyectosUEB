-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.15 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura para tabla galeria_arte.audit
CREATE TABLE IF NOT EXISTS `audit` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `userId` int(5) NOT NULL,
  `operationCrud` varchar(1) NOT NULL,
  `tableName` varchar(30) NOT NULL,
  `tableId` int(20) NOT NULL,
  `createDate` datetime NOT NULL,
  `addressIP` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla galeria_arte.audit: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `audit` DISABLE KEYS */;
/*!40000 ALTER TABLE `audit` ENABLE KEYS */;

-- Volcando estructura para tabla galeria_arte.categoria
CREATE TABLE IF NOT EXISTS `categoria` (
  `id` smallint(3) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(75) DEFAULT NULL,
  `activo` smallint(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla galeria_arte.categoria: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;

-- Volcando estructura para tabla galeria_arte.clasificado
CREATE TABLE IF NOT EXISTS `clasificado` (
  `id` smallint(3) NOT NULL AUTO_INCREMENT,
  `idCliente` smallint(3) NOT NULL,
  `correo` varchar(70) DEFAULT NULL,
  `celular` varchar(15) DEFAULT NULL,
  `mensaje` varchar(80) DEFAULT NULL,
  `detalleMensaje` varchar(200) DEFAULT NULL,
  `medioEnvio` varchar(15) DEFAULT NULL,
  `activo` varchar(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla galeria_arte.clasificado: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `clasificado` DISABLE KEYS */;
/*!40000 ALTER TABLE `clasificado` ENABLE KEYS */;

-- Volcando estructura para tabla galeria_arte.exposicion
CREATE TABLE IF NOT EXISTS `exposicion` (
  `id` smallint(3) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) DEFAULT NULL,
  `tipoExposicion` varchar(20) DEFAULT NULL,
  `fechaInicial` datetime NOT NULL,
  `fechaFinal` datetime NOT NULL,
  `activo` varchar(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla galeria_arte.exposicion: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `exposicion` DISABLE KEYS */;
INSERT INTO `exposicion` (`id`, `descripcion`, `tipoExposicion`, `fechaInicial`, `fechaFinal`, `activo`) VALUES
	(1, 'Autores: Sebastian Rodriguez y David Valoyes', 'Grupal', '2019-05-20 00:00:00', '2019-05-25 00:00:00', 'A');
/*!40000 ALTER TABLE `exposicion` ENABLE KEYS */;

-- Volcando estructura para tabla galeria_arte.parametro
CREATE TABLE IF NOT EXISTS `parametro` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `tipoParametro` varchar(1) NOT NULL,
  `codigoParametro` varchar(10) NOT NULL,
  `descripcion` varchar(60) NOT NULL,
  `valorTexto` varchar(10) NOT NULL,
  `valorNumerico` int(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla galeria_arte.parametro: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `parametro` DISABLE KEYS */;
/*!40000 ALTER TABLE `parametro` ENABLE KEYS */;

-- Volcando estructura para tabla galeria_arte.producto
CREATE TABLE IF NOT EXISTS `producto` (
  `id` smallint(3) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(75) DEFAULT NULL,
  `descripcion` varchar(75) DEFAULT NULL,
  `autor` varchar(75) DEFAULT NULL,
  `rutaFoto` varchar(75) DEFAULT NULL,
  `valorProducto` int(10) NOT NULL,
  `activo` varchar(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla galeria_arte.producto: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` (`id`, `nombre`, `descripcion`, `autor`, `rutaFoto`, `valorProducto`, `activo`) VALUES
	(1, 'Manchas', 'Arte abstracto', 'Sebastian Vargas', '-----', 1200000, 'A');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;

-- Volcando estructura para tabla galeria_arte.transaccion
CREATE TABLE IF NOT EXISTS `transaccion` (
  `id` smallint(3) NOT NULL AUTO_INCREMENT,
  `idComprador` smallint(3) NOT NULL,
  `fechaTransaccion` datetime NOT NULL,
  `idProducto` smallint(3) NOT NULL,
  `valorTransaccion` int(10) NOT NULL,
  `idExposicion` smallint(3) NOT NULL,
  `idClasificado` smallint(3) DEFAULT NULL,
  `activo` varchar(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla galeria_arte.transaccion: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `transaccion` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaccion` ENABLE KEYS */;

-- Volcando estructura para tabla galeria_arte.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `userName` varchar(8) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `fullName` varchar(60) NOT NULL,
  `emailAddress` varchar(75) DEFAULT NULL,
  `phoneNumber` varchar(10) NOT NULL,
  `dateLastPassword` datetime NOT NULL,
  `active` varchar(1) NOT NULL,
  `intentos` int(2) NOT NULL,
  `userType` varchar(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla galeria_arte.user: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `userName`, `password`, `fullName`, `emailAddress`, `phoneNumber`, `dateLastPassword`, `active`, `intentos`, `userType`) VALUES
	(1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'Usuario Administrador', 'admin@gmail.com', '987654321', '2018-04-10 00:00:00', 'A', 0, 'A'),
	(2, 'usuario', 'f8032d5cae3de20fcec887f395ec9a6a', 'User', 'usuario@gmail.com', '456789', '2019-05-15 15:17:23', 'A', 0, 'O'),
	(3, 'Sagrav', '202cb962ac59075b964b07152d234b70', 'Sebastian Vargas', 'jsvargasq@unbosque.edu.co', '3203362420', '2019-05-15 16:13:57', 'A', 0, 'O');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
