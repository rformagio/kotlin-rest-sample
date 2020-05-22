package br.com.rformagio.service

import br.com.rformagio.processor.Processor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PaymentService {

    @Autowired
    private lateinit var processor: Processor

    
}