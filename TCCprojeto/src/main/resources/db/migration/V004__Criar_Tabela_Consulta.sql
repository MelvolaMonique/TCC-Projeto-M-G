create table consulta(
id int not null primary key auto_increment,
datahoraconsulta  date,
historico varchar(600),
idanimal int not null,
idmedico int not null
);
