package com.sw1tech.orcamento.Respostas;

import com.sw1tech.orcamento.Entidades.Parceiro;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class FinanceiroRes {
    private int id;
    private int nroDocumento;
    private boolean receita;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date dtMovimento;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date dtVencimento;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date dtBaixa;
    private String historico;
    private BigDecimal vlrFinanceiro;
    private int parceiroId;
    private Parceiro parceiro;
    private boolean pendente;
}
