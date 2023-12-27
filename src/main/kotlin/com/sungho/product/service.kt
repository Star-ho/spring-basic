package com.sungho.product

import com.sungho.product.request.CreateProductDto
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class ProductService(

) {
    fun getProductList(): List<Product> {
        return listOf()
    }

}