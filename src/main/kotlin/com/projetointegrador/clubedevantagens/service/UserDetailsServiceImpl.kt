package com.projetointegrador.clubedevantagens.service

import com.projetointegrador.clubedevantagens.model.Empresa
import com.projetointegrador.clubedevantagens.model.UserDetailsImpl
import com.projetointegrador.clubedevantagens.model.Usuario
import com.projetointegrador.clubedevantagens.repository.EmpresaRepository
import com.projetointegrador.clubedevantagens.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl : UserDetailsService {

    @Autowired
    private lateinit var usuarioRepository: UsuarioRepository

    @Autowired
    private lateinit var empresaRepository: EmpresaRepository

    override fun loadUserByUsername(login: String): UserDetails {
        var usuario = Usuario()
        var empresa = Empresa()
        if (login.length == 11) {
            usuario = usuarioRepository.findBycpf(login) ?: throw RuntimeException()
        } else {
            empresa = empresaRepository.findByCnpj(login) ?: throw RuntimeException()
        }
        return UserDetailsImpl(usuario, empresa)
    }
}
