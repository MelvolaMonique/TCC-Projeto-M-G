alter table agenda add constraint FK_agenda_medico foreign key(idmedico) references medico(id);


alter table animal add constraint FK_animal_cliente foreign key(idcliente) references cliente(id);
alter table animal add constraint FK_animal_raca foreign key(idraca) references raca(id);
alter table animal add constraint Fk_animal_especie foreign key(idespecie) references especie(id);

alter table consulta add constraint FK_consulta_animal foreign key(idanimal) references animal(id);
alter table consulta add constraint FK_consulta_medico foreign key(idmedico) references medico(id);

alter table cliente add constraint Fk_cliente_cidade foreign key(idcidade) references cidade(id);

--insert agenda
insert into medico values
(1, 'Márcio', 14997736147,  )

insert into agenda values
(1,'2000-03-13', 1);

--insert Animal

insert into animal values
(1, 'alberto', '3','F','não',1,1,1);

--insert cidade

insert into cidade values
(1,'itatiba','SP',)


-- insert consulta

