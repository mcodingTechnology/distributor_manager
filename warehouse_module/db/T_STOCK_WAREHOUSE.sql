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
--  Table structure for `T_STOCK_WAREHOUSE`
-- ----------------------------
DROP TABLE IF EXISTS `T_STOCK_WAREHOUSE`;
CREATE TABLE `T_STOCK_WAREHOUSE` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `USER_ID` varchar(50) DEFAULT NULL COMMENT '用户ID',
  `COMPANY_ID` varchar(50) DEFAULT NULL COMMENT '公司ID',
  `WAREHOUSE_NAME` varchar(255) DEFAULT NULL COMMENT '仓库名称',
  `WAREHOUSE_CODE` varchar(255) DEFAULT NULL COMMENT '仓库编码',
  `IS_DEFAULT` int(11) DEFAULT '0' COMMENT '是否默认仓库：0否，1是',
  `STATUS` varchar(50) DEFAULT 'available' COMMENT '状态：available可用，unavailable不可用',
  `ADDRESS` varchar(255) DEFAULT NULL COMMENT '仓库地址',
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `IS_ENABLE` int(11) DEFAULT '1' COMMENT '是否启用：1启用，0禁用',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='仓库';

SET FOREIGN_KEY_CHECKS = 1;
