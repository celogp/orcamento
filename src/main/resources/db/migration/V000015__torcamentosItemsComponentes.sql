CREATE TABLE torcamentosItensComponentes (
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
    produtoid bigserial,
    volume varchar(3),
    orcamentoitemid bigserial,    
	CONSTRAINT torcamentosItensComponentes_pkey PRIMARY KEY (id)
);

ALTER TABLE torcamentosItensComponentes ADD CONSTRAINT fk_tproduto FOREIGN KEY (produtoid) REFERENCES tprodutos(id);

ALTER TABLE torcamentosItensComponentes ADD CONSTRAINT fk_torcamentoItem FOREIGN KEY (orcamentoitemid) REFERENCES torcamentosItens(id)  on delete cascade;
