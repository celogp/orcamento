package com.sw1tech.orcamento.Respostas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
public class FinanceiroMesRes {
    private int anoref;
    private int mesref;
    private boolean receita;
    private BigDecimal valor;
}
