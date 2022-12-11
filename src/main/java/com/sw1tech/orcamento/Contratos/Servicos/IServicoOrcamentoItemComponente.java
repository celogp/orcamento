package com.sw1tech.orcamento.Contratos.Servicos;

import java.util.List;

import com.sw1tech.orcamento.Entidades.OrcamentoItemComponente;

public interface IServicoOrcamentoItemComponente  extends IServico<OrcamentoItemComponente> {

	List<OrcamentoItemComponente> doObterPorOrcamentoItemId(final Long orcamentoItemId);
	void doAdicionarLstOrcamentoItemComponente(List<OrcamentoItemComponente> LstOrcamentoItemComponente);
}
