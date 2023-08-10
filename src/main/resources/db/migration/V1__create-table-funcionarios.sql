create table funcionarios(

id bigint not null auto_increment,
nome varchar(100) not null,
idade varchar(3) not null,
cpf varchar(30) not null,
dnascimento varchar(20) not null,
salario numeric(20, 2) not null,
funcao varchar(60) not null,

primary key(id)

)