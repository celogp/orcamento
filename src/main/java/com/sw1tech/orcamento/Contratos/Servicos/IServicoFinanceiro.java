package com.sw1tech.orcamento.Contratos.Servicos;

import com.sw1tech.orcamento.Entidades.Financeiro;
import com.sw1tech.orcamento.Views.VFinanceiroMes;

import java.util.Date;
import java.util.List;

public interface IServicoFinanceiro extends IServico<Financeiro> {
    Integer doBaixar(int id, Date dtBaixa);
    Integer doEstornarBaixa(int id);
    List<VFinanceiroMes> doObterFinanceirosMes(int ano);
}
