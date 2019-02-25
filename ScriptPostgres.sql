-- Database: MyApp

-- DROP DATABASE "MyApp";

CREATE DATABASE "MyApp"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.utf8'
    LC_CTYPE = 'en_US.utf8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

GRANT CREATE, CONNECT ON DATABASE "MyApp" TO postgres;
GRANT TEMPORARY ON DATABASE "MyApp" TO postgres WITH GRANT OPTION;

GRANT TEMPORARY, CONNECT ON DATABASE "MyApp" TO PUBLIC;

CREATE TABLE usuarios(
	id_usuario bigserial primary key,
	nome_usuario varchar(60),
	login varchar(12),
	email varchar(60),
	senha varchar(45),
	data_criacao timestamptz,
	tempo_expiracao_senha int4,
	cod_autorizacao varchar(1),
	status_usuario varchar(1),
	cod_pessoa int8
);

CREATE TABLE perfil(
	id_perfil bigserial primary key,
	nome_perfil varchar(60)
);

CREATE TABLE aparelhos(
	id_aparelho bigserial primary key,
	descricao_aparelho varchar(15),
	codigo_aparelho varchar(100),
);

CREATE TABLE usuarios_aparelhos(
	id_usuario int8,
	id_aparelho int8,
	CONSTRAINT id_aparelho_fk FOREIGN KEY (id_aparelho)
        REFERENCES public.aparelhos (id_aparelho) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT id_usuario_fk FOREIGN KEY (id_usuario)
        REFERENCES public.usuarios (id_usuario) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE public.usuarios_perfil
(
    id_usuario bigint,
    id_perfil bigint,
    CONSTRAINT id_perfil_fk FOREIGN KEY (id_perfil)
        REFERENCES public.perfil (id_perfil) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT id_usuario_fk FOREIGN KEY (id_usuario)
        REFERENCES public.usuarios (id_usuario) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
