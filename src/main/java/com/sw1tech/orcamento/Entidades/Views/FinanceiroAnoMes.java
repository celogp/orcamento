package com.sw1tech.orcamento.Views;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Immutable
@Table(name = "VFINANCEIROMES")
public class VFinanceiroMes {
    @Id
    private int id;
    private int anoref;
    private int mesref;
    private boolean receita;
    private BigDecimal valor;
}
