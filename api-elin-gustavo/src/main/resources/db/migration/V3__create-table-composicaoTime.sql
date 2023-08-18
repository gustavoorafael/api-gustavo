create table composicao(

                           id bigint not null auto_increment,
                           Id_Integrante bigint not null,
                           Id_Time bigint not null,

                           primary key (Id),
                           foreign key (Id_Integrante) references Integrante(Id),
                           foreign key (Id_Time) references Time(id)
);