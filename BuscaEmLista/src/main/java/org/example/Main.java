package org.example;
import java.util.ArrayList;
import java.util.Scanner;

//Busca Array List
public class Main {
    public static void main(String[] args) {
        ArrayList<String> nomes = new ArrayList<>();
        nomes.add("Ana");
        nomes.add("Bruno");
        nomes.add("Carlos");
        nomes.add("Daniel");
        nomes.add("Eduardo");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um nome para buscar: ");
        String nomeBusca = scanner.nextLine();
        int indice = nomes.indexOf(nomeBusca);
        if (indice != -1) {
            System.out.println("O nome " + nomeBusca + " foi encontrado na posição " + indice);
        } else {
            System.out.println("O nome " + nomeBusca + " não está na lista.");
        }
        scanner.close();
    }
}