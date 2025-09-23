package com.poo.desafio.pagamento;

import com.poo.desafio.exceptions.PagamentoInvalidoException;

import java.math.BigDecimal;

public abstract class FormaPagamento {
    public abstract void validarPagamento() throws PagamentoInvalidoException;
    public abstract void processarPagamento(BigDecimal valor) throws PagamentoInvalidoException;
}
