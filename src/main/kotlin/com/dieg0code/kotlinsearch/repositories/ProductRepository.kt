package com.dieg0code.kotlinsearch.repositories

import com.dieg0code.kotlinsearch.models.Product
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ProductRepository : JpaRepository<Product, Int> {

    @Query("select p from  Product p where p.title like %?1% or p.description like %?1%")
    fun search(s: String, sort: Sort): List<Product>
}