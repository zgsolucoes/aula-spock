package br.com.zgsoluções.venda;

import java.math.BigDecimal;

public class ItemVenda {
    private final int numero;
    private final Produto produto;
    private final BigDecimal quantidade;

    public ItemVenda(int numero, Produto produto, BigDecimal quantidade) {
        this.numero = numero;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public int getNumero() {
        return numero;
    }

    public Produto getProduto() {
        return produto;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }
}
