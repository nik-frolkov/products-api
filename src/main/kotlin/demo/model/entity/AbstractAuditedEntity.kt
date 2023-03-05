package demo.model.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class AbstractAuditedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonIgnore
    var id: Long = 0L

    @CreatedDate
    @Column(nullable = false, updatable = false)
    lateinit var createdAt: LocalDateTime

    @CreatedDate
    @Column(nullable = false, updatable = false)
    lateinit var createdBy: String

    @LastModifiedDate
    @Column(nullable = false)
    lateinit var modifiedAt: LocalDateTime

    @LastModifiedDate
    @Column(nullable = false)
    lateinit var modifiedBy: String
}