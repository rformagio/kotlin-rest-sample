package br.com.rformagio.service

import br.com.rformagio.data.PaymentData
import br.com.rformagio.processor.PaymentProcessor
import br.com.rformagio.processor.Processor
import br.com.rformagio.repository.PaymentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PaymentService(@Autowired val processor: Processor,
                     @Autowired val paymentRepository: PaymentRepository) {



    fun process(paymentData: PaymentData){

        var paymentProcessor: PaymentProcessor? = processor.getPaymentProcessorByType(paymentData.type)
        paymentProcessor?.process(paymentData)
       // paymentRepository.save()
    }
}