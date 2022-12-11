package com.sw1tech.orcamento.Servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw1tech.orcamento.Contratos.Repositorios.IRepositorioProdutoModelo;
import com.sw1tech.orcamento.Contratos.Servicos.IServicoProdutoModelo;
import com.sw1tech.orcamento.Entidades.ProdutoModelo;

@Service
public class ServicoProdutoModelo implements IServicoProdutoModelo{

    @Autowired
    IRepositorioProdutoModelo _rep;

    @Override
    public ProdutoModelo doAdicionar(ProdutoModelo produtoModelo) {
        return _rep.save(produtoModelo);    
    }

    @Override
    public Long doApagar(Long id) {
    	_rep.deleteById(id);
        return id;
    }

    @Override
    public ProdutoModelo doAtualizar(ProdutoModelo produtoModelo) {
        return _rep.save(produtoModelo);
    }

    @Override
    public Optional<ProdutoModelo> doObterPorId(Long id) {
        return _rep.findById(id);
    }

    @Override
    public List<ProdutoModelo> doObterTodos() {
        return _rep.findAll();
    }
    
}
