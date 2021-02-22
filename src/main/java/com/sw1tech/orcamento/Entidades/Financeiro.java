package com.sw1tech.orcamento.Entidades;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity(name = "TFINANCEIROS")
public class Financeiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="receita")
    private boolean receita;

    @Column(name="dtmovimento")
    private Date dtMovimento;

    @Column(name="dtvencimento")
    private Date dtVencimento;

    @Column(name="dtbaixa")
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
