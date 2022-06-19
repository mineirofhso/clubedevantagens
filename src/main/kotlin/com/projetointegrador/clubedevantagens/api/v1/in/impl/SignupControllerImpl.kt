package com.projetointegrador.clubedevantagens.api.v1.`in`.impl

import com.projetointegrador.clubedevantagens.api.v1.`in`.request.UsuarioRequest
import com.projetointegrador.clubedevantagens.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
class SignupControllerImpl : com.projetointegrador.clubedevantagens.api.v1.`in`.SignupController {

    @Autowired
    private lateinit var usuarioService: UsuarioService


    override fun salvar(usuarioRequest: UsuarioRequest): ResponseEntity<*>? {
        val usuarioCriado = usuarioService.criaUsuario(usuarioRequest)
        return ResponseEntity.created(URI("")).body(usuarioCriado)
    }
}