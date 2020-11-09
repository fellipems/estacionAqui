-- MySQL Script generated by MySQL Workbench
-- Mon Nov  9 02:21:29 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema estacionamento
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema estacionamento
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `estacionamento` DEFAULT CHARACTER SET utf8 ;
USE `estacionamento` ;

-- -----------------------------------------------------
-- Table `estacionamento`.`TIPO_VEICULO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estacionamento`.`TIPO_VEICULO` (
  `id_tipo` INT NOT NULL,
  `preco_tipo` DECIMAL NOT NULL,
  `tipo` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_tipo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estacionamento`.`TICKET`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estacionamento`.`TICKET` (
  `id_ticket` BIGINT NOT NULL,
  `hora_entrada` DATETIME NOT NULL,
  `hora_saida` DATETIME NOT NULL,
  `placa` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_ticket`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estacionamento`.`VEICULO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estacionamento`.`VEICULO` (
  `id_veiculo` INT NOT NULL,
  `placa` VARCHAR(8) NOT NULL,
  `cor` VARCHAR(45) NULL,
  `ano_veiculo` YEAR NULL,
  `nome_modelo` VARCHAR(45) NULL,
  `marca` VARCHAR(45) NULL,
  `TIPO_VEICULO_id_veiculo` INT NOT NULL,
  `TICKET_id_ticket` BIGINT NOT NULL,
  PRIMARY KEY (`id_veiculo`),
  INDEX `fk_VEICULO_TIPO_VEICULO_idx` (`TIPO_VEICULO_id_veiculo` ASC) VISIBLE,
  UNIQUE INDEX `placa_UNIQUE` (`placa` ASC) VISIBLE,
  INDEX `fk_VEICULO_TICKET1_idx` (`TICKET_id_ticket` ASC) VISIBLE,
  CONSTRAINT `fk_VEICULO_TIPO_VEICULO`
    FOREIGN KEY (`TIPO_VEICULO_id_veiculo`)
    REFERENCES `estacionamento`.`TIPO_VEICULO` (`id_tipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_VEICULO_TICKET1`
    FOREIGN KEY (`TICKET_id_ticket`)
    REFERENCES `estacionamento`.`TICKET` (`id_ticket`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estacionamento`.`CLIENTE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estacionamento`.`CLIENTE` (
  `id_cliente` INT NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `nome_cliente` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(60) NULL,
  `VEICULO_id_veiculo` INT NOT NULL,
  PRIMARY KEY (`id_cliente`),
  INDEX `fk_CLIENTE_VEICULO1_idx` (`VEICULO_id_veiculo` ASC) VISIBLE,
  CONSTRAINT `fk_CLIENTE_VEICULO1`
    FOREIGN KEY (`VEICULO_id_veiculo`)
    REFERENCES `estacionamento`.`VEICULO` (`id_veiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estacionamento`.`RESPONSAVEL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estacionamento`.`RESPONSAVEL` (
  `id_responsavel` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(50) NOT NULL,
  `cargo` VARCHAR(20) NULL,
  `cpf` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`id_responsavel`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estacionamento`.`ESTACIONAMENTO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estacionamento`.`ESTACIONAMENTO` (
  `id_estacionamento` INT NOT NULL,
  `qtd_vagas` INT NULL,
  `status_vaga` VARCHAR(45) NULL,
  `RESPONSAVEL_id_responsavel` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_estacionamento`),
  INDEX `fk_ESTACIONAMENTO_RESPONSAVEL1_idx` (`RESPONSAVEL_id_responsavel` ASC) VISIBLE,
  CONSTRAINT `fk_ESTACIONAMENTO_RESPONSAVEL1`
    FOREIGN KEY (`RESPONSAVEL_id_responsavel`)
    REFERENCES `estacionamento`.`RESPONSAVEL` (`id_responsavel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `estacionamento`.`VAGA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estacionamento`.`VAGA` (
  `id_vaga` INT NOT NULL,
  `num_vaga` VARCHAR(45) NOT NULL,
  `tipo_vaga` VARCHAR(45) NULL,
  `status` TINYINT NULL,
  `ESTACIONAMENTO_id_estacionamento` INT NOT NULL,
  `VEICULO_id_veiculo` INT NOT NULL,
  PRIMARY KEY (`id_vaga`),
  INDEX `fk_VAGA_ESTACIONAMENTO1_idx` (`ESTACIONAMENTO_id_estacionamento` ASC) VISIBLE,
  INDEX `fk_VAGA_VEICULO1_idx` (`VEICULO_id_veiculo` ASC) VISIBLE,
  CONSTRAINT `fk_VAGA_ESTACIONAMENTO1`
    FOREIGN KEY (`ESTACIONAMENTO_id_estacionamento`)
    REFERENCES `estacionamento`.`ESTACIONAMENTO` (`id_estacionamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_VAGA_VEICULO1`
    FOREIGN KEY (`VEICULO_id_veiculo`)
    REFERENCES `estacionamento`.`VEICULO` (`id_veiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
