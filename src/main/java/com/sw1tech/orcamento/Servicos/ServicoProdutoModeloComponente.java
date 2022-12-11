package com.sw1tech.orcamento.Servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw1tech.orcamento.Contratos.Repositorios.IRepositorioProdutoModeloComponente;
import com.sw1tech.orcamento.Contratos.Servicos.IServicoProdutoModeloComponente;
import com.sw1tech.orcamento.Entidades.ProdutoModeloComponente;

@Service
public class ServicoProdutoModeloComponente implements IServicoProdutoModeloComponente{

    @Autowired
    IRepositorioProdutoModeloComponente _rep;

    @Override
    public ProdutoModeloComponente doAdicionar(ProdutoModeloComponente produtoModeloComponente) {
        return _rep.save(produtoModeloComponente);    
    }

    @Override
    public Long doApagar(Long id) {
    	_rep.deleteById(id);
        return id;
    }

    @Override
    public ProdutoModeloComponente doAtualizar(ProdutoModeloComponente produtoModeloComponente) {
        return _rep.save(produtoModeloComponente);
    }

    @Override
    public Optional<ProdutoModeloComponente> doObterPorId(Long id) {
        return _rep.findById(id);
    }

    @Override
    public List<ProdutoModeloComponente> doObterTodos() {
        return _rep.findAll();
    }

	@Override
	public List<ProdutoModeloComponente> doObterTodosPorModeloId(Long id) {
		return _rep.findByProdutoModeloId(id);
	}
    
}
