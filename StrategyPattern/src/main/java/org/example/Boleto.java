package org.example;

import java.util.Random;

public class Boleto implements PaymentStrategy {
    @Override
        public void ProcessPayment(double amount) {
            String boletoCode = "237" + new Random().nextInt(999999999);
            System.out.println("Pagamento via Boleto gerado com sucesso!\n");
            System.out.println("Código do Boleto: " + boletoCode);
            System.out.println("Valor: R$ " + amount);
        }
}
