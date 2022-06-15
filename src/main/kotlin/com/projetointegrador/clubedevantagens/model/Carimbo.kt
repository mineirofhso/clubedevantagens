package com.projetointegrador.clubedevantagens.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

//@Entity
//class Carimbo {
//    @Id
//    var id: String? = null
//        private set
//    var idPromocao: String? = null
//    var idUsuario: String? = null
//    var quantidadeCarimbos: Int? = null
//    var utilizado: Boolean? = null
//
//    @Deprecated("")
//    constructor() {
//    }
//
//    constructor(idPromocao: String?, idUsuario: String?, quantidadeCarimbos: Int?, utilizado: Boolean?) {
//        id = UUID.randomUUID().toString()
//        this.idPromocao = idPromocao
//        this.idUsuario = idUsuario
//        this.quantidadeCarimbos = quantidadeCarimbos
//        this.utilizado = utilizado
//    }
//}

@Entity
class Carimbo {


    @Id
    var id: String? = null

    var idPromocao: String? = null
    var idUsuario: String? = null
    var quantidadeCarimbos: Int? = null
    var utilizado: Boolean? = null

    @Deprecated("")
    constructor() {
    }

    constructor(idPromocao: String?, idUsuario: String?, quantidadeCarimbos: Int?, utilizado: Boolean?) {
        id = UUID.randomUUID().toString()
        this.idPromocao = idPromocao
        this.idUsuario = idUsuario
        this.quantidadeCarimbos = quantidadeCarimbos
        this.utilizado = utilizado
    }
}