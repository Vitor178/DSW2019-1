create table Livro
(
id integer not null generated always as identity (start with 1, increment by 1),
titulo varchar(256) not null,
autor varchar(256) not null,
ano integer not null,
preco float not null,
CONSTRAINT Livro_PK PRIMARY KEY (id)
);

insert into Livro(titulo, autor, ano, preco) values 
('Ensaio sobre a Cegueira', 'José Saramago', 1995, 54.9);

insert into Livro(titulo, autor, ano, preco) values 
('Cem anos de Solidão', 'Gabriel Garcia Márquez', 1977, 59.9);

insert into Livro(titulo, autor, ano, preco) values 
('Diálogos Impossíveis', 'Luis Fernando Verissimo', 2012, 22.9);


