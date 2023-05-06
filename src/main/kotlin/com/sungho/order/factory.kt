package com.sungho.order

import com.sungho.order.dto.CreateOrderEntryRequest
import com.sungho.order.dto.RegisterOrderRequest
import com.sungho.member.MemberRepository
import com.sungho.product.ProductRepository
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class OrderFactory(
    private val productRepository: ProductRepository,
    private val orderEntryRepository: OrderEntryRepository,
    private val memberRepository: MemberRepository,
    private val orderRepository: OrderRepository,
) {
    @OptIn(ExperimentalStdlibApi::class)
    fun createOrder(registerOrderRequest: RegisterOrderRequest) {
        val orderEntryList = registerOrderRequest.products.map { createOrderEntry(it) }
        val totalPrice = 0
        orderEntryList.forEach { totalPrice.plus(it.price) }

        val member =
            memberRepository.findById(registerOrderRequest.memberId).getOrNull() ?: throw IllegalArgumentException("멤버를 찾을 수 없습니다")
        val order = Order(
            totalPrice = totalPrice,
            member = member, orderEntryList = orderEntryList as MutableList<OrderEntry>
        )
        orderRepository.save(order)
        orderEntryRepository.saveAll(orderEntryList)
    }

    @OptIn(ExperimentalStdlibApi::class)
    private fun createOrderEntry(createOrderEntryRequest: CreateOrderEntryRequest): OrderEntry {
        val product = productRepository.findById(createOrderEntryRequest.productId).getOrNull()
            ?: throw IllegalArgumentException("상품이 존재하지 않습니다")
        return OrderEntry(
            product = product,
            price = product.price,
            quantity = createOrderEntryRequest.quantity
        )
    }
}