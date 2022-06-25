package com.projetointegrador.clubedevantagens.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.projetointegrador.clubedevantagens.model.Credentials
import com.projetointegrador.clubedevantagens.model.UserDetailsImpl


import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class JWTAuthenticationFilter : UsernamePasswordAuthenticationFilter {

    data class TokenResponse(var token: String)


    private var jwtUtil: JWTUtil

    constructor(authenticationManager: AuthenticationManager, jwtUtil: JWTUtil) : super() {
        this.authenticationManager = authenticationManager
        this.jwtUtil = jwtUtil
    }

    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse?): Authentication? {
        try {
            val (usuario, senha) = ObjectMapper().readValue(request.inputStream, Credentials::class.java)

            val token = UsernamePasswordAuthenticationToken(usuario, senha)

            return authenticationManager.authenticate(token)
        } catch (e: Exception) {
            throw UsernameNotFoundException("User not found!")
        }
    }

    override fun successfulAuthentication(
        request: HttpServletRequest?,
        response: HttpServletResponse,
        chain: FilterChain?,
        authResult: Authentication
    ) {
        val user = (authResult.principal as UserDetailsImpl)
        val token = jwtUtil.generateToken(user.username)
//        response.addHeader(authorization, "$bearer $token")

        val mapper = jacksonObjectMapper()

        val tokenResponse = TokenResponse(token)

        val tokenJson = mapper.writeValueAsString(tokenResponse)


        response.writer.write(tokenJson);
        response.writer.flush();
    }

}