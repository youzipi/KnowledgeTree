/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50535
Source Host           : 127.0.0.1:3306
Source Database       : infotree

Target Server Type    : MYSQL
Target Server Version : 50535
File Encoding         : 65001

Date: 2014-11-24 15:38:56
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of knowledge_desc
-- ----------------------------
INSERT INTO `knowledge_desc` VALUES ('087cdc5db6394fbbadecbbde4253b8e8', 'null', null);
INSERT INTO `knowledge_desc` VALUES ('1', 'java', 'Java is a computer programming language that is concurrent, class-based, object-oriented, and specifically designed to have as few implementation dependencies as possible.');
INSERT INTO `knowledge_desc` VALUES ('11', 'java ee', 'Java Platform Enterprise Editionn');
INSERT INTO `knowledge_desc` VALUES ('111', 'servlet', 'servlett');
INSERT INTO `knowledge_desc` VALUES ('112', 'jsp', 'jsppp');
INSERT INTO `knowledge_desc` VALUES ('12', 'java se', 'Java Platform Standard Edition123ffghhgghfd');
INSERT INTO `knowledge_desc` VALUES ('2', 'css', 'Cascading Style Sheets');
INSERT INTO `knowledge_desc` VALUES ('50ff5e65738f4f608f9d929dac96bb4f', 'unname1', '呵呵呵');
INSERT INTO `knowledge_desc` VALUES ('t1', 't1', 'tttttt');
INSERT INTO `knowledge_desc` VALUES ('t2', 't2', null);
INSERT INTO `knowledge_desc` VALUES ('t3', 't3', '1212');
INSERT INTO `knowledge_desc` VALUES ('t5', 't5', '2asd');
INSERT INTO `knowledge_desc` VALUES ('test', 'test', 'df');

-- ----------------------------
-- Table structure for knowledge_relation
-- ----------------------------
DROP TABLE IF EXISTS `knowledge_relation`;
CREATE TABLE `knowledge_relation` (
  `father_id` varchar(50) DEFAULT NULL,
  `id_sub` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
INSERT INTO `knowledge_relation` VALUES ('test', 't1');
INSERT INTO `knowledge_relation` VALUES ('t1', 't2');
INSERT INTO `knowledge_relation` VALUES ('t2', 't3');
INSERT INTO `knowledge_relation` VALUES ('t2', 't5');
INSERT INTO `knowledge_relation` VALUES ('2', '50ff5e65738f4f608f9d929dac96bb4f');
