package br.com.rformagio.processor

import br.com.rformagio.data.PaymentData
import br.com.rformagio.data.PaymentType
import br.com.rformagio.domain.Payment

interface PaymentProcessor {

    fun process(paymentData: PaymentData):Payment
    fun getType() : PaymentType
}