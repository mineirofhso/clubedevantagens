package com.projetointegrador.clubedevantagens.api.v1.`in`.request

import com.fasterxml.jackson.annotation.JsonProperty
import com.projetointegrador.clubedevantagens.model.CartaoFidelidade
import org.apache.logging.log4j.util.Strings
import java.time.LocalDate
import javax.validation.constraints.NotNull

class CartaoFidelidadeRequest {
    @JsonProperty("idPromocao")
    private val idPromocao: @NotNull String? = null

    @JsonProperty("idUsuario")
    private val idUsuario: @NotNull String? = null

    @JsonProperty("espacoTotal")
    private val espacoTotal: @NotNull Int = 0
    fun toModel(): CartaoFidelidade {
        return CartaoFidelidade(idPromocao, idUsuario, espacoTotal, 0, Strings.EMPTY, LocalDate.now(), Strings.EMPTY)
    }
}