package br.com.zgsoluções.venda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Venda {

    private final long numero;
    private final String cliente;
    private List<ItemVenda> itens = new ArrayList<>();

    public Venda(long numero, String cliente) {
        this.numero = numero;
        this.cliente = cliente;
    }

    public List<ItemVenda> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public long getNumero() {
        return numero;
    }

    public String getCliente() {
        return cliente;
    }

}
