package com.sungho.order

import com.sungho.member.Member
import com.sungho.product.Product
import javax.persistence.*

@Entity
@Table(name = "`ORDER`")
class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "TOTAL_PRICE")
    val totalPrice: Int = 0,

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    val member: Member,

    @OneToMany(fetch = FetchType.LAZY)
    var orderEntryList: MutableList<OrderEntry> = mutableListOf(),
)


@Entity
@Table(name = "ORDER_ENTRY")
class OrderEntry(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    var order: Order? = null,

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    val product: Product,

    @Column(name = "PRICE")
    val price: Int,

    @Column(name = "QUANTITY")
    val quantity: Int,
)