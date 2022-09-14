package com.sw1tech.orcamento.Controles;

import com.sw1tech.orcamento.Contratos.Controles.IControleLocalizacao;
import com.sw1tech.orcamento.Entidades.Localizacao;
import com.sw1tech.orcamento.Requisicoes.LocalizacaoReq;
import com.sw1tech.orcamento.Respostas.LocalizacaoRes;
import com.sw1tech.orcamento.Respostas.ObjetoResposta;
import com.sw1tech.orcamento.Servicos.ServicoLocalizacao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("localizacoes")
public class ControleLocalizacao implements IControleLocalizacao {

    @Autowired
    ServicoLocalizacao _servicoLocalizacao;

    @Autowired
    ModelMapper _modelMapper;

    private LocalizacaoRes doMapperEntityToRes(Localizacao localizacao){
        return _modelMapper.map(localizacao, LocalizacaoRes.class);
    }

    private Localizacao doMapperReqToEntity(LocalizacaoReq localizacaoReq){
        return _modelMapper.map(localizacaoReq, Localizacao.class);
    }

    @Override
    public ResponseEntity<ObjetoResposta> doObterTodos() {
        var lstLocalizacao = _servicoLocalizacao.doObterTodos()
                .stream()
                .map(this::doMapperEntityToRes)
                .collect(Collectors.toList());
        var _objResposta = new ObjetoResposta(lstLocalizacao);
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ObjetoResposta> doObterPorId(Long id) {
        var _objResposta =  new ObjetoResposta(
                doMapperEntityToRes(_servicoLocalizacao.doObterPorId(id).orElseGet(Localizacao::new))
        );
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ObjetoResposta> doAdicionar(LocalizacaoReq _requisicao) {
        if (!_requisicao.doValidar()){
            var _objResposta = new ObjetoResposta(null, _requisicao.doObterMensagens());
            return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.BAD_REQUEST);
        }
        var _localizacao = doMapperReqToEntity(_requisicao);
        var _objResposta = new ObjetoResposta(
                 _servicoLocalizacao.doAdicionar(_localizacao)
        );
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ObjetoResposta> doAtualizar(LocalizacaoReq _requisicao) {
        if (!_requisicao.doValidar()){
            final ObjetoResposta _objResposta = new ObjetoResposta( _requisicao.getId(), _requisicao.doObterMensagens());
            return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.BAD_REQUEST);
        }
        var _localizacao = doMapperReqToEntity(_requisicao);
        var _objResposta = new ObjetoResposta(
                _servicoLocalizacao.doAtualizar(_localizacao)
        );
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);    }

    @Override
    public ResponseEntity<ObjetoResposta> doApagar(Long id) {
        if (id<=0){
            var _objResposta = new ObjetoResposta(id);
            return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.BAD_REQUEST);
        }
        _servicoLocalizacao.doApagar(id);
        var _objResposta = new ObjetoResposta(id);
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
    }
}
