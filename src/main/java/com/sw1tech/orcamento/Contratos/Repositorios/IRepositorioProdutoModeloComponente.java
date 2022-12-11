package com.sw1tech.orcamento.Contratos.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sw1tech.orcamento.Entidades.ProdutoModeloComponente;

public interface IRepositorioProdutoModeloComponente extends JpaRepository<ProdutoModeloComponente, Long> {
	
    List<ProdutoModeloComponente> findByProdutoModeloId(Long produtoModeloId);
	
}
