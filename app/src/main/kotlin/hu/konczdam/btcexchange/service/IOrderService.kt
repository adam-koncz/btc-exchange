package hu.konczdam.btcexchange.service

import hu.konczdam.btcexchange.dtos.request.PostMarketOrderDTO
import hu.konczdam.btcexchange.dtos.response.PostMarketOrderResponseDTO

interface IOrderService {
    fun postAndResolveMarketOrderForUser(
        userId: Long,
        orderDto: PostMarketOrderDTO
    ): PostMarketOrderResponseDTO
}
