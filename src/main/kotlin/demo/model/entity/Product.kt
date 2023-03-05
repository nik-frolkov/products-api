package demo.model.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.*

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCTS")
data class Product(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        @JsonIgnore
        val id: Long = 0,
        @Column(name = "name", nullable = false)
        val name: String,
        @Column(name = "ccals", nullable = false)
        var ccals: Double
) {
    @Column(name = "barcode")
    var barcode: String? = null

    @Column(name = "proteins")
    var proteins: Double = 0.00

    @Column(name = "carbs")
    var carbs: Double = 0.00

    @Column(name = "fats")
    var fats: Double = 0.00
}