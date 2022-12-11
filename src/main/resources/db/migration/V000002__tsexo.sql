CREATE TABLE tsexo (
	id bigserial NOT NULL,
    nome varchar(255),
    sigla varchar(255),
	adicionado timestamp default CURRENT_TIMESTAMP,
	alterado timestamp,
	CONSTRAINT tsexo_pkey PRIMARY KEY (id)
);
