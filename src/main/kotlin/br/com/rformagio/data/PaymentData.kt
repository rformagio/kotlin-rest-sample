package br.com.rformagio.data

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import java.util.*

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type"
)
@JsonSubTypes(
        JsonSubTypes.Type (value = BoletoData::class, name = "BOLETO"),
        JsonSubTypes.Type (value = CreditCardData::class, name = "CREDIT_CARD")
)
abstract class PaymentData (val type: PaymentType) {
    lateinit var paymentId: UUID
}