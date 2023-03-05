package demo.model.entity

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCTS")
data class Product(
        @Column(name = "name", nullable = false)
        val name: String,
        @Column(name = "ccals", nullable = false)
        var ccals: Double
) : AbstractAuditedEntity() {

    @Column(name = "barcode")
    var barcode: String? = null

    @Column(name = "proteins")
    var proteins: Double = 0.00

    @Column(name = "carbs")
    var carbs: Double = 0.00

    @Column(name = "fats")
    var fats: Double = 0.00
}