create table livro(

id bigint not null auto_increment,
titulo varchar(250) not null,
autor varchar(100) not null,
formato varchar(50) not null,
editor varchar(60) not null,
ano varchar(10) not null,
npaginas varchar(30) not null,
codigo varchar(30) not null,

primary key(id)

)