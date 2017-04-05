/*
SQLyog Ultimate v8.55 
MySQL - 5.6.14 : Database - ranathisaradb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ranathisaradb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ranathisaradb`;

/*Table structure for table `author` */

DROP TABLE IF EXISTS `author`;

CREATE TABLE `author` (
  `authorId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(25) NOT NULL,
  `lastName` varchar(30) NOT NULL,
  PRIMARY KEY (`authorId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `author` */

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `isbn` varchar(20) NOT NULL,
  `quantity` int(11) NOT NULL,
  `subCategoryId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_book` (`subCategoryId`),
  CONSTRAINT `FK_book` FOREIGN KEY (`subCategoryId`) REFERENCES `subcategory` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`id`,`title`,`isbn`,`quantity`,`subCategoryId`) values (1,'Viragaya','9558415480',13,6),(2,'Gamperaliya','9550201368',9,6),(3,'Kaliyugaya','9558415448',24,6),(4,'Gahaniyak','9555640433',30,7),(5,'Miriguva','9554444444',24,6),(6,'Leela','6543333333',22,6),(7,'Sheetha','3322222222',21,6);

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `NewIndex1` (`categoryName`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`id`,`categoryName`) values (24,'English'),(23,'Sinhala');

/*Table structure for table `ebookstore_role` */

DROP TABLE IF EXISTS `ebookstore_role`;

CREATE TABLE `ebookstore_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userEmail` varchar(64) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ebookstore_role` (`userEmail`),
  CONSTRAINT `FK_ebookstore_role` FOREIGN KEY (`userEmail`) REFERENCES `ebookstore_user` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `ebookstore_role` */

insert  into `ebookstore_role`(`id`,`userEmail`,`roleId`) values (1,'suhani@gmail.com',2),(2,'amila@gmail.com',1);

/*Table structure for table `ebookstore_user` */

DROP TABLE IF EXISTS `ebookstore_user`;

CREATE TABLE `ebookstore_user` (
  `email` varchar(64) NOT NULL,
  `firstName` varchar(32) NOT NULL,
  `lastName` varchar(32) NOT NULL,
  `registeredDate` date NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ebookstore_user` */

insert  into `ebookstore_user`(`email`,`firstName`,`lastName`,`registeredDate`,`password`) values ('amila@gmail.com','Amila','abcde','2017-02-02','abc123'),('suhani@gmail.com','Suhani','Abesekara','2017-02-02','abc123');

/*Table structure for table `film` */

DROP TABLE IF EXISTS `film`;

CREATE TABLE `film` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `sellingPrice` int(11) DEFAULT NULL,
  `addedDate` date DEFAULT NULL,
  `reOrderLevel` int(11) DEFAULT NULL,
  `stockInHand` int(11) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_film` (`typeId`),
  CONSTRAINT `FK_film` FOREIGN KEY (`typeId`) REFERENCES `type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `film` */

insert  into `film`(`id`,`title`,`sellingPrice`,`addedDate`,`reOrderLevel`,`stockInHand`,`typeId`) values (1,'Ganster',500,'2017-01-20',10,75,2),(2,'Titanic',400,'2017-02-05',10,60,2),(3,'Robbin',600,'2017-04-01',5,50,1);

/*Table structure for table `movie` */

DROP TABLE IF EXISTS `movie`;

CREATE TABLE `movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `movieName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `movie` */

/*Table structure for table `profit` */

DROP TABLE IF EXISTS `profit`;

CREATE TABLE `profit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `month` varchar(20) DEFAULT NULL,
  `netprofit` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `profit` */

insert  into `profit`(`id`,`month`,`netprofit`) values (1,'January',12000),(2,'February',13000),(3,'March',10000),(4,'April',16000);

/*Table structure for table `publisher` */

DROP TABLE IF EXISTS `publisher`;

CREATE TABLE `publisher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `publisherName` varchar(40) NOT NULL,
  `address` varchar(100) NOT NULL,
  `telNo` varchar(20) NOT NULL,
  `email` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `NewIndex1` (`publisherName`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `publisher` */

insert  into `publisher`(`id`,`publisherName`,`address`,`telNo`,`email`) values (1,'Sarasa Publications','Waththala','0323345416','sarasa@gmail.com'),(2,'Malpiyali Publications','Dhankotuwa','0322223454','malpiyali@gmail.com');

/*Table structure for table `subcategory` */

DROP TABLE IF EXISTS `subcategory`;

CREATE TABLE `subcategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subCategoryName` varchar(60) NOT NULL,
  `categoryId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_subcategory` (`categoryId`),
  CONSTRAINT `FK_subcategory` FOREIGN KEY (`categoryId`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `subcategory` */

insert  into `subcategory`(`id`,`subCategoryName`,`categoryId`) values (1,'Accounting',23),(2,'Agriculture',23),(3,'Art',23),(4,'Astrology',23),(5,'Biography',23),(6,'Novel',23),(7,'Short Stories',23),(8,'Child Care',24),(9,'Commics',24),(10,'Computer',24),(11,'Education',24);

/*Table structure for table `type` */

DROP TABLE IF EXISTS `type`;

CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `type` */

insert  into `type`(`id`,`typeName`) values (1,'Action'),(2,'Romantic');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
