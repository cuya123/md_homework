-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.5.8-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.1.0.6116
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- md_homework 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `md_homework` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `md_homework`;

-- 테이블 md_homework.apply_house 구조 내보내기
CREATE TABLE IF NOT EXISTS `apply_house` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `applicant` varchar(50) NOT NULL,
  `contact` varchar(50) NOT NULL,
  `starting_point` varchar(50) NOT NULL,
  `starting_point_floor` int(11) NOT NULL,
  `destination` varchar(50) NOT NULL,
  `destination_floor` int(11) NOT NULL,
  `moving_at` datetime NOT NULL,
  `is_storage_option` enum('Y','N') NOT NULL,
  `is_term_agree` enum('Y','N') NOT NULL,
  `is_personal_submit_agree` enum('Y','N') NOT NULL,
  `is_marketing_receive_agree` enum('Y','N') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_apply_house_info_customer` (`customer_id`),
  CONSTRAINT `FK_apply_house_info_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- 테이블 데이터 md_homework.apply_house:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `apply_house` DISABLE KEYS */;
INSERT INTO `apply_house` (`id`, `customer_id`, `applicant`, `contact`, `starting_point`, `starting_point_floor`, `destination`, `destination_floor`, `moving_at`, `is_storage_option`, `is_term_agree`, `is_personal_submit_agree`, `is_marketing_receive_agree`) VALUES
	(1, 13, '김자바', '010-6666-1111', '서울시 동작구 사당동 ', 14, '천안시 서북구 호밀동', 1, '2021-01-20 18:35:33', 'Y', 'Y', 'Y', 'Y'),
	(2, 20, '남도일', '010-7777-8888', '서울시 동작구 문래동 ', 14, '경기도 광주시 자이동', 1, '2021-01-21 02:06:44', 'N', 'Y', 'Y', 'Y'),
	(3, 21, '김노드', '010-2777-5885', '서울시 동작구 영진동', 14, '경기도 광주시 자이동', 1, '2021-01-21 02:07:59', 'Y', 'Y', 'Y', 'Y');
/*!40000 ALTER TABLE `apply_house` ENABLE KEYS */;

-- 테이블 md_homework.customer 구조 내보내기
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `contact` varchar(50) NOT NULL,
  `is_term_agree` enum('Y','N') NOT NULL,
  `is_personal_submit_agree` enum('Y','N') NOT NULL,
  `is_marketing_receive_agree` enum('Y','N') NOT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4;

-- 테이블 데이터 md_homework.customer:~6 rows (대략적) 내보내기
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`id`, `name`, `contact`, `is_term_agree`, `is_personal_submit_agree`, `is_marketing_receive_agree`, `created_at`) VALUES
	(3, '남현우', '01099998888', 'Y', 'N', 'N', '2021-01-09 20:54:31'),
	(4, '노자바', '01077776666', 'Y', 'N', 'N', '2021-01-09 20:55:14'),
	(5, '이노드', '01022223333', 'Y', 'N', 'N', '2021-01-09 20:55:14'),
	(6, '박씨샵', '01077778888', 'Y', 'N', 'N', '2021-01-10 18:24:16'),
	(13, '리엑트', '01077778888', 'Y', 'N', 'N', '2021-01-10 18:35:33'),
	(19, '김자바', '01077778888', 'Y', 'N', 'N', '2021-01-11 02:06:05'),
	(20, '남도일', '010-7777-8888', 'Y', 'N', 'N', '2021-01-11 02:06:44'),
	(21, '김노드', '010-2777-5885', 'Y', 'N', 'N', '2021-01-11 02:07:59');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- 테이블 md_homework.customer_feedback 구조 내보내기
CREATE TABLE IF NOT EXISTS `customer_feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `move_company_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `feed_content` text NOT NULL,
  `moving_type` enum('HOUSE','STUDIO') NOT NULL,
  `is_info_open_agree` enum('Y','N') NOT NULL,
  `professional_satisfy_degree` tinyint(4) NOT NULL DEFAULT 0,
  `price_satisfy_degree` tinyint(4) NOT NULL DEFAULT 0,
  `kindness_degree` tinyint(4) NOT NULL DEFAULT 0,
  `revisit_will` enum('Y','N') DEFAULT NULL,
  `price` int(11) NOT NULL DEFAULT 0,
  `moving_at` datetime NOT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_customer_feedback_move_company` (`move_company_id`),
  KEY `FK_customer_feedback_customer` (`customer_id`),
  CONSTRAINT `FK_customer_feedback_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_customer_feedback_move_company` FOREIGN KEY (`move_company_id`) REFERENCES `move_company` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- 테이블 데이터 md_homework.customer_feedback:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `customer_feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_feedback` ENABLE KEYS */;

-- 테이블 md_homework.move_company 구조 내보내기
CREATE TABLE IF NOT EXISTS `move_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `ceo` varchar(50) NOT NULL,
  `company_number` varchar(50) NOT NULL,
  `contact` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `address_detail` varchar(50) NOT NULL,
  `company_opened_at` datetime NOT NULL,
  `employee_count` smallint(6) NOT NULL,
  `is_match_available` enum('Y','N') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4;

-- 테이블 데이터 md_homework.move_company:~6 rows (대략적) 내보내기
/*!40000 ALTER TABLE `move_company` DISABLE KEYS */;
INSERT INTO `move_company` (`id`, `name`, `ceo`, `company_number`, `contact`, `address`, `address_detail`, `company_opened_at`, `employee_count`, `is_match_available`) VALUES
	(22, '아가페', 'kim', '11022032', '022234444', '서울시 강남구 강남동', '위워크 14층 101호', '2019-06-04 00:00:00', 120, 'Y'),
	(23, '청목', 'nam', '11022033', '023334444', '서울시 강남구 강남동', '위워크 14층 201호', '2019-06-04 00:00:00', 30, 'Y'),
	(24, '미라클', 'lee', '11022035', '024445555', '서울시 강남구 강남동', '위워크 14층 301호', '2019-06-04 00:00:00', 20, 'Y'),
	(25, '프리렉', 'su', '11022036', '026667777', '서울시 강남구 강남동', '위워크 14층 401호', '2019-06-04 00:00:00', 70, 'Y'),
	(26, '한빛미디어', 'park', '11022037', '027778888', '서울시 강남구 강남동', '위워크 14층 501호', '2019-06-04 00:00:00', 100, 'Y'),
	(27, '일사뮤직', 'jung', '11022038', '028889999', '서울시 강남구 강남동', '위워크 14층 601호', '2019-06-04 00:00:00', 40, 'Y');
/*!40000 ALTER TABLE `move_company` ENABLE KEYS */;

-- 테이블 md_homework.vehicle 구조 내보내기
CREATE TABLE IF NOT EXISTS `vehicle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `move_company_id` int(11) DEFAULT NULL,
  `vehicle_type` enum('ONE_POINT_FIVE','TWO_POINT_FIVE','ETC') NOT NULL,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_vehicle_move_company` (`move_company_id`),
  CONSTRAINT `FK_vehicle_move_company` FOREIGN KEY (`move_company_id`) REFERENCES `move_company` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- 테이블 데이터 md_homework.vehicle:~9 rows (대략적) 내보내기
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` (`id`, `move_company_id`, `vehicle_type`, `count`) VALUES
	(1, 22, 'ONE_POINT_FIVE', 1),
	(2, 22, 'TWO_POINT_FIVE', 1),
	(3, 22, 'ETC', 1),
	(4, 23, 'ONE_POINT_FIVE', 1),
	(5, 23, 'TWO_POINT_FIVE', 2),
	(6, 23, 'ETC', 3),
	(7, 24, 'ONE_POINT_FIVE', 1),
	(8, 24, 'TWO_POINT_FIVE', 2),
	(9, 24, 'ETC', 3);
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
