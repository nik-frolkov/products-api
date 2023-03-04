package demo.model.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCTS")
class Product(
    @Column(name = "name", nullable = false)
    val name: String,
    @Column(name = "barcode")
    val barcode: String?,
    @Column(name = "ccals", nullable = false)
    val ccals: Double,
    @Column(name = "proteins")
    val proteins: Double? = 0.00,
    @Column(name = "carbs")
    val carbs: Double? = 0.00,
    @Column(name = "fats")
    val fats: Double? = 0.00,
    @Column(name = "weight")
    val weight: Double? = 100.00
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonIgnore
    val id: Long = 0
}