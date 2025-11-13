create database if not exists db_decola;
use db_decola;

create table usuario(
	id int primary key auto_increment,
    nome varchar(100) not null,
    email varchar(255) not null,
    senha varchar(255) not null
);