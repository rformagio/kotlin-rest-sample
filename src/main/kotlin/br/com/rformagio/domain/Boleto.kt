package br.com.rformagio.domain

import br.com.rformagio.data.BoletoData
import br.com.rformagio.data.PaymentData
import br.com.rformagio.data.PaymentType
import java.util.*
import javax.persistence.Entity
import javax.persistence.PrimaryKeyJoinColumn

@Entity
@PrimaryKeyJoinColumn(name = "boletoId", referencedColumnName = "paymentId")
data class Boleto(var barCode: String): Payment(PaymentType.BOLETO) {

    override fun toData(): PaymentData {
        val boletoData = BoletoData(barCode)
        boletoData.paymentId = super.paymentId
        return boletoData
    }




}