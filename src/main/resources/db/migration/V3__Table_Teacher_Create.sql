CREATE TABLE `teachers` (
  `id`        INT             NOT NULL  AUTO_INCREMENT,
  `version`   INT             NOT NULL  DEFAULT 0,
  `name`      VARCHAR(50)     NOT NULL,
  `age`       INT             NOT NULL,
  `gender`    ENUM('M', 'F')  NOT NULL,
  `created`   TIMESTAMP       NULL      DEFAULT NOW(),
  `modified`  TIMESTAMP       NULL      DEFAULT NOW(),
  PRIMARY KEY (`id`));