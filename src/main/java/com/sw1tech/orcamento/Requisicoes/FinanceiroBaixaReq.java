package com.sw1tech.orcamento.Requisicoes;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class FinanceiroBaixaReq extends RequisicaoBase {
    private int id;
    private Date dtMovimento;
    private Date dtBaixa;
    private BigDecimal vlrFinanceiro;
    private BigDecimal vlrBaixa;

    @Override
    public boolean doValidar() {
        this.doValidarId();
        this.doValidarDtBaixa();
        this.doValidarVlrBaixa();
        this.doValidarJaBaixado();
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

    private void doValidarDtBaixa(){
        if (this.vlrBaixa.compareTo(BigDecimal.ZERO)>0){
            if (this.dtBaixa == null) {
                this.lstMensagens.add("Atenção !, Data da baixa está null.");
            }else{
                if (this.dtMovimento != null) {
                    if (this.dtBaixa.before(this.dtMovimento)) {
                        this.lstMensagens.add("Atenção !, Data da baixa está anterior a data de movimento.");
                    }
                }
            }
        }
    }

    private void doValidarVlrBaixa() {
        if (this.dtBaixa != null){
            if (this.vlrBaixa == null) {
                this.lstMensagens.add("Atenção !, Valor da baixa está null.");
            }else {
                if (this.vlrBaixa.compareTo(BigDecimal.ZERO) == 0) {
                    this.lstMensagens.add("Atenção !, Valor da baixa está sem valor.");
                }

                if (this.vlrBaixa.compareTo(BigDecimal.ZERO) < 0) {
                    this.lstMensagens.add("Atenção !, Valor da baixa não pode ser menor que zero.");
                }
                if (this.vlrBaixa.compareTo(this.vlrFinanceiro) != 0) {
                    this.lstMensagens.add("Atenção !, Valor da baixa não pode ser diferente do valor do financeiro.");
                }
            }
        }
    }

    private void doValidarJaBaixado() {
        if ( (this.dtBaixa != null) || this.vlrBaixa.compareTo(BigDecimal.ZERO) !=0) {
            this.lstMensagens.add("Atenção !, Financeiro já foi baixado.");
        }
    }

}
