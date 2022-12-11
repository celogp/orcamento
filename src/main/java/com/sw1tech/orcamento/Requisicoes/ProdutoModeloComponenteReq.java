package com.sw1tech.orcamento.Requisicoes;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data()
@EqualsAndHashCode(callSuper = true)
public class ProdutoModeloComponenteReq extends RequisicaoBase {
    private Long id;
    private BigDecimal quantidade;
    private Long produtoModeloId;
    private Long produtoId;
    
    @Override
    public boolean doValidar() {
    	doValidaProdutoModeloId();
    	doValidaProdutoId();
        return lstMensagens.isEmpty();
    }
    
    @Override
    public List<String> doObterMensagens() {
    	return lstMensagens;
    }
    
    private void doValidaProdutoModeloId() {
        if ((produtoModeloId == null) || ( produtoModeloId == 0 )) {
            lstMensagens.add("Atenção ! Número do Id do Modelo não foi informado");
        }
    }
    
    private void doValidaProdutoId() {
        if ((produtoId == null) || ( produtoId == 0 )) {
            lstMensagens.add("Atenção ! Número do Id do Produto não foi informado");
        }
    }      
    
}


