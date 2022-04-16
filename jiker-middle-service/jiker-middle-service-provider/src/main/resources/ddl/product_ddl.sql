USE `dubbo_middle`;

DROP TABLE IF EXISTS `PRODUCT`;
CREATE TABLE `PRODUCT`(
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `VENDOR_ID` bigint(20) NOT NULL ,
  `PRODUCT_CODE` varchar(100) NOT NULL ,
  `PRODUCT_NAME` varchar(100) NOT NULL ,
  `DESCRIPTION` varchar(100),
  `PRICE` double NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `product` VALUES ('1', '1', 'product_code1', 'product_name1', 'description1', '100');
INSERT INTO `product` VALUES ('2', '1', 'product_code2', 'product_name2', 'description2', '200');