/*
Navicat MySQL Data Transfer

Source Server         : 京东云数据库
Source Server Version : 50718
Source Host           : 116.196.66.248:3306
Source Database       : rbac

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-01-17 16:15:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permisson
-- ----------------------------
DROP TABLE IF EXISTS `permisson`;
CREATE TABLE `permisson` (
  `permisson_id` int(11) NOT NULL AUTO_INCREMENT,
  `permisson_name` varchar(255) DEFAULT NULL,
  `permisson_url` varchar(255) DEFAULT NULL,
  `parent_permisson_id` int(11) DEFAULT NULL,
  `permisson_lv` int(255) DEFAULT '0' COMMENT '1为1级 2为2级',
  PRIMARY KEY (`permisson_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permisson
-- ----------------------------
INSERT INTO `permisson` VALUES ('1', '用户管理', null, '0', '1');
INSERT INTO `permisson` VALUES ('2', '新增修改', '/user-post', '1', '2');
INSERT INTO `permisson` VALUES ('3', '列表查询', '/user-get', '1', '2');
INSERT INTO `permisson` VALUES ('4', '删除用户', '/user/{id}-delete', '1', '2');
INSERT INTO `permisson` VALUES ('6', '角色管理', null, '0', '1');
INSERT INTO `permisson` VALUES ('7', '新增修改', '/role-post', '6', '2');
INSERT INTO `permisson` VALUES ('8', '列表查询', '/role-get', '6', '2');
INSERT INTO `permisson` VALUES ('9', '删除角色', '/role/{id}-delete', '6', '2');
INSERT INTO `permisson` VALUES ('11', '角色授权', '/role-authorization-post', '6', '2');
INSERT INTO `permisson` VALUES ('13', '权限管理', '', '0', '1');
INSERT INTO `permisson` VALUES ('14', '新增修改', '/permission-post', '13', '2');
INSERT INTO `permisson` VALUES ('15', '列表查询', '/permission-get', '13', '2');
INSERT INTO `permisson` VALUES ('16', '删除权限', '/permission/{id}-delete', '13', '2');
INSERT INTO `permisson` VALUES ('17', '预览权限', '/permission-view-get', '13', '2');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '用户管理员');
INSERT INTO `role` VALUES ('3', '角色管理员');
INSERT INTO `role` VALUES ('4', '权限管理员');
INSERT INTO `role` VALUES ('5', '超级管理员');

-- ----------------------------
-- Table structure for role_permisson
-- ----------------------------
DROP TABLE IF EXISTS `role_permisson`;
CREATE TABLE `role_permisson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permisson_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permisson
-- ----------------------------
INSERT INTO `role_permisson` VALUES ('43', '3', '7');
INSERT INTO `role_permisson` VALUES ('44', '3', '8');
INSERT INTO `role_permisson` VALUES ('45', '3', '9');
INSERT INTO `role_permisson` VALUES ('46', '3', '11');
INSERT INTO `role_permisson` VALUES ('47', '4', '14');
INSERT INTO `role_permisson` VALUES ('48', '4', '15');
INSERT INTO `role_permisson` VALUES ('49', '4', '16');
INSERT INTO `role_permisson` VALUES ('50', '4', '17');
INSERT INTO `role_permisson` VALUES ('51', '5', '2');
INSERT INTO `role_permisson` VALUES ('52', '5', '3');
INSERT INTO `role_permisson` VALUES ('53', '5', '4');
INSERT INTO `role_permisson` VALUES ('54', '5', '7');
INSERT INTO `role_permisson` VALUES ('55', '5', '8');
INSERT INTO `role_permisson` VALUES ('56', '5', '9');
INSERT INTO `role_permisson` VALUES ('57', '5', '11');
INSERT INTO `role_permisson` VALUES ('58', '5', '14');
INSERT INTO `role_permisson` VALUES ('59', '5', '15');
INSERT INTO `role_permisson` VALUES ('60', '5', '16');
INSERT INTO `role_permisson` VALUES ('61', '5', '17');
INSERT INTO `role_permisson` VALUES ('91', '1', '2');
INSERT INTO `role_permisson` VALUES ('92', '1', '3');
INSERT INTO `role_permisson` VALUES ('93', '1', '4');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `user_role_names` varchar(255) DEFAULT NULL,
  `user_account` varchar(20) DEFAULT NULL COMMENT '账号',
  `user_password` varchar(150) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('13', '小杜', '用户管理员', 'dusy', '123456');
INSERT INTO `user` VALUES ('14', '小云', '超级管理员', 'admin', '123456');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('5', '13', '1');
INSERT INTO `user_role` VALUES ('7', '14', '5');
INSERT INTO `user_role` VALUES ('8', '15', '3');
SET FOREIGN_KEY_CHECKS=1;
