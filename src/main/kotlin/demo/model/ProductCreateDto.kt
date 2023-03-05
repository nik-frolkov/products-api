package demo.model

import lombok.Data

@Data
class ProductCreateDto(
    val name: String,
    val barcode: String?,
    val ccals: Double,
    val proteins: Double?,
    val carbs: Double?,
    val fats: Double?
)