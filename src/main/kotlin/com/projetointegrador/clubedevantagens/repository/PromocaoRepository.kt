package com.projetointegrador.clubedevantagens.repository

import com.projetointegrador.clubedevantagens.model.Promocao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface PromocaoRepository : JpaRepository<Promocao?, String?> {
    @Query(value = "SELECT * FROM PROMOCAO WHERE ID_EMPRESA = ?1", nativeQuery = true)
    fun findByIdEmpresa(idEmpresa: String?): List<Promocao?>?
}