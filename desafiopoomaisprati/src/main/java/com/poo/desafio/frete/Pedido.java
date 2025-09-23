package com.poo.desafio.frete;

import java.math.BigDecimal;

public class Pedido {
    private final String id;
    private final String cep;
    private final BigDecimal valorTotal;
    private CalculadoraFrete estrategiaFrete;

    public Pedido(String id, String cep, BigDecimal valorTotal, CalculadoraFrete estrategiaFrete) {
        if (valorTotal == null || valorTotal.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor total inválido.");
        }
        this.id = id;
        this.cep = cep;
        this.valorTotal = valorTotal;
        this.estrategiaFrete = estrategiaFrete;
    }

    public String getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setEstrategiaFrete(CalculadoraFrete estrategiaFrete) {
        this.estrategiaFrete = estrategiaFrete;
    }

    public BigDecimal calcularFrete() {
        return estrategiaFrete.calcular(this);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id='" + id + '\'' +
                ", cep='" + cep + '\'' +
                ", valorTotal=" + valorTotal +
                ", frete=" + calcularFrete() +
                '}';
    }
}
