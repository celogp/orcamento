package com.sw1tech.orcamento.Controles;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sw1tech.orcamento.Contratos.Controles.IControleOrcamentoItemComponente;
import com.sw1tech.orcamento.Entidades.OrcamentoItemComponente;
import com.sw1tech.orcamento.Requisicoes.OrcamentoItemComponenteReq;
import com.sw1tech.orcamento.Respostas.ObjetoResposta;
import com.sw1tech.orcamento.Respostas.OrcamentoItemComponenteRes;
import com.sw1tech.orcamento.Servicos.ServicoOrcamentoItemComponente;

@RestController
@RequestMapping("orcamentositenscomponentes")
public class ControleOrcamentoItemComponente  implements IControleOrcamentoItemComponente{

    @Autowired
    ServicoOrcamentoItemComponente _servicosOrcamentoItemComponente;
	
    @Autowired
    ModelMapper _modelMapper;

    private OrcamentoItemComponenteRes doMapperEntityToRes(OrcamentoItemComponente orcamentoItemComponente){

        return _modelMapper.map(orcamentoItemComponente, OrcamentoItemComponenteRes.class);
    }

    private OrcamentoItemComponente doMapperReqToEntity(OrcamentoItemComponenteReq orcamentoItemComponenteReq){
        return _modelMapper.map(orcamentoItemComponenteReq, OrcamentoItemComponente.class);
    }
	
	@Override
	public ResponseEntity<ObjetoResposta> doObterTodos() {
        var lstOrcamentoItemComponente = _servicosOrcamentoItemComponente.doObterTodos()
                .stream()
                .map(this::doMapperEntityToRes)
                .collect(Collectors.toList());
        var _objResposta = new ObjetoResposta(lstOrcamentoItemComponente);
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ObjetoResposta> doObterPorId(Long id) {
        final ObjetoResposta _objResposta =  new ObjetoResposta(
                doMapperEntityToRes(_servicosOrcamentoItemComponente.doObterPorId(id).orElseGet(OrcamentoItemComponente::new))
        );
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ObjetoResposta> doAdicionar(OrcamentoItemComponenteReq _requisicao) {
        if (!_requisicao.doValidar()){
            var _objResposta = new ObjetoResposta(null, _requisicao.doObterMensagens());
            return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.BAD_REQUEST);
        }
        var _orcamentoItemComponente = doMapperReqToEntity(_requisicao);
        var _objResposta = new ObjetoResposta(
                _servicosOrcamentoItemComponente.doAdicionar(_orcamentoItemComponente)
        );
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ObjetoResposta> doAtualizar(OrcamentoItemComponenteReq _requisicao) {
        if (!_requisicao.doValidar()){
            var _objResposta = new ObjetoResposta(_requisicao, _requisicao.doObterMensagens());
            return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.BAD_REQUEST);
        }
        var _orcamentoItemComponente = _modelMapper.map(_requisicao, OrcamentoItemComponente.class);
        var _objResposta = new ObjetoResposta(
                _servicosOrcamentoItemComponente.doAtualizar(_orcamentoItemComponente)
        );
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ObjetoResposta> doApagar(Long id) {
        if (id<=0){
            var _objResposta = new ObjetoResposta(id);
            return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.BAD_REQUEST);
        }
        _servicosOrcamentoItemComponente.doApagar(id);
        var _objResposta = new ObjetoResposta(id);
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ObjetoResposta> doObterPorOrcamentoItemId(Long orcamentoItemId) {
		// TODO Auto-generated method stub
        var lstOrcamentoItemComponente = _servicosOrcamentoItemComponente.doObterPorOrcamentoItemId(orcamentoItemId)
                .stream()
                .map(this::doMapperEntityToRes)
                .collect(Collectors.toList());
        var _objResposta = new ObjetoResposta(lstOrcamentoItemComponente);
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
	}

}