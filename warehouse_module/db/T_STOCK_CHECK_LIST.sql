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
--  Table structure for `T_STOCK_CHECK_LIST`
-- ----------------------------
DROP TABLE IF EXISTS `T_STOCK_CHECK_LIST`;
CREATE TABLE `T_STOCK_CHECK_LIST` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `STOCK_CHECK_ID` varchar(50) DEFAULT NULL COMMENT '盘点单ID',
  `SRC` varchar(50) DEFAULT 'entering' COMMENT '来源：entering手工录入，import导入',
  `PRODUCT_ID` varchar(50) DEFAULT NULL COMMENT '产品ID',
  `PRODUCT_NAME` varchar(255) DEFAULT NULL COMMENT '产品名称',
  `PRODUCT_CODE` varchar(255) DEFAULT NULL COMMENT '产品编码',
  `PRODUCT_MODEL` varchar(255) DEFAULT NULL COMMENT '产品规格型号',
  `PRODUCT_UNIT` varchar(50) DEFAULT NULL COMMENT '产品单位',
  `AMOUNT` int(11) DEFAULT '0' COMMENT '实盘数量',
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `IS_ENABLE` int(11) DEFAULT '1' COMMENT '是否启用：1启用，0禁用',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='盘点明细清单';

SET FOREIGN_KEY_CHECKS = 1;
