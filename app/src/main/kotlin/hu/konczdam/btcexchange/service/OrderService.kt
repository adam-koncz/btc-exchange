package hu.konczdam.btcexchange.service

import hu.konczdam.btcexchange.repository.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrderService: IOrderService {

    @Autowired
    private lateinit var orderRepository: OrderRepository
}
