USE `dubbo_middle`;

DROP TABLE IF EXISTS `ACCOUNT`;
CREATE TABLE `ACCOUNT`(
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ACCOUNT_NAME` varchar(100) NOT NULL,
  `REAL_NAME` varchar(100),
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `account` VALUES ('1', 'jiker-account1', 'jiker-realname1');
INSERT INTO `account` VALUES ('2', 'jiker-account2', 'jiker-realname2');