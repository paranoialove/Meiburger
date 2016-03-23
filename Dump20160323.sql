CREATE DATABASE  IF NOT EXISTS `meiburger` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `meiburger`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: meiburger
-- ------------------------------------------------------
-- Server version	5.7.10-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `burger_bread`
--

DROP TABLE IF EXISTS `burger_bread`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `burger_bread` (
  `breadId` int(11) NOT NULL AUTO_INCREMENT,
  `breadName` varchar(45) NOT NULL,
  `url` varchar(100) DEFAULT NULL,
  `describ` varchar(100) DEFAULT NULL,
  `status` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`breadId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `burger_bread`
--

LOCK TABLES `burger_bread` WRITE;
/*!40000 ALTER TABLE `burger_bread` DISABLE KEYS */;
INSERT INTO `burger_bread` VALUES (1,'白麵包Italian',NULL,NULL,0),(2,'全麥麵包Wheat',NULL,NULL,0),(3,'巴馬乾酪Parmensan Oregano',NULL,NULL,0),(4,'蜂蜜燕麥Honey Oat',NULL,NULL,0),(5,'家鄉麵包Hearty Italian',NULL,NULL,0);
/*!40000 ALTER TABLE `burger_bread` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `burger_flaver`
--

DROP TABLE IF EXISTS `burger_flaver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `burger_flaver` (
  `flaverId` int(11) NOT NULL AUTO_INCREMENT,
  `flaverName` varchar(45) NOT NULL DEFAULT 'flaverName',
  `flaverPrice6inch` int(11) DEFAULT NULL,
  `flaverPrice12inch` int(11) NOT NULL DEFAULT '999',
  `url` varchar(100) DEFAULT NULL,
  `describ` varchar(300) DEFAULT NULL,
  `status` int(10) NOT NULL DEFAULT '0',
  `catagory` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`flaverId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `burger_flaver`
--

LOCK TABLES `burger_flaver` WRITE;
/*!40000 ALTER TABLE `burger_flaver` DISABLE KEYS */;
INSERT INTO `burger_flaver` VALUES (1,'燒烤牛肉 / ROAST BEEF',110,180,'img/burger/flaver/RoastBeef.jpg','受歡迎的SUBWAY®經典美味-低脂、柔嫩的香烤牛肉切片配上自選新鮮蔬菜和醬料，夾入新鮮出爐的麵包裡，簡約而不簡單。',0,'牛肉'),(2,'百味俱樂部 / SUBWAY CLUB',110,180,'img/burger/flaver/SubwayClub.jpg','百味俱樂部(Subway Club) 是另一款美味潛艇堡。真正的百味融合，柔嫩的精選雞胸肉，煙燻的香烤牛肉，美味的火腿切片，現場烤製的麵包，配上自選的蔬菜和醬料，獨特的味覺挑逗，捨我其誰！',0,'牛肉'),(3,'火雞胸肉 / TURKEY BREAST',95,155,'img/burger/flaver/TurkeyBreast.jpg','何必等到感恩節？現在就來享受美味的火雞胸肉(Turkey Breast)潛艇堡吧。柔嫩火雞胸肉切片，保證低脂，風味獨特，麵包現場烤製，配上自選的新鮮蔬菜和醬料，可口的潛艇堡就此誕生!',0,'火雞'),(4,'火雞火腿 /TURKEY BREAST & HAM',95,155,'img/burger/flaver/TurkeyBreastHam.jpg','這款內容豐富的潛艇堡，入口齒頰留香，您根本沒意識自己正在享用低脂食品。在新鮮出爐的麵包裡夾入一層美味火雞火腿切片，鋪上自選的新鮮蔬菜，淋上不含脂肪的醬料。',0,'火雞'),(5,'嫩切雞肉 / SLICED CHICKEN',95,155,'img/burger/flaver/SlicedChicken.jpg','鮮嫩雞肉切片，美味低脂，搭配自選新鮮蔬菜及醬料，豐富的口感讓人難以抗拒。',0,'雞肉'),(6,'香烤雞肉 / ROASTED CHICKEN',95,155,'img/burger/flaver/RoadstedChicken.jpg','是不是想吃雞肉了？那麼，就嚐一嘗SUBWAY®的香烤雞肉吧。柔嫩無骨的雞肉烤得恰到好處，配上自選的新鮮蔬菜和獨特醬料，麵包新鮮出爐，鮮香四溢，那個味道，嘗起來是否如媽媽親手做的？',0,'雞肉'),(7,'照燒雞肉 / CHICKEN TERIYAKI',95,155,'img/burger/flaver/ChickenTeriyaki.jpg','這是一款風靡亞洲的經典美食，在柔嫩的雞肉切片上淋上少量照燒調味醬，搭配自選的新鮮蔬菜和調味品，一起裹入新鮮出爐的麵包。',0,'雞肉'),(8,'火腿 / HAM',85,145,'img/burger/flaver/Ham.jpg','配上鮮嫩多汁的片片火腿，美味難以抵擋，更何況脂肪只有少於6克。',0,NULL),(9,'素食蔬菜 / VEGGIE DELITE',65,105,'img/burger/flaver/VeggieDelite.jpg','現場烤製的麵包和各種蔬菜匯聚一堂：生菜、蕃茄，青椒、洋蔥、橄欖和酸黃瓜，配上爽口開胃的醬料，看上去像個沙拉潜艇堡，美味讓您大吃一驚!',0,'素食'),(10,'雞肉丸 / CHICKEN MEATBALL',75,125,'img/burger/flaver/ChickenMeatball.jpg','雞肉丸沉浸在我們獨有義大利番茄醬（這是SUBWAY® 創始人媽媽的獨家秘方）裡，配以自選的新鮮蔬菜和醬料，最後夾入新鮮出爐的麵包。請盡情享用吧!',0,'雞肉'),(11,'火雞臘腸 / COLD CUT TRIO',75,125,'img/burger/flaver/ColdCutTrio.jpg','系列中的傳統款，讓您品嘗到片片美味的義式煙燻臘腸、火雞火腿和義式臘味香腸，搭配自選蔬菜和醬料，並與每日新鮮烘製麵包一同上桌。',0,'火雞'),(12,'鮪魚 / TUNA',85,145,'img/burger/flaver/Tuna.jpg','鮪魚與新鮮美乃滋的混合，創造出世上最妙不可言的滋味。 SUBWAY® 鮪魚(Tuna) 潛艇堡可自選蔬菜、醬料以及新鮮出爐的各式麵包 。',0,'海鮮'),(13,'義大利經典 / ITALIAN B.M.T',110,180,'img/burger/flaver/ItalianBMT.jpg','經典系列中備受青睞的美味。在新鮮出爐的麵包裡夾入義式煙燻臘腸、義大利辣香腸和火腿切片，佐以自選的新鮮蔬菜，最後淋上醬料。',0,NULL),(14,'香熱起司 / SUBWAY MELT',110,180,'img/burger/flaver/SubwayMELT.jpg','柔嫩的火雞胸肉，火腿，滋滋作響的培根，濃濃的芝士，配以清脆的蔬菜和獨特醬料，一切都融合在新鲜出爐的麵包内， 這種美妙滋味只能意會不可言傳。立刻動身前往最近的SUBWAY® 一飽口福吧。',0,'火雞'),(15,'起司牛排 / STEAK & CHEESE',110,180,'img/burger/flaver/SteakCheese.jpg','靈感來自於費城著名的三明治(Hoagie)，而SUBWAY®的起司牛排(Cheese Steak) 嘗來更是不惶多讓，令人垂涎三尺的低脂、柔嫩的牛排切片，佐以嫩炒洋蔥和青椒，覆上一層熱融融的芝士，再配上各種自選的新鮮蔬菜和醬料，夾在新鮮出爐的麵包裡，熱氣騰騰，令人食指大動。',0,'牛肉');
/*!40000 ALTER TABLE `burger_flaver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `burger_sause`
--

DROP TABLE IF EXISTS `burger_sause`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `burger_sause` (
  `sauseId` int(11) NOT NULL AUTO_INCREMENT,
  `sauseName` varchar(45) NOT NULL DEFAULT 'sauseName',
  `url` varchar(100) DEFAULT NULL,
  `describ` varchar(100) DEFAULT NULL,
  `status` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`sauseId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `burger_sause`
--

LOCK TABLES `burger_sause` WRITE;
/*!40000 ALTER TABLE `burger_sause` DISABLE KEYS */;
INSERT INTO `burger_sause` VALUES (1,'黃芥末Mustard',NULL,NULL,0),(2,'義式油醋Oil&Vinegar',NULL,NULL,0),(3,'蜂蜜芥末Honey Mustard',NULL,NULL,0),(4,'甜蔥醬Sweet Onion',NULL,NULL,0),(5,'西南醬Chipotle Southweat',NULL,NULL,0),(6,'美乃滋Mayonnaise',NULL,NULL,0),(7,'橄欖油Oil',NULL,NULL,0),(8,'鹽&胡椒Salt & Pepper',NULL,NULL,0);
/*!40000 ALTER TABLE `burger_sause` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `burger_veg`
--

DROP TABLE IF EXISTS `burger_veg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `burger_veg` (
  `vegId` int(11) NOT NULL AUTO_INCREMENT,
  `vegName` varchar(45) NOT NULL,
  `url` varchar(100) DEFAULT NULL,
  `describ` varchar(100) DEFAULT NULL,
  `status` int(10) DEFAULT '0',
  PRIMARY KEY (`vegId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `burger_veg`
--

LOCK TABLES `burger_veg` WRITE;
/*!40000 ALTER TABLE `burger_veg` DISABLE KEYS */;
INSERT INTO `burger_veg` VALUES (1,'生菜Lettuce',NULL,NULL,0),(2,'番茄Tomatoes',NULL,NULL,0),(3,'大黃瓜Cucumbers',NULL,NULL,0),(4,'酸黃瓜Pickles',NULL,NULL,0),(5,'青椒Peppers',NULL,NULL,0),(6,'黑橄欖Olives',NULL,NULL,0),(7,'洋蔥Red Onions',NULL,NULL,0),(8,'墨西哥辣椒Jalapenos',NULL,NULL,0);
/*!40000 ALTER TABLE `burger_veg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `burgertemp`
--

DROP TABLE IF EXISTS `burgertemp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `burgertemp` (
  `cid` char(10) NOT NULL,
  `adddate` date DEFAULT NULL,
  `breadId` int(11) DEFAULT NULL,
  `breadName` varchar(45) DEFAULT NULL,
  `flaverId` int(11) DEFAULT NULL,
  `flaverName` varchar(45) DEFAULT NULL,
  `flaverPrice` int(11) DEFAULT NULL,
  `selectedSause01` tinyint(1) DEFAULT '0',
  `selectedSause02` tinyint(1) DEFAULT '0',
  `selectedSause03` tinyint(1) DEFAULT '0',
  `selectedSause04` tinyint(1) DEFAULT '0',
  `selectedSause05` tinyint(1) DEFAULT '0',
  `selectedSause06` tinyint(1) DEFAULT '0',
  `selectedSause07` tinyint(1) DEFAULT '0',
  `selectedSause08` tinyint(1) DEFAULT '0',
  `selectedVeg01` tinyint(1) DEFAULT '0',
  `selectedVeg02` tinyint(1) DEFAULT '0',
  `selectedVeg03` tinyint(1) DEFAULT '0',
  `selectedVeg04` tinyint(1) DEFAULT '0',
  `selectedVeg05` tinyint(1) DEFAULT '0',
  `selectedVeg06` tinyint(1) DEFAULT '0',
  `selectedVeg07` tinyint(1) DEFAULT '0',
  `selectedVeg08` tinyint(1) DEFAULT '0',
  `note` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  CONSTRAINT `foreignkey_cid` FOREIGN KEY (`cid`) REFERENCES `customers` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `burgertemp`
--

LOCK TABLES `burgertemp` WRITE;
/*!40000 ALTER TABLE `burgertemp` DISABLE KEYS */;
/*!40000 ALTER TABLE `burgertemp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customers` (
  `id` char(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `gender` char(2) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(45) NOT NULL,
  `birthday` date DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `discount` int(10) unsigned NOT NULL DEFAULT '0',
  `status` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES ('A123456770','陳小華','F','123456','Aaa@uuu.com.tw','2016-02-16',NULL,NULL,NULL,0,0),('A123456789','王小明','M','123456','uuu@uuu.com.tw','2016-02-16','02123456789','台中市','Customer',0,0),('A159350730','å¨å¨','M','123456','dlin@abb.com',NULL,NULL,NULL,NULL,0,0),('G126200776','陳忠茂','M','123456789','dasi483@yahoo.com.tw','2016-02-17','03-9781027','宜蘭縣頭城鎮濱海路五段483號','VIP',0,0),('L223911848','WWW','F','123456','akazuma82@gmail.com',NULL,'0',NULL,NULL,0,0);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `productId` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(45) NOT NULL,
  `price` int(10) DEFAULT NULL,
  `url` varchar(500) DEFAULT NULL,
  `priceLarge` int(10) DEFAULT NULL,
  `priceMiddle` int(10) DEFAULT NULL,
  `priceSmall` int(10) DEFAULT NULL,
  `describ` varchar(500) DEFAULT NULL,
  `addDate` date NOT NULL,
  `status` int(10) NOT NULL DEFAULT '0',
  `size` varchar(500) DEFAULT 'null',
  `catagory` char(8) DEFAULT NULL,
  PRIMARY KEY (`productId`),
  UNIQUE KEY `productId_UNIQUE` (`productId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'飲料項目',0,NULL,50,40,30,'說明內容','1911-01-01',9999,'','dr'),(2,'大吉嶺紅茶',0,NULL,50,40,30,'出產於印度西孟加拉邦北部喜馬拉雅山麓的大吉嶺高原，是红茶的一種，味道帶有果香而濃郁。','2016-03-23',0,'','dr'),(3,'阿里山高山烏龍',0,NULL,50,40,30,'產區風土為嘉義縣阿里山里，海拔1500M高山之礫質壤土，茶樹品種為青心(軟枝)烏龍，四季皆有。','2016-03-23',0,'','dr'),(4,'美粒果橘子汽水',0,NULL,50,40,30,'很單純的美粒果汽水橘子口味','2016-03-23',0,'','dr'),(5,'可口可樂',0,NULL,50,40,30,'很單純的可口可樂','2016-03-23',0,'','dr'),(6,'雪碧',0,NULL,50,40,30,'很單純的雪碧','2016-03-23',0,'','dr'),(7,'ZERO',0,NULL,50,40,30,'很單純的ZERO','2016-03-23',0,'','dr');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-23 19:01:10
