package com.sw1tech.orcamento.Servicos;

import com.sw1tech.orcamento.Contratos.Repositorios.IRepositorioLocalizacao;
import com.sw1tech.orcamento.Contratos.Servicos.IServicoLocalizacao;
import com.sw1tech.orcamento.Entidades.Localizacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoLocalizacao  implements IServicoLocalizacao {

    @Autowired
    IRepositorioLocalizacao _reopositorioLocalizacao;

    @Override
    public Localizacao doAdicionar(Localizacao localizacao) {
        return _reopositorioLocalizacao.save(localizacao);
    }

    @Override
    public Integer doApagar(int id) {
        _reopositorioLocalizacao.deleteById(id);
        return id;
    }

    @Override
    public Localizacao doAtualizar(Localizacao localizacao) {
        return _reopositorioLocalizacao.save(localizacao);
    }

    @Override
    public Optional<Localizacao> doObterPorId(int id) {
        return _reopositorioLocalizacao.findById(id);
    }

    @Override
    public List<Localizacao> doObterTodos() {
        return _reopositorioLocalizacao.findAll();
    }

}
