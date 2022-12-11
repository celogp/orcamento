package com.sw1tech.orcamento.Controles;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sw1tech.orcamento.Contratos.Controles.IControleOrcamentoItem;
import com.sw1tech.orcamento.Entidades.OrcamentoItem;
import com.sw1tech.orcamento.Requisicoes.OrcamentoItemReq;
import com.sw1tech.orcamento.Respostas.ObjetoResposta;
import com.sw1tech.orcamento.Respostas.OrcamentoItemRes;
import com.sw1tech.orcamento.Servicos.ServicoOrcamentoItem;

@RestController
@RequestMapping("orcamentositens")
public class ControleOrcamentoItem  implements IControleOrcamentoItem{

    @Autowired
    ServicoOrcamentoItem _servicosOrcamentoItem;
	
	
    @Autowired
    ModelMapper _modelMapper;

    private OrcamentoItemRes doMapperEntityToRes(OrcamentoItem orcamentoItem){

        return _modelMapper.map(orcamentoItem, OrcamentoItemRes.class);
    }

    private OrcamentoItem doMapperReqToEntity(OrcamentoItemReq orcamentoItemReq){
        return _modelMapper.map(orcamentoItemReq, OrcamentoItem.class);
    }
	
	@Override
	public ResponseEntity<ObjetoResposta> doObterTodos() {
        var lstOrcamentoItem = _servicosOrcamentoItem.doObterTodos()
                .stream()
                .map(this::doMapperEntityToRes)
                .collect(Collectors.toList());
        var _objResposta = new ObjetoResposta(lstOrcamentoItem);
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ObjetoResposta> doObterPorId(Long id) {
        final ObjetoResposta _objResposta =  new ObjetoResposta(
                doMapperEntityToRes(_servicosOrcamentoItem.doObterPorId(id).orElseGet(OrcamentoItem::new))
        );
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ObjetoResposta> doAdicionar(OrcamentoItemReq _requisicao) {
        if (!_requisicao.doValidar()){
            var _objResposta = new ObjetoResposta(null, _requisicao.doObterMensagens());
            return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.BAD_REQUEST);
        }
        var _orcamentoItem = doMapperReqToEntity(_requisicao);
        var _objResposta = new ObjetoResposta(
                _servicosOrcamentoItem.doAdicionar(_orcamentoItem)
        );
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ObjetoResposta> doAtualizar(OrcamentoItemReq _requisicao) {
        if (!_requisicao.doValidar()){
            var _objResposta = new ObjetoResposta(_requisicao, _requisicao.doObterMensagens());
            return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.BAD_REQUEST);
        }
        var _orcamentoItem = _modelMapper.map(_requisicao, OrcamentoItem.class);
        var _objResposta = new ObjetoResposta(
                _servicosOrcamentoItem.doAtualizar(_orcamentoItem)
        );
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ObjetoResposta> doApagar(Long id) {
        if (id<=0){
            var _objResposta = new ObjetoResposta(id);
            return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.BAD_REQUEST);
        }
        _servicosOrcamentoItem.doApagar(id);
       // _servicosOrcamentoItem.doSaveTotalOrcamento(_requisicao.getOrcamentoId());
        var _objResposta = new ObjetoResposta(id);
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ObjetoResposta> doObterPorOrcamentoId(Long orcamentoId) {
		// TODO Auto-generated method stub
        var lstOrcamentoItem = _servicosOrcamentoItem.doObterPorOrcamentoId(orcamentoId)
                .stream()
                .map(this::doMapperEntityToRes)
                .collect(Collectors.toList());
        var _objResposta = new ObjetoResposta(lstOrcamentoItem);
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
	}

}