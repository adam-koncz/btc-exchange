package hu.konczdam.btcexchange.config.jwt

import hu.konczdam.btcexchange.config.userdetails.UserDetailsServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class AuthTokenFilter: OncePerRequestFilter() {

    @Autowired
    private lateinit var jwtUtils: JwtUtils

    @Autowired
    private lateinit var userDetailsService: UserDetailsServiceImpl

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val jwtToken = request.extractJwtToken()

        if (jwtToken == null) {
            filterChain.doFilter(request, response)
            return
        }

        if (jwtUtils.validateJwtToken(jwtToken)) {
            val username = jwtUtils.getusernameFromJwtToken(jwtToken)
            val userDetails = userDetailsService.loadUserByUsername(username)
            val authentication = UsernamePasswordAuthenticationToken(
                userDetails,
                null,
                userDetails.authorities
            )
            authentication.details = WebAuthenticationDetailsSource().buildDetails(request)
            SecurityContextHolder.getContext().authentication = authentication
        }
    }

    private fun HttpServletRequest.extractJwtToken(): String? {
        val headerAuth = this.getHeader("Authentication")

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7)
        }

        return headerAuth
    }
}
