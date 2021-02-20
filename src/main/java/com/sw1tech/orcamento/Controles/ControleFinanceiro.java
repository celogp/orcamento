package com.sw1tech.orcamento.Controles;

import com.sw1tech.orcamento.Contratos.Controles.IControleFinanceiro;
import com.sw1tech.orcamento.Entidades.Financeiro;
import com.sw1tech.orcamento.Requisicoes.FinanceiroReq;
import com.sw1tech.orcamento.Respostas.FinanceiroRes;
import com.sw1tech.orcamento.Respostas.ObjetoResposta;
import com.sw1tech.orcamento.Servicos.ServicoFinanceiro;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.stream.Collectors;

@RestController
@RequestMapping("financeiros")
public class ControleFinanceiro implements IControleFinanceiro {

    @Autowired
    ServicoFinanceiro _servicosFinanceiro;

    @Autowired
    ModelMapper _modelMapper;

    private FinanceiroRes doMapperEntityToRes(Financeiro financeiro){

        return _modelMapper.map(financeiro, FinanceiroRes.class);
    }

    private Financeiro doMapperReqToEntity(FinanceiroReq financeiroReq){
        return _modelMapper.map(financeiroReq, Financeiro.class);
    }

    @Override
    public ResponseEntity<ObjetoResposta> doObterTodos() {
        var lstFinanceiro = _servicosFinanceiro.doObterTodos()
                .stream()
                .map(this::doMapperEntityToRes)
                .collect(Collectors.toList());

        var _objResposta = new ObjetoResposta(lstFinanceiro);

        return new ResponseEntity(_objResposta, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ObjetoResposta> doObterPorId(int id) {
        final ObjetoResposta _objResposta =  new ObjetoResposta(
                doMapperEntityToRes(_servicosFinanceiro.doObterPorId(id).orElseGet(Financeiro::new))
        );
        return new ResponseEntity(_objResposta, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ObjetoResposta> doAdicionar(FinanceiroReq _requisicao) {
        if (!_requisicao.doValidar()){
            var _objResposta = new ObjetoResposta(null, _requisicao.doObterMensagens());
            return new ResponseEntity(_objResposta, HttpStatus.BAD_REQUEST);
        }
        var _financeiro = doMapperReqToEntity(_requisicao);
        var _objResposta = new ObjetoResposta(
                _servicosFinanceiro.doAdicionar(_financeiro).getId()
        );
        return new ResponseEntity(_objResposta, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity doAtualizar(FinanceiroReq _requisicao) {
        if (!_requisicao.doValidar()){
            var _objResposta = new ObjetoResposta(_requisicao, _requisicao.doObterMensagens());
            return new ResponseEntity(_objResposta, HttpStatus.BAD_REQUEST);
        }
        var _financeiro = _modelMapper.map(_requisicao, Financeiro.class);
        //var _dt = _financeiro.getDtVencimento().toString("YYYY-DD-MM");

         var _objResposta = new ObjetoResposta(
                _servicosFinanceiro.doAtualizar(_financeiro).getId()
        );
        return new ResponseEntity(_objResposta, HttpStatus.OK);
    }

    @Override
    public ResponseEntity doApagar(int id) {
        if (id<=0){
            var _objResposta = new ObjetoResposta(id);
            return new ResponseEntity(_objResposta, HttpStatus.BAD_REQUEST);
        }
        _servicosFinanceiro.doApagar(id);
        var _objResposta = new ObjetoResposta(id);
        return new ResponseEntity(_objResposta, HttpStatus.OK);
    }
}