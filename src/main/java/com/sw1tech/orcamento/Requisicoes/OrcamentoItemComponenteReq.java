package com.sw1tech.orcamento.Requisicoes;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrcamentoItemComponenteReq extends RequisicaoBase {
	
    private Long id;
    private BigDecimal quantidade;
    private BigDecimal vlrUnitario;
    private BigDecimal vlrBruto;
    private BigDecimal percDesconto;
    private BigDecimal vlrDesconto;
    private BigDecimal vlrLiquido;
    private BigDecimal largura = BigDecimal.ZERO;
    
    private BigDecimal comprimento;
    private BigDecimal espessura;
    private BigDecimal area;
    
    private Long produtoId;
    private String volume;
    private Long orcamentoItemId;    
	
	
	@Override
	public boolean doValidar() {
		doValidaOrcamentoItemId();
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

    private void doValidaOrcamentoItemId() {
        if (orcamentoItemId == 0) {
            lstMensagens.add("Atenção ! Id do Orçamento do item não foi informado.");
        }
    }
	
    private void doValidaProdutoId() {
    	if (produtoId==0) {
            lstMensagens.add("Atenção ! Id do Produto do componente não foi informado.");
        }
    }

    private void doValidaQuantidade() {
    	if (quantidade.compareTo(BigDecimal.ZERO) <=0 ) {
            lstMensagens.add("Atenção ! Quantidade do item do componente não pode ser menor igual a zero.");
        }
    }
    
    private void doValidaVlrUnitario() {
    	if (vlrUnitario.compareTo(BigDecimal.ZERO) <=0) {
            lstMensagens.add("Atenção ! Valor unitário do item do componente não pode ser menor igual a zero.");
        }
    }    
    
    private void doValidaLargura() {
    	if (largura.compareTo(BigDecimal.ZERO) <=0) {
            lstMensagens.add("Atenção ! Largura do item do componente não pode ser menor igual a zero.");
        }
    }    

    private void doValidaComprimento() {
    	if (comprimento.compareTo(BigDecimal.ZERO) <=0) {
            lstMensagens.add("Atenção ! Comprimento do item do componente não pode ser menor igual a zero.");
        }
    }        
}
