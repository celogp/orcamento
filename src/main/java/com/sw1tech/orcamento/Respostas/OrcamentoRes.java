package com.sw1tech.orcamento.Respostas;

import java.math.BigDecimal;
import java.util.Date;

import com.sw1tech.orcamento.Entidades.Parceiro;

import lombok.Data;

@Data
public class OrcamentoRes {

    private Long id;
    private Long numero;
    private String descricao;
    private Boolean bloqueado;
    private Date dtMovimento;
    private Date dtEntrega;   
    private BigDecimal vlrTotalItens;
    private BigDecimal vlrDesconto;
    private BigDecimal percDesconto;
    private BigDecimal vlrTotal;
    private Long parceiroId;
    private Parceiro parceiro;
	
}
