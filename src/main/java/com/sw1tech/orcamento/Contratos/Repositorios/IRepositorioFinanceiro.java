package com.sw1tech.orcamento.Contratos.Repositorios;

import com.sw1tech.orcamento.Entidades.Financeiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositorioFinanceiro extends JpaRepository<Financeiro, Integer> {

}
