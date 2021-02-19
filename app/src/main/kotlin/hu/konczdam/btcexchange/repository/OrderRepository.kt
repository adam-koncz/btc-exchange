package hu.konczdam.btcexchange.repository

import hu.konczdam.btcexchange.model.Order
import hu.konczdam.btcexchange.model.OrderState
import hu.konczdam.btcexchange.model.OrderType
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : CrudRepository<Order, Long> {

    fun getOrdersByOrderTypeAndOrderStateNotOrderByLimitPriceAsc(
        orderType: OrderType,
        orderState: OrderState = OrderState.FULFILLED
    )
}
