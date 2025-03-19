package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProdutoControle produtoControle = new ProdutoControle();
        int opcao;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Buscar produto por código");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("\n- - - - - - - - - - - - - - - - -\n");
                    System.out.print("Digite o código do produto: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o preço do produto: ");
                    double preco = scanner.nextDouble();
                    System.out.print("- - - - - - - - - - - - - - - - -\n");
                    produtoControle.cadastrarProduto(codigo, nome, preco);
                    System.out.flush();
                }
                case 2 -> {
                    System.out.print("Digite o código do produto para buscar: ");
                    int codigoBusca = scanner.nextInt();
                    Produto produto = produtoControle.buscarProdutoPorCodigo(codigoBusca);
                    if (produto != null) {
                        System.out.println("\nProduto encontrado: " + produto);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                }
                case 3 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 3);

        scanner.close();
    }
}