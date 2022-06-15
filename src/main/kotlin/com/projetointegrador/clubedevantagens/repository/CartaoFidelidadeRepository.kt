package com.projetointegrador.clubedevantagens.repository

import com.projetointegrador.clubedevantagens.model.CartaoFidelidade
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CartaoFidelidadeRepository : JpaRepository<CartaoFidelidade?, String?> {
    @Query(value = "SELECT * FROM CARTAO_FIDELIDADE WHERE ID_USUARIO = ?1", nativeQuery = true)
    fun findByIdUsuario(idUsuario: String?): List<CartaoFidelidade?>?
}
