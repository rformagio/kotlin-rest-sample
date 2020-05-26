package br.com.rformagio.processor

import br.com.rformagio.data.BoletoData
import br.com.rformagio.data.CreditCardData
import br.com.rformagio.data.PaymentData
import br.com.rformagio.data.PaymentType
import br.com.rformagio.domain.Boleto
import br.com.rformagio.domain.CreditCard
import org.springframework.stereotype.Component

@Component
class CreditCardProcessor: PaymentProcessor {

    private var type: PaymentType = PaymentType.CREDIT_CARD

    override fun getType(): PaymentType = type

    override fun process(paymentData: PaymentData): CreditCard {
        if(paymentData !is CreditCardData) throw IllegalArgumentException("CreditCardData required")
        var payment = CreditCard(paymentData.creditCardNumber,
        paymentData.cvv,
        paymentData.holderName)

        return payment
    }


}