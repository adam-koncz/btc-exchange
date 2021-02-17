package hu.konczdam.btcexchange.repository

import hu.konczdam.btcexchange.model.Order
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : CrudRepository<Order, Long>
