package br.com.rformagio.repository

import br.com.rformagio.domain.Payment
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface PaymentRepository: JpaRepository<Payment, UUID> {
    fun save(payment: Payment): Payment
}