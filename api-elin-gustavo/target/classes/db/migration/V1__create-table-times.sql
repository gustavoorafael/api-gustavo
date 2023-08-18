create table time(

                        id bigint not null auto_increment,
                        time varchar(100) not null,
                        data varchar(100) not null unique,

                        primary key(id)

);