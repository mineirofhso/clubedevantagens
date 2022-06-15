package com.projetointegrador.clubedevantagens.repository

import com.projetointegrador.clubedevantagens.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario?, String?> {
    fun findBycpf(cpf: String?): Usuario?
}
