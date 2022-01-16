-- MySQL dump 10.13  Distrib 8.0.27, for Linux (x86_64)
--
-- Host: 34.122.94.78    Database: tu_van_dinh_duong
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `chieu_cao_can_nang`
--

DROP TABLE IF EXISTS `chieu_cao_can_nang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chieu_cao_can_nang` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `gioi_tinh` varchar(255) DEFAULT NULL,
  `tuoi` double NOT NULL,
  `can_nang_toi_da` double NOT NULL,
  `can_nang_toi_thieu` double NOT NULL,
  `chieu_cao_toi_da` double NOT NULL,
  `chieu_cao_toi_thieu` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chieu_cao_can_nang`
--

LOCK TABLES `chieu_cao_can_nang` WRITE;
/*!40000 ALTER TABLE `chieu_cao_can_nang` DISABLE KEYS */;
INSERT INTO `chieu_cao_can_nang` VALUES (1,'nam',1,3.6,5.9,48.2,52.8),(2,'nữ',1,3.4,4.5,52.1,55.8),(3,'nam',2,4.3,6,55.5,60.7),(4,'nữ',2,4,5.4,54.4,59.2),(5,'nam',3,5,6.9,58.7,63.7),(6,'nữ',3,5.3,6.9,57.1,59.5),(7,'nam',4,5.7,7.6,61,66.4),(8,'nữ',4,5.8,7.5,59.5,64.5),(9,'nam',5,6.3,8.2,63.2,68.6),(10,'nữ',5,6.3,8.1,61.5,66.7),(11,'nam',6,7.3,8.5,65.1,70.5),(12,'nữ',6,6.8,8.7,63.3,68.6),(13,'nam',7,7.4,9.2,70.3,75.7),(14,'nữ',7,7.1,9,67.3,74.2),(15,'nam',8,7.7,9.6,70.3,75.7),(16,'nữ',8,7.7,9.1,68.7,75.8),(17,'nam',9,8.25,9.75,70.6,72.2),(18,'nữ',9,8.2,9.3,70.1,77.4),(19,'nam',10,8.3,10.2,73.3,80.1),(20,'nữ',10,8.5,9.6,71.5,78.9),(21,'nam',11,8.4,10.5,74.1,81.5),(22,'nữ',11,8.7,9.9,72.8,81.5),(23,'nam',12,8.9,10.4,74.5,82.9),(24,'nữ',12,8.9,10.1,74,81.7),(25,'nam',18,9,13.7,76.9,88.7),(26,'nữ',18,9,13.2,74.9,86.5),(27,'nam',24,9.7,15.3,81.7,93.9),(28,'nữ',24,9,14.8,80,92.9),(29,'nam',30,10.5,16.9,85.1,102.1),(30,'nữ',30,10,16.5,83.6,97.7),(31,'nam',36,11.3,18.3,88.1,107.2),(32,'nữ',36,10.8,18.1,87.4,102.7),(33,'nam',42,12,19.7,91.9,117.7),(34,'nữ',42,11.6,19.8,90.9,107.2),(35,'nam',48,12.7,21.2,94.1,115.9),(36,'nữ',48,12.3,21.5,94.1,111.3),(37,'nam',54,13.4,22.7,97.8,119.9),(38,'nữ',54,13,21.5,94.1,111.3),(39,'nam',60,14.1,24.2,100.7,123.9),(40,'nữ',60,13.8,24.9,99.9,118.9),(41,'nam',66,17.4,22.3,108.4,117.8),(42,'nữ',66,16.5,21.6,106.9,116.2),(43,'nam',72,18.4,24.6,111.2,121),(44,'nữ',72,18.3,22.9,109.7,119.6),(45,'nam',0,2.9,3.8,48.2,52.8),(46,'nữ',0,2.7,3.6,47.7,52);
/*!40000 ALTER TABLE `chieu_cao_can_nang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dinh_duong`
--

DROP TABLE IF EXISTS `dinh_duong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dinh_duong` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nhom` varchar(255) DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dinh_duong`
--

LOCK TABLES `dinh_duong` WRITE;
/*!40000 ALTER TABLE `dinh_duong` DISABLE KEYS */;
INSERT INTO `dinh_duong` VALUES (1,'Chất sinh năng lượng','Protein'),(2,'Chất sinh năng lượng','Lipit'),(3,'Chất sinh năng lượng','Glucid'),(4,'Dinh dưỡng thiết yếu','Nước'),(5,'Dinh dưỡng thiết yếu','Vitamin'),(6,'Dinh dưỡng thiết yếu','Khoáng chất');
/*!40000 ALTER TABLE `dinh_duong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giai_phap`
--

DROP TABLE IF EXISTS `giai_phap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `giai_phap` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `giai_phap` varchar(2048) DEFAULT NULL,
  `van_de` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giai_phap`
--

LOCK TABLES `giai_phap` WRITE;
/*!40000 ALTER TABLE `giai_phap` DISABLE KEYS */;
INSERT INTO `giai_phap` VALUES (1,' Phục hồi mất nước:\nCháo muối: 1 nắm gạo (50g) + 1 nhúm muối (3.5g) + 6 bát ăn nước cơm, đun nhừ,\nlọc lấy nước uống\nNước gạo rang: 50g gạo rang vàng và nấu như cháo muối\n','Suy dinh dưỡng thể còm'),(2,'Nếu trẻ ít hơn 2 tuổi, nuôi con bằng sữa mẹ: Cho trẻ bú sữa mẹ càng sớm càng tốt, theo nhu cầu\nCho bú sữa mẹ hoàn toàn trong 6 tháng đầu,\nThời gian được bú sữa mẹ ít nhất 12 tháng, tốt nhất là 24 tháng\n','Suy dinh dưỡng thể còm'),(3,'Cho trẻ ăn bổ sung hợp lý:\nCho ăn bổ sung sau 6 tháng tuổi\nCho trẻ ăn từ ít đến nhiều, tập làm quen với thức ăn mới\nSố lượng thức ăn tăng theo độ tuổi\nĐảm bảo thức ăn mềm, dễ nhai, dễ nuốt\nThức ăn bổ cùng cần cân đối dinh dưỡng, có đủ các nhóm thức ăn\nTăng đậm độ năng lượng của thức ăn: thêm dầu, mỡ, vừng, lạc\nĐảm bảo vệ sinh thực phẩm\nCho trẻ ăn nhiều hơn trong và sau khi bị ốm, cho trẻ ăn uống nhiều chất lỏng hơn,\nđặc biệt là khi bị ỉa chảy và sốt cao\n','Suy dinh dưỡng thể còm'),(4,' Phục hồi mất nước:\nCháo muối: 1 nắm gạo (50g) + 1 nhúm muối (3.5g) + 6 bát ăn nước cơm, đun nhừ,\nlọc lấy nước uống\nNước gạo rang: 50g gạo rang vàng và nấu như cháo muối\n','Suy dinh dưỡng thể phù'),(5,'Nếu trẻ ít hơn 2 tuổi, nuôi con bằng sữa mẹ: Cho trẻ bú sữa mẹ càng sớm càng tốt, theo nhu cầu\nCho bú sữa mẹ hoàn toàn trong 6 tháng đầu,\nThời gian được bú sữa mẹ ít nhất 12 tháng, tốt nhất là 24 tháng\n','Suy dinh dưỡng thể phù'),(6,'Cho trẻ ăn bổ sung hợp lý:\nCho ăn bổ sung sau 6 tháng tuổi\nCho trẻ ăn từ ít đến nhiều, tập làm quen với thức ăn mới\nSố lượng thức ăn tăng theo độ tuổi\nĐảm bảo thức ăn mềm, dễ nhai, dễ nuốt\nThức ăn bổ cùng cần cân đối dinh dưỡng, có đủ các nhóm thức ăn\nTăng đậm độ năng lượng của thức ăn: thêm dầu, mỡ, vừng, lạc\nĐảm bảo vệ sinh thực phẩm\nCho trẻ ăn nhiều hơn trong và sau khi bị ốm, cho trẻ ăn uống nhiều chất lỏng hơn,\nđặc biệt là khi bị ỉa chảy và sốt cao\n','Suy dinh dưỡng thể phù'),(7,' Phục hồi mất nước:\nCháo muối: 1 nắm gạo (50g) + 1 nhúm muối (3.5g) + 6 bát ăn nước cơm, đun nhừ,\nlọc lấy nước uống\nNước gạo rang: 50g gạo rang vàng và nấu như cháo muối\n','Suy dinh dưỡng thể phối hợp'),(8,'Nếu trẻ ít hơn 2 tuổi, nuôi con bằng sữa mẹ: Cho trẻ bú sữa mẹ càng sớm càng tốt, theo nhu cầu\nCho bú sữa mẹ hoàn toàn trong 6 tháng đầu,\nThời gian được bú sữa mẹ ít nhất 12 tháng, tốt nhất là 24 tháng\n','Suy dinh dưỡng thể phối hợp'),(9,'Cho trẻ ăn bổ sung hợp lý:\nCho ăn bổ sung sau 6 tháng tuổi\nCho trẻ ăn từ ít đến nhiều, tập làm quen với thức ăn mới\nSố lượng thức ăn tăng theo độ tuổi\nĐảm bảo thức ăn mềm, dễ nhai, dễ nuốt\nThức ăn bổ cùng cần cân đối dinh dưỡng, có đủ các nhóm thức ăn\nTăng đậm độ năng lượng của thức ăn: thêm dầu, mỡ, vừng, lạc\nĐảm bảo vệ sinh thực phẩm\nCho trẻ ăn nhiều hơn trong và sau khi bị ốm, cho trẻ ăn uống nhiều chất lỏng hơn,\nđặc biệt là khi bị ỉa chảy và sốt cao\n','Suy dinh dưỡng thể phối hợp'),(10,'Cho trẻ ăn đủ thức ăn giàu vitamin A: hạt nêm, bơ thực vật, dầu thực vật, đường...','Thiếu vitamin A'),(11,'Ăn thực phẩm giàu sắt, giàu vitamin C để tăng cường hấp thu sắt','Thiếu máu dinh dưỡng'),(12,'Ăn các thực phẩm giàu vitamin: cà chua, rau ...','Thiếu máu dinh dưỡng'),(13,'Sử dụng muối i-ốt','Thiếu i-ốt và bướu cổ'),(14,'Sử dụng gia vị chứa i-ốt: bột canh, hạt nêm..','Thiếu i-ốt và bướu cổ'),(15,'Đảm bảo chế độ ăn cung cấp đủ nhu cầu kẽm','Thiếu kẽm'),(16,'Cung cấp đủ rau quả chứa nhiều vitamin C, giúp tăng hấp thụ kẽm','Thiếu kẽm'),(17,'Thay thế các loại thực phẩm có thành phần dinh dưỡng nhưng ít đường\nvà chất béo hơn như khoai lang, ngô. Có thể cho trẻ ăn nhiều rau xanh,\ncác loại trái cây thực phẩm chứa nhiều chất xơ.\n','Thừa cân, béo phì'),(18,'Không cho trẻ ăn các thức ăn nhiều dầu mỡ, đồ ăn chiên xào\nthay vào đó có thể hấp, luộc\n','Thừa cân, béo phì'),(19,'Cho trẻ ăn ít loại đồ ăn vừa chứa chất béo vừa nhiều\nđường như bánh nướng, khoai tây chiên, \n xúc xích...','Thừa cân, béo phì');
/*!40000 ALTER TABLE `giai_phap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hien_tuong`
--

DROP TABLE IF EXISTS `hien_tuong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hien_tuong` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `bieu_hien` varchar(255) DEFAULT NULL,
  `muc_do_phu_hop` int NOT NULL,
  `van_de` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hien_tuong`
--

LOCK TABLES `hien_tuong` WRITE;
/*!40000 ALTER TABLE `hien_tuong` DISABLE KEYS */;
INSERT INTO `hien_tuong` VALUES (1,'Da bọc xương, teo cơ',3,'Suy dinh dưỡng thể còm'),(2,'Mắt mỡ dưới da',3,'Suy dinh dưỡng thể còm'),(3,'Bộ mặt của ông già',3,'Suy dinh dưỡng thể còm'),(4,'Bụng ỏng, phình ra',2,'Suy dinh dưỡng thể còm'),(5,'Khó chịu, bứt rứt, quấy khóc',1,'Suy dinh dưỡng thể còm'),(6,'Phù chân tay mặt',2,'Suy dinh dưỡng thể phù'),(7,'Sút cân vừa phải',3,'Suy dinh dưỡng thể phù'),(8,'Mặt tròn, vòng cánh tay nhỏ, cơ yếu',2,'Suy dinh dưỡng thể phù'),(9,'Kém ngon miệng',1,'Suy dinh dưỡng thể phù'),(10,'Bứt rứt, lãnh đạm, thờ ơ, quấy khóc',1,'Suy dinh dưỡng thể phù'),(11,'Tóc mỏng, thưa, dễ nhổ',2,'Suy dinh dưỡng thể phù'),(12,'Sút cân nhiều',3,'Suy dinh dưỡng thể phối hợp'),(13,'Phù chân tay mặt',3,'Suy dinh dưỡng thể phối hợp'),(14,'Tóc mỏng, thay đổi da',3,'Suy dinh dưỡng thể phối hợp'),(15,'Gầy',1,'Suy dinh dưỡng thể phối hợp'),(16,'Thay đổi tinh thần',2,'Suy dinh dưỡng thể phối hợp'),(17,'Giảm thị lực trong điều kiện thiếu ánh sáng',2,'Thiếu vitamin A'),(18,'Không nhìn rõ lúc chập tối',1,'Thiếu vitamin A'),(19,'Sợ đi, ngồi 1 chỗ',1,'Thiếu vitamin A'),(20,'Đi vấp ngã, đi không đúng chỗ',1,'Thiếu vitamin A'),(21,'Mảng nổi lên có màu trắng sáng hoặc vàng nhạt,\nhình oval hoặc tam giác ở vị trí góc mũi hoặc thái dương\n',3,'Thiếu vitamin A'),(22,'Bề mặt mắt có vẩy hoặc chấm trắng như đám mây',3,'Thiếu vitamin A'),(23,'Sợ ánh sáng, chói, hay dụi mắt',2,'Thiếu vitamin A'),(24,'Bề mặt mắt bị phủ 1 lớp mây trắng đục,\ntoàn bộ giác mạc bị mềm nhũn\n',3,'Thiếu vitamin A'),(25,'Giác mạc bị đục',3,'Thiếu vitamin A'),(26,'Mệt mỏi, thờ ơ, ù tai, hoa mắt chóng mặt',3,'Thiếu máu dinh dưỡng'),(27,'Đau đầu, giảm trí nhớ, mất ngủ, tê tay chân',3,'Thiếu máu dinh dưỡng'),(28,'Đánh trống ngực, khó thở',3,'Thiếu máu dinh dưỡng'),(29,'Da xanh, niêm mạc nhợt nhạt',3,'Thiếu máu dinh dưỡng'),(30,'Lưỡi màu nhợt',2,'Thiếu máu dinh dưỡng'),(31,'Tóc rụng, móng tay giòn, dễ gãy',1,'Thiếu máu dinh dưỡng'),(32,'Mạch nhanh',1,'Thiếu máu dinh dưỡng'),(33,'Sờ thấy tuyến giáp, mỗi thùy bên của tuyến giáp\ncó kích thước lớn hơn đốt ngón tay cái\n',3,'Thiếu i-ốt và bướu cổ'),(34,'Ngửa cổ nhìn thấy tuyến giáp di động khi nuốt',3,'Thiếu i-ốt và bướu cổ'),(35,'Tuyến giáp to, nhìn thấy bướu khi cổ ở tư thế bình thường',3,'Thiếu i-ốt và bướu cổ'),(36,'Thấp còi, nhẹ cân',1,'Thiếu kẽm'),(37,'Chán ăn, rối loạn nhận thức',3,'Thiếu kẽm'),(38,'Thừa cân, nhiều mỡ',3,'Thừa cân, béo phì'),(39,'Thường xuyên đói bụng',1,'Thừa cân, béo phì'),(40,'Tê chân tay',2,'Thừa cân, béo phì');
/*!40000 ALTER TABLE `hien_tuong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhu_cau_chat_khoang`
--

DROP TABLE IF EXISTS `nhu_cau_chat_khoang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhu_cau_chat_khoang` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `canxi` double NOT NULL,
  `dong` double NOT NULL,
  `iot` double NOT NULL,
  `kem` double NOT NULL,
  `maggie` double NOT NULL,
  `phospho` double NOT NULL,
  `sat` double NOT NULL,
  `seleni` double NOT NULL,
  `tuoi_toi_da` double NOT NULL,
  `tuoi_toi_thieu` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhu_cau_chat_khoang`
--

LOCK TABLES `nhu_cau_chat_khoang` WRITE;
/*!40000 ALTER TABLE `nhu_cau_chat_khoang` DISABLE KEYS */;
INSERT INTO `nhu_cau_chat_khoang` VALUES (1,210,200,110,2,30,100,0.27,15,6,0),(2,270,220,130,3,75,275,11,20,12,6),(3,500,340,90,3,80,460,7,20,24,12),(4,800,440,90,5,130,500,10,30,72,24);
/*!40000 ALTER TABLE `nhu_cau_chat_khoang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhu_cau_glucid`
--

DROP TABLE IF EXISTS `nhu_cau_glucid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhu_cau_glucid` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `khoi_luong` double NOT NULL,
  `tuoi_toi_da` double NOT NULL,
  `tuoi_toi_thieu` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhu_cau_glucid`
--

LOCK TABLES `nhu_cau_glucid` WRITE;
/*!40000 ALTER TABLE `nhu_cau_glucid` DISABLE KEYS */;
INSERT INTO `nhu_cau_glucid` VALUES (1,20,0,72);
/*!40000 ALTER TABLE `nhu_cau_glucid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhu_cau_lipid`
--

DROP TABLE IF EXISTS `nhu_cau_lipid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhu_cau_lipid` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `khoi_luong` double NOT NULL,
  `tuoi_toi_da` double NOT NULL,
  `tuoi_toi_thieu` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhu_cau_lipid`
--

LOCK TABLES `nhu_cau_lipid` WRITE;
/*!40000 ALTER TABLE `nhu_cau_lipid` DISABLE KEYS */;
INSERT INTO `nhu_cau_lipid` VALUES (1,4.9,6,0),(2,5.1,12,7),(3,7.7,24,12),(4,10.9,72,24);
/*!40000 ALTER TABLE `nhu_cau_lipid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhu_cau_nang_luong`
--

DROP TABLE IF EXISTS `nhu_cau_nang_luong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhu_cau_nang_luong` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `tuoi_toi_da` double NOT NULL,
  `tuoi_toi_thieu` double NOT NULL,
  `nang_luong` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhu_cau_nang_luong`
--

LOCK TABLES `nhu_cau_nang_luong` WRITE;
/*!40000 ALTER TABLE `nhu_cau_nang_luong` DISABLE KEYS */;
INSERT INTO `nhu_cau_nang_luong` VALUES (1,3,0,480),(2,6,3,620),(3,12,6,820),(4,36,12,1300),(5,72,36,1600);
/*!40000 ALTER TABLE `nhu_cau_nang_luong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhu_cau_nuoc`
--

DROP TABLE IF EXISTS `nhu_cau_nuoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhu_cau_nuoc` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `tuoi` double NOT NULL,
  `can_nang` double NOT NULL,
  `dung_luong_toi_da` double NOT NULL,
  `dung_luong_toi_thieu` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhu_cau_nuoc`
--

LOCK TABLES `nhu_cau_nuoc` WRITE;
/*!40000 ALTER TABLE `nhu_cau_nuoc` DISABLE KEYS */;
INSERT INTO `nhu_cau_nuoc` VALUES (1,0.1,3,100,100),(2,0.33,3.2,125,150),(3,3,5.4,140,160),(4,6,7.3,130,155),(5,9,8.6,125,145),(6,12,9.5,120,135),(7,24,11.8,115,125),(8,48,16.2,100,110),(9,72,20,90,100);
/*!40000 ALTER TABLE `nhu_cau_nuoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhu_cau_protein`
--

DROP TABLE IF EXISTS `nhu_cau_protein`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhu_cau_protein` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `khoi_luong` double NOT NULL,
  `tuoi_toi_da` double NOT NULL,
  `tuoi_toi_thieu` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhu_cau_protein`
--

LOCK TABLES `nhu_cau_protein` WRITE;
/*!40000 ALTER TABLE `nhu_cau_protein` DISABLE KEYS */;
INSERT INTO `nhu_cau_protein` VALUES (1,2,3,1),(2,1.68,6,3),(3,1.65,24,6),(4,1.23,72,24);
/*!40000 ALTER TABLE `nhu_cau_protein` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhu_cau_vitamin`
--

DROP TABLE IF EXISTS `nhu_cau_vitamin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhu_cau_vitamin` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `tuoi_toi_da` double NOT NULL,
  `tuoi_toi_thieu` double NOT NULL,
  `vitamin_a` double DEFAULT NULL,
  `vitamin_b1` double DEFAULT NULL,
  `vitamin_b12` double DEFAULT NULL,
  `vitamin_b2` double DEFAULT NULL,
  `vitamin_b3` double DEFAULT NULL,
  `vitamin_b6` double DEFAULT NULL,
  `vitamin_b9` double DEFAULT NULL,
  `vitamin_c` double DEFAULT NULL,
  `vitamin_d` double DEFAULT NULL,
  `vitamin_e` double DEFAULT NULL,
  `vitamin_k` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhu_cau_vitamin`
--

LOCK TABLES `nhu_cau_vitamin` WRITE;
/*!40000 ALTER TABLE `nhu_cau_vitamin` DISABLE KEYS */;
INSERT INTO `nhu_cau_vitamin` VALUES (1,6,0,375,0.3,0.3,0.4,5,0.3,25,30,5,3,5),(2,12,6,375,0.4,0.5,0.5,6,0.6,35,35,5,4,10),(3,36,12,400,0.7,0.7,0.8,9,1,50,40,5,6,15),(4,72,36,500,0.9,1,1.1,12,1.1,75,45,5,7,20);
/*!40000 ALTER TABLE `nhu_cau_vitamin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thuc_pham_chuyen_doi`
--

DROP TABLE IF EXISTS `thuc_pham_chuyen_doi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thuc_pham_chuyen_doi` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `chat_beo_bao_hoa` varchar(255) DEFAULT NULL,
  `kcal` double NOT NULL,
  `nhom` varchar(255) DEFAULT NULL,
  `protein` varchar(255) DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `tinh_bot` varchar(255) DEFAULT NULL,
  `xo` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thuc_pham_chuyen_doi`
--

LOCK TABLES `thuc_pham_chuyen_doi` WRITE;
/*!40000 ALTER TABLE `thuc_pham_chuyen_doi` DISABLE KEYS */;
INSERT INTO `thuc_pham_chuyen_doi` VALUES (1,'0.15-1.35',150,'Nhiều tinh bột','1.35-5.4','Cơm','28.2-105.75',0),(2,'3-27',250,'Nhiều tinh bột','9-36','Bánh mì đen','48-180',7),(3,'4-36',266,'Nhiều tinh bột','1-4','Bánh mì','48-180',4),(4,'1-9',96,'Nhiều tinh bột','1-4','Ngô ngọt','19-71.25',3),(5,'0',89,'Nhiều tinh bột','1-4','Chuối','23-86.25',3),(6,'21.5-193.5',260,'Nhiều chất béo','16.5-66','Thịt ba chỉ','0',0),(7,'3-27',187,'Nhiều chất béo','18-72','Thịt gà','0',0),(8,'6-54',201,'Nhiều chất béo','34-136','Bắp bò','0',0),(9,'11-99',259,'Nhiều chất béo','5.6-22.4','Phô mai','0',0),(10,'116-104.4',166,'Nhiều protein','14.8-59.2','Trứng','0',0),(11,'0',23,'Nhiều protein','1-4','Cà chua xanh','5-18.75',1),(12,'0',41,'Nhiều protein','1-4','Cà rốt','10-37.5',3),(13,'0',114,'Nhiều protein','24-96','Cá thu','0.5-1.875',0),(14,'0',30,'Nhiều protein','3-12','Rau muống','3.5-13.125',1),(15,'0',25,'Nhiều protein','2.8-11.2','Rau đay','5-18.75',1.5),(16,'0',26,'Nhiều protein','3.5-14','Rau ngót','6-22.5',2.5),(17,'0',16,'Nhiều protein','1-4','Rau cần tây','4-15',2),(18,'0',30,'Nhiều protein','2-8','Súp lơ','5-18.75',3),(19,'0',20,'Nhiều protein','1-4','Bầu','4-15',0),(20,'0',38,'Nhiều protein','1-4','Bưởi','10-37.5',1);
/*!40000 ALTER TABLE `thuc_pham_chuyen_doi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ti_le_dinh_duong`
--

DROP TABLE IF EXISTS `ti_le_dinh_duong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ti_le_dinh_duong` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `canxi` double DEFAULT NULL,
  `chat_beo` double NOT NULL,
  `protein` double NOT NULL,
  `tinh_bot` double NOT NULL,
  `tong_kcal` double DEFAULT NULL,
  `tuoi_toi_da` double NOT NULL,
  `tuoi_toi_thieu` double NOT NULL,
  `vitamin_a` double DEFAULT NULL,
  `vitamin_b1` double DEFAULT NULL,
  `vitamin_b12` double DEFAULT NULL,
  `vitamin_b2` double DEFAULT NULL,
  `vitamin_c` double DEFAULT NULL,
  `vitamin_d` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ti_le_dinh_duong`
--

LOCK TABLES `ti_le_dinh_duong` WRITE;
/*!40000 ALTER TABLE `ti_le_dinh_duong` DISABLE KEYS */;
INSERT INTO `ti_le_dinh_duong` VALUES (1,300,40,12,48,620,6,0,300,1.5,2,1.5,30,300),(2,500,38,12,50,820,12,6,550,1.5,2,1.5,30,500),(3,500,35,12,53,1300,36,12,550,1.5,2,1.5,65,500),(4,500,25,12,63,1600,72,36,550,1.5,2,1.5,65,500);
/*!40000 ALTER TABLE `ti_le_dinh_duong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vai_tro`
--

DROP TABLE IF EXISTS `vai_tro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vai_tro` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `vai_tro` varchar(255) DEFAULT NULL,
  `dinh_duong_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdxd09tofsnxsv200td072iqe3` (`dinh_duong_id`),
  CONSTRAINT `FKdxd09tofsnxsv200td072iqe3` FOREIGN KEY (`dinh_duong_id`) REFERENCES `dinh_duong` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vai_tro`
--

LOCK TABLES `vai_tro` WRITE;
/*!40000 ALTER TABLE `vai_tro` DISABLE KEYS */;
INSERT INTO `vai_tro` VALUES (1,'Vật liệu xây dựng cơ thể',1),(2,'Thành phần chủ yếu của các enzym, nội tiết, kháng thể',1),(3,'Tham gia vận chuyển 1 số chất: canxi, sắt, mỡ',1),(4,'Nguồn cung năng lượng duy trì sự sống',1),(5,'Nguồn cung năng lượng chủ yếu duy trì sự sống',2),(6,'Nguồn cung cấp các acid béo',2),(7,'Tham gia vào quá trình xây dựng cơ thể: màng tế bào, mô mỡ dưới da...',2),(8,'Tăng khả năng hấp thụ vitamin tan trong dầu: A, D, E, K… và tích trữ chúng',2),(9,'Cung cấp năng lượng duy trì sự sống',3),(10,'Tham gia vào quá trình tạo cơ thể: dịch ngoại bào, mô, sụn, da...',3),(11,'Khử độc gan',3),(12,'Cung cấp khoáng chất',4),(13,'Vận chuyển chất dinh dưỡng, oxy cho các tế bào',4),(14,'Duy trì sự sống',4),(15,'Tham gia vào quá trình chuyển hóa: vitamin b1 chuyển hóa glucid, vitamin d sử dụng và chuyển hóa canxi, phospho',5),(16,'Giúp phát triển cơ thể: vitamin a, vitamin b1, vitamin b2',5),(17,'Tạo hồng cầu: vitamin b2, vitamin b12, acid folic',5),(18,'Tăng sức đề kháng của cơ thể: vitamin a, vitamin c',5),(19,'Giữ cho hệ thần kinh, hệ tiêu hóa hoạt động tốt: vitamin b1, vitamin b2, vitamin b12, vitamin c',5),(20,'Chống lão hóa: vitamin e, vitamin c',5),(21,'Thành phần quan trọng của tổ chức xương',6),(22,'Duy trì áp lực thẩm thấu, tham gia trong các quá trình chuyển hóa của cơ thể',6),(23,'Hình thành xương, răng vững chức: canxi',6),(24,'Tham gia tạo hồng cầu: sắt',6),(25,'Giúp hình thành hệ xương, răng, chuyển hóa năng lượng giúp phát triển tốt: phospho',6),(26,'Phòng chống bướu cổ, thiểu năng trí tuệ: i-ốt',6);
/*!40000 ALTER TABLE `vai_tro` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-15 23:36:13
