-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 06-10-2016 a las 23:38:05
-- Versión del servidor: 10.1.16-MariaDB
-- Versión de PHP: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `consultorio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pacientes`
--

CREATE TABLE `pacientes` (
  `id_paciente` int(5) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apePaterno` varchar(30) NOT NULL,
  `apeMaterno` varchar(30) NOT NULL,
  `genero` varchar(15) NOT NULL,
  `fechaNacimiento` varchar(10) NOT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `celular` varchar(15) DEFAULT NULL,
  `rfc` varchar(30) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `codigoPostal` varchar(10) DEFAULT NULL,
  `direccion` varchar(100) NOT NULL,
  `responsable` varchar(50) DEFAULT NULL,
  `referenciado` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `pacientes`
--

INSERT INTO `pacientes` (`id_paciente`, `nombre`, `apePaterno`, `apeMaterno`, `genero`, `fechaNacimiento`, `telefono`, `celular`, `rfc`, `correo`, `codigoPostal`, `direccion`, `responsable`, `referenciado`) VALUES
(1, 'Ramiro Alejandro', 'Uvalle', 'Vigueras', 'Masculino', '2016-10-17', '8181818181', '8117466318', '1234567890', 'ramiro@gmail.com', '67190', 'Calle Flor, colonia ramos, guadalupe', '', ''),
(2, 'Katia Berenice', 'Reyna', 'Sepulveda', 'Femenino', '2016-10-06', '8181818182', '8182838485', '1234566789', 'katia@gmail.com', '67190', 'alguna calle 232', '', '');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`id_paciente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  MODIFY `id_paciente` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
