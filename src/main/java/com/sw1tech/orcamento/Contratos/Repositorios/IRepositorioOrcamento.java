package com.sw1tech.orcamento.Contratos.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sw1tech.orcamento.Entidades.Orcamento;

public interface IRepositorioOrcamento  extends JpaRepository<Orcamento, Long>{

}
