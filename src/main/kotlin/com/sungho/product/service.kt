package com.sungho.product

import com.sungho.product.request.CreateProductDto
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class ProductService(
    private val productFactory: ProductFactory,
    private val productRepository: ProductRepository,
) {
    fun getProductList(): List<Product> {
        return productRepository.findAll()
    }

    @OptIn(ExperimentalStdlibApi::class)
    fun getProduct(id: Long): Product {
        return productRepository.findById(id).getOrNull() ?: throw IllegalArgumentException("상품을 찾을 수 없습니다")
    }

    fun registerProduct(createProductDto: CreateProductDto) {
        productFactory.createProduct(createProductDto)
    }
}