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

    private fun createProduct(productCreateDto: ProductCreateDto): Product =
            Product(
                    name = productCreateDto.name,
                    ccals = productCreateDto.ccals,
            ).apply {
                barcode = productCreateDto.barcode
                proteins = productCreateDto.proteins ?: 0.00
                carbs = productCreateDto.carbs ?: 0.00
                fats = productCreateDto.fats ?: 0.00
            }
}