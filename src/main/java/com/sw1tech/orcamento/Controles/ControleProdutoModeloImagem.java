package com.sw1tech.orcamento.Controles;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sw1tech.orcamento.Contratos.Controles.IControleProdutoModeloImagem;
import com.sw1tech.orcamento.Entidades.ProdutoModeloImagem;
import com.sw1tech.orcamento.Requisicoes.ProdutoModeloImagemReq;
import com.sw1tech.orcamento.Respostas.ObjetoResposta;
import com.sw1tech.orcamento.Servicos.ServicoProdutoModelo;
import com.sw1tech.orcamento.Servicos.ServicoProdutoModeloImagem;

@RestController
@RequestMapping("produtosmodelosimagem")
public class ControleProdutoModeloImagem implements IControleProdutoModeloImagem{

    @Autowired
    ServicoProdutoModeloImagem servicosProdutoModeloImagem;

    @Autowired
    ServicoProdutoModelo servicosProdutoModelo;
    
	@Override
	public ResponseEntity<ObjetoResposta> doSalvar(ProdutoModeloImagemReq produtoModeloImagemReq) {
		var produtoModeloImagem = new ProdutoModeloImagem();
        try {
			produtoModeloImagem.setId(produtoModeloImagemReq.getId());
			produtoModeloImagem.setConteudo(produtoModeloImagemReq.getConteudo().getBytes());
			
		} catch (IOException e) {
            var objResposta = new ObjetoResposta(e.toString());
            return new ResponseEntity<>(objResposta, HttpStatus.BAD_REQUEST);
		}
        var objResposta = new ObjetoResposta(
                servicosProdutoModeloImagem.doAtualizar(produtoModeloImagem)
        );
        return new ResponseEntity<>(objResposta, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<ObjetoResposta> doApagar(Long id) {
		if (id<=0){
            var objResposta = new ObjetoResposta(id);
            return new ResponseEntity<>(objResposta, HttpStatus.BAD_REQUEST);
        }
		servicosProdutoModeloImagem.doApagar(id);
        var objResposta = new ObjetoResposta(id);
        return new ResponseEntity<>(objResposta, HttpStatus.OK);
	}
  
}
