package com.sw1tech.orcamento.Requisicoes;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrcamentoItemReq extends RequisicaoBase {
	
    private Long id;
    private BigDecimal quantidade;
    private BigDecimal vlrUnitario;
    private BigDecimal vlrBruto;
    private BigDecimal percDesconto;
    private BigDecimal vlrDesconto;
    private BigDecimal vlrLiquido;
    private BigDecimal largura;
    private BigDecimal comprimento;
    private BigDecimal espessura;
    private BigDecimal area;
    private String ambiente;
    private Long produtoId;
    private String volume;
    private Long orcamentoId;    
    private Long produtoModeloId;
	
	@Override
	public boolean doValidar() {
		doValidaOrcamentoId();
	    doValidaProdutoId();
	    doValidaQuantidade();
	    doValidaVlrUnitario();
	    doValidaLargura();
	    doValidaComprimento();	
		return lstMensagens.isEmpty();
	}

	@Override
	public List<String> doObterMensagens() {
		return lstMensagens;
	}

    private void doValidaOrcamentoId() {
        if (orcamentoId == 0) {
            lstMensagens.add("Atenção ! Id do Orçamento não foi informado.");
        }
    }
	
    private void doValidaProdutoId() {
    	if (produtoId==0) {
            lstMensagens.add("Atenção ! Id do Produto não foi informado.");
        }
    }

    private void doValidaQuantidade() {
    	if (quantidade.compareTo(BigDecimal.ZERO) <=0 ) {
            lstMensagens.add("Atenção ! Quantidade do item não pode ser menor igual a zero.");
        }
    }
    
    private void doValidaVlrUnitario() {
    	if (vlrUnitario.compareTo(BigDecimal.ZERO) <=0) {
            lstMensagens.add("Atenção ! Valor unitário do item não pode ser menor igual a zero.");
        }
    }    
    
    private void doValidaLargura() {
    	if (largura.compareTo(BigDecimal.ZERO) <=0) {
            lstMensagens.add("Atenção ! Largura do item não pode ser menor igual a zero.");
        }
    }    

    private void doValidaComprimento() {
    	if (comprimento.compareTo(BigDecimal.ZERO) <=0) {
            lstMensagens.add("Atenção ! Comprimento do item não pode ser menor igual a zero.");
        }
    }	
}
