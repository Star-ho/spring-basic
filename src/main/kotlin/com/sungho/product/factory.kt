package com.sungho.product

import com.sungho.product.request.CreateProductDto
import org.springframework.stereotype.Component

@Component
class ProductFactory(
    private val productRepository: ProductRepository
) {
    fun createProduct(createProductDto: CreateProductDto) {
        val product = Product(0, createProductDto.label, createProductDto.price)
        productRepository.save(product)
    }
}