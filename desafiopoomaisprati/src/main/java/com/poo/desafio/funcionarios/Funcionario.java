package com.poo.desafio.funcionarios;

import com.poo.desafio.repositorio.Identificavel;

import java.math.BigDecimal;

public abstract class Funcionario implements Identificavel<String> {
    private final String id;
    private final String nome;
    protected BigDecimal salario;

    public Funcionario(String id, String nome, BigDecimal salario) {
        this.id = id;
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");
        }
        if (salario == null || salario.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O salário deve ser positivo.");
        }
        this.nome = nome;
        this.salario = salario;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public abstract BigDecimal calcularBonus();

    @Override
    public String toString() {
        return "Funcionario{id='" + id + "', nome='" + nome + "'}";
    }
}
