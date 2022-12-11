CREATE TABLE torcamentosItens (
	id bigserial NOT NULL,
    quantidade numeric(19,2),
    vlrunitario numeric(19,2),
    vlrbruto numeric(19,2),
    percdesconto numeric(19,2),
    vlrdesconto numeric(19,2),
    vlrliquido numeric(19,2),
    largura numeric(19,2),
    comprimento numeric(19,2),
    espessura numeric(19,2),
    area numeric(19,2),
    ambiente varchar(255),
    produtoid bigserial,
    volume varchar(3),
    orcamentoid bigserial,    
	CONSTRAINT torcamentosItens_pkey PRIMARY KEY (id)
);

ALTER TABLE torcamentosItens ADD CONSTRAINT fk_tproduto FOREIGN KEY (produtoid) REFERENCES tprodutos(id);

ALTER TABLE torcamentosItens ADD CONSTRAINT fk_torcamento FOREIGN KEY (orcamentoid) REFERENCES torcamentos(id)  on delete cascade;
