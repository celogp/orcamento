CREATE TABLE torcamentos (
	id bigserial NOT NULL,
	numero bigint, 
	descricao  varchar(255),
    bloqueado boolean,
    dtMovimento date,    
    dtEntrega date,
    vlrtotalitens numeric(19,2),
    vlrdesconto numeric(19,2),
    percdesconto numeric(19,2),
    vlrtotal numeric(19,2),
    parceiroid bigserial,
	CONSTRAINT torcamentos_pkey PRIMARY KEY (id)
);

ALTER TABLE torcamentos ADD CONSTRAINT fk_tparceiro FOREIGN KEY (parceiroid) REFERENCES tparceiros(id);