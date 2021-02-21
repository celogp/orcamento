package com.sw1tech.orcamento.Requisicoes;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class FinanceiroReq  extends RequisicaoBase {
    private int id;
    private int recdesp;
    private Date dtMovimento;
    private Date dtVencimento;
    private Date dtBaixa;
    private String historico;
    private BigDecimal vlrFinanceiro;
    private BigDecimal vlrBaixa;
    private int parceiroId;


    @Override
    public boolean doValidar() {
        doValidarDtMovimento();
        doValidarDtVencimento();
        doValidarParceiroId();
        doValidarVlrFinanceiro();
        return this.lstMensagens.isEmpty();
    }

    @Override
    public List<String> doObterMensagens() {
        return this.lstMensagens;
    }

    private void doValidarId(){
        if (this.id == 0) {
            this.lstMensagens.add("Atenção !, Nro.Único do financeiro sem valor.");
        }
    }

    private void doValidarParceiroId() {
        if (this.parceiroId == 0) {
            this.lstMensagens.add("Atenção !, Parceiro não foi informado.");
        }
    }

    private void doValidarDtVencimento() {
        if (this.dtVencimento == null) {
            this.lstMensagens.add("Atenção !, Data de vencimento está null.");
        }
        if (this.dtVencimento.before(this.dtMovimento)) {
            this.lstMensagens.add("Atenção !, Data de vencimento está anterior a data de movimento.");
        }
    }

    private void doValidarDtMovimento() {
        if (this.dtMovimento == null) {
            this.lstMensagens.add("Atenção !, Data de movimento está null.");
        }
    }

    private void doValidarVlrFinanceiro() {
        if (this.vlrFinanceiro.compareTo(BigDecimal.ZERO) == 0) {
            this.lstMensagens.add("Atenção !, Valor do financeiro não pode ser zero.");
        }
        if (this.vlrFinanceiro.compareTo(BigDecimal.ZERO) < 0) {
            this.lstMensagens.add("Atenção !, Valor do financeiro não pode ser negativo.");
        }
    }

}
