package com.poo.desafio.frete;

import java.math.BigDecimal;

public class Pac implements CalculadoraFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        validarCep(pedido.getCep());
        return BigDecimal.valueOf(15.00);
    }

    private void validarCep(String cep) {
        if (cep == null || !cep.matches("\\d{8}")) {
            throw new com.poo.desafio.exceptions.CepInvalidoException("CEP inválido: " + cep);
        }
    }
}
