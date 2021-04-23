package com.sw1tech.orcamento.Contratos.Controles;

import com.sw1tech.orcamento.Requisicoes.FinanceiroBaixaReq;
import com.sw1tech.orcamento.Requisicoes.FinanceiroReq;
import com.sw1tech.orcamento.Respostas.ObjetoResposta;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface IControleFinanceiro extends IControle<FinanceiroReq> {

    @PutMapping("/doBaixar")
    ResponseEntity<ObjetoResposta> doBaixar(@Validated @RequestBody final FinanceiroBaixaReq _requisicao);

    @PutMapping("/doEstornarBaixa")
    ResponseEntity<ObjetoResposta> doEstornarBaixa(@Validated @RequestParam(name = "id") final int id);

    @GetMapping("/doObterFinanceirosMes")
    ResponseEntity<ObjetoResposta> doObterFinanceirosMes(@Validated @RequestParam(name = "ano") final int ano);
}
