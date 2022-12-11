package com.sw1tech.orcamento.Respostas;

import java.math.BigDecimal;

import com.sw1tech.orcamento.Entidades.Produto;

import lombok.Data;

@Data
public class OrcamentoItemRes {

    private Long id;
    private BigDecimal quantidade;
    private BigDecimal vlrUnitario;
    private BigDecimal vlrBruto;
    private BigDecimal percDesconto;
    private BigDecimal vlrDesconto;
    private BigDecimal vlrLiquido;
    private BigDecimal largura;
    private BigDecimal comprimento;
    private BigDecimal espessura;
    private BigDecimal area;
    private String ambiente;
    private Long produtoId;
    private Produto produto;
    private String volume;
    private Long orcamentoId;
	
}
