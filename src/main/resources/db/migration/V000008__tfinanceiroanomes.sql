CREATE TABLE tfinanceiroanomes (
	id bigserial NOT NULL,
    anoref int,
    mesref int,
    receita boolean ,
    valor numeric(19,2),
	CONSTRAINT tfinanceiroanomes_pkey PRIMARY KEY (id)
);
