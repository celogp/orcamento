package com.sw1tech.orcamento.Entidades;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity(name = "TFINANCEIROS")
public class Financeiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="recdesp")
    private int recdesp;

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

    @Column(name="vlrbaixa")
    private BigDecimal vlrBaixa;

    @ManyToOne()
    @JoinColumn(name = "parceiroid", referencedColumnName = "id")
    private Parceiro parceiro;

    @Column(name="dtretorno")
    @Temporal(TemporalType.DATE)
    private Date dtRetorno;

    @Column(name="dtaux")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dtAux;

}
