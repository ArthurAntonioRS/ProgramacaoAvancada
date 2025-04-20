package com.unicesumar.repository;

import com.unicesumar.entities.Sale;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SaleRepository {
    private final Connection connection;

    public SaleRepository(Connection connection) {
        this.connection = connection;
        criarTabelaSeNaoExistir();
    }

    private void criarTabelaSeNaoExistir() {
        String sql = """
                CREATE TABLE IF NOT EXISTS sales (
                    uuid TEXT PRIMARY KEY,
                    user_id TEXT NOT NULL,
                    product_ids TEXT NOT NULL,
                    total_amount REAL NOT NULL,
                    payment_type TEXT NOT NULL
                );
                """;

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela de vendas: " + e.getMessage());
        }
    }

    public void salvar(Sale sale) {
        String sql = "INSERT INTO sales (uuid, user_id, product_ids, total_amount, payment_type) VALUES (?, ?, ?, ?, ?)";

        String produtosConcatenados = String.join(",", sale.getProductIds().stream().map(UUID::toString).toList());

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, sale.getUuid().toString());
            pstmt.setString(2, sale.getUserId().toString());
            pstmt.setString(3, produtosConcatenados);
            pstmt.setDouble(4, sale.getTotalAmount());
            pstmt.setString(5, sale.getPaymentType());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar venda: " + e.getMessage());
        }
    }

    public List<Sale> listar() {
        List<Sale> vendas = new ArrayList<>();
        String sql = "SELECT * FROM sales";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                UUID userId = UUID.fromString(rs.getString("user_id"));
                List<UUID> productIds = new ArrayList<>();
                for (String id : rs.getString("product_ids").split(",")) {
                    productIds.add(UUID.fromString(id));
                }
                double total = rs.getDouble("total_amount");
                String pagamento = rs.getString("payment_type");

                vendas.add(new Sale(userId, productIds, total, pagamento));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar vendas: " + e.getMessage());
        }

        return vendas;
    }
}