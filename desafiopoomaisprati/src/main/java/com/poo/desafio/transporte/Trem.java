package com.poo.desafio.transporte;

import com.poo.desafio.exceptions.VelocidadeInvalidaException;

public class Trem implements IMeioTransporte {
    private int velocidade = 0;
    private final int MAX_VELOCIDADE = 300;

    @Override
    public void acelerar() throws VelocidadeInvalidaException {
        if (velocidade + 50 > MAX_VELOCIDADE) {
            throw new VelocidadeInvalidaException("Trem não pode ultrapassar " + MAX_VELOCIDADE + " km/h.");
        }
        velocidade += 50;
    }

    @Override
    public void frear() throws VelocidadeInvalidaException {
        if (velocidade - 50 < 0) {
            throw new VelocidadeInvalidaException("Trem já está parado.");
        }
        velocidade -= 50;
    }

    @Override
    public int getVelocidade() {
        return velocidade;
    }

    @Override
    public String getNome() {
        return "Trem";
    }
}
