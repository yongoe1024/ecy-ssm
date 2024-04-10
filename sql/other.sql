/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.32 : Database - ecy-lj
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ecy-lj` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `ecy-lj`;

/*Table structure for table `t_article` */

DROP TABLE IF EXISTS `t_article`;

CREATE TABLE `t_article` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标题',
                             `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '内容',
                             `status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '状态',
                             `score` int DEFAULT NULL COMMENT '积分',
                             `create_time` datetime NOT NULL COMMENT '创建时间',
                             `update_time` datetime NOT NULL COMMENT '修改时间',
                             `create_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
                             `update_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '修改人',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `t_article` */

insert  into `t_article`(`id`,`title`,`content`,`status`,`score`,`create_time`,`update_time`,`create_by`,`update_by`) values
                                                                                                                          (1,'环保从点滴做起，美丽家园靠大家。珍爱自然，共筑绿色家园。','环保从点滴做起，美丽家园靠大家。珍爱自然，共筑绿色家园。','通过',1,'2024-02-23 18:58:42','2024-02-23 18:58:48','啊啊啊','啊啊啊'),
                                                                                                                          (2,'让绿色走进家园，使生命远离污染。千方百计治理污染，协力保护环境。','让绿色走进家园，使生命远离污染。千方百计治理污染，协力保护环境。','通过',11,'2024-02-25 16:36:10','2024-02-25 16:39:31','yongoe','yongoe'),
                                                                                                                          (3,'绿色环保，人人参与，共建美丽中国，共享美好环境。','绿色环保，人人参与，共建美丽中国，共享美好环境。','通过',1,'2024-02-25 22:26:45','2024-02-25 22:26:47','admin','admin'),
                                                                                                                          (4,'环保无小事，你我共同守护，绿色生活，从点滴做起。','环保无小事，你我共同守护，绿色生活，从点滴做起。','通过',1,'2024-02-25 22:27:18','2024-02-25 22:27:19','admin','admin'),
                                                                                                                          (5,'绿色环保，人人有责。行动起来，用我们的双手共建美丽世界。','绿色环保，人人有责。行动起来，用我们的双手共建美丽世界。','通过',1,'2024-02-25 22:27:39','2024-02-25 22:27:41','admin','admin'),
                                                                                                                          (6,'绿色环保，人人有责。行动起来，用我们的双手共建美丽世界。','绿色环保，人人有责。行动起来，用我们的双手共建美丽世界。','通过',1,'2024-02-26 22:31:18','2024-02-26 22:31:24','admin','admin'),
                                                                                                                          (7,'绿色环保，人人参与，共建美丽中国，共享美好环境。','绿色环保，人人参与，共建美丽中国，共享美好环境。','通过',1,'2024-02-26 22:31:48','2024-02-26 22:31:50','admin','admin'),
                                                                                                                          (8,'绿色环保，人人参与，共建美丽中国，共享美好环境。','绿色环保，人人参与，共建美丽中国，共享美好环境。','通过',1,'2024-02-26 22:32:17','2024-02-26 22:32:19','admin','admin'),
                                                                                                                          (9,'让绿色走进家园，使生命远离污染。千方百计治理污染，协力保护环境。','让绿色走进家园，使生命远离污染。千方百计治理污染，协力保护环境。','通过',1,'2024-02-26 22:32:41','2024-02-26 22:32:42','ads','asd'),
                                                                                                                          (10,'绿色环保，人人参与，共建美丽中国，共享美好环境。','绿色环保，人人参与，共建美丽中国，共享美好环境。','通过',1,'2024-02-26 22:33:05','2024-02-26 22:33:07','asdfa','asdf'),
                                                                                                                          (11,'绿色环保，人人参与，共建美丽中国，共享美好环境。','绿色环保，人人参与，共建美丽中国，共享美好环境。','通过',1,'2024-02-26 22:33:24','2024-02-26 22:33:25','faSF','SDA'),
                                                                                                                          (12,'asdfasdf','asdfasdfasdf','通过',10,'2024-02-26 22:55:03','2024-02-26 22:55:20','yongoe','yongoe'),
                                                                                                                          (13,'曹操','曹操（155年 [1]－220年3月15日 [2]），字孟德，一名吉利，小字阿瞒 [73]，一说本姓夏侯 [141]，沛国谯县（今安徽省亳州市）人 [3]。中国古代杰出的政治家、军事家、文学家、书法家 [261]，东汉末年权臣，亦是曹魏政权的奠基者。太尉曹嵩之子 [3]。\n曹操少年间任侠放荡，到二十岁时举孝廉为郎，授洛阳北部尉。后任骑都尉，参与镇压黄巾军，调济南相。董卓擅政时，散尽家财，起兵讨董卓。初平三年（192年），据兖州，分化诱降黄巾军三十余万，选取其中精锐组建青州军。建安元年（196年），迎汉献帝至许县，从此用献帝名义发号施令，总揽朝政。在此前后相继击败袁术、陶谦、吕布等势力。建安五年（200年），在官渡之战中大败割据河北的袁绍，随后削平袁尚、袁谭，北击乌桓，统一北方。建安十三年（208年）进位丞相。同年率军南征，收服荆州，但在赤壁之战中败于孙刘联军。建安二十年（215年），取汉中，次年（216年）自魏公进爵魏王。建安二十五年（220年），曹操病死于洛阳，享年六十六岁 [139]。曹魏建立后，被追尊为太祖，谥号武皇帝 [112]，葬于高陵。 [73]\n曹操用人唯才，抑制豪强，加强集权；在北方屯田，兴修水利。他的诸种举措使统治地区的社会经济得到一定的恢复和发展。对于曹操的功业及其为人，后世评论之多，分歧之大，可谓世所罕见 [262]。此外，他知兵法，工书法，擅诗歌。其诗多抒发政治抱负，反映汉末人民的苦难生活，气魄雄伟，慷慨悲凉，开建安文学之风。著有《魏武帝集》，已佚失。今人辑有《曹操集》。 [112] [261]','通过',10,'2024-02-26 23:18:22','2024-02-26 23:18:31','yongoe','yongoe'),
                                                                                                                          (14,'155','2654555','未审核',NULL,'2024-02-29 15:51:00','2024-02-29 15:51:00','张张','张张');

/*Table structure for table `t_gonggao` */

DROP TABLE IF EXISTS `t_gonggao`;

CREATE TABLE `t_gonggao` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标题',
                             `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci COMMENT '内容',
                             `create_time` datetime NOT NULL COMMENT '创建时间',
                             `update_time` datetime NOT NULL COMMENT '修改时间',
                             `create_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
                             `update_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '修改人',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `t_gonggao` */

insert  into `t_gonggao`(`id`,`title`,`content`,`create_time`,`update_time`,`create_by`,`update_by`) values
                                                                                                         (1,'啊啊啊','啊啊啊','2024-02-24 03:07:38','2024-02-24 03:07:38','yongoe','yongoe'),
                                                                                                         (2,'信息','信息','2024-02-24 03:07:42','2024-02-24 03:07:42','yongoe','yongoe'),
                                                                                                         (4,'爱护地球，人人有责，行动起来，环保从我做起。','爱护地球，人人有责，行动起来，环保从我做起。','2024-02-25 22:28:20','2024-02-25 22:28:20','yongoe','yongoe'),
                                                                                                         (5,'保护环境，人人有责，绿色行动，共创美好未来。','保护环境，人人有责，绿色行动，共创美好未来。','2024-02-25 22:28:27','2024-02-25 22:28:27','yongoe','yongoe'),
                                                                                                         (6,'环保从你我做起，美丽地球靠大家。','环保从你我做起，美丽地球靠大家。','2024-02-25 22:28:31','2024-02-25 22:28:31','yongoe','yongoe'),
                                                                                                         (7,'共建生态家园，守护绿水青山。环保行动，从每个细节做起。','共建生态家园，守护绿水青山。环保行动，从每个细节做起。','2024-02-25 22:28:35','2024-02-25 22:28:35','yongoe','yongoe'),
                                                                                                         (8,'保护地球，人人有责，从我做起，共筑绿意家园。','保护地球，人人有责，从我做起，共筑绿意家园。','2024-02-25 22:28:41','2024-02-25 22:28:41','yongoe','yongoe');

/*Table structure for table `t_goods` */

DROP TABLE IF EXISTS `t_goods`;

CREATE TABLE `t_goods` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
                           `img` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片',
                           `detials` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '详情',
                           `price` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '价格',
                           `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '交易地点',
                           `phone` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系方式',
                           `buyer` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '买家姓名',
                           `buyer_phone` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '买家联系方式',
                           `buy_time` datetime DEFAULT NULL COMMENT '购买时间',
                           `status` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '状态',
                           `create_time` datetime NOT NULL COMMENT '创建时间',
                           `update_time` datetime NOT NULL COMMENT '修改时间',
                           `create_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
                           `update_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '修改人',
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `t_goods` */

insert  into `t_goods`(`id`,`name`,`img`,`detials`,`price`,`address`,`phone`,`buyer`,`buyer_phone`,`buy_time`,`status`,`create_time`,`update_time`,`create_by`,`update_by`) values
                                                                                                                                                                                (1,'商品1','/file/2024/2/28/528b74e0ab0f4411a00dc265f689aed3.JPG','b','10','sss','198288','张张','18695592421','2024-02-29 15:55:02','未售出','2024-02-25 09:51:45','2024-02-29 15:55:02','yongoe','张张'),
                                                                                                                                                                                (2,'商品2','/file/2024/2/28/528b74e0ab0f4411a00dc265f689aed3.JPG','a','10','dfghdfhfg','42452','张张','18695592421','2024-02-29 15:52:08','已售出','2024-02-25 23:26:13','2024-02-29 15:52:33','yongoe','张张');

/*Table structure for table `t_jilu` */

DROP TABLE IF EXISTS `t_jilu`;

CREATE TABLE `t_jilu` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `user_id` bigint DEFAULT NULL COMMENT '用户id',
                          `detail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '原因',
                          `update_num` int DEFAULT NULL COMMENT '变化数量',
                          `sum` int DEFAULT NULL COMMENT '当前总数',
                          `create_time` datetime NOT NULL COMMENT '创建时间',
                          `update_time` datetime NOT NULL COMMENT '修改时间',
                          `create_by` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
                          `update_by` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '修改人',
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Data for the table `t_jilu` */

insert  into `t_jilu`(`id`,`user_id`,`detail`,`update_num`,`sum`,`create_time`,`update_time`,`create_by`,`update_by`) values
                                                                                                                          (1,2,'垃圾投放',1,3,'2024-03-24 17:14:10','2024-03-24 17:14:10','yongoe','yongoe'),
                                                                                                                          (2,1,'垃圾投放',1,38,'2024-03-24 17:18:15','2024-03-24 17:18:15','yongoe','yongoe'),
                                                                                                                          (3,1,'垃圾投放',1,39,'2024-03-24 17:18:46','2024-03-24 17:18:46','yongoe','yongoe'),
                                                                                                                          (4,1,'兑换商品2',-1,37,'2024-03-24 17:28:14','2024-03-24 17:28:14','yongoe','yongoe');

/*Table structure for table `t_message` */

DROP TABLE IF EXISTS `t_message`;

CREATE TABLE `t_message` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `parent_id` bigint DEFAULT NULL COMMENT 'pid',
                             `content` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '留言内容',
                             `status` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '1' COMMENT '状态',
                             `create_time` datetime NOT NULL COMMENT '创建时间',
                             `update_time` datetime NOT NULL COMMENT '修改时间',
                             `create_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
                             `update_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '修改人',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `t_message` */

insert  into `t_message`(`id`,`parent_id`,`content`,`status`,`create_time`,`update_time`,`create_by`,`update_by`) values
                                                                                                                      (5,0,'爱绿护绿，共创美好家园。环保从我做起，人人有责，点滴改变，共建绿色地球。','1','2024-02-25 22:50:08','2024-02-25 22:50:08','yongoe','yongoe'),
                                                                                                                      (6,0,'保护环境，从我做起，珍爱每一滴水，每一片绿。','1','2024-02-25 22:51:07','2024-02-25 22:51:07','yongoe','yongoe'),
                                                                                                                      (7,6,'环保从细节做起，美好环境靠大家。','1','2024-02-25 23:06:14','2024-02-25 23:06:14','yongoe','yongoe'),
                                                                                                                      (8,0,'hhh','1','2024-02-27 14:57:21','2024-02-27 14:57:21','yongoe','yongoe'),
                                                                                                                      (9,0,'yyy','1','2024-02-27 14:58:42','2024-02-27 14:58:42','yongoe','yongoe'),
                                                                                                                      (10,8,'ss','1','2024-02-28 11:49:20','2024-02-28 11:49:20','yongoe','yongoe');

/*Table structure for table `t_prize` */

DROP TABLE IF EXISTS `t_prize`;

CREATE TABLE `t_prize` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
                           `img` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片',
                           `detials` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '详情',
                           `score` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '积分',
                           `num` int DEFAULT NULL COMMENT '数量',
                           `create_time` datetime NOT NULL COMMENT '创建时间',
                           `update_time` datetime NOT NULL COMMENT '修改时间',
                           `create_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
                           `update_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '修改人',
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `t_prize` */

insert  into `t_prize`(`id`,`name`,`img`,`detials`,`score`,`num`,`create_time`,`update_time`,`create_by`,`update_by`) values
                                                                                                                          (1,'商品1','/file/2024/2/28/528b74e0ab0f4411a00dc265f689aed3.JPG','环保从点滴做起，美丽家园靠大家。珍爱自然，共筑绿色家园。','2',-4,'2024-02-24 03:12:03','2024-02-25 16:12:56','yongoe','yongoe'),
                                                                                                                          (2,'商品2','/file/2024/2/28/528b74e0ab0f4411a00dc265f689aed3.JPG','保护环境，人人有责，共建绿色地球家园。','1',2,'2024-02-24 03:12:11','2024-03-24 17:28:14','yongoe','yongoe');

/*Table structure for table `t_prize_record` */

DROP TABLE IF EXISTS `t_prize_record`;

CREATE TABLE `t_prize_record` (
                                  `id` bigint NOT NULL AUTO_INCREMENT,
                                  `prize_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '奖品名',
                                  `create_time` datetime NOT NULL COMMENT '创建时间',
                                  `update_time` datetime NOT NULL COMMENT '修改时间',
                                  `create_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
                                  `update_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '修改人',
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `t_prize_record` */

insert  into `t_prize_record`(`id`,`prize_name`,`create_time`,`update_time`,`create_by`,`update_by`) values
                                                                                                         (1,'aa','2024-02-25 15:53:57','2024-02-25 15:53:57','yongoe','yongoe'),
                                                                                                         (2,'aa','2024-02-25 15:55:21','2024-02-25 15:55:21','yongoe','yongoe'),
                                                                                                         (3,'aa','2024-02-25 16:12:54','2024-02-25 16:12:54','yongoe','yongoe'),
                                                                                                         (4,'aa','2024-02-25 16:12:56','2024-02-25 16:12:56','yongoe','yongoe'),
                                                                                                         (5,'aa','2024-02-25 16:12:56','2024-02-25 16:12:56','yongoe','yongoe'),
                                                                                                         (6,'aa','2024-02-25 16:12:56','2024-02-25 16:12:56','yongoe','yongoe'),
                                                                                                         (7,'ccc','2024-02-25 16:42:16','2024-02-25 16:42:16','yongoe','yongoe'),
                                                                                                         (8,'商品2','2024-03-24 17:28:14','2024-03-24 17:28:14','yongoe','yongoe');

/*Table structure for table `t_rubbish` */

DROP TABLE IF EXISTS `t_rubbish`;

CREATE TABLE `t_rubbish` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `status` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '状态',
                             `img` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片',
                             `detials` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '详情',
                             `trash_can` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '垃圾桶',
                             `trash_can_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '垃圾桶类型',
                             `trash_can_address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '垃圾桶地点',
                             `put_time` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '投放时间',
                             `create_time` datetime NOT NULL COMMENT '创建时间',
                             `update_time` datetime NOT NULL COMMENT '修改时间',
                             `create_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
                             `update_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '修改人',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `t_rubbish` */

insert  into `t_rubbish`(`id`,`status`,`img`,`detials`,`trash_can`,`trash_can_type`,`trash_can_address`,`put_time`,`create_time`,`update_time`,`create_by`,`update_by`) values
                                                                                                                                                                            (15,'拒绝','/file/2024/2/28/528b74e0ab0f4411a00dc265f689aed3.JPG','asdfas','垃圾桶1','厨余垃圾','深圳市','2024-02-26 21:58:17','2024-02-26 21:58:19','2024-02-27 00:21:47','yongoe','yongoe'),
                                                                                                                                                                            (16,'通过','/file/2024/2/28/528b74e0ab0f4411a00dc265f689aed3.JPG','aaaaaaaa111111111111111','垃圾桶3','有害垃圾','上海市','2024-03-08 00:00:00','2024-02-26 21:58:28','2024-03-24 17:18:46','yongoe','yongoe'),
                                                                                                                                                                            (19,'通过','/file/2024/2/28/528b74e0ab0f4411a00dc265f689aed3.JPG','收拾收拾收拾收拾收拾收拾','垃圾桶1','厨余垃圾','深圳市',NULL,'2024-02-28 15:28:56','2024-03-24 17:18:15','yongoe','yongoe'),
                                                                                                                                                                            (20,'通过','/file/2024/2/29/9774fb5d51944516a6c75fbc6fe5805d.jpg','aaa','垃圾桶1','厨余垃圾','深圳市','2024-02-05 00:00:00','2024-02-29 15:50:46','2024-03-24 17:14:10','张张','yongoe');

/*Table structure for table `t_trash_can` */

DROP TABLE IF EXISTS `t_trash_can`;

CREATE TABLE `t_trash_can` (
                               `id` bigint NOT NULL AUTO_INCREMENT,
                               `name` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
                               `type` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '类型',
                               `capacity` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '容量',
                               `img` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片',
                               `enabled` tinyint DEFAULT NULL COMMENT '可用',
                               `address` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '位置',
                               `create_time` datetime NOT NULL COMMENT '创建时间',
                               `update_time` datetime NOT NULL COMMENT '修改时间',
                               `create_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '创建人',
                               `update_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '修改人',
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `t_trash_can` */

insert  into `t_trash_can`(`id`,`name`,`type`,`capacity`,`img`,`enabled`,`address`,`create_time`,`update_time`,`create_by`,`update_by`) values
                                                                                                                                            (1,'垃圾桶1','厨余垃圾','10L','/file/2024/2/28/528b74e0ab0f4411a00dc265f689aed3.JPG',0,'深圳市','2024-02-26 00:25:44','2024-02-26 00:25:46','admin','admin'),
                                                                                                                                            (2,'垃圾桶2','可回收垃圾','10L','/file/2024/2/28/528b74e0ab0f4411a00dc265f689aed3.JPG',1,'北京市','2024-02-26 00:29:37','2024-02-26 00:29:39','admin','admin'),
                                                                                                                                            (3,'垃圾桶3','有害垃圾','10L','/file/2024/2/28/528b74e0ab0f4411a00dc265f689aed3.JPG',0,'上海市','2024-02-26 00:30:10','2024-02-26 00:30:12','admin','admin'),
                                                                                                                                            (4,'垃圾桶4','其他垃圾','10L','/file/2024/2/28/528b74e0ab0f4411a00dc265f689aed3.JPG',0,'重庆市','2024-02-26 00:30:44','2024-02-26 00:30:46','admin','admin');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
