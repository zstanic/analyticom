CREATE TABLE `analyticomdb`.`countries` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `intCode` VARCHAR(10) NULL,
  `name` VARCHAR(200) NULL,
  PRIMARY KEY (`id`));

  
  CREATE TABLE `analyticomdb`.`clubs` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NULL,
  `type` VARCHAR(10) NULL,
  PRIMARY KEY (`id`));

  
  CREATE TABLE `analyticomdb`.`players` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `dateOfBirth` DATETIME NULL,
  `firstName` VARCHAR(60) NULL,
  `lastName` VARCHAR(120) NULL,
  `placeOfBirth` VARCHAR(60) NULL,
  `uniqueID` VARCHAR(30) NULL,
  `country_id` BIGINT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `uniqueID_UNIQUE` (`uniqueID` ASC),
  CONSTRAINT `country_id`
    FOREIGN KEY (`country_id`)
    REFERENCES `analyticomdb`.`countries` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

	CREATE TABLE `analyticomdb`.`playerregistrations` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `dateFrom` DATETIME NULL,
  `dateTo` DATETIME NULL,
  `club_id` BIGINT NULL,
  `player_id` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `player_id_idx` (`player_id` ASC),
  INDEX `club_id_idx` (`club_id` ASC),
  CONSTRAINT `club_id`
    FOREIGN KEY (`club_id`)
    REFERENCES `analyticomdb`.`clubs` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `player_id`
    FOREIGN KEY (`player_id`)
    REFERENCES `analyticomdb`.`players` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

	
INSERT INTO `analyticomdb`.`clubs` (`name`) VALUES ('NK Dinamo');
INSERT INTO `analyticomdb`.`clubs` (`name`) VALUES ('NK Hajduk');
INSERT INTO `analyticomdb`.`clubs` (`name`) VALUES ('NK Osijek');
INSERT INTO `analyticomdb`.`clubs` (`name`) VALUES ('NK Rijeka');
INSERT INTO `analyticomdb`.`clubs` (`name`) VALUES ('NK Varteks');
INSERT INTO `analyticomdb`.`clubs` (`name`) VALUES ('NK Split');

INSERT INTO `analyticomdb`.`countries` (`intCode`, `name`) VALUES ('385', 'Croatia');
INSERT INTO `analyticomdb`.`countries` (`intCode`, `name`) VALUES ('386', 'BIH');
INSERT INTO `analyticomdb`.`countries` (`intCode`, `name`) VALUES ('01', 'USA');

