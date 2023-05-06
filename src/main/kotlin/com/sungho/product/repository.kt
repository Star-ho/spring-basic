package com.sungho.product

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductJPARepository : JpaRepository<Product, Long>