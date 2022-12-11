package com.sw1tech.orcamento.Servicos;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.sw1tech.orcamento.Contratos.Repositorios.IRepositorioOrcamentoItemComponente;
import com.sw1tech.orcamento.Entidades.OrcamentoItemComponente;
import com.sw1tech.orcamento.Entidades.Enum.ProdutoTipoEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw1tech.orcamento.Contratos.Repositorios.IRepositorioOrcamentoItem;
import com.sw1tech.orcamento.Contratos.Repositorios.IRepositorioProdutoModelo;
import com.sw1tech.orcamento.Contratos.Repositorios.IRepositorioProdutoModeloComponente;
import com.sw1tech.orcamento.Contratos.Servicos.IServicoOrcamentoItem;
import com.sw1tech.orcamento.Entidades.OrcamentoItem;

@Service
public class ServicoOrcamentoItem implements IServicoOrcamentoItem {

    @Autowired
    IRepositorioOrcamentoItem _repositorioOrcamentoItem;

	@Autowired
	IRepositorioOrcamentoItemComponente _repositorioOrcamentoItemComponente;


    @Autowired
    IRepositorioProdutoModelo _repositorioProdutoModelo;
    
    @Autowired
    IRepositorioProdutoModeloComponente _repositorioProdutoModeloComponente;
    
	@Override
	public OrcamentoItem doAdicionar(OrcamentoItem orcamentoItem) {
		var _orcamentoItem = _repositorioOrcamentoItem.save(orcamentoItem);
		doSaveTotalOrcamento(orcamentoItem.getOrcamento().getId());
		return _orcamentoItem;
	}

	@Override
	public Long doApagar(Long id) {
		var _orcamentoItem = _repositorioOrcamentoItem.findById(id);
        _repositorioOrcamentoItem.deleteById(id);
		doSaveTotalOrcamento(_orcamentoItem.get().getOrcamento().getId());
        return id;
	}

	@Override
	public OrcamentoItem doAtualizar(OrcamentoItem orcamentoItem) {
		var _orcamentoItem = _repositorioOrcamentoItem.save(orcamentoItem);
		doSaveTotalOrcamento(orcamentoItem.getOrcamento().getId());
        return _orcamentoItem;
	}

    @Override
    public Optional<OrcamentoItem> doObterPorId(Long id) {
        return _repositorioOrcamentoItem.findById(id);
    }

    @Override
    public List<OrcamentoItem> doObterPorOrcamentoId(Long orcamentoId) {
		return _repositorioOrcamentoItem.doObterPorOrcamentoId(orcamentoId);
    }

	@Override
	public List<OrcamentoItem> doObterTodos() {
		return _repositorioOrcamentoItem.findAll();
	}

	private void doSaveTotalOrcamento(Long orcamentoId) {
		_repositorioOrcamentoItem.doSaveTotalOrcamento(orcamentoId);
	}

	@Override
	public OrcamentoItem doAdicionarComModelo(OrcamentoItem orcamentoItem, Long produtoModeloId) {
		var _orcamentoItem = _repositorioOrcamentoItem.save(orcamentoItem);
		var _lstOrcamentoItemComponente = _repositorioProdutoModeloComponente.findByProdutoModeloId(produtoModeloId);
		var _produtoModelo = _repositorioProdutoModelo.findById(produtoModeloId);
		var usaPrecoDaBase = _produtoModelo.get().getProdutoBase().getPrecoDaBase();

		var _orcamentoItemComponente =  new OrcamentoItemComponente();

		_lstOrcamentoItemComponente.forEach( item -> {
			if (item.getProduto().getProdutoTipo().getId() == ProdutoTipoEnum.SERVICO.ordinal()){
				_orcamentoItemComponente.setQuantidade(BigDecimal.ONE);
			}else{
				_orcamentoItemComponente.setQuantidade(_orcamentoItem.getQuantidade().multiply( item.getQuantidade() ) );
			}
			if (usaPrecoDaBase){
				_orcamentoItemComponente.setVlrUnitario(_produtoModelo.get().getProdutoBase().getPrecoTabela());
			}else{
				_orcamentoItemComponente.setVlrUnitario(item.getProduto().getPrecoTabela());
			}
			_orcamentoItemComponente.setVlrBruto(_orcamentoItemComponente.getQuantidade().multiply(_orcamentoItemComponente.getVlrUnitario()));
			_orcamentoItemComponente.setVlrLiquido(_orcamentoItemComponente.getVlrBruto());

			_orcamentoItemComponente.setProduto(item.getProduto());
			_orcamentoItemComponente.setVolume(item.getProduto().getVolume());
			_orcamentoItemComponente.setLargura(_orcamentoItem.getLargura());
			_orcamentoItemComponente.setComprimento(_orcamentoItem.getComprimento());
			_orcamentoItemComponente.setArea(_orcamentoItem.getArea());
			_orcamentoItemComponente.setEspessura(_orcamentoItem.getEspessura());

			_repositorioOrcamentoItemComponente.save(_orcamentoItemComponente);

		});

		doSaveTotalOrcamento(orcamentoItem.getOrcamento().getId());
		return _orcamentoItem;
	}
	
}
