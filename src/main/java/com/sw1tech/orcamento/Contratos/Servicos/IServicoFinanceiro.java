package com.sw1tech.orcamento.Contratos.Servicos;

import com.sw1tech.orcamento.Entidades.Financeiro;

import java.util.Date;

public interface IServicoFinanceiro extends IServico<Financeiro> {
    Integer doBaixar(int id, Date dtBaixa);
    Integer doEstornarBaixa(int id);
}
