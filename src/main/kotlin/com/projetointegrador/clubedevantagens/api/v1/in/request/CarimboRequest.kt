package com.projetointegrador.clubedevantagens.api.v1.`in`.request

import com.projetointegrador.clubedevantagens.model.Carimbo

class CarimboRequest {
    @Deprecated("")
    fun CarimboRequest() {
    }

    private var idPromocao: String? = null

    private var cpf: String? = null

    private var idUsuario: String? = null

    private var qtdCarimbos: Int = 0

    fun getIdUsuario(): String? {
        return idUsuario
    }


    fun getIdPromocao(): String? {
        return idPromocao
    }

    fun setIdPromocao(idPromocao: String?) {
        this.idPromocao = idPromocao
    }

    fun getCpf(): String? {
        return cpf
    }

    fun setIdUsuario(idUsuario: String?) {
        this.idUsuario = idUsuario
    }

    fun setQtdCarimbos(qtdCarimbos: Int) {
        this.qtdCarimbos = qtdCarimbos
    }

    fun CarimboRequest(idPromocao: String?, cpf: String?, qtdCarimbos: Int, idUsuario: String?) {
        this.idPromocao = idPromocao
        this.cpf = cpf
        this.qtdCarimbos = qtdCarimbos
        this.idUsuario = idUsuario
    }

    fun toModel(): Carimbo? {
        return Carimbo(idPromocao, idUsuario, qtdCarimbos!!, false)
    }
}