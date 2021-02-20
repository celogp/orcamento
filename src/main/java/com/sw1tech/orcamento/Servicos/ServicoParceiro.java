package com.sw1tech.orcamento.Servicos;

import com.sw1tech.orcamento.Contratos.Repositorios.IRepositorioParceiro;
import com.sw1tech.orcamento.Contratos.Servicos.IServicoParceiro;
import com.sw1tech.orcamento.Entidades.Parceiro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoParceiro implements IServicoParceiro {

    @Autowired
    IRepositorioParceiro _repositoriosParceiro;

    @Override
    public Parceiro doAdicionar(Parceiro parceiro) {
        return _repositoriosParceiro.save(parceiro);
    }

    @Override
    public Integer doApagar(int id) {
        _repositoriosParceiro.deleteById(id);
        return id;
    }

    @Override
    public Parceiro doAtualizar(Parceiro parceiro) {
        return _repositoriosParceiro.save(parceiro);
    }

    @Override
    public Optional<Parceiro> doObterPorId(int id) {
        return _repositoriosParceiro.findById(id);
    }

    @Override
    public List<Parceiro> doObterTodos() {
        return _repositoriosParceiro.findAll();
    }
}
