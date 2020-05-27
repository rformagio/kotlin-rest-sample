./gradlew bootRun

GET - getPayment

http://localhost:8080/payments/{paymentId}

- ``paymentId`` is a UUID

GET - getPayments

http://localhost:8080/payments/

POST - createPayment

http://localhost:8080/payments/

body:
- BOLETO
```
{"paymentId": "", "type": "BOLETO", "barCode": "123456789"}
```
- CREDIT CARD
```
{"paymentId": "", "type": "CREDIT_CARD", "creditCardNumber": "123456789", "cvv": "123", "holderName": "Teste"}
```