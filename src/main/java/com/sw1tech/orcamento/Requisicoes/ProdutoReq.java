package com.sw1tech.orcamento.Requisicoes;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data()
@EqualsAndHashCode(callSuper = true)
public class ProdutoReq extends RequisicaoBase {
    private int id;
    private String nome;
    private String volume;
    private BigDecimal precoTabela;
    private BigDecimal custoGerencial;
    private BigDecimal estoque;
    private Boolean ativo;
    private Boolean precoDaBase;
    private int produtoTipoId;
    private Date adicionadoTime;
    private Date alteradoTime;
    
    @Override
    public boolean doValidar() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public List<String> doObterMensagens() {
        // TODO Auto-generated method stub
        return null;
    }
}


