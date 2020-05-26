package br.com.rformagio.controller

import br.com.rformagio.data.PaymentData
import br.com.rformagio.domain.Payment
import br.com.rformagio.service.PaymentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/payments")
class PaymentController {

    @Autowired
    lateinit var paymentService: PaymentService

    @GetMapping("/")
    fun getAllPayments() = paymentService.findAll()

    @GetMapping("/{paymentId}")
    fun getPayment(@PathVariable(value = "paymentId") paymentId: UUID):Payment {
        return paymentService.findPaymentById(paymentId).get()
    }

    @PostMapping
    fun createPayment(@RequestBody paymentData: PaymentData): UUID? {
         return paymentService.createPayment(paymentData)
    }
}