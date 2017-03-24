-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema GameDataBase
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `GameDataBase` ;

-- -----------------------------------------------------
-- Schema GameDataBase
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `GameDataBase` DEFAULT CHARACTER SET utf8 ;
USE `GameDataBase` ;

-- -----------------------------------------------------
-- Table `game`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `game` ;

CREATE TABLE IF NOT EXISTS `game` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  `genre` VARCHAR(45) NULL,
  `msrp` DOUBLE NOT NULL,
  `rating` CHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vendor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vendor` ;

CREATE TABLE IF NOT EXISTS `vendor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `customer` ;

CREATE TABLE IF NOT EXISTS `customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firs_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `age` VARCHAR(45) NULL,
  `vendor_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_customer_vendor1_idx` (`vendor_id` ASC),
  CONSTRAINT `fk_customer_vendor1`
    FOREIGN KEY (`vendor_id`)
    REFERENCES `vendor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `inventory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `inventory` ;

CREATE TABLE IF NOT EXISTS `inventory` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `game_id` INT NOT NULL,
  `vendor_id` INT NOT NULL,
  `price` DOUBLE NULL,
  `sold` INT(1) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_game_has_vendor_vendor1_idx` (`vendor_id` ASC),
  INDEX `fk_game_has_vendor_game1_idx` (`game_id` ASC),
  CONSTRAINT `fk_game_has_vendor_game1`
    FOREIGN KEY (`game_id`)
    REFERENCES `game` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_game_has_vendor_vendor1`
    FOREIGN KEY (`vendor_id`)
    REFERENCES `vendor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO developer@localhost;
 DROP USER developer@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'developer'@'localhost' IDENTIFIED BY 'developer';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'developer'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `game`
-- -----------------------------------------------------
START TRANSACTION;
USE `GameDataBase`;
INSERT INTO `game` (`id`, `name`, `description`, `genre`, `msrp`, `rating`) VALUES (1, 'Mass Effect Andromeda', 'A futuristic role-playing game set in a new galaxy', 'RPG', 59.99, 'M');
INSERT INTO `game` (`id`, `name`, `description`, `genre`, `msrp`, `rating`) VALUES (2, 'Overwatch', 'Team-based multiplayer first-person shooter video game', 'FPS', 40.00, 'T');
INSERT INTO `game` (`id`, `name`, `description`, `genre`, `msrp`, `rating`) VALUES (3, 'NieR: Automata', 'Third-person action RPG', 'RPG', 59.99, 'M');
INSERT INTO `game` (`id`, `name`, `description`, `genre`, `msrp`, `rating`) VALUES (4, 'NBA 2K17', 'Newest installment in the NBA 2k franchise', 'Sports', 41.99, 'E');
INSERT INTO `game` (`id`, `name`, `description`, `genre`, `msrp`, `rating`) VALUES (5, 'Ghost Recon Wildlands', 'Ultimate military shooter set in a massive open world', 'FPS', 59.99, 'M');
INSERT INTO `game` (`id`, `name`, `description`, `genre`, `msrp`, `rating`) VALUES (6, 'Guild Wars 2: Heart of Thorns', 'Fantasy massive multiplayer online roleplaying game set in Tyria', 'MMO', 24.97, 'T');
INSERT INTO `game` (`id`, `name`, `description`, `genre`, `msrp`, `rating`) VALUES (7, 'Sid Meier\'s Civilization VI', 'Turn-based strategy game to build your own empire', 'RTD', 59.99, 'E');
INSERT INTO `game` (`id`, `name`, `description`, `genre`, `msrp`, `rating`) VALUES (8, 'BioShock', 'Action game to solve the mystery behind a sinister underwater city', 'Action', 4.99, 'M');
INSERT INTO `game` (`id`, `name`, `description`, `genre`, `msrp`, `rating`) VALUES (9, 'The Elder Scrolls V: Skyrim', 'The Elder Scrolls V: Skyrim, Open-world epic fantasy RPG', 'RPG', 9, 'M');
INSERT INTO `game` (`id`, `name`, `description`, `genre`, `msrp`, `rating`) VALUES (10, 'The Forest', 'Open-world horror survival game', 'Action', 14.99, 'U');

COMMIT;


-- -----------------------------------------------------
-- Data for table `vendor`
-- -----------------------------------------------------
START TRANSACTION;
USE `GameDataBase`;
INSERT INTO `vendor` (`id`, `name`) VALUES (1, 'GameStop');
INSERT INTO `vendor` (`id`, `name`) VALUES (2, 'Walmart');
INSERT INTO `vendor` (`id`, `name`) VALUES (3, 'Target');

COMMIT;


-- -----------------------------------------------------
-- Data for table `customer`
-- -----------------------------------------------------
START TRANSACTION;
USE `GameDataBase`;
INSERT INTO `customer` (`id`, `firs_name`, `last_name`, `age`, `vendor_id`) VALUES (1, 'Chandan', 'Thakur', '25', 1);
INSERT INTO `customer` (`id`, `firs_name`, `last_name`, `age`, `vendor_id`) VALUES (2, 'Greg', 'Engler', '29', 1);
INSERT INTO `customer` (`id`, `firs_name`, `last_name`, `age`, `vendor_id`) VALUES (3, 'Dennis', 'Carrasquillo', '26', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `inventory`
-- -----------------------------------------------------
START TRANSACTION;
USE `GameDataBase`;
INSERT INTO `inventory` (`id`, `game_id`, `vendor_id`, `price`, `sold`) VALUES (1, 1, 1, 50, 1);
INSERT INTO `inventory` (`id`, `game_id`, `vendor_id`, `price`, `sold`) VALUES (2, 2, 1, 50, 1);
INSERT INTO `inventory` (`id`, `game_id`, `vendor_id`, `price`, `sold`) VALUES (3, 3, 1, 50, 1);
INSERT INTO `inventory` (`id`, `game_id`, `vendor_id`, `price`, `sold`) VALUES (4, 1, 1, 50, 1);

COMMIT;

