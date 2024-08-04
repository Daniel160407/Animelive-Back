ALTER TABLE `animelive`.`animes`
ADD COLUMN `url` VARCHAR(45) NOT NULL AFTER `description`,
CHANGE COLUMN `description` `description` VARCHAR(2000) NOT NULL ;
