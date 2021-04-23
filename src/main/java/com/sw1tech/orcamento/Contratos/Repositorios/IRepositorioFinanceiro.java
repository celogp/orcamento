package com.sw1tech.orcamento.Contratos.Repositorios;

import com.sw1tech.orcamento.Entidades.Financeiro;
import com.sw1tech.orcamento.Respostas.FinanceiroMesRes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface IRepositorioFinanceiro extends JpaRepository<Financeiro, Integer>, CustomizedFinanceiroRepository {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update TFinanceiros f set f.dtbaixa = :dtbaixa, f.pendente = false where f.id = :id", nativeQuery = true)
    Integer doBaixar(@Param("id") Integer id,
                     @Param("dtbaixa") Date dtbaixa);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update TFinanceiros f set f.dtbaixa = null, f.pendente = true where f.id = :id", nativeQuery = true)
    Integer doEstornarBaixa(@Param("id") Integer id);

/*    @Query(value = "select \n" +
            "f.anoref, f.mesref, f.receita, f.valor   \n" +
            "from VFinanceiroMes f \n" +
            "where f.anoref = :ano \n", nativeQuery = true)*/

/*
    @Query(value = "SELECT \n" +
            " new com.sw1tech.orcamento.Respostas.FinanceiroMesRes(YEAR(f.DTMOVIMENTO), MONTH(f.DTMOVIMENTO), f.RECEITA, SUM(f.VLRFINANCEIRO) ) \n" +
            "FROM TFinanceiros f \n" +
            "WHERE YEAR(f.DTMOVIMENTO) = :ano \n" +
            "GROUP BY YEAR(f.DTMOVIMENTO), MONTH(f.DTMOVIMENTO), f.RECEITA", nativeQuery = true)
    List<FinanceiroMesRes> doObterFinanceirosMes(@Param("ano") Integer ano);
*/

}
