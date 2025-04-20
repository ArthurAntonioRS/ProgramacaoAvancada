package com.unicesumar.entities;

import java.util.List;
import java.util.UUID;

public class Sale extends Entity {
    private final UUID userId;
    private final List<UUID> productIds;
    private final double totalAmount;
    private final String paymentType;

    public Sale(UUID userId, List<UUID> productIds, double totalAmount, String paymentType) {
        super();
        this.userId = userId;
        this.productIds = productIds;
        this.totalAmount = totalAmount;
        this.paymentType = paymentType;
    }

    public UUID getUserId() {
        return userId;
    }

    public List<UUID> getProductIds() {
        return productIds;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    @Override
    public String toString() {
        return String.format("Venda %s | Usuário: %s | Produtos: %s | Total: R$%.2f | Pagamento: %s",
                getUuid(), userId, productIds, totalAmount, paymentType);
    }
}