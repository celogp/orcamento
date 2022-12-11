CREATE TABLE tprodutosModelosImagem (
	id bigserial NOT NULL,
	conteudo bytea,
	CONSTRAINT tprodutosmodelosImagem_pkey PRIMARY KEY (id)
);

ALTER TABLE tprodutosmodelosimagem ADD CONSTRAINT fk_tprodutomodeloimagem FOREIGN KEY (id) REFERENCES tprodutosmodelos(id) on delete cascade;