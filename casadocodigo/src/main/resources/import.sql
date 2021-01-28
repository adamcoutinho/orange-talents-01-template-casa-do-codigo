insert into autor(id,descricao,email,nome,instant)  VALUES (nextval('sq_autor'), 'asdasd','ian@gmail.com','Ian Sommerville',current_timestamp);
insert into autor(id,descricao,email,nome,instant)  VALUES (nextval('sq_autor'), 'asdasd','ramez@gmail.com','Ramez Elmasri',current_timestamp);
insert into autor(id,descricao,email,nome,instant)  VALUES (nextval('sq_autor'), 'asdasd','henry@gmail.com','Henry F. Korth',current_timestamp);
insert into autor(id,descricao,email,nome,instant)  VALUES (nextval('sq_autor'), 'asdasd','sudarshan@gmail.com','S. Sudarshan',current_timestamp);
insert into autor(id,descricao,email,nome,instant)  VALUES (nextval('sq_autor'), 'asdasd','daniel@gmail.com','Daniel Vieiraz',current_timestamp);
insert into autor(id,descricao,email,nome,instant)  VALUES (nextval('sq_autor'), 'asdasd','sadoc@gmail.com','Daniel Sadoc Menasche',current_timestamp);
insert into autor(id,descricao,email,nome,instant)  VALUES (nextval('sq_autor'), 'asdasd','nunes@gmail.com','Joo Nunes de Souza',current_timestamp);
insert into autor(id,descricao,email,nome,instant)  VALUES (nextval('sq_autor'), 'asdasd','stevene@gmail.com','Steven Klaudat',current_timestamp);
insert into autor(id,descricao,email,nome,instant)  VALUES (nextval('sq_autor'), 'asdasd','antoine@gmail.com','Antoine de Saint-Exupry',current_timestamp);
insert into autor(id,descricao,email,nome,instant)  VALUES (nextval('sq_autor'), 'asdasd','lavolace@gmail.com','lavolace',current_timestamp);

insert into categoria (id ,nome) values(nextval('sq_categoria'),'Informática');
insert into categoria (id ,nome) values(nextval('sq_categoria'),'Entretenimento');
insert into categoria (id ,nome) values(nextval('sq_categoria'),'Calculo');

INSERT INTO livro (id,titulo,resumo,sumario,isbn,numero_paginas,preco,data_publicacao,autor,categoria) values(nextval('sq_livro'), 'Le Petit Prince', 'Gallimard','Asdasdasdazxojcnvzxc','8570564570',200,23.90,'2021-04-21',1,1);

--calculo
INSERT INTO livro (id,titulo,resumo,sumario,isbn,numero_paginas,preco,data_publicacao,autor,categoria) values(nextval('sq_livro'), 'Cálculo','3º Volume Esc. de Engenharia / PUCRS','bxoxjqwwe','9788522106615',200,45.56,'2021-04-01',1,1);
INSERT INTO livro (id,titulo,resumo,sumario,isbn,numero_paginas,preco,data_publicacao,autor,categoria) values(nextval('sq_livro'), 'Fundamentos Matemáticos','5.ed.','bxoxjqwwe','9788521614227',200,45.56,'2022-02-25',1,1);

--Computação
INSERT INTO livro (id,titulo,resumo,sumario,isbn,numero_paginas,preco,data_publicacao,autor,categoria) values(nextval('sq_livro'), 'Algoritmos  teoria e prática','3. ed.','bxoxjqwwe','9788535236996',200,45.56,'2022-05-11',1,1);
INSERT INTO livro (id,titulo,resumo,sumario,isbn,numero_paginas,preco,data_publicacao,autor,categoria) values(nextval('sq_livro'), 'Computer algorithms','3. ed.','bxoxjqwwe','0929306414',200,45.56,'2022-02-25',1,1);
INSERT INTO livro (id,titulo,resumo,sumario,isbn,numero_paginas,preco,data_publicacao,autor,categoria) values(nextval('sq_livro'), 'Internet','2ª edeção','i36aadasdasd','857001953X',200,45.56,'2021-04-01',1,1);
INSERT INTO livro (id,titulo,resumo,sumario,isbn,numero_paginas,preco,data_publicacao,autor,categoria) values(nextval('sq_livro'),'Java for everyone: late objects','2nd ed.','bxoxjqwwe','9780471791911',200,45.56,'2022-02-25',1,1);
INSERT INTO livro (id,titulo,resumo,sumario,isbn,numero_paginas,preco,data_publicacao,autor,categoria) values(nextval('sq_livro'),'Object-oriented analysis and design','2nd ed.','bxoxjqwwe','9781849965217',200,45.56,'2022-02-25',1,1);
INSERT INTO livro (id,titulo,resumo,sumario,isbn,numero_paginas,preco,data_publicacao,autor,categoria) values(nextval('sq_livro'),'The object-oriented thought process','4. ed.','bxoxjqwwe','9780321861276',200,45.56,'2022-02-25',1,1);
INSERT INTO livro (id,titulo,resumo,sumario,isbn,numero_paginas,preco,data_publicacao,autor,categoria) values(nextval('sq_livro'),'Estruturas de dados e algoritmos em Java','4. ed.','bxoxjqwwe','9788560031504',200,45.56,'2022-02-25',1,1);

insert into pais(id,nome) values(nextval('sq_pais'),'Brasil');
insert into pais(id,nome) values(nextval('sq_pais'),'Alemanha');
insert into pais(id,nome) values(nextval('sq_pais'),'Paraguai');
insert into pais(id,nome) values(nextval('sq_pais'),'Uruguai');
insert into pais(id,nome) values(nextval('sq_pais'),'Argentina');


insert into estado(id,nome,pais) values(NEXTVAL('sq_estado'),  'Acre'                 ,1);
insert into estado(id,nome,pais) values(NEXTVAL('sq_estado'),  'Alagoas'              ,1);
insert into estado(id,nome,pais) values(NEXTVAL('sq_estado'),  'Amazonas'             ,1);
insert into estado(id,nome,pais) values(NEXTVAL('sq_estado'),  'Amapá'                ,1);
insert into estado(id,nome,pais) values(NEXTVAL('sq_estado'),  'Bahia'                ,1);
insert into estado(id,nome,pais) values(NEXTVAL('sq_estado'),  'Ceará'                ,1);
insert into estado(id,nome,pais) values(NEXTVAL('sq_estado'),  'Distrito Federal'     ,1);
insert into estado(id,nome,pais) values(NEXTVAL('sq_estado'),  'Espírito Santo'       ,1);
insert into estado(id,nome,pais) values(NEXTVAL('sq_estado'),  'Goiás'                ,1);
insert into estado(id,nome,pais) values(NEXTVAL('sq_estado'),  'Maranhão'             ,1);
insert into estado(id,nome,pais) values(NEXTVAL('sq_estado'),  'Minas Gerais'         ,1);
insert into estado(id,nome,pais) values(NEXTVAL('sq_estado'),  'Mato Grosso do Sul'   ,1);
insert into estado(id,nome,pais) values(NEXTVAL('sq_estado'),  'Mato Grosso'          ,1);
insert into estado(id,nome,pais) values(NEXTVAL('sq_estado'),  'Pará'                 ,1);
insert into estado(id,nome,pais) values(NEXTVAL('sq_estado'),  'Paraíba'              ,1);
insert into estado(id,nome,pais) values(NEXTVAL('sq_estado'),  'Pernambuco'           ,1);
insert into estado(id,nome,pais) values(NEXTVAL('sq_estado'),  'Piauí'                ,1);
insert into estado(id,nome,pais) values(NEXTVAL('sq_estado'),  'Paraná'               ,1);
insert into estado(id,nome,pais) values(NEXTVAL('sq_estado'),  'Rio de Janeiro'       ,1);
insert into estado(id,nome,pais) values(NEXTVAL('sq_estado'),  'Rio Grande do Norte'  ,1);
insert into estado(id,nome,pais) values(NEXTVAL('sq_estado'),  'Rondônia'             ,1);
insert into estado(id,nome,pais) values(NEXTVAL('sq_estado'),  'Roraima'              ,1);
insert into estado(id,nome,pais) values(NEXTVAL('sq_estado'),  'Rio Grande do Sul'    ,1);
insert into estado(id,nome,pais) values(NEXTVAL('sq_estado'),  'Santa Catarina'       ,1);
insert into estado(id,nome,pais) values(NEXTVAL('sq_estado'),  'Sergipe'              ,1);
insert into estado(id,nome,pais) values(NEXTVAL('sq_estado'),  'São Paulo'            ,1);
insert into estado(id,nome,pais) values(NEXTVAL('sq_estado'),  'Tocantins'            ,1);
insert into estado(id,nome,pais) values(NEXTVAL('sq_estado'),  'Exterior'             ,1);