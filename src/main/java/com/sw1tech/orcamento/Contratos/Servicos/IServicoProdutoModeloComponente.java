package com.sw1tech.orcamento.Contratos.Servicos;

import java.util.List;

import com.sw1tech.orcamento.Entidades.ProdutoModeloComponente;

public interface IServicoProdutoModeloComponente extends IServico<ProdutoModeloComponente>{

	List<ProdutoModeloComponente> doObterTodosPorModeloId(Long id);
}
