-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 13, 2019 at 12:06 AM
-- Server version: 8.0.12
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `knk`
--

-- --------------------------------------------------------

--
-- Table structure for table `adresat`
--

CREATE TABLE `adresat` (
  `idAdresa` int(11) NOT NULL,
  `idRajoni` int(11) NOT NULL,
  `idKomuna` int(11) NOT NULL,
  `Lagjja` varchar(255) NOT NULL,
  `idRruges` int(11) NOT NULL,
  `idObjektit` int(11) NOT NULL,
  `Latitude` double NOT NULL,
  `Longitude` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `adresat`
--

INSERT INTO `adresat` (`idAdresa`, `idRajoni`, `idKomuna`, `Lagjja`, `idRruges`, `idObjektit`, `Latitude`, `Longitude`) VALUES
(1, 1, 2, 'Lagjja e Spitalit', 2, 2, 15.4899, -1.0005),
(2, 1, 1, 'Lagjja e Re', 1, 1, 45.6699, 78.2555);

-- --------------------------------------------------------

--
-- Table structure for table `kahjet`
--

CREATE TABLE `kahjet` (
  `idKahjet` int(11) NOT NULL,
  `Kahu` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `komunat`
--

CREATE TABLE `komunat` (
  `idKomunat` int(11) NOT NULL,
  `EmriKomunes` varchar(255) NOT NULL,
  `KodiPostar` char(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `komunat`
--

INSERT INTO `komunat` (`idKomunat`, `EmriKomunes`, `KodiPostar`) VALUES
(1, 'Ferizaj', '70000'),
(2, 'Prishtine', '10000');

-- --------------------------------------------------------

--
-- Table structure for table `objektet`
--

CREATE TABLE `objektet` (
  `idObjekti` int(11) NOT NULL,
  `LlojiObjektit` varchar(255) NOT NULL,
  `NumriKateve` int(11) NOT NULL,
  `NumriHyrjes` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `objektet`
--

INSERT INTO `objektet` (`idObjekti`, `LlojiObjektit`, `NumriKateve`, `NumriHyrjes`) VALUES
(1, 'Biznis', 4, 12),
(2, 'Privat', 2, 14);

-- --------------------------------------------------------

--
-- Table structure for table `perdoruesit`
--

CREATE TABLE `perdoruesit` (
  `idPerdoruesit` int(11) NOT NULL,
  `Emri` varchar(255) NOT NULL,
  `Mbiemri` varchar(255) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `perdoruesit`
--

INSERT INTO `perdoruesit` (`idPerdoruesit`, `Emri`, `Mbiemri`, `Username`, `Password`, `Email`) VALUES
(1, 'Blerina', 'Fejza', 'blerinafejza', '7c222fb2927d828af22f592134e8932480637c0d', 'blerinafejza98@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `rajonet`
--

CREATE TABLE `rajonet` (
  `idRajoni` int(11) NOT NULL,
  `EmriRajonit` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `rajonet`
--

INSERT INTO `rajonet` (`idRajoni`, `EmriRajonit`) VALUES
(2, 'Rrafshi i Dukagjinit'),
(1, 'Rrafshi i Kosoves');

-- --------------------------------------------------------

--
-- Table structure for table `rruget`
--

CREATE TABLE `rruget` (
  `idRruget` int(11) NOT NULL,
  `Komuna` varchar(255) NOT NULL,
  `Fshati` varchar(255) DEFAULT NULL,
  `KodiRruges` varchar(255) NOT NULL,
  `EmriRruges` varchar(255) NOT NULL,
  `LlojiRruges` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `rruget`
--

INSERT INTO `rruget` (`idRruget`, `Komuna`, `Fshati`, `KodiRruges`, `EmriRruges`, `LlojiRruges`) VALUES
(1, 'Ferizaj', 'Komogllave', 'ADDB_456', 'Besim Rexhepi', 'Dytesore'),
(2, 'Prishtine', NULL, 'BGL_466', 'Malush Kosova', 'Dytesore');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adresat`
--
ALTER TABLE `adresat`
  ADD PRIMARY KEY (`idAdresa`),
  ADD UNIQUE KEY `idKomuna` (`idKomuna`,`idRruges`),
  ADD UNIQUE KEY `komuna_rruga` (`idKomuna`,`idRruges`),
  ADD KEY `idObjektit` (`idObjektit`),
  ADD KEY `idRajoni` (`idRajoni`),
  ADD KEY `idRruges` (`idRruges`);

--
-- Indexes for table `kahjet`
--
ALTER TABLE `kahjet`
  ADD PRIMARY KEY (`idKahjet`);

--
-- Indexes for table `komunat`
--
ALTER TABLE `komunat`
  ADD PRIMARY KEY (`idKomunat`),
  ADD UNIQUE KEY `EmriKomunes` (`EmriKomunes`);

--
-- Indexes for table `objektet`
--
ALTER TABLE `objektet`
  ADD PRIMARY KEY (`idObjekti`);

--
-- Indexes for table `perdoruesit`
--
ALTER TABLE `perdoruesit`
  ADD PRIMARY KEY (`idPerdoruesit`),
  ADD UNIQUE KEY `Email` (`Email`),
  ADD UNIQUE KEY `Username` (`Username`);

--
-- Indexes for table `rajonet`
--
ALTER TABLE `rajonet`
  ADD PRIMARY KEY (`idRajoni`),
  ADD UNIQUE KEY `EmriRajonit` (`EmriRajonit`);

--
-- Indexes for table `rruget`
--
ALTER TABLE `rruget`
  ADD PRIMARY KEY (`idRruget`),
  ADD UNIQUE KEY `unique_rruget` (`Komuna`,`EmriRruges`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adresat`
--
ALTER TABLE `adresat`
  MODIFY `idAdresa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `kahjet`
--
ALTER TABLE `kahjet`
  MODIFY `idKahjet` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `komunat`
--
ALTER TABLE `komunat`
  MODIFY `idKomunat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `objektet`
--
ALTER TABLE `objektet`
  MODIFY `idObjekti` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `perdoruesit`
--
ALTER TABLE `perdoruesit`
  MODIFY `idPerdoruesit` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `rajonet`
--
ALTER TABLE `rajonet`
  MODIFY `idRajoni` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `rruget`
--
ALTER TABLE `rruget`
  MODIFY `idRruget` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `adresat`
--
ALTER TABLE `adresat`
  ADD CONSTRAINT `adresat_ibfk_1` FOREIGN KEY (`idKomuna`) REFERENCES `komunat` (`idkomunat`) ON DELETE CASCADE,
  ADD CONSTRAINT `adresat_ibfk_2` FOREIGN KEY (`idObjektit`) REFERENCES `objektet` (`idobjekti`) ON DELETE CASCADE,
  ADD CONSTRAINT `adresat_ibfk_3` FOREIGN KEY (`idRajoni`) REFERENCES `rajonet` (`idrajoni`) ON DELETE CASCADE,
  ADD CONSTRAINT `adresat_ibfk_4` FOREIGN KEY (`idRruges`) REFERENCES `rruget` (`idrruget`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
