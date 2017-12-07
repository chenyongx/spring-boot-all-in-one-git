DROP TABLE user IF EXISTS;

CREATE TABLE `user` (
  `id`        INT(11),
  `user_name` VARCHAR(96),
  `birthday`  DATETIME
);