package br.com.rformagio.data

data class BoletoData(var boletoNumber: String): PaymentData(PaymentType.BOLETO)