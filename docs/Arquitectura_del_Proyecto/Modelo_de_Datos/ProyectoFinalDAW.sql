-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               10.5.5-MariaDB-1:10.5.5+maria~focal - mariadb.org binary distribution
-- Server OS:                    debian-linux-gnu
-- HeidiSQL Version:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping data for table ProyectoFinalDAW.diet: ~3 rows (approximately)
/*!40000 ALTER TABLE `diet` DISABLE KEYS */;
INSERT INTO `diet` (`id`, `allergens`, `carbohydrates`, `description`, `fats`, `name`, `proteins`) VALUES
	(1, 'LECHE', 200, 'DEFICIT', 80, 'DEFICIT', 100),
	(2, 'TRIGO', 300, 'SUPERAVIT', 100, 'SUPERAVIT', 200),
	(3, 'OMEGA 3', 50, 'DEFICIT ULTRA', 200, 'DEFICIT ULTRA', 200);
/*!40000 ALTER TABLE `diet` ENABLE KEYS */;

-- Dumping data for table ProyectoFinalDAW.role: ~4 rows (approximately)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `name`) VALUES
	(1, 'admin'),
	(2, 'cliente'),
	(3, 'dietista'),
	(4, 'entrenador');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Dumping data for table ProyectoFinalDAW.routine: ~3 rows (approximately)
/*!40000 ALTER TABLE `routine` DISABLE KEYS */;
INSERT INTO `routine` (`id`, `intensity`, `name`) VALUES
	(1, 'ALTA', 'HIT'),
	(2, 'BAJA', 'LISS'),
	(3, 'MEDIA', 'POWER');
/*!40000 ALTER TABLE `routine` ENABLE KEYS */;

-- Dumping data for table ProyectoFinalDAW.trainingplan: ~3 rows (approximately)
/*!40000 ALTER TABLE `trainingplan` DISABLE KEYS */;
INSERT INTO `trainingplan` (`id`, `name`, `objetive`, `price`) VALUES
	(1, 'LEGEND', 'PERDIDA', '100'),
	(2, 'JAVELIN', 'SUBIDA', '50'),
	(3, 'FREEZE', '80', '250');
/*!40000 ALTER TABLE `trainingplan` ENABLE KEYS */;

-- Dumping data for table ProyectoFinalDAW.trainingplan_diet: ~7 rows (approximately)
/*!40000 ALTER TABLE `trainingplan_diet` DISABLE KEYS */;
INSERT INTO `trainingplan_diet` (`diet_id`, `trainingplan_id`) VALUES
	(1, 1),
	(1, 2),
	(1, 3),
	(2, 1),
	(3, 1),
	(3, 2),
	(3, 3);
/*!40000 ALTER TABLE `trainingplan_diet` ENABLE KEYS */;

-- Dumping data for table ProyectoFinalDAW.trainingplan_routine: ~7 rows (approximately)
/*!40000 ALTER TABLE `trainingplan_routine` DISABLE KEYS */;
INSERT INTO `trainingplan_routine` (`routine_id`, `trainingplan_id`) VALUES
	(1, 1),
	(1, 2),
	(2, 1),
	(2, 3),
	(3, 1),
	(3, 2),
	(3, 3);
/*!40000 ALTER TABLE `trainingplan_routine` ENABLE KEYS */;

-- Dumping data for table ProyectoFinalDAW.trainingplan_user: ~0 rows (approximately)
/*!40000 ALTER TABLE `trainingplan_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `trainingplan_user` ENABLE KEYS */;

-- Dumping data for table ProyectoFinalDAW.user: ~4 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `age`, `lastname`, `name`, `password`, `username`) VALUES
	(1, 20, 'admin', 'admin', '$2a$10$KpP30HLiS3crteioezWvmeuasqr/Whhf2b88RBJQXgzOMrV3n99fW', 'admin'),
	(2, 25, 'cliente', 'cliente', '$2a$10$oJJeCqaQaVNZgfMPCjKRD.nVwjY5LiPczA7u3bedFip4M5CanKKKm', 'cliente'),
	(3, 30, 'dietista', 'dietista', '$2a$10$H0LUxYDP1GcdFcR40VeULOkUcl9H.URe4TsWNd3KaJ/g./s.XNqK2', 'dietista'),
	(5, 40, 'entrenador', 'entrenador', '$2a$10$T./4ys1tIwIVhG9dou/nMOv.5EuEM4FVcBcVPd6kkBo0rbWbchGRu', 'entrenador');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping data for table ProyectoFinalDAW.users_roles: ~4 rows (approximately)
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
	(1, 1),
	(2, 2),
	(3, 3),
	(5, 4);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
