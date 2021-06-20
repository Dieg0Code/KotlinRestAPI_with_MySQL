package com.dieg0code.kotlinsearch.controllers

import com.dieg0code.kotlinsearch.models.Product
import com.dieg0code.kotlinsearch.repositories.ProductRepository
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class ProductController(private val productRepository: ProductRepository) {

    // This is an EndPoint
    @GetMapping("/products/frontend")
    fun frontend() : ResponseEntity<List<Product>> {
        return ResponseEntity.ok(this.productRepository.findAll())
    }

    @GetMapping("/products/backend")
    fun backend(
        @RequestParam("s", defaultValue = "") s: String,
        @RequestParam("sort", defaultValue = "") sort: String
    ) : ResponseEntity<List<Product>> {
        var direction = Sort.unsorted()

        if(sort == "asc") {
            direction = Sort.by(Sort.Direction.ASC, "price")
        } else if (sort == "desc") {
            direction = Sort.by(Sort.Direction.DESC, "price")
        }

        return ResponseEntity.ok(this.productRepository.search(s, direction))
    }
}