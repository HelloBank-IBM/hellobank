create database hellobank;

use hellobank;

CREATE TABLE `cliente` (
  `id_cliente` int not null auto_increment,
  `nome` varchar(60) not null,
  `senha` varchar(15) not null,
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
  `numero_conta` int not null,
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

/*Script para a Populacao dos dados*/

INSERT INTO cliente VALUES
(null, "Thiago Conceicao de Oliveira","369852147", "21987894321", "63720145999", "Rua A, Bairro A, CidadeA1-RJ", "thiago@teste.com"),
(null, "Amanda da Rocha Pitta", "698521473","71987665321", "16553786194", "Rua B, Bairro B, CidadeB2-RJ", "amanda@teste.com"),
(null, "Walderney Oliveira Azevedo","985214736", "98984354321", "14288772230", "Rua C, Bairro C CidadeC3-RJ", "walderney@teste.com"),
(null, "Cristiane Barros Cruz","852,014369" ,"21987994321", "18188223425", "Rua D, Bairro D, CidadeD4-RJ", "cristiane@teste.com"),
(null, "Natanael Carvalho de Queiroz", "521473698","71980054321", "16021023765", "Rua E, Bairro E, CidadeE5-RJ", "natanael@gteste.com"),
(null, "Marcus Vinicius Lameu Lima", "214736985","71987074321", "16411146144", "Rua F, Bairro F, CidadeF6-RJ", "marcus@teste.com"),
(null, "Wesner Souza Carvalho Filho", "147369852","71987904321", "60214647102", "Rua F, Bairro F, CidadeG7-RJ", "wesner@teste.com");

INSERT INTO tipo_conta VALUES
(null, "Corrente"),
(null, "Poupanca"),
(null, "Universitaria"),
(null, "Salario");

INSERT INTO conta VALUES
(null, 1, 07111111,300.00, 1),
(null, 2, 07122222,600.00, 2),
(null, 3, 07133333,900.00, 3),
(null, 4, 07144444,1200.00, 4),
(null, 5, 07155551,1500.00, 1),
(null, 6, 07166662,1800.00, 2),
(null, 7, 07177773,2100.00, 3);

INSERT INTO tipo_transacao VALUES
(null, "Deposito"),
(null, "Saque"),
(null, "Transferencia");

INSERT INTO transacao VALUES
(null, 1, null, "2022-09-19", 100.00, 1),
(null, 2, null, "2022-09-20", 200.00, 2),
(null, 4, 3, "2022-09-21", 300.00, 3);
