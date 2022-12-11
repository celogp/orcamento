package com.sw1tech.orcamento.Controles;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sw1tech.orcamento.Contratos.Controles.IControleProdutoModelo;
import com.sw1tech.orcamento.Entidades.ProdutoModelo;
import com.sw1tech.orcamento.Requisicoes.ProdutoModeloReq;
import com.sw1tech.orcamento.Respostas.ObjetoResposta;
import com.sw1tech.orcamento.Respostas.ProdutoModeloRes;
import com.sw1tech.orcamento.Servicos.ServicoProdutoModelo;

@RestController
@RequestMapping("produtosmodelos")
public class ControleProdutoModelo implements IControleProdutoModelo{

    @Autowired
    ServicoProdutoModelo servicosProdutoModelo;
    
    @Autowired
    ModelMapper modelMapper;

    private ProdutoModeloRes doMapperEntityToRes(ProdutoModelo produtoModelo){

        return modelMapper.map(produtoModelo, ProdutoModeloRes.class);
    }

    private ProdutoModelo doMapperReqToEntity(ProdutoModeloReq produtoModeloReq){
        return modelMapper.map(produtoModeloReq, ProdutoModelo.class);
    }


    @Override
    public ResponseEntity<ObjetoResposta> doObterTodos() {
        var lstProdutoModelo = servicosProdutoModelo.doObterTodos()
                .stream()
                .map(this::doMapperEntityToRes)
                .toList();
                //.collect(Collectors.toList());
        var objResposta = new ObjetoResposta(lstProdutoModelo);
        return new ResponseEntity<>(objResposta, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ObjetoResposta> doObterPorId(Long id) {
        final ObjetoResposta objResposta =  new ObjetoResposta(
                doMapperEntityToRes(servicosProdutoModelo.doObterPorId(id).orElseGet(ProdutoModelo::new))
        );
        return new ResponseEntity<>(objResposta, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ObjetoResposta> doAdicionar(ProdutoModeloReq produtoModeloReq) {
        if (!produtoModeloReq.doValidar()){
            var objResposta = new ObjetoResposta(null, produtoModeloReq.doObterMensagens());
            return new ResponseEntity<>(objResposta, HttpStatus.BAD_REQUEST);
        }
        var produtoModelo = doMapperReqToEntity(produtoModeloReq);
        var objResposta = new ObjetoResposta(
                servicosProdutoModelo.doAdicionar(produtoModelo)
        );
        return new ResponseEntity<>(objResposta, HttpStatus.CREATED);        
    }

    @Override
    public ResponseEntity<ObjetoResposta> doAtualizar(ProdutoModeloReq produtoModeloReq) {
        if (!produtoModeloReq.doValidar()){
            var objResposta = new ObjetoResposta(produtoModeloReq, produtoModeloReq.doObterMensagens());
            return new ResponseEntity<>(objResposta, HttpStatus.BAD_REQUEST);
        }
        var produto = modelMapper.map(produtoModeloReq, ProdutoModelo.class);
        var objResposta = new ObjetoResposta(
                servicosProdutoModelo.doAtualizar(produto)
        );
        return new ResponseEntity<>(objResposta, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ObjetoResposta> doApagar(Long id) {
        if (id<=0){
            var objResposta = new ObjetoResposta(id);
            return new ResponseEntity<>(objResposta, HttpStatus.BAD_REQUEST);
        }
        servicosProdutoModelo.doApagar(id);
        var objResposta = new ObjetoResposta(id);
        return new ResponseEntity<>(objResposta, HttpStatus.OK);
    }

    
}
