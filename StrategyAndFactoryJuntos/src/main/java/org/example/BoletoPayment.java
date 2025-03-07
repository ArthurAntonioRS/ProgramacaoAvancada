package org.example;

import java.util.Random;

public class BoletoPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        String boletoCode = "007" + new Random().nextInt(999999999);
        System.out.println("Pagamento via Boleto gerado com sucesso!\n");
        System.out.println("Código do Boleto: " + boletoCode);
        System.out.println("Valor: R$ " + amount);
    }
}
