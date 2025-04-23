create table dependentes(
id SERIAL primary key,
nome VARCHAR (100) not null,
cpf VARCHAR (11) unique not null,
datanascimento DATE  not null,
status VARCHAR(20) CHECK (status IN ('FILHO', 'SOBRINHO', 'OUTROS')) NOT NULL
);

create table folhapagamento(
id SERIAL primary key,
nomefuncionario VARCHAR (100) not null,
cpf VARCHAR (11) unique not null,
datapagamento DATE not null,
descontoinss NUMERIC(20,2) NOT NULL,
descontoir NUMERIC(20,2) NOT NULL,
salarioliquido NUMERIC (20,2) NOT NULL
);

create table funcionario(
ID SERIAL PRIMARY KEY,
nome VARCHAR (100) NOT NULL,
cpf VARCHAR (11) unique NOT NULL,
datanascimento DATE NOT NULL,
salariobruto NUMERIC(20,2)NOT NULL,
descontoinss NUMERIC(20,2) NOT NULL,
descontoir NUMERIC(20,2) NOT NULL
);

CREATE TABLE PESSOA(
ID SERIAL PRIMARY KEY,
nome VARCHAR (100) NOT NULL,
cpf VARCHAR (11) unique NOT NULL,
datanascimento DATE NOT NULL
);

SELECT * FROM DEPENDENTES, folhapagamento, funcionario

ALTER TABLE dependentes DROP CONSTRAINT dependentes_status_check;

ALTER TABLE dependentes ADD CONSTRAINT dependentes_status_check
CHECK (status IN ('FILHO', 'SOBRINHO', 'OUTROS'));

TRUNCATE TABLE dependentes;
TRUNCATE TABLE folhapagamento;
TRUNCATE TABLE funcionario;