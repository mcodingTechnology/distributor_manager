/*
 Navicat Premium Data Transfer

 Source Server         : 39.108.169.59
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : 39.108.169.59
 Source Database       : omp

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 10/27/2017 10:34:16 AM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `T_CONTRACT_REFUND_TARGET`
-- ----------------------------
DROP TABLE IF EXISTS `T_CONTRACT_REFUND_TARGET`;
CREATE TABLE `T_CONTRACT_REFUND_TARGET` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `CONTRACT_ID` varchar(50) DEFAULT NULL COMMENT '合同ID',
  `YEAR` int(11) DEFAULT NULL COMMENT '年份',
  `MONTH` int(11) DEFAULT NULL COMMENT '月份',
  `YEAR_REFUND_TARGET` double DEFAULT NULL COMMENT '年度回款目标(万元)',
  `MONTH_REFUND_TARGET` double DEFAULT NULL COMMENT '月度回款目标(万元)',
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `IS_ENABLE` int(11) DEFAULT '1' COMMENT '是否启用：1启用，0禁用',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合同回款目标';

SET FOREIGN_KEY_CHECKS = 1;
