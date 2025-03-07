package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nDigite o número correspondente ao tipo de notificação que deseja:");
        System.out.println("|1|- Email");
        System.out.println("|2|- SMS");
        System.out.println("|3|- Push");
        System.out.print("\nOpção: ");

        int option = scanner.nextInt();
        scanner.nextLine();

        String notificationType;
        switch (option) {
            case 1:
                notificationType = "email";
                break;
            case 2:
                notificationType = "sms";
                break;
            case 3:
                notificationType = "push";
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }

        System.out.print("Digite a mensagem que será enviada: ");
        String message = scanner.nextLine();

        Notification notification = NotificationFactory.createNotification(notificationType);
        notification.send(message);
    }
}
