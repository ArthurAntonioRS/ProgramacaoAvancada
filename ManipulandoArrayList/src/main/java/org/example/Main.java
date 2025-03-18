package org.example;
import java.util.ArrayList;

//Exercício Array List
public class Main {
    public static void main(String[] args) {
        ArrayList<String> nomes = new ArrayList<>();

        // Adicionando elementos
        nomes.add("Ana");
        nomes.add("Carlos");
        nomes.add("Maria");
        nomes.add("Pedro");
        nomes.add("Lucas");
        System.out.println("Lista inicial: " + nomes);

        // Removendo o terceiro nome
        nomes.remove(2);

        // Substituindo o último nome
        nomes.set(nomes.size() - 1, "João");
        System.out.println("Lista final: " + nomes);
    }
}