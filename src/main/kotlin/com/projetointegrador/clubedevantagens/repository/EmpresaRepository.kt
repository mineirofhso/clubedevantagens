package com.projetointegrador.clubedevantagens.repository

import com.projetointegrador.clubedevantagens.model.Empresa
import org.springframework.data.jpa.repository.JpaRepository

interface EmpresaRepository : JpaRepository<Empresa?, String?> {
    fun findByCnpj(cnpj: String?): Empresa?
}