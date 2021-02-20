package com.sw1tech.orcamento.Requisicoes;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigInteger;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class LocalizacaoReq extends RequisicaoBase {

    private int id;
    private String cep; //maximo de 8
    private String logradouro; //maximo de 100
    private String complemento; //maximo de 100
    private String localidade; //maximo de 100
    private int ufId; //maximo de 2
    private String bairro; //maximo de 100
    private BigInteger longitude;
    private BigInteger latitude;

    @Override
    public boolean doValidar() {
        doValidaCep();
        return lstMensagens.isEmpty();
    }

    @Override
    public List<String> doObterMensagens() {
        return lstMensagens;
    }

    private void doValidaCep() {
        if (cep == null) {
            lstMensagens.add("Atenção ! Cep está nullo");
        }else if ((cep.isBlank()) && (cep.isEmpty())) {
            lstMensagens.add("Atenção ! Cep está vazio");
        } else if (cep.length() < 8) {
            lstMensagens.add("Atenção ! Cep não contem todos os digitos.");
        }
    }

}
