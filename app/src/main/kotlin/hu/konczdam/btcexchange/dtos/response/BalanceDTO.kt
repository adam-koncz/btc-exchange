package hu.konczdam.btcexchange.dtos.response

data class BalanceDTO(
    val BTC: Long,
    val USD: Long,
    val USD_equivalent: Double? = null
)
