package hu.konczdam.btcexchange.dtos.request

import hu.konczdam.btcexchange.model.Currency

data class BalanceTopUpRequestDTO(
    val currency: Currency,
    val amount: Long,
)
