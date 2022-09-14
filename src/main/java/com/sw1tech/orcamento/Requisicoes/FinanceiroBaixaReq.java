package com.sw1tech.orcamento.Requisicoes;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FinanceiroBaixaReq extends RequisicaoBase {
	private Long id;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date dtMovimento;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date dtBaixa;
    private BigDecimal vlrFinanceiro;
    private boolean pendente;

    @Override
    public boolean doValidar() {
        this.doValidarId();
        this.doValidarDtBaixa();
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
        if (this.pendente == false){
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

    private void doValidarJaBaixado() {
        if ( (this.dtBaixa != null) && (this.pendente == false) ) {
            this.lstMensagens.add("Atenção !, Financeiro já foi baixado.");
        }
    }

}
