DROP DATABASE IF EXISTS `product_users_database`;
CREATE DATABASE `product_users_database`;

USE `product_users_database`;

CREATE TABLE `product_table` (
    `id_product` INT NOT NULL AUTO_INCREMENT,
    `name_product` VARCHAR(50) NOT NULL,
    `value_product` DOUBLE,
    PRIMARY KEY (`id_product`)
)