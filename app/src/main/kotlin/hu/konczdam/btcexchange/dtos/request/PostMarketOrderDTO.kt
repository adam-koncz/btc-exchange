package hu.konczdam.btcexchange.dtos.request

import hu.konczdam.btcexchange.model.OrderType

data class PostMarketOrderDTO(
    val quantity: Long,
    val type: OrderType,
)
