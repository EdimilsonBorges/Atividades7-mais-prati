package com.poo.desafio;

import java.math.BigDecimal;

public class Gerente extends Funcionario {

    public Gerente(String nome, BigDecimal salario) {
        super(null, nome, salario);
    }

    @Override
    public BigDecimal calcularBonus() {
        return salario.multiply(new BigDecimal("0.20")); // 20%
    }

    @Override
    public String getId() {
        return "";
    }

    public Gerente(String id, String nome, BigDecimal salario) {
        super(id, nome, salario);
    }


}

