/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 03/05/2023 19:36:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for best_answer
-- ----------------------------
DROP TABLE IF EXISTS `best_answer`;
CREATE TABLE `best_answer`  (
  `question_id` bigint(0) NOT NULL COMMENT '关联 question 的 id，随 question 的提出和删除一并操作，二者数量应该相等',
  `best_answer_id` bigint(0) NULL DEFAULT NULL COMMENT '关联 comment 的 id',
  PRIMARY KEY (`question_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '问题集 id',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '问题集标题',
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建者，关联 user 的 id',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '问题集描述',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更改时间，若无可为空',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1002 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for collection_question_relation
-- ----------------------------
DROP TABLE IF EXISTS `collection_question_relation`;
CREATE TABLE `collection_question_relation`  (
  `collection_id` bigint(0) NOT NULL COMMENT '关联 collection 的 id',
  `question_id` bigint(0) NOT NULL COMMENT '关联 question 的 id',
  PRIMARY KEY (`collection_id`, `question_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '评论 id',
  `question` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '关联 question 的 id',
  `parent` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '父评论 id，关联 comment 的 id，若无则为 question 的一级评论',
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '关联 user 的 id',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '内容',
  `upvote` int(0) NULL DEFAULT NULL COMMENT '点赞数',
  `devote` int(0) NULL DEFAULT NULL COMMENT '点踩数',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更改时间，若无可为空',
  `status` int(0) NULL DEFAULT NULL COMMENT '状态，是否可用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for point
-- ----------------------------
DROP TABLE IF EXISTS `point`;
CREATE TABLE `point`  (
  `id` bigint(0) NOT NULL COMMENT '关联 user 的 id，随用户注册或删除账户时一并操作，应该与 user 的数据库条数相同',
  `point` bigint(0) NULL DEFAULT 0 COMMENT '助人点分数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '问题 id，唯一凭证',
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '作者，关联 user 的 id',
  `title` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '文章标题',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '文章内容',
  `reward` int(0) NULL DEFAULT NULL COMMENT '悬赏分数，标注最佳答案后进行事务性扣除',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间，若无更改可为空',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1047 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '标签 id',
  `label` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标签名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tag_question_relation
-- ----------------------------
DROP TABLE IF EXISTS `tag_question_relation`;
CREATE TABLE `tag_question_relation`  (
  `tag_id` bigint(0) NOT NULL COMMENT '关联 tag 的 id',
  `question_id` bigint(0) NOT NULL COMMENT '关联 question 的 id',
  PRIMARY KEY (`tag_id`, `question_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'user' COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码，加密',
  `avatar` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '头像，链接存储',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱，唯一凭证',
  `gender` tinyint(1) NULL DEFAULT 1 COMMENT '性别，默认为 1，女性',
  `birthday` datetime(6) NULL DEFAULT NULL COMMENT '生日，仅日期',
  `register_time` datetime(0) NULL DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
