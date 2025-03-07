package org.example;

public class PaymentFactory {
    public static PaymentStrategy createPayment(int option) {
        return switch (option) {
            case 1 -> new PixPayment();
            case 2 -> new CreditCardPayment();
            case 3 -> new BoletoPayment();
            default -> null;
        };
    }
}
