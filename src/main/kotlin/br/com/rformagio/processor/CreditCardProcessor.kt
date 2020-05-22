package br.com.rformagio.processor

import br.com.rformagio.data.PaymentData
import br.com.rformagio.data.PaymentType
import org.springframework.stereotype.Component

@Component
class CreditCardProcessor: PaymentProcessor {

    private var type: PaymentType = PaymentType.CREDIT_CARD

    override fun getType(): PaymentType = type

    override fun process(paymentData: PaymentData) {
        TODO("Not yet implemented")
    }


}