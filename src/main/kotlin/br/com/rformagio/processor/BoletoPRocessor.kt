package br.com.rformagio.processor

import br.com.rformagio.data.PaymentData
import br.com.rformagio.data.PaymentType
import org.springframework.stereotype.Component

@Component
class BoletoPRocessor: PaymentProcessor {

    private var type: PaymentType = PaymentType.BOLETO

    constructor()

    override fun getType(): PaymentType {
        return type
    }

    override fun process(paymentData: PaymentData) {
        TODO("Not yet implemented")
    }

}