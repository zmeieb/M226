-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 08. Nov 2018 um 06:04
-- Server-Version: 10.1.36-MariaDB
-- PHP-Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `notendb`
--

DELIMITER $$
--
-- Prozeduren
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `AddFach` (IN `FachName` VARCHAR(45), IN `Fach_Id` INT)  NO SQL
insert into fach Value(Fach_Id,Fachname)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `AddNote` (IN `Noten_Id` INT, IN `Fach_ID` INT, IN `Gewichtung` INT, IN `ErhalteneNote` FLOAT)  NO SQL
Insert Into note VALUES(Noden_Id,Fach_Id,Gewichtung,ErhalteneNote)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteFach` (IN `Fach_ID` INT)  NO SQL
DELETE from fach where fach.Fach_ID = Fach_ID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteNote` (IN `Noten_Id` INT)  NO SQL
DELETE from Note where note.Noten_ID = Noden_Id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `LoadFaecher` ()  NO SQL
SELECT * from Fach$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `LoadNoten` ()  NO SQL
SELECT * from note$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateFach` (IN `Fach_IDParam` INT, IN `FachnameParam` VARCHAR(45))  NO SQL
Update Fach set Fach.Fachname= FachnameParam where Fach.Fach_ID = Fach_IDParam$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UpdateNote` (IN `Noten_ID` INT, IN `Fach_ID` INT, IN `Gewichtung` INT, IN `ErhalteneNote` FLOAT)  NO SQL
Update note set note.Fach_ID = Fach_ID, note.Gewichtung= Gewichtung, note.ErhalteneNote = ErhalteneNote where note.Noten_ID = Noten_ID$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `fach`
--

CREATE TABLE `fach` (
  `Fach_ID` int(11) NOT NULL,
  `Fachname` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `fach`
--

INSERT INTO `fach` (`Fach_ID`, `Fachname`) VALUES
(1, 'Mathe'),
(2, 'Englisch');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `note`
--

CREATE TABLE `note` (
  `Noten_ID` int(11) NOT NULL,
  `Fach_ID` int(11) NOT NULL,
  `Gewichtung` int(11) NOT NULL,
  `ErhalteneNote` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `note`
--

INSERT INTO `note` (`Noten_ID`, `Fach_ID`, `Gewichtung`, `ErhalteneNote`) VALUES
(1, 1, 100, 5.9);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `fach`
--
ALTER TABLE `fach`
  ADD PRIMARY KEY (`Fach_ID`);

--
-- Indizes für die Tabelle `note`
--
ALTER TABLE `note`
  ADD PRIMARY KEY (`Noten_ID`),
  ADD KEY `Fach_ID` (`Fach_ID`);

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `note`
--
ALTER TABLE `note`
  ADD CONSTRAINT `Fach_ID` FOREIGN KEY (`Fach_ID`) REFERENCES `fach` (`Fach_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
