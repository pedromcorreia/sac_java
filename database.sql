-- public."user" definition

-- Drop table

-- DROP TABLE public."user";

CREATE TABLE public."user" (
	"name" varchar NOT NULL,
	login varchar NOT NULL,
	"password" varchar NOT NULL,
	id_usuario serial NOT NULL,
	"role" varchar NOT NULL,
	CONSTRAINT tb_usuario_pkey PRIMARY KEY (id_usuario)
);