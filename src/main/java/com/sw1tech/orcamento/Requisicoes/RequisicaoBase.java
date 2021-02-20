package com.sw1tech.orcamento.Requisicoes;

import java.util.ArrayList;
import java.util.List;

public abstract class RequisicaoBase {
    List<String> lstMensagens;

    public abstract boolean doValidar();
    public abstract List<String> doObterMensagens();

    public RequisicaoBase(){
        lstMensagens = new ArrayList<>();
    }

}
