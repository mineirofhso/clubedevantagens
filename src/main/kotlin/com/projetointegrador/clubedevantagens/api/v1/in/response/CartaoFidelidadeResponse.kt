package com.projetointegrador.clubedevantagens.api.v1.`in`.response

import com.projetointegrador.clubedevantagens.model.CartaoFidelidade
import java.time.LocalDate

class CartaoFidelidadeResponse(cartaoFidelidade: CartaoFidelidade) {
    var id: String
    var idPromocao: String
    var idUsuario: String
    var espacoTotal: Int
    var espacoCarimbado: Int
    var empresa: String
    var validade: LocalDate
    var descricao: String


    init {
        id = cartaoFidelidade.getId().toString()
        idPromocao = cartaoFidelidade.getIdPromocao().toString()
        idUsuario = cartaoFidelidade.getIdUsuario().toString()
        espacoCarimbado = cartaoFidelidade.getEspacoCarimbado()
        espacoTotal = cartaoFidelidade.getEspacoTotal()
        empresa = cartaoFidelidade.empresa
        validade = cartaoFidelidade.validade
        descricao = cartaoFidelidade.descricao
    }
}