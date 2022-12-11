package com.sw1tech.orcamento.Contratos.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sw1tech.orcamento.Entidades.OrcamentoItemComponente;

public interface IRepositorioOrcamentoItemComponente  extends JpaRepository<OrcamentoItemComponente, Long>{

	 final String _updateTotalOrcamentoItem = "UPDATE TORCAMENTOSITENS SET "
				+ " vlrunitario    = (SELECT SUM(i.vlrLiquido) FROM TORCAMENTOSITENSCOMPONENTES I WHERE I.orcamentoItemId = :orcamentoItemId) / quantidade "
				+ " ,vlrbruto      = (SELECT SUM(i.vlrLiquido) FROM TORCAMENTOSITENSCOMPONENTES I WHERE I.orcamentoItemid = :orcamentoItemId) "
				+ " ,vlrliquido    = (SELECT SUM(i.vlrLiquido) FROM TORCAMENTOSITENSCOMPONENTES I WHERE I.orcamentoItemid = :orcamentoItemId) - vlrDesconto "
				+ "WHERE id = :orcamentoItemId ";

	
	@Query("SELECT compon FROM TORCAMENTOSITENSCOMPONENTES compon WHERE compon.orcamentoItem.id = :orcamentoItemId")
	public List<OrcamentoItemComponente> doObterPorOrcamentoItemId(@Param("orcamentoItemId") Long orcamentoItemId);

    @Transactional
    @Modifying(clearAutomatically = true)
	@Query(value = _updateTotalOrcamentoItem, nativeQuery = true)
	public void doSaveTotalOrcamentoItem(@Param("orcamentoItemId") Long orcamentoItemId);
	
}
