package com.projetointegrador.clubedevantagens.api.v1.`in`.response

import com.projetointegrador.clubedevantagens.model.Promocao
import java.time.LocalDate

class PromocaoResponse(promocao: Promocao) {
    var idEmpresa: String
    var idPromocao: String
    var dataValidade: LocalDate
    var quantidadeCarimbo: Int
    var descricao: String

    init {
        idPromocao = promocao.id.toString()
        idEmpresa = promocao.id_empresa.toString()
        dataValidade = promocao.dataValidade!!
        quantidadeCarimbo = promocao.quantidadeCarimbo!!
        descricao = promocao.descricao.toString()
    }
}