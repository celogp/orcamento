package com.sw1tech.orcamento.Entidades;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "TUF")
public class Uf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="nome")
    private String nome; //maximo de 60

    @Column(name="sigla")
    private String sigla; //maximo de 2
}
