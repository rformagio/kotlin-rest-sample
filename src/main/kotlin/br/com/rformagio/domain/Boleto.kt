package br.com.rformagio.domain

import javax.persistence.Entity
import javax.persistence.PrimaryKeyJoinColumn

@Entity
@PrimaryKeyJoinColumn(name = "boletoId", referencedColumnName = "paymentId")
class Boleto(var barCode: String): Payment() {



}