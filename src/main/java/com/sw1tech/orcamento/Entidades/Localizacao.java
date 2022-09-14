package com.sw1tech.orcamento.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name = "TLOCALIZACOES")
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="cep")
    private String cep; //maximo de 8

    @Column(name="logradouro")
    private String logradouro; //maximo de 100

    @Column(name="complemento")
    private String complemento; //maximo de 100

    @Column(name="localidade")
    private String localidade; //maximo de 100

    @Column(name="bairro")
    private String bairro; //maximo de 100

    @Column(name="longitude")
    private Long longitude;

    @Column(name="latitude")
    private Long latitude;

    @ManyToOne()
    @JoinColumn(name = "ufid", referencedColumnName = "id")
    private Uf uf;

}
