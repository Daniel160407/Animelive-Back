CREATE TABLE `animelive`.`episodes` (
  `id` INT NOT NULL,
  `anime_id` INT NOT NULL,
  `season` INT NOT NULL,
  `episode` INT NOT NULL,
  `url` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`id`));
