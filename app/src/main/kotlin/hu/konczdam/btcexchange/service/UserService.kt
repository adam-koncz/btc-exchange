package hu.konczdam.btcexchange.service

import hu.konczdam.btcexchange.dtos.request.RegistrationRequestDTO
import hu.konczdam.btcexchange.model.Currency
import hu.konczdam.btcexchange.model.User
import hu.konczdam.btcexchange.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService : IUserService {

    @Autowired
    private lateinit var userRepository: UserRepository

    companion object {
        private val logger = LoggerFactory.getLogger(UserService::class.java)
    }

    @Transactional
    override fun registerNewUser(registrationRequestDTO: RegistrationRequestDTO): User {
        val username = registrationRequestDTO.username
        if (userRepository.existsByUsername(username)) {
            val message = "A user with the username '$username' already exists!"
            logger.error(message)
            throw Exception(message)
        }

        return userRepository.save(User(username = username))
    }

    @Transactional
    override fun topUpUserBalance(userId: Long, currency: Currency, amount: Long) {
        val userOpt = userRepository.findById(userId)
        if (!userOpt.isPresent) {
            throw Exception("User not found in database!")
        }

        val user = userOpt.get()

        when (currency) {
            Currency.BTC -> user.btcBalance += amount
            Currency.USD -> user.usdBalance += amount
        }
    }
}
