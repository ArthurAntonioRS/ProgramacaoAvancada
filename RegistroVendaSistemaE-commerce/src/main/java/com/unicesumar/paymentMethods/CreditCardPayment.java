package com.unicesumar.paymentMethods;

import java.util.UUID;

public class CreditCardPayment implements PaymentMethod {

    String autorizacao = UUID.randomUUID().toString();

    @Override
    public String pay(double amount) {
        System.out.println(" Pagamento efetuado com sucesso via cartão de crédito! " + "Chave de Autorização: " + autorizacao);
        return "";
    }
}