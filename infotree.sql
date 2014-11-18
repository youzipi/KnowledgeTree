/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50535
Source Host           : 127.0.0.1:3306
Source Database       : infotree

Target Server Type    : MYSQL
Target Server Version : 50535
File Encoding         : 65001

Date: 2014-11-18 22:04:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for knowledge_desc
-- ----------------------------
DROP TABLE IF EXISTS `knowledge_desc`;
CREATE TABLE `knowledge_desc` (
  `id` varchar(100) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of knowledge_desc
-- ----------------------------
INSERT INTO `knowledge_desc` VALUES ('087cdc5db6394fbbadecbbde4253b8e8', 'null', null);
INSERT INTO `knowledge_desc` VALUES ('1', 'java', 'Java is a computer programming language that is concurrent, class-based, object-oriented, and specifically designed to have as few implementation dependencies as possible.');
INSERT INTO `knowledge_desc` VALUES ('11', 'java ee', 'Java Platform Enterprise Edition');
INSERT INTO `knowledge_desc` VALUES ('111', 'servlet', 'servlett');
INSERT INTO `knowledge_desc` VALUES ('112', 'jsp', 'jsppp');
INSERT INTO `knowledge_desc` VALUES ('12', 'java se', 'Java Platform Standard Edition123');
INSERT INTO `knowledge_desc` VALUES ('2', 'css', 'Cascading Style Sheets3456778256gsdgsgsdsgsgdgsgg');
INSERT INTO `knowledge_desc` VALUES ('50ff5e65738f4f608f9d929dac96bb4f', 'unname1', null);
INSERT INTO `knowledge_desc` VALUES ('8a23a7c860ef45878ac5fd8414808ee9', 'noooode2', '2asd');
INSERT INTO `knowledge_desc` VALUES ('a3d85bd0c1b24d9ab7ed67ddd3aa3d9c', 'unname1', null);
INSERT INTO `knowledge_desc` VALUES ('d8530df4caff4a2db4939161ed6a1fe6', 'unname1', null);
INSERT INTO `knowledge_desc` VALUES ('de33cc1ea7b34e9f959e46adf94f2666', 'noooode1', 'tt');
INSERT INTO `knowledge_desc` VALUES ('test', 'testsdfsd', 'df');

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
INSERT INTO `knowledge_relation` VALUES ('44', '56');
INSERT INTO `knowledge_relation` VALUES ('null', 'test');
INSERT INTO `knowledge_relation` VALUES ('test', 'de33cc1ea7b34e9f959e46adf94f2666');
INSERT INTO `knowledge_relation` VALUES ('de33cc1ea7b34e9f959e46adf94f2666', '8a23a7c860ef45878ac5fd8414808ee9');
INSERT INTO `knowledge_relation` VALUES ('de33cc1ea7b34e9f959e46adf94f2666', 'd8530df4caff4a2db4939161ed6a1fe6');
INSERT INTO `knowledge_relation` VALUES ('d8530df4caff4a2db4939161ed6a1fe6', 'a3d85bd0c1b24d9ab7ed67ddd3aa3d9c');
INSERT INTO `knowledge_relation` VALUES ('2', '50ff5e65738f4f608f9d929dac96bb4f');
