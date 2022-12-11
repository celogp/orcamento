package com.sw1tech.orcamento.Contratos.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sw1tech.orcamento.Entidades.Views.FinanceiroAnoMes;

@Repository
public interface IRepositorioFinanceiroAnoMes extends JpaRepository<FinanceiroAnoMes, Long>{
    
	@Query(value = "select \n" +
            "f.id, f.anoref, f.mesref, f.receita, f.valor   \n" +
            "from VFINANCEIROANOMES f \n" +
            "where f.anoref = :ano \n" +
            "order by f.anoref, f.mesref \n", nativeQuery = true)
    List<FinanceiroAnoMes> doObterFinanceirosMesV(@Param("ano") Integer ano);
}