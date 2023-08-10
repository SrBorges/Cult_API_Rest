create table cliente(

id bigint not null auto_increment,
nome varchar(100) not null,
rg varchar(50) not null,
cpf varchar(50) not null,
email varchar(100) not null,
telefone varchar(50),
celular varchar(50) not null,
rua varchar(30) not null,
bairro varchar(30) not null,
cep varchar(30) not null,
cidade varchar(30) not null,
estado varchar(2) not null,

primary key(id)

)