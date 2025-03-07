package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEscolha o método de pagamento:");
        System.out.println("|1|- Pix");
        System.out.println("|2|- Cartão de Crédito");
        System.out.println("|3|- Boleto");
        System.out.print("\nOpção: ");

        int option = scanner.nextInt();
        scanner.nextLine();

        PaymentStrategy paymentStrategy = PaymentFactory.createPayment(option);
        if (paymentStrategy == null) {
            System.out.println("Opção inválida!");
            return;
        }

        System.out.print("Digite o valor da transação: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        PaymentProcessor processor = new PaymentProcessor(paymentStrategy);
        processor.executePayment(amount);
    }
}