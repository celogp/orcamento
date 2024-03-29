CREATE or REPLACE VIEW VFINANCEIROANOMES ( ID, ANOREF, MESREF, RECEITA, VALOR) AS
SELECT
MAX(f.id) AS ID,
extract(ISOYEAR FROM f.DTMOVIMENTO)  AS ANOREF,
extract(MONTH FROM f.DTMOVIMENTO)  AS MESREF,
f.receita as RECEITA,
SUM(f.VLRFINANCEIRO) as VALOR
FROM TFINANCEIROS f
GROUP BY  
extract(ISOYEAR FROM f.DTMOVIMENTO), 
extract(MONTH FROM f.DTMOVIMENTO), 
f.RECEITA;