package com.unicesumar.paymentMethods;

import java.util.UUID;

public class BoletoPayment implements PaymentMethod {

    String codigo = UUID.randomUUID().toString();

    @Override
    public String pay(double amount) {
        System.out.println(" Pagamento efetuado com sucesso via boleto! " + "Código de Autorização: " + codigo);
        return "";
    }
}