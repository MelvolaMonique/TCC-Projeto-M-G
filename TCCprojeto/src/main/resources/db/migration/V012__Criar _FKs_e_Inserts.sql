alter table agenda add constraint FK_agenda_medico foreign key(idmedico) references medico(id);


alter table animal add constraint FK_animal_cliente foreign key(idcliente) references cliente(id);
alter table animal add constraint FK_animal_raca foreign key(idraca) references raca(id);
alter table animal add constraint Fk_animal_especie foreign key(idespecie) references especie(id);

alter table consulta add constraint FK_consulta_animal foreign key(idanimal) references animal(id);
alter table consulta add constraint FK_consulta_medico foreign key(idmedico) references medico(id);

alter table cliente add constraint Fk_cliente_cidade foreign key(idcidade) references cidade(id);


insert into medico(id,nome, telefone, CPF,RG) values
(1, 'Marcio','(14)99773-6147','905.550.860-89','30.896.574-7' )

insert into agenda(id,datahoraconsulta, idmedico) values
(1,"2000-03-13", 1);

--insert Animal

insert into animal(id, nomeanimal, idade, sexo, castracao,idcliente,idraca,idespecie) values
(1, 'alberto', '3','F','não',1,1,1);

--insert cidade

insert into cidade(id, nomecidade, estado) values
(1,'itatiba','SP',)


-- insert consulta

