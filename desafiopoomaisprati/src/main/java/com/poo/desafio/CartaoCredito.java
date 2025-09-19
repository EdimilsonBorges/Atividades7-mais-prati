package com.poo.desafio;

import com.poo.desafio.exceptions.PagamentoInvalidoException;

import java.math.BigDecimal;

class CartaoCredito extends FormaPagamento {
    private String numeroCartao;

    public CartaoCredito(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        if (numeroCartao == null || !numeroCartao.matches("\\d{16}")) {
            throw new PagamentoInvalidoException("Número de cartão inválido! Deve conter 16 dígitos.");
        }
    }

    @Override
    public void processarPagamento(BigDecimal valor) throws PagamentoInvalidoException {
        validarPagamento();
        System.out.println("Pagamento de R$" + valor + " processado com Cartão de Crédito " + numeroCartao);
    }
}
