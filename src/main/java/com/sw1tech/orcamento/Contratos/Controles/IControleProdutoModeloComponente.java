package com.sw1tech.orcamento.Contratos.Controles;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sw1tech.orcamento.Requisicoes.ProdutoModeloComponenteReq;
import com.sw1tech.orcamento.Respostas.ObjetoResposta;


public interface IControleProdutoModeloComponente extends IControle<ProdutoModeloComponenteReq> {
	
    @GetMapping("/doObterTodosPorModeloId")
    ResponseEntity<ObjetoResposta> doObterTodosPorModeloId(@Validated @RequestParam(name = "id") final Long id);
	
}
