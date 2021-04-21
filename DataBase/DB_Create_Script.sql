-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema books_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `books_db` ;

-- -----------------------------------------------------
-- Schema books_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `books_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `books_db` ;

-- -----------------------------------------------------
-- Table `books_db`.`Role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `books_db`.`Role` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `books_db`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `books_db`.`User` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Nickname` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Role_Id` INT NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_User_Role1_idx` (`Role_Id` ASC) VISIBLE,
  CONSTRAINT `fk_User_Role1`
    FOREIGN KEY (`Role_Id`)
    REFERENCES `books_db`.`Role` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `books_db`.`Audiobook_File`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `books_db`.`Audiobook_File` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Duration` INT NOT NULL DEFAULT 0,
  `Extension` VARCHAR(45) NOT NULL,
  `File_path` VARCHAR(510) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `books_db`.`Audiobook`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `books_db`.`Audiobook` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `User_Id` INT NOT NULL,
  `Distributed` TINYINT NOT NULL DEFAULT 0,
  `Title` VARCHAR(45) NOT NULL,
  `Picture_Path` VARCHAR(500) NULL,
  `Publication_Year` INT NULL,
  `Description` VARCHAR(2100) NOT NULL,
  `Add_Date` DATETIME NOT NULL,
  `Rating` DOUBLE NOT NULL DEFAULT 0,
  `Audiobook_File_Id` INT NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_Audiobook_User_idx` (`User_Id` ASC) VISIBLE,
  INDEX `fk_Audiobook_Audiobook_File1_idx` (`Audiobook_File_Id` ASC) VISIBLE,
  CONSTRAINT `fk_Audiobook_User`
    FOREIGN KEY (`User_Id`)
    REFERENCES `books_db`.`User` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Audiobook_Audiobook_File1`
    FOREIGN KEY (`Audiobook_File_Id`)
    REFERENCES `books_db`.`Audiobook_File` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `books_db`.`Genre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `books_db`.`Genre` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `books_db`.`Creator`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `books_db`.`Creator` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(45) NOT NULL,
  `Author` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `books_db`.`Audiobook_Genre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `books_db`.`Audiobook_Genre` (
  `Audiobook_Id` INT NOT NULL,
  `Genre_Id` INT NOT NULL,
  PRIMARY KEY (`Audiobook_Id`, `Genre_Id`),
  INDEX `fk_Audiobook_has_Genre_Genre1_idx` (`Genre_Id` ASC) VISIBLE,
  INDEX `fk_Audiobook_has_Genre_Audiobook1_idx` (`Audiobook_Id` ASC) VISIBLE,
  CONSTRAINT `fk_Audiobook_has_Genre_Audiobook1`
    FOREIGN KEY (`Audiobook_Id`)
    REFERENCES `books_db`.`Audiobook` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Audiobook_has_Genre_Genre1`
    FOREIGN KEY (`Genre_Id`)
    REFERENCES `books_db`.`Genre` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `books_db`.`Audiobook_Creator`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `books_db`.`Audiobook_Creator` (
  `Audiobook_Id` INT NOT NULL,
  `Creator_Id` INT NOT NULL,
  PRIMARY KEY (`Audiobook_Id`, `Creator_Id`),
  INDEX `fk_Audiobook_has_Creator_Creator1_idx` (`Creator_Id` ASC) VISIBLE,
  INDEX `fk_Audiobook_has_Creator_Audiobook1_idx` (`Audiobook_Id` ASC) VISIBLE,
  CONSTRAINT `fk_Audiobook_has_Creator_Audiobook1`
    FOREIGN KEY (`Audiobook_Id`)
    REFERENCES `books_db`.`Audiobook` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Audiobook_has_Creator_Creator1`
    FOREIGN KEY (`Creator_Id`)
    REFERENCES `books_db`.`Creator` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `books_db`.`User_Audiobook`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `books_db`.`User_Audiobook` (
  `User_Id` INT NOT NULL,
  `Audiobook_Id` INT NOT NULL,
  PRIMARY KEY (`User_Id`, `Audiobook_Id`),
  INDEX `fk_User_has_Audiobook_Audiobook1_idx` (`Audiobook_Id` ASC) VISIBLE,
  INDEX `fk_User_has_Audiobook_User1_idx` (`User_Id` ASC) VISIBLE,
  CONSTRAINT `fk_User_has_Audiobook_User1`
    FOREIGN KEY (`User_Id`)
    REFERENCES `books_db`.`User` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Audiobook_Audiobook1`
    FOREIGN KEY (`Audiobook_Id`)
    REFERENCES `books_db`.`Audiobook` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `books_db`.`Query`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `books_db`.`Query` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Audiobook_Id` INT NOT NULL,
  `User_Id` INT NOT NULL,
  `Send_DateTime` DATETIME NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_Query_Audiobook1_idx` (`Audiobook_Id` ASC) VISIBLE,
  INDEX `fk_Query_User1_idx` (`User_Id` ASC) VISIBLE,
  CONSTRAINT `fk_Query_Audiobook1`
    FOREIGN KEY (`Audiobook_Id`)
    REFERENCES `books_db`.`Audiobook` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Query_User1`
    FOREIGN KEY (`User_Id`)
    REFERENCES `books_db`.`User` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `books_db`.`Rating`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `books_db`.`Rating` (
  `Audiobook_Id` INT NOT NULL,
  `User_Id` INT NOT NULL,
  `Value` INT NOT NULL,
  PRIMARY KEY (`Audiobook_Id`, `User_Id`),
  INDEX `fk_Audiobook_has_User_User1_idx` (`User_Id` ASC) VISIBLE,
  INDEX `fk_Audiobook_has_User_Audiobook1_idx` (`Audiobook_Id` ASC) VISIBLE,
  CONSTRAINT `fk_Audiobook_has_User_Audiobook1`
    FOREIGN KEY (`Audiobook_Id`)
    REFERENCES `books_db`.`Audiobook` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Audiobook_has_User_User1`
    FOREIGN KEY (`User_Id`)
    REFERENCES `books_db`.`User` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `books_db`.`Comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `books_db`.`Comment` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Audiobook_Id` INT NOT NULL,
  `User_Id` INT NOT NULL,
  `Text` VARCHAR(510) NOT NULL,
  `Send_DateTime` DATETIME NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_Query_Audiobook1_idx` (`Audiobook_Id` ASC) VISIBLE,
  INDEX `fk_Query_User1_idx` (`User_Id` ASC) VISIBLE,
  CONSTRAINT `fk_Query_Audiobook10`
    FOREIGN KEY (`Audiobook_Id`)
    REFERENCES `books_db`.`Audiobook` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Query_User10`
    FOREIGN KEY (`User_Id`)
    REFERENCES `books_db`.`User` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `books_db`;

DELIMITER $$
USE `books_db`$$
CREATE DEFINER = CURRENT_USER TRIGGER `books_db`.`Rating_AFTER_INSERT` AFTER INSERT ON `Rating` FOR EACH ROW
BEGIN
    UPDATE audiobook
    SET books_db.audiobook.Rating = (SELECT AVG(`value`) FROM `books_db`.`Rating`
                         WHERE `books_db`.`Rating`.audiobook_Id = audiobook.id)
    WHERE id = NEW.audiobook_Id;
END$$

USE `books_db`$$
CREATE DEFINER = CURRENT_USER TRIGGER `books_db`.`Rating_AFTER_UPDATE` AFTER UPDATE ON `Rating` FOR EACH ROW
BEGIN
    UPDATE audiobook
    SET books_db.audiobook.Rating = (SELECT AVG(`value`) FROM `books_db`.`Rating`
                         WHERE `books_db`.`Rating`.audiobook_Id = audiobook.id)
    WHERE id = NEW.audiobook_Id;
END$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
