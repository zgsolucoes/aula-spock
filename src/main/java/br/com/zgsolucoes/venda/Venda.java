package br.com.zgsolucoes.venda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Venda {

    private final long numero;
    private final String cliente;
    private List<ItemVenda> itens = new ArrayList<>();
    private BigDecimal valorTotal = BigDecimal.ZERO;

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

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public ItemVenda adicioneItem(Produto produto, BigDecimal quantidade) {
        Optional<ItemVenda> optionalItemVenda = busqueItem(produto);

        optionalItemVenda.ifPresent(itemVenda -> itens.remove(itemVenda));

        ItemVenda itemVenda = mapItem(quantidade, optionalItemVenda).orElseGet(() -> new ItemVenda(itens.size() + 1, produto, quantidade));

        itens.add(itemVenda);

        calculeTotal();

        return itemVenda;
    }

    public void removaItem(Produto produto, BigDecimal quantidade) {
        Optional<ItemVenda> optionalItemVenda = busqueItem(produto);

        optionalItemVenda.ifPresent(itemVenda -> itens.remove(itemVenda));

        mapItem(quantidade.negate(), optionalItemVenda).ifPresent(itemVenda -> {
            if (itemVenda.getQuantidade().compareTo(BigDecimal.ZERO) > 0) {
                itens.add(itemVenda);
            }
        });

        calculeTotal();
    }

    private Optional<ItemVenda> busqueItem(Produto produto) {
        Optional<ItemVenda> optionalItemVenda = itens.stream()
                .filter(item -> item.getProduto().equals(produto))
                .findFirst();
        return optionalItemVenda;
    }

    private Optional<ItemVenda> mapItem(BigDecimal quantidade, Optional<ItemVenda> optionalItemVenda) {
        return optionalItemVenda.map(item -> {
            return new ItemVenda(
                    item.getNumero(),
                    item.getProduto(),
                    item.getQuantidade().add(quantidade)
            );
        });
    }

    private void calculeTotal() {
        valorTotal = itens.stream()
                .map(ItemVenda::getValorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
