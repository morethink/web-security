/*
Navicat MySQL Data Transfer

Source Server         : 本地主机
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : post

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2018-01-04 16:07:37
*/

USE post;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `id` int(11) NOT NULL,
  `content` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('1', '1');
INSERT INTO `post` VALUES ('2', '2');
INSERT INTO `post` VALUES ('3', '3');
INSERT INTO `post` VALUES ('4', '4');
INSERT INTO `post` VALUES ('5', '5');
INSERT INTO `post` VALUES ('6', '6');
SET FOREIGN_KEY_CHECKS=1;
