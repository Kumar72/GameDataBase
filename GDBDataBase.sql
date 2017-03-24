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
-- Table `customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `customer` ;

CREATE TABLE IF NOT EXISTS `customer` (
  `id` INT NOT NULL,
  `firs_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `age` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vendor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vendor` ;

CREATE TABLE IF NOT EXISTS `vendor` (
  `id` INT NOT NULL,
  `price` DOUBLE NOT NULL,
  `customer_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_vendor_customer_idx` (`customer_id` ASC),
  CONSTRAINT `fk_vendor_customer`
    FOREIGN KEY (`customer_id`)
    REFERENCES `customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


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
  `vendor_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_developer_vendor_idx` (`vendor_id` ASC),
  CONSTRAINT `fk_developer_vendor`
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
