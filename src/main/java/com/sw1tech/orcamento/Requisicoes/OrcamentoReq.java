package com.sw1tech.orcamento.Requisicoes;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = true)
public class OrcamentoReq extends RequisicaoBase {
	
	private Long id;
	private Long numero;
	private String descricao;
    private Boolean bloqueado;
    private Date dtMovimento;    
    private Date dtEntrega;   
    private BigDecimal vlrTotalItens;
    private BigDecimal vlrDesconto;
    private BigDecimal percDesconto;
    private BigDecimal vlrTotal;
    private Long parceiroId;

	@Override
	public boolean doValidar() {
		doValidaParceiroId();
		doValidaVlrTotal();
		doValidaNumero();
		return lstMensagens.isEmpty();
	}

	@Override
	public List<String> doObterMensagens() {
		return lstMensagens;
	}

    private void doValidaParceiroId() {
        if (parceiroId == 0) {
            lstMensagens.add("Atenção ! Id do parceiro não foi informado.");
        }
    }
    
    private void doValidaVlrTotal() {
    	if (vlrTotal.compareTo(BigDecimal.ZERO) <0 ) {
            lstMensagens.add("Atenção ! Total do orçamento não pode ser menor que zero.");
        }
    }
    
    private void doValidaNumero() {
    	if (numero <=0 ) {
            lstMensagens.add("Atenção ! Número do orçamento não pode ser menor ou igual a zero.");
        }
    }
	
}
