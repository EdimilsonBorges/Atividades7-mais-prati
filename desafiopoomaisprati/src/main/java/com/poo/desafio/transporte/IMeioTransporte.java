package com.poo.desafio.transporte;

import com.poo.desafio.exceptions.VelocidadeInvalidaException;

public interface IMeioTransporte {
    void acelerar() throws VelocidadeInvalidaException;
    void frear() throws VelocidadeInvalidaException;

    int getVelocidade();
    String getNome();
}
