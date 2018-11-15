/*
Navicat MySQL Data Transfer

Source Server         : mysql80
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : mybatis002

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2018-11-15 10:22:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', 'Finance', 'Shanghai');
INSERT INTO `dept` VALUES ('2', 'Human Resource', 'Nanjing');
INSERT INTO `dept` VALUES ('3', 'General Manager Office', 'Beijing');
INSERT INTO `dept` VALUES ('4', 'Information Technology', 'Hongkong');
INSERT INTO `dept` VALUES ('5', 'Marketing', 'TaiWan');
INSERT INTO `dept` VALUES ('6', 'Sales', 'GuangZhou');

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `mobilePhone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `d_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_person_dept` (`d_id`),
  CONSTRAINT `fk_person_dept` FOREIGN KEY (`d_id`) REFERENCES `dept` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', 'yurij', '12', '11111111111', '1');
INSERT INTO `person` VALUES ('2', 'jst', '22', '22222222', '2');
INSERT INTO `person` VALUES ('3', 'catalinaj', '30', '33333333', '1');
INSERT INTO `person` VALUES ('5', 'jsd', '47', '55555555', '3');
INSERT INTO `person` VALUES ('6', 'httj', '99', '0101010101', '3');
INSERT INTO `person` VALUES ('7', 'JohnCorner', '26', '0xffffff', '1');
INSERT INTO `person` VALUES ('8', 'Jeff', '45', 'nkdfkdsjffdlkgjf', '6');
INSERT INTO `person` VALUES ('9', 'Micheal', '12', '53485374', '3');
INSERT INTO `person` VALUES ('10', 'Cris', '35', '000000000000', '4');
