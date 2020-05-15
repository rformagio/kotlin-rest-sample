package br.com.rformagio.data

data class CreditCardData(var creditCardNumber: String,
                          var cvv: String,
                          var holderName: String,
                          override val type: PaymentType = PaymentType.CREDIT_CARD) : PaymentData(type)