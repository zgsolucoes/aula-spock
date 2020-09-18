package br.com.zgsolucoes;

import java.time.LocalDate;

public class Lote {
    private Long id;
    private String lote;
    private LocalDate dataValidade;

    public void setId(Long id) {
        this.id = id;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Long getId() {
        return id;
    }

    public String getLote() {
        return lote;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }
}
