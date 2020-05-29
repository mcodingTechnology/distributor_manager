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
--  Table structure for `T_CONTRACT_SALE_SUPPORT`
-- ----------------------------
DROP TABLE IF EXISTS `T_CONTRACT_SALE_SUPPORT`;
CREATE TABLE `T_CONTRACT_SALE_SUPPORT` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `CONTRACT_ID` varchar(50) DEFAULT NULL COMMENT '合同ID',
  `SERIAL_NUM` int(11) DEFAULT NULL COMMENT '序号',
  `REFUND_MIN` double DEFAULT NULL COMMENT '回款任务(万元)最小值(大于)',
  `REFUND_MAX` double DEFAULT NULL COMMENT '回款任务(万元)最大值(小于等于)',
  `SUPPORT_RATE` double DEFAULT NULL COMMENT '销售支持比率',
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `IS_ENABLE` int(11) DEFAULT '1' COMMENT '是否启用：1启用，0禁用',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合同销售支持';

SET FOREIGN_KEY_CHECKS = 1;
