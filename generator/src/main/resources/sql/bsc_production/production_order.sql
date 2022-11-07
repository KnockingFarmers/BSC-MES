/*
 Navicat Premium Data Transfer

 Source Server         : mydb
 Source Server Type    : MySQL
 Source Server Version : 50621
 Source Host           : localhost:3306
 Source Schema         : bsc_production

 Target Server Type    : MySQL
 Target Server Version : 50621
 File Encoding         : 65001

 Date: 07/11/2022 20:49:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for production_order
-- ----------------------------
DROP TABLE IF EXISTS `production_order`;
CREATE TABLE `production_order`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `gtm_created` datetime(0) NOT NULL COMMENT '创建时间',
  `order_no` bigint(30) NOT NULL COMMENT '订单号',
  `gmt_modified` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `status` int(1) NOT NULL COMMENT '订单状态',
  `responsible_person` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '张三' COMMENT '责任人',
  `order_amount` decimal(10, 0) NOT NULL DEFAULT 0 COMMENT '下单金额',
  `order_product` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'BSC总成' COMMENT '订单产品',
  `product_num` double NOT NULL DEFAULT 100000 COMMENT '下单数量',
  `deleted` int(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
  `customer_id` bigint(20) NOT NULL COMMENT '客户id，外键',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '生产管理订单表' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
