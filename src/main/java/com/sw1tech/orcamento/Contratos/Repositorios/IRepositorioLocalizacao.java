package com.sw1tech.orcamento.Contratos.Repositorios;

import com.sw1tech.orcamento.Entidades.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositorioLocalizacao  extends JpaRepository<Localizacao, Long> {
}
