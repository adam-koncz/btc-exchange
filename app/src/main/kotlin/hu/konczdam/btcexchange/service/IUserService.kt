package hu.konczdam.btcexchange.service

import hu.konczdam.btcexchange.dtos.request.RegistrationRequestDTO
import hu.konczdam.btcexchange.model.Currency
import hu.konczdam.btcexchange.model.User

interface IUserService {
    fun registerNewUser(registrationRequestDTO: RegistrationRequestDTO): User

    fun topUpUserBalance(userId: Long, currency: Currency, amount: Long)
}
