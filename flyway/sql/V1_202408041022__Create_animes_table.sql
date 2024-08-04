CREATE TABLE `animelive`.`animes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `episodes` VARCHAR(45) NOT NULL,
  `ganre` VARCHAR(45) NOT NULL,
  `release_time` VARCHAR(45) NOT NULL,
  `studio` VARCHAR(45) NOT NULL,
  `age_restriction` VARCHAR(45) NOT NULL,
  `episode_duration` VARCHAR(45) NOT NULL,
  `imdb` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
