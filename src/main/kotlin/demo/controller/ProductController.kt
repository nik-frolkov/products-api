package demo.controller

import demo.model.entity.Product
import demo.model.ProductCreateDto
import demo.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.NO_CONTENT
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("products")
class ProductController(val productService: ProductService) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createProduct(@RequestBody products: List<ProductCreateDto>): List<Long> {
        return productService.createProduct(products)
    }

    @GetMapping(params = ["id"])
    fun getProductById(@RequestParam("id") id: Long): Product {
        return productService.getProductById(id)
    }

    @GetMapping(params = ["names"])
    fun getProductsByNames(@RequestParam("names") names: Set<String>): List<Product> {
        return productService.getProductsByNames(names)
    }

    @GetMapping(params = ["barcodes"])
    fun getProductsByBarcodes(@RequestParam("barcodes") barcodes: Set<String>): List<Product> {
        return productService.getProductsByBarcodes(barcodes)
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping(params = ["names"])
    fun deleteProductsByNames(@RequestParam("names") names: Set<String>) {
        productService.deleteProductsByNames(names)
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping(params = ["barcodes"])
    fun deleteProductsByBarcodes(@RequestParam("barcodes") barcodes: Set<String>) {
        productService.deleteProductsByBarcodes(barcodes)
    }
}