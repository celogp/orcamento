package com.sw1tech.orcamento.Entidades;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;

@Data
@Entity(name = "TPRODUTOSMODELOS")
public class ProdutoModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome")
    private String nome;
    
    @Column(name="largura")
    private BigDecimal largura;
    
    @Column(name="comprimento")
    private BigDecimal comprimento;
    
    @Column(name="espessura")
    private BigDecimal espessura;
    
    @ManyToOne()
    @JoinColumn(name = "produtoacabadoid", referencedColumnName = "id")
    private Produto produtoAcabado;

    @ManyToOne()
    @JoinColumn(name = "produtobaseid", referencedColumnName = "id")
    private Produto produtoBase;

    @OneToOne()
    @PrimaryKeyJoinColumn
    private ProdutoModeloImagem produtomodeloimagem;
    
	/*
	 * 
	 * Comentado apenas para ficar salvo a forma de fazer, e dessa forma quando atualiza essa entidade o hibernate reclama
	 * do campo produtomodeloId que está null, pois ele tenta atualizar o filho.
	 * 
	 * @OneToMany()
	 * 
	 * @JoinColumn(name = "produtomodeloid") private Set<ProdutoModeloComponente>
	 * produtoModeloComponente;
	 */    
}
