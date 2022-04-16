
USE `dubbo_frontend`;

DROP TABLE IF EXISTS `orders`;
DROP TABLE IF EXISTS `item`;

create table `orders` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`account_id` bigint(20) NOT NULL ,
	`status` varchar(20) not null,
	PRIMARY KEY (`id`)
);

CREATE TABLE `item`(
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ORDER_ID` bigint(20) NOT NULL ,
  `PRODUCT_CODE` varchar(100) NOT NULL ,
  `PRODUCT_NAME` varchar(100) NOT NULL ,
  `DESCRIPTION` varchar(100),
  `PRODUCT_PRICE` double NOT NULL,
  `ITEM_COUNT` double NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
