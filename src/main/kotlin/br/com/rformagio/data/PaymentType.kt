package br.com.rformagio.data

import com.fasterxml.jackson.annotation.JsonValue

enum class PaymentType(@get:JsonValue val description: String) {
    BOLETO("BOLETO"),
    CREDIT_CARD("CFEDIT_CARD")
}