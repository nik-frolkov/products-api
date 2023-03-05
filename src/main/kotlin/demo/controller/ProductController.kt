package demo.controller

import demo.controller.ProductController.Companion.PRODUCTS_URL
import demo.model.ProductCreateDto
import demo.model.entity.Product
import demo.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.NO_CONTENT
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(PRODUCTS_URL)
class ProductController(
        val productService: ProductService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createProduct(@RequestBody products: List<ProductCreateDto>): List<Long> =
            productService.createProduct(products)

    @GetMapping(params = ["id"])
    fun getProductById(@RequestParam("id") id: Long): Product =
            productService.getProductById(id)

    @GetMapping(params = ["names"])
    fun getProductsByNames(@RequestParam("names") names: Set<String>): List<Product> =
            productService.getProductsByNames(names)

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
    @DeleteMapping(params = [BARCODES_PARAM])
    fun deleteProductsByBarcodes(@RequestParam(BARCODES_PARAM) barcodes: Set<String>) {
        productService.deleteProductsByBarcodes(barcodes)
    }

    companion object {
        const val PRODUCTS_URL = "products"
        const val BARCODES_PARAM = "barcodes"
    }
}