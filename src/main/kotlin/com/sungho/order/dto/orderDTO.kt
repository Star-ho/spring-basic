package com.sungho.order.dto

class RegisterOrderRequest(
    val memberId: Long,
    val products: List<CreateOrderEntryRequest>,
)

class CreateOrderEntryRequest(
    val productId: Long,
    val quantity: Int
)