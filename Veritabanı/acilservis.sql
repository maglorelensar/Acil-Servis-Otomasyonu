-- --------------------------------------------------------
-- Sunucu:                       127.0.0.1
-- Sunucu sürümü:                10.4.12-MariaDB - mariadb.org binary distribution
-- Sunucu İşletim Sistemi:       Win64
-- HeidiSQL Sürüm:               10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- acilservis için veritabanı yapısı dökülüyor
CREATE DATABASE IF NOT EXISTS `acilservis` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `acilservis`;

-- tablo yapısı dökülüyor acilservis.hastagiris
CREATE TABLE IF NOT EXISTS `hastagiris` (
  `TC` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `Ad` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Soyad` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Tel` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Eposta` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Cinsiyet` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`TC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- acilservis.hastagiris: ~0 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `hastagiris` DISABLE KEYS */;
/*!40000 ALTER TABLE `hastagiris` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
