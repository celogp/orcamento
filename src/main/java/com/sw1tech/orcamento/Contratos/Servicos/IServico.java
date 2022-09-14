package com.sw1tech.orcamento.Contratos.Servicos;

import java.util.List;
import java.util.Optional;

public interface IServico<ObjEntidade> {
    ObjEntidade doAdicionar(ObjEntidade objEntidade);
    Long doApagar(Long id);
    ObjEntidade doAtualizar(ObjEntidade objEntidade);
    Optional<ObjEntidade> doObterPorId(Long id);
    List<ObjEntidade> doObterTodos();
}
