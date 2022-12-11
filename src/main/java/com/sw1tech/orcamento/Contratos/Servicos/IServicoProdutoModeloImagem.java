package com.sw1tech.orcamento.Contratos.Servicos;

import java.util.Optional;

import com.sw1tech.orcamento.Entidades.ProdutoModeloImagem;

public interface IServicoProdutoModeloImagem {

    Long doApagar(Long id);
    ProdutoModeloImagem doAtualizar(ProdutoModeloImagem produtoModeloImagem);
    Optional<ProdutoModeloImagem> doObterPorId(Long id);

}
