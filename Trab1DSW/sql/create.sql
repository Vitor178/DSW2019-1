CREATE TABLE Admin (
	cpf integer not null,
	prenome varchar(30)  not null,
	sobrenome varchar(30) not null,
	email varchar(30) not null,
	senha  varchar(30) not null,
  constraint admin_pk primary key (cpf)
);

create table Site (
  id integer not null,
  email varchar(256) not null,
  senha varchar(256) not null,
  url varchar(256) not null,
  nome varchar(256) not null,
  telefone integer not null,
  CONSTRAINT Livro_PK PRIMARY KEY (id));

CREATE TABLE Teatro (
  cnpj integer,	
	email varchar(30) not null,
	senha varchar(20) not null,
	nome varchar(30) not null,
	cidade varchar(30) not null,
  constraint cnpj_pk primary key (cnpj)
);

CREATE TABLE Promocao(
  id integer,
  cnpj integer,
	preco integer not null,
	nomePeca varchar(100) not null,
	dia	varchar(16) not null,
	horario varchar(16) not null, 
  constraint fk_id foreign key (id) references Site(id),
  constraint fk_cnpj foreign key (cnpj) references Teatro(cnpj)
);
