package com.projetointegrador.clubedevantagens.model

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

//@Entity
//@Table(name = "usuario")
//class Usuario {
//    @Id
//    var usuarioId: String? = null
//
//    var nome: String? = null
//
//
//    @Column(unique = true)
//    var cpf: String? = null
//
//    var email: String? = null
//
//    var telefone: String? = null
//
//    var senha: String? = null
//    var dataNascimento: LocalDate? = null
//
//    var instanteCriacao: LocalDateTime? = null
//
//
//    constructor(
//        nome: String?,
//        cpf: String?,
//        email: String?,
//        telefone: String?,
//        senha: String?,
//        dataNascimento: LocalDate?
//    ) : super() {
//        usuarioId = UUID.randomUUID().toString()
//        this.nome = nome
//        this.cpf = cpf
//        this.email = email
//        this.telefone = telefone
//        this.senha = senha
//        this.dataNascimento = dataNascimento
//        instanteCriacao = LocalDateTime.now()
//    }
//
//    @Deprecated("")
//    constructor() {
//    }
//
//    override fun toString(): String {
//        return "Usuario{" +
//                "usuarioId=" + usuarioId +
//                ", nome='" + nome + '\'' +
//                ", cpf='" + cpf + '\'' +
//                ", dataNascimento=" + dataNascimento +
//                ", instanteCriacao=" + instanteCriacao +
//                '}'
//    }
//}
@Entity
@Table(name = "usuario")
class Usuario {
    @Id
     var usuarioId: String? = null
     var nome: String? = null

    @Column(unique = true)
     var cpf: String? = null
     var email: String? = null
     var telefone: String? = null
     var senha: String? = null
     var dataNascimento: LocalDate? = null
     var instanteCriacao: LocalDateTime? = null

    constructor(
        nome: String?,
        cpf: String?,
        email: String?,
        telefone: String?,
        senha: String?,
        dataNascimento: LocalDate?
    ) : super() {
        usuarioId = UUID.randomUUID().toString()
        this.nome = nome
        this.cpf = cpf
        this.email = email
        this.telefone = telefone
        this.senha = senha
        this.dataNascimento = dataNascimento
        instanteCriacao = LocalDateTime.now()
    }

    @Deprecated("")
    constructor() {
    }

    override fun toString(): String {
        return "Usuario{" +
                "usuarioId=" + usuarioId +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", instanteCriacao=" + instanteCriacao +
                '}'
    }

//    fun getUsuarioId(): String? {
//        return usuarioId
//    }
//
//    fun getNome(): String? {
//        return nome
//    }
//
//    fun getCpf(): String? {
//        return cpf
//    }
//
//    fun getEmail(): String? {
//        return email
//    }
//
//    fun getTelefone(): String? {
//        return telefone
//    }
//
//    fun getDataNascimento(): LocalDate? {
//        return dataNascimento
//    }
//
//    fun getInstanteCriacao(): LocalDateTime? {
//        return instanteCriacao
//    }
}