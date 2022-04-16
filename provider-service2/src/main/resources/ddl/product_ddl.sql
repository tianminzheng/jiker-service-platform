USE `dubbo_vendor`;

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

INSERT INTO `product` VALUES ('1', '9082', 'product_code_9082_1', 'product_name_9082_1', 'description', '30');
INSERT INTO `product` VALUES ('2', '9082', 'product_code_9082_2', 'product_name_9082_2', 'description', '40');