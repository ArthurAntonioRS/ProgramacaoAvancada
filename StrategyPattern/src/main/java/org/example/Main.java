package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentStrategy paymentStrategy;

        System.out.println("\nEscolha o método de pagamento:");
        System.out.println("|1|- Pix");
        System.out.println("|2|- Cartão de Crédito");
        System.out.println("|3|- Boleto");
        System.out.print("\nOpção: ");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                paymentStrategy = new Pix();
                break;
            case 2:
                paymentStrategy = new CreditCard();
                break;
            case 3:
                paymentStrategy = new Boleto();
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }

        System.out.print("Digite o valor da transação: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        ProcessPayment processor = new ProcessPayment(paymentStrategy);
        processor.executePayment(amount);

    }
}
