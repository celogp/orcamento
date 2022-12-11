package com.sw1tech.orcamento.Controles;

import java.util.stream.Collectors;

import com.sw1tech.orcamento.Contratos.Controles.IControleProduto;
import com.sw1tech.orcamento.Entidades.Produto;
import com.sw1tech.orcamento.Requisicoes.ProdutoReq;
import com.sw1tech.orcamento.Respostas.ObjetoResposta;
import com.sw1tech.orcamento.Respostas.ProdutoRes;
import com.sw1tech.orcamento.Servicos.ServicoProduto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produtos")
public class ControleProduto implements IControleProduto{

    @Autowired
    ServicoProduto _servicosProduto;

    @Autowired
    ModelMapper _modelMapper;

    private ProdutoRes doMapperEntityToRes(Produto produto){

        return _modelMapper.map(produto, ProdutoRes.class);
    }

    private Produto doMapperReqToEntity(ProdutoReq produtoReq){
        return _modelMapper.map(produtoReq, Produto.class);
    }


    @Override
    public ResponseEntity<ObjetoResposta> doObterTodos() {
        var lstProduto = _servicosProduto.doObterTodos()
                .stream()
                .map(this::doMapperEntityToRes)
                .collect(Collectors.toList());
        var _objResposta = new ObjetoResposta(lstProduto);
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ObjetoResposta> doObterPorId(Long id) {
        final ObjetoResposta _objResposta =  new ObjetoResposta(
                doMapperEntityToRes(_servicosProduto.doObterPorId(id).orElseGet(Produto::new))
        );
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ObjetoResposta> doAdicionar(ProdutoReq _produtoReq) {
        if (!_produtoReq.doValidar()){
            var _objResposta = new ObjetoResposta(null, _produtoReq.doObterMensagens());
            return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.BAD_REQUEST);
        }
        var _produto = doMapperReqToEntity(_produtoReq);
        var _objResposta = new ObjetoResposta(
                _servicosProduto.doAdicionar(_produto)
        );
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.CREATED);        
    }

    @Override
    public ResponseEntity<ObjetoResposta> doAtualizar(ProdutoReq _produtoReq) {
        if (!_produtoReq.doValidar()){
            var _objResposta = new ObjetoResposta(_produtoReq, _produtoReq.doObterMensagens());
            return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.BAD_REQUEST);
        }
        var _produto = _modelMapper.map(_produtoReq, Produto.class);
        var _objResposta = new ObjetoResposta(
                _servicosProduto.doAtualizar(_produto)
        );
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ObjetoResposta> doApagar(Long id) {
        if (id<=0){
            var _objResposta = new ObjetoResposta(id);
            return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.BAD_REQUEST);
        }
        _servicosProduto.doApagar(id);
        var _objResposta = new ObjetoResposta(id);
        return new ResponseEntity<ObjetoResposta>(_objResposta, HttpStatus.OK);
    }
    
}
