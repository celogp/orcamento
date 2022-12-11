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
@Entity(name = "TORCAMENTOSITENSCOMPONENTES")
public class OrcamentoItemComponente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="quantidade")
    private BigDecimal quantidade;

    @Column(name="vlrunitario")
    private BigDecimal vlrUnitario;

    @Column(name="vlrbruto")
    private BigDecimal vlrBruto;
    
    @Column(name="percdesconto")
    private BigDecimal percDesconto;

    @Column(name="vlrdesconto")
    private BigDecimal vlrDesconto;
    
    @Column(name="vlrliquido")
    private BigDecimal vlrLiquido;

    @Column(name="largura")
    private BigDecimal largura;

    @Column(name="comprimento")
    private BigDecimal comprimento;

    @Column(name="espessura")
    private BigDecimal espessura;

    @Column(name="area")
    private BigDecimal area;
    
    @ManyToOne()
    @JoinColumn(name = "produtoid", referencedColumnName = "id")
    private Produto produto;
    
    @Column(name="volume")
    private String volume;

    @ManyToOne()
    @JoinColumn(name = "orcamentoitemid", referencedColumnName = "id")
    private OrcamentoItem orcamentoItem;    
	
}
