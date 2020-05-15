package br.com.rformagio.data

data class BoletoData(var boletoNumber: String,
                      override val type: PaymentType = PaymentType.BOLETO): PaymentData(type)