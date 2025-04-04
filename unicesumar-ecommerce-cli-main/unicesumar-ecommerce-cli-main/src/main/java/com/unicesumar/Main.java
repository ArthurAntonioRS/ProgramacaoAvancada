package com.unicesumar;

import com.unicesumar.entities.Product;
import com.unicesumar.entities.User;
import com.unicesumar.repository.ProductRepository;
import com.unicesumar.repository.UserRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        ProductRepository productRepository = null;
        UserRepository userRepository = null;
        Connection conn = null;

        // Parâmetros de conexão
        String url = "jdbc:sqlite:database.sqlite";

        // Tentativa de conexão
        try {
            conn = DriverManager.getConnection(url);
            if (conn != null) {
                productRepository = new ProductRepository(conn);
                userRepository = new UserRepository(conn);
            } else {
                System.out.println("Falha na conexão.");
                System.exit(1);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            System.exit(1);
        }

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n---MENU---");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Procurar Produto");
            System.out.println("4 - Deletar Produto");
            System.out.println("5 - Cadastrar Usuário");
            System.out.println("6 - Listar Usuários");
            System.out.println("7 - Procurar Usuário");
            System.out.println("8 - Deletar Usuário");
            System.out.println("9 - Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            switch (option) {
                // Produtos
                case 1:
                    System.out.println("Cadastrar Produto");
                    productRepository.save(new Product("Teste", 10));
                    productRepository.save(new Product("Computador", 3000));
                    break;
                case 2:
                    System.out.println("Listar Produtos");
                    List<Product> products = productRepository.findAll();
                    products.forEach(product -> {
                        System.out.println("ID: " + product.getUuid());
                        System.out.println("Nome: " + product.getName());
                        System.out.println("Preço: " + product.getPrice());
                        System.out.println();
                    });
                    break;
                case 3:
                    System.out.print("Informe o UUID do Produto para Procurar: ");
                    String productIdToSearch = scanner.next();
                    try {
                        UUID uuidProduct = UUID.fromString(productIdToSearch);
                        productRepository.findById(uuidProduct)
                                .ifPresentOrElse(
                                        System.out::println,
                                        () -> System.out.println("Produto não encontrado")
                                );
                    } catch (IllegalArgumentException e) {
                        System.out.println("UUID inválido.");
                    }
                    break;
                case 4:
                    System.out.print("Informe o UUID do Produto para Deletar: ");
                    String productIdToDelete = scanner.next();
                    try {
                        UUID uuidProduct = UUID.fromString(productIdToDelete);
                        productRepository.deleteById(uuidProduct);
                        System.out.println("Produto deletado com sucesso.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("UUID inválido.");
                    }
                    break;

                // Usuários
                case 5:
                    System.out.println("Cadastrar Usuário");
                    // Solicita os dados do usuário
                    System.out.print("Nome do Usuário: ");
                    String name = scanner.next();
                    System.out.print("Email do Usuário: ");
                    String email = scanner.next();
                    System.out.print("Senha do Usuário: ");
                    String password = scanner.next();

                    // Verifica se já existe um usuário com o mesmo e-mail
                    if (userRepository.findByEmail(email).isPresent()) {
                        System.out.println("Erro: Já existe um usuário cadastrado com esse e-mail.");
                    } else {
                        userRepository.save(new User(name, email, password));
                        System.out.println("Usuário cadastrado com sucesso!");
                    }
                    break;
                case 6:
                    System.out.println("Listar Usuários");
                    List<User> users = userRepository.findAll();
                    users.forEach(user -> {
                        System.out.println("ID: " + user.getUuid());
                        System.out.println("Nome: " + user.getName());
                        System.out.println("Email: " + user.getEmail());
                        System.out.println();
                    });
                    break;
                case 7:
                    System.out.print("Informe o UUID do Usuário para Procurar: ");
                    String userIdToSearch = scanner.next();
                    try {
                        UUID uuidUser = UUID.fromString(userIdToSearch);
                        userRepository.findById(uuidUser)
                                .ifPresentOrElse(
                                        System.out::println,
                                        () -> System.out.println("Usuário não encontrado")
                                );
                    } catch (IllegalArgumentException e) {
                        System.out.println("UUID inválido.");
                    }
                    break;
                case 8:
                    System.out.print("Informe o UUID do Usuário para Deletar: ");
                    String userIdToDelete = scanner.next();
                    try {
                        UUID uuidUser = UUID.fromString(userIdToDelete);
                        userRepository.deleteById(uuidUser);
                        System.out.println("Usuário deletado com sucesso.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("UUID inválido.");
                    }
                    break;

                // Sair
                case 9:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente");
                    break;
            }

        } while (option != 9);

        scanner.close();
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
