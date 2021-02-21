package com.sw1tech.orcamento.Servicos;

import com.sw1tech.orcamento.Contratos.Repositorios.IRepositorioFinanceiro;
import com.sw1tech.orcamento.Contratos.Servicos.IServicoFinanceiro;
import com.sw1tech.orcamento.Entidades.Financeiro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServicoFinanceiro implements IServicoFinanceiro {

    @Autowired
    IRepositorioFinanceiro _repositoriosFinanceiro;

    @Override
    public Financeiro doAdicionar(Financeiro financeiro) {
        return _repositoriosFinanceiro.save(financeiro);
    }

    @Override
    public Integer doApagar(int id) {
        _repositoriosFinanceiro.deleteById(id);
        return id;
    }

    @Override
    public Financeiro doAtualizar(Financeiro financeiro) {
        return _repositoriosFinanceiro.save(financeiro);
    }

    @Override
    public Optional<Financeiro> doObterPorId(int id) {
        return _repositoriosFinanceiro.findById(id);
    }

    @Override
    public List<Financeiro> doObterTodos() {
        return _repositoriosFinanceiro.findAll();
    }

    @Override
    public Integer doBaixar(int id, Date dtBaixa, BigDecimal vlrBaixa) {
        return _repositoriosFinanceiro.doBaixar(id, dtBaixa, vlrBaixa);
    }

    @Override
    public Integer doEstornarBaixa(int id) {
        return _repositoriosFinanceiro.doEstornarBaixa(id);
    }
}
