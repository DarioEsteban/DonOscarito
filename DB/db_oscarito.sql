-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-07-2021 a las 05:47:30
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_oscarito`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cancha`
--

CREATE TABLE `cancha` (
  `id_cancha` int(11) NOT NULL,
  `id_estado_cancha` int(11) DEFAULT NULL,
  `id_tipo_cancha` int(11) DEFAULT NULL,
  `valor_bloque` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cancha`
--

INSERT INTO `cancha` (`id_cancha`, `id_estado_cancha`, `id_tipo_cancha`, `valor_bloque`) VALUES
(1, 1, 1, 4500);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_cancha`
--

CREATE TABLE `estado_cancha` (
  `id_estado_cancha` int(11) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estado_cancha`
--

INSERT INTO `estado_cancha` (`id_estado_cancha`, `descripcion`) VALUES
(1, 'Disponible'),
(2, 'Mantención'),
(3, 'No disponible');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_reserva`
--

CREATE TABLE `estado_reserva` (
  `id_estado_reserva` int(11) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estado_reserva`
--

INSERT INTO `estado_reserva` (`id_estado_reserva`, `descripcion`) VALUES
(1, 'Reservado'),
(2, 'Anulado'),
(3, 'Reagendado'),
(4, 'Pendiente de pago');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horario_disponible`
--

CREATE TABLE `horario_disponible` (
  `id_horario` int(11) NOT NULL,
  `id_cancha` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `bloque_inicio` time DEFAULT NULL,
  `bloque_fin` time DEFAULT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `horario_disponible`
--

INSERT INTO `horario_disponible` (`id_horario`, `id_cancha`, `fecha`, `bloque_inicio`, `bloque_fin`, `estado`) VALUES
(2, 1, '2021-06-20', '11:00:00', '11:59:00', 1),
(4, 1, '2021-06-20', '10:00:00', '10:59:00', 1),
(5, 1, '2021-06-20', '12:00:00', '12:59:00', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

CREATE TABLE `pago` (
  `id_pago` int(11) NOT NULL,
  `metodo` varchar(10) DEFAULT NULL,
  `monto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pago`
--

INSERT INTO `pago` (`id_pago`, `metodo`, `monto`) VALUES
(1, 'debito', 4500);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `id_reserva` int(11) NOT NULL,
  `id_cancha` int(11) NOT NULL,
  `fecha_reserva` date NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_pago` int(11) DEFAULT NULL,
  `id_estado_reserva` int(11) NOT NULL,
  `bloque_inicio` int(11) DEFAULT NULL,
  `bloque_fin` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`id_reserva`, `id_cancha`, `fecha_reserva`, `id_usuario`, `id_pago`, `id_estado_reserva`, `bloque_inicio`, `bloque_fin`) VALUES
(1, 1, '2021-06-21', 2, NULL, 2, 2, 2),
(2, 1, '2021-06-22', 2, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_cancha`
--

CREATE TABLE `tipo_cancha` (
  `id_tipo_cancha` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `capacidad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_cancha`
--

INSERT INTO `tipo_cancha` (`id_tipo_cancha`, `nombre`, `capacidad`) VALUES
(1, 'Tenis', 4),
(2, 'Futbolito', 17),
(3, 'Baby_Futbol', 10),
(4, 'Futbol', 22),
(5, 'Voleybol', 12),
(6, 'Basquetbol', 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_usuario`
--

CREATE TABLE `tipo_usuario` (
  `id_tipo_usuario` int(11) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_usuario`
--

INSERT INTO `tipo_usuario` (`id_tipo_usuario`, `descripcion`) VALUES
(1, 'Administrador'),
(2, 'Recepcionista'),
(3, 'Cliente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `id_tipo_usuario` int(11) DEFAULT NULL,
  `nombre` varchar(15) DEFAULT NULL,
  `apellido` varchar(15) DEFAULT NULL,
  `email` varchar(15) DEFAULT NULL,
  `telefono` varchar(9) DEFAULT NULL,
  `contrasena` varchar(20) CHARACTER SET latin1 COLLATE latin1_general_cs DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `id_tipo_usuario`, `nombre`, `apellido`, `email`, `telefono`, `contrasena`) VALUES
(1, 1, 'Matias', 'Gaete', 'matias', '123212', 'matias123'),
(2, 1, 'string6', 'Verdugo', 'string15', 'asddasasd', 'datio123');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cancha`
--
ALTER TABLE `cancha`
  ADD PRIMARY KEY (`id_cancha`),
  ADD KEY `fk_estado_cancha` (`id_estado_cancha`),
  ADD KEY `fk_tipo_cancha` (`id_tipo_cancha`);

--
-- Indices de la tabla `estado_cancha`
--
ALTER TABLE `estado_cancha`
  ADD PRIMARY KEY (`id_estado_cancha`);

--
-- Indices de la tabla `estado_reserva`
--
ALTER TABLE `estado_reserva`
  ADD PRIMARY KEY (`id_estado_reserva`);

--
-- Indices de la tabla `horario_disponible`
--
ALTER TABLE `horario_disponible`
  ADD PRIMARY KEY (`id_horario`,`id_cancha`,`fecha`),
  ADD KEY `fk_horario` (`id_cancha`);

--
-- Indices de la tabla `pago`
--
ALTER TABLE `pago`
  ADD PRIMARY KEY (`id_pago`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`id_reserva`),
  ADD KEY `fk_estado_reserva` (`id_estado_reserva`),
  ADD KEY `fk_pago` (`id_pago`),
  ADD KEY `fk_usuario` (`id_usuario`),
  ADD KEY `id_cancha` (`id_cancha`);

--
-- Indices de la tabla `tipo_cancha`
--
ALTER TABLE `tipo_cancha`
  ADD PRIMARY KEY (`id_tipo_cancha`);

--
-- Indices de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  ADD PRIMARY KEY (`id_tipo_usuario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `fk_tipo_usuario` (`id_tipo_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cancha`
--
ALTER TABLE `cancha`
  MODIFY `id_cancha` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `estado_cancha`
--
ALTER TABLE `estado_cancha`
  MODIFY `id_estado_cancha` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `estado_reserva`
--
ALTER TABLE `estado_reserva`
  MODIFY `id_estado_reserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `horario_disponible`
--
ALTER TABLE `horario_disponible`
  MODIFY `id_horario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `pago`
--
ALTER TABLE `pago`
  MODIFY `id_pago` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `id_reserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tipo_cancha`
--
ALTER TABLE `tipo_cancha`
  MODIFY `id_tipo_cancha` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  MODIFY `id_tipo_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cancha`
--
ALTER TABLE `cancha`
  ADD CONSTRAINT `fk_estado_cancha` FOREIGN KEY (`id_estado_cancha`) REFERENCES `estado_cancha` (`id_estado_cancha`),
  ADD CONSTRAINT `fk_tipo_cancha` FOREIGN KEY (`id_tipo_cancha`) REFERENCES `tipo_cancha` (`id_tipo_cancha`);

--
-- Filtros para la tabla `horario_disponible`
--
ALTER TABLE `horario_disponible`
  ADD CONSTRAINT `fk_horario` FOREIGN KEY (`id_cancha`) REFERENCES `cancha` (`id_cancha`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `fk_cancha` FOREIGN KEY (`id_cancha`) REFERENCES `cancha` (`id_cancha`),
  ADD CONSTRAINT `fk_estado_reserva` FOREIGN KEY (`id_estado_reserva`) REFERENCES `estado_reserva` (`id_estado_reserva`),
  ADD CONSTRAINT `fk_pago` FOREIGN KEY (`id_pago`) REFERENCES `pago` (`id_pago`),
  ADD CONSTRAINT `fk_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_tipo_usuario` FOREIGN KEY (`id_tipo_usuario`) REFERENCES `tipo_usuario` (`id_tipo_usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
