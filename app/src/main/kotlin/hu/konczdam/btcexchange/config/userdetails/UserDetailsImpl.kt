package hu.konczdam.btcexchange.config.userdetails

import hu.konczdam.btcexchange.model.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetailsImpl(

    val id: Long,

    private val username: String,

) : UserDetails {

    companion object {
        fun build(user: User): UserDetailsImpl {
            return UserDetailsImpl(
                id = user.id!!,
                username = user.username,
            )
        }
    }

    override fun getUsername() = username

    override fun getAuthorities() = listOf(SimpleGrantedAuthority("ROLE_USER"))

    override fun getPassword() = ""

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}
