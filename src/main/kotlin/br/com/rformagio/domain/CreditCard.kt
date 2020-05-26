package br.com.rformagio.domain

import javax.persistence.Entity
import javax.persistence.PrimaryKeyJoinColumn

@Entity
@PrimaryKeyJoinColumn(name = "creditCardId", referencedColumnName = "paymentId")
class CreditCard: Payment() {

    lateinit var creditCardNumber: String
    lateinit var cvv: String
    lateinit var holderName: String
}