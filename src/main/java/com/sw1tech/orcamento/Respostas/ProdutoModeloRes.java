package com.sw1tech.orcamento.Respostas;

import java.math.BigDecimal;

import com.sw1tech.orcamento.Entidades.Produto;
import com.sw1tech.orcamento.Entidades.ProdutoModeloImagem;

import lombok.Data;

@Data()
public class ProdutoModeloRes {
    private int id;
    private String nome;
    private BigDecimal largura;
    private BigDecimal comprimento;
    private BigDecimal altura;
    private BigDecimal espessura;
    private int produtoAcabadoId;
    private int produtoBaseId;
    
    private Produto produtoAcabado;
    private Produto produtoBase;
    
    private ProdutoModeloImagem produtoModeloImagem;
    
	/*
	 * Mesmo caso da entidade ProdutoModelo
	 *  private Set<ProdutoModeloComponente> produtoModeloComponente; */
}