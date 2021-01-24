CREATE TABLE IF NOT EXISTS `t_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `memberId` varchar(30) NOT NULL,
  `userName` varchar(20) DEFAULT NULL,
  `loginName` varchar(20) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `mobilePhone` varchar(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `lastmodifytime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `t_manager` (
  `managerId` bigint(20) NOT NULL AUTO_INCREMENT,
  `manageModuleId` int(11) DEFAULT NULL,
  `loginName` varchar(20) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `mobilePhone` varchar(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `expiredTime` datetime DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `lastmodifytime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`managerId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `t_article_category` (
  `categoryId` bigint(20) NOT NULL AUTO_INCREMENT,
  `parentCategoryId` bigint(20) DEFAULT NULL,
  `categoryLevel` int(11) DEFAULT NULL,
  `categoryName` varchar(50) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `lastmodifytime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
