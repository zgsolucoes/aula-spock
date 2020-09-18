package br.com.zgsolucoes;

import java.util.List;

public interface LoteService {
    Lote novoLote(Lote lote);
    List<Lote> lotesForaDoPrazoDeValidade();

}
