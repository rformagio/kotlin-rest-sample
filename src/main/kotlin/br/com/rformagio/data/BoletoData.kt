package br.com.rformagio.data

data class BoletoData(var barCode: String): PaymentData(PaymentType.BOLETO)