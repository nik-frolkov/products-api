package demo.model

import lombok.Data

@Data
class ProductCreateDto(
    val name: String,
    val barcode: String?,
    val ccals: Double,
    val proteins: Double? = 0.00,
    val carbs: Double? = 0.00,
    val fats: Double? = 0.00,
    val weight: Double? = 100.00
)