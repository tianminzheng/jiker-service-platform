
USE `dubbo_middle`;

DROP TABLE IF EXISTS `VENDOR_SYSTEM`;
CREATE TABLE `VENDOR_SYSTEM`(
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `VENDOR_CODE` varchar(100) NOT NULL,
  `VENDOR_NAME` varchar(100) NOT NULL,
  `DESCRIPTION` varchar(100),
  `IP` varchar(100) NOT NULL,
  `PORT` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `vendor_system` VALUES ('1', '9081', 'vendor_name1', 'description1', 	'127.0.0.1', '9081');
INSERT INTO `vendor_system` VALUES ('2', '9082', 'vendor_name2', 'description2', 	'127.0.0.1', '9082');