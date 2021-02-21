package com.sw1tech.orcamento.Contratos.Servicos;

import com.sw1tech.orcamento.Entidades.Financeiro;

import java.math.BigDecimal;
import java.util.Date;

public interface IServicoFinanceiro extends IServico<Financeiro> {
    Integer doBaixar(int id, Date dtBaixa, BigDecimal vlrBaixa);
    Integer doEstornarBaixa(int id);
}
