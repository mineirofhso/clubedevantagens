package com.projetointegrador.clubedevantagens.model

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Promocao {
    @Id
    var id: String? = null
        private set
    var id_empresa: String? = null
        private set
    var dataCriacao: LocalDateTime? = null
        private set
    var dataValidade: LocalDate? = null
        private set
    var quantidadeCarimbo: Int? = null
        private set
    var descricao: String? = null
        private set

    @Deprecated("")
    constructor() {
    }

    constructor(
        id_empresa: String?,
        dataValidade: LocalDate?,
        quantidadeCarimbo: Int?,
        descricao: String?
    ) : super() {
        id = UUID.randomUUID().toString()
        this.id_empresa = id_empresa
        dataCriacao = LocalDateTime.now()
        this.dataValidade = dataValidade
        this.quantidadeCarimbo = quantidadeCarimbo
        this.descricao = descricao
    }
}