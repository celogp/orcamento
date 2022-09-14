package com.sw1tech.orcamento.Entidades.Views;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "TFINANCEIROANOMES")
public class FinanceiroAnoMes {
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getAnoref() {
		return anoref;
	}
	public void setAnoref(int anoref) {
		this.anoref = anoref;
	}
	public int getMesref() {
		return mesref;
	}
	public void setMesref(int mesref) {
		this.mesref = mesref;
	}
	public boolean isReceita() {
		return receita;
	}
	public void setReceita(boolean receita) {
		this.receita = receita;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	@Id
    private Long id;
    private int anoref;
    private int mesref;
    private boolean receita;
    private BigDecimal valor;
}
