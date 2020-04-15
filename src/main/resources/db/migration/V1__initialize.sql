-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Sep 25, 2018 at 10:23 PM
-- Server version: 5.6.34-log
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `redhawk-rentals`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'Basketball'),
(2, 'Soccer'),
(3, 'Football'),
(4, 'Yoga'),
(5, 'Weights'),
(6, 'Running'),
(7, 'Swimming'),
(8, 'Climbing'),
(9, 'Boxing'),
(10, 'Table Tennis'),
(11, 'Tennis'),
(12, 'Competitive Cooking');

-- --------------------------------------------------------

--
-- Table structure for table `equipment`
--

CREATE TABLE `equipment` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `quantity` int(11) NOT NULL,
  `category_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `equipment`
--

INSERT INTO `equipment` (`id`, `name`, `quantity`, `category_id`) VALUES
(1, 'Basketball Goals', 2, 1),
(2, 'Soccer Nets', 2, 2),
(3, 'Yoga Mat', 7, 4),
(4, 'Football Flags', 3, 3),
(5, 'Boxing Gloves (set)', 2, 9),
(6, 'Pool Volleyball Set', 2, 7),
(7, '5 Pound Dumbbells', 2, 5),
(8, '10 Pound Dumbbells', 6, 5),
(9, '2.5 Pound Dumbbells', 2, 5),
(10, 'Stopwatch', 14, 6),
(11, 'Climbing Rope 75 ft.', 5, 8),
(12, 'Climbing Harnesses', 5, 8),
(13, 'Paddles', 4, 10),
(14, 'Ping Pong Balls', 0, 10),
(15, 'Kicking Tee', 3, 3),
(16, '5lb Medicine Ball', 3, 5),
(17, '10lb Medicine Ball', 7, 5),
(18, 'Gloves (pair)', 2, 8),
(19, 'Tennis Ball', 34, 11),
(20, 'Tennis Racket', 7, 11),
(21, 'Punching Bag', 6, 9);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`) VALUES
(1, 'cooluser'),
(2, 'cooleruser'),
(3, 'loseruser'),
(4, 'bestuserever'),
(5, 'gooduser'),
(6, 'testuser'),
(7, 'OkayUser');

-- --------------------------------------------------------

--
-- Table structure for table `user_rentals`
--

CREATE TABLE `user_rentals` (
  `users_id` int(11) NOT NULL,
  `rentals_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_rentals`
--

INSERT INTO `user_rentals` (`users_id`, `rentals_id`) VALUES
(6, 1),
(6, 2),
(6, 3),
(6, 5),
(6, 10),
(1, 9),
(1, 13),
(4, 10),
(2, 3),
(2, 1),
(2, 6),
(2, 5),
(2, 1),
(5, 11),
(5, 12),
(5, 5),
(5, 1),
(5, 18),
(3, 3),
(3, 16);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `equipment`
--
ALTER TABLE `equipment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKb4svnpl9s3b1p5uuvqx5ihlki` (`category_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_rentals`
--
ALTER TABLE `user_rentals`
  ADD KEY `FKc8c7tpuumh56s0168ip142ocj` (`rentals_id`),
  ADD KEY `FK22d8jyba893mcp496q76e0u2` (`users_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `equipment`
--
ALTER TABLE `equipment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `equipment`
--
ALTER TABLE `equipment`
  ADD CONSTRAINT `FKb4svnpl9s3b1p5uuvqx5ihlki` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

--
-- Constraints for table `user_rentals`
--
ALTER TABLE `user_rentals`
  ADD CONSTRAINT `FK22d8jyba893mcp496q76e0u2` FOREIGN KEY (`users_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKc8c7tpuumh56s0168ip142ocj` FOREIGN KEY (`rentals_id`) REFERENCES `equipment` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
