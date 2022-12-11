package com.sw1tech.orcamento.Contratos.Controles;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sw1tech.orcamento.Requisicoes.OrcamentoItemReq;
import com.sw1tech.orcamento.Respostas.ObjetoResposta;

public interface IControleOrcamentoItem extends IControle<OrcamentoItemReq> {

	
    @GetMapping("/doObterPorOrcamentoId")
    ResponseEntity<ObjetoResposta> doObterPorOrcamentoId(@Validated @RequestParam(name = "orcamentoId") final Long orcamentoId);
	
}
