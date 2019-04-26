CREATE TABLE Admin (
    cpf integer not null,
    prenome varchar(50)  not null,
    sobrenome varchar(50) not null,
    email varchar(50) not null,
    senha  varchar(50) not null,
  constraint Admin_pk primary key (cpf)
);

CREATE TABLE  Site (
    id integer not null,
    email varchar(50) not null,
    senha varchar(50) not null,
    url varchar(50) not null,
    nome varchar(50) not null,
    telefone varchar(50) not null,
  constraint Site_pk primary key (id)
);

CREATE TABLE Teatro (
    cnpj varchar(50) not null,	
    email varchar(50) not null,
    senha varchar(50) not null,
    nome varchar(50) not null,
    cidade varchar(50) not null,
  constraint Teatro_pk primary key (cnpj)
);

CREATE TABLE Promocao(
    id integer,
    cnpj varchar(50),
    preco float not null,
    nomePeca varchar(100) not null,
    dia	varchar(16) not null,
    horario varchar(16) not null, 
  constraint fk_id foreign key (id) references Site(id),
  constraint fk_cnpj foreign key (cnpj) references Teatro(cnpj)
);


Insert into Site values
(1,'site1@site.com','123456','site1.com.br', 'site1', '0800-1234'),
(2,'site2@site.com','123456','site2.com.br', 'site2', '0800-4321'),
(3,'site3@site.com','123456','site3.com.br', 'site3', '0800-8000'),
(4,'site4@site.com','123456','site4.com.br', 'site4', '0800-8080');

Insert into Teatro values
('12345678912345', 'teatro1@teatro.com', '123456', 'teatro1', 'sao carlos'),
('12345678912346', 'teatro2@teatro.com', '123456', 'teatro2', 'sao paulo'),
('12345678912347', 'teatro3@teatro.com', '123456', 'teatro3', 'catanduva'),
('12345678912348', 'teatro4@teatro.com', '123456', 'teatro4', 'são josé do rio preto');