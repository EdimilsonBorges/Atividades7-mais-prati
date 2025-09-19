package com.poo.desafio;

import com.poo.desafio.exceptions.PagamentoInvalidoException;

import java.math.BigDecimal;

abstract class FormaPagamento {
    public abstract void validarPagamento() throws PagamentoInvalidoException;
    public abstract void processarPagamento(BigDecimal valor) throws PagamentoInvalidoException;
}
