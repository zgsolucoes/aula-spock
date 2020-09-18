package br.com.zgsolucoes;

import java.util.List;

public class LoteDaoImp implements LoteDao {

    @Override
    public void save(Lote lote) {
        //Chamada e operações de banco de dados
        throw new RuntimeException("O banco de dados não esta disponivel");
    }

    @Override
    public List<Lote> list() {
        //Chamada e operações de banco de dados
        throw new RuntimeException("O banco de dados não esta disponivel");
    }
}
