package com.sw1tech.orcamento.Contratos.Repositorios;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sw1tech.orcamento.Entidades.Financeiro;

@Repository
public interface IRepositorioFinanceiro extends JpaRepository<Financeiro, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update TFinanceiros f set f.dtbaixa = :dtbaixa, f.pendente = false where f.id = :id", nativeQuery = true)
    Long doBaixar(@Param("id") Long id,
                     @Param("dtbaixa") Date dtbaixa);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update TFinanceiros f set f.dtbaixa = null, f.pendente = true where f.id = :id", nativeQuery = true)
    Long doEstornarBaixa(@Param("id") Long id);

	/*
	 * @Query(value = "select \n" +
	 * "f.id, f.anoref, f.mesref, f.receita, f.valor   \n" +
	 * "from VFINANCEIROANOMES f \n" + "where f.anoref = :ano \n" +
	 * "order by f.anoref, f.mesref \n", nativeQuery = true) List<FinanceiroAnoMes>
	 * doObterFinanceirosMesV(@Param("ano") Integer ano);
	 */
}
