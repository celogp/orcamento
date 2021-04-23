package com.sw1tech.orcamento.Views;

import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Immutable
@Table(name = "VFINANCEIROMES")

public class VFinanceiroMes {
    private int anoref;
    private int mesref;
    private boolean receita;
    private BigDecimal valor;
}
