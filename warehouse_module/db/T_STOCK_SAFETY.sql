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
--  Table structure for `T_STOCK_SAFETY`
-- ----------------------------
DROP TABLE IF EXISTS `T_STOCK_SAFETY`;
CREATE TABLE `T_STOCK_SAFETY` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `PRODUCT_ID` varchar(50) DEFAULT NULL COMMENT '产品ID',
  `PRODUCT_NAME` varchar(255) DEFAULT NULL COMMENT '产品名称',
  `PRODUCT_CODE` varchar(255) DEFAULT NULL COMMENT '产品编码',
  `PRODUCT_MODEL` varchar(255) DEFAULT NULL COMMENT '产品规格型号',
  `PRODUCT_UNIT` varchar(50) DEFAULT NULL COMMENT '产品单位',
  `MIN` int(11) DEFAULT NULL COMMENT '最小库存量',
  `MAX` int(11) DEFAULT NULL COMMENT '最大库存量',
  `DAY_SHIPMENTS` int(11) DEFAULT NULL COMMENT '日发货量',
  `MIN_PACKAGES` int(11) DEFAULT NULL COMMENT '最小包装数',
  `STATUS` varchar(50) DEFAULT NULL COMMENT '状态：valid有效、invalid无效',
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `IS_ENABLE` int(11) DEFAULT '1' COMMENT '是否启用：1启用，0禁用',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='安全库存';

SET FOREIGN_KEY_CHECKS = 1;
