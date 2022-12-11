package com.sw1tech.orcamento.Entidades;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity(name = "TPRODUTOS")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome")
    private String nome;
    
    @Column(name="volume")
    private String volume;

    @Column(name="preco")
    private BigDecimal precoTabela;
    
    @Column(name="custo")
    private BigDecimal custoGerencial;
    
    @Column(name="estoque")
    private BigDecimal estoque;

    @Column(name="ativo")
    private Boolean ativo;

    @Column(name="precodabase")
    private Boolean precoDaBase;

    @ManyToOne()
    @JoinColumn(name = "produtotipoid", referencedColumnName = "id")
    private ProdutoTipo produtoTipo;
 
    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="adicionado")
    private Date adicionadoTime;
    
    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="alterado")
    private Date alteradoTime;
    
}