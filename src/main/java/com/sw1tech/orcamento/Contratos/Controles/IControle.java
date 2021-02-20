package com.sw1tech.orcamento.Contratos.Controles;

import com.sw1tech.orcamento.Respostas.ObjetoResposta;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

public interface IControle<ObjetoRequisicao> {

    @GetMapping("/doObterTodos")
    ResponseEntity<ObjetoResposta> doObterTodos();

    @GetMapping("/doObterPorId")
    ResponseEntity<ObjetoResposta> doObterPorId(@Validated @RequestParam(name = "id") final int id);

    @PostMapping("/doAdicionar")
    ResponseEntity<ObjetoResposta> doAdicionar(@Validated @RequestBody final ObjetoRequisicao _objRequisicao);

    @PutMapping("/doAtualizar")
    ResponseEntity<ObjetoResposta> doAtualizar(@Validated @RequestBody final ObjetoRequisicao _objRequisicao);

    @DeleteMapping("/doApagar")
    ResponseEntity<ObjetoResposta> doApagar(@Validated @RequestParam(name = "id") final int id);

}
