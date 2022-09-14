package com.sw1tech.orcamento.Contratos.Servicos;

import java.util.Date;
import java.util.List;

import com.sw1tech.orcamento.Entidades.Financeiro;
import com.sw1tech.orcamento.Entidades.Views.FinanceiroAnoMes;

public interface IServicoFinanceiro extends IServico<Financeiro> {
    Long doBaixar(Long id, Date dtBaixa);
    Long doEstornarBaixa(Long id);
    List<FinanceiroAnoMes> doObterFinanceirosMes(int ano);
}
