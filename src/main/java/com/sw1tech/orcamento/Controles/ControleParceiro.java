package com.sw1tech.orcamento.Controles;

import com.sw1tech.orcamento.Contratos.Controles.IControleParceiro;
import com.sw1tech.orcamento.Entidades.Parceiro;
import com.sw1tech.orcamento.Requisicoes.ParceiroReq;
import com.sw1tech.orcamento.Respostas.ObjetoResposta;
import com.sw1tech.orcamento.Respostas.ParceiroRes;
import com.sw1tech.orcamento.Servicos.ServicoParceiro;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("parceiros")
public class ControleParceiro implements IControleParceiro {

    @Autowired
    ServicoParceiro _servicosParceiro;

    @Autowired
    ModelMapper _modelMapper;

    private ParceiroRes doMapperEntityToRes(Parceiro parceiro){

        return _modelMapper.map(parceiro, ParceiroRes.class);
    }

    private Parceiro doMapperReqToEntity(ParceiroReq parceiroReq){
        return _modelMapper.map(parceiroReq, Parceiro.class);
    }

    @Override
    public ResponseEntity<ObjetoResposta> doObterTodos() {
        var lstParceiro = _servicosParceiro.doObterTodos()
                .stream()
                .map(this::doMapperEntityToRes)
                .collect(Collectors.toList());
        var _objResposta = new ObjetoResposta(lstParceiro);
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ObjetoResposta> doObterPorId(Long id) {
        final ObjetoResposta _objResposta =  new ObjetoResposta(
                doMapperEntityToRes(_servicosParceiro.doObterPorId(id).orElseGet(Parceiro::new))
        );
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ObjetoResposta> doAdicionar(ParceiroReq _requisicao) {
        if (!_requisicao.doValidar()){
            var _objResposta = new ObjetoResposta(null, _requisicao.doObterMensagens());
            return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.BAD_REQUEST);
        }
        var _parceiro = doMapperReqToEntity(_requisicao);
        var _objResposta = new ObjetoResposta(
                _servicosParceiro.doAdicionar(_parceiro)
        );
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ObjetoResposta> doAtualizar(ParceiroReq _requisicao) {
        if (!_requisicao.doValidar()){
            var _objResposta = new ObjetoResposta(_requisicao, _requisicao.doObterMensagens());
            return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.BAD_REQUEST);
        }
        var _parceiro = _modelMapper.map(_requisicao, Parceiro.class);
        var _objResposta = new ObjetoResposta(
                _servicosParceiro.doAtualizar(_parceiro)
        );
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ObjetoResposta> doApagar(Long id) {
        if (id<=0){
            var _objResposta = new ObjetoResposta(id);
            return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.BAD_REQUEST);
        }
        _servicosParceiro.doApagar(id);
        var _objResposta = new ObjetoResposta(id);
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
    }

}