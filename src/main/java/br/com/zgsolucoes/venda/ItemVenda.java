package br.com.zgsolucoes.venda;

import java.math.BigDecimal;

public class ItemVenda {
    private final int numero;
    private final Produto produto;
    private final BigDecimal quantidade;
    private final BigDecimal valorTotal;

    public ItemVenda(int numero, Produto produto, BigDecimal quantidade) {
        this.numero = numero;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = produto.getValorUnitario().multiply(quantidade);
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

    public BigDecimal getValorTotal() {
        return this.valorTotal;
    }
}
