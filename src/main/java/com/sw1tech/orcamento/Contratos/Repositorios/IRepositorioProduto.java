package com.sw1tech.orcamento.Contratos.Repositorios;

import com.sw1tech.orcamento.Entidades.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositorioProduto extends JpaRepository<Produto, Long> {
    
}
