package com.sw1tech.orcamento.Contratos.Repositorios;

import com.sw1tech.orcamento.Entidades.ProdutoTipo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositorioProdutoTipo extends JpaRepository<ProdutoTipo, Long>{
    
}