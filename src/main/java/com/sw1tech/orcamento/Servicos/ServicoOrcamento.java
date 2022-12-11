package com.sw1tech.orcamento.Servicos;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw1tech.orcamento.Contratos.Repositorios.IRepositorioOrcamento;
import com.sw1tech.orcamento.Contratos.Servicos.IServicoOrcamento;
import com.sw1tech.orcamento.Entidades.Orcamento;

@Service
public class ServicoOrcamento implements IServicoOrcamento {

    @Autowired
    IRepositorioOrcamento _repositorioOrcamento;

	@Override
	public Orcamento doAdicionar(Orcamento orcamento) {
		return _repositorioOrcamento.save(orcamento);
	}

	@Override
	public Long doApagar(Long id) {
        _repositorioOrcamento.deleteById(id);
        return id;
	}

	@Override
	public Orcamento doAtualizar(Orcamento orcamento) {
        return _repositorioOrcamento.save(orcamento);
	}

    @Override
    public Optional<Orcamento> doObterPorId(Long id) {
        return _repositorioOrcamento.findById(id);
    }

    @Override
    public List<Orcamento> doObterTodos() {
        return _repositorioOrcamento.findAll();
    }
}
