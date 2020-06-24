-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema grupo1bddoo22020
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema grupo1bddoo22020
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `grupo1bddoo22020` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `grupo1bddoo22020` ;

-- -----------------------------------------------------
-- Table `grupo1bddoo22020`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo1bddoo22020`.`persona` (
  `id_persona` BIGINT NOT NULL AUTO_INCREMENT,
  `apellido` VARCHAR(255) NULL DEFAULT NULL,
  `created_at` DATETIME(6) NULL DEFAULT NULL,
  `dni` BIGINT NULL DEFAULT NULL,
  `fecha_nacimiento` DATE NULL DEFAULT NULL,
  `nombre` VARCHAR(255) NULL DEFAULT NULL,
  `updated_at` DATETIME(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id_persona`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `grupo1bddoo22020`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo1bddoo22020`.`cliente` (
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `id_persona` BIGINT NOT NULL,
  PRIMARY KEY (`id_persona`),
  CONSTRAINT `FKlbs69o9qkvv7lgn06idak3crb`
    FOREIGN KEY (`id_persona`)
    REFERENCES `grupo1bddoo22020`.`persona` (`id_persona`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `grupo1bddoo22020`.`local`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo1bddoo22020`.`local` (
  `id_local` BIGINT NOT NULL AUTO_INCREMENT,
  `direccion` VARCHAR(255) NULL DEFAULT NULL,
  `latitud` FLOAT NULL DEFAULT NULL,
  `longitud` FLOAT NULL DEFAULT NULL,
  `telefono` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id_local`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `grupo1bddoo22020`.`clienteporlocal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo1bddoo22020`.`clienteporlocal` (
  `id_persona` BIGINT NOT NULL,
  `id_local` BIGINT NOT NULL,
  PRIMARY KEY (`id_persona`, `id_local`),
  INDEX `FKaneyho44iiy7pouwiadcu6kp0` (`id_local` ASC) VISIBLE,
  CONSTRAINT `FK3mfgugi7gp0nixh8tuw2rkvgk`
    FOREIGN KEY (`id_persona`)
    REFERENCES `grupo1bddoo22020`.`cliente` (`id_persona`),
  CONSTRAINT `FKaneyho44iiy7pouwiadcu6kp0`
    FOREIGN KEY (`id_local`)
    REFERENCES `grupo1bddoo22020`.`local` (`id_local`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `grupo1bddoo22020`.`empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo1bddoo22020`.`empleado` (
  `comision` FLOAT NULL DEFAULT NULL,
  `gerente` BIT(1) NULL DEFAULT NULL,
  `horario_trabajoe` TIME NULL DEFAULT NULL,
  `horario_trabajos` TIME NULL DEFAULT NULL,
  `sueldo_basico` FLOAT NULL DEFAULT NULL,
  `id_persona` BIGINT NOT NULL,
  `id_local` BIGINT NOT NULL,
  PRIMARY KEY (`id_persona`),
  INDEX `FKhhawk216si6sv711n1sbmyxum` (`id_local` ASC) VISIBLE,
  CONSTRAINT `FK3yo5m2sf91t2spkatlwxagm5x`
    FOREIGN KEY (`id_persona`)
    REFERENCES `grupo1bddoo22020`.`persona` (`id_persona`),
  CONSTRAINT `FKhhawk216si6sv711n1sbmyxum`
    FOREIGN KEY (`id_local`)
    REFERENCES `grupo1bddoo22020`.`local` (`id_local`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `grupo1bddoo22020`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo1bddoo22020`.`producto` (
  `id_producto` BIGINT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(255) NOT NULL,
  `fecha_alta` DATE NULL DEFAULT NULL,
  `nombre` VARCHAR(255) NOT NULL,
  `precio_unitario` FLOAT NOT NULL,
  PRIMARY KEY (`id_producto`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `grupo1bddoo22020`.`lote`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo1bddoo22020`.`lote` (
  `id_lote` BIGINT NOT NULL AUTO_INCREMENT,
  `activo` BIT(1) NULL DEFAULT NULL,
  `cantidad_actual` INT NULL DEFAULT NULL,
  `cantidad_ingreso` INT NULL DEFAULT NULL,
  `fecha_ingreso` DATE NULL DEFAULT NULL,
  `local_id` BIGINT NOT NULL,
  `producto_id_producto` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id_lote`),
  INDEX `FKs3kgkykj1afd80g8urht532jn` (`local_id` ASC) VISIBLE,
  INDEX `FKwxvc6m52c8dknmu27ylt62su` (`producto_id_producto` ASC) VISIBLE,
  CONSTRAINT `FKs3kgkykj1afd80g8urht532jn`
    FOREIGN KEY (`local_id`)
    REFERENCES `grupo1bddoo22020`.`local` (`id_local`),
  CONSTRAINT `FKwxvc6m52c8dknmu27ylt62su`
    FOREIGN KEY (`producto_id_producto`)
    REFERENCES `grupo1bddoo22020`.`producto` (`id_producto`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `grupo1bddoo22020`.`venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo1bddoo22020`.`venta` (
  `id_venta` BIGINT NOT NULL AUTO_INCREMENT,
  `pedido_id_pedido` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id_venta`),
  INDEX `FKm5at25s4gkicj814dw4dawfcn` (`pedido_id_pedido` ASC) VISIBLE,
  CONSTRAINT `FKm5at25s4gkicj814dw4dawfcn`
    FOREIGN KEY (`pedido_id_pedido`)
    REFERENCES `grupo1bddoo22020`.`pedido` (`id_pedido`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `grupo1bddoo22020`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo1bddoo22020`.`pedido` (
  `id_pedido` BIGINT NOT NULL AUTO_INCREMENT,
  `cantidad` INT NULL DEFAULT NULL,
  `fecha_pedido` DATE NULL DEFAULT NULL,
  `precio_total` FLOAT NULL DEFAULT NULL,
  `resuelto` BIT(1) NULL DEFAULT NULL,
  `cliente_id_persona` BIGINT NULL DEFAULT NULL,
  `empleado_id_persona` BIGINT NULL DEFAULT NULL,
  `local_id_local` BIGINT NULL DEFAULT NULL,
  `producto_id_producto` BIGINT NULL DEFAULT NULL,
  `venta_id_venta` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id_pedido`),
  INDEX `FKee9kmfvfpfbidx3ssf0fbg502` (`cliente_id_persona` ASC) VISIBLE,
  INDEX `FKbwvmqyu2hggqc18oamclxjv6a` (`empleado_id_persona` ASC) VISIBLE,
  INDEX `FK9gupdgw8kr68omepwge9wcjb7` (`local_id_local` ASC) VISIBLE,
  INDEX `FKhwr210k74q8di57sc14qi1w4m` (`producto_id_producto` ASC) VISIBLE,
  INDEX `FK6dv02hyv9hd0pom9gn8994yr3` (`venta_id_venta` ASC) VISIBLE,
  CONSTRAINT `FK6dv02hyv9hd0pom9gn8994yr3`
    FOREIGN KEY (`venta_id_venta`)
    REFERENCES `grupo1bddoo22020`.`venta` (`id_venta`),
  CONSTRAINT `FK9gupdgw8kr68omepwge9wcjb7`
    FOREIGN KEY (`local_id_local`)
    REFERENCES `grupo1bddoo22020`.`local` (`id_local`),
  CONSTRAINT `FKbwvmqyu2hggqc18oamclxjv6a`
    FOREIGN KEY (`empleado_id_persona`)
    REFERENCES `grupo1bddoo22020`.`empleado` (`id_persona`),
  CONSTRAINT `FKee9kmfvfpfbidx3ssf0fbg502`
    FOREIGN KEY (`cliente_id_persona`)
    REFERENCES `grupo1bddoo22020`.`cliente` (`id_persona`),
  CONSTRAINT `FKhwr210k74q8di57sc14qi1w4m`
    FOREIGN KEY (`producto_id_producto`)
    REFERENCES `grupo1bddoo22020`.`producto` (`id_producto`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `grupo1bddoo22020`.`pedido_vendido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo1bddoo22020`.`pedido_vendido` (
  `id_pedido_vendido` BIGINT NOT NULL AUTO_INCREMENT,
  `venta_id_venta` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id_pedido_vendido`),
  INDEX `FK13s6jei27dadn1blns5cdc7f8` (`venta_id_venta` ASC) VISIBLE,
  CONSTRAINT `FK13s6jei27dadn1blns5cdc7f8`
    FOREIGN KEY (`venta_id_venta`)
    REFERENCES `grupo1bddoo22020`.`venta` (`id_venta`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `grupo1bddoo22020`.`solicitud_stock`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo1bddoo22020`.`solicitud_stock` (
  `id_solicitud_stock` BIGINT NOT NULL AUTO_INCREMENT,
  `aceptado` BIT(1) NULL DEFAULT NULL,
  `activo` BIT(1) NULL DEFAULT NULL,
  `cantidad` INT NULL DEFAULT NULL,
  `fecha_solicitud_stock` DATE NULL DEFAULT NULL,
  `colaborador_id_persona` BIGINT NULL DEFAULT NULL,
  `empleado_id_persona` BIGINT NULL DEFAULT NULL,
  `local_id_local` BIGINT NULL DEFAULT NULL,
  `local2_id_local` BIGINT NULL DEFAULT NULL,
  `id_producto` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id_solicitud_stock`),
  INDEX `FKdesh31f8bo722m0eiy5gjfje6` (`colaborador_id_persona` ASC) VISIBLE,
  INDEX `FK5oukl4swgl8yk0fj0rn93rrxb` (`empleado_id_persona` ASC) VISIBLE,
  INDEX `FK6d329iev8ybwdp0qxedpk476h` (`local_id_local` ASC) VISIBLE,
  INDEX `FK8q6ty5v9p1gudp9i942c9d55o` (`local2_id_local` ASC) VISIBLE,
  INDEX `FKdetvoltsnhq2kmtgru679jg9r` (`id_producto` ASC) VISIBLE,
  CONSTRAINT `FK5oukl4swgl8yk0fj0rn93rrxb`
    FOREIGN KEY (`empleado_id_persona`)
    REFERENCES `grupo1bddoo22020`.`empleado` (`id_persona`),
  CONSTRAINT `FK6d329iev8ybwdp0qxedpk476h`
    FOREIGN KEY (`local_id_local`)
    REFERENCES `grupo1bddoo22020`.`local` (`id_local`),
  CONSTRAINT `FK8q6ty5v9p1gudp9i942c9d55o`
    FOREIGN KEY (`local2_id_local`)
    REFERENCES `grupo1bddoo22020`.`local` (`id_local`),
  CONSTRAINT `FKdesh31f8bo722m0eiy5gjfje6`
    FOREIGN KEY (`colaborador_id_persona`)
    REFERENCES `grupo1bddoo22020`.`empleado` (`id_persona`),
  CONSTRAINT `FKdetvoltsnhq2kmtgru679jg9r`
    FOREIGN KEY (`id_producto`)
    REFERENCES `grupo1bddoo22020`.`producto` (`id_producto`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `grupo1bddoo22020`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo1bddoo22020`.`user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `createdat` DATETIME(6) NULL DEFAULT NULL,
  `enabled` BIT(1) NULL DEFAULT NULL,
  `password` LONGTEXT NULL DEFAULT NULL,
  `updatedat` DATETIME(6) NULL DEFAULT NULL,
  `username` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `grupo1bddoo22020`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo1bddoo22020`.`user_role` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `createdat` DATETIME(6) NULL DEFAULT NULL,
  `role` VARCHAR(100) NOT NULL,
  `updatedat` DATETIME(6) NULL DEFAULT NULL,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UKscfpive7aa0o9savdwmxmnaij` (`role` ASC, `user_id` ASC) VISIBLE,
  INDEX `FK859n2jvi8ivhui0rl0esws6o` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o`
    FOREIGN KEY (`user_id`)
    REFERENCES `grupo1bddoo22020`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `grupo1bddoo22020`.`venta_pedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo1bddoo22020`.`venta_pedidos` (
  `venta_id_venta` BIGINT NOT NULL,
  `pedidos_id_pedido_vendido` BIGINT NOT NULL,
  PRIMARY KEY (`venta_id_venta`, `pedidos_id_pedido_vendido`),
  UNIQUE INDEX `UK_iq6avqwykr13wq7qsshnxt10o` (`pedidos_id_pedido_vendido` ASC) VISIBLE,
  CONSTRAINT `FKl483upx9b3n6xbvuw5mbwu1ss`
    FOREIGN KEY (`venta_id_venta`)
    REFERENCES `grupo1bddoo22020`.`venta` (`id_venta`),
  CONSTRAINT `FKpujh870li91ny8kxtt153jb4g`
    FOREIGN KEY (`pedidos_id_pedido_vendido`)
    REFERENCES `grupo1bddoo22020`.`pedido_vendido` (`id_pedido_vendido`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


select * from pedido;
select * from persona;
select * from cliente;
select * from empleado;
select * from local;
select * from producto;
select * from user;
select * from user_role;

alter table user change password password longtext;

insert into `user` (id, createdat, enabled, password, updatedat, username) values (1, '2011-12-18 12:31:00' ,true, "$2a$04$9E7vRmwUmgdX.2GwnKL7BehJWV3/F5wm3Utm1zCAnbIxjMkbHlKGK", '2011-12-18 12:31:00' ,"admin");

insert into user_role (id, createdat, role, updatedat, user_id) values (1, '2011-12-18 12:31:00' ,"administrador", '2011-12-18 12:31:00', 1);

drop table user_role;
drop table user;


show tables;