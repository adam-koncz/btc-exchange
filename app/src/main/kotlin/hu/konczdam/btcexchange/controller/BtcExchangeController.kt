package hu.konczdam.btcexchange.controller

import hu.konczdam.btcexchange.config.jwt.JwtUtils
import hu.konczdam.btcexchange.config.userdetails.UserDetailsImpl
import hu.konczdam.btcexchange.dtos.request.BalanceTopUpRequestDTO
import hu.konczdam.btcexchange.dtos.request.RegistrationRequestDTO
import hu.konczdam.btcexchange.dtos.response.SuccesDTO
import hu.konczdam.btcexchange.dtos.response.TokenDTO
import hu.konczdam.btcexchange.service.IUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BtcExchangeController {

    @Autowired
    private lateinit var userService: IUserService

    @Autowired
    private lateinit var jwtUtils: JwtUtils

    @PostMapping("/register")
    fun register(
        @RequestBody registrationRequestDTO: RegistrationRequestDTO,
    ): ResponseEntity<TokenDTO> {
        val newUser = userService.registerNewUser(registrationRequestDTO)
        val token = jwtUtils.generateJwtToken(newUser)
        return ResponseEntity.ok(TokenDTO(token = token))
    }

    @PostMapping("/balance")
    @PreAuthorize("hasRole('USER')")
    fun topUp(
        principal: UsernamePasswordAuthenticationToken,
        @RequestBody balanceTopUpRequestDTO: BalanceTopUpRequestDTO,
    ): ResponseEntity<SuccesDTO> {
        val userId = getUserIdFromPrincipal(principal)
        userService.topUpUserBalance(
            userId = userId,
            currency = balanceTopUpRequestDTO.currency,
            amount = balanceTopUpRequestDTO.amount
        )
        return ResponseEntity.ok(SuccesDTO(true))
    }

    private fun getUserIdFromPrincipal(principal: UsernamePasswordAuthenticationToken): Long {
        return (principal.principal as UserDetailsImpl).id
    }
}
