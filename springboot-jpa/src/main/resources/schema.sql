CREATE TABLE `userRedis`
(
    `id`        bigint(20) NOT NULL AUTO_INCREMENT,
    `name`      varchar(255) DEFAULT NULL,
    `phone`     varchar(255) DEFAULT NULL,
    `avatar`    varchar(255) DEFAULT NULL,
    `nick_name` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `user`
(
    `id`        bigint(20) NOT NULL AUTO_INCREMENT,
    `name`      varchar(255) DEFAULT NULL,
    `phone`     varchar(255) DEFAULT NULL,
    `avatar`    varchar(255) DEFAULT NULL,
    `nick_name` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

