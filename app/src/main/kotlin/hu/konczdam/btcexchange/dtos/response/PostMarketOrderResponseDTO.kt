package hu.konczdam.btcexchange.dtos.response

data class PostMarketOrderResponseDTO(
    val fulfilled: Long,
    val avgPrice: Double,
)
