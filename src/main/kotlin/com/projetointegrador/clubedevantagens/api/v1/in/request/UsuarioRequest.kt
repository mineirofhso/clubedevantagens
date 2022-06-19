package com.projetointegrador.clubedevantagens.api.v1.`in`.request

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import com.projetointegrador.clubedevantagens.model.Empresa
import com.projetointegrador.clubedevantagens.model.Usuario
import org.apache.logging.log4j.util.Strings

import org.hibernate.validator.constraints.br.CPF
import java.time.LocalDate
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class UsuarioRequest {
    @NotBlank
    @JsonProperty("nome")
    val nome: String? = null

    @NotBlank
    @JsonProperty("cpfcnpj")
    val cpfcnpj: String? = null

    @Email
    @JsonProperty("email")
    val email: String? = null

    @NotBlank
    @JsonProperty("telefone")
    val telefone: String? = null

    @JsonProperty("contatoNome")
    val contatoNome: @NotBlank String? = null

    @NotBlank
    @JsonProperty("senha")
    val senha: String = Strings.EMPTY


    @JsonProperty("data_nascimento")
    @JsonDeserialize(using = LocalDateDeserializer::class)
    val dataNascimento: LocalDate? = null


    fun toUsuario(): Usuario {
        return Usuario(nome, cpfcnpj, email, telefone, senha, dataNascimento)
    }

    fun toEmpresa(): Empresa {
        return Empresa(nome, cpfcnpj, senha, contatoNome, telefone, email)
    }
}