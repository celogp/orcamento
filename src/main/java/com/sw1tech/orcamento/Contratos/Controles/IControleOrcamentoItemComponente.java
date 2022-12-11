package com.sw1tech.orcamento.Contratos.Controles;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sw1tech.orcamento.Requisicoes.OrcamentoItemComponenteReq;
import com.sw1tech.orcamento.Respostas.ObjetoResposta;

public interface IControleOrcamentoItemComponente extends IControle<OrcamentoItemComponenteReq> {

    @GetMapping("/doObterPorOrcamentoItemId")
    ResponseEntity<ObjetoResposta> doObterPorOrcamentoItemId(@Validated @RequestParam(name = "orcamentoItemId") final Long orcamentoItemId);

}
