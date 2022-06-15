package com.projetointegrador.clubedevantagens.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class CartaoFidelidade {
    @Id
    var id: String? = null
        private set
    var idPromocao: String? = null
    var idUsuario: String? = null
    var espacoTotal: Int? = null
    var espacoCarimbado: Int? = null

    @Deprecated("")
    constructor() {
    }

    constructor(idPromocao: String?, idUsuario: String?, espacoTotal: Int?, espacoCarimbado: Int?) {
        id = UUID.randomUUID().toString()
        this.idPromocao = idPromocao
        this.idUsuario = idUsuario
        this.espacoTotal = espacoTotal
        this.espacoCarimbado = espacoCarimbado
    }
}