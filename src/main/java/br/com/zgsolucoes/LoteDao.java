package br.com.zgsolucoes;

import java.util.List;

public interface LoteDao {
    void save(Lote lote);
    List<Lote> list();
}
