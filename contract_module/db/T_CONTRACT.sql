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
--  Table structure for `T_CONTRACT`
-- ----------------------------
DROP TABLE IF EXISTS `T_CONTRACT`;
CREATE TABLE `T_CONTRACT` (
  `ID` varchar(50) NOT NULL COMMENT '主键',
  `CONTRACT_NAME` varchar(255) DEFAULT NULL COMMENT '合同名称',
  `CONTRACT_NUM` varchar(50) DEFAULT NULL COMMENT '合同编号',
  `SIGN_DATE` date DEFAULT NULL COMMENT '签署日期',
  `START_DATE` date DEFAULT NULL COMMENT '开始日期',
  `END_DATE` date DEFAULT NULL COMMENT '结束日期',
  `STATUS` varchar(50) DEFAULT NULL COMMENT '状态：submit已提交、valid生效、invalid作废',
  `SIGN_ADDR` varchar(255) DEFAULT NULL COMMENT '签署地',
  `PARTY_A_ID` varchar(50) DEFAULT NULL COMMENT '甲方ID',
  `PARTY_A` varchar(255) DEFAULT NULL COMMENT '甲方',
  `PARTY_B_ID` varchar(50) DEFAULT NULL COMMENT '乙方ID',
  `PARTY_B` varchar(255) DEFAULT NULL COMMENT '乙方',
  `SALE_PROVINCE` varchar(50) DEFAULT NULL COMMENT '销售区域省',
  `SALE_CITY` varchar(50) DEFAULT NULL COMMENT '销售区域市',
  `SALE_DISTRICT` varchar(50) DEFAULT NULL COMMENT '销售区域县(区)',
  `SALE_PROVINCE_CODE` varchar(50) DEFAULT NULL COMMENT '销售区域省编码',
  `SALE_CITY_CODE` varchar(50) DEFAULT NULL COMMENT '销售区域市编码',
  `SALE_DISTRICT_CODE` varchar(50) DEFAULT NULL COMMENT '销售区域县(区)编码',
  `SALE_CHANNEL` varchar(50) DEFAULT NULL COMMENT '销售渠道：ds药店、cs化妆品店、mbs母婴用品店',
  `YEAR_REFUND_TARGET` double DEFAULT NULL COMMENT '年度回款目标(万元)',
  `FIRST_PAY_AMOUNT` double DEFAULT NULL COMMENT '首笔货款金额(万元)',
  `FIRST_RECEIPT_DATE` date DEFAULT NULL COMMENT '首笔收款日期',
  `PER_ORDER_AMOUNT` double DEFAULT NULL COMMENT '每批次订货金额(万元)',
  `GOODS_PAYMENT` varchar(50) DEFAULT NULL COMMENT '货款：pbd款到发货、cod货到付款',
  `PAY_TYPE` varchar(50) DEFAULT NULL COMMENT '货款支付方式：TA转账、TT电汇',
  `PAYEE_ID` varchar(50) DEFAULT NULL COMMENT '收款单位ID',
  `PAYEE_NAME` varchar(255) DEFAULT NULL COMMENT '收款单位名称',
  `BANK_TYPE` varchar(50) DEFAULT NULL COMMENT '银行类型',
  `BANK_NAME` varchar(50) DEFAULT NULL COMMENT '银行名称',
  `BANK_ACCOUNT` varchar(50) DEFAULT NULL COMMENT '银行账号',
  `DELIVERY_ADDRESS` varchar(255) DEFAULT NULL COMMENT '合同发货地址',
  `RECEIVE_ADDRESS` varchar(255) DEFAULT NULL COMMENT '合同收货地址',
  `RECEIVE_NAME` varchar(50) DEFAULT NULL COMMENT '收货人姓名',
  `RECEIVE_PHONE` varchar(50) DEFAULT NULL COMMENT '收货人电话',
  `FIRST_PENALTY` int(11) DEFAULT NULL COMMENT '违约金第一次（元）',
  `SECOND_PENALTY` int(11) DEFAULT NULL COMMENT '违约金第二次或以上（元）',
  `MARKET_EXPENSE_RATE` double DEFAULT NULL COMMENT '市场推广费用比率',
  `REFUND_EXCHANGE_ADDRESS` varchar(255) DEFAULT NULL COMMENT '退、换货地址',
  `REFUND_EXCHANGE_NAME` varchar(50) DEFAULT NULL COMMENT '退、换货收货人姓名',
  `REFUND_EXCHANGE_PHONE` varchar(50) DEFAULT NULL COMMENT '退、换货收货人电话',
  `REFUND_EXCHANGE_LIMIT_RATE` double DEFAULT NULL COMMENT '退、换货额度为本年总回款额的占比，在这个比率内可免费',
  `REFUND_EXCHANGE_EXCEED_RATE` double DEFAULT NULL COMMENT '退、换货额度超出本年发货总额的占比',
  `CREATE_TIME` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `IS_ENABLE` int(11) DEFAULT '1' COMMENT '是否启用：1启用，0禁用',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合同';

SET FOREIGN_KEY_CHECKS = 1;
