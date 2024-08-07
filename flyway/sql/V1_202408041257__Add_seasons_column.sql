ALTER TABLE `animelive`.`animes`
ADD COLUMN `seasons` INT NOT NULL AFTER `name`,
CHANGE COLUMN `episodes` `episodes` INT NOT NULL ,
CHANGE COLUMN `description` `description` VARCHAR(2000) NOT NULL ;
