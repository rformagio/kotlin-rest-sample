package br.com.rformagio.domain

import br.com.rformagio.data.CreditCardData
import br.com.rformagio.data.PaymentData
import br.com.rformagio.data.PaymentType
import javax.persistence.Entity
import javax.persistence.PrimaryKeyJoinColumn

@Entity
@PrimaryKeyJoinColumn(name = "creditCardId", referencedColumnName = "paymentId")
class CreditCard (var creditCardNumber: String,
                  var cvv: String,
                  var holderName: String): Payment(PaymentType.CREDIT_CARD) {

    override fun toData(): PaymentData {
        val creditCardData = CreditCardData(creditCardNumber,
                                    cvv,
                                    holderName)
        creditCardData.paymentId = super.paymentId
        return creditCardData
    }

}