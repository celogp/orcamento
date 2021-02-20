package com.sw1tech.orcamento.Controles;

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

    @GetMapping("/doObterUfs")
    public ResponseEntity<ObjetoResposta> doObterUfs(){
        var _lstAllEufs = _repoUf.findAll();
        var _objResposta = new ObjetoResposta(_lstAllEufs);
        return new ResponseEntity(_objResposta, HttpStatus.OK);
    };

    @GetMapping("/doObterSexos")
    public ResponseEntity<ObjetoResposta> doObterSexos(){
        var _lstAllEufs = _repoSexo.findAll();
        var _objResposta = new ObjetoResposta(_lstAllEufs);
        return new ResponseEntity(_objResposta, HttpStatus.OK);
    };


}
