package com.sw1tech.orcamento.Requisicoes;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ParceiroReq extends RequisicaoBase {

	private int id;
    private String razao; //maximo de 100
    private String nome; // maximo de 100
    private int localizacaoId; // chave estrangeira
    private String cnpj; // maximo de 14
    private String inscricao; // maximo de 14
    private String cpf; // maximo de 11
    private String identidade; // maximo de 16
    private String email; // maximo de 100
    private int sexoId;
    private String fone; // maximo de 12
    private String celular; // maximo de 12
    private String contato; //  VARCHAR(100),
    private String foneContato; // maximo de 12
    private String celularContato; // maximo de 12
    private boolean celularContatoIsWhatsApp; // maximo de 1
    private boolean celularIsWhatsApp; // maximo de 1

    @Override
    public boolean doValidar() {
        doValidaCpf();
        doValidaCnpj();
        doValidaFone();
        doValidaEmail();
        return lstMensagens.isEmpty();
    }

    @Override
    public List<String> doObterMensagens() {
        return lstMensagens;
    }

    private void doValidaCpf() {
        if (cpf == null) {
            lstMensagens.add("Atenção ! Cpf do parceiro está nullo");
        }else if ((cpf.isBlank()) && (cpf.isEmpty())) {
            lstMensagens.add("Atenção ! Cpf do parceiro está vazio");
        } else if (cpf.length() < 11) {
            lstMensagens.add("Atenção ! Cpf do parceiro não contem todos os digitos.");
        }
    }

    private void doValidaCnpj(){
        if (cnpj != null) {
            if ((cnpj.isBlank()) && (cnpj.isEmpty())) {
                lstMensagens.add("Atenção ! Cnpj do parceiro está vazio");
            } else if (cnpj.length() < 14) {
                lstMensagens.add("Atenção ! Cnpj do parceiro não contem todos os digitos");
            }
        }
    }

    private void doValidaFone(){
        if (fone != null) {
            if ((fone.isBlank()) && (fone.isEmpty())) {
                lstMensagens.add("Atenção ! Telefone do parceiro está vazio");
            } else if (fone.length() < 11) {
                lstMensagens.add("Atenção ! Telefone do parceiro não contem todos os digitos");
            }
        }
    }

    private void doValidaEmail(){
        if (email != null) {
            if ((email.isBlank()) && (email.isEmpty())) {
                lstMensagens.add("Atenção ! Email do parceiro está vazio.");
            }
        }
    }

}
