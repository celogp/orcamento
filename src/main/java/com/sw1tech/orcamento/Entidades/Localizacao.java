package com.sw1tech.orcamento.Entidades;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity(name = "TLOCALIZACOES")
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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
    private BigInteger longitude;

    @Column(name="latitude")
    private BigInteger latitude;

    @ManyToOne()
    @JoinColumn(name = "ufid", referencedColumnName = "id")
    private Uf uf;

}
