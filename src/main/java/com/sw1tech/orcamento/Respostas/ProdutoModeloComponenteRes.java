package com.sw1tech.orcamento.Respostas;

import java.math.BigDecimal;

import com.sw1tech.orcamento.Entidades.Produto;

import lombok.Data;

@Data()
public class ProdutoModeloComponenteRes {
    private Long id;
    private BigDecimal largura;
    private BigDecimal comprimento;
    private BigDecimal altura;
    private BigDecimal espessura;
    private BigDecimal quantidade;
    private Long produtoModeloId;
    private Long produtoId;
    private Produto produto;

}