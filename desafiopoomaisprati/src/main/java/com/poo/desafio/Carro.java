package com.poo.desafio;

import com.poo.desafio.exceptions.VelocidadeInvalidaException;

public class Carro implements IMeioTransporte{
    private int velocidade = 0;
    private final int MAX_VELOCIDADE = 200;

    @Override
    public void acelerar() throws VelocidadeInvalidaException {
        if (velocidade + 20 > MAX_VELOCIDADE) {
            throw new VelocidadeInvalidaException("Carro não pode ultrapassar " + MAX_VELOCIDADE + " km/h.");
        }
        velocidade += 20;
    }

    @Override
    public void frear() throws VelocidadeInvalidaException {
        if (velocidade - 20 < 0) {
            throw new VelocidadeInvalidaException("Carro já está parado.");
        }
        velocidade -= 20;
    }

    @Override
    public int getVelocidade() {
        return velocidade;
    }

    @Override
    public String getNome() {
        return "Carro";
    }
}
