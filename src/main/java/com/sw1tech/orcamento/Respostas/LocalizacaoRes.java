package com.sw1tech.orcamento.Respostas;

import java.math.BigInteger;

import com.sw1tech.orcamento.Entidades.Uf;

import lombok.Data;

@Data
public class LocalizacaoRes  {
    private int id;
    private String cep; //maximo de 8
    private String logradouro; //maximo de 100
    private String complemento; //maximo de 100
    private String localidade; //maximo de 100
    private int ufId;
    private String bairro; //maximo de 100
    private BigInteger longitude;
    private BigInteger latitude;
    private Uf uf;

}
