package br.com.rformagio.service

import br.com.rformagio.data.PaymentData
import br.com.rformagio.processor.PaymentProcessor
import br.com.rformagio.processor.Processor
import br.com.rformagio.repository.PaymentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class PaymentService(@Autowired private val processor: Processor,
                     @Autowired private val paymentRepository: PaymentRepository) {



    fun createPayment(paymentData: PaymentData): UUID? {

        var paymentProcessor: PaymentProcessor? = processor.getPaymentProcessorByType(paymentData.type)
        var payment = paymentProcessor?.process(paymentData)
        if (payment != null) {
           return paymentRepository.save(payment).paymentId
        }
        return null
    }

    fun findPaymentById(paymentId:UUID) =
            paymentRepository.findById(paymentId)

    fun findAll() = paymentRepository.findAll()
}