package com.sungho.order

import com.sungho.order.dto.RegisterOrderRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/order")
class OrderController(
    private val orderService: OrderService
) {
    @GetMapping
    fun getOrders(): List<Order> {
        return orderService.getOrders()
    }

    @GetMapping("/{id}")
    fun getOrders(@PathVariable id: Long): Order {
        return orderService.getOrder(id)
    }

    @PostMapping
    fun registerOrders(@RequestBody registerOrderRequest: RegisterOrderRequest): ResponseEntity<String> {
        orderService.registerOrder(registerOrderRequest)
        return ResponseEntity.ok().build()
    }
}