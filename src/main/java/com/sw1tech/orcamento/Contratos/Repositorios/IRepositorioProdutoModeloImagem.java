package com.sw1tech.orcamento.Contratos.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sw1tech.orcamento.Entidades.ProdutoModeloImagem;

public interface IRepositorioProdutoModeloImagem extends JpaRepository<ProdutoModeloImagem, Long> {
    
}
