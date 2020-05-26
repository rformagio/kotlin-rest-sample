package br.com.rformagio.domain

import br.com.rformagio.data.PaymentType
import java.util.*
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
open class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    lateinit var paymentId: UUID

    lateinit var type: PaymentType
}