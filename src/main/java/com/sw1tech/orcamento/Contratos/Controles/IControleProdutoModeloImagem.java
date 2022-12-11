package com.sw1tech.orcamento.Contratos.Controles;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sw1tech.orcamento.Requisicoes.ProdutoModeloImagemReq;
import com.sw1tech.orcamento.Respostas.ObjetoResposta;

public interface IControleProdutoModeloImagem {
	
    @PostMapping("/doSalvar")
    ResponseEntity<ObjetoResposta> doSalvar(@Validated final ProdutoModeloImagemReq produtoModeloImagemReq);

    @DeleteMapping("/doApagar")
    ResponseEntity<ObjetoResposta> doApagar(@Validated @RequestParam(name = "id") final Long id);
	
}
