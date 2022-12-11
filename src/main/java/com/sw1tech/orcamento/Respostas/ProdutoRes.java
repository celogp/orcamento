package com.sw1tech.orcamento.Respostas;

import java.math.BigDecimal;
import java.util.Date;

import com.sw1tech.orcamento.Entidades.ProdutoTipo;

import lombok.Data;
@Data
public class ProdutoRes {
    private int id;
    private String nome;
    private String volume;
    private BigDecimal precoTabela;
    private BigDecimal custoGerencial;
    private BigDecimal estoque;
    private Boolean ativo;
    private Boolean precoDaBase;
    private Date adicionadoTime;
    private Date alteradoTime;
    private int produtoTipoId;
    private ProdutoTipo produtoTipo;
}