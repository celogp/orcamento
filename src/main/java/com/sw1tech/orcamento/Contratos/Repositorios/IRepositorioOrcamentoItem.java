package com.sw1tech.orcamento.Contratos.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sw1tech.orcamento.Entidades.OrcamentoItem;

public interface IRepositorioOrcamentoItem  extends JpaRepository<OrcamentoItem, Long>, JpaSpecificationExecutor<OrcamentoItem>{

	 final String _updateTotalOrcamento = "UPDATE TORCAMENTOS SET "
			+ "vlrTotalItens = (SELECT SUM(i.vlrLiquido) FROM TORCAMENTOSITENS I WHERE I.orcamentoId = :orcamentoId), "
			+ "vlrTotal      = (SELECT SUM(i.vlrLiquido) FROM TORCAMENTOSITENS I WHERE I.orcamentoId = :orcamentoId) - vlrDesconto "
			+ "WHERE id = :orcamentoId ";
	
	@Query("SELECT item FROM TORCAMENTOSITENS item WHERE item.orcamento.id = :orcamentoId")
	public List<OrcamentoItem> doObterPorOrcamentoId(@Param("orcamentoId") Long orcamentoId);

    @Transactional
    @Modifying(clearAutomatically = true)
	@Query(value = _updateTotalOrcamento, nativeQuery = true)
	public void doSaveTotalOrcamento(@Param("orcamentoId") Long orcamentoId);

}
