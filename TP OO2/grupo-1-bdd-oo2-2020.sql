-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema grupo-1-bdd-oo2-2020
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema grupo-1-bdd-oo2-2020
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `grupo-1-bdd-oo2-2020` DEFAULT CHARACTER SET utf8 ;
USE `grupo-1-bdd-oo2-2020` ;

-- -----------------------------------------------------
-- Table `grupo-1-bdd-oo2-2020`.`Local`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo-1-bdd-oo2-2020`.`Local` (
  `idLocal` INT NOT NULL AUTO_INCREMENT,
  `telefono` BIGINT(12) NULL DEFAULT NULL,
  `direccion` VARCHAR(45) NULL DEFAULT NULL,
  `latitud` FLOAT NULL DEFAULT NULL,
  `longitud` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`idLocal`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo-1-bdd-oo2-2020`.`Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo-1-bdd-oo2-2020`.`Producto` (
  `idProducto` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL,
  `precioUnitario` FLOAT NULL DEFAULT NULL,
  `fechaAlta` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`idProducto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo-1-bdd-oo2-2020`.`Lote`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo-1-bdd-oo2-2020`.`Lote` (
  `idLote` INT NOT NULL AUTO_INCREMENT,
  `fechaIngreso` DATE NULL DEFAULT NULL,
  `cantidadIngreso` INT NULL DEFAULT NULL,
  `cantidadActual` INT NULL DEFAULT NULL,
  `activo` BIT NULL DEFAULT 0,
  `producto` INT NOT NULL,
  `local` INT NOT NULL,
  PRIMARY KEY (`idLote`),
  INDEX `fk_Lote_Producto_idx` (`producto` ASC),
  INDEX `fk_Lote_Local1_idx` (`local` ASC),
  CONSTRAINT `fk_Lote_Producto`
    FOREIGN KEY (`producto`)
    REFERENCES `grupo-1-bdd-oo2-2020`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Lote_Local1`
    FOREIGN KEY (`local`)
    REFERENCES `grupo-1-bdd-oo2-2020`.`Local` (`idLocal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo-1-bdd-oo2-2020`.`Persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo-1-bdd-oo2-2020`.`Persona` (
  `idPersona` INT NOT NULL AUTO_INCREMENT,
  `dni` BIGINT(10) NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `fechaNacimiento` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`idPersona`),
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo-1-bdd-oo2-2020`.`Empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo-1-bdd-oo2-2020`.`Empleado` (
  `idEmpleado` INT NOT NULL,
  `sueldoBasico` FLOAT NULL DEFAULT NULL,
  `comision` FLOAT NULL DEFAULT 0,
  `horarioTrabajoE` TIME NULL,
  `horarioTrabajoS` TIME NULL,
  `gerente` BIT NULL,
  `local` INT NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  INDEX `fk_Empleado_Persona1_idx` (`idEmpleado` ASC),
  INDEX `fk_Empleado_Local1_idx` (`local` ASC),
  CONSTRAINT `fk_Empleado_Persona1`
    FOREIGN KEY (`idEmpleado`)
    REFERENCES `grupo-1-bdd-oo2-2020`.`Persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_Local1`
    FOREIGN KEY (`local`)
    REFERENCES `grupo-1-bdd-oo2-2020`.`Local` (`idLocal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo-1-bdd-oo2-2020`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo-1-bdd-oo2-2020`.`Cliente` (
  `idCliente` INT NOT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idCliente`),
  CONSTRAINT `fk_Cliente_Persona1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `grupo-1-bdd-oo2-2020`.`Persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo-1-bdd-oo2-2020`.`DetalleVenta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo-1-bdd-oo2-2020`.`DetalleVenta` (
  `idDetalleVenta` INT NOT NULL,
  `producto` INT NOT NULL,
  `cantidad` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idDetalleVenta`),
  INDEX `fk_DetalleVenta_Producto1_idx` (`producto` ASC),
  CONSTRAINT `fk_DetalleVenta_Producto1`
    FOREIGN KEY (`producto`)
    REFERENCES `grupo-1-bdd-oo2-2020`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo-1-bdd-oo2-2020`.`Venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo-1-bdd-oo2-2020`.`Venta` (
  `idVenta` INT NOT NULL,
  `fechaActual` DATE NULL,
  `cliente` INT NOT NULL,
  `empleado` INT NOT NULL,
  `detalleVenta` INT NOT NULL,
  PRIMARY KEY (`idVenta`),
  INDEX `fk_Venta_Cliente1_idx` (`cliente` ASC),
  INDEX `fk_Venta_Empleado1_idx` (`empleado` ASC),
  INDEX `fk_Venta_DetalleVenta1_idx` (`detalleVenta` ASC),
  CONSTRAINT `fk_Venta_Cliente1`
    FOREIGN KEY (`cliente`)
    REFERENCES `grupo-1-bdd-oo2-2020`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venta_Empleado1`
    FOREIGN KEY (`empleado`)
    REFERENCES `grupo-1-bdd-oo2-2020`.`Empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venta_DetalleVenta1`
    FOREIGN KEY (`detalleVenta`)
    REFERENCES `grupo-1-bdd-oo2-2020`.`DetalleVenta` (`idDetalleVenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo-1-bdd-oo2-2020`.`SolicitudStock`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo-1-bdd-oo2-2020`.`SolicitudStock` (
  `idSolicitudStock` INT NOT NULL,
  `fecha` DATE NULL DEFAULT NULL,
  `producto` INT NOT NULL,
  `cantidad` INT NULL DEFAULT NULL,
  `empleadoVendedor` INT NOT NULL,
  `empleadoColaborador` INT NOT NULL,
  `aceptado` BIT NULL,
  PRIMARY KEY (`idSolicitudStock`),
  INDEX `fk_SolicitudStock_Producto1_idx` (`producto` ASC),
  INDEX `fk_SolicitudStock_Empleado1_idx` (`empleadoVendedor` ASC),
  INDEX `fk_SolicitudStock_Empleado2_idx` (`empleadoColaborador` ASC),
  UNIQUE INDEX `empleadoVendedor_UNIQUE` (`empleadoVendedor` ASC),
  UNIQUE INDEX `empleadoColaborador_UNIQUE` (`empleadoColaborador` ASC),
  CONSTRAINT `fk_SolicitudStock_Producto1`
    FOREIGN KEY (`producto`)
    REFERENCES `grupo-1-bdd-oo2-2020`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SolicitudStock_Empleado1`
    FOREIGN KEY (`empleadoVendedor`)
    REFERENCES `grupo-1-bdd-oo2-2020`.`Empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SolicitudStock_Empleado2`
    FOREIGN KEY (`empleadoColaborador`)
    REFERENCES `grupo-1-bdd-oo2-2020`.`Empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
