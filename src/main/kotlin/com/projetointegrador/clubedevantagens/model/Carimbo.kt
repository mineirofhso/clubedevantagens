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
    private var id: String? = null

    private var idPromocao: String? = null
    private var idUsuario: String? = null
    private var quantidadeCarimbos: Int = 0
    private var utilizado: Boolean? = null

    @Deprecated("")
    constructor() {
    }

    constructor(idPromocao: String?, idUsuario: String?, quantidadeCarimbos: Int, utilizado: Boolean?) {
        id = UUID.randomUUID().toString()
        this.idPromocao = idPromocao
        this.idUsuario = idUsuario
        this.quantidadeCarimbos = quantidadeCarimbos
        this.utilizado = utilizado
    }

    fun setQuantidadeCarimbos(quantidadeCarimbos: Int) {
        this.quantidadeCarimbos = quantidadeCarimbos
    }

    fun setUtilizado(utilizado: Boolean?) {
        this.utilizado = utilizado
    }

    fun getQuantidadeCarimbos(): Int {
        return quantidadeCarimbos
    }

    fun getId(): String? {
        return id
    }

    fun getUtilizado(): Boolean? {
        return utilizado
    }

    fun getIdUsuario(): String? {
        return idUsuario
    }

    fun getIdPromocao(): String? {
        return idPromocao
    }
}