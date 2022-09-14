package com.sw1tech.orcamento.Controles;

import com.sw1tech.orcamento.Contratos.Repositorios.IRepositorioProdutoTipo;
import com.sw1tech.orcamento.Contratos.Repositorios.IRepositorioSexo;
import com.sw1tech.orcamento.Contratos.Repositorios.IRepositorioUf;
import com.sw1tech.orcamento.Respostas.ObjetoResposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pesquisas")
public class ControlePesquisas {

    @Autowired
    IRepositorioUf _repoUf;

    @Autowired
    IRepositorioSexo _repoSexo;

    @Autowired
    IRepositorioProdutoTipo _repoProdutoTipo;

    @GetMapping("/doObterUfs")
    public ResponseEntity<ObjetoResposta> doObterUfs(){
        var _lstAllufs = _repoUf.findAll();
        var _objResposta = new ObjetoResposta(_lstAllufs);
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
    };

    @GetMapping("/doObterSexos")
    public ResponseEntity<ObjetoResposta> doObterSexos(){
        var _lstAllSexo = _repoSexo.findAll();
        var _objResposta = new ObjetoResposta(_lstAllSexo);
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
    };

    @GetMapping("/doObterProdutoTipo")
    public ResponseEntity<ObjetoResposta> doObterProdutoTipo(){
        var _lstAllProdutoTipo = _repoProdutoTipo.findAll();
        var _objResposta = new ObjetoResposta(_lstAllProdutoTipo);
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
    };

}
