package com.sw1tech.orcamento.Requisicoes;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data()
@EqualsAndHashCode(callSuper = true)
public class ProdutoModeloReq extends RequisicaoBase {
    private Long id;
    private String nome;
    private BigDecimal largura;
    private BigDecimal comprimento;
    private BigDecimal espessura;
    private int produtoAcabadoId;
    private int produtoBaseId;

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


