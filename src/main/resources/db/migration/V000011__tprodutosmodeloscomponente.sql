CREATE TABLE tprodutosmodeloscomponente (
	id bigserial NOT NULL,
    quantidade numeric(19,2),
    produtomodeloid bigserial,
    produtoid bigserial,
	adicionado timestamp default CURRENT_TIMESTAMP,
	alterado timestamp,
	CONSTRAINT tprodutosmodeloscomponente_pkey PRIMARY KEY (id)
);

ALTER TABLE tprodutosmodeloscomponente ADD CONSTRAINT fk_tprodutomodelo FOREIGN KEY (produtomodeloid) REFERENCES tprodutosmodelos(id) on delete cascade;

ALTER TABLE tprodutosmodeloscomponente ADD CONSTRAINT fk_tproduto FOREIGN KEY (produtoid) REFERENCES tprodutos(id);
