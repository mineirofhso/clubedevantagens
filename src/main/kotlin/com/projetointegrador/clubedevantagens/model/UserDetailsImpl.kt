package com.projetointegrador.clubedevantagens.model


import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetailsImpl(
    private val usuario: Usuario,
    private val empresa: Empresa
) : UserDetails {
    override fun getAuthorities() = mutableListOf<GrantedAuthority>()

    override fun isEnabled() = true

    override fun getUsername(): String {
        return usuario.cpf ?: empresa.cnpj as String
    }

    override fun isCredentialsNonExpired() = true

    override fun getPassword(): String {
        return usuario.senha!!.ifEmpty {
            empresa.senha!!
        }
    }


    override fun isAccountNonExpired() = true
    override fun isAccountNonLocked() = true
}
