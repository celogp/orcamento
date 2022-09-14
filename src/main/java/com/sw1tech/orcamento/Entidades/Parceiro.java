package com.sw1tech.orcamento.Entidades;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "TPARCEIROS")
public class Parceiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="razao")
    private String razao; //maximo de 100

    @Column(name="nome")
    private String nome; // maximo de 100

    @Column(name="cnpj")
    private String cnpj; // maximo de 14

    @Column(name="inscricao")
    private String inscricao; // maximo de 14

    @Column(name="cpf")
    private String cpf; // maximo de 11

    @Column(name="identidade")
    private String identidade; // maximo de 16

    @Column(name="email")
    private String email; // maximo de 100

    @Column(name="fone")
    private String fone; // maximo de 12

    @Column(name="celular")
    private String celular; // maximo de 12

    @Column(name="celulariswhatsapp")
    private boolean celularIsWhatsApp; // maximo de 1

    @Column(name="contato")
    private String contato; //  VARCHAR(100),

    @Column(name="fonecontato")
    private String foneContato; // maximo de 12

    @Column(name="celularcontato")
    private String celuluarContato; // maximo de 12

    @Column(name="celularcontatoiswhatsapp")
    private boolean celularContatoIsWhatsApp; // maximo de 1

    @ManyToOne()
    @JoinColumn(name = "localizacaoid", referencedColumnName = "id")
    private Localizacao localizacao;

    @ManyToOne()
    @JoinColumn(name = "sexoid", referencedColumnName = "id")
    private Sexo sexo;

}
