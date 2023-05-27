-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-05-2023 a las 04:17:35
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tecnologos2023`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aprendiz`
--

CREATE TABLE `aprendiz` (
  `idA` int(11) NOT NULL,
  `documentoA` int(11) NOT NULL,
  `nombreA` varchar(45) NOT NULL,
  `apellidoA` varchar(45) NOT NULL,
  `emailA` varchar(45) NOT NULL,
  `telefonoA` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `aprendiz`
--

INSERT INTO `aprendiz` (`idA`, `documentoA`, `nombreA`, `apellidoA`, `emailA`, `telefonoA`) VALUES
(1, 7547547, 'Juan', 'Joya', 'juaan@wefg', 436436),
(2, 768769, 'diego', 'morales', 'diegoo@errh', 346436),
(3, 6356346, 'alejo', 'Martinez', 'alejoo@afgeg', 546547),
(4, 456546, 'nixon', 'canon', 'nixoon@efeg', 546547),
(5, 547547, 'Juan', 'Leal', 'juaan@egweewg', 436346),
(6, 436436436, 'Felipe', 'Leal', 'felipee@wegew', 34643346);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aprendiz_ficha`
--

CREATE TABLE `aprendiz_ficha` (
  `idaf` int(11) NOT NULL,
  `codficha` int(11) DEFAULT NULL,
  `idA` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `aprendiz_ficha`
--

INSERT INTO `aprendiz_ficha` (`idaf`, `codficha`, `idA`) VALUES
(5, 54654754, 1),
(6, 54654754, 2),
(7, 54654754, 3),
(8, 54654754, 5),
(9, 54654754, 6),
(10, 54654754, 5),
(11, 54654754, 6),
(12, 54654754, 5),
(13, 54654754, 6),
(14, 45654775, 3),
(15, 45654775, 4),
(16, 45654775, 5),
(17, 45654775, 1),
(18, 45654775, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ficha`
--

CREATE TABLE `ficha` (
  `codficha` int(11) NOT NULL,
  `cantapre` int(11) NOT NULL,
  `codpro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ficha`
--

INSERT INTO `ficha` (`codficha`, `cantapre`, `codpro`) VALUES
(45654775, 5, 222222),
(54654754, 20, 44444);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `programa`
--

CREATE TABLE `programa` (
  `codpro` int(11) NOT NULL,
  `nombrepro` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `programa`
--

INSERT INTO `programa` (`codpro`, `nombrepro`) VALUES
(44444, 'multimedia'),
(222222, 'ADSII'),
(546546, 'disenoo');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aprendiz`
--
ALTER TABLE `aprendiz`
  ADD PRIMARY KEY (`idA`),
  ADD UNIQUE KEY `documentoA` (`documentoA`);

--
-- Indices de la tabla `aprendiz_ficha`
--
ALTER TABLE `aprendiz_ficha`
  ADD PRIMARY KEY (`idaf`),
  ADD KEY `codficha` (`codficha`),
  ADD KEY `idA` (`idA`);

--
-- Indices de la tabla `ficha`
--
ALTER TABLE `ficha`
  ADD PRIMARY KEY (`codficha`),
  ADD KEY `codpro` (`codpro`);

--
-- Indices de la tabla `programa`
--
ALTER TABLE `programa`
  ADD PRIMARY KEY (`codpro`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `aprendiz`
--
ALTER TABLE `aprendiz`
  MODIFY `idA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `aprendiz_ficha`
--
ALTER TABLE `aprendiz_ficha`
  MODIFY `idaf` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `aprendiz_ficha`
--
ALTER TABLE `aprendiz_ficha`
  ADD CONSTRAINT `aprendiz_ficha_ibfk_1` FOREIGN KEY (`codficha`) REFERENCES `ficha` (`codficha`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `aprendiz_ficha_ibfk_2` FOREIGN KEY (`idA`) REFERENCES `aprendiz` (`idA`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ficha`
--
ALTER TABLE `ficha`
  ADD CONSTRAINT `ficha_ibfk_1` FOREIGN KEY (`codpro`) REFERENCES `programa` (`codpro`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
