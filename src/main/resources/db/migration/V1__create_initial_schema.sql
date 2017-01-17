CREATE TABLE `inventory` (
  `id`       INTEGER              NOT NULL  AUTO_INCREMENT,
  `version`  INTEGER              NOT NULL  DEFAULT 0,
  `name`    VARCHAR(255)      UNIQUE ,
  `stock_number`  VARCHAR(10)  UNIQUE,
  `rating`   INTEGER              NULL,
  `description` VARCHAR(100)  NULL,
  `no_of_reviews` INTEGER           NULL      DEFAULT 0,
  `selling_price`    INTEGER       NULL     DEFAULT  0,
  `discount`    INTEGER           NULL      DEFAULT 0,
  `actual_price` INTEGER           NULL,
  `quantity` INTEGER              NULL  DEFAULT  0,
  `restriction` BOOLEAN       NULL      DEFAULT  FALSE ,
  PRIMARY KEY (`id`));

