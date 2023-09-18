alter table agenda add constraint FK_agenda_medico foreign key(idmedico) references medico(id);


alter table animal add constraint FK_animal_cliente foreign key(idcliente) references cliente(id);
alter table animal add constraint FK_animal_raca foreign key(idraca) references raca(id);
alter table animal add constraint FK_animal_especie foreign key(idespecie) references especie(id);

alter table consulta add constraint FK_consulta_animal foreign key(idanimal) references animal(id);
alter table consulta add constraint FK_consulta_medico foreign key(idmedico) references medico(id);

alter table cliente add constraint FK_cliente_cidade foreign key(idcidade) references cidade(id);

-- INSERT-----------------------------------------------------------------------------------------------------------------------------------------------------------------
-- INSERIR MEDICO
insert into medico(id,nome, telefone, CPF,RG) values (1, 'Marcio','(14)99773-6147','905.550.860-89','30.896.574-7');
-- Inserir na tabela "agenda"
insert into agenda(id,datahoraconsulta, idmedico) values (1,'2000-03-13', 1);
-- insert cidade
insert into cidade(id, nomecidade, estado) values (1,'itatiba','SP');
-- insert cliente
insert into cliente(id,nomecliente,endereco, tele1, tele2, CPF, RG, idcidade) values(1,'Claúdia','rua josé bizerra 165', '(14)99685-7426','(14)98565-4585','125.369.258-54','28.145.956-4', 1);
-- insert especie
insert into especie(id, descricao) values (1, 'gato');
-- inserir raca
insert into raca(id, descricao) values (1,'siamês');
-- insert Animal
insert into animal(id, nomeanimal, idade, sexo, castracao,idcliente,idraca,idespecie) values (1, 'alberto', '3','F','não',1,1,1);

-- insert consulta
insert into consulta(id, datahora,historico,idanimal,idmedico) values(1,'2000-03-13','animal com a pata quebrada', 1,1);
