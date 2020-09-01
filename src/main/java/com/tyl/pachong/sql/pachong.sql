/*
 Navicat Premium Data Transfer

 Source Server         : localhost 123456
 Source Server Type    : MySQL
 Source Server Version : 100413
 Source Host           : localhost:3306
 Source Schema         : pachong

 Target Server Type    : MySQL
 Target Server Version : 100413
 File Encoding         : 65001

 Date: 01/09/2020 10:51:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for movie
-- ----------------------------
DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie`  (
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `rate` float NULL DEFAULT NULL,
  PRIMARY KEY (`title`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for template3
-- ----------------------------
DROP TABLE IF EXISTS `template3`;
CREATE TABLE `template3`  (
  `template_id` int(11) NOT NULL,
  `renderer_accelerate` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`template_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
