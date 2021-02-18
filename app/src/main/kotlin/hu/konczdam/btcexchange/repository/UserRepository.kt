package hu.konczdam.btcexchange.repository

import hu.konczdam.btcexchange.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Long> {
    fun findUserByUsername(username: String): User?
}
