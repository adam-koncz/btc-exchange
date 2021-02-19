package hu.konczdam.btcexchange.model

import java.net.URL
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Index
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(
    name = "standing_orders",
    indexes = arrayOf(
        Index(name = "orderStateAndorderTypeAndLimitPrice", columnList = "orderState, orderType, limitPrice")
    ),
)
data class Order(

    val orderType: OrderType,

    var orderState: OrderState = OrderState.LIVE,

    val quantity: Long,

    val limitPrice: Long,

    val webhookUrl: URL,

    var fulfilledQuantity: Long = 0L,

    var averagePrice: Double = 0.0,

    @ManyToOne(fetch = FetchType.LAZY)
    val issuer: User?,
) {

    @Id
    @GeneratedValue
    var id: Long? = null
}
