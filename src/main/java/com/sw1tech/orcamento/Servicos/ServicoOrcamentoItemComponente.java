package com.sw1tech.orcamento.Servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw1tech.orcamento.Contratos.Repositorios.IRepositorioOrcamentoItem;
import com.sw1tech.orcamento.Contratos.Repositorios.IRepositorioOrcamentoItemComponente;
import com.sw1tech.orcamento.Contratos.Servicos.IServicoOrcamentoItemComponente;
import com.sw1tech.orcamento.Entidades.OrcamentoItemComponente;

@Service
public class ServicoOrcamentoItemComponente implements IServicoOrcamentoItemComponente {

    @Autowired
    IRepositorioOrcamentoItemComponente _repositorioOrcamentoItemComponente;

    @Autowired
    IRepositorioOrcamentoItem _repositorioOrcamentoItem;
    
	@Override
	public OrcamentoItemComponente doAdicionar(OrcamentoItemComponente orcamentoItemComponente) {
		var _orcamentoItemComponente = _repositorioOrcamentoItemComponente.save(orcamentoItemComponente);
		doSaveTotalOrcamentoItem(_orcamentoItemComponente.getOrcamentoItem().getId());
		return _orcamentoItemComponente;
	}

	@Override
	public Long doApagar(Long id) {
		var _orcamentoItemComponente = _repositorioOrcamentoItemComponente.findById(id);
        _repositorioOrcamentoItemComponente.deleteById(id);
        doSaveTotalOrcamentoItem(_orcamentoItemComponente.get().getOrcamentoItem().getId());
        return id;
	}

	@Override
	public OrcamentoItemComponente doAtualizar(OrcamentoItemComponente orcamentoItemComponente) {
		var _orcamentoItemComponente = _repositorioOrcamentoItemComponente.save(orcamentoItemComponente);
		doSaveTotalOrcamentoItem(_orcamentoItemComponente.getOrcamentoItem().getId());
        return _orcamentoItemComponente;
	}

    @Override
    public Optional<OrcamentoItemComponente> doObterPorId(Long id) {
        return _repositorioOrcamentoItemComponente.findById(id);
    }

    @Override
    public List<OrcamentoItemComponente> doObterTodos() {
        return _repositorioOrcamentoItemComponente.findAll();
    }

	@Override
	public List<OrcamentoItemComponente> doObterPorOrcamentoItemId(Long orcamentoItemId) {
		return _repositorioOrcamentoItemComponente.doObterPorOrcamentoItemId(orcamentoItemId);
	}
	
	private void doSaveTotalOrcamentoItem(Long orcamentoItemId) {
		var _orcamentoItem = _repositorioOrcamentoItem.findById(orcamentoItemId);
		_repositorioOrcamentoItemComponente.doSaveTotalOrcamentoItem(orcamentoItemId);
		_repositorioOrcamentoItem.doSaveTotalOrcamento(_orcamentoItem.get().getOrcamento().getId());
	}

	@Override
	public void doAdicionarLstOrcamentoItemComponente(List<OrcamentoItemComponente> LstOrcamentoItemComponente) {
		_repositorioOrcamentoItemComponente.saveAll(LstOrcamentoItemComponente);
	}
	
}
