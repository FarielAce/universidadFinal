-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-09-2023 a las 15:38:08
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `universidad`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `idAlumno` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `fechaNac` date NOT NULL,
  `estado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`idAlumno`, `dni`, `apellido`, `nombre`, `fechaNac`, `estado`) VALUES
(2, 23545678, 'Gonzalez', 'Andres', '1986-04-16', 1),
(3, 45678987, 'Perez', 'Alejandro', '1995-01-10', 1),
(4, 25689574, 'Ramirez', 'Sebastian', '1989-10-15', 1),
(5, 25369852, 'Fernandez', 'Gustavo', '1995-03-26', 1),
(6, 63985454, 'Huges', 'Christian', '1986-03-26', 1),
(7, 23456543, 'Ronaldo', 'cristiano', '1999-02-28', 1),
(8, 44125865, 'Marquez', 'Jorge', '1995-02-22', 1),
(9, 25365874, 'Marquez', 'Javier', '1995-02-24', 1),
(10, 12345678, 'Pérez García', 'Juan', '1995-03-15', 1),
(14, 56789012, 'López Pérez', 'Diego', '1993-09-28', 1),
(17, 89012345, 'Pérez Martínez', 'Sofía', '1999-08-18', 1),
(20, 23456789, 'Martínez López', 'Jorge', '1994-03-30', 1),
(21, 34567890, 'Pérez Fernández', 'Valentina', '1997-05-14', 1),
(22, 45678901, 'Sánchez González', 'Felipe', '1996-10-03', 1),
(24, 67890123, 'García López', 'Matías', '1998-11-23', 1),
(25, 78901234, 'Fernández Pérez', 'Valeria', '1999-07-19', 1),
(26, 90123456, 'González Sánchez', 'Sebastián', '1993-04-02', 1),
(36, 123, 'Acevedo', 'fernando ariel', '1983-06-28', 1),
(37, 987, 'cristian', 'fernandez', '2023-09-12', 1),
(38, 13, 'asd', 'gds', '2023-09-03', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripciones`
--

CREATE TABLE `inscripciones` (
  `idInscripciones` int(11) NOT NULL,
  `idAlumno` int(11) NOT NULL,
  `idMateria` int(11) NOT NULL,
  `nota` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materias`
--

CREATE TABLE `materias` (
  `idMateria` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `anio` int(11) NOT NULL,
  `estado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `materias`
--

INSERT INTO `materias` (`idMateria`, `nombre`, `anio`, `estado`) VALUES
(1, 'Matematicas', 1, 0),
(2, 'Historia', 1, 1),
(3, 'Geografia', 1, 1),
(4, 'Lengua', 1, 1),
(5, 'Matemáticas 1ro', 1, 1),
(6, 'Ciencias de la Computación 1ro', 1, 1),
(7, 'Historia 1ro', 1, 1),
(8, 'Literatura 1ro', 1, 1),
(9, 'Biología 1ro', 1, 1),
(10, 'Química 1ro', 1, 1),
(11, 'Física 1ro', 1, 1),
(12, 'Inglés 1ro', 1, 1),
(13, 'Arte 1ro', 1, 1),
(14, 'Educación Física 1ro', 1, 1),
(15, 'Matemáticas 2do', 2, 1),
(16, 'Ciencias de la Computación 2do', 2, 1),
(17, 'Historia 2do', 2, 1),
(18, 'Literatura 2do', 2, 1),
(19, 'Biología 2do', 2, 1),
(20, 'Química 2do', 2, 1),
(21, 'Física 2do', 2, 1),
(22, 'Inglés 2do', 2, 1),
(23, 'Arte 2do', 2, 1),
(24, 'Educación Física 2do', 2, 1),
(25, 'Matemáticas 3ro', 3, 1),
(26, 'Ciencias de la Computación 3ro', 3, 1),
(27, 'Historia 3ro', 3, 1),
(28, 'Literatura 3ro', 3, 1),
(29, 'Biología 3ro', 3, 1),
(30, 'Química 3ro', 3, 1),
(31, 'Física 3ro', 3, 1),
(32, 'Inglés 3ro', 3, 1),
(33, 'Arte 3ro', 3, 1),
(34, 'Educación Física 3ro', 3, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`idAlumno`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `inscripciones`
--
ALTER TABLE `inscripciones`
  ADD PRIMARY KEY (`idInscripciones`),
  ADD KEY `idAlumno` (`idAlumno`),
  ADD KEY `idMateria` (`idMateria`);

--
-- Indices de la tabla `materias`
--
ALTER TABLE `materias`
  ADD PRIMARY KEY (`idMateria`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  MODIFY `idAlumno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT de la tabla `inscripciones`
--
ALTER TABLE `inscripciones`
  MODIFY `idInscripciones` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT de la tabla `materias`
--
ALTER TABLE `materias`
  MODIFY `idMateria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `inscripciones`
--
ALTER TABLE `inscripciones`
  ADD CONSTRAINT `inscripciones_ibfk_1` FOREIGN KEY (`idAlumno`) REFERENCES `alumnos` (`idAlumno`),
  ADD CONSTRAINT `inscripciones_ibfk_2` FOREIGN KEY (`idMateria`) REFERENCES `materias` (`idMateria`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
