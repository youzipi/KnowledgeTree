/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50535
Source Host           : 127.0.0.1:3306
Source Database       : infotree

Target Server Type    : MYSQL
Target Server Version : 50535
File Encoding         : 65001

Date: 2014-11-12 14:45:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for knowledge_desc
-- ----------------------------
DROP TABLE IF EXISTS `knowledge_desc`;
CREATE TABLE `knowledge_desc` (
  `id` varchar(100) NOT NULL,
  `name` varchar(50) NOT NULL,
  `content` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of knowledge_desc
-- ----------------------------
INSERT INTO `knowledge_desc` VALUES ('1', 'java', 'null');
INSERT INTO `knowledge_desc` VALUES ('11', 'java ee', 'null');
INSERT INTO `knowledge_desc` VALUES ('111', 'wang', '汪');
INSERT INTO `knowledge_desc` VALUES ('112', 'yi', '宜');
INSERT INTO `knowledge_desc` VALUES ('12', 'java se', 'null');
INSERT INTO `knowledge_desc` VALUES ('2', 'css', 'null');

-- ----------------------------
-- Table structure for knowledge_relation
-- ----------------------------
DROP TABLE IF EXISTS `knowledge_relation`;
CREATE TABLE `knowledge_relation` (
  `father_id` varchar(50) DEFAULT NULL,
  `id_sub` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of knowledge_relation
-- ----------------------------
INSERT INTO `knowledge_relation` VALUES ('null', '1');
INSERT INTO `knowledge_relation` VALUES ('null', '2');
INSERT INTO `knowledge_relation` VALUES ('1', '11');
INSERT INTO `knowledge_relation` VALUES ('1', '12');
INSERT INTO `knowledge_relation` VALUES ('11', '111');
INSERT INTO `knowledge_relation` VALUES ('11', '112');
