CREATE TABLE tprodutos (
	id bigserial NOT NULL,
	nome varchar(255),
	volume varchar(3),
	ativo boolean,
	precodabase boolean,
	custo numeric(19,2),
	preco numeric(19,2),
	estoque numeric(19,2),
	produtotipoid bigserial, 
	adicionado timestamp default CURRENT_TIMESTAMP,
	alterado timestamp,
	CONSTRAINT tprodutos_pkey PRIMARY KEY (id)
);
