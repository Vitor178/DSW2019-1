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
(1,'ingressorapido@gmail.com','123abc','ingressorapido.com.br', 'Ingresso Rápido', '0800-1234'),
(2,'assistirteatro2@gmail.com','321cba','assistirteatro.com.br', 'Assistir Teatro', '0800-4321'),
(3,'ingressonahora@gmail.com','456dfg','ingressonahora.com.br', 'Ingresso na hora', '0800-8000'),
(4,'ticketsteatros@gmail.com','123456','ticketsteatros.com.br', 'Tickets Teatros', '0800-9500');

Insert into Teatro values
('58.025.303/0001-49', 'teatroSC@gmail.com', '123456', 'Dr. Alderico Vieira Perdigão', 'São Carlos'),
('14.036.553/0001-09', 'teatroSP@gmail.com', '654321', 'Municipal de São Paulo', 'São Paulo'),
('55.793.329/0001-49', 'teatroCA@gmail.com', '159753', 'Aniz Pachá', 'catanduva'),
('79.811.601/0001-34', 'teatroRJ@gmail.com','753159','Municipal do Rio de Janeiro','Rio de Janeiro'),
('61.455.466/0001-76', 'teatroSJRP@gmail.com', '789456', 'Paulo Moura', 'São José do Rio Preto');