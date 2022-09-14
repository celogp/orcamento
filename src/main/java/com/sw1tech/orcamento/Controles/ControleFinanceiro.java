package com.sw1tech.orcamento.Controles;

import com.sw1tech.orcamento.Contratos.Controles.IControleFinanceiro;
import com.sw1tech.orcamento.Entidades.Financeiro;
import com.sw1tech.orcamento.Requisicoes.FinanceiroBaixaReq;
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

import java.math.BigDecimal;
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

        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ObjetoResposta> doObterPorId(Long id) {
        final ObjetoResposta _objResposta =  new ObjetoResposta(
                doMapperEntityToRes(_servicosFinanceiro.doObterPorId(id).orElseGet(Financeiro::new))
        );
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ObjetoResposta> doAdicionar(FinanceiroReq _requisicao) {
        if (!_requisicao.doValidar()){
            var _objResposta = new ObjetoResposta(null, _requisicao.doObterMensagens());
            return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.BAD_REQUEST);
        }
        var _financeiro = doMapperReqToEntity(_requisicao);
        var _objResposta = new ObjetoResposta(
                _servicosFinanceiro.doAdicionar(_financeiro)
        );
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ObjetoResposta> doAtualizar(FinanceiroReq _requisicao) {
        if (!_requisicao.doValidar()){
            var _objResposta = new ObjetoResposta(_requisicao, _requisicao.doObterMensagens());
            return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.BAD_REQUEST);
        }
        var _financeiro = _modelMapper.map(_requisicao, Financeiro.class);
        //var _dt = _financeiro.getDtVencimento().toString("YYYY-DD-MM");

         var _objResposta = new ObjetoResposta(
                _servicosFinanceiro.doAtualizar(_financeiro)
        );
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ObjetoResposta> doApagar(Long id) {
        if (id<=0){
            var _objResposta = new ObjetoResposta(id);
            return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.BAD_REQUEST);
        }
        _servicosFinanceiro.doApagar(id);
        var _objResposta = new ObjetoResposta(id);
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<ObjetoResposta> doBaixar(FinanceiroBaixaReq _requisicao) {
        var _financeiro = _servicosFinanceiro.doObterPorId(_requisicao.getId()).orElseGet(Financeiro::new);
        _requisicao.setDtMovimento(_financeiro.getDtMovimento());
        _requisicao.setVlrFinanceiro(_financeiro.getVlrFinanceiro());
        _requisicao.setPendente(_financeiro.isPendente());

        if ( !_requisicao.doValidar() ) {
            var _objResposta = new ObjetoResposta(_requisicao, _requisicao.doObterMensagens());
            return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.BAD_REQUEST);
        }

        var _objResposta = new ObjetoResposta(
                _servicosFinanceiro.doBaixar(_requisicao.getId(), _requisicao.getDtBaixa())
        );

        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ObjetoResposta> doEstornarBaixa(Long id) {
        if (id<=0){
            var _objResposta = new ObjetoResposta(id);
            return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.BAD_REQUEST);
        }
        var _objResposta = new ObjetoResposta(
                _servicosFinanceiro.doEstornarBaixa(id)
        );
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ObjetoResposta> doObterFinanceirosMes(int ano) {
        var lstFinanceiroMes = _servicosFinanceiro.doObterFinanceirosMes(ano);
        var mesesAno = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        var vlrRecMes = new BigDecimal[]{ BigDecimal.ZERO,
                BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,
                BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,
                BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO};
        var vlrDesMes = vlrRecMes.clone();
        //

        lstFinanceiroMes.stream().forEach((item) -> {
            var mes = item.getMesref();
            var vlr = item.getValor();
            if (item.isReceita()){
                vlrRecMes[mes-1] = vlr;
            }else{
                vlrDesMes[mes-1] = vlr;
            }
        });

        var _resultResp = new Object[]{ mesesAno, vlrRecMes, vlrDesMes};
        var _objResposta = new ObjetoResposta(_resultResp);
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
    }
}