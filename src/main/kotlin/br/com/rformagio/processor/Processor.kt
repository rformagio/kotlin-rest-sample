package br.com.rformagio.processor

import br.com.rformagio.data.PaymentType
import org.springframework.stereotype.Component

@Component
class Processor(allProcessors: List<PaymentProcessor>) {

    var processor: Map<PaymentType, PaymentProcessor> =
            allProcessors.associateBy( { it.getType() }, {it})

    fun getPaymentProcessorByType(paymentType: PaymentType) =
            processor[paymentType]
}