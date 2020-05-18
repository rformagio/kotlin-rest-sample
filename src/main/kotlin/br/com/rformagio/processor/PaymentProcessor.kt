package br.com.rformagio.processor

import br.com.rformagio.data.PaymentData
import br.com.rformagio.data.PaymentType

interface PaymentProcessor {

    fun process(paymentData: PaymentData)
    fun getType() : PaymentType
}