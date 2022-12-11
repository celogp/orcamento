CREATE TABLE tlocalizacoes (
	id bigserial NOT NULL,
    cep varchar(10),
    logradouro varchar(255),
    complemento varchar(255),
    localidade varchar(255),
    bairro varchar(255),
    longitude bigint, 
    latitude bigint,
    ufid bigserial,
	adicionado timestamp default CURRENT_TIMESTAMP,
	alterado timestamp,
	CONSTRAINT tlocalizacoes_pkey PRIMARY KEY (id)
);

ALTER TABLE tlocalizacoes ADD CONSTRAINT fk_tuf FOREIGN KEY (ufid) REFERENCES tufs(id);
