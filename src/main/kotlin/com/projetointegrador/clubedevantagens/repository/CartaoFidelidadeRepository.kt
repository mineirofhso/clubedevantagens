package com.projetointegrador.clubedevantagens.repository

import com.projetointegrador.clubedevantagens.model.CartaoFidelidade
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CartaoFidelidadeRepository : JpaRepository<CartaoFidelidade?, String?> {
    @Query(
        value =
        "SELECT cf.id, " +
                " cf.espaco_carimbado, " +
                " cf.espaco_total, " +
                " cf.id_promocao, " +
                " cf.id_usuario, " +
                " cf.contemplado, " +
                " E.RAZAO_SOCIAL AS EMPRESA, " +
                " P.DATA_VALIDADE AS VALIDADE, " +
                " P.DESCRICAO " +
                " FROM public.cartao_fidelidade cf " +
                " INNER JOIN PROMOCAO P " +
                " ON P.ID=CF.ID_PROMOCAO " +
                " INNER JOIN empresa e " +
                " ON E.EMPRESA_ID=P.ID_EMPRESA " +
                " WHERE cf.id_usuario=?1 ;", nativeQuery = true
    )
    fun findByIdUsuario(idUsuario: String?): List<CartaoFidelidade?>?

    //    @Query(value = "SELECT * FROM CARTAO_FIDELIDADE WHERE CONTEMPLADO = NULL " +
//            " AND AND ID_USUARIO = ?1", nativeQuery = true)
    @Query(
        value = "SELECT cf.id, cf.espaco_carimbado, cf.espaco_total, cf.id_promocao, cf.id_usuario, cf.contemplado, cf.descricao, cf.empresa, cf.validade " +
                " FROM public.cartao_fidelidade cf " +
                " inner join public.promocao p" +
                " on p.id=cf.id_promocao " +
                " where cf.id_usuario=?1" +
                " and cf.id_promocao=?2 ;", nativeQuery = true
    )
    fun findByIdUsuarioAndIdPromocao(idUsuario: String?, idPromocao: String?): CartaoFidelidade?
}
