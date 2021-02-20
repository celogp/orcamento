package com.sw1tech.orcamento.Contratos.Servicos;

import java.util.List;
import java.util.Optional;

public interface IServico<ObjEntidade> {
    ObjEntidade doAdicionar(ObjEntidade ObjEntidade);
    Integer doApagar(int id);
    ObjEntidade doAtualizar(ObjEntidade ObjEntidade);
    Optional<ObjEntidade> doObterPorId(int id);
    List<ObjEntidade> doObterTodos();
}
