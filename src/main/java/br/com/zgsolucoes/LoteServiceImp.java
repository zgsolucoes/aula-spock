package br.com.zgsolucoes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class LoteServiceImp implements LoteService {

    private final LoteDao loteDao;

    public LoteServiceImp(LoteDao loteDao) {
        this.loteDao = loteDao;
    }

    @Override
    public Lote novoLote(Lote lote) {
        if (ChronoUnit.DAYS.between(LocalDate.now(), lote.getDataValidade()) < 30) {
            throw new IllegalArgumentException("Para inserir um novo lote a data de validade deve ser maior do que trinta dias!");
        }
        loteDao.save(lote);
        enviaParaSistemExterno(lote);
        return lote;
    }

    @Override
    public List<Lote> lotesForaDoPrazoDeValidade() {
        List<Lote> lotes = loteDao.list();
        return lotes.stream()
                .filter(lote -> ChronoUnit.DAYS.between(LocalDate.now(), lote.getDataValidade()) < 0)
                .collect(Collectors.toList());
    }

    void enviaParaSistemExterno(Lote lote) {
        //Chamada de rede
        throw new RuntimeException("Não foi possivel se conectar ao sistema externo");
    }
}
