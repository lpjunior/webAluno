create schema if not exists dbsublog;

use dbsublog;

drop table if exists alunos;

create table aluno(
	id bigint primary key auto_increment,
	matricula varchar(20) unique not null,
	nome varchar(200) not null,
	email varchar(150) not null,
	telefone varchar(15) not null
);