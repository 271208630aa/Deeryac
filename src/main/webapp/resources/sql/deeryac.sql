/*
SQLyog Ultimate v8.82 
MySQL - 5.5.5-10.1.7-MariaDB : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `t_sys_code` */

DROP TABLE IF EXISTS `t_sys_code`;

CREATE TABLE `t_sys_code` (
  `id` varchar(50) NOT NULL,
  `upid` varchar(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `sortcode` varchar(50) DEFAULT NULL,
  `sortname` varchar(100) DEFAULT NULL,
  `flag` varchar(300) DEFAULT NULL,
  `enable` varchar(10) DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_code` */

/*Table structure for table `t_sys_depart` */

DROP TABLE IF EXISTS `t_sys_depart`;

CREATE TABLE `t_sys_depart` (
  `id` varchar(50) NOT NULL,
  `upid` varchar(50) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `namepy` varchar(100) DEFAULT NULL,
  `namepyall` varchar(500) DEFAULT NULL,
  `type` int(10) DEFAULT NULL,
  `layer` varchar(10) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_depart` */

/*Table structure for table `t_sys_menu` */

DROP TABLE IF EXISTS `t_sys_menu`;

CREATE TABLE `t_sys_menu` (
  `id` varchar(50) NOT NULL,
  `upid` varchar(50) DEFAULT NULL,
  `name` varchar(300) DEFAULT NULL,
  `url` varchar(900) DEFAULT NULL,
  `flag` varchar(600) DEFAULT NULL,
  `enable` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_menu` */

/*Table structure for table `t_sys_property` */

DROP TABLE IF EXISTS `t_sys_property`;

CREATE TABLE `t_sys_property` (
  `wid` varchar(50) NOT NULL,
  `name` varchar(300) DEFAULT NULL COMMENT '参数名称',
  `key` varchar(50) DEFAULT NULL COMMENT '参数KEY',
  `value` varchar(300) DEFAULT NULL COMMENT '参数值',
  `flag` varchar(300) DEFAULT NULL COMMENT '备注',
  `type` varchar(10) DEFAULT NULL COMMENT '参数类型',
  `enable` varchar(10) DEFAULT NULL COMMENT '是否启用',
  PRIMARY KEY (`wid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_property` */

/*Table structure for table `t_sys_role` */

DROP TABLE IF EXISTS `t_sys_role`;

CREATE TABLE `t_sys_role` (
  `id` varchar(50) NOT NULL,
  `name` varchar(300) DEFAULT NULL,
  `enable` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_role` */

/*Table structure for table `t_sys_role_menu` */

DROP TABLE IF EXISTS `t_sys_role_menu`;

CREATE TABLE `t_sys_role_menu` (
  `id` varchar(50) NOT NULL,
  `userid` varchar(50) DEFAULT NULL,
  `menuid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_role_menu` */

/*Table structure for table `t_sys_sort` */

DROP TABLE IF EXISTS `t_sys_sort`;

CREATE TABLE `t_sys_sort` (
  `id` varchar(50) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `flag` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_sort` */

/*Table structure for table `t_sys_user` */

DROP TABLE IF EXISTS `t_sys_user`;

CREATE TABLE `t_sys_user` (
  `id` varchar(50) NOT NULL,
  `departid` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `name` varchar(300) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `usertype` int(11) DEFAULT NULL,
  `loginid` varchar(300) DEFAULT NULL COMMENT '登陆人账号',
  `menutype` int(10) DEFAULT NULL COMMENT '菜单方式',
  `enable` int(10) DEFAULT NULL COMMENT '是否启用',
  `startdate` date DEFAULT NULL COMMENT '启用时间',
  `enddate` date DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_user` */

/*Table structure for table `t_sys_user_menu` */

DROP TABLE IF EXISTS `t_sys_user_menu`;

CREATE TABLE `t_sys_user_menu` (
  `id` varchar(50) NOT NULL,
  `userid` varchar(50) DEFAULT NULL,
  `menuid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_user_menu` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
