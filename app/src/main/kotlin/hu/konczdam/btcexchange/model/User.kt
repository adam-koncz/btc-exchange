package hu.konczdam.btcexchange.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "users")
data class User(

    @Column(unique = true)
    val username: String,

    @Column
    var usdBalance: Long,

    @Column
    var btcBalance: Long,

    @OneToMany(
        fetch = FetchType.LAZY,
        orphanRemoval = true
    )
    @JoinColumn(name = "id")
    val standingOrders: List<Order>
) {
    @Id
    @GeneratedValue
    var id: Long? = null
}
