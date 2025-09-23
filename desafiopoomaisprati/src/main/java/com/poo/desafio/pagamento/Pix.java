package com.poo.desafio.pagamento;

import com.poo.desafio.exceptions.PagamentoInvalidoException;

import java.math.BigDecimal;

public class Pix extends FormaPagamento {
    private String chavePix;

    public Pix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        if (chavePix == null || chavePix.isBlank()) {
            throw new PagamentoInvalidoException("Chave Pix inválida!");
        }
        // Pode ser e-mail, CPF, CNPJ ou telefone. Aqui simplificamos.
        if (!(chavePix.matches("\\d{11}") || chavePix.contains("@") || chavePix.matches("\\d{14}"))) {
            throw new PagamentoInvalidoException("Formato de chave Pix inválido!");
        }
    }

    @Override
    public void processarPagamento(BigDecimal valor) throws PagamentoInvalidoException {
        validarPagamento();
        System.out.println("Pagamento de R$" + valor + " enviado via Pix para chave: " + chavePix);
    }
}
