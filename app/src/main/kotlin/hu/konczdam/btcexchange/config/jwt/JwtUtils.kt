package hu.konczdam.btcexchange.config.jwt

import hu.konczdam.btcexchange.model.User
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.MalformedJwtException
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.SignatureException
import io.jsonwebtoken.UnsupportedJwtException
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils
import java.util.Date

@Component
class JwtUtils {

    @Value("\${jwtSecret}")
    private lateinit var jwtSecret: String

    companion object {
        private val logger = LoggerFactory.getLogger(JwtUtils::class.java)
    }

    fun generateJwtToken(user: User): String {
        val now = Date()
        return Jwts.builder()
            .setId(user.id.toString())
            .setIssuedAt(now)
            .setSubject(user.username)
            .setExpiration(Date(Long.MAX_VALUE))
            .signWith(SignatureAlgorithm.HS512, jwtSecret)
            .compact()
    }

    fun validateJwtToken(authToken: String): Boolean {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken)
            return true
        } catch (e: SignatureException) {
            logger.error("Invalid JWT signature: {}", e.message)
        } catch (e: MalformedJwtException) {
            logger.error("Invalid JWT token: {}", e.message)
        } catch (e: ExpiredJwtException) {
            logger.error("JWT token is expired: {}", e.message)
        } catch (e: UnsupportedJwtException) {
            logger.error("JWT token is unsupported: {}", e.message)
        } catch (e: IllegalArgumentException) {
            logger.error("JWT claims string is empty: {}", e.message)
        }
        return false
    }

    fun getusernameFromJwtToken(header: String): String {
        val token = if (StringUtils.hasText(header) && header.startsWith("Bearer ")) header.substring(7) else header
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).body.subject
    }
}
