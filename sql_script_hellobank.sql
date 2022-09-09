create database hellobank;

use hellobank;

CREATE TABLE `cliente` (
  `id_cliente` int not null auto_increment,
  `nome` varchar(60) not null,
  `contato` varchar(11),
  `cpf_cnpj` varchar(20) not null unique,
  `endereco` varchar(100),
  `email` varchar(50) not null,
  PRIMARY KEY (`id_cliente`)
);

CREATE TABLE `tipo_conta` (
  `id_tipo_conta` int not null auto_increment,
  `nome_tipo_conta` varchar(50) not null unique,
  PRIMARY KEY (`id_tipo_conta`)
);

CREATE TABLE `conta` (
  `id_conta` int not null auto_increment,
  `cliente` int not null,
  `saldo` float not null,
  `tipo_conta` int not null,
  PRIMARY KEY (`id_conta`),
  FOREIGN KEY (`tipo_conta`) REFERENCES `tipo_conta`(`id_tipo_conta`),
  FOREIGN KEY (`cliente`) REFERENCES `cliente`(`id_cliente`)
);

CREATE TABLE `tipo_transacao` (
  `id_tipo_transacao` int not null auto_increment,
  `nome_tipo_transacao` varchar(50) not null unique,
  PRIMARY KEY (`id_tipo_transacao`)
);

CREATE TABLE `transacao` (
  `id_transacao` int not null auto_increment,
  `conta_origem` int not null,
  `conta_destino` int,
  `data` date not null,
  `valor` float not null,
  `tipo_transacao` int not null,
  PRIMARY KEY (`id_transacao`),
  FOREIGN KEY (`tipo_transacao`) REFERENCES `tipo_transacao`(`id_tipo_transacao`),
  FOREIGN KEY (`conta_destino`) REFERENCES `conta`(`id_conta`),
  FOREIGN KEY (`conta_origem`) REFERENCES `conta`(`id_conta`)
);


