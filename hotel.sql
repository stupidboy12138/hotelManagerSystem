# Host: localhost  (Version 5.5.40)
# Date: 2018-10-28 19:47:31
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "admin"
#

CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "admin"
#

INSERT INTO `admin` VALUES (1,'admin','F379EAF3C831B04DE153469D1BEC345E');

#
# Structure for table "authority"
#

CREATE TABLE `authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "authority"
#


#
# Structure for table "building"
#

CREATE TABLE `building` (
  `building_id` varchar(11) NOT NULL DEFAULT '',
  `address` varchar(255) DEFAULT NULL,
  `coding` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `optid` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `floor_number` varchar(255) DEFAULT NULL,
  `rest_number` int(11) DEFAULT '10',
  PRIMARY KEY (`building_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "building"
#

INSERT INTO `building` VALUES ('1001','南区一栋','1','爱森公寓','1','1','2018-06-29 21:29:07','10',10),('1002','南区12413254栋',NULL,NULL,NULL,NULL,'2018-07-01 14:34:59',NULL,NULL),('1003','南区三栋','1','爱森公寓','1','1','2018-06-29 21:29:07','30',10),('1004','南区四栋','1','爱森公寓','1','1','2018-06-30 14:20:20','11',10),('1005','下安一栋','1','爱森公寓','1','1','2018-06-30 14:22:03','12',10),('1006','下安二栋','1','爱森公寓','1','1','2018-06-30 14:22:13','13',10),('1008','北区一栋','1','爱森公寓','1','1','2018-06-30 14:25:47','15',10),('1009','北区二栋','1','爱森公寓','1','1','2018-06-30 14:25:53','16',10),('1010','北区三栋','1','爱森公寓','1','1','2018-06-30 14:25:58','21',10),('1012','北区五栋','1','爱森公寓','1','1','2018-06-30 15:34:23','24',10),('1013','北区七栋',NULL,NULL,NULL,NULL,'2018-07-01 13:43:54',NULL,NULL);

#
# Structure for table "checkin"
#

CREATE TABLE `checkin` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "checkin"
#


#
# Structure for table "files"
#

CREATE TABLE `files` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(100) DEFAULT NULL,
  `date` varchar(20) NOT NULL,
  `family` varchar(100) NOT NULL,
  `filename` varchar(100) NOT NULL,
  `is_show` bit(1) DEFAULT NULL,
  `username` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "files"
#


#
# Structure for table "room"
#

CREATE TABLE `room` (
  `description` varchar(255) DEFAULT NULL,
  `building_id` varchar(255) DEFAULT NULL,
  `is_in` varchar(11) DEFAULT '0',
  `room_id` varchar(255) DEFAULT NULL,
  `check_in_time` varchar(255) DEFAULT NULL,
  `check_out_time` varchar(255) DEFAULT NULL,
  `idcard` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "room"
#

INSERT INTO `room` VALUES ('1楼1号房','1001','1','101',NULL,NULL,NULL),(NULL,NULL,NULL,'102',NULL,NULL,NULL),('1楼3号房','1001','0','103',NULL,NULL,NULL),('1楼4号房','1001','0','104',NULL,NULL,NULL),('1楼5号房','1001','0','105',NULL,NULL,NULL),('1楼6号房','1001','0','106',NULL,NULL,NULL),('1楼7号房','1001','0','107',NULL,NULL,NULL),('1楼8号房','1001','0','108',NULL,NULL,NULL),('1楼9号房','1001','0','109',NULL,NULL,NULL),('1楼10号房','1001','0','110',NULL,NULL,NULL),('2楼1号房','1002','0','201',NULL,NULL,NULL),('3楼1号房','1003','0','301',NULL,NULL,NULL),('1楼11号房','1001','0','111',NULL,NULL,NULL),('1楼12号房','1001','1','112',NULL,NULL,NULL),('1楼13号房','1001','0','113',NULL,NULL,NULL),('1楼14号房','1001','0','114',NULL,NULL,NULL);

#
# Structure for table "user"
#

CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `roomid` varchar(255) DEFAULT NULL,
  `idcard` varchar(255) DEFAULT NULL,
  `check_in_time` datetime DEFAULT NULL,
  `check_out_time` datetime DEFAULT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (2,'18900298765','EA0E919EC831AE92BED6B55D0E0AA4BE','18900298765','101','350120199876543213','2018-06-10 00:00:00','2018-07-05 00:00:00',''),(10,'13159402799','E86C4206238CEAB73497F6B51DEAFB09\r\n','13159402799','106','513030199903035311','2018-06-14 00:00:00','2018-06-22 00:00:00',''),(14,'123412434','B68F3E5F36ED4ECA7A3ACB46A4877735','123412434','101','382736463736278987','2018-07-08 00:00:00','2018-07-28 00:00:00',''),(15,'189002975231','2F9ECFA0F357772A6113CEFFEF84DDF4','189002975231','112','350121199806254738','2018-07-06 00:00:00','2018-07-07 00:00:00','');

#
# Structure for table "user_authority"
#

CREATE TABLE `user_authority` (
  `user_id` bigint(20) NOT NULL,
  `authority_id` bigint(20) NOT NULL,
  KEY `FKgvxjs381k6f48d5d2yi11uh89` (`authority_id`),
  KEY `FKpqlsjpkybgos9w2svcri7j8xy` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "user_authority"
#

