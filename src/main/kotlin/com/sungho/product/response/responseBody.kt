package com.sungho.product.response

import com.sungho.product.Product

class ProductResponse(product: Product) {
    val id = product.id
    val label = product.label
    val price = product.price
}