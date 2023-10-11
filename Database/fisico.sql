CREATE DATABASE goodtrip;

USE goodtrip;

CREATE TABLE cidade (
    id_cidade INTEGER PRIMARY KEY auto_increment not null,
    nome_cidade VARCHAR(30)
);

CREATE TABLE horario (
    id_horario INTEGER PRIMARY KEY auto_increment not null,
    hora_saida TIME,
    tempo_viagem TIME,
    fk_cidade_id_cidade_origem INTEGER,
    fk_cidade_id_cidade_destino INTEGER
);

CREATE TABLE passagem (
    id_passagem INTEGER PRIMARY KEY auto_increment not null,
    valor DECIMAL(10,2),
    poltrona VARCHAR(5),
    data_viagem VARCHAR(10),
    fk_horario_id_horario INTEGER,
    fk_usuario_id_usuario INTEGER
);

CREATE TABLE usuario (
    id_usuario INTEGER PRIMARY KEY auto_increment not null,
    nome_usuario VARCHAR(50),
    cpf BIGINT,
    senha VARCHAR(10)
);
 
ALTER TABLE horario ADD CONSTRAINT FK_horario
    FOREIGN KEY (fk_cidade_id_cidade_origem)
    REFERENCES cidade (id_cidade)
    ON DELETE CASCADE;
    
ALTER TABLE horario ADD CONSTRAINT FK_horario_2
    FOREIGN KEY (fk_cidade_id_cidade_destino)
    REFERENCES cidade (id_cidade)
    ON DELETE CASCADE;
 
ALTER TABLE passagem ADD CONSTRAINT FK_passagem_2
    FOREIGN KEY (fk_horario_id_horario)
    REFERENCES horario (id_horario)
    ON DELETE CASCADE;
 
ALTER TABLE passagem ADD CONSTRAINT FK_passagem_3
    FOREIGN KEY (fk_usuario_id_usuario)
    REFERENCES usuario (id_usuario)
    ON DELETE CASCADE;

-- Insere dados na tabela (CREATE)
insert into cidade (nome_cidade) values
('Rio de Janeiro'),
('São Paulo'),
('Santa Catarina'),
('Minas Gerais');

insert into horario (hora_saida, tempo_viagem, fk_cidade_id_cidade_origem, fk_cidade_id_cidade_destino)  values 
('07:15', '06:00', 1, 2),
('10:15', '06:30', 3, 2),
('13:15', '19:00', 4, 1),
('07:00', '13:30', 1, 3);

insert into usuario (nome_usuario, cpf, senha) values
('Anderson', '44444444444', '123456'),
('Shermann', '11111111111', '123456'),
('Ana', '22222222222', '123456'),
('Beatriz', '33333333333', '123456');

insert into passagem (valor, poltrona, data_viagem, fk_horario_id_horario, fk_usuario_id_usuario) values
('100', '13A', '09/10/2023', 1, 4),
('150', '9B', '09/10/2023', 2, 3),
('200', '5B', '09/10/2023', 3, 2),
('250', '27B', '09/10/2023', 4, 1);

    
-- consulta de dados (READ)
select * from cidade;
select * from horario;
select * from passagem;
select * from usuario;
Select hora_saida, tempo_viagem, sec_to_time(time_to_sec(hora_saida) + time_to_sec(tempo_viagem)) as hora_chegada, 

(select nome_cidade
from cidade
where id_cidade = horario.fk_cidade_id_cidade_origem ) as origem,

(select nome_cidade
from cidade
where id_cidade = horario.fk_cidade_id_cidade_destino ) as destino

from horario;

-- Atualiza os dados na tabela (UPDATE)
UPDATE cidade SET nome_cidade = 'Salvador' WHERE id_cidade = 3;
UPDATE usuario SET nome_usuario = 'Anderson Borges', cpf = '55555555555', senha = '123' WHERE id_usuario = 1;
UPDATE horario SET hora_saida = '16:11', tempo_viagem = '8:00', fk_cidade_id_cidade_origem = 3, fk_cidade_id_cidade_destino = 2 WHERE id_horario = 1;
UPDATE passagem SET valor = '300', poltrona = '40A', data_viagem = '10/10/2023', fk_horario_id_horario = 3, fk_usuario_id_usuario = 1 WHERE id_passagem = 1; 


-- Deleta os dados na tabela (DELETE)
DELETE FROM cidade WHERE id_cidade = 1;
DELETE FROM horario WHERE id_horario = 1;
DELETE FROM passagem WHERE id_passagem = 1;
DELETE FROM usuario where id_usuario = 1;