package com.sw1tech.orcamento.Controles;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sw1tech.orcamento.Contratos.Controles.IControleProdutoModeloComponente;
import com.sw1tech.orcamento.Entidades.ProdutoModeloComponente;
import com.sw1tech.orcamento.Requisicoes.ProdutoModeloComponenteReq;
import com.sw1tech.orcamento.Respostas.ObjetoResposta;
import com.sw1tech.orcamento.Respostas.ProdutoModeloComponenteRes;
import com.sw1tech.orcamento.Servicos.ServicoProdutoModeloComponente;

@RestController
@RequestMapping("produtosmodeloscomponentes")
public class ControleProdutoModeloComponente implements IControleProdutoModeloComponente{

    @Autowired
    ServicoProdutoModeloComponente servicosProdutoModeloComponente;
    
    @Autowired
    ModelMapper modelMapper;

    private ProdutoModeloComponenteRes doMapperEntityToRes(ProdutoModeloComponente produtoModeloComponente){

        return modelMapper.map(produtoModeloComponente, ProdutoModeloComponenteRes.class);
    }

    private ProdutoModeloComponente doMapperReqToEntity(ProdutoModeloComponenteReq produtoModeloComponenteReq){
        return modelMapper.map(produtoModeloComponenteReq, ProdutoModeloComponente.class);
    }


    @Override
    public ResponseEntity<ObjetoResposta> doObterTodos() {
        var lstProdutoModeloComponente = servicosProdutoModeloComponente.doObterTodos()
                .stream()
                .map(this::doMapperEntityToRes)
                .toList();
        var objResposta = new ObjetoResposta(lstProdutoModeloComponente);
        return new ResponseEntity<>(objResposta, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ObjetoResposta> doObterPorId(Long id) {
        final ObjetoResposta objResposta =  new ObjetoResposta(
                doMapperEntityToRes(servicosProdutoModeloComponente.doObterPorId(id).orElseGet(ProdutoModeloComponente::new))
        );
        return new ResponseEntity<>(objResposta, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ObjetoResposta> doAdicionar(ProdutoModeloComponenteReq produtoModeloComponenteReq) {
        if (!produtoModeloComponenteReq.doValidar()){
            var objResposta = new ObjetoResposta(null, produtoModeloComponenteReq.doObterMensagens());
            return new ResponseEntity<>(objResposta, HttpStatus.BAD_REQUEST);
        }
        var produtoModeloComponente = doMapperReqToEntity(produtoModeloComponenteReq);
        var objResposta = new ObjetoResposta(
                servicosProdutoModeloComponente.doAdicionar(produtoModeloComponente)
        );
        return new ResponseEntity<>(objResposta, HttpStatus.CREATED);        
    }

    @Override
    public ResponseEntity<ObjetoResposta> doAtualizar(ProdutoModeloComponenteReq produtoModeloComponenteReq) {
        if (!produtoModeloComponenteReq.doValidar()){
            var objResposta = new ObjetoResposta(produtoModeloComponenteReq, produtoModeloComponenteReq.doObterMensagens());
            return new ResponseEntity<>(objResposta, HttpStatus.BAD_REQUEST);
        }
        var produtoModeloComponente = modelMapper.map(produtoModeloComponenteReq, ProdutoModeloComponente.class);
        var objResposta = new ObjetoResposta(
                servicosProdutoModeloComponente.doAtualizar(produtoModeloComponente)
        );
        return new ResponseEntity<>(objResposta, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ObjetoResposta> doApagar(Long id) {
        if (id<=0){
            var objResposta = new ObjetoResposta(id);
            return new ResponseEntity<>(objResposta, HttpStatus.BAD_REQUEST);
        }
        servicosProdutoModeloComponente.doApagar(id);
        var objResposta = new ObjetoResposta(id);
        return new ResponseEntity<>(objResposta, HttpStatus.OK);
    }

	@Override
	public ResponseEntity<ObjetoResposta> doObterTodosPorModeloId(Long id) {
        var lstProdutoModeloComponente = servicosProdutoModeloComponente.doObterTodosPorModeloId(id)
                .stream()
                .map(this::doMapperEntityToRes)
                .toList();
        var objResposta = new ObjetoResposta(lstProdutoModeloComponente);
        return new ResponseEntity<>(objResposta, HttpStatus.OK);
	}
    
}
