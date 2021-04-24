package com.sw1tech.orcamento.Respostas;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class VFinanceiroMesRes {

    private int id;
    private int anoref;
    private int mesref;
    private boolean receita;
    private BigDecimal valor;
}
