package com.sw1tech.orcamento.Servicos;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw1tech.orcamento.Contratos.Repositorios.IRepositorioFinanceiro;
import com.sw1tech.orcamento.Contratos.Repositorios.IRepositorioFinanceiroAnoMes;
import com.sw1tech.orcamento.Contratos.Servicos.IServicoFinanceiro;
import com.sw1tech.orcamento.Entidades.Financeiro;
import com.sw1tech.orcamento.Entidades.Views.FinanceiroAnoMes;

@Service
public class ServicoFinanceiro implements IServicoFinanceiro {

    @Autowired
    IRepositorioFinanceiroAnoMes _repositoriosFinanceiroAnoMes;

	
    @Autowired
    IRepositorioFinanceiro _repositoriosFinanceiro;

    @Override
    public Financeiro doAdicionar(Financeiro financeiro) {
        return _repositoriosFinanceiro.save(financeiro);
    }

    @Override
    public Long doApagar(Long id) {
        _repositoriosFinanceiro.deleteById(id);
        return id;
    }

    @Override
    public Financeiro doAtualizar(Financeiro financeiro) {
        return _repositoriosFinanceiro.save(financeiro);
    }

    @Override
    public Optional<Financeiro> doObterPorId(Long id) {
        return _repositoriosFinanceiro.findById(id);
    }

    @Override
    public List<Financeiro> doObterTodos() {
        return _repositoriosFinanceiro.findAll();
    }

    @Override
    public Long doBaixar(Long id, Date dtBaixa) {
        return _repositoriosFinanceiro.doBaixar(id, dtBaixa);
    }

    @Override
    public Long doEstornarBaixa(Long id) {
        return _repositoriosFinanceiro.doEstornarBaixa(id);
    }

    @Override
    public List<FinanceiroAnoMes> doObterFinanceirosMes(int ano) {
        return _repositoriosFinanceiroAnoMes.doObterFinanceirosMesV(ano);
    }
}
