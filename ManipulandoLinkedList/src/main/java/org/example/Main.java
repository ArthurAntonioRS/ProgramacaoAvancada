package org.example;
import java.util.LinkedList;

//Exercício Linked List
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> numeros = new LinkedList<>();

        // Adicionando elementos
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        numeros.add(40);
        numeros.add(50);
        System.out.println("Lista inicial: " + numeros);

        // Adicionando no início e no fim
        numeros.addFirst(5);
        numeros.addLast(60);

        // Removendo o primeiro e o último elemento
        numeros.removeFirst();
        numeros.removeLast();
        System.out.println("Lista final: " + numeros);
    }
}
