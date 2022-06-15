package com.projetointegrador.clubedevantagens.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Empresa {
    @Id
    var empresaId: String? = null

    var razaoSocial: String? = null


    @Column(unique = true)
    var cnpj: String? = null
    var senha: String? = null
    var contatoNome: String? = null
    var contatoTelefone: String? = null
    var contatoEmail: String? = null

    @Deprecated("")
    constructor() {
    }

    constructor(
        razaoSocial: String?,
        cnpj: String?,
        senha: String?,
        contatoNome: String?,
        contatoTelefone: String?,
        contatoEmail: String?
    ) : super() {
        empresaId = UUID.randomUUID().toString()
        this.razaoSocial = razaoSocial
        this.cnpj = cnpj
        this.senha = senha
        this.contatoNome = contatoNome
        this.contatoTelefone = contatoTelefone
        this.contatoEmail = contatoEmail
    }


}