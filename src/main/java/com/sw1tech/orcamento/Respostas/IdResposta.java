package com.sw1tech.orcamento.Respostas;

import lombok.Data;

@Data
public class IdResposta {
    private int id;

    public IdResposta(int _id){
        this.id = _id;
    }
}
