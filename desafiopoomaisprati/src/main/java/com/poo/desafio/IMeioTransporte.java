package com.poo.desafio;

import com.poo.desafio.exceptions.VelocidadeInvalidaException;

public interface IMeioTransporte {
    void acelerar() throws VelocidadeInvalidaException;
    void frear() throws VelocidadeInvalidaException;

    int getVelocidade();
    String getNome();
}
