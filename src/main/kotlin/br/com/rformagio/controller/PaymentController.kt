package br.com.rformagio.controller

import br.com.rformagio.data.BoletoData
import br.com.rformagio.data.CreditCardData
import br.com.rformagio.data.PaymentData
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/payments")
class PaymentController {


    @GetMapping("/{paymentId}")
    fun getPayment(@PathVariable(value = "paymentId") paymentId: String) =
            "PaymentID: $paymentId ," + "UUID: " + UUID.randomUUID()


    @PostMapping
    fun createPayment(@RequestBody payment: PaymentData): String {

        when (payment) {
            is BoletoData -> return payment.boletoNumber +
                    " : " + payment.type +
                    " : " + payment.paymentId
            is CreditCardData -> return payment.creditCardNumber +
                    " : " + payment.cvv +
                    " : " + payment.holderName +
                    " : " + payment.type
        }
        return ""
    }
}