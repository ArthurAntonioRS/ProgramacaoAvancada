package com.unicesumar.paymentMethods;

import java.util.UUID;

public class PixPayment implements PaymentMethod {
    String chave = UUID.randomUUID().toString();

    public String pay(double amount) {
        System.out.println(" Pagamento efetuado com sucesso via PIX! " + "Chave de Autorização: " + chave);
        return "";
    }
}