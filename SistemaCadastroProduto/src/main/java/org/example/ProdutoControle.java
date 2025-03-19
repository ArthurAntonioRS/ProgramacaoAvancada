package org.example;

import java.util.HashMap;
import java.util.Map;

public class ProdutoControle {
    private Map<Integer, Produto> produtos = new HashMap<>();

    public void cadastrarProduto(int codigo, String nome, double preco) {
        Produto produto = new Produto(codigo, nome, preco);
        produtos.put(codigo, produto);
        System.out.println("\nProduto cadastrado com sucesso!");
        System.out.flush();
    }

    public Produto buscarProdutoPorCodigo(int codigo) {
        return produtos.get(codigo);
    }
}
