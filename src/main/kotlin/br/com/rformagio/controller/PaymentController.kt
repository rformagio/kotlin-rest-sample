package br.com.rformagio.controller

import br.com.rformagio.data.BoletoData
import br.com.rformagio.data.CreditCardData
import br.com.rformagio.data.PaymentData
import br.com.rformagio.data.PaymentType
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/payments")
class PaymentController {


    @GetMapping("/{paymentId}")
    fun getPayment(@PathVariable(value = "paymentId") paymentId: String) =
            "PaymentID: $paymentId" + "UUID: " + UUID.randomUUID()


    @PostMapping
    fun createPayment(@RequestBody payment: PaymentData): String {

        val p = payment;
        when (p) {
            is BoletoData -> return p.boletoNumber
            is CreditCardData -> return p.creditCardNumber
        }
        return ""
    }
}