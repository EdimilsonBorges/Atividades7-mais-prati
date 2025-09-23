package com.poo.desafio;

public class Produto2 {
    private final String nome;
    private final Dinheiro preco;

    public Produto2(String nome, Dinheiro preco) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do produto inválido.");
        }
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public Dinheiro getPreco() {
        return preco;
    }
}
