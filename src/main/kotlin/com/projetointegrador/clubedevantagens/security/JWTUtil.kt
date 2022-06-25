package com.projetointegrador.clubedevantagens.security

<<<<<<< HEAD
import io.jsonwebtoken.Claims
=======
>>>>>>> 645ea7d72096deac3b0d3916349d34272dcc6a5a
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*
<<<<<<< HEAD
=======
import io.jsonwebtoken.Claims


>>>>>>> 645ea7d72096deac3b0d3916349d34272dcc6a5a


@Component
class JWTUtil {

    @Value("\${jwt.secret}")
    private lateinit var secret: String

<<<<<<< HEAD
    private val expiration: Long = 900000
=======
    private val expiration: Long = 60000
>>>>>>> 645ea7d72096deac3b0d3916349d34272dcc6a5a

    fun generateToken(username: String): String {
        return Jwts.builder()
            .setSubject(username)
            .setExpiration(Date(System.currentTimeMillis() + expiration))
<<<<<<< HEAD
            .signWith(SignatureAlgorithm.HS512, secret.toByteArray())
=======
            .signWith(SignatureAlgorithm.HS256, secret.toByteArray())
>>>>>>> 645ea7d72096deac3b0d3916349d34272dcc6a5a
            .compact()
    }

    fun isTokenValid(token: String): Boolean {
        val claims = getClaimsToken(token)
        if (claims != null) {
            val username = claims.subject
            val expirationDate = claims.expiration
            val now = Date(System.currentTimeMillis())
            if (username != null && expirationDate != null && now.before(expirationDate)) {
                return true
            }
        }
        return false
    }


    private fun getClaimsToken(token: String): Claims? {
        return try {
            Jwts.parser().setSigningKey(secret.toByteArray()).parseClaimsJws(token).body
        } catch (e: Exception) {
            null
        }
    }

    fun getUserName(token: String): String? {
        val claims = getClaimsToken(token)
        return claims?.subject
    }
<<<<<<< HEAD
=======

>>>>>>> 645ea7d72096deac3b0d3916349d34272dcc6a5a
}