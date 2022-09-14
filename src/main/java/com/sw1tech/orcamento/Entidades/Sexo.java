package com.sw1tech.orcamento.Entidades;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "TSEXO")
public class Sexo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome")
    private String nome;

    @Column(name="sigla")
    private String sigla;
}
