package hu.konczdam.btcexchange.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Index
import javax.persistence.JoinColumn
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(
    name = "users",
    indexes = arrayOf(
        Index(name = "usernameIndex", columnList = "username")
    )
)
data class User(

    @Column(unique = true)
    val username: String,

    @Column
    var usdBalance: Long = 0,

    @Column
    var btcBalance: Long = 0,

    @OneToMany(
        fetch = FetchType.LAZY,
        orphanRemoval = true
    )
    @JoinColumn(name = "id")
    val standingOrders: MutableList<Order> = mutableListOf()
) {
    @Id
    @GeneratedValue
    var id: Long? = null
}
