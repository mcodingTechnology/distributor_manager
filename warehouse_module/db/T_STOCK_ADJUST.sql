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
--  Table structure for `T_STOCK_ADJUST`
-- ----------------------------
DROP TABLE IF EXISTS `T_STOCK_ADJUST`;
CREATE TABLE `T_STOCK_ADJUST` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `COMPANY_ID` varchar(50) DEFAULT NULL COMMENT '公司ID',
  `COMPANY_NAME` varchar(255) DEFAULT NULL COMMENT '公司名称',
  `USER_ID` varchar(50) DEFAULT NULL COMMENT '用户ID',
  `WAREHOUSE_ID` varchar(50) DEFAULT NULL COMMENT '仓库ID',
  `WAREHOUSE_NAME` varchar(255) DEFAULT NULL COMMENT '仓库名称',
  `ADJUST_ORDER_NUM` varchar(255) DEFAULT NULL COMMENT '调整单号',
  `ADJUST_TIME` datetime DEFAULT NULL COMMENT '调整时间',
  `ADJUST_REASON` varchar(255) DEFAULT NULL COMMENT '调整原因',
  `REMARK` varchar(255) DEFAULT NULL COMMENT '备注',
  `STATUS` varchar(50) DEFAULT NULL COMMENT '状态：to_audit待审批、pass审批通过、no_pass审批不通过',
  `AUDIT_REASON` varchar(255) DEFAULT NULL COMMENT '审批原因',
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `IS_ENABLE` int(11) DEFAULT '1' COMMENT '是否启用：1启用，0禁用',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='调整单';

SET FOREIGN_KEY_CHECKS = 1;
