package com.projetointegrador.clubedevantagens.api.v1.`in`.response

import com.projetointegrador.clubedevantagens.model.CartaoFidelidade

class CartaoFidelidadeResponse(cartaoFidelidade: CartaoFidelidade) {
    var id: String
    var idPromocao: String
    var idUsuario: String
    var espacoTotal: Int
    var espacoCarimbado: Int

    init {
        id = cartaoFidelidade.getId().toString()
        idPromocao = cartaoFidelidade.getIdPromocao().toString()
        idUsuario = cartaoFidelidade.getIdUsuario().toString()
        espacoCarimbado = cartaoFidelidade.getEspacoCarimbado()
        espacoTotal = cartaoFidelidade.getEspacoTotal()
    }
}