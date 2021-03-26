DROP DATABASE  IF EXISTS `survey_web_app`;

CREATE DATABASE  IF NOT EXISTS `survey_web_app`;
USE `survey_web_app`;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` char(80) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: http://www.luv2code.com/generate-bcrypt-password
--
-- Default passwords here are: fun123
--

INSERT INTO `user` (username,password,first_name,last_name,email)
VALUES 
('john','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','John','Doe','john@luv2code.com'),
('mary','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','Mary','Public','mary@luv2code.com'),
('susan','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','Susan','Adams','susan@luv2code.com');


--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `roles`
--

INSERT INTO `role` (name)
VALUES 
('ROLE_USER'),('ROLE_ADMIN');

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;

CREATE TABLE `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  
  PRIMARY KEY (`user_id`,`role_id`),
  
  KEY `FK_ROLE_idx` (`role_id`),
  
  CONSTRAINT `FK_USER_05` FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`) 
  REFERENCES `role` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `survey`;

CREATE TABLE `survey` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(128) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `TITLE_UNIQUE` (`title`)

)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `question`;

CREATE TABLE `question` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(128) NOT NULL,
    `type` VARCHAR(45) NOT NULL,
    `survey_id` INT(11) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FK_SURVEY_idx` (`survey_id`),
	CONSTRAINT `FK_SURVEY` FOREIGN KEY (`survey_id`) 
	REFERENCES `survey` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION

)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `answer`;

CREATE TABLE `answer` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(128) NOT NULL,
    `question_id` INT(11) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FK_QUESTION_idx` (`question_id`),
	CONSTRAINT `FK_QUESTION` FOREIGN KEY (`question_id`) 
	REFERENCES `question` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION

)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `response`;

CREATE TABLE `response` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(45) NOT NULL,
    `survey_id` INT(11) NOT NULL,
    `question_id` INT(11) NOT NULL,
    `text` VARCHAR(128) NOT NULL,
    `verification` VARCHAR(128) NOT NULL,
    PRIMARY KEY (`id`),
	
    KEY `FK_QUESTION_idx` (`question_id`),

  CONSTRAINT `FK_SURVEY_05` FOREIGN KEY (`survey_id`) 
  REFERENCES `survey` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_QUESTION_05` FOREIGN KEY (`question_id`) 
  REFERENCES `question` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION

)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `users_surveys`;

CREATE TABLE `users_surveys` (
  `user_id` int(11) NOT NULL,
  `survey_id` int(11) NOT NULL,
  
  PRIMARY KEY (`user_id`,`survey_id`),
  
  KEY `FK_SURVEY_idx` (`survey_id`),
  
  CONSTRAINT `FK_USER_10` FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_SURVEY_10` FOREIGN KEY (`survey_id`) 
  REFERENCES `survey` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


SET FOREIGN_KEY_CHECKS = 1;

--
-- Dumping data for table `users_roles`
--

INSERT INTO `users_roles` (user_id,role_id)
VALUES 
(1, 1),
(2, 1),
(2, 2),
(3, 1),
(3, 2)