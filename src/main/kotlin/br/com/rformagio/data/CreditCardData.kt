package br.com.rformagio.data

data class CreditCardData(var creditCardNumber: String,
                          var cvv: String,
                          var holderName: String) : PaymentData(PaymentType.CREDIT_CARD)