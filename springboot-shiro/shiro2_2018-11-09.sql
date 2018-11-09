# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.6.39)
# Database: shiro2
# Generation Time: 2018-11-09 07:06:38 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table T_PERMISSION
# ------------------------------------------------------------

DROP TABLE IF EXISTS `T_PERMISSION`;

CREATE TABLE `T_PERMISSION` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `url` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `T_PERMISSION` WRITE;
/*!40000 ALTER TABLE `T_PERMISSION` DISABLE KEYS */;

INSERT INTO `T_PERMISSION` (`id`, `url`, `name`)
VALUES
	(1,'/user','user:list'),
	(2,'/user/add','user:add'),
	(3,'/user/delete','user:delete');

/*!40000 ALTER TABLE `T_PERMISSION` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table T_ROLE
# ------------------------------------------------------------

DROP TABLE IF EXISTS `T_ROLE`;

CREATE TABLE `T_ROLE` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `memo` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `T_ROLE` WRITE;
/*!40000 ALTER TABLE `T_ROLE` DISABLE KEYS */;

INSERT INTO `T_ROLE` (`id`, `name`, `memo`)
VALUES
	(1,'admin','超级管理员'),
	(2,'test','测试账号');

/*!40000 ALTER TABLE `T_ROLE` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table T_ROLE_PERMISSION
# ------------------------------------------------------------

DROP TABLE IF EXISTS `T_ROLE_PERMISSION`;

CREATE TABLE `T_ROLE_PERMISSION` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `rid` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `T_ROLE_PERMISSION` WRITE;
/*!40000 ALTER TABLE `T_ROLE_PERMISSION` DISABLE KEYS */;

INSERT INTO `T_ROLE_PERMISSION` (`id`, `rid`, `pid`)
VALUES
	(1,1,2),
	(2,1,3),
	(3,1,1),
	(4,2,1);

/*!40000 ALTER TABLE `T_ROLE_PERMISSION` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table T_USER
# ------------------------------------------------------------

DROP TABLE IF EXISTS `T_USER`;

CREATE TABLE `T_USER` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(128) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `T_USER` WRITE;
/*!40000 ALTER TABLE `T_USER` DISABLE KEYS */;

INSERT INTO `T_USER` (`id`, `username`, `password`, `status`)
VALUES
	(1,'xiaozhao','4e9bc85a1bfdb5abe4f2f1b641e9f102','1'),
	(2,'tester','e3af7f08eddd6614652214d5ae6e020b','1');

/*!40000 ALTER TABLE `T_USER` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table T_USER_ROLE
# ------------------------------------------------------------

DROP TABLE IF EXISTS `T_USER_ROLE`;

CREATE TABLE `T_USER_ROLE` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `T_USER_ROLE` WRITE;
/*!40000 ALTER TABLE `T_USER_ROLE` DISABLE KEYS */;

INSERT INTO `T_USER_ROLE` (`id`, `user_id`, `rid`)
VALUES
	(1,1,1),
	(2,2,2);

/*!40000 ALTER TABLE `T_USER_ROLE` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
