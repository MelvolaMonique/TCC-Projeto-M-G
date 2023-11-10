alter table agenda add constraint FK_agenda_medico foreign key(idmedico) references medico(id);


alter table animal add constraint FK_animal_cliente foreign key(idcliente) references cliente(id);
alter table animal add constraint FK_animal_raca foreign key(idraca) references raca(id);
alter table animal add constraint FK_animal_especie foreign key(idespecie) references especie(id);

alter table consulta add constraint FK_consulta_animal foreign key(idanimal) references animal(id);
alter table consulta add constraint FK_consulta_medico foreign key(idmedico) references medico(id);

alter table cliente add constraint FK_cliente_cidade foreign key(idcidade) references cidade(id);

-- INSERT-----------------------------------------------------------------------------------------------------------------------------------------------------------------
-- INSERIR MEDICO
insert into medico(id,nomemedico, telefone, CPF,RG) values (1, 'Marcio','(14)99773-6147','905.550.860-89','30.896.574-7');
insert into medico(id,nomemedico, telefone, CPF,RG) values (2, 'Alberto','(14)9956-8795','105.524.865-29','35.786.634-5');
insert into medico(id,nomemedico, telefone, CPF,RG) values (3, 'Pamela','(14)98753-6317','455.540.145-86','12.845.454-2');

-- Inserir na tabela "agenda"
insert into agenda(id,datahora, idmedico) values (1,'2000/03/13', 1);
insert into agenda(id,datahora, idmedico) values (2,'2012/12/23', 3);
insert into agenda(id,datahora, idmedico) values (3,'2004/05/02', 2);

-- insert cidade
insert into cidade(id, nomecidade, estado) values (1,'itatiba','SP');
insert into cidade(id, nomecidade, estado) values (2,'bauru','SP');
insert into cidade(id, nomecidade, estado) values (3,'aguas claras','RS');
insert into cidade(id, nomecidade, estado) values (4,'Lençois Paulista','MG');
insert into cidade(id, nomecidade, estado) values (5,'Macatuba','SP');
insert into cidade(id, nomecidade, estado) values (6,'Agudos','SP');

-- insert cliente
insert into cliente(id,nomecliente,endereco, tele1, tele2, CPF, RG, idcidade) values(1,'Claúdia','rua josé bizerra 165', '(14)99685-7426','(14)98565-4585','125.369.258-54','28.145.956-4', 1);
insert into cliente(id,nomecliente,endereco, tele1, tele2, CPF, RG, idcidade) values(2,'Marcia','rua rosas vermelhas 20', '(14)99569-0356','(14)98665-0235','130.359.158-51','28.145.123-5', 3);
insert into cliente(id,nomecliente,endereco, tele1, tele2, CPF, RG, idcidade) values(3,'Zelia','rua apocalandia 444', '(14)99254-1236','(14)98585-9122','236.969.151-11','28.145.696-3', 2);
insert into cliente(id,nomecliente,endereco, tele1, tele2, CPF, RG, idcidade) values(4,'Amelia','rua piracicaba 123', '(14)99254-1235','(15)98585-9232','236.969.125-22','22.116.538-1', 4);
insert into cliente(id,nomecliente,endereco, tele1, tele2, CPF, RG, idcidade) values(5,'SHING','rua avaré 233', '(14)99254-1212','(13)98585-9112','236.969.156-56','36.112.499-2', 6);
insert into cliente(id,nomecliente,endereco, tele1, tele2, CPF, RG, idcidade) values(6,'Gabriel','rua monte azul 12', '(14)99254-1213','(14)98585-9232','236.969.157-99','44.196.381-4', 5);

-- insert especie
insert into especie(id, descricao_es) values (1, 'gato');
insert into especie(id, descricao_es) values (2, 'cachorro');
insert into especie(id, descricao_es) values (3, 'papagaio');
-- inserir raca
insert into raca(id, descricao_ra) values (1,'siamês');
insert into raca(id, descricao_ra) values (2,'husky siberiano');
insert into raca(id, descricao_ra) values (3,'arara azul');
insert into raca(id, descricao_ra) values (4,'Border Collie');
insert into raca(id, descricao_ra) values (5,'pinscher');
insert into raca(id, descricao_ra) values (6,'shitzu');


-- insert Animal
insert into animal(id, nomeanimal, idade, sexo, castracao,idcliente,idraca,idespecie) values (1, 'lidia', '3','F','não',1,1,1);
insert into animal(id, nomeanimal, idade, sexo, castracao,idcliente,idraca,idespecie) values (2, 'chuchu', '1','M','sim',3,2,2);
insert into animal(id, nomeanimal, idade, sexo, castracao,idcliente,idraca,idespecie) values (3, 'popoco', '2','F','não',2,3,3);
insert into animal(id, nomeanimal, idade, sexo, castracao,idcliente,idraca,idespecie) values (4, 'mel', '5','F','sim',5,2,1);
insert into animal(id, nomeanimal, idade, sexo, castracao,idcliente,idraca,idespecie) values (5, 'toto', '2','M','não',4,3,3);
insert into animal(id, nomeanimal, idade, sexo, castracao,idcliente,idraca,idespecie) values (6, 'biu', '1','M','sim',6,4,2);


-- insert consulta
insert into consulta(id, datahoraconsulta,historico,idanimal,idmedico) values(1,'2000-03-13','animal com a pata quebrada', 1,1);
insert into consulta(id, datahoraconsulta,historico,idanimal,idmedico) values(2,'2006-05-03','castraçao', 2,3);
insert into consulta(id, datahoraconsulta,historico,idanimal,idmedico) values(3,'2008-04-09','asa trincada', 3,2);
