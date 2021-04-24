package com.sw1tech.orcamento.Contratos.Repositorios;

import com.sw1tech.orcamento.Views.VFinanceiroMes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositorioVFinanceiroMes extends JpaRepository<VFinanceiroMes, Integer> {
    @Query(value = "select \n" +
        "f.id, f.anoref, f.mesref, f.receita, f.valor   \n" +
        "from VFINANCEIROMES f \n" +
        "where f.anoref = :ano \n" +
        "order by f.anoref, f.mesref \n", nativeQuery = true)
    List<VFinanceiroMes> doObterFinanceirosMesV(@Param("ano") Integer ano);

}
