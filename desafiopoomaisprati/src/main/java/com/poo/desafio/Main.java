package com.poo.desafio;

public class Main {
    public static void main(String[] args) {
        // Criando instância válida
        Produto p1 = new Produto("Carro Gol", 45000.00, 5);
        System.out.println(p1);

        // Alterando valores válidos
        p1.setPreco(50000.00);
        p1.setQuantidadeEmEstoque(10);
        p1.setNome("Gol 1.0");
        System.out.println("Após alterações válidas: " + p1);

        // Tentativas inválidas
        try {
            p1.setPreco(-50);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao definir preço: " + e.getMessage());
        }

        try {
            p1.setQuantidadeEmEstoque(-3);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao definir quantidade: " + e.getMessage());
        }

        try {
            p1.setNome("");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao definir nome: " + e.getMessage());
        }

        try {
            Produto p2 = new Produto(null, 100, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar produto: " + e.getMessage());
        }
    }
}
