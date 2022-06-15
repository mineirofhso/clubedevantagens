package com.projetointegrador.clubedevantagens.api.v1.`in`.response

import com.projetointegrador.clubedevantagens.model.CartaoFidelidade

class CartaoFidelidadeResponse(cartaoFidelidade: CartaoFidelidade) {
    var id: String
    var idPromocao: String
    var idUsuario: String
    var espacoTotal: Int
    var espacoCarimbado: Int

    init {
        id = cartaoFidelidade.id.toString()
        idPromocao = cartaoFidelidade.idPromocao.toString()
        idUsuario = cartaoFidelidade.idUsuario.toString()
        espacoCarimbado = cartaoFidelidade.espacoCarimbado!!
        espacoTotal = cartaoFidelidade.espacoTotal!!
    }
}