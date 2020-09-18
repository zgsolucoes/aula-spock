package br.com.zgsolucoes;

import spock.lang.Specification

import java.time.LocalDate


class LoteServiceSpec extends Specification {

	LoteDao loteDao;
	LoteService loteService;

	void setup() {
		loteDao = new LoteDaoImp()
		loteService = new LoteServiceImp(loteDao)
	}

	void "Teste lista todos o lotes vencidos"() {
		setup:
		Lote loteForaDoPrazo = new Lote()
		loteForaDoPrazo.lote = '123'
		loteForaDoPrazo.dataValidade = LocalDate.now().minusDays(1)

		Lote loteVenceHoje = new Lote()
		loteVenceHoje.lote = '456'
		loteVenceHoje.dataValidade = LocalDate.now()

		Lote loteVenceEmTrintaDias = new Lote()
		loteVenceEmTrintaDias.lote = '456'
		loteVenceEmTrintaDias.dataValidade = LocalDate.now().plusDays(30)

		loteDao.save(loteForaDoPrazo)
		loteDao.save(loteVenceHoje)
		loteDao.save(loteVenceEmTrintaDias)

		when:
		List<Lote> lotesForaDoPrazoDeValidade = loteService.lotesForaDoPrazoDeValidade()

		then:
		lotesForaDoPrazoDeValidade == [loteForaDoPrazo]
	}

	void "teste insere novo lote dentro do prazo permitido"() {
		setup:
		Lote loteVenceEmTrintaDias = new Lote()
		loteVenceEmTrintaDias.lote = '456'
		loteVenceEmTrintaDias.dataValidade = LocalDate.now().plusDays(30)

		when:
		Lote lote = loteService.novoLote(loteVenceEmTrintaDias)

		then:
		lote.id != null
	}

	void "teste insere novo lote fora do prazo permitido"() {
		setup:
		Lote loteVenceEmTrintaDias = new Lote()
		loteVenceEmTrintaDias.lote = '456'
		loteVenceEmTrintaDias.dataValidade = LocalDate.now().plusDays(20)

		when:
		Lote lote = loteService.novoLote(loteVenceEmTrintaDias)

		then:
		RuntimeException exception = thrown(RuntimeException)
		exception.message == 'Para inserir um novo lote a data de validade deve ser maior do que trinta dias!'
	}
}
