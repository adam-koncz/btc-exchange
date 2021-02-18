package hu.konczdam.btcexchange.config.userdetails

import hu.konczdam.btcexchange.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl: UserDetailsService {

    @Autowired
    private lateinit var userRepo: UserRepository

    companion object {
        private val logger = LoggerFactory.getLogger(UserDetailsServiceImpl::class.java)
    }

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepo.findUserByUsername(username)

        if (user == null) {
            val message = "User not found with username: $username"
            logger.warn(message)
            throw UsernameNotFoundException(message)
        }

        return UserDetailsImpl.build(user)
    }
}