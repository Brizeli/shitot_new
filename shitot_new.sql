-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 07, 2016 at 10:14 AM
-- Server version: 5.7.9
-- PHP Version: 5.6.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shitot_new`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
CREATE TABLE IF NOT EXISTS `appointment` (
  `id` int(11) NOT NULL,
  `applyDate` date DEFAULT NULL,
  `appointmentDate` date DEFAULT NULL,
  `checkNumber` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `paymentAmount` varchar(255) DEFAULT NULL,
  `paymentDate` date DEFAULT NULL,
  `alternativeDoctor_id` int(11) DEFAULT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  `patient_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK28xlnhg831uvyrrvxt1fg4w8u` (`alternativeDoctor_id`),
  KEY `FK51y2ce12yp0g0hgsa39p2u9jq` (`doctor_id`),
  KEY `FK3mbue9w5cldlnxx3hm15t5sfo` (`patient_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`id`, `applyDate`, `appointmentDate`, `checkNumber`, `description`, `paymentAmount`, `paymentDate`, `alternativeDoctor_id`, `doctor_id`, `patient_id`) VALUES
(55, '2005-08-27', '2004-06-26', '43', 'blah-blah-blah', '300$', '2005-04-26', 14, 7, 43),
(56, '2014-04-14', '2000-08-11', '43', 'blah-blah-blah', '300$', '2015-07-24', 14, 7, 35),
(57, '2009-03-16', '2000-07-13', '43', 'blah-blah-blah', '300$', '2011-05-10', NULL, 14, 41),
(58, '2004-02-22', '2014-09-12', '43', 'blah-blah-blah', '300$', '2007-04-13', NULL, 14, 52),
(59, '2002-01-25', '2014-03-11', '43', 'blah-blah-blah', '300$', '2000-09-18', 14, 7, 38),
(60, '2003-07-11', '2005-09-15', '43', 'blah-blah-blah', '300$', '2010-02-22', 14, 14, 43),
(61, '2012-05-23', '2015-08-19', '43', 'blah-blah-blah', '300$', '2005-08-20', 14, 14, 46),
(62, '2009-09-16', '2014-06-19', '43', 'blah-blah-blah', '300$', '2002-02-15', 7, 14, 32),
(63, '2009-04-12', '2001-03-27', '43', 'blah-blah-blah', '300$', '2006-04-10', 14, 14, 26),
(64, '2012-03-15', '2005-01-16', '43', 'blah-blah-blah', '300$', '2003-02-12', 7, 14, 47);

-- --------------------------------------------------------

--
-- Table structure for table `appointments`
--

DROP TABLE IF EXISTS `appointments`;
CREATE TABLE IF NOT EXISTS `appointments` (
  `id` int(11) NOT NULL,
  `applyDate` date DEFAULT NULL,
  `appointmentDate` date DEFAULT NULL,
  `checkNumber` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `paymentAmount` varchar(255) DEFAULT NULL,
  `paymentDate` date DEFAULT NULL,
  `alternativeDoctor_id` int(11) DEFAULT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  `patient_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc932r6mytjsmxoxtm32lm3401` (`alternativeDoctor_id`),
  KEY `FKmujeo4tymoo98cmf7uj3vsv76` (`doctor_id`),
  KEY `FK8exap5wmg8kmb1g1rx3by21yt` (`patient_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appointments`
--

INSERT INTO `appointments` (`id`, `applyDate`, `appointmentDate`, `checkNumber`, `description`, `paymentAmount`, `paymentDate`, `alternativeDoctor_id`, `doctor_id`, `patient_id`) VALUES
(62, '2003-08-24', '2008-05-16', '43', 'blah-blah-blah', '300$', '2010-05-25', 21, 21, 46),
(63, '2002-02-16', '2007-08-28', '43', 'blah-blah-blah', '300$', '2002-04-14', 6, 21, 27),
(64, '2011-07-25', '2014-07-28', '43', 'blah-blah-blah', '300$', '2005-07-28', NULL, 6, 22),
(65, '2010-09-20', '2001-04-23', '43', 'blah-blah-blah', '300$', '2007-05-16', 6, 6, 60),
(66, '2009-02-28', '2014-06-14', '43', 'blah-blah-blah', '300$', '2005-02-24', 21, 21, 23),
(67, '2009-06-20', '2000-01-20', '43', 'blah-blah-blah', '300$', '2011-02-15', 21, 21, 27),
(68, '2004-09-23', '2003-02-19', '43', 'blah-blah-blah', '300$', '2011-01-16', 6, 21, 53),
(69, '2006-05-11', '2008-07-11', '43', 'blah-blah-blah', '300$', '2005-08-24', 6, 21, 52),
(70, '2010-02-17', '2005-07-24', '43', 'blah-blah-blah', '300$', '2007-09-28', 6, 21, 40),
(71, '2003-05-22', '2003-09-10', '43', 'blah-blah-blah', '300$', '2009-09-22', 21, 21, 45);

-- --------------------------------------------------------

--
-- Table structure for table `appointments_problems`
--

DROP TABLE IF EXISTS `appointments_problems`;
CREATE TABLE IF NOT EXISTS `appointments_problems` (
  `appointments_id` int(11) NOT NULL,
  `problems_name` varchar(255) NOT NULL,
  PRIMARY KEY (`appointments_id`,`problems_name`),
  KEY `FKco9f5n85esg0ct0sy6ek6hh8o` (`problems_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appointments_problems`
--

INSERT INTO `appointments_problems` (`appointments_id`, `problems_name`) VALUES
(62, 'Problem1'),
(63, 'Problem5'),
(64, 'Problem14'),
(64, 'Problem20'),
(64, 'Problem5'),
(65, 'Problem10'),
(65, 'Problem12'),
(65, 'Problem16'),
(66, 'Problem17'),
(67, 'Problem2'),
(67, 'Problem4'),
(67, 'Problem5'),
(67, 'Problem9'),
(68, 'Problem10'),
(68, 'Problem14'),
(68, 'Problem17'),
(68, 'Problem4'),
(69, 'Problem1'),
(69, 'Problem13'),
(69, 'Problem6'),
(69, 'Problem9'),
(70, 'Problem19'),
(71, 'Problem3');

-- --------------------------------------------------------

--
-- Table structure for table `appointments_symptoms`
--

DROP TABLE IF EXISTS `appointments_symptoms`;
CREATE TABLE IF NOT EXISTS `appointments_symptoms` (
  `appointments_id` int(11) NOT NULL,
  `symptoms_name` varchar(255) NOT NULL,
  PRIMARY KEY (`appointments_id`,`symptoms_name`),
  KEY `FK8ldab2xkmtsruhmrbb4ge5df6` (`symptoms_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appointments_symptoms`
--

INSERT INTO `appointments_symptoms` (`appointments_id`, `symptoms_name`) VALUES
(62, 'Symptom12'),
(62, 'Symptom13'),
(62, 'Symptom19'),
(62, 'Symptom2'),
(63, 'Symptom10'),
(63, 'Symptom17'),
(63, 'Symptom2'),
(64, 'Symptom1'),
(64, 'Symptom20'),
(64, 'Symptom9'),
(65, 'Symptom6'),
(65, 'Symptom7'),
(66, 'Symptom1'),
(66, 'Symptom17'),
(67, 'Symptom12'),
(67, 'Symptom13'),
(67, 'Symptom16'),
(68, 'Symptom1'),
(68, 'Symptom18'),
(69, 'Symptom18'),
(69, 'Symptom6'),
(69, 'Symptom9'),
(70, 'Symptom12'),
(70, 'Symptom7'),
(71, 'Symptom11'),
(71, 'Symptom12'),
(71, 'Symptom15');

-- --------------------------------------------------------

--
-- Table structure for table `appointment_problems`
--

DROP TABLE IF EXISTS `appointment_problems`;
CREATE TABLE IF NOT EXISTS `appointment_problems` (
  `appointments_id` int(11) NOT NULL,
  `problems_name` varchar(255) NOT NULL,
  PRIMARY KEY (`appointments_id`,`problems_name`),
  KEY `FK9vvxs4n3224346ta0tmx7y9mk` (`problems_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appointment_problems`
--

INSERT INTO `appointment_problems` (`appointments_id`, `problems_name`) VALUES
(55, 'Problem10'),
(55, 'Problem11'),
(55, 'Problem13'),
(55, 'Problem20'),
(56, 'Problem1'),
(56, 'Problem4'),
(57, 'Problem15'),
(57, 'Problem4'),
(58, 'Problem18'),
(58, 'Problem7'),
(59, 'Problem12'),
(59, 'Problem8'),
(59, 'Problem9'),
(60, 'Problem13'),
(60, 'Problem17'),
(60, 'Problem19'),
(60, 'Problem7'),
(61, 'Problem14'),
(61, 'Problem16'),
(61, 'Problem20'),
(61, 'Problem4'),
(62, 'Problem1'),
(62, 'Problem10'),
(63, 'Problem10'),
(63, 'Problem4'),
(63, 'Problem8'),
(63, 'Problem9'),
(64, 'Problem10'),
(64, 'Problem14'),
(64, 'Problem17');

-- --------------------------------------------------------

--
-- Table structure for table `appointment_symptoms`
--

DROP TABLE IF EXISTS `appointment_symptoms`;
CREATE TABLE IF NOT EXISTS `appointment_symptoms` (
  `appointments_id` int(11) NOT NULL,
  `symptoms_name` varchar(255) NOT NULL,
  PRIMARY KEY (`appointments_id`,`symptoms_name`),
  KEY `FKtns1i7t6sq15n12c2mkxs0fwg` (`symptoms_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appointment_symptoms`
--

INSERT INTO `appointment_symptoms` (`appointments_id`, `symptoms_name`) VALUES
(55, 'Symptom10'),
(55, 'Symptom18'),
(55, 'Symptom6'),
(55, 'Symptom9'),
(56, 'Symptom14'),
(56, 'Symptom19'),
(56, 'Symptom20'),
(56, 'Symptom9'),
(57, 'Symptom16'),
(58, 'Symptom1'),
(58, 'Symptom17'),
(59, 'Symptom20'),
(60, 'Symptom1'),
(60, 'Symptom12'),
(60, 'Symptom13'),
(60, 'Symptom20'),
(61, 'Symptom10'),
(61, 'Symptom15'),
(61, 'Symptom7'),
(61, 'Symptom8'),
(62, 'Symptom6'),
(62, 'Symptom7'),
(63, 'Symptom16'),
(63, 'Symptom17'),
(63, 'Symptom6'),
(63, 'Symptom9'),
(64, 'Symptom14'),
(64, 'Symptom6');

-- --------------------------------------------------------

--
-- Table structure for table `audiences`
--

DROP TABLE IF EXISTS `audiences`;
CREATE TABLE IF NOT EXISTS `audiences` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `audiences`
--

INSERT INTO `audiences` (`name`) VALUES
('Adults'),
('Children'),
('Eldery'),
('Teens');

-- --------------------------------------------------------

--
-- Table structure for table `certificates`
--

DROP TABLE IF EXISTS `certificates`;
CREATE TABLE IF NOT EXISTS `certificates` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `certificates`
--

INSERT INTO `certificates` (`name`) VALUES
('Cert1'),
('Cert2');

-- --------------------------------------------------------

--
-- Table structure for table `clinics`
--

DROP TABLE IF EXISTS `clinics`;
CREATE TABLE IF NOT EXISTS `clinics` (
  `id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrvj131ww4gdr8alqttnt02wde` (`doctor_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clinics`
--

INSERT INTO `clinics` (`id`, `address`, `city`, `name`, `doctor_id`) VALUES
(2, 'Address1', 'Tel Aviv', 'Clinic1', 6),
(5, 'Address2', 'Tel Aviv', 'Clinic2', 6),
(12, 'Address3', 'Tel Aviv', 'Clinic3', 21),
(20, 'Address4', 'Haifa', 'Clinic4', 21);

-- --------------------------------------------------------

--
-- Table structure for table `doctors`
--

DROP TABLE IF EXISTS `doctors`;
CREATE TABLE IF NOT EXISTS `doctors` (
  `id` int(11) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `fullName` varchar(255) NOT NULL,
  `homeAddress` varchar(255) DEFAULT NULL,
  `lections` varchar(255) DEFAULT NULL,
  `preferential` varchar(255) DEFAULT NULL,
  `telHome` varchar(255) DEFAULT NULL,
  `telNumber` varchar(255) DEFAULT NULL,
  `certificate_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_seuh09bpwiw66cwrmrmflrmeg` (`login`),
  UNIQUE KEY `UK_caifv0va46t2mu85cg5afmayf` (`email`),
  KEY `FK5ke1h7e75h4m5spbhuydpd8rq` (`certificate_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctors`
--

INSERT INTO `doctors` (`id`, `enabled`, `login`, `password`, `role`, `comments`, `email`, `fullName`, `homeAddress`, `lections`, `preferential`, `telHome`, `telNumber`, `certificate_name`) VALUES
(6, b'1', 'DoctorLogin1', 'DoctorPwd1', 'DOCTOR', 'Comm1', 'DtrEmail1@gmail.com', 'Doctor1', 'DoctorHome1', 'Lection of 1', 'prefer1', NULL, 'telN1', 'Cert1'),
(21, b'1', 'DoctorLogin2', 'DoctorPwd2', 'DOCTOR', 'Comm2', 'DtrEmail2@gmail.com', 'Doctor2', 'DoctorHome2', 'Lection of 2', 'prefer2', NULL, 'telN2', 'Cert2');

-- --------------------------------------------------------

--
-- Table structure for table `doctors_audiences`
--

DROP TABLE IF EXISTS `doctors_audiences`;
CREATE TABLE IF NOT EXISTS `doctors_audiences` (
  `doctors_id` int(11) NOT NULL,
  `targetAudiences_name` varchar(255) NOT NULL,
  PRIMARY KEY (`doctors_id`,`targetAudiences_name`),
  KEY `FKbj5k4el7cgaqxqh63n5vb0hg2` (`targetAudiences_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctors_audiences`
--

INSERT INTO `doctors_audiences` (`doctors_id`, `targetAudiences_name`) VALUES
(6, 'Children'),
(6, 'Eldery'),
(21, 'Adults'),
(21, 'Children'),
(21, 'Eldery'),
(21, 'Teens');

-- --------------------------------------------------------

--
-- Table structure for table `doctors_qualifications`
--

DROP TABLE IF EXISTS `doctors_qualifications`;
CREATE TABLE IF NOT EXISTS `doctors_qualifications` (
  `doctors_id` int(11) NOT NULL,
  `qualifications_name` varchar(255) NOT NULL,
  PRIMARY KEY (`doctors_id`,`qualifications_name`),
  KEY `FK3ana1sct6wgoo0j28od2km0ia` (`qualifications_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctors_qualifications`
--

INSERT INTO `doctors_qualifications` (`doctors_id`, `qualifications_name`) VALUES
(6, 'Qual1'),
(6, 'Qual2'),
(6, 'Qual3'),
(6, 'Qual4'),
(21, 'Qual2');

-- --------------------------------------------------------

--
-- Table structure for table `doctors_specialties`
--

DROP TABLE IF EXISTS `doctors_specialties`;
CREATE TABLE IF NOT EXISTS `doctors_specialties` (
  `doctors_id` int(11) NOT NULL,
  `specialties_name` varchar(255) NOT NULL,
  PRIMARY KEY (`doctors_id`,`specialties_name`),
  KEY `FKk7pt7ujl87w675do16ow5fh1i` (`specialties_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctors_specialties`
--

INSERT INTO `doctors_specialties` (`doctors_id`, `specialties_name`) VALUES
(6, 'Spec2'),
(21, 'Spec5');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(75),
(75),
(75),
(75),
(75),
(75);

-- --------------------------------------------------------

--
-- Table structure for table `intervals`
--

DROP TABLE IF EXISTS `intervals`;
CREATE TABLE IF NOT EXISTS `intervals` (
  `hour` int(11) NOT NULL,
  PRIMARY KEY (`hour`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `intervals`
--

INSERT INTO `intervals` (`hour`) VALUES
(0),
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10),
(11),
(12),
(13),
(14),
(15),
(16),
(17),
(18),
(19),
(20),
(21),
(22),
(23);

-- --------------------------------------------------------

--
-- Table structure for table `patients`
--

DROP TABLE IF EXISTS `patients`;
CREATE TABLE IF NOT EXISTS `patients` (
  `id` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `telNumber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patients`
--

INSERT INTO `patients` (`id`, `age`, `name`, `telNumber`) VALUES
(22, 78, 'Patient1', '052XXXXXXX'),
(23, 53, 'Patient2', '052XXXXXXX'),
(24, 21, 'Patient3', '052XXXXXXX'),
(25, 20, 'Patient4', '052XXXXXXX'),
(26, 52, 'Patient5', '052XXXXXXX'),
(27, 12, 'Patient6', '052XXXXXXX'),
(28, 7, 'Patient7', '052XXXXXXX'),
(29, 1, 'Patient8', '052XXXXXXX'),
(30, 69, 'Patient9', '052XXXXXXX'),
(31, 18, 'Patient10', '052XXXXXXX'),
(32, 55, 'Patient11', '052XXXXXXX'),
(33, 11, 'Patient12', '052XXXXXXX'),
(34, 45, 'Patient13', '052XXXXXXX'),
(35, 52, 'Patient14', '052XXXXXXX'),
(36, 73, 'Patient15', '052XXXXXXX'),
(37, 18, 'Patient16', '052XXXXXXX'),
(38, 48, 'Patient17', '052XXXXXXX'),
(39, 45, 'Patient18', '052XXXXXXX'),
(40, 29, 'Patient19', '052XXXXXXX'),
(41, 39, 'Patient20', '052XXXXXXX'),
(42, 50, 'Patient21', '052XXXXXXX'),
(43, 78, 'Patient22', '052XXXXXXX'),
(44, 23, 'Patient23', '052XXXXXXX'),
(45, 33, 'Patient24', '052XXXXXXX'),
(46, 74, 'Patient25', '052XXXXXXX'),
(47, 3, 'Patient26', '052XXXXXXX'),
(48, 61, 'Patient27', '052XXXXXXX'),
(49, 15, 'Patient28', '052XXXXXXX'),
(50, 34, 'Patient29', '052XXXXXXX'),
(51, 80, 'Patient30', '052XXXXXXX'),
(52, 7, 'Patient31', '052XXXXXXX'),
(53, 55, 'Patient32', '052XXXXXXX'),
(54, 50, 'Patient33', '052XXXXXXX'),
(55, 8, 'Patient34', '052XXXXXXX'),
(56, 71, 'Patient35', '052XXXXXXX'),
(57, 66, 'Patient36', '052XXXXXXX'),
(58, 12, 'Patient37', '052XXXXXXX'),
(59, 66, 'Patient38', '052XXXXXXX'),
(60, 69, 'Patient39', '052XXXXXXX'),
(61, 70, 'Patient40', '052XXXXXXX');

-- --------------------------------------------------------

--
-- Table structure for table `problems`
--

DROP TABLE IF EXISTS `problems`;
CREATE TABLE IF NOT EXISTS `problems` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `problems`
--

INSERT INTO `problems` (`name`) VALUES
('Problem1'),
('Problem10'),
('Problem11'),
('Problem12'),
('Problem13'),
('Problem14'),
('Problem15'),
('Problem16'),
('Problem17'),
('Problem18'),
('Problem19'),
('Problem2'),
('Problem20'),
('Problem3'),
('Problem4'),
('Problem5'),
('Problem6'),
('Problem7'),
('Problem8'),
('Problem9');

-- --------------------------------------------------------

--
-- Table structure for table `qualifications`
--

DROP TABLE IF EXISTS `qualifications`;
CREATE TABLE IF NOT EXISTS `qualifications` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `qualifications`
--

INSERT INTO `qualifications` (`name`) VALUES
('Qual1'),
('Qual2'),
('Qual3'),
('Qual4');

-- --------------------------------------------------------

--
-- Table structure for table `slots`
--

DROP TABLE IF EXISTS `slots`;
CREATE TABLE IF NOT EXISTS `slots` (
  `id` int(11) NOT NULL,
  `dayOfWeek` int(11) NOT NULL,
  `clinic_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKrsw3la1vi2382pfmt3qfb2h4h` (`dayOfWeek`,`clinic_id`),
  KEY `FKfxfwgkl1x713obs1wcrt7uhyw` (`clinic_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `slots`
--

INSERT INTO `slots` (`id`, `dayOfWeek`, `clinic_id`) VALUES
(1, 4, 2),
(3, 0, 5),
(4, 1, 5),
(7, 0, 12),
(8, 1, 12),
(9, 3, 12),
(10, 5, 12),
(11, 6, 12),
(13, 0, 20),
(14, 1, 20),
(15, 2, 20),
(16, 3, 20),
(17, 4, 20),
(18, 5, 20),
(19, 6, 20);

-- --------------------------------------------------------

--
-- Table structure for table `slots_intervals`
--

DROP TABLE IF EXISTS `slots_intervals`;
CREATE TABLE IF NOT EXISTS `slots_intervals` (
  `slots_id` int(11) NOT NULL,
  `intervals_hour` int(11) NOT NULL,
  PRIMARY KEY (`slots_id`,`intervals_hour`),
  KEY `FKr9106jlqna0m48orixiunxrjg` (`intervals_hour`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `slots_intervals`
--

INSERT INTO `slots_intervals` (`slots_id`, `intervals_hour`) VALUES
(1, 0),
(1, 1),
(1, 3),
(1, 4),
(1, 7),
(1, 8),
(1, 10),
(1, 13),
(1, 14),
(1, 15),
(1, 17),
(1, 18),
(1, 19),
(1, 21),
(1, 23),
(3, 0),
(3, 1),
(3, 3),
(3, 4),
(3, 6),
(3, 8),
(3, 9),
(3, 10),
(3, 11),
(3, 12),
(3, 13),
(3, 15),
(3, 17),
(3, 18),
(3, 19),
(3, 20),
(3, 22),
(3, 23),
(4, 5),
(4, 7),
(4, 11),
(4, 12),
(4, 14),
(4, 19),
(4, 20),
(4, 23),
(7, 0),
(7, 2),
(7, 3),
(7, 4),
(7, 5),
(7, 6),
(7, 7),
(7, 8),
(7, 9),
(7, 12),
(7, 14),
(7, 15),
(7, 16),
(7, 18),
(7, 19),
(7, 20),
(7, 21),
(7, 22),
(7, 23),
(8, 0),
(8, 1),
(8, 2),
(8, 3),
(8, 4),
(8, 7),
(8, 9),
(8, 12),
(8, 13),
(8, 15),
(8, 16),
(8, 19),
(8, 21),
(8, 22),
(8, 23),
(9, 5),
(9, 10),
(9, 11),
(9, 13),
(10, 1),
(10, 2),
(10, 16),
(10, 17),
(10, 23),
(11, 1),
(11, 2),
(11, 3),
(11, 6),
(11, 7),
(11, 10),
(11, 11),
(11, 12),
(11, 13),
(11, 14),
(11, 15),
(11, 17),
(11, 18),
(11, 19),
(11, 20),
(11, 23),
(13, 8),
(13, 15),
(13, 19),
(13, 22),
(14, 1),
(14, 3),
(14, 4),
(14, 5),
(14, 6),
(14, 8),
(14, 9),
(14, 10),
(14, 11),
(14, 12),
(14, 15),
(14, 16),
(14, 17),
(14, 19),
(14, 20),
(14, 21),
(14, 22),
(15, 0),
(15, 1),
(15, 2),
(15, 3),
(15, 5),
(15, 6),
(15, 7),
(15, 10),
(15, 11),
(15, 12),
(15, 13),
(15, 14),
(15, 15),
(15, 16),
(15, 17),
(15, 18),
(15, 20),
(15, 21),
(15, 22),
(15, 23),
(16, 0),
(16, 6),
(16, 11),
(16, 12),
(16, 15),
(16, 16),
(16, 18),
(16, 20),
(16, 22),
(17, 1),
(17, 4),
(17, 5),
(17, 8),
(17, 14),
(17, 16),
(17, 17),
(17, 23),
(18, 0),
(18, 1),
(18, 3),
(18, 5),
(18, 6),
(18, 7),
(18, 8),
(18, 9),
(18, 10),
(18, 11),
(18, 12),
(18, 13),
(18, 14),
(18, 15),
(18, 16),
(18, 17),
(18, 18),
(18, 19),
(18, 20),
(18, 21),
(18, 22),
(18, 23),
(19, 0),
(19, 1),
(19, 2),
(19, 3),
(19, 4),
(19, 5),
(19, 6),
(19, 7),
(19, 8),
(19, 9),
(19, 10),
(19, 11),
(19, 12),
(19, 13),
(19, 14),
(19, 15),
(19, 16),
(19, 17),
(19, 18),
(19, 19),
(19, 20),
(19, 21),
(19, 22),
(19, 23);

-- --------------------------------------------------------

--
-- Table structure for table `specialties`
--

DROP TABLE IF EXISTS `specialties`;
CREATE TABLE IF NOT EXISTS `specialties` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `specialties`
--

INSERT INTO `specialties` (`name`) VALUES
('Spec1'),
('Spec10'),
('Spec11'),
('Spec12'),
('Spec2'),
('Spec3'),
('Spec4'),
('Spec5'),
('Spec6'),
('Spec7'),
('Spec8'),
('Spec9');

-- --------------------------------------------------------

--
-- Table structure for table `symptoms`
--

DROP TABLE IF EXISTS `symptoms`;
CREATE TABLE IF NOT EXISTS `symptoms` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `symptoms`
--

INSERT INTO `symptoms` (`name`) VALUES
('Symptom1'),
('Symptom10'),
('Symptom11'),
('Symptom12'),
('Symptom13'),
('Symptom14'),
('Symptom15'),
('Symptom16'),
('Symptom17'),
('Symptom18'),
('Symptom19'),
('Symptom2'),
('Symptom20'),
('Symptom3'),
('Symptom4'),
('Symptom5'),
('Symptom6'),
('Symptom7'),
('Symptom8'),
('Symptom9');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ow0gan20590jrb00upg3va2fn` (`login`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `enabled`, `login`, `password`, `role`) VALUES
(72, b'1', 'oper1', '123', 'USER');

-- --------------------------------------------------------

--
-- Stand-in structure for view `users_doctors`
--
DROP VIEW IF EXISTS `users_doctors`;
CREATE TABLE IF NOT EXISTS `users_doctors` (
`login` varchar(255)
,`password` varchar(255)
,`enabled` bit(1)
,`role` varchar(255)
);

-- --------------------------------------------------------

--
-- Structure for view `users_doctors`
--
DROP TABLE IF EXISTS `users_doctors`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `users_doctors`  AS  select `users`.`login` AS `login`,`users`.`password` AS `password`,`users`.`enabled` AS `enabled`,`users`.`role` AS `role` from `users` union select `doctors`.`login` AS `login`,`doctors`.`password` AS `password`,`doctors`.`enabled` AS `enabled`,`doctors`.`role` AS `role` from `doctors` ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
