package com.sw1tech.orcamento.Respostas;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Data
@Setter(AccessLevel.PROTECTED)
public class ObjetoResposta {
    Object data;
    List<String> mensagens = new ArrayList<>();

    public ObjetoResposta(int _id){
        data = new IdResposta(_id);
    }

    public ObjetoResposta(Object obj){
        data = obj;
    }

    public ObjetoResposta(Object obj, List<String> lstmensagens){
        data = obj;
        mensagens = lstmensagens;
    }

}
