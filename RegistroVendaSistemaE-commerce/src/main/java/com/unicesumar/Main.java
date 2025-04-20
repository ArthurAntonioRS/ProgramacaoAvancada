package com.unicesumar;

import com.unicesumar.entities.Product;
import com.unicesumar.entities.Sale;
import com.unicesumar.entities.User;
import com.unicesumar.paymentMethods.PaymentMethod;
import com.unicesumar.paymentMethods.PaymentType;
import com.unicesumar.repository.ProductRepository;
import com.unicesumar.repository.SaleRepository;
import com.unicesumar.repository.UserRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ProductRepository listaDeProdutos = null;
        UserRepository listaDeUsuarios = null;
        SaleRepository listaDeVendas = null;

        Connection conn = null;
        String url = "jdbc:sqlite:database.sqlite";

        try {
            conn = DriverManager.getConnection(url);
            if (conn != null) {
                listaDeProdutos = new ProductRepository(conn);
                listaDeUsuarios = new UserRepository(conn);
                listaDeVendas = new SaleRepository(conn);
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
            System.out.println("\n ---------MENU---------");
            System.out.println(" |1| - Cadastrar Produto");
            System.out.println(" |2| - Listar Produtos");
            System.out.println(" |3| - Cadastrar Usuário");
            System.out.println(" |4| - Listar Usuários");
            System.out.println(" |5| - Registrar Venda");
            System.out.println(" |6| - Sair");
            System.out.print(" Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (option) {
                case 1:
                    System.out.println(" Cadastrar Produto");
                    listaDeProdutos.save(new Product(" Teste", 10));
                    listaDeProdutos.save(new Product(" Computador", 3000));
                    break;

                case 2:
                    System.out.println(" Listar Produtos");
                    List<Product> products = listaDeProdutos.findAll();
                    products.forEach(p ->
                            System.out.println(" " + p.getUuid() + " | " + p.getName() + " | R$" + p.getPrice()));
                    break;

                case 3:
                    System.out.println(" Cadastrar Usuário");
                    listaDeUsuarios.save(new User(" Rafael Labegalini", "rafael@example", "1234"));
                    break;

                case 4:
                    System.out.println(" Listar Usuários");
                    List<User> users = listaDeUsuarios.findAll();
                    users.forEach(u ->
                            System.out.println(" " + u.getUuid() + " | " + u.getName()));
                    break;

                case 5:
                    System.out.println(" Registrar Venda");
                    List<User> usuarios = listaDeUsuarios.findAll();
                    List<Product> produtos = listaDeProdutos.findAll();

                    if (usuarios.isEmpty() || produtos.isEmpty()) {
                        System.out.println(" É necessário ter pelo menos um usuário e um produto cadastrado.");
                        break;
                    }

                    System.out.println(" ");
                    System.out.println(" Usuários:");
                    usuarios.forEach(u -> System.out.println(" " + u.getEmail() + " | " + u.getName()));
                    System.out.print(" Digite o e-mail do usuário comprador: ");
                    String emailUsuario = scanner.nextLine();

                    Optional<User> usuarioSelecionado = usuarios.stream()
                            .filter(u -> u.getEmail().equalsIgnoreCase(emailUsuario))
                            .findFirst();

                    if (usuarioSelecionado.isEmpty()) {
                        System.out.println(" Usuário não encontrado.");
                        break;
                    }

                    List<UUID> produtosSelecionados = new ArrayList<>();
                    List<String> nomesProdutos = new ArrayList<>();
                    double total = 0;

                    while (true) {
                        System.out.println(" ");
                        System.out.println(" Produtos disponíveis:");
                        produtos.forEach(p -> System.out.println(" " + p.getUuid() + " | " + p.getName() + " R$" + p.getPrice()));
                        System.out.print(" Digite o ID do produto (ou 'fim' para encerrar): ");
                        String entrada = scanner.nextLine();

                        if (entrada.equalsIgnoreCase("fim")) break;

                        try {
                            UUID idProduto = UUID.fromString(entrada);
                            Optional<Product> produtoSelecionado = produtos.stream()
                                    .filter(p -> p.getUuid().equals(idProduto))
                                    .findFirst();

                            if (produtoSelecionado.isPresent()) {
                                produtosSelecionados.add(idProduto);
                                nomesProdutos.add(produtoSelecionado.get().getName());
                                total += produtoSelecionado.get().getPrice();
                                System.out.println(" Produto adicionado!");
                                System.out.println(" ");
                            } else {
                                System.out.println(" Produto não encontrado!");
                                System.out.println(" ");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println(" ID inválido!");
                            System.out.println(" ");
                        }
                    }

                    if (produtosSelecionados.isEmpty()) {
                        System.out.println(" Nenhum produto selecionado! Venda cancelada.");
                        break;
                    }

                    System.out.println(" ");
                    System.out.println(" Total da venda: R$" + total);
                    System.out.print(" Forma de pagamento (boleto, cartao, pix): ");
                    String tipoPagamento = scanner.nextLine();

                    PaymentMethod metodo = PaymentMethodFactory.create(
                            switch (tipoPagamento.toLowerCase()) {
                                case "boleto" -> PaymentType.BOLETO;
                                case "cartao" -> PaymentType.CARTAO;
                                case "pix" -> PaymentType.PIX;
                                default -> null;
                            }
                    );

                    if (metodo == null) {
                        System.out.println(" Método de pagamento inválido!");
                        break;
                    }

                    System.out.println(" ");
                    System.out.println(" Aguarde, efetuando pagamento...");
                    String mensagemPagamento = metodo.pay(total);
                    System.out.println(" " + mensagemPagamento);

                    Sale novaVenda = new Sale(usuarioSelecionado.get().getUuid(), produtosSelecionados, total, tipoPagamento);
                    listaDeVendas.salvar(novaVenda);

                    System.out.println(" ");
                    System.out.println(" Resumo da venda:");
                    System.out.println(" Cliente: " + usuarioSelecionado.get().getName());
                    System.out.println(" Produtos:");
                    nomesProdutos.forEach(nome -> System.out.println(" - " + nome));
                    System.out.printf(" Valor total: R$%.2f\n", total);
                    System.out.println(" Pagamento: " + tipoPagamento.toUpperCase());

                    System.out.println(" ");
                    System.out.println(" Venda registrada com sucesso!");
                    break;

                case 6:
                    System.out.println(" Saindo...");
                    break;

                default:
                    System.out.println(" Opção inválida! Tente novamente.");
            }

        } while (option != 6);

        scanner.close();
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}