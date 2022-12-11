package com.sw1tech.orcamento.Servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw1tech.orcamento.Contratos.Repositorios.IRepositorioProdutoModeloImagem;
import com.sw1tech.orcamento.Contratos.Servicos.IServicoProdutoModeloImagem;
import com.sw1tech.orcamento.Entidades.ProdutoModeloImagem;

@Service
public class ServicoProdutoModeloImagem implements IServicoProdutoModeloImagem{

    @Autowired
    IRepositorioProdutoModeloImagem repositorio;

    @Override
    public Long doApagar(Long id) {
    	repositorio.deleteById(id);
        return id;
    }

    @Override
    public ProdutoModeloImagem doAtualizar(ProdutoModeloImagem produtoModeloImagem) {
        return repositorio.save(produtoModeloImagem);
    }

    @Override
    public Optional<ProdutoModeloImagem> doObterPorId(Long id) {
        return repositorio.findById(id);
    }
    
}
