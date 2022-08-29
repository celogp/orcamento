INSERT INTO TSEXO
(NOME, SIGLA)
select 'Masculino' AS "NOME", 'M' as "SIGLA" FROM TDUAL
WHERE NOT EXISTS (SELECT 1 FROM TSEXO WHERE NOME='Masculino');

INSERT INTO TSEXO
(NOME, SIGLA)
select 'Feminino' AS "NOME", 'F' as "SIGLA" FROM TDUAL
WHERE NOT EXISTS (SELECT 1 FROM TSEXO WHERE NOME='Feminino');

INSERT INTO TSEXO
(NOME, SIGLA)
select 'Masculino 1' AS "NOME", 'M1' as "SIGLA" FROM TDUAL
WHERE NOT EXISTS (SELECT 1 FROM TSEXO WHERE NOME='Masculino 1');

INSERT INTO TSEXO
(NOME, SIGLA)
select 'Feminino 1' AS "NOME", 'F1' as "SIGLA" FROM TDUAL
WHERE NOT EXISTS (SELECT 1 FROM TSEXO WHERE NOME='Feminino 1');