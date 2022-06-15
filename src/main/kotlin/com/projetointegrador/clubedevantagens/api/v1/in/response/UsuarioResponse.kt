package com.projetointegrador.clubedevantagens.api.v1.`in`.response

import com.projetointegrador.clubedevantagens.model.Usuario
import java.time.LocalDate
import java.time.LocalDateTime

class UsuarioResponse(usuario: Usuario) {
    var usuarioId: String?
    var nome: String?
    var cpf: String?
    var email: String?
    var telefone: String?
    var dataNascimento: LocalDate?
    var instanteCriacao: LocalDateTime?

    init {
        usuarioId = usuario.usuarioId
        nome = usuario.nome
        cpf = usuario.cpf
        email = usuario.email
        telefone = usuario.telefone
        dataNascimento = usuario.dataNascimento
        instanteCriacao = usuario.instanteCriacao
    }
}