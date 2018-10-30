# Dump of table role

# ------------------------------------------------------------

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (

`id` int(11) unsigned NOT NULL AUTO_INCREMENT,

`name` varchar(50) NOT NULL DEFAULT '' COMMENT '角色名称',

PRIMARY KEY (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `role` WRITE;

/*!40000 ALTER TABLE `role` DISABLE KEYS */;

INSERT INTO `role` (`id`, `name`)

VALUES

  (1,'超级管理员'),

  (2,'一般用户');

/*!40000 ALTER TABLE `role` ENABLE KEYS */;

UNLOCK TABLES;