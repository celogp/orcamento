package com.sw1tech.orcamento.Contratos.Repositorios;

import com.sw1tech.orcamento.Entidades.ProdutoModelo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositorioProdutoModelo extends JpaRepository<ProdutoModelo, Long> {
    
}
