create table consulta(
id int not null primary key auto_increment,
data  date,
hora  date,
historico varchar(600),
idanimal int not null,
idmedico int not null
);
