package demo.mapper

import demo.model.ProductCreateDto
import demo.model.entity.Product
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
 class ProductMapper {

    fun toProduct(products: List<ProductCreateDto>): List<Product> {
        return products.stream()
            .map(this::createProduct)
            .collect(Collectors.toList())
    }

    private fun createProduct(productCreateDto: ProductCreateDto): Product {
        return Product(
            productCreateDto.name,
            productCreateDto.barcode,
            productCreateDto.ccals,
            productCreateDto.proteins,
            productCreateDto.carbs,
            productCreateDto.fats,
            productCreateDto.weight
        )
    }
}