package com.sw1tech.orcamento.Entidades;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "TUFS")
public class Uf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome")
    private String nome; //maximo de 60

    @Column(name="sigla")
    private String sigla; //maximo de 2
}
