package com.sw1tech.orcamento.Servicos;

import java.util.List;
import java.util.Optional;

import com.sw1tech.orcamento.Contratos.Repositorios.IRepositorioProduto;
import com.sw1tech.orcamento.Contratos.Servicos.IServicoProduto;
import com.sw1tech.orcamento.Entidades.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoProduto implements IServicoProduto{

    @Autowired
    IRepositorioProduto _repositoriosProduto;

    @Override
    public Produto doAdicionar(Produto produto) {
        return _repositoriosProduto.save(produto);    
    }

    @Override
    public Long doApagar(Long id) {
        _repositoriosProduto.deleteById(id);
        return id;
    }

    @Override
    public Produto doAtualizar(Produto produto) {
        return _repositoriosProduto.save(produto);
    }

    @Override
    public Optional<Produto> doObterPorId(Long id) {
        return _repositoriosProduto.findById(id);
    }

    @Override
    public List<Produto> doObterTodos() {
        return _repositoriosProduto.findAll();
    }
    
}
