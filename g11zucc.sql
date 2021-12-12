/*
Navicat MySQL Data Transfer

Source Server         : g11
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : g11zucc

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2021-12-12 16:10:23
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
  `choose_state` varchar(11) NOT NULL COMMENT '认领状态，0未认领1认领',
  `choose_time` datetime NOT NULL COMMENT '认领时间',
  PRIMARY KEY (`choose_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of choose
-- ----------------------------
INSERT INTO `choose` VALUES ('1', '1', '31901209', '31901208', '已认领', '2021-11-28 20:09:02');
INSERT INTO `choose` VALUES ('2', '2', '31901211', '31901209', '已认领', '2021-11-28 20:09:28');
INSERT INTO `choose` VALUES ('3', '3', '31901208', '31901211', '未认领', '2021-11-28 20:09:47');
INSERT INTO `choose` VALUES ('4', '5', '10111111', '11111111', '0', '2021-12-31 17:48:56');
INSERT INTO `choose` VALUES ('5', '7', '11111111', '10111111', '1', '2021-12-04 18:46:18');
INSERT INTO `choose` VALUES ('6', '9', '10111111', '11111111', '1', '2021-12-04 19:07:34');

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES ('1', '31901209', '2', '2021-11-28 20:06:26');
INSERT INTO `collection` VALUES ('2', '31901208', '1', '2021-11-28 20:06:41');
INSERT INTO `collection` VALUES ('3', '31901211', '3', '2021-11-28 20:06:47');
INSERT INTO `collection` VALUES ('4', '1', '1', '2021-11-30 22:32:03');
INSERT INTO `collection` VALUES ('5', '5', '5', '2021-11-30 22:32:19');
INSERT INTO `collection` VALUES ('6', '5', '7', '2021-11-10 22:32:25');
INSERT INTO `collection` VALUES ('7', '11111111', '1', '2021-10-28 22:37:38');
INSERT INTO `collection` VALUES ('8', '11111111', '2', '2021-12-01 13:57:00');
INSERT INTO `collection` VALUES ('9', '11111111', '1', '2021-12-10 15:36:18');

-- ----------------------------
-- Table structure for email
-- ----------------------------
DROP TABLE IF EXISTS `email`;
CREATE TABLE `email` (
  `email` varchar(255) NOT NULL,
  `code` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of email
-- ----------------------------
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '0');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '0');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '0');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '0');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '642775');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '0');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '0');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '0');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '0');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '0');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '0');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '0');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '0');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '470239');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '991860');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '574612');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '643014');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '137356');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '632361');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '131532');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '139548');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '666542');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '935568');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '182452');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '704358');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '800354');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '124366');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '436812');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '176228');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '934088');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '848663');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '419889');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '455711');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '326519');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '169098');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '308510');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '635642');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '254451');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '788910');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '906045');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '647030');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '867299');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '958541');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '559872');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '283495');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '713118');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '808228');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '847821');
INSERT INTO `email` VALUES ('31901208@stu.zucc.edu.cn', '407417');

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
  `feedback_state` varchar(11) NOT NULL COMMENT '反馈状态，1未处理，2已经处理',
  PRIMARY KEY (`feedback_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES ('1', '管理员看过来', '你上当了', '31901209', '2021-11-28 20:04:53', '未处理');
INSERT INTO `feedback` VALUES ('2', '管理员别看过来', '你上当了', '31901208', '2021-11-28 20:05:12', '未处理');
INSERT INTO `feedback` VALUES ('3', '管理员你Ma没了', '芜湖', '31901211', '2021-11-28 20:05:31', '未处理');

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
  `reply_state` varchar(11) NOT NULL COMMENT '回复状态，1正常2删除',
  PRIMARY KEY (`reply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES ('1', '1', '真不戳', '31901209', '2021-11-28 20:02:20', '正常');
INSERT INTO `reply` VALUES ('2', '2', '针不戳', '31901210', '2021-11-28 20:03:18', '正常');
INSERT INTO `reply` VALUES ('3', '3', '牛逼', '31901211', '2021-11-28 20:03:43', '正常');
INSERT INTO `reply` VALUES ('4', '4', 'bn', '11111111', '2021-12-04 19:03:53', 'zc');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(10) NOT NULL COMMENT '用户id（学号）',
  `user_name` varchar(10) NOT NULL COMMENT '用户昵称',
  `user_pwd` varchar(100) NOT NULL COMMENT '用户密码',
  `user_registertime` datetime NOT NULL COMMENT '注册时间',
  `user_state` varchar(11) DEFAULT NULL COMMENT '正常，冷冻，封禁',
  `user_sex` varchar(11) DEFAULT NULL COMMENT '男,女,未知',
  `user_jurisdiction` varchar(11) DEFAULT NULL COMMENT '普通用户,管理员',
  `user_signature` varchar(100) DEFAULT '' COMMENT '个性签名',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('10101010', '12345679', 'defac44447b57f152d14f30cea7a73cb', '2021-12-12 16:03:46', '正常', '男', '用户', '');
INSERT INTO `user` VALUES ('11111111', '11', '96e79218965eb72c92a549dd5a330112', '2021-11-30 16:16:08', '正常', '男', '用户', '我的我的我的');
INSERT INTO `user` VALUES ('12345555', '12345679', 'defac44447b57f152d14f30cea7a73cb', '2021-12-12 16:00:38', '正常', '男', '用户', '');
INSERT INTO `user` VALUES ('12345678', '12345678', '25d55ad283aa400af464c76d713c07ad', '2021-12-12 11:37:35', '正常', '男', '用户', '');
INSERT INTO `user` VALUES ('12345679', '12345678', '25d55ad283aa400af464c76d713c07ad', '2021-12-12 12:03:02', '正常', '男', '用户', '');
INSERT INTO `user` VALUES ('12345680', '12345679', 'defac44447b57f152d14f30cea7a73cb', '2021-12-12 15:58:15', '正常', '男', '用户', '');
INSERT INTO `user` VALUES ('20000000', '12345679', 'defac44447b57f152d14f30cea7a73cb', '2021-12-12 15:59:04', '正常', '男', '用户', '');
INSERT INTO `user` VALUES ('21111111', '21111111', '5992aa1ca5ec11321e6cb588f012fe13', '2021-12-12 12:54:39', '正常', '男', '用户', '');
INSERT INTO `user` VALUES ('21121111', '21121111', '3a6f4e10ef5a1981e2159da60f4e8c48', '2021-12-12 12:56:32', '正常', '男', '用户', '');
INSERT INTO `user` VALUES ('31901208', 'WYB', '111111', '2021-11-28 16:04:34', '正常', '男', '管理员', '');
INSERT INTO `user` VALUES ('31901209', 'Lenovo', '123456', '2021-11-28 16:02:52', '正常', '男', '管理员', '1010');
INSERT INTO `user` VALUES ('31901211', 'ZHJ', '123456', '2021-11-28 16:04:06', '正常', '男', '管理员', '');
INSERT INTO `user` VALUES ('33333333', '33333333', 'd27d320c27c3033b7883347d8beca317', '2021-12-12 12:03:47', '正常', '男', '用户', '');
INSERT INTO `user` VALUES ('45674567', '4567', 'b7bcc76a844978f0681f1c87b286c872', '2021-12-12 13:13:56', '正常', '男', '用户', '');
INSERT INTO `user` VALUES ('51111111', '51111111', 'e6ad56ac57420567a1286f576572310d', '2021-12-12 13:00:13', '正常', '男', '用户', '');
INSERT INTO `user` VALUES ('54545454', '54545454', '2f293b2594d89f65e28cb942526aea2e', '2021-12-12 13:17:53', '正常', '男', '用户', '');
INSERT INTO `user` VALUES ('55544444', '12345679', 'defac44447b57f152d14f30cea7a73cb', '2021-12-12 16:01:49', '正常', '男', '用户', '');
INSERT INTO `user` VALUES ('74747474', '74747474', '1451f2a4e2ff3852c594c0ea45bb5c91', '2021-12-12 16:07:30', '正常', '男', '用户', '');

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
  `wall_state` varchar(10) NOT NULL COMMENT '表白墙状态，1正常2精选3删除',
  `wall_good` int(11) NOT NULL COMMENT '表白墙点赞数',
  `wall_collection` int(11) NOT NULL COMMENT '表白墙收藏数',
  `wall_talk` int(11) NOT NULL COMMENT '表白墙评论数',
  `wall_report` int(11) NOT NULL COMMENT '表白墙举报数',
  `wall_to` varchar(10) DEFAULT NULL COMMENT '被表白对象',
  PRIMARY KEY (`wall_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wall
-- ----------------------------
INSERT INTO `wall` VALUES ('1', '我的最爱', 'oh,my baby', '2021-11-28 15:43:08', '31901209', '正常', '1', '2', '0', '0', 'wlx');
INSERT INTO `wall` VALUES ('9', '对象对象对象对象对象', '我的对象', '2021-12-09 22:59:02', '11111111', '正常', '0', '0', '0', '0', '我的对象');
