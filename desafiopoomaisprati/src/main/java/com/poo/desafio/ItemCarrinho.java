package com.poo.desafio;

class ItemCarrinho {
    private final Produto2 produto;
    private final int quantidade;

    public ItemCarrinho(Produto2 produto, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que 0.");
        }
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto2 getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Dinheiro getTotal() {
        return produto.getPreco().multiplicar(quantidade);
    }
}
