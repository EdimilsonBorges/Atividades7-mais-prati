package com.poo.desafio.carrinho;

import com.poo.desafio.produto.Produto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Carrinho {
    private final List<ItemCarrinho> itens;
    private final Dinheiro total;

    public Carrinho(List<ItemCarrinho> itens) {
        this.itens = Collections.unmodifiableList(new ArrayList<>(itens));
        this.total = calcularTotal();
    }

    public Carrinho adicionarItem(Produto produto, int quantidade) {
        List<ItemCarrinho> novosItens = new ArrayList<>(itens);
        novosItens.add(new ItemCarrinho(produto, quantidade));
        return new Carrinho(novosItens);
    }

    public Carrinho removerItem(String nomeProduto) {
        List<ItemCarrinho> novosItens = new ArrayList<>(itens);
        novosItens.removeIf(item -> item.getProduto().getNome().equalsIgnoreCase(nomeProduto));
        return new Carrinho(novosItens);
    }

    public Carrinho aplicarCupom(BigDecimal percentual) {
        if (percentual.compareTo(new BigDecimal("0.30")) > 0) {
            throw new IllegalArgumentException("Desconto não pode ultrapassar 30%.");
        }
        List<ItemCarrinho> novosItens = new ArrayList<>(itens);
        Dinheiro novoTotal = total.aplicarDesconto(percentual);
        return new Carrinho(novosItens) {
            @Override
            public Dinheiro getTotal() {
                return novoTotal;
            }
        };
    }

    private Dinheiro calcularTotal() {
        if (itens.isEmpty()) {
            return new Dinheiro(BigDecimal.ZERO, Moeda.BRL);
        }
        Dinheiro acumulado = new Dinheiro(BigDecimal.ZERO, itens.get(0).getProduto().getPreco().getMoeda());
        for (ItemCarrinho item : itens) {
            acumulado = acumulado.adicionar(item.getTotal());
        }
        return acumulado;
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public Dinheiro getTotal() {
        return total;
    }
}
