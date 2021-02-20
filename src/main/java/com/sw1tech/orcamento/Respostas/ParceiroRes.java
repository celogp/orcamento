package com.sw1tech.orcamento.Respostas;

import com.sw1tech.orcamento.Entidades.Localizacao;
import com.sw1tech.orcamento.Entidades.Sexo;
import lombok.Data;

@Data
public class ParceiroRes {

    private int id;
    private String razao;
    private String nome;
    private int localizacaoId;
    private String cnpj;
    private String inscricao;
    private String cpf;
    private String identidade;
    private String email;
    private int sexoId;
    private String fone;
    private String celular;
    private boolean celularIsWhatsApp;
    private String contato;
    private String foneContato;
    private String celularContato;
    private boolean celularContatoIsWhatsApp;
    private Localizacao localizacao;
    private Sexo sexo;

}
