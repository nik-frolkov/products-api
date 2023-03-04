package demo.service

import demo.mapper.ProductMapper
import demo.model.entity.Product
import demo.model.ProductCreateDto
import demo.repository.ProductRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
class ProductService(
    val productRepository: ProductRepository,
    val productMapper: ProductMapper
    ) {

    fun createProduct(products: List<ProductCreateDto>): List<Long> {
        val savedProducts = productRepository.saveAll(productMapper.toProduct(products))
        return savedProducts.stream()
            .map(Product::id)
            .collect(Collectors.toList())
    }

    fun getProductById(id: Long): Product {
        return productRepository.getById(id);
    }

    fun getProductsByNames(names: Set<String>): List<Product> {
        return productRepository.findAllByNameIn(names)
    }

    fun getProductsByBarcodes(barcodes: Set<String>): List<Product> {
        return productRepository.findAllByBarcodeIn(barcodes)
    }

    @Transactional
    fun deleteProductsByNames(names: Set<String>) {
        productRepository.deleteAllByNameIn(names)
    }

    @Transactional
    fun deleteProductsByBarcodes(barcodes: Set<String>) {
        productRepository.deleteAllByBarcodeIn(barcodes)
    }
}