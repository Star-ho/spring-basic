package com.sungho.product

import javax.persistence.*

@Entity
@Table(name = "PRODUCT")
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    @Column(name = "LABEL")
    val label: String,
    @Column(name = "PRICE")
    val price: Int,
)