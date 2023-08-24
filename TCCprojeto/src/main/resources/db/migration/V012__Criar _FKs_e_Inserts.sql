alter table agenda add constraint FK_agenda_medico foreign key(idmedico) references medico(id);


alter table animal add constraint FK_animal_cliente foreign key(idcliente) references cliente(id);
alter table animal add constraint FK_animal_raca foreign key(idraca) references raca(id);
alter table animal add constraint Fk_animal_especie foreign key(idespecie) references especie(id);

alter table consulta add constraint FK_consulta_animal foreign key(idanimal) references animal(id);
alter table consulta add constraint FK_consulta_medico foreign key(idmedico) references medico(id);

alter table cliente add constraint Fk_cliente_cidade foreign key(idcidade) references cidade(id);

