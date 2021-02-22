package com.sw1tech.orcamento.Respostas;

import com.sw1tech.orcamento.Entidades.Parceiro;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class FinanceiroRes {
    private int id;
    private boolean receita;
    private Date dtMovimento;
    private Date dtVencimento;
    private Date dtBaixa;
    private String historico;
    private BigDecimal vlrFinanceiro;
    private int parceiroId;
    private Parceiro parceiro;
    private boolean pendente;
}
