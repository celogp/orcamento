CREATE TABLE tparceiros (
	id bigserial NOT NULL,
	razao varchar(255),
	nome varchar(255),
    cnpj varchar(20),
    inscricao  varchar(20),
    cpf  varchar(20),
    identidade  varchar(20),
    email varchar(255),
    fone varchar(20),
    celular  varchar(20),
    celulariswhatsapp boolean,
    contato  varchar(255),
    fonecontato  varchar(20),
    celularcontato varchar(20),
    celularcontatoiswhatsapp boolean,
    localizacaoid bigserial,
    sexoid bigserial,
	adicionado timestamp default CURRENT_TIMESTAMP,
	alterado timestamp,
	CONSTRAINT tparceiros_pkey PRIMARY KEY (id)
);

ALTER TABLE tparceiros ADD CONSTRAINT fk_tlocalizacao FOREIGN KEY (localizacaoid) REFERENCES tlocalizacoes(id);

ALTER TABLE tparceiros ADD CONSTRAINT fk_tsexo FOREIGN KEY (sexoid) REFERENCES tsexo(id);
