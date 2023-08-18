create table integrante(

                           id bigint not null auto_increment,
                           franquia varchar(100) not null,
                           nome varchar(100) not null,
                           funcao varchar(100) not null unique,
                           composicao varchar(100) not null unique,

                           primary key(id)

);
