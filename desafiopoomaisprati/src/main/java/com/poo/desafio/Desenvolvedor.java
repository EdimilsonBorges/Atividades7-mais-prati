package com.poo.desafio;

import java.math.BigDecimal;

public class Desenvolvedor extends Funcionario {

    public Desenvolvedor(String nome, BigDecimal salario) {
        super(null, nome, salario);
    }

    public Desenvolvedor(String id, String nome, BigDecimal salario) {
        super(id, nome, salario);
    }

    @Override
    public BigDecimal calcularBonus() {
        return salario.multiply(new BigDecimal("0.10")); // 10%
    }

    @Override
    public String getId() {
        return "";
    }
}

