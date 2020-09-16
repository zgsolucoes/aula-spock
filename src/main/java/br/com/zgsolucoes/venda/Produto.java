package br.com.zgsolucoes.venda;

import java.math.BigDecimal;

public class Produto {
    private final String nome;
    private final BigDecimal valorUnitario;

    public Produto(String nome, BigDecimal valorUnitario) {
        this.nome = nome;
        this.valorUnitario = valorUnitario;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }
}
