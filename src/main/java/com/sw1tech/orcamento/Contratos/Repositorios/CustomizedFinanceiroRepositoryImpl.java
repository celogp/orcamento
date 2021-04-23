package com.sw1tech.orcamento.Contratos.Repositorios;

import com.sw1tech.orcamento.Respostas.FinanceiroMesRes;
import com.sw1tech.orcamento.Views.VFinanceiroMes;
import org.hibernate.transform.Transformers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CustomizedFinanceiroRepositoryImpl implements CustomizedFinanceiroRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<FinanceiroMesRes> customMethod(int ano) {

        List<FinanceiroMesRes> items = em.createNativeQuery("SELECT \n" +
                "f.anoref, f.mesref, f.RECEITA, f.valor \n" +
                "FROM VFINANCEIROMES f \n" +
                "WHERE f.anoref = :p_ano \n", VFinanceiroMes.class )
                .setParameter("p_ano", ano)
                .getResultList();

/*
dando problema no mapping
        List<FinanceiroMesRes> items = (List<FinanceiroMesRes>)  em.createNativeQuery("SELECT \n" +
                "YEAR(f.DTMOVIMENTO) as anoref, MONTH(f.DTMOVIMENTO) as mesref, f.RECEITA as receita, SUM(f.VLRFINANCEIRO) as valor \n" +
                "FROM TFINANCEIROS f \n" +
                "WHERE YEAR(f.DTMOVIMENTO) = :p_ano \n" +
                "GROUP BY YEAR(f.DTMOVIMENTO), MONTH(f.DTMOVIMENTO), f.RECEITA")
                .setParameter("p_ano", ano)
                .getResultList();
*/

/*
deu ruim
        List<FinanceiroMesRes> items = em.createNativeQuery("SELECT \n" +
                "YEAR(f.DTMOVIMENTO) as anoref, MONTH(f.DTMOVIMENTO) as mesref, f.RECEITA as receita, SUM(f.VLRFINANCEIRO) as valor \n" +
                "FROM TFINANCEIROS f \n" +
                "WHERE YEAR(f.DTMOVIMENTO) = :p_ano \n" +
                "GROUP BY YEAR(f.DTMOVIMENTO), MONTH(f.DTMOVIMENTO), f.RECEITA")
                .setParameter("p_ano", ano)
                .unwrap(org.hibernate.query.NativeQuery.class)
                .setResultTransformer(Transformers.aliasToBean(FinanceiroMesRes.class))
                .getResultList();

        */

/*
deu ruim
        var q = em.createNativeQuery("SELECT \n" +
                "YEAR(f.DTMOVIMENTO) as anoref, MONTH(f.DTMOVIMENTO) as mesref, f.RECEITA as receita, SUM(f.VLRFINANCEIRO) as valor \n" +
                "FROM TFINANCEIROS f \n" +
                "WHERE YEAR(f.DTMOVIMENTO) = :p_ano \n" +
                "GROUP BY YEAR(f.DTMOVIMENTO), MONTH(f.DTMOVIMENTO), f.RECEITA")
                .setParameter("p_ano", ano)
                .getResultList();
*/

/*
deu pior
        q.setResultTransformer(Transformers.aliasToBean(FinanceiroMesRes.class));

        List<FinanceiroMesRes> relatorioCNMP = q.list();
*/
        //return relatorioCNMP;
/*
        List<FinanceiroMesRes> lstFinanceiroMesRes = q.;
        for (FinanceiroMesRes a : lstFinanceiroMesRes) {
            System.out.println("financeiro "
                    + a.getMesref()
                    + " - "
                    + a.getValor());
        }
*/

        return items;
    }
}