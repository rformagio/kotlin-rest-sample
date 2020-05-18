package br.com.rformagio.processor

import br.com.rformagio.data.PaymentType
import org.springframework.stereotype.Component

@Component
class Processor {

    var processor: Map<PaymentType, PaymentProcessor>

    constructor(allProcessors: List<PaymentProcessor>) {
        processor = allProcessors.associateBy( { it.getType() }, {it})
    }

    fun getPaymentProcessorByType(paymentType: PaymentType) =
            processor.get(paymentType)
}