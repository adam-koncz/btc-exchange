package hu.konczdam.btcexchange.service

import hu.konczdam.btcexchange.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService: IUserService {

    @Autowired
    private lateinit var userRepository : UserRepository
}
