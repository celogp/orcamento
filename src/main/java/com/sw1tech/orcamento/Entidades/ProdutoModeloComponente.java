package com.sw1tech.orcamento.Entidades;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name = "TPRODUTOSMODELOSCOMPONENTE")
public class ProdutoModeloComponente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="quantidade")
    private BigDecimal quantidade;
    
    @Column(name="produtomodeloid")
    private Long produtoModeloId;
    
    @ManyToOne()
    @JoinColumn(name = "produtoid", referencedColumnName = "id")
    private Produto produto;
}
