package br.com.rformagio.processor

import br.com.rformagio.data.BoletoData
import br.com.rformagio.data.PaymentData
import br.com.rformagio.data.PaymentType
import br.com.rformagio.domain.Boleto
import org.springframework.stereotype.Component

@Component
class BoletoProcessor: PaymentProcessor {

    private var type: PaymentType = PaymentType.BOLETO

    override fun getType(): PaymentType = type
    override fun convertDataToEntity(paymentData: PaymentData) {
        if(paymentData !is BoletoData) throw IllegalArgumentException("BoletoData required")
        var payment = Boleto()

    }

    override fun process(paymentData: PaymentData) {

    }

}