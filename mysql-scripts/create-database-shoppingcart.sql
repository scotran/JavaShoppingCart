CREATE DATABASE `shoppingcart` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `users` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `balance` int NOT NULL DEFAULT '10000',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `inventory` (
  `username` varchar(45) NOT NULL,
  `item1` int NOT NULL DEFAULT '0',
  `item2` int NOT NULL DEFAULT '0',
  `item3` int NOT NULL DEFAULT '0',
  `item4` int NOT NULL DEFAULT '0',
  `item5` int NOT NULL DEFAULT '0',
  `item6` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

