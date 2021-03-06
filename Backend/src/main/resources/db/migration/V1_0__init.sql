-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.20-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Verzió:              9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for itservices
CREATE DATABASE IF NOT EXISTS `itservices` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `itservices`;

-- Dumping structure for tábla itservices.applicationareas
CREATE TABLE IF NOT EXISTS `applicationareas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_4bhcewm4uytc5fuxa2woo44jp` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for tábla itservices.comments
CREATE TABLE IF NOT EXISTS `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL,
  `created_at` datetime NOT NULL,
  `edited_at` datetime NOT NULL,
  `text` varchar(255) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `service_request_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_prcqqctbkmo4906ms4trae88b` (`created_at`),
  UNIQUE KEY `UK_g5yk8flk1xbo40arhfkua23ig` (`edited_at`),
  UNIQUE KEY `UK_3s4mrmfxtlg5gxbsm04mknmms` (`text`),
  KEY `FK8omq0tc18jd43bu5tjh6jvraq` (`user_id`),
  KEY `FKdppqoxdamf5v991vy62jnhgkn` (`service_request_id`),
  CONSTRAINT `FK8omq0tc18jd43bu5tjh6jvraq` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKdppqoxdamf5v991vy62jnhgkn` FOREIGN KEY (`service_request_id`) REFERENCES `service_requests` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for tábla itservices.permissions
CREATE TABLE IF NOT EXISTS `permissions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_pnvtwliis6p05pn6i3ndjrqt2` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for tábla itservices.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ofx66keruapi6vyqpv6f2or37` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for tábla itservices.roles_permissions
CREATE TABLE IF NOT EXISTS `roles_permissions` (
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  KEY `FKrgsearyqx888evgyw6el3ot8o` (`permission_id`),
  KEY `FKtl7y42e4ssc8xeh46itoyp03x` (`role_id`),
  CONSTRAINT `FKrgsearyqx888evgyw6el3ot8o` FOREIGN KEY (`permission_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKtl7y42e4ssc8xeh46itoyp03x` FOREIGN KEY (`role_id`) REFERENCES `permissions` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for tábla itservices.schema_version
CREATE TABLE IF NOT EXISTS `schema_version` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `schema_version_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for tábla itservices.services
CREATE TABLE IF NOT EXISTS `services` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL,
  `average_responsetime` bigint(20) NOT NULL,
  `description` varchar(4000) NOT NULL,
  `icon_file_name` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `request_form` varchar(4000) DEFAULT NULL,
  `required_position` varchar(255) NOT NULL,
  `service_type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_h4rqgjwnqidx6mvj4i22dxwxe` (`name`),
  KEY `FK9htmf3b0pfrtfr35mduky2qrb` (`service_type_id`),
  CONSTRAINT `FK9htmf3b0pfrtfr35mduky2qrb` FOREIGN KEY (`service_type_id`) REFERENCES `service_types` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for tábla itservices.service_requests
CREATE TABLE IF NOT EXISTS `service_requests` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL,
  `date_of_request` datetime NOT NULL,
  `json_data` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `assigned_operator` int(11) DEFAULT NULL,
  `requested_service` int(11) DEFAULT NULL,
  `requester_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKickg1ib2vy5ggm5i2y0kt6hsq` (`assigned_operator`),
  KEY `FKkrekrkfoyubir9lkgndj78w2w` (`requested_service`),
  KEY `FKkx14c900w6r39qv0c99ahk223` (`requester_id`),
  CONSTRAINT `FKickg1ib2vy5ggm5i2y0kt6hsq` FOREIGN KEY (`assigned_operator`) REFERENCES `users` (`id`),
  CONSTRAINT `FKkrekrkfoyubir9lkgndj78w2w` FOREIGN KEY (`requested_service`) REFERENCES `services` (`id`),
  CONSTRAINT `FKkx14c900w6r39qv0c99ahk223` FOREIGN KEY (`requester_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for tábla itservices.service_types
CREATE TABLE IF NOT EXISTS `service_types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL,
  `service_type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_kwhl9uw1mlpjf0luss01sts02` (`service_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for tábla itservices.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `employeeid` varchar(255) NOT NULL,
  `forename` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`),
  KEY `FKp56c1712k691lhsyewcssf40f` (`role_id`),
  CONSTRAINT `FKp56c1712k691lhsyewcssf40f` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
