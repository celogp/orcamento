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
@Entity(name = "TORCAMENTOS")
public class Orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="numero")
    private Long numero;

    @Column(name="descricao")
    private String descricao;
    
    @Column(name="bloqueado")
    private Boolean bloqueado;
    
    @Temporal(value=TemporalType.DATE)
    @Column(name="dtmovimento")
    private Date dtMovimento;

    @Temporal(value=TemporalType.DATE)
    @Column(name="dtentrega")
    private Date dtEntrega;   
    
    @Column(name="vlrtotalitens")
    private BigDecimal vlrTotalItens;

    @Column(name="vlrdesconto")
    private BigDecimal vlrDesconto;
    
    @Column(name="percdesconto")
    private BigDecimal percDesconto;

    @Column(name="vlrtotal")
    private BigDecimal vlrTotal;

    @ManyToOne()
    @JoinColumn(name = "parceiroid", referencedColumnName = "id")
    private Parceiro parceiro;
    
}
