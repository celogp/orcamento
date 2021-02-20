package com.sw1tech.orcamento.Requisicoes;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
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
    private Date dtRetorno;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dtAux;

    @Override
    public boolean doValidar() {
        return true;
    }

    @Override
    public List<String> doObterMensagens() {
        return null;
    }
}
