package com.sw1tech.orcamento.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/*
 *  TODOS = 0,
    ACABADO = 1,
    BASE = 2,
    ACABAMENTOS = 3,
    ACESSORIOS = 4,
    SERVICOS = 5
 * */

@Data
@Entity(name = "TPRODUTOSTIPO")
public class ProdutoTipo {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome")
    private String nome;
}
