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

 Date: 03/05/2023 19:37:40
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
-- Records of best_answer
-- ----------------------------
INSERT INTO `best_answer` VALUES (1020, NULL);
INSERT INTO `best_answer` VALUES (1021, NULL);
INSERT INTO `best_answer` VALUES (1022, NULL);
INSERT INTO `best_answer` VALUES (1023, NULL);
INSERT INTO `best_answer` VALUES (1024, NULL);
INSERT INTO `best_answer` VALUES (1025, NULL);
INSERT INTO `best_answer` VALUES (1026, NULL);
INSERT INTO `best_answer` VALUES (1027, NULL);
INSERT INTO `best_answer` VALUES (1028, NULL);
INSERT INTO `best_answer` VALUES (1029, NULL);
INSERT INTO `best_answer` VALUES (1030, NULL);
INSERT INTO `best_answer` VALUES (1031, NULL);
INSERT INTO `best_answer` VALUES (1032, NULL);
INSERT INTO `best_answer` VALUES (1033, NULL);
INSERT INTO `best_answer` VALUES (1034, NULL);
INSERT INTO `best_answer` VALUES (1035, NULL);
INSERT INTO `best_answer` VALUES (1036, NULL);
INSERT INTO `best_answer` VALUES (1037, NULL);
INSERT INTO `best_answer` VALUES (1038, NULL);
INSERT INTO `best_answer` VALUES (1039, NULL);
INSERT INTO `best_answer` VALUES (1040, NULL);
INSERT INTO `best_answer` VALUES (1041, NULL);
INSERT INTO `best_answer` VALUES (1042, NULL);
INSERT INTO `best_answer` VALUES (1043, NULL);
INSERT INTO `best_answer` VALUES (1044, NULL);
INSERT INTO `best_answer` VALUES (1045, NULL);
INSERT INTO `best_answer` VALUES (1046, NULL);

SET FOREIGN_KEY_CHECKS = 1;
