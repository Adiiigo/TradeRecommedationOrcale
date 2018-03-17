-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 17, 2018 at 08:44 PM
-- Server version: 5.7.20-0ubuntu0.16.04.1
-- PHP Version: 5.6.32-1+ubuntu16.04.1+deb.sury.org+2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `citi`
--

-- --------------------------------------------------------

--
-- Table structure for table `account_details`
--

CREATE TABLE `account_details` (
  `entry_id` int(11) NOT NULL,
  `security_code` int(11) NOT NULL,
  `status` varchar(30) NOT NULL,
  `current_price` decimal(11,4) NOT NULL,
  `volume` int(11) NOT NULL,
  `last_update_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sector_security_map`
--

CREATE TABLE `sector_security_map` (
  `security_code` int(11) NOT NULL,
  `sector_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sector_table`
--

CREATE TABLE `sector_table` (
  `sector_id` int(11) NOT NULL,
  `sector_name` varchar(30) NOT NULL,
  `sector_code` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `security_table`
--

CREATE TABLE `security_table` (
  `security_id` int(11) NOT NULL,
  `security_code` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_account_map`
--

CREATE TABLE `user_account_map` (
  `user_acc_map_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `entry_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_details`
--

CREATE TABLE `user_details` (
  `user_id` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `la_st_name` varchar(50) NOT NULL,
  `phone_no` int(11) NOT NULL,
  `email_id` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account_details`
--
ALTER TABLE `account_details`
  ADD PRIMARY KEY (`entry_id`);

--
-- Indexes for table `sector_security_map`
--
ALTER TABLE `sector_security_map`
  ADD UNIQUE KEY `security_code` (`security_code`,`sector_id`),
  ADD KEY `sector_id` (`sector_id`);

--
-- Indexes for table `sector_table`
--
ALTER TABLE `sector_table`
  ADD PRIMARY KEY (`sector_id`);

--
-- Indexes for table `security_table`
--
ALTER TABLE `security_table`
  ADD PRIMARY KEY (`security_id`),
  ADD UNIQUE KEY `security_code` (`security_code`);

--
-- Indexes for table `user_account_map`
--
ALTER TABLE `user_account_map`
  ADD UNIQUE KEY `user_id` (`user_id`,`entry_id`),
  ADD KEY `entry_id` (`entry_id`);

--
-- Indexes for table `user_details`
--
ALTER TABLE `user_details`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `user_id` (`user_id`),
  ADD UNIQUE KEY `email_id` (`email_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `sector_security_map`
--
ALTER TABLE `sector_security_map`
  ADD CONSTRAINT `sector_security_map_ibfk_1` FOREIGN KEY (`security_code`) REFERENCES `security_table` (`security_code`),
  ADD CONSTRAINT `sector_security_map_ibfk_2` FOREIGN KEY (`sector_id`) REFERENCES `sector_table` (`sector_id`);

--
-- Constraints for table `user_account_map`
--
ALTER TABLE `user_account_map`
  ADD CONSTRAINT `user_account_map_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user_details` (`user_id`),
  ADD CONSTRAINT `user_account_map_ibfk_2` FOREIGN KEY (`entry_id`) REFERENCES `account_details` (`entry_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
