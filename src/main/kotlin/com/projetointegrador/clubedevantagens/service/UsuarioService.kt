package com.projetointegrador.clubedevantagens.service

import com.projetointegrador.clubedevantagens.api.v1.`in`.request.UsuarioRequest
import com.projetointegrador.clubedevantagens.model.Empresa
import com.projetointegrador.clubedevantagens.model.Usuario
import com.projetointegrador.clubedevantagens.repository.EmpresaRepository
import com.projetointegrador.clubedevantagens.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UsuarioService {

    @Autowired
    private lateinit var userRepository: UsuarioRepository

    @Autowired
    private lateinit var empresaRepository: EmpresaRepository

    @Autowired
    @org.springframework.context.annotation.Lazy
    private lateinit var bCryptPasswordEncoder: BCryptPasswordEncoder



    fun criaUsuario(usuarioRequest: UsuarioRequest): Any {

        return if (usuarioRequest.cpfcnpj?.length?.equals(11) == true) {
            val usuario = usuarioRequest.toUsuario()
            usuario.senha = encriptaSenha(usuario.senha!!)
            createUsuario(usuario)
        } else {
            val empresa = usuarioRequest.toEmpresa()
            empresa.senha = encriptaSenha(empresa.senha!!)
            createEmpresa(empresa)
        }
    }


    private fun createEmpresa(empresa: Empresa): Empresa {
        return empresaRepository.save(empresa)
    }

    private fun createUsuario(usuario: Usuario): Usuario {
        return userRepository.save(usuario)
    }

    private fun encriptaSenha(senha: String) :String {
       return bCryptPasswordEncoder.encode(senha)
    }
}