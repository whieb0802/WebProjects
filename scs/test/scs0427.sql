/*
MySQL Data Transfer
Source Host: localhost
Source Database: scs07
Target Host: localhost
Target Database: scs07
Date: 2011/4/28 15:05:39
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for area
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
  `areaid` int(4) NOT NULL AUTO_INCREMENT,
  `areaname` varchar(20) NOT NULL,
  PRIMARY KEY (`areaid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for consume
-- ----------------------------
DROP TABLE IF EXISTS `consume`;
CREATE TABLE `consume` (
  `consumeid` int(11) NOT NULL AUTO_INCREMENT,
  `p1demand` int(11) NOT NULL,
  `p2demand` int(11) NOT NULL,
  `p3demand` int(11) NOT NULL,
  `currentime` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`consumeid`),
  UNIQUE KEY `consumeid` (`consumeid`),
  KEY `FK9BEF93DCD7CBEC0D` (`currentime`),
  KEY `FK9BEF93DC60B0246E` (`userid`),
  CONSTRAINT `FK9BEF93DC60B0246E` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`),
  CONSTRAINT `FK9BEF93DCD7CBEC0D` FOREIGN KEY (`currentime`) REFERENCES `currentime` (`currentime`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for currentime
-- ----------------------------
DROP TABLE IF EXISTS `currentime`;
CREATE TABLE `currentime` (
  `currentime` int(11) NOT NULL,
  PRIMARY KEY (`currentime`),
  UNIQUE KEY `currentime` (`currentime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for demand
-- ----------------------------
DROP TABLE IF EXISTS `demand`;
CREATE TABLE `demand` (
  `demandid` int(4) NOT NULL AUTO_INCREMENT,
  `p1mindemand` int(4) NOT NULL,
  `p2mindemand` int(4) NOT NULL,
  `p3mindemand` int(4) NOT NULL,
  `p1maxdemand` int(4) NOT NULL,
  `p2maxdemand` int(4) NOT NULL,
  `p3maxdemand` int(4) NOT NULL,
  `currentime` int(11) DEFAULT NULL,
  PRIMARY KEY (`demandid`),
  KEY `productid` (`p2mindemand`),
  KEY `FK79CBD66B54C1339C` (`p2mindemand`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for fund
-- ----------------------------
DROP TABLE IF EXISTS `fund`;
CREATE TABLE `fund` (
  `fundid` int(11) NOT NULL AUTO_INCREMENT,
  `currentloan` int(11) NOT NULL,
  `currentmoney` int(11) NOT NULL,
  `interest` float NOT NULL,
  `remaintime` int(11) NOT NULL,
  `totaloan` int(11) NOT NULL,
  `currentime` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`fundid`),
  UNIQUE KEY `fundid` (`fundid`),
  KEY `FK2196E5D7CBEC0D` (`currentime`),
  KEY `FK2196E560B0246E` (`userid`),
  CONSTRAINT `FK2196E560B0246E` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`),
  CONSTRAINT `FK2196E5D7CBEC0D` FOREIGN KEY (`currentime`) REFERENCES `currentime` (`currentime`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for groupinfo
-- ----------------------------
DROP TABLE IF EXISTS `groupinfo`;
CREATE TABLE `groupinfo` (
  `id` int(11) NOT NULL,
  `manCount` int(11) NOT NULL,
  `agentCount` int(11) NOT NULL,
  `retailerCount` int(11) NOT NULL,
  `groupCount` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for growline
-- ----------------------------
DROP TABLE IF EXISTS `growline`;
CREATE TABLE `growline` (
  `growlineid` int(11) NOT NULL AUTO_INCREMENT,
  `buyp1growline` int(11) NOT NULL,
  `buyp2growline` int(11) NOT NULL,
  `buyp3growline` int(11) NOT NULL,
  `islarged` int(11) NOT NULL,
  `rentp1growline` int(11) NOT NULL,
  `rentp2growline` int(11) NOT NULL,
  `rentp3growline` int(11) NOT NULL,
  `currentime` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`growlineid`),
  UNIQUE KEY `growlineid` (`growlineid`),
  KEY `FK22235EA7D7CBEC0D` (`currentime`),
  KEY `FK22235EA760B0246E` (`userid`),
  CONSTRAINT `FK22235EA760B0246E` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`),
  CONSTRAINT `FK22235EA7D7CBEC0D` FOREIGN KEY (`currentime`) REFERENCES `currentime` (`currentime`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for growlineinfo
-- ----------------------------
DROP TABLE IF EXISTS `growlineinfo`;
CREATE TABLE `growlineinfo` (
  `growlineid` int(4) NOT NULL,
  `growlinename` varchar(20) NOT NULL,
  `capacity` int(4) NOT NULL,
  `buyprice` int(8) NOT NULL,
  `rentprice` int(8) NOT NULL,
  `depretation` int(8) NOT NULL,
  `largerprice` int(8) NOT NULL,
  `largeredcapacity` int(4) NOT NULL,
  PRIMARY KEY (`growlineid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for icon
-- ----------------------------
DROP TABLE IF EXISTS `icon`;
CREATE TABLE `icon` (
  `userid` int(11) NOT NULL,
  `icon0` bit(1) NOT NULL,
  `icon1` bit(1) NOT NULL,
  `icon10` bit(1) NOT NULL,
  `icon11` bit(1) NOT NULL,
  `icon2` bit(1) NOT NULL,
  `icon3` bit(1) NOT NULL,
  `icon4` bit(1) NOT NULL,
  `icon5` bit(1) NOT NULL,
  `icon6` bit(1) NOT NULL,
  `icon7` bit(1) NOT NULL,
  `icon8` bit(1) NOT NULL,
  `icon9` bit(1) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for inventory
-- ----------------------------
DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory` (
  `inventoryid` int(11) NOT NULL AUTO_INCREMENT,
  `currentp1` int(11) NOT NULL,
  `currentp2` int(11) NOT NULL,
  `currentp3` int(11) NOT NULL,
  `p1in` int(11) NOT NULL,
  `p1out` int(11) NOT NULL,
  `p1totalin` int(11) NOT NULL,
  `p1totalout` int(11) NOT NULL,
  `p2in` int(11) NOT NULL,
  `p2out` int(11) NOT NULL,
  `p2totalin` int(11) NOT NULL,
  `p2totalout` int(11) NOT NULL,
  `p3in` int(11) NOT NULL,
  `p3out` int(11) NOT NULL,
  `p3totalin` int(11) NOT NULL,
  `p3totalout` int(11) NOT NULL,
  `currentime` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`inventoryid`),
  UNIQUE KEY `inventoryid` (`inventoryid`),
  KEY `FKFF02393CD7CBEC0D` (`currentime`),
  KEY `FKFF02393C60B0246E` (`userid`),
  CONSTRAINT `FKFF02393C60B0246E` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`),
  CONSTRAINT `FKFF02393CD7CBEC0D` FOREIGN KEY (`currentime`) REFERENCES `currentime` (`currentime`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `manager` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`manager`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `productid` int(4) NOT NULL,
  `roleid` int(4) NOT NULL,
  `pname` varchar(10) NOT NULL,
  `inprice` int(8) DEFAULT NULL,
  `outprice` int(8) DEFAULT NULL,
  `icost` int(8) NOT NULL,
  `advance` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `roleid` (`roleid`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for relation
-- ----------------------------
DROP TABLE IF EXISTS `relation`;
CREATE TABLE `relation` (
  `userid` int(11) NOT NULL,
  `upstream` int(11) NOT NULL,
  `areaid` int(11) NOT NULL,
  `roleid` int(11) NOT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `userid` (`userid`),
  KEY `FKE2CE5E1C3E77C572` (`areaid`),
  KEY `FKE2CE5E1C5B5ACF04` (`roleid`),
  KEY `FKE2CE5E1C60B0246E` (`userid`),
  CONSTRAINT `FKE2CE5E1C3E77C572` FOREIGN KEY (`areaid`) REFERENCES `area` (`areaid`),
  CONSTRAINT `FKE2CE5E1C5B5ACF04` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`),
  CONSTRAINT `FKE2CE5E1C60B0246E` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `reportid` int(11) NOT NULL AUTO_INCREMENT,
  `currentmoney` int(11) NOT NULL,
  `currentprofit` int(11) NOT NULL,
  `directcost` int(11) NOT NULL,
  `fundcost` int(11) NOT NULL,
  `growlinevalue` int(11) NOT NULL,
  `initiamoney` int(11) DEFAULT NULL,
  `productstoragecost` int(11) NOT NULL,
  `productstoragevalue` int(11) NOT NULL,
  `profitleft` int(11) NOT NULL,
  `receivablemoney` int(11) NOT NULL,
  `saleincome` int(11) NOT NULL,
  `storagerentcost` int(11) NOT NULL,
  `storagevalue` int(11) NOT NULL,
  `tax` int(11) NOT NULL,
  `totalloan` int(11) NOT NULL,
  `currentime` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `initialcapital` int(11) DEFAULT NULL,
  PRIMARY KEY (`reportid`),
  UNIQUE KEY `reportid` (`reportid`),
  KEY `FKC84C5534D7CBEC0D` (`currentime`),
  KEY `FKC84C553460B0246E` (`userid`),
  CONSTRAINT `FKC84C553460B0246E` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`),
  CONSTRAINT `FKC84C5534D7CBEC0D` FOREIGN KEY (`currentime`) REFERENCES `currentime` (`currentime`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleid` int(4) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(20) NOT NULL,
  `initialp1` int(4) NOT NULL,
  `initialp2` int(4) NOT NULL,
  `initialp3` int(4) NOT NULL,
  `initialmoney` int(8) NOT NULL,
  `maxloan` int(8) NOT NULL,
  `interestrate` float NOT NULL,
  `smallStorage` int(4) NOT NULL,
  `middleStorage` int(4) NOT NULL,
  `bigStorage` int(4) NOT NULL,
  `p1growline` int(4) NOT NULL,
  `p2growline` int(4) NOT NULL,
  `p3growline` int(4) NOT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for storage
-- ----------------------------
DROP TABLE IF EXISTS `storage`;
CREATE TABLE `storage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buy1count` int(11) DEFAULT NULL,
  `buy2count` int(11) DEFAULT NULL,
  `buy3count` int(11) DEFAULT NULL,
  `rent1count` int(11) DEFAULT NULL,
  `rent2count` int(11) DEFAULT NULL,
  `rent3count` int(11) DEFAULT NULL,
  `currentime` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKF2E8DA5BD7CBEC0D` (`currentime`),
  KEY `FKF2E8DA5B60B0246E` (`userid`),
  CONSTRAINT `FKF2E8DA5B60B0246E` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`),
  CONSTRAINT `FKF2E8DA5BD7CBEC0D` FOREIGN KEY (`currentime`) REFERENCES `currentime` (`currentime`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for storageinfo
-- ----------------------------
DROP TABLE IF EXISTS `storageinfo`;
CREATE TABLE `storageinfo` (
  `id` int(2) NOT NULL,
  `storageid` int(1) NOT NULL,
  `storagename` varchar(20) NOT NULL,
  `roleid` int(1) NOT NULL,
  `p1count` int(4) NOT NULL,
  `p2count` int(4) NOT NULL,
  `p3count` int(4) NOT NULL,
  `rentprice` int(4) NOT NULL,
  `buyprice` int(8) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `roleid` (`roleid`),
  CONSTRAINT `storageinfo_ibfk_3` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_bill
-- ----------------------------
DROP TABLE IF EXISTS `t_bill`;
CREATE TABLE `t_bill` (
  `billid` int(11) NOT NULL AUTO_INCREMENT,
  `bfrom` int(11) NOT NULL,
  `bto` int(11) DEFAULT NULL,
  `countp1` int(11) NOT NULL,
  `countp2` int(11) NOT NULL,
  `countp3` int(11) NOT NULL,
  `iscomplete` int(11) NOT NULL,
  `p1lack` int(11) NOT NULL,
  `p1price` int(11) NOT NULL,
  `p2lack` int(11) NOT NULL,
  `p2price` int(11) NOT NULL,
  `p3lack` int(11) NOT NULL,
  `p3price` int(11) NOT NULL,
  `receivetime` int(11) NOT NULL,
  `currentime` int(11) NOT NULL,
  PRIMARY KEY (`billid`),
  KEY `FKCB5B04F2D7CBEC0D` (`currentime`),
  CONSTRAINT `FKCB5B04F2D7CBEC0D` FOREIGN KEY (`currentime`) REFERENCES `currentime` (`currentime`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `countp1` int(11) NOT NULL,
  `countp2` int(11) NOT NULL,
  `countp3` int(11) NOT NULL,
  `iscomplete` int(11) NOT NULL,
  `ofrom` int(11) NOT NULL,
  `oto` int(11) NOT NULL,
  `p1price` int(11) NOT NULL,
  `p2price` int(11) NOT NULL,
  `p3price` int(11) NOT NULL,
  `currentime` int(11) NOT NULL,
  PRIMARY KEY (`orderid`),
  UNIQUE KEY `orderid` (`orderid`),
  KEY `FKA0C0C3C3D7CBEC0D` (`currentime`),
  CONSTRAINT `FKA0C0C3C3D7CBEC0D` FOREIGN KEY (`currentime`) REFERENCES `currentime` (`currentime`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `iscomplete` int(11) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  `realname` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `userid` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `area` VALUES ('1', '华中区');
INSERT INTO `area` VALUES ('2', '东北区');
INSERT INTO `area` VALUES ('3', '西北区');
INSERT INTO `area` VALUES ('4', '东南区');
INSERT INTO `area` VALUES ('5', '西南区');
INSERT INTO `consume` VALUES ('1', '3', '5', '3', '1', '3');
INSERT INTO `consume` VALUES ('2', '2', '8', '8', '2', '3');
INSERT INTO `consume` VALUES ('3', '2', '9', '2', '3', '3');
INSERT INTO `consume` VALUES ('5', '2', '9', '8', '4', '3');
INSERT INTO `consume` VALUES ('6', '2', '3', '7', '5', '3');
INSERT INTO `consume` VALUES ('7', '3', '6', '6', '7', '3');
INSERT INTO `consume` VALUES ('8', '2', '12', '2', '8', '3');
INSERT INTO `consume` VALUES ('9', '3', '11', '5', '9', '3');
INSERT INTO `consume` VALUES ('10', '2', '11', '5', '10', '3');
INSERT INTO `consume` VALUES ('11', '2', '8', '4', '11', '3');
INSERT INTO `currentime` VALUES ('1');
INSERT INTO `currentime` VALUES ('2');
INSERT INTO `currentime` VALUES ('3');
INSERT INTO `currentime` VALUES ('4');
INSERT INTO `currentime` VALUES ('5');
INSERT INTO `currentime` VALUES ('6');
INSERT INTO `currentime` VALUES ('7');
INSERT INTO `currentime` VALUES ('8');
INSERT INTO `currentime` VALUES ('9');
INSERT INTO `currentime` VALUES ('10');
INSERT INTO `currentime` VALUES ('11');
INSERT INTO `demand` VALUES ('1', '1', '1', '2', '10', '6', '4', null);
INSERT INTO `demand` VALUES ('2', '2', '2', '2', '2', '11', '9', null);
INSERT INTO `demand` VALUES ('3', '2', '3', '2', '2', '11', '9', null);
INSERT INTO `demand` VALUES ('4', '2', '1', '2', '3', '12', '9', null);
INSERT INTO `demand` VALUES ('5', '2', '2', '2', '3', '12', '9', null);
INSERT INTO `demand` VALUES ('6', '2', '3', '2', '3', '12', '9', null);
INSERT INTO `demand` VALUES ('7', '2', '1', '2', '4', '13', '9', null);
INSERT INTO `demand` VALUES ('8', '2', '2', '2', '4', '13', '9', null);
INSERT INTO `demand` VALUES ('9', '2', '3', '2', '4', '13', '9', null);
INSERT INTO `demand` VALUES ('10', '2', '1', '2', '5', '14', '9', null);
INSERT INTO `demand` VALUES ('11', '2', '2', '2', '5', '14', '9', null);
INSERT INTO `demand` VALUES ('12', '2', '3', '2', '5', '14', '9', null);
INSERT INTO `demand` VALUES ('13', '2', '1', '2', '6', '15', '9', null);
INSERT INTO `demand` VALUES ('14', '2', '2', '2', '6', '15', '9', null);
INSERT INTO `demand` VALUES ('15', '2', '3', '2', '6', '15', '9', null);
INSERT INTO `demand` VALUES ('16', '2', '1', '2', '7', '16', '9', null);
INSERT INTO `demand` VALUES ('17', '2', '2', '2', '7', '16', '9', null);
INSERT INTO `demand` VALUES ('18', '2', '3', '2', '7', '16', '9', null);
INSERT INTO `demand` VALUES ('19', '2', '1', '2', '8', '17', '9', null);
INSERT INTO `demand` VALUES ('20', '2', '2', '2', '8', '17', '9', null);
INSERT INTO `demand` VALUES ('21', '2', '3', '2', '8', '17', '9', null);
INSERT INTO `demand` VALUES ('22', '2', '1', '2', '9', '18', '9', null);
INSERT INTO `demand` VALUES ('23', '2', '2', '2', '9', '18', '9', null);
INSERT INTO `demand` VALUES ('24', '2', '3', '2', '9', '18', '9', null);
INSERT INTO `demand` VALUES ('25', '2', '1', '2', '10', '19', '9', null);
INSERT INTO `demand` VALUES ('26', '2', '2', '2', '10', '19', '9', null);
INSERT INTO `demand` VALUES ('27', '2', '3', '2', '10', '19', '9', null);
INSERT INTO `demand` VALUES ('28', '2', '1', '2', '11', '20', '9', null);
INSERT INTO `demand` VALUES ('29', '2', '2', '2', '11', '20', '9', null);
INSERT INTO `demand` VALUES ('30', '2', '3', '2', '11', '20', '9', null);
INSERT INTO `fund` VALUES ('1', '0', '2840', '0', '0', '0', '1', '1');
INSERT INTO `fund` VALUES ('2', '2000', '3829', '10', '5', '2000', '1', '2');
INSERT INTO `fund` VALUES ('3', '0', '927', '0', '0', '0', '1', '3');
INSERT INTO `fund` VALUES ('4', '0', '2290', '0', '-1', '0', '2', '1');
INSERT INTO `fund` VALUES ('5', '0', '3616', '10', '4', '2000', '2', '2');
INSERT INTO `fund` VALUES ('6', '0', '841', '0', '-1', '0', '2', '3');
INSERT INTO `fund` VALUES ('7', '100', '1987', '0.5', '5', '100', '3', '1');
INSERT INTO `fund` VALUES ('8', '300', '3811', '11.5', '5', '2300', '3', '2');
INSERT INTO `fund` VALUES ('9', '1500', '9816', '7.5', '5', '1500', '3', '3');
INSERT INTO `fund` VALUES ('10', '0', '1806', '0.5', '4', '100', '4', '1');
INSERT INTO `fund` VALUES ('11', '0', '3700', '11.5', '4', '2300', '4', '2');
INSERT INTO `fund` VALUES ('12', '1200', '10942', '13.5', '5', '2700', '4', '3');
INSERT INTO `fund` VALUES ('13', '0', '993', '0.5', '3', '100', '5', '1');
INSERT INTO `fund` VALUES ('14', '0', '3471', '11.5', '3', '2300', '5', '2');
INSERT INTO `fund` VALUES ('15', '0', '10797', '13.5', '4', '2700', '5', '3');
INSERT INTO `fund` VALUES ('16', '0', '1016', '0.5', '2', '100', '6', '1');
INSERT INTO `fund` VALUES ('17', '2000', '2458', '21.5', '20', '4300', '6', '2');
INSERT INTO `fund` VALUES ('18', '0', '10633', '13.5', '3', '2700', '6', '3');
INSERT INTO `fund` VALUES ('19', '9000', '27804', '45.5', '5', '9100', '7', '1');
INSERT INTO `fund` VALUES ('20', '0', '1357', '21.5', '19', '4300', '7', '2');
INSERT INTO `fund` VALUES ('21', '0', '5487', '13.5', '2', '2700', '7', '3');
INSERT INTO `fund` VALUES ('22', '0', '22405', '45.5', '4', '9100', '8', '1');
INSERT INTO `fund` VALUES ('23', '0', '856', '21.5', '18', '4300', '8', '2');
INSERT INTO `fund` VALUES ('24', '0', '5270', '13.5', '1', '2700', '8', '3');
INSERT INTO `fund` VALUES ('25', '200', '14788', '46.5', '5', '9300', '9', '1');
INSERT INTO `fund` VALUES ('26', '0', '62', '21.5', '17', '4300', '9', '2');
INSERT INTO `fund` VALUES ('27', '200', '5183', '14.5', '5', '2900', '9', '3');
INSERT INTO `fund` VALUES ('28', '0', '5157', '46.5', '4', '9300', '10', '1');
INSERT INTO `fund` VALUES ('29', '1700', '1178', '30', '5', '6000', '10', '2');
INSERT INTO `fund` VALUES ('30', '100', '5032', '15', '5', '3000', '10', '3');
INSERT INTO `fund` VALUES ('31', '0', '3157', '46.5', '3', '9300', '11', '1');
INSERT INTO `fund` VALUES ('32', '0', '783', '30', '4', '6000', '11', '2');
INSERT INTO `fund` VALUES ('33', '0', '4781', '15', '4', '3000', '11', '3');
INSERT INTO `groupinfo` VALUES ('1', '1', '1', '1', '1');
INSERT INTO `growline` VALUES ('1', '1', '1', '1', '0', '0', '0', '0', '1', '1');
INSERT INTO `growline` VALUES ('2', '1', '1', '1', '0', '0', '0', '0', '2', '1');
INSERT INTO `growline` VALUES ('3', '2', '2', '2', '0', '0', '0', '0', '3', '1');
INSERT INTO `growline` VALUES ('4', '2', '2', '2', '0', '0', '0', '1', '4', '1');
INSERT INTO `growline` VALUES ('5', '4', '3', '2', '0', '1', '0', '1', '5', '1');
INSERT INTO `growline` VALUES ('6', '4', '3', '2', '0', '1', '0', '1', '6', '1');
INSERT INTO `growline` VALUES ('7', '6', '4', '2', '0', '1', '0', '2', '7', '1');
INSERT INTO `growline` VALUES ('8', '6', '4', '2', '0', '1', '0', '2', '8', '1');
INSERT INTO `growline` VALUES ('9', '6', '4', '2', '0', '1', '0', '2', '9', '1');
INSERT INTO `growline` VALUES ('10', '6', '4', '2', '0', '1', '0', '2', '10', '1');
INSERT INTO `growline` VALUES ('11', '6', '4', '2', '0', '1', '0', '2', '11', '1');
INSERT INTO `growlineinfo` VALUES ('1', 'P1生产线', '100', '200', '30', '40', '50', '150');
INSERT INTO `growlineinfo` VALUES ('2', 'p2生产线', '200', '300', '40', '50', '60', '250');
INSERT INTO `growlineinfo` VALUES ('3', 'P3生产线', '300', '400', '50', '60', '70', '450');
INSERT INTO `icon` VALUES ('1', '', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `icon` VALUES ('2', '', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `icon` VALUES ('3', '', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `inventory` VALUES ('1', '6', '5', '9', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1');
INSERT INTO `inventory` VALUES ('2', '7', '7', '8', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '2');
INSERT INTO `inventory` VALUES ('3', '3', '3', '3', '0', '2', '0', '2', '0', '2', '0', '2', '0', '2', '0', '2', '1', '3');
INSERT INTO `inventory` VALUES ('4', '7', '6', '10', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '1', '0', '2', '1');
INSERT INTO `inventory` VALUES ('5', '4', '4', '3', '0', '3', '0', '3', '0', '3', '0', '3', '0', '5', '0', '5', '2', '2');
INSERT INTO `inventory` VALUES ('6', '3', '3', '3', '0', '1', '0', '3', '0', '1', '0', '3', '0', '1', '0', '3', '2', '3');
INSERT INTO `inventory` VALUES ('7', '14', '13', '17', '9', '2', '9', '2', '9', '2', '9', '2', '9', '2', '9', '2', '3', '1');
INSERT INTO `inventory` VALUES ('8', '3', '3', '2', '0', '1', '0', '4', '0', '1', '0', '4', '0', '1', '0', '6', '3', '2');
INSERT INTO `inventory` VALUES ('9', '3', '3', '3', '0', '1', '0', '4', '0', '1', '0', '4', '0', '1', '0', '4', '3', '3');
INSERT INTO `inventory` VALUES ('10', '11', '10', '14', '2', '3', '4', '7', '2', '3', '4', '7', '2', '3', '4', '7', '4', '1');
INSERT INTO `inventory` VALUES ('11', '3', '3', '2', '0', '0', '0', '4', '0', '0', '0', '4', '0', '0', '0', '6', '4', '2');
INSERT INTO `inventory` VALUES ('12', '3', '3', '3', '0', '2', '0', '2', '0', '2', '0', '7', '0', '2', '0', '7', '4', '3');
INSERT INTO `inventory` VALUES ('13', '11', '10', '14', '0', '0', '4', '7', '0', '0', '4', '7', '0', '0', '4', '7', '5', '1');
INSERT INTO `inventory` VALUES ('14', '4', '4', '3', '2', '1', '6', '5', '2', '1', '6', '5', '2', '1', '8', '7', '5', '2');
INSERT INTO `inventory` VALUES ('15', '6', '6', '8', '3', '2', '5', '2', '3', '2', '10', '11', '5', '2', '12', '11', '5', '3');
INSERT INTO `inventory` VALUES ('16', '6', '5', '9', '1', '3', '8', '13', '1', '3', '8', '13', '1', '3', '8', '13', '6', '1');
INSERT INTO `inventory` VALUES ('17', '3', '3', '2', '2', '3', '7', '8', '2', '3', '7', '8', '2', '3', '9', '10', '6', '2');
INSERT INTO `inventory` VALUES ('18', '6', '6', '8', '0', '0', '5', '2', '0', '0', '10', '11', '0', '0', '12', '11', '6', '3');
INSERT INTO `inventory` VALUES ('19', '391', '390', '394', '200', '6', '200', '15', '200', '6', '213', '28', '200', '6', '213', '28', '7', '1');
INSERT INTO `inventory` VALUES ('20', '3', '3', '2', '0', '0', '7', '8', '0', '0', '7', '8', '0', '0', '9', '10', '7', '2');
INSERT INTO `inventory` VALUES ('21', '6', '6', '8', '0', '3', '5', '8', '0', '3', '10', '17', '0', '3', '12', '17', '7', '3');
INSERT INTO `inventory` VALUES ('22', '590', '489', '493', '200', '1', '215', '16', '100', '1', '128', '29', '100', '1', '128', '29', '8', '1');
INSERT INTO `inventory` VALUES ('23', '3', '3', '2', '0', '0', '7', '8', '0', '0', '7', '8', '0', '0', '9', '10', '8', '2');
INSERT INTO `inventory` VALUES ('24', '7', '7', '9', '1', '2', '9', '10', '1', '2', '18', '19', '1', '2', '18', '19', '8', '3');
INSERT INTO `inventory` VALUES ('25', '790', '689', '693', '200', '0', '216', '16', '200', '0', '229', '29', '200', '0', '229', '29', '9', '1');
INSERT INTO `inventory` VALUES ('26', '10', '10', '9', '9', '2', '17', '10', '9', '2', '17', '10', '9', '2', '19', '12', '9', '2');
INSERT INTO `inventory` VALUES ('27', '10', '10', '12', '3', '2', '13', '12', '3', '2', '22', '21', '3', '2', '22', '21', '9', '3');
INSERT INTO `inventory` VALUES ('28', '988', '887', '891', '200', '2', '216', '18', '200', '2', '229', '31', '200', '2', '229', '31', '10', '1');
INSERT INTO `inventory` VALUES ('29', '9', '9', '8', '1', '2', '11', '12', '1', '2', '11', '12', '1', '2', '13', '14', '10', '2');
INSERT INTO `inventory` VALUES ('30', '10', '10', '12', '0', '2', '13', '14', '0', '2', '22', '23', '0', '2', '22', '23', '10', '3');
INSERT INTO `inventory` VALUES ('31', '1188', '1087', '1091', '200', '0', '218', '18', '200', '0', '231', '31', '200', '0', '231', '31', '11', '1');
INSERT INTO `inventory` VALUES ('32', '6', '6', '5', '0', '3', '11', '15', '0', '3', '11', '15', '0', '3', '13', '17', '11', '2');
INSERT INTO `inventory` VALUES ('33', '10', '10', '12', '0', '2', '13', '16', '0', '2', '22', '25', '0', '2', '22', '25', '11', '3');
INSERT INTO `manager` VALUES ('1', '1');
INSERT INTO `manager` VALUES ('admin', '1');
INSERT INTO `product` VALUES ('1', '1', '1', 'MACBOOK', '6', null, '6', '2');
INSERT INTO `product` VALUES ('2', '1', '2', 'MACBOOK', null, null, '3', '3');
INSERT INTO `product` VALUES ('3', '1', '3', 'MACBOOK', null, '4', '4', '4');
INSERT INTO `product` VALUES ('4', '2', '1', 'IPHONE', '3', null, '3', '2');
INSERT INTO `product` VALUES ('5', '2', '2', 'IPHONE', null, null, '8', '3');
INSERT INTO `product` VALUES ('6', '2', '3', 'IPHONE', null, '3', '3', '4');
INSERT INTO `product` VALUES ('7', '3', '1', 'IPAD', '1', null, '1', '2');
INSERT INTO `product` VALUES ('8', '3', '2', 'IPAD', null, null, '3', '3');
INSERT INTO `product` VALUES ('9', '3', '3', 'IPAD', null, '6', '6', '4');
INSERT INTO `relation` VALUES ('1', '1', '1', '1');
INSERT INTO `relation` VALUES ('2', '1', '1', '2');
INSERT INTO `relation` VALUES ('3', '2', '1', '3');
INSERT INTO `report` VALUES ('1', '927', '-73', '0', '0', '0', '6000', '39', '0', '0', '0', '26', '60', '5000', '0', '0', '1', '3', null);
INSERT INTO `report` VALUES ('2', '2840', '-150', '0', '0', '900', '13900', '60', '10', '0', '0', '10', '100', '10000', '0', '0', '1', '1', null);
INSERT INTO `report` VALUES ('3', '3829', '-171', '0', '10', '0', '7000', '101', '0', '0', '0', '0', '60', '5000', '0', '2000', '1', '2', null);
INSERT INTO `report` VALUES ('4', '2290', '-180', '0', '0', '900', '13900', '70', '100', '-150', '0', '90', '200', '20000', '0', '0', '2', '1', null);
INSERT INTO `report` VALUES ('5', '3616', '-90', '0', '10', '0', '7000', '53', '0', '-171', '0', '33', '60', '5000', '0', '2000', '2', '2', null);
INSERT INTO `report` VALUES ('6', '841', '-86', '0', '0', '0', '6000', '39', '33', '-73', '0', '13', '60', '5000', '0', '0', '2', '3', null);
INSERT INTO `report` VALUES ('7', '9816', '-93', '0', '7', '0', '6000', '39', '33', '-86', '0', '13', '60', '5000', '0', '1500', '3', '3', null);
INSERT INTO `report` VALUES ('8', '3811', '-104', '0', '11', '0', '7000', '39', '0', '-90', '0', '6', '60', '5000', '0', '2300', '3', '2', null);
INSERT INTO `report` VALUES ('9', '1987', '-320', '0', '0', '1800', '13900', '140', '120', '-180', '0', '20', '200', '20000', '0', '100', '3', '1', null);
INSERT INTO `report` VALUES ('10', '10942', '-86', '0', '13', '0', '6000', '39', '39', '-93', '0', '26', '60', '5000', '0', '2700', '4', '3', null);
INSERT INTO `report` VALUES ('11', '1806', '-290', '0', '0', '1800', '13900', '110', '140', '-320', '0', '20', '200', '20000', '0', '100', '4', '1', null);
INSERT INTO `report` VALUES ('12', '3700', '-110', '0', '11', '0', '7000', '39', '78', '-104', '0', '0', '60', '5000', '0', '2300', '4', '2', null);
INSERT INTO `report` VALUES ('13', '10797', '-137', '0', '13', '0', '6000', '90', '39', '-86', '0', '26', '60', '5000', '0', '2700', '5', '3', null);
INSERT INTO `report` VALUES ('14', '993', '-140', '0', '0', '2500', '4000', '110', '150', '-110', '0', '10', '40', '400', '0', '100', '5', '1', null);
INSERT INTO `report` VALUES ('15', '3471', '-118', '0', '11', '0', '7000', '53', '78', '-110', '0', '6', '60', '5000', '0', '2300', '5', '2', null);
INSERT INTO `report` VALUES ('16', '2458', '-430', '36', '21', '0', '2500', '39', '-138', '-118', '0', '36', '370', '3100', '0', '4300', '6', '2', null);
INSERT INTO `report` VALUES ('17', '1016', '1600', '0', '0', '2500', '4000', '60', '2150', '-140', '0', '2000', '40', '400', '300', '100', '6', '1', null);
INSERT INTO `report` VALUES ('18', '10633', '-163', '0', '13', '0', '6000', '90', '81', '-163', '0', '0', '60', '5000', '0', '2700', '6', '3', null);
INSERT INTO `report` VALUES ('19', '5487', '-184', '0', '13', '0', '6000', '90', '81', '-163', '0', '39', '120', '10000', '0', '2700', '7', '3', null);
INSERT INTO `report` VALUES ('20', '27804', '-2445', '0', '45', '3200', '4000', '3910', '3750', '1600', '0', '1600', '90', '900', '0', '9100', '7', '1', null);
INSERT INTO `report` VALUES ('21', '5270', '-210', '0', '13', '0', '6000', '103', '81', '-184', '0', '26', '120', '10000', '0', '2700', '8', '3', null);
INSERT INTO `report` VALUES ('22', '856', '-518', '18', '21', '0', '2500', '39', '393', '-518', '0', '0', '440', '3700', '0', '4300', '8', '2', null);
INSERT INTO `report` VALUES ('23', '22405', '-3659', '4', '45', '3200', '4000', '5500', '5718', '-2445', '0', '2000', '110', '1100', '0', '9100', '8', '1', null);
INSERT INTO `report` VALUES ('24', '5183', '-250', '0', '14', '0', '6000', '142', '81', '-210', '0', '26', '120', '10000', '0', '2900', '9', '3', null);
INSERT INTO `report` VALUES ('25', '62', '-620', '34', '21', '0', '2500', '137', '234', '-518', '0', '12', '440', '3700', '0', '4300', '9', '2', null);
INSERT INTO `report` VALUES ('26', '14788', '-5671', '0', '46', '3200', '4000', '7500', '7750', '-3659', '0', '2000', '125', '1250', '0', '9300', '9', '1', null);
INSERT INTO `report` VALUES ('27', '5157', '-7659', '8', '46', '3200', '4000', '9480', '9670', '-5671', '0', '2000', '125', '1250', '0', '9300', '10', '1', null);
INSERT INTO `report` VALUES ('28', '5032', '-239', '-12', '15', '0', '6000', '142', '213', '-250', '0', '26', '120', '10000', '0', '3000', '10', '3', null);
INSERT INTO `report` VALUES ('29', '1178', '-619', '38', '30', '0', '2500', '123', '178', '-620', '0', '12', '440', '3700', '0', '6000', '10', '2', null);
INSERT INTO `report` VALUES ('30', '783', '-605', '210', '30', '0', '2500', '81', '-1752', '-619', '0', '156', '440', '3700', '0', '6000', '11', '2', null);
INSERT INTO `report` VALUES ('31', '4781', '-251', '0', '15', '0', '6000', '142', '261', '-239', '0', '26', '120', '10000', '0', '3000', '11', '3', null);
INSERT INTO `role` VALUES ('1', '生产商', '6', '5', '9', '3000', '100000', '0.005', '1', '0', '0', '1', '1', '1');
INSERT INTO `role` VALUES ('2', '代理商', '7', '7', '8', '2000', '6000', '0.005', '1', '0', '0', '0', '0', '0');
INSERT INTO `role` VALUES ('3', '零售商', '3', '3', '3', '1000', '3000', '0.005', '1', '0', '0', '0', '0', '0');
INSERT INTO `storage` VALUES ('1', '1', '0', '0', '0', '0', '0', '1', '1');
INSERT INTO `storage` VALUES ('2', '1', '0', '0', '0', '0', '0', '1', '2');
INSERT INTO `storage` VALUES ('3', '1', '0', '0', '0', '0', '0', '1', '3');
INSERT INTO `storage` VALUES ('4', '2', '0', '0', '2', '1', '0', '2', '1');
INSERT INTO `storage` VALUES ('5', '1', '0', '0', '0', '0', '0', '2', '2');
INSERT INTO `storage` VALUES ('6', '1', '0', '0', '0', '0', '0', '2', '3');
INSERT INTO `storage` VALUES ('7', '2', '0', '0', '3', '2', '1', '3', '1');
INSERT INTO `storage` VALUES ('8', '1', '0', '0', '0', '0', '0', '3', '2');
INSERT INTO `storage` VALUES ('9', '1', '0', '0', '0', '0', '0', '3', '3');
INSERT INTO `storage` VALUES ('10', '2', '0', '0', '3', '2', '1', '4', '1');
INSERT INTO `storage` VALUES ('11', '1', '0', '0', '0', '0', '0', '4', '2');
INSERT INTO `storage` VALUES ('12', '1', '0', '0', '0', '0', '0', '4', '3');
INSERT INTO `storage` VALUES ('13', '2', '0', '1', '3', '2', '2', '5', '1');
INSERT INTO `storage` VALUES ('14', '1', '0', '0', '0', '0', '0', '5', '2');
INSERT INTO `storage` VALUES ('15', '1', '0', '0', '0', '0', '0', '5', '3');
INSERT INTO `storage` VALUES ('16', '2', '0', '1', '3', '2', '2', '6', '1');
INSERT INTO `storage` VALUES ('17', '5', '1', '0', '0', '0', '0', '6', '2');
INSERT INTO `storage` VALUES ('18', '1', '0', '0', '0', '0', '0', '6', '3');
INSERT INTO `storage` VALUES ('19', '3', '0', '3', '3', '2', '2', '7', '1');
INSERT INTO `storage` VALUES ('20', '5', '2', '0', '0', '0', '0', '7', '2');
INSERT INTO `storage` VALUES ('21', '2', '0', '0', '0', '1', '0', '7', '3');
INSERT INTO `storage` VALUES ('22', '3', '0', '4', '3', '2', '2', '8', '1');
INSERT INTO `storage` VALUES ('23', '5', '2', '0', '0', '0', '0', '8', '2');
INSERT INTO `storage` VALUES ('24', '2', '0', '0', '0', '1', '0', '8', '3');
INSERT INTO `storage` VALUES ('25', '3', '1', '4', '3', '2', '2', '9', '1');
INSERT INTO `storage` VALUES ('26', '5', '2', '0', '0', '0', '0', '9', '2');
INSERT INTO `storage` VALUES ('27', '2', '0', '0', '0', '1', '1', '9', '3');
INSERT INTO `storage` VALUES ('28', '3', '1', '4', '3', '2', '2', '10', '1');
INSERT INTO `storage` VALUES ('29', '5', '2', '0', '0', '0', '0', '10', '2');
INSERT INTO `storage` VALUES ('30', '2', '0', '0', '0', '1', '1', '10', '3');
INSERT INTO `storage` VALUES ('31', '3', '1', '4', '4', '3', '3', '11', '1');
INSERT INTO `storage` VALUES ('32', '5', '2', '0', '0', '0', '0', '11', '2');
INSERT INTO `storage` VALUES ('33', '2', '0', '0', '0', '1', '1', '11', '3');
INSERT INTO `storageinfo` VALUES ('1', '1', '小厂房', '1', '500', '700', '500', '10', '100');
INSERT INTO `storageinfo` VALUES ('2', '2', '中厂房', '1', '5', '6', '7', '15', '150');
INSERT INTO `storageinfo` VALUES ('3', '3', '大厂房', '1', '6', '7', '8', '20', '200');
INSERT INTO `storageinfo` VALUES ('4', '1', '小仓库', '2', '30', '40', '50', '60', '500');
INSERT INTO `storageinfo` VALUES ('5', '2', '中仓库', '2', '40', '50', '60', '70', '600');
INSERT INTO `storageinfo` VALUES ('6', '3', '大仓库', '2', '50', '60', '70', '80', '700');
INSERT INTO `storageinfo` VALUES ('7', '1', '小仓库', '3', '30', '40', '50', '60', '5000');
INSERT INTO `storageinfo` VALUES ('8', '2', '中仓库', '3', '40', '50', '60', '70', '6000');
INSERT INTO `storageinfo` VALUES ('9', '3', '大仓库', '3', '50', '60', '70', '80', '7000');
INSERT INTO `t_bill` VALUES ('1', '3', null, '2', '2', '2', '1', '1', '4', '3', '3', '1', '6', '0', '1');
INSERT INTO `t_bill` VALUES ('2', '1', '1', '1', '1', '1', '1', '0', '6', '0', '3', '0', '1', '2', '1');
INSERT INTO `t_bill` VALUES ('4', '1', '1', '9', '9', '9', '1', '0', '6', '0', '3', '0', '1', '3', '2');
INSERT INTO `t_bill` VALUES ('5', '2', '3', '3', '3', '5', '1', '0', '3', '0', '3', '-2', '3', '4', '2');
INSERT INTO `t_bill` VALUES ('6', '3', null, '1', '1', '1', '1', '1', '4', '7', '3', '7', '6', '0', '2');
INSERT INTO `t_bill` VALUES ('7', '3', null, '1', '1', '1', '1', '1', '4', '8', '3', '1', '6', '0', '3');
INSERT INTO `t_bill` VALUES ('8', '2', '3', '1', '1', '1', '1', '1', '2', '1', '2', '1', '2', '4', '3');
INSERT INTO `t_bill` VALUES ('9', '1', '1', '2', '2', '2', '1', '0', '6', '0', '3', '0', '1', '4', '3');
INSERT INTO `t_bill` VALUES ('10', '1', '2', '2', '2', '2', '1', '1', '3', '1', '3', '1', '3', '3', '3');
INSERT INTO `t_bill` VALUES ('11', '1', '1', '2', '2', '2', '1', '0', '6', '0', '3', '0', '1', '5', '4');
INSERT INTO `t_bill` VALUES ('12', '1', '2', '2', '2', '2', '1', '2', '4', '2', '4', '2', '4', '3', '4');
INSERT INTO `t_bill` VALUES ('14', '3', null, '2', '2', '2', '1', '0', '4', '7', '3', '6', '6', '0', '4');
INSERT INTO `t_bill` VALUES ('15', '1', '2', '3', '3', '3', '1', '1', '4', '1', '4', '1', '4', '3', '4');
INSERT INTO `t_bill` VALUES ('19', '1', '1', '1', '1', '1', '1', '0', '6', '0', '3', '0', '1', '6', '5');
INSERT INTO `t_bill` VALUES ('20', '2', '3', '1', '1', '1', '0', '1', '2', '1', '2', '1', '2', '4', '5');
INSERT INTO `t_bill` VALUES ('22', '2', '3', '3', '3', '3', '1', '1', '4', '1', '4', '1', '4', '4', '6');
INSERT INTO `t_bill` VALUES ('23', '1', '1', '200', '200', '200', '1', '0', '6', '0', '3', '0', '1', '7', '6');
INSERT INTO `t_bill` VALUES ('24', '1', '2', '3', '3', '3', '1', '0', '3', '0', '3', '0', '3', '3', '6');
INSERT INTO `t_bill` VALUES ('25', '1', '2', '3', '3', '3', '1', '0', '3', '0', '3', '0', '3', '3', '6');
INSERT INTO `t_bill` VALUES ('27', '3', null, '3', '3', '3', '1', '0', '4', '3', '3', '3', '6', '0', '7');
INSERT INTO `t_bill` VALUES ('29', '1', '1', '200', '100', '100', '1', '0', '6', '0', '3', '0', '1', '8', '7');
INSERT INTO `t_bill` VALUES ('30', '1', '2', '9', '9', '9', '1', '0', '9', '0', '9', '0', '9', '3', '7');
INSERT INTO `t_bill` VALUES ('31', '1', '2', '6', '6', '6', '1', '3', '9', '3', '9', '3', '9', '3', '7');
INSERT INTO `t_bill` VALUES ('32', '3', null, '2', '2', '2', '1', '0', '4', '10', '3', '0', '6', '0', '8');
INSERT INTO `t_bill` VALUES ('33', '1', '1', '200', '200', '200', '1', '0', '6', '0', '3', '0', '1', '9', '8');
INSERT INTO `t_bill` VALUES ('34', '1', '2', '1', '1', '1', '0', '0', '1', '0', '1', '0', '1', '3', '8');
INSERT INTO `t_bill` VALUES ('35', '3', null, '2', '2', '2', '1', '1', '4', '9', '3', '3', '6', '0', '9');
INSERT INTO `t_bill` VALUES ('36', '2', '3', '2', '2', '2', '-1', '0', '2', '0', '2', '0', '2', '4', '9');
INSERT INTO `t_bill` VALUES ('37', '1', '1', '200', '200', '200', '0', '0', '6', '0', '3', '0', '1', '10', '9');
INSERT INTO `t_bill` VALUES ('38', '1', '1', '200', '200', '200', '0', '0', '6', '0', '3', '0', '1', '11', '10');
INSERT INTO `t_bill` VALUES ('39', '1', '2', '2', '2', '2', '-1', '1', '3', '1', '3', '1', '3', '3', '10');
INSERT INTO `t_bill` VALUES ('40', '3', null, '2', '2', '2', '1', '0', '4', '9', '3', '3', '6', '0', '10');
INSERT INTO `t_bill` VALUES ('41', '2', '3', '2', '2', '2', '-1', '0', '2', '0', '2', '0', '2', '4', '10');
INSERT INTO `t_bill` VALUES ('42', '2', '3', '3', '3', '3', '-1', '1', '4', '1', '44', '1', '4', '4', '11');
INSERT INTO `t_bill` VALUES ('43', '3', null, '2', '2', '2', '1', '0', '4', '6', '3', '2', '6', '0', '11');
INSERT INTO `t_order` VALUES ('1', '3', '3', '3', '1', '3', '2', '3', '3', '3', '1');
INSERT INTO `t_order` VALUES ('2', '3', '3', '3', '1', '2', '1', '3', '3', '3', '2');
INSERT INTO `t_order` VALUES ('3', '2', '2', '2', '1', '3', '2', '2', '2', '2', '2');
INSERT INTO `t_order` VALUES ('4', '2', '2', '2', '0', '3', '2', '2', '2', '2', '3');
INSERT INTO `t_order` VALUES ('5', '4', '4', '4', '1', '2', '1', '4', '4', '4', '3');
INSERT INTO `t_order` VALUES ('7', '2', '2', '2', '1', '3', '2', '2', '2', '2', '4');
INSERT INTO `t_order` VALUES ('9', '4', '4', '4', '1', '3', '2', '4', '4', '4', '5');
INSERT INTO `t_order` VALUES ('10', '3', '3', '3', '1', '2', '1', '3', '3', '3', '5');
INSERT INTO `t_order` VALUES ('12', '9', '9', '9', '1', '2', '1', '9', '9', '9', '6');
INSERT INTO `t_order` VALUES ('14', '3', '3', '3', '0', '3', '2', '3', '3', '3', '7');
INSERT INTO `t_order` VALUES ('15', '1', '1', '1', '1', '2', '1', '1', '1', '1', '7');
INSERT INTO `t_order` VALUES ('16', '2', '2', '2', '1', '3', '2', '2', '2', '2', '8');
INSERT INTO `t_order` VALUES ('17', '2', '2', '2', '1', '3', '2', '2', '2', '2', '9');
INSERT INTO `t_order` VALUES ('18', '3', '3', '3', '1', '2', '1', '3', '3', '3', '9');
INSERT INTO `t_order` VALUES ('19', '4', '4', '4', '1', '3', '2', '4', '44', '4', '10');
INSERT INTO `t_order` VALUES ('20', '4', '4', '4', '0', '2', '1', '44', '4', '4', '10');
INSERT INTO `t_order` VALUES ('21', '4', '4', '4', '0', '2', '1', '4', '4', '4', '11');
INSERT INTO `t_order` VALUES ('22', '4', '4', '4', '0', '3', '2', '4', '44', '4', '11');
INSERT INTO `user` VALUES ('1', '-1', '1', '1', '1');
INSERT INTO `user` VALUES ('2', '1', '2', '2', '2');
INSERT INTO `user` VALUES ('3', '1', '3', '3', '3');
