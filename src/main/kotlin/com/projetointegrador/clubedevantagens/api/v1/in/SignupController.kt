package com.projetointegrador.clubedevantagens.api.v1.`in`

import com.projetointegrador.clubedevantagens.api.v1.`in`.request.UsuarioRequest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RequestMapping(value = ["/v1"], produces = [MediaType.APPLICATION_JSON_VALUE])
interface SignupController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = ["/signup"])
    fun salvar(@Valid @RequestBody usuarioRequest: UsuarioRequest): ResponseEntity<*>?
}