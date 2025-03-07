package org.example;

import java.util.Random;

public class Pix implements PaymentStrategy {
    @Override
    public void ProcessPayment(double amount){
        String pixCode = "PIX" + new Random().nextInt(999999);
        System.out.println("Pagamento via Pix processado com sucesso!\n");
        System.out.println("Código Pix: " + pixCode);
        System.out.println("Valor: R$ " + amount);
    }
}
