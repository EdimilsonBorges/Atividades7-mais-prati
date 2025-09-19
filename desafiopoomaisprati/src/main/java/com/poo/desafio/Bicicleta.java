package com.poo.desafio;

import com.poo.desafio.exceptions.VelocidadeInvalidaException;

public class Bicicleta implements IMeioTransporte{
    private int velocidade = 0;
    private final int MAX_VELOCIDADE = 40;

    @Override
    public void acelerar() throws VelocidadeInvalidaException {
        if (velocidade + 5 > MAX_VELOCIDADE) {
            throw new VelocidadeInvalidaException("Bicicleta não pode ultrapassar " + MAX_VELOCIDADE + " km/h.");
        }
        velocidade += 5;
    }

    @Override
    public void frear() throws VelocidadeInvalidaException {
        if (velocidade - 5 < 0) {
            throw new VelocidadeInvalidaException("Bicicleta já está parada.");
        }
        velocidade -= 5;
    }

    @Override
    public int getVelocidade() {
        return velocidade;
    }

    @Override
    public String getNome() {
        return "Bicicleta";
    }
}
