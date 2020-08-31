-- public.category definition

-- Drop table

-- DROP TABLE public.category;

CREATE TABLE public.category (
	"name" varchar NOT NULL,
	category_id serial NOT NULL
);


-- public.companhia definition

-- Drop table

-- DROP TABLE public.companhia;

CREATE TABLE public.companhia (
	codc serial NOT NULL,
	cidade varchar NULL,
	nome_companhia varchar NULL,
	CONSTRAINT companhia_pkey PRIMARY KEY (codc)
);


-- public.empregado definition

-- Drop table

-- DROP TABLE public.empregado;

CREATE TABLE public.empregado (
	nome varchar NULL,
	rua varchar NULL,
	cpf varchar NULL,
	rg varchar NULL,
	mae varchar NULL,
	salario int4 NULL,
	sexo varchar NULL,
	code serial NOT NULL,
	codc int4 NULL,
	nasc date NULL,
	CONSTRAINT empregado_pkey PRIMARY KEY (code)
);


-- public.empregado_auditoria definition

-- Drop table

-- DROP TABLE public.empregado_auditoria;

CREATE TABLE public.empregado_auditoria (
	cod_empregado int4 NULL,
	data_alteracao date NULL,
	salario int4 NULL
);


-- public.pessoa definition

-- Drop table

-- DROP TABLE public.pessoa;

CREATE TABLE public.pessoa (
	nome varchar NULL,
	idade int4 NULL,
	salario int4 NULL,
	active bool NULL,
	sexo varchar NULL,
	id serial NOT NULL,
	CONSTRAINT pessoa_pkey PRIMARY KEY (id)
);


-- public.pessoa_auditoria definition

-- Drop table

-- DROP TABLE public.pessoa_auditoria;

CREATE TABLE public.pessoa_auditoria (
	cod_pessoa int4 NULL,
	data_alteracao date NULL,
	salario int4 NULL
);


-- public.product definition

-- Drop table

-- DROP TABLE public.product;

CREATE TABLE public.product (
	"name" varchar NULL,
	description varchar NULL,
	weight int4 NULL,
	product_id serial NOT NULL,
	category_id int4 NULL
);


-- public.question definition

-- Drop table

-- DROP TABLE public.question;

CREATE TABLE public.question (
	description varchar NOT NULL,
	solution varchar NULL,
	question_id serial NOT NULL,
	active bool NOT NULL DEFAULT true,
	created_at timestamp NULL,
	product_id int4 NULL,
	user_id int4 NULL,
	"type" varchar NULL,
	CONSTRAINT tb_question_pkey PRIMARY KEY (question_id)
);


-- public."user" definition

-- Drop table

-- DROP TABLE public."user";

CREATE TABLE public."user" (
	"name" varchar NOT NULL,
	email varchar NOT NULL,
	"password" varchar NOT NULL,
	user_id serial NOT NULL,
	"role" varchar NULL,
	cpf varchar NULL,
	phone varchar NULL,
	street varchar NULL,
	"number" varchar NULL,
	complement varchar NULL,
	neighborhood varchar NULL,
	zipcode varchar NULL,
	city varchar NULL,
	state varchar NULL,
	CONSTRAINT tb_usuario_pkey PRIMARY KEY (user_id),
	CONSTRAINT user_un UNIQUE (email, cpf)
);


-- public.address definition

-- Drop table

-- DROP TABLE public.address;

CREATE TABLE public.address (
	street varchar NULL,
	"number" int4 NULL,
	complement varchar NULL,
	neighborhood varchar NULL,
	zipcode varchar NULL,
	city varchar NULL,
	state varchar NULL,
	id_address serial NOT NULL,
	user_id int4 NULL,
	CONSTRAINT address_fk FOREIGN KEY (user_id) REFERENCES "user"(user_id) ON UPDATE CASCADE ON DELETE CASCADE
);


-- public.gerente definition

-- Drop table

-- DROP TABLE public.gerente;

CREATE TABLE public.gerente (
	gerente_fk int4 NOT NULL,
	gerenciado_fk int4 NOT NULL,
	CONSTRAINT gerente_gerenciado_fk_fkey FOREIGN KEY (gerenciado_fk) REFERENCES empregado(code),
	CONSTRAINT gerente_gerente_fk_fkey FOREIGN KEY (gerente_fk) REFERENCES empregado(code)
);


-- public.trabalha definition

-- Drop table

-- DROP TABLE public.trabalha;

CREATE TABLE public.trabalha (
	codc int4 NOT NULL,
	code int4 NOT NULL,
	CONSTRAINT trabalha_fk FOREIGN KEY (codc) REFERENCES companhia(codc),
	CONSTRAINT trabalha_fk_1 FOREIGN KEY (code) REFERENCES empregado(code)
);
