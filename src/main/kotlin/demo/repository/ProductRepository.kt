package demo.repository

import demo.model.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long> {

    fun findAllByNameIn(names: Set<String>): List<Product>
    fun findAllByBarcodeIn(barcodes: Set<String>): List<Product>
    fun deleteAllByNameIn(names: Set<String>)
    fun deleteAllByBarcodeIn(barcodes: Set<String>)
}