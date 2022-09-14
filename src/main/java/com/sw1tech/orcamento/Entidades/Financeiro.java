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
@Entity(name = "TFINANCEIROS")
public class Financeiro {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nrodocumento")
    private Long nrodocumento;

    @Column(name="receita")
    private boolean receita;

    @Temporal(value=TemporalType.DATE)
    @Column(name="dtmovimento")
    private Date dtMovimento;

    @Temporal(value=TemporalType.DATE)
    @Column(name="dtvencimento")
    private Date dtVencimento;

    @Column(name="dtbaixa")
    @Temporal(value=TemporalType.DATE)
    private Date dtBaixa;

    @Column(name="historico")
    private String historico;

    @Column(name="vlrfinanceiro")
    private BigDecimal vlrFinanceiro;

    @ManyToOne()
    @JoinColumn(name = "parceiroid", referencedColumnName = "id")
    private Parceiro parceiro;

    @Column(name="pendente")
    private boolean pendente;

}
