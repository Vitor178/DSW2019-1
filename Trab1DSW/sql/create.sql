create table Site (
id integer not null,
email varchar(256) not null,
senha varchar(256) not null,
url varchar(256) not null,
nome varchar(256) not null,
telefone integer not null,
CONSTRAINT Livro_PK PRIMARY KEY (id));
insert into Site(id, email, senha, url, nome, telefone) values
(1,'teste@teste', '123456', 'teste.com', 'teste1', 08008080);

