CREATE TABLE tprodutosModelos (
	id bigserial NOT NULL,
	nome varchar(255),
    largura numeric(19,2),
    comprimento numeric(19,2),
    espessura numeric(19,2),
    produtoacabadoid bigserial,
    produtobaseid bigserial,
	adicionado timestamp default CURRENT_TIMESTAMP,
	alterado timestamp,
	CONSTRAINT tprodutosmodelos_pkey PRIMARY KEY (id)
);

ALTER TABLE tprodutosmodelos ADD CONSTRAINT fk_tprodutoacabado FOREIGN KEY (produtoacabadoid) REFERENCES tprodutos(id);

ALTER TABLE tprodutosmodelos ADD CONSTRAINT fk_tprodutobase FOREIGN KEY (produtobaseid) REFERENCES tprodutos(id);
