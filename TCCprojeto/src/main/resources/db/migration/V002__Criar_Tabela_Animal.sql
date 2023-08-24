CREATE table animal(
id int not null primary key auto_increment,
nomeanimal varchar(100),
idade varchar (10),
sexo varchar(1),
castracao varchar(3),
idcliente int not null,
idraca int not null,
idespecie int not null
 );
