-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`customer` (
  `Id` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`Id`));


-- -----------------------------------------------------
-- Table `mydb`.`comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`comments` (
  `id` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `meseng` VARCHAR(45) NOT NULL,
  `customer_Id` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comments_customer1_idx` (`customer_Id` ASC) VISIBLE,
  CONSTRAINT `fk_comments_customer1`
    FOREIGN KEY (`customer_Id`)
    REFERENCES `mydb`.`customer` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`Seller`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Seller` (
  `Id` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `Last_name` VARCHAR(45) NOT NULL,
  `phone_number` INT NOT NULL,
  PRIMARY KEY (`Id`));


-- -----------------------------------------------------
-- Table `mydb`.`car`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`car` (
  `id` INT NOT NULL,
  `brand` VARCHAR(45) NOT NULL,
  `graduathion_year` VARCHAR(45) NOT NULL,
  `ser_num` INT NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `new` TINYINT NOT NULL,
  `sold` TINYINT NULL,
  `comments_id` INT NOT NULL,
  `Seller_Id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_car_comments1_idx` (`comments_id` ASC) VISIBLE,
  INDEX `fk_car_Seller1_idx` (`Seller_Id` ASC) VISIBLE,
  CONSTRAINT `fk_car_comments1`
    FOREIGN KEY (`comments_id`)
    REFERENCES `mydb`.`comments` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_car_Seller1`
    FOREIGN KEY (`Seller_Id`)
    REFERENCES `mydb`.`Seller` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`characteristic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`characteristic` (
  `category_id` INT NOT NULL,
  `Engine` VARCHAR(45) NOT NULL,
  `Drive` VARCHAR(45) NOT NULL,
  `Color` VARCHAR(45) NOT NULL,
  `Car_body` VARCHAR(45) NOT NULL,
  `Transmission` VARCHAR(45) NOT NULL,
  `car_id` INT NOT NULL,
  PRIMARY KEY (`category_id`),
  INDEX `fk_characteristic_car1_idx` (`car_id` ASC) VISIBLE,
  CONSTRAINT `fk_characteristic_car1`
    FOREIGN KEY (`car_id`)
    REFERENCES `mydb`.`car` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`Сar_dealership`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Сar_dealership` (
  `Id` TIMESTAMP NOT NULL COMMENT '\n',
  `Address` VARCHAR(45) NOT NULL,
  `Site` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `car_id` INT NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_Сar_dealership_car1_idx` (`car_id` ASC) VISIBLE,
  CONSTRAINT `fk_Сar_dealership_car1`
    FOREIGN KEY (`car_id`)
    REFERENCES `mydb`.`car` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`Test_drive`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Test_drive` (
  `Id` VARCHAR(16) NOT NULL,
  `car_id` INT NOT NULL,
  `Brand` VARCHAR(45) NOT NULL,
  `model` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_Test_car_idx` (`car_id` ASC) VISIBLE,
  CONSTRAINT `fk_Test_car`
    FOREIGN KEY (`car_id`)
    REFERENCES `mydb`.`car` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`site`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`site` (
  `id_site` INT NOT NULL,
  `Seller_Sellercol` VARCHAR(45) NOT NULL,
  `Сar_dealership_Id` TIMESTAMP NOT NULL,
  `car_id` INT NOT NULL,
  PRIMARY KEY (`id_site`),
  INDEX `fk_site_Seller1_idx` (`Seller_Sellercol` ASC) VISIBLE,
  INDEX `fk_site_Сar_dealership1_idx` (`Сar_dealership_Id` ASC) VISIBLE,
  INDEX `fk_site_car1_idx` (`car_id` ASC) VISIBLE,
  CONSTRAINT `fk_site_Seller1`
    FOREIGN KEY (`Seller_Sellercol`)
    REFERENCES `mydb`.`Seller` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_site_Сar_dealership1`
    FOREIGN KEY (`Сar_dealership_Id`)
    REFERENCES `mydb`.`Сar_dealership` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_site_car1`
    FOREIGN KEY (`car_id`)
    REFERENCES `mydb`.`car` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
