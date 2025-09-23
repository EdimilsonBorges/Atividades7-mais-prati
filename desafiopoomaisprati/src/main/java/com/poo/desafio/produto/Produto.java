package com.poo.desafio.produto;

import com.poo.desafio.carrinho.Dinheiro;
import com.poo.desafio.exceptions.DescontoInvalidoException;
import com.poo.desafio.repositorio.Identificavel;

public class Produto implements Identificavel<Integer> {
    private String nome;
    private int quantidadeEmEstoque;
    private Dinheiro preco;
    private Integer id;

    public Produto(Integer id, String nome, Dinheiro preco, int quantidadeEmEstoque) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do produto inválido.");
        }
        setId(id);
        setNome(nome);
        setPreco(preco);
        setQuantidadeEmEstoque(quantidadeEmEstoque);
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setId(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Id inválido.");
        }
        this.id = id;
    }

    public Dinheiro getPreco() {
        return preco;
    }

    public void setPreco(Dinheiro preco) {
        if (preco == null) {
            throw new IllegalArgumentException("O preço não pode ser nulo.");
        }
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        if (quantidadeEmEstoque < 0) {
            throw new IllegalArgumentException("A quantidade em estoque não pode ser negativa.");
        }
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public void aplicarDesconto(double porcentagem){
        if(porcentagem <= 0 || porcentagem > 50){
            throw new DescontoInvalidoException("O desconto deve ser maior que 0% e no máximo 50%.");
        }

        // Converter porcentagem para BigDecimal
        var percentual = java.math.BigDecimal.valueOf(porcentagem).divide(java.math.BigDecimal.valueOf(100));

        // Criar novo preço com desconto
        this.preco = this.preco.aplicarDesconto(percentual);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidadeEmEstoque=" + quantidadeEmEstoque +
                '}';
    }
}
