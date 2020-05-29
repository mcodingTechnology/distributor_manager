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
--  Table structure for `T_STOCK_CHECK`
-- ----------------------------
DROP TABLE IF EXISTS `T_STOCK_CHECK`;
CREATE TABLE `T_STOCK_CHECK` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `SRC` varchar(50) DEFAULT 'entering' COMMENT '来源：entering手工录入，import导入',
  `COMPANY_ID` varchar(50) DEFAULT NULL COMMENT '公司ID',
  `COMPANY_NAME` varchar(255) DEFAULT NULL COMMENT '公司名称',
  `USER_ID` varchar(50) DEFAULT NULL COMMENT '用户ID',
  `WAREHOUSE_ID` varchar(50) DEFAULT NULL COMMENT '仓库ID',
  `WAREHOUSE_NAME` varchar(255) DEFAULT NULL COMMENT '仓库名称',
  `CHECK_ORDER_NUM` varchar(255) DEFAULT NULL COMMENT '盘点单号',
  `CHECK_TIME` datetime DEFAULT NULL COMMENT '盘点时间',
  `TRAVELING_TIME` datetime DEFAULT NULL COMMENT '在途时间',
  `REMARK` varchar(255) DEFAULT NULL COMMENT '备注',
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `IS_ENABLE` int(11) DEFAULT '1' COMMENT '是否启用：1启用，0禁用',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='盘点单';

SET FOREIGN_KEY_CHECKS = 1;
