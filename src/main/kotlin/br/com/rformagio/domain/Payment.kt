package br.com.rformagio.domain

import br.com.rformagio.data.PaymentData
import br.com.rformagio.data.PaymentType
import java.util.*
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract class Payment(var type: PaymentType) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var paymentId: UUID? = null

    abstract fun toData(): PaymentData
}