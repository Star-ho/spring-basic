package com.sungho.product

import com.sungho.product.request.CreateProductDto
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeGreaterThan
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductServiceTest @Autowired constructor(
    private val productService: ProductService
) : FunSpec(){
    init {
        test("registerProduct") {
            val request = CreateProductDto(
                label = "productLabel",
                price = 1000
            )
            shouldNotThrow<Exception> {
                productService.registerProduct(request)
            }
        }

        test("getProductList") {
            val productList = productService.getProductList()
            productList.size shouldBeGreaterThan 1
        }

        test("getProduct") {
            shouldNotThrow<Exception> {
                productService.getProduct(1)
            }
        }

    }
}
