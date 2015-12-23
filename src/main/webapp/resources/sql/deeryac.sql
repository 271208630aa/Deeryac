/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 10.1.7-MariaDB : Database - test
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE  IF NOT EXISTS`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `t_sys_code` */

DROP TABLE IF EXISTS `t_sys_code`;

CREATE TABLE `t_sys_code` (
  `id` varchar(50) NOT NULL,
  `code` varchar(150) DEFAULT NULL,
  `enable` varchar(10) DEFAULT NULL,
  `flag` varchar(300) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  `sortcode` varchar(150) DEFAULT NULL,
  `sortname` varchar(150) DEFAULT NULL,
  `upid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_code` */

/*Table structure for table `t_sys_depart` */

DROP TABLE IF EXISTS `t_sys_depart`;

CREATE TABLE `t_sys_depart` (
  `id` varchar(50) NOT NULL,
  `layer` varchar(10) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `namepy` varchar(50) DEFAULT NULL,
  `namepyall` varchar(750) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `upid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_depart` */

/*Table structure for table `t_sys_menu` */

DROP TABLE IF EXISTS `t_sys_menu`;

CREATE TABLE `t_sys_menu` (
  `id` varchar(50) NOT NULL,
  `enable` varchar(10) DEFAULT NULL,
  `flag` varchar(300) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `upid` varchar(50) DEFAULT NULL,
  `url` varchar(500) DEFAULT NULL,
  `layer` int(11) DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_menu` */

/*Table structure for table `t_sys_property` */

DROP TABLE IF EXISTS `t_sys_property`;

CREATE TABLE `t_sys_property` (
  `id` varchar(50) NOT NULL,
  `name` varchar(300) DEFAULT NULL COMMENT '名称',
  `key` varchar(50) DEFAULT NULL COMMENT '关键字',
  `flag` varchar(300) DEFAULT NULL COMMENT '备注',
  `value` varchar(300) DEFAULT NULL COMMENT '值',
  `type` varchar(10) DEFAULT NULL COMMENT '类别',
  `enable` varchar(10) DEFAULT NULL COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统参数';

/*Data for the table `t_sys_property` */

/*Table structure for table `t_sys_role` */

DROP TABLE IF EXISTS `t_sys_role`;

CREATE TABLE `t_sys_role` (
  `id` varchar(50) NOT NULL,
  `enable` varchar(10) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_role` */

/*Table structure for table `t_sys_role_menu` */

DROP TABLE IF EXISTS `t_sys_role_menu`;

CREATE TABLE `t_sys_role_menu` (
  `id` varchar(50) NOT NULL,
  `menuid` varchar(50) DEFAULT NULL,
  `roleid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_role_menu` */

/*Table structure for table `t_sys_sort` */

DROP TABLE IF EXISTS `t_sys_sort`;

CREATE TABLE `t_sys_sort` (
  `id` varchar(50) NOT NULL,
  `code` varchar(50) DEFAULT NULL,
  `flag` varchar(300) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_sort` */

insert  into `t_sys_sort`(`id`,`code`,`flag`,`name`) values ('1','sysname','wiouwehriweuh','校园足球联盟');

/*Table structure for table `t_sys_user` */

DROP TABLE IF EXISTS `t_sys_user`;

CREATE TABLE `t_sys_user` (
  `id` varchar(50) NOT NULL,
  `departid` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `enable` int(11) DEFAULT NULL,
  `enddate` datetime DEFAULT NULL,
  `loginid` varchar(50) DEFAULT NULL,
  `menutype` int(11) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `startdate` datetime DEFAULT NULL,
  `usertype` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_user` */

insert  into `t_sys_user`(`id`,`departid`,`email`,`enable`,`enddate`,`loginid`,`menutype`,`name`,`password`,`startdate`,`usertype`) values ('1','1','12121@23.com',1,NULL,'admin',1,'王军军','202cb962ac59075b964b07152d234b70',NULL,1);

/*Table structure for table `t_sys_user_menu` */

DROP TABLE IF EXISTS `t_sys_user_menu`;

CREATE TABLE `t_sys_user_menu` (
  `id` varchar(50) NOT NULL,
  `menuid` varchar(50) DEFAULT NULL,
  `userid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_user_menu` */

/*Table structure for table `t_sys_user_role` */

DROP TABLE IF EXISTS `t_sys_user_role`;

CREATE TABLE `t_sys_user_role` (
  `id` varchar(50) NOT NULL,
  `userid` varchar(50) DEFAULT NULL COMMENT '账号主键',
  `roleid` varchar(50) DEFAULT NULL COMMENT '角色主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

/*Data for the table `t_sys_user_role` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
