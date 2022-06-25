package com.projetointegrador.clubedevantagens.security

import com.projetointegrador.clubedevantagens.model.authorization
import com.projetointegrador.clubedevantagens.model.bearer
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

<<<<<<< HEAD

=======
>>>>>>> 645ea7d72096deac3b0d3916349d34272dcc6a5a
class JWTAuthorizationFilter : BasicAuthenticationFilter {

    private var jwtUtil: JWTUtil
    private var userDetailService: UserDetailsService

<<<<<<< HEAD
    constructor(
        authenticationManager: AuthenticationManager,
        jwtUtil: JWTUtil,
        userDetailService: UserDetailsService
    ) : super(authenticationManager) {
=======
    constructor(authenticationManager: AuthenticationManager, jwtUtil: JWTUtil, userDetailService: UserDetailsService) : super(authenticationManager) {
>>>>>>> 645ea7d72096deac3b0d3916349d34272dcc6a5a
        this.jwtUtil = jwtUtil
        this.userDetailService = userDetailService
    }

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        val authorizationHeader = request.getHeader(authorization)
<<<<<<< HEAD
        if (!authorizationHeader.isNullOrEmpty()) {
            if (authorizationHeader.startsWith(bearer)) {
                val auth = getAuthentication(authorizationHeader)
                SecurityContextHolder.getContext().authentication = auth
            }
        }
=======

        if(authorizationHeader.startsWith(bearer)) {
            val auth = getAuthentication(authorizationHeader)
            SecurityContextHolder.getContext().authentication = auth
        }

>>>>>>> 645ea7d72096deac3b0d3916349d34272dcc6a5a
        chain.doFilter(request, response)
    }

    private fun getAuthentication(authorizationHeader: String?): UsernamePasswordAuthenticationToken {
        val token = authorizationHeader?.substring(7) ?: ""
<<<<<<< HEAD
        if (jwtUtil.isTokenValid(token)) {
=======
        if(jwtUtil.isTokenValid(token)) {
>>>>>>> 645ea7d72096deac3b0d3916349d34272dcc6a5a
            val username = jwtUtil.getUserName(token)
            val user = userDetailService.loadUserByUsername(username)
            return UsernamePasswordAuthenticationToken(user, null, user.authorities)
        }
        throw UsernameNotFoundException("Auth invalid!")
    }

<<<<<<< HEAD
}
=======
}
>>>>>>> 645ea7d72096deac3b0d3916349d34272dcc6a5a
