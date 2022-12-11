package com.sw1tech.orcamento.Entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.Type;

import lombok.Data;

@Data
@Entity(name = "TPRODUTOSMODELOSIMAGEM")
public class ProdutoModeloImagem {
	
	@Id
    private Long id;
    
    @Lob
    @Type(type="org.hibernate.type.BinaryType") 
    @Column(name="conteudo")
    private byte[] conteudo;
    
}
