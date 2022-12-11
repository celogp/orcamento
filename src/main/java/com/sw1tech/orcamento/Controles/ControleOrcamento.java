package com.sw1tech.orcamento.Controles;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sw1tech.orcamento.Contratos.Controles.IControleOrcamento;
import com.sw1tech.orcamento.Entidades.Orcamento;
import com.sw1tech.orcamento.Requisicoes.OrcamentoReq;
import com.sw1tech.orcamento.Respostas.ObjetoResposta;
import com.sw1tech.orcamento.Respostas.OrcamentoRes;
import com.sw1tech.orcamento.Servicos.ServicoOrcamento;

@RestController
@RequestMapping("orcamentos")
public class ControleOrcamento  implements IControleOrcamento{

    @Autowired
    ServicoOrcamento _servicosOrcamento;
	
	
    @Autowired
    ModelMapper _modelMapper;

    private OrcamentoRes doMapperEntityToRes(Orcamento orcamento){

        return _modelMapper.map(orcamento, OrcamentoRes.class);
    }

    private Orcamento doMapperReqToEntity(OrcamentoReq orcamentoReq){
        return _modelMapper.map(orcamentoReq, Orcamento.class);
    }
	
	@Override
	public ResponseEntity<ObjetoResposta> doObterTodos() {
        var lstOrcamento = _servicosOrcamento.doObterTodos()
                .stream()
                .map(this::doMapperEntityToRes)
                .collect(Collectors.toList());
        var _objResposta = new ObjetoResposta(lstOrcamento);
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ObjetoResposta> doObterPorId(Long id) {
        final ObjetoResposta _objResposta =  new ObjetoResposta(
                doMapperEntityToRes(_servicosOrcamento.doObterPorId(id).orElseGet(Orcamento::new))
        );
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ObjetoResposta> doAdicionar(OrcamentoReq _requisicao) {
        if (!_requisicao.doValidar()){
            var _objResposta = new ObjetoResposta(null, _requisicao.doObterMensagens());
            return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.BAD_REQUEST);
        }
        var _orcamento = doMapperReqToEntity(_requisicao);
        var _objResposta = new ObjetoResposta(
                _servicosOrcamento.doAdicionar(_orcamento)
        );
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ObjetoResposta> doAtualizar(OrcamentoReq _requisicao) {
        if (!_requisicao.doValidar()){
            var _objResposta = new ObjetoResposta(_requisicao, _requisicao.doObterMensagens());
            return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.BAD_REQUEST);
        }
        var _orcamento = _modelMapper.map(_requisicao, Orcamento.class);
        var _objResposta = new ObjetoResposta(
                _servicosOrcamento.doAtualizar(_orcamento)
        );
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ObjetoResposta> doApagar(Long id) {
        if (id<=0){
            var _objResposta = new ObjetoResposta(id);
            return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.BAD_REQUEST);
        }
        _servicosOrcamento.doApagar(id);
        var _objResposta = new ObjetoResposta(id);
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
	}

}