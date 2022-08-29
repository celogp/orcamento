CREATE VIEW VFINANCEIROMES ( ID, ANOREF, MESREF, RECEITA, VALOR) AS
SELECT
ROW_NUMBER() OVER () AS ID,
YEAR(f.DTMOVIMENTO) AS ANOREF,
MONTH(f.DTMOVIMENTO) AS MESREF,
f.receita as RECEITA,
SUM(f.VLRFINANCEIRO) as VALOR
FROM TFINANCEIROS f
GROUP BY 1, YEAR(f.DTMOVIMENTO), MONTH(f.DTMOVIMENTO), f.RECEITA