package com.projetointegrador.clubedevantagens.api.v1.`in`.request

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import com.projetointegrador.clubedevantagens.model.Promocao
import java.time.LocalDate
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class PromocaoRequest {
    @JsonProperty("idEmpresa")
    private val idEmpresa: String? = null

    @JsonDeserialize(using = LocalDateDeserializer::class)
    @JsonProperty("dataValidade")
    private val dataValidade: @NotNull LocalDate? = null

    @JsonProperty("quantidadeCarimbo")
    private val quantidadeCarimbo: @NotNull Int? = null

    @JsonProperty("descricao")
    private val descricao: @NotBlank String? = null
    fun toModel(): Promocao {
        return Promocao(
            idEmpresa,
            dataValidade,
            quantidadeCarimbo,
            descricao
        )
    }
}