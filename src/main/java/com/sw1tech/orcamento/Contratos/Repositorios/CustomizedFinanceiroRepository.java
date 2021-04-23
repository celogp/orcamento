package com.sw1tech.orcamento.Contratos.Repositorios;

import com.sw1tech.orcamento.Respostas.FinanceiroMesRes;

import java.util.List;

public interface CustomizedFinanceiroRepository {
    List<FinanceiroMesRes> customMethod(int ano);
}
