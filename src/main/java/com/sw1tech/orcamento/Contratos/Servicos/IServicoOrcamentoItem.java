package com.sw1tech.orcamento.Contratos.Servicos;

import java.util.List;

import com.sw1tech.orcamento.Entidades.OrcamentoItem;

public interface IServicoOrcamentoItem  extends IServico<OrcamentoItem> {
	
    List<OrcamentoItem> doObterPorOrcamentoId(final Long orcamentoId);
	OrcamentoItem doAdicionarComModelo(OrcamentoItem orcamentoItem, Long produtoModeloId);
    
    
}
