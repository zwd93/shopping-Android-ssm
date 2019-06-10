# Spring-SpringMVC-Mybatis
## 环境
  + Eclipse:Mars Release (4.5.0)
  + Java web项目
  + MySql 5.7
  + JDK1.7
  + Spring3.2.0 + Mybatis3.2.7
  + Tomcat8.0.50
## 数据库
```sql
/*
Navicat MySQL Data Transfer

Source Server         : ZWD
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2019-06-10 12:21:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `activity`
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品活动id',
  `title` varchar(255) DEFAULT NULL COMMENT '商品活动标题',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('1', '超值购');
INSERT INTO `activity` VALUES ('2', '热门活动');
INSERT INTO `activity` VALUES ('3', '特色市场');
INSERT INTO `activity` VALUES ('4', '大卖大卖');

-- ----------------------------
-- Table structure for `categories`
-- ----------------------------
DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品类别id',
  `title` varchar(255) DEFAULT NULL COMMENT '商品类别图片地址',
  `img_url` varchar(255) DEFAULT NULL,
  `activity_id` int(11) DEFAULT NULL COMMENT '活动id',
  PRIMARY KEY (`id`),
  KEY `acticity_id` (`activity_id`),
  CONSTRAINT `acticity_id` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of categories
-- ----------------------------
INSERT INTO `categories` VALUES ('1', '玩转十一', 'imgs/3.jpeg', '1');
INSERT INTO `categories` VALUES ('2', '萌动双10季', 'imgs/4.jpg', '1');
INSERT INTO `categories` VALUES ('3', '联想品牌日', 'imgs/5.jpg', '1');
INSERT INTO `categories` VALUES ('4', '满减专区', 'imgs/6.jpg', '2');
INSERT INTO `categories` VALUES ('5', '钟表榜', 'imgs/7.jpg', '2');
INSERT INTO `categories` VALUES ('6', '手机国庆礼', 'imgs/8.jpg', '2');
INSERT INTO `categories` VALUES ('7', '品牌特卖', 'imgs/9.jpg', '3');
INSERT INTO `categories` VALUES ('8', '品牌秀场', 'imgs/10.jpg', '3');
INSERT INTO `categories` VALUES ('9', '最招聘', 'imgs/11.jpg', '3');
INSERT INTO `categories` VALUES ('10', '天天特卖', 'imgs/12.jpg', '4');
INSERT INTO `categories` VALUES ('11', '每日好店', 'imgs/13.jpg', '4');
INSERT INTO `categories` VALUES ('12', '哇哦视频', 'imgs/14.jpg', '4');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  `productid` int(11) DEFAULT NULL COMMENT '产品id',
  `statuscode` int(11) DEFAULT NULL COMMENT '状态代码',
  `useraddress` varchar(255) DEFAULT NULL COMMENT '收货地址',
  `submittime` date DEFAULT NULL COMMENT '购买日期',
  `备用1` varchar(255) DEFAULT NULL,
  `备用2` varchar(255) DEFAULT NULL,
  `备用3` varchar(255) DEFAULT NULL,
  `备用4` varchar(255) DEFAULT NULL,
  `备用5` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `productid` (`productid`),
  KEY `userid` (`userid`),
  CONSTRAINT `productid` FOREIGN KEY (`productid`) REFERENCES `product` (`id`),
  CONSTRAINT `userid` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `imgUrl` varchar(255) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `categories_id` int(11) DEFAULT NULL,
  `备用1` date DEFAULT NULL,
  `备用2` varchar(255) DEFAULT NULL,
  `备用3` varchar(255) DEFAULT NULL,
  `备用4` varchar(255) DEFAULT NULL,
  `备用5` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `categories_id` (`categories_id`),
  CONSTRAINT `categories_id` FOREIGN KEY (`categories_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '小米饼', '12', '好吃不贵', 'imgs/15.jpg', null, '1', null, null, null, null, null);
INSERT INTO `product` VALUES ('2', '西兰菜花', '10', '喔哈哈哈哈', 'imgs/16.jpg', null, '2', null, null, null, null, null);
INSERT INTO `product` VALUES ('3', '鸡爪', '5', '泡椒鸡爪', 'imgs/17.jpg', null, '3', null, null, null, null, null);
INSERT INTO `product` VALUES ('4', '洛基亚', '1000', '好看耐摔', 'imgs/18.jpg', null, '4', null, null, null, null, null);
INSERT INTO `product` VALUES ('5', 'OPPO', '3400', '照亮你的美', 'imgs/19.jpg', null, '5', null, null, null, null, null);
INSERT INTO `product` VALUES ('6', '英语六级考试卷', '34', '六级', 'imgs/20.jpg', null, '6', null, null, null, null, null);
INSERT INTO `product` VALUES ('7', '英语四级考试卷', '35', '四级', 'imgs/21.jpg', null, '7', null, null, null, null, null);
INSERT INTO `product` VALUES ('8', '老干妈', '10', '贵州最美', 'imgs/22.jpg', null, '8', null, null, null, null, null);
INSERT INTO `product` VALUES ('9', 'Lenovo ideapad 710s', '2200', '笔记本', 'imgs/24.jpg', null, '9', null, null, null, null, null);
INSERT INTO `product` VALUES ('10', '法式方领复古上衣', '99', '复古女郎', 'imgs/23.jpg', null, '10', null, null, null, null, null);
INSERT INTO `product` VALUES ('11', '短袖洋气T恤', '99', '短袖', 'imgs/25.jpg', null, '11', null, null, null, null, null);
INSERT INTO `product` VALUES ('12', '很仙的毛衣', '139', '秒变高挑女神', 'imgs/26.jpg', null, '12', null, null, null, null, null);

-- ----------------------------
-- Table structure for `stutas`
-- ----------------------------
DROP TABLE IF EXISTS `stutas`;
CREATE TABLE `stutas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `meaning` varchar(255) DEFAULT NULL COMMENT '状态含义',
  `statuscode` int(11) DEFAULT NULL COMMENT '状态代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stutas
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名称',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `logo_url` char(255) DEFAULT NULL COMMENT '用户头像',
  `phone` varchar(255) DEFAULT NULL COMMENT '电话号码',
  `email` varchar(255) DEFAULT NULL COMMENT '电子邮箱',
  `备用1` date DEFAULT NULL,
  `备用2` float DEFAULT NULL,
  `备用3` varchar(255) DEFAULT NULL,
  `备用4` varchar(255) DEFAULT NULL,
  `备用5` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin123', '', 'admin', '', null, null, null, null, null);
INSERT INTO `user` VALUES ('2', '123', '123456', null, '18900000000', null, null, null, null, null, null);
INSERT INTO `user` VALUES ('3', '123', '123456', null, '1890000000', null, null, null, null, null, null);
INSERT INTO `user` VALUES ('4', 'aaa', '123456', null, '15300000000', null, null, null, null, null, null);
INSERT INTO `user` VALUES ('5', 'police', '110', null, '110', null, null, null, null, null, null);
INSERT INTO `user` VALUES ('6', 'hospital', '120', null, '120', null, null, null, null, null, null);
INSERT INTO `user` VALUES ('7', 'aaa', '123456', null, '123456', null, null, null, null, null, null);


```
