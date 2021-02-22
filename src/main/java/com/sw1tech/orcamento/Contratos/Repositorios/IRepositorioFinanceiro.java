package com.sw1tech.orcamento.Contratos.Repositorios;

import com.sw1tech.orcamento.Entidades.Financeiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

@Repository
public interface IRepositorioFinanceiro extends JpaRepository<Financeiro, Integer> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update TFinanceiros f set f.dtbaixa = :dtbaixa, f.pendente = false where f.id = :id", nativeQuery = true)
    Integer doBaixar(@Param("id") Integer id,
                     @Param("dtbaixa") Date dtbaixa);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update TFinanceiros f set f.dtbaixa = null, f.pendente = true where f.id = :id", nativeQuery = true)
    Integer doEstornarBaixa(@Param("id") Integer id);
}
