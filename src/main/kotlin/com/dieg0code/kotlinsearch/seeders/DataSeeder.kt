package com.dieg0code.kotlinsearch.seeders

import com.dieg0code.kotlinsearch.models.Product
import com.dieg0code.kotlinsearch.repositories.ProductRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import kotlin.random.Random

//Seeding the Database
@Component
class DataSeeder(private val productRepository: ProductRepository) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
      /*  for (i in 1..50) {
            val product = Product()
            product.title = "Title #" + i
            product.description = "Description #" + (i + 1)
            product.image = "http://lorempixel.com/200/200?" + Random.nextInt(10000)
            product.price = Random.nextInt(10, 100)
            this.productRepository.save(product)
        } */
    }
}