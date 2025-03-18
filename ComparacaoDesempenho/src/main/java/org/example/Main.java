package org.example;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Comparação Listas
public class Main {
    public static void main(String[] args) {
        int quantidade = 100000;

        // Teste com ArrayList
        List<Integer> arrayList = new ArrayList<>();
        long inicioArrayList = System.nanoTime();
        for (int i = 0; i < quantidade; i++) {
            arrayList.add(0, i);
        }
        long fimArrayList = System.nanoTime();

        // Teste com LinkedList
        List<Integer> linkedList = new LinkedList<>();
        long inicioLinkedList = System.nanoTime();
        for (int i = 0; i < quantidade; i++) {
            linkedList.add(0, i);
        }
        long fimLinkedList = System.nanoTime();

        // Exibindo os tempos
        System.out.println("Tempo ArrayList: " + (fimArrayList - inicioArrayList) / 1e6 + " ms");
        System.out.println("Tempo LinkedList: " + (fimLinkedList - inicioLinkedList) / 1e6 + " ms");
    }
}