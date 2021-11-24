/*
Navicat MySQL Data Transfer

Source Server         : booklib
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : g11zucc

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2021-11-24 18:51:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for choose
-- ----------------------------
DROP TABLE IF EXISTS `choose`;
CREATE TABLE `choose` (
  `choose_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '认领id',
  `choose_wallid` int(11) NOT NULL COMMENT '表白墙id',
  `choose_beuserid` varchar(10) NOT NULL COMMENT '被认领人',
  `choose_userid` varchar(10) NOT NULL COMMENT '认领人',
  `choose_state` int(11) NOT NULL COMMENT '认领状态，0未认领1认领',
  `choose_time` datetime NOT NULL COMMENT '认领时间',
  PRIMARY KEY (`choose_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of choose
-- ----------------------------

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `collection_id` int(11) NOT NULL AUTO_INCREMENT,
  `collection_userid` varchar(255) NOT NULL COMMENT '收藏的用户id',
  `collection_wallid` int(11) NOT NULL COMMENT '收藏的帖子id',
  `collection_time` datetime NOT NULL COMMENT '收藏时间',
  PRIMARY KEY (`collection_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collection
-- ----------------------------

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `feedback_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '反馈id号',
  `feedback_title` varchar(10) NOT NULL COMMENT '反馈标题',
  `feedback_content` varchar(140) NOT NULL COMMENT '反馈正文',
  `feedback_userid` varchar(10) NOT NULL COMMENT '反馈人',
  `feedback_date` datetime NOT NULL COMMENT '反馈时间',
  `feedback_state` int(11) NOT NULL COMMENT '反馈状态，1未处理，2已经处理',
  PRIMARY KEY (`feedback_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feedback
-- ----------------------------

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `reply_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '回复编号',
  `wall_id` int(11) NOT NULL COMMENT '在谁的帖子下回复',
  `reply_content` varchar(20) NOT NULL COMMENT '回复正文',
  `reply_userid` varchar(10) NOT NULL COMMENT '回复的用户id',
  `reply_time` datetime NOT NULL COMMENT '回复时间',
  `reply_state` int(11) NOT NULL COMMENT '回复状态，1正常2删除',
  PRIMARY KEY (`reply_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(10) NOT NULL COMMENT '用户id（学号）',
  `user_name` varchar(10) NOT NULL COMMENT '用户昵称',
  `user_pwd` varchar(10) NOT NULL COMMENT '用户密码',
  `user_registertime` datetime NOT NULL COMMENT '注册时间',
  `user_state` int(11) NOT NULL COMMENT '用户状态，1正常，2冷冻，3封禁',
  `user_sex` int(11) NOT NULL COMMENT '用户性别，1男2女',
  `user_jurisdiction` int(11) NOT NULL COMMENT '用户权限，1普通用户2管理员',
  `user_signature` varchar(100) DEFAULT '' COMMENT '个性签名',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('31901209', 'Lenovo', '123456', '2021-11-18 18:47:19', '1', '1', '2', '');

-- ----------------------------
-- Table structure for wall
-- ----------------------------
DROP TABLE IF EXISTS `wall`;
CREATE TABLE `wall` (
  `wall_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，表白墙id',
  `wall_content` varchar(140) NOT NULL COMMENT '表白墙正文',
  `wall_contenttitle` varchar(10) NOT NULL COMMENT '表白墙标题',
  `wall_time` datetime NOT NULL COMMENT '表白墙发表时间',
  `wall_userid` varchar(10) NOT NULL COMMENT '发表该表白墙的用户',
  `wall_state` int(10) NOT NULL COMMENT '表白墙状态，1正常2精选3删除',
  `wall_good` int(11) NOT NULL COMMENT '表白墙点赞数',
  `wall_collection` int(11) NOT NULL COMMENT '表白墙收藏数',
  `wall_talk` int(11) NOT NULL COMMENT '表白墙评论数',
  `wall_report` int(11) NOT NULL COMMENT '表白墙举报数',
  `wall_to` varchar(10) DEFAULT NULL COMMENT '被表白对象',
  PRIMARY KEY (`wall_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wall
-- ----------------------------
