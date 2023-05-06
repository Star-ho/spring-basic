package com.sungho.product

import com.sungho.product.response.ProductResponse
import com.sungho.product.request.CreateProductDto
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/product")
class ProductController(
    private val productService: ProductService,
) {
    @GetMapping
    fun getProductList(): List<ProductResponse> {
        return productService.getProductList().map { ProductResponse(it) }
    }

    @PostMapping
    fun registerProduct(@RequestBody createProductDto: CreateProductDto) {
        return productService.registerProduct(createProductDto)
    }
}