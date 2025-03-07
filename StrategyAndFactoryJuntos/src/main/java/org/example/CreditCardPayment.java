package org.example;

import java.util.Scanner;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do cartão de crédito: ");
        String numCartao = scanner.nextLine();
        System.out.println("Pagamento via Cartão de Crédito processado com sucesso!\n");
        System.out.println("Número do cartão: " + numCartao);
        System.out.println("Valor: R$ " + amount);
    }
}
