CREATE TABLE tfinanceiros (
	id bigserial NOT NULL,
    nrodocumento bigint,
    receita boolean,
    dtmovimento date,
    dtvencimento date,
    dtbaixa date,
    historico  varchar(255),
    vlrfinanceiro numeric(19,2),
    pendente boolean,
    parceiroid bigserial,
	adicionado timestamp default CURRENT_TIMESTAMP,
	alterado timestamp,
	CONSTRAINT tfinanceiros_pkey PRIMARY KEY (id)
);

ALTER TABLE tfinanceiros ADD CONSTRAINT fk_tparceiro FOREIGN KEY (parceiroid) REFERENCES tparceiros(id);
