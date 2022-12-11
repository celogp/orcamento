package com.sw1tech.orcamento.Requisicoes;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data()
@EqualsAndHashCode(callSuper = true)
public class ProdutoModeloImagemReq extends RequisicaoBase {
    private Long id;
    private MultipartFile conteudo;  

    @Override
    public boolean doValidar() {
    	doValidaId();
        return lstMensagens.isEmpty();
    }
    @Override 
    public List<String> doObterMensagens() {
    	return lstMensagens;
    }
    
    private void doValidaId() {
        if ((id == null) || ( id == 0 )) {
            lstMensagens.add("Atenção ! Número do Id não foi informado");
        }
    }    
}


