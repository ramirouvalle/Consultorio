-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 08-10-2016 a las 01:50:04
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
-- Estructura de tabla para la tabla `citas`
--

CREATE TABLE `citas` (
  `cit_id` int(11) NOT NULL COMMENT 'Identificador de la cita.',
  `cit_hora_inicial` time NOT NULL COMMENT 'Hora inicial de la cita.\n\nEl formato de almacenamiento de horas es de:\nHH:MM:SS (Horas:Minutos:Segundos)',
  `cit_hora_final` time NOT NULL COMMENT 'Hora final de la cita.\n\nEl formato de almacenamiento de horas es de:\nHH:MM:SS (Horas:Minutos:Segundos)',
  `cit_fecha` date NOT NULL COMMENT 'Día programado para la cita.\n\nEl formato de la fecha es:\nAño-Mes-Día ',
  `cit_fecha_extendida` datetime NOT NULL COMMENT 'Fecha extendida de la cita.\n\nEl formato de la fecha extendida de la cita es:\nAño-Mes-Día Horas:Minutos:Segundos'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Información del agendado de citas';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consultas`
--

CREATE TABLE `consultas` (
  `con_id` int(11) NOT NULL COMMENT 'Identificador de cada consulta.',
  `usu_id` int(11) DEFAULT NULL COMMENT 'Identificador del usuario que realizó la consulta.\n\nEl usuario que realice consulta deberá ser de tipo Doctor',
  `pac_id` int(11) DEFAULT NULL COMMENT 'Identificador del paciente.'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Información de cada consulta realizada';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `emp_id` int(11) NOT NULL COMMENT 'Identificador del usuario de la aplicación.',
  `emp_nombre` varchar(30) CHARACTER SET latin1 NOT NULL COMMENT 'Nombre(s) del usuario.',
  `emp_apellidos` varchar(30) CHARACTER SET latin1 NOT NULL COMMENT 'Apellidos del usuario',
  `emp_direccion` varchar(60) CHARACTER SET latin1 NOT NULL COMMENT 'Dirección de vivienda del usuario.La dirección deberá estar en el siguiente formato:Calle, Número interior o exterior, Colonia, Municipio',
  `emp_telefono` varchar(8) CHARACTER SET latin1 DEFAULT NULL COMMENT 'Teléfono fijo (de hogar) del usuario.',
  `emp_telefono_movil` varchar(10) CHARACTER SET latin1 DEFAULT NULL COMMENT 'Teléfono móvil (celular) del usuario',
  `emp_correo_electronico` varchar(60) CHARACTER SET latin1 DEFAULT NULL COMMENT 'Correo electrónico (e-mail) del usuario.',
  `emp_tipo` varchar(9) CHARACTER SET latin1 NOT NULL COMMENT 'Tipo de usuario a agregar.Los tipos de usuario son los siguientes:- Doctor- Asistente',
  `emp_user` varchar(50) NOT NULL,
  `emp_password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Información acerca de los usuarios de la aplicación.';

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`emp_id`, `emp_nombre`, `emp_apellidos`, `emp_direccion`, `emp_telefono`, `emp_telefono_movil`, `emp_correo_electronico`, `emp_tipo`, `emp_user`, `emp_password`) VALUES
(1, 'Ramiro Alejandro', 'Uvalle Vigueras', 'Nardo 626, 3 caminos', '81818181', '8117466318', 'ramiro@gmail.com', 'doctor', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pacientes`
--

CREATE TABLE `pacientes` (
  `pac_id` int(11) NOT NULL COMMENT 'Identificador de cada paciente.',
  `pac_nombre` varchar(30) NOT NULL COMMENT 'Nombre(s) del paciente.',
  `pac_apellidoPaterno` varchar(30) NOT NULL COMMENT 'Apellidos del paciente.',
  `pac_apellidoMaterno` varchar(30) NOT NULL,
  `pac_fechaNacimiento` varchar(10) NOT NULL COMMENT 'Edad del paciente.',
  `pac_genero` varchar(9) NOT NULL COMMENT 'Género del paciente:\n\n- Masculino\n- Femenino',
  `pac_direccion` varchar(60) NOT NULL COMMENT 'Dirección de vivienda del paciente.\n\nEn el siguiente formato:\nCalle, Número interior o exterior, Colonia',
  `pac_codigo_postal` varchar(5) NOT NULL COMMENT 'Código postal de la vivienda del paciente.',
  `pac_telefono` varchar(8) DEFAULT NULL COMMENT 'Teléfono fijo (de hogar u oficina) del paciente.',
  `pac_telefono_movil` varchar(10) DEFAULT NULL COMMENT 'Teléfono móvil (número de celular) del paciente.\n',
  `pac_correo` varchar(80) DEFAULT NULL COMMENT 'Correo electrónico (e-mail) del paciente.',
  `pac_responsable` varchar(60) DEFAULT NULL COMMENT 'Responsable del paciente.\n\nSi el paciente es menor de edad, el responsable es algún familiar.\nSi el paciente es casado, el responsable es su pareja.\nSi el paciente es soltero, debe de elegir una persona responsable.\n\nEl responsable es la persona a la que se notificará cualquier cosa además del paciente.',
  `pac_responsable_parentezco` varchar(30) DEFAULT NULL COMMENT 'Parentezco de la persona responsable.\n\nEl parentezco es, si el paciente es menor de edad, el familiar responsable, ya sea madre, padre, abuelo, etc.\nSi el paciente es casado, el parentezco de la persona responsable es su esposo/a.\n\nEjemplo:\nPaciente menor de edad\nResponsable: María del refugio Sandoval Martínez\nParentezco: Mamá ',
  `pac_referenciado` varchar(60) DEFAULT NULL COMMENT 'Referenciado del paciente.\n\nEl referenciado es, si por ejemplo, si algún otro Doctor recomendó el consultorio, el referenciado sería el nombre del Doctor que lo recomendó.',
  `pac_rfc` varchar(15) DEFAULT NULL COMMENT 'Registro Federal de Contribuyentes (RFC) del paciente.\n\nEsto es en caso de que el paciente (siempre y cuando tenga RFC) quiera alguna factura.',
  `pac_datos_especiales` varchar(150) DEFAULT NULL COMMENT 'Datos especiales del paciente.\n\nLos datos especiales son algo personal del paciente, ya sea gustos o algo con lo cual, el Doctor pueda llevar una amena relación Médico-Paciente.'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Información básica de un paciente	';

--
-- Volcado de datos para la tabla `pacientes`
--

INSERT INTO `pacientes` (`pac_id`, `pac_nombre`, `pac_apellidoPaterno`, `pac_apellidoMaterno`, `pac_fechaNacimiento`, `pac_genero`, `pac_direccion`, `pac_codigo_postal`, `pac_telefono`, `pac_telefono_movil`, `pac_correo`, `pac_responsable`, `pac_responsable_parentezco`, `pac_referenciado`, `pac_rfc`, `pac_datos_especiales`) VALUES
(1, 'katia', 'reina', 'sepulveda', '2016-10-07', 'Femenino', 'direcion tal, calle tal', '12345', '81818181', '8181818182', 'katia@gmail.com', '', '', '', '1234567890', ''),
(2, 'Ramiro', 'Uvalle', 'Vigueras', '2016-10-07', 'Masculino', 'Calle buen 777, colonia dia', '12548', '81828384', '8182838485', 'ramiro@gmail.com', '', '', '', '3216549871', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recetas`
--

CREATE TABLE `recetas` (
  `rec_id` int(11) NOT NULL COMMENT 'Identificador de la receta médica.',
  `usu_id` int(11) NOT NULL COMMENT 'Identificador del usuario que asigno la receta médica. \n\nEn este caso, el usuario debe de ser de tipo Doctor, ya que el tipo Asistente no puede crear recetas médicas.',
  `pac_id` int(11) NOT NULL COMMENT 'Identificador del paciente al que se asignó la receta médica.'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Información acerca de las recetas médicas.';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sesion`
--

CREATE TABLE `sesion` (
  `ses_id` int(11) NOT NULL COMMENT 'Identificador de la sesión.',
  `ses_nombre_usuario` varchar(20) NOT NULL COMMENT 'Nombre de usuario que inicie sesión.',
  `ses_contrasena` varchar(16) NOT NULL COMMENT 'Contraseña del usuario de inicio de sesión.',
  `ses_tipo_usuario` varchar(9) NOT NULL COMMENT 'Tipo de usuario a iniciar sesión.\n\nTipos de usuario:\n- Doctor\n- Asistente'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Información acerca de las sesiones de la aplicación';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sesion_detalles`
--

CREATE TABLE `sesion_detalles` (
  `sesdet_id` int(11) NOT NULL COMMENT 'Identificador de los detalles de inicio de sesión.\n\nEste identificador será el mismo que el identificador de la sesión.',
  `sesdet_fecha_inicio` datetime NOT NULL COMMENT 'Fecha de inicio del inicio de sesión.\n\nEl formato de la fecha es:\nAño-Mes-Día Horas:Minutos:Segundos',
  `sesdet_fecha_final` datetime DEFAULT NULL COMMENT 'Fecha de cierre de sesión.\n\nEl formato de la fecha es:\nAño-Mes-Día Horas:Minutos:Segundos'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Detalles acerca del inicio de sesión';

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `citas`
--
ALTER TABLE `citas`
  ADD PRIMARY KEY (`cit_id`);

--
-- Indices de la tabla `consultas`
--
ALTER TABLE `consultas`
  ADD PRIMARY KEY (`con_id`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`emp_id`);

--
-- Indices de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`pac_id`);

--
-- Indices de la tabla `recetas`
--
ALTER TABLE `recetas`
  ADD PRIMARY KEY (`rec_id`);

--
-- Indices de la tabla `sesion`
--
ALTER TABLE `sesion`
  ADD PRIMARY KEY (`ses_id`);

--
-- Indices de la tabla `sesion_detalles`
--
ALTER TABLE `sesion_detalles`
  ADD PRIMARY KEY (`sesdet_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `citas`
--
ALTER TABLE `citas`
  MODIFY `cit_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificador de la cita.';
--
-- AUTO_INCREMENT de la tabla `consultas`
--
ALTER TABLE `consultas`
  MODIFY `con_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificador de cada consulta.';
--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `emp_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificador del usuario de la aplicación.', AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  MODIFY `pac_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificador de cada paciente.', AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `recetas`
--
ALTER TABLE `recetas`
  MODIFY `rec_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificador de la receta médica.';
--
-- AUTO_INCREMENT de la tabla `sesion`
--
ALTER TABLE `sesion`
  MODIFY `ses_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificador de la sesión.';
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
