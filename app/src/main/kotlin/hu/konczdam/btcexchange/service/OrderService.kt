package hu.konczdam.btcexchange.service

import hu.konczdam.btcexchange.dtos.request.PostMarketOrderDTO
import hu.konczdam.btcexchange.dtos.response.PostMarketOrderResponseDTO
import hu.konczdam.btcexchange.repository.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OrderService : IOrderService {

    @Autowired
    private lateinit var orderRepository: OrderRepository

    @Autowired
    private lateinit var userService: UserService

    @Transactional
    override fun postAndResolveMarketOrderForUser(
        userId: Long,
        orderDto: PostMarketOrderDTO
    ): PostMarketOrderResponseDTO {
        TODO("Not yet implemented")
    }
}
