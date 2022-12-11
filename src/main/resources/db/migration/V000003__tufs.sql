CREATE TABLE tufs (
	id bigserial NOT NULL,
    nome varchar(255),
    sigla varchar(255),
	adicionado timestamp default CURRENT_TIMESTAMP,
	alterado timestamp,
	CONSTRAINT tufs_pkey PRIMARY KEY (id)
);
