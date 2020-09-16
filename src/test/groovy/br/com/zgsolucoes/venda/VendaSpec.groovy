package br.com.zgsolucoes.venda

import spock.lang.Specification

class VendaSpec extends Specification {

	private final Produto produtoA = new Produto("A", 7.5)
	private final Produto produtoB = new Produto("B", 25.00)

	private Venda venda

	void setup() {
		venda = new Venda(1, 'Henrique')
	}

	void "Adicionando itens"() {
		when: 'Ao informar cinco unidade do Produto A com o valor de R$ 7,50.'
		venda.adicioneItem(produtoA, 5.0)

		then: 'O valor total do item do item deve ser R$ 37,50'
		venda.valorTotal == 37.50

		when: 'A informar novamente o Produto A com apenas uma unidade no valor de R$ 7,5.'
		ItemVenda itemVenda = venda.adicioneItem(produtoA, 1.0)

		then: 'A quantidade e valor deve ser adicionada no item já informado, totalizando o valor da venda de R$ 45,00'
		venda.valorTotal == 45.00
		itemVenda.quantidade == 6

		when: 'Ao adicionar uma unidade do Produto B com o valor de R$ 25,00.'
		venda.adicioneItem(produtoB, 1.0)

		then: 'O valor da venda passará a ser de R$ 70,00'
		venda.valorTotal == 70.00
	}

	void "Removendo item" () {
		setup: 'Dada uma venda onde temos um dois itens, cinco unidades do produto A no valor unitário de R$ 7,50 e duas unidades do produto B no valor unitário de R$ 25,00.'
		venda.adicioneItem(produtoA, 5.0)
		venda.adicioneItem(produtoB, 2.0)

		expect: 'Com o valor total da venda de R$ 87,50'
		venda.valorTotal == 87.50

		when: 'Ao remover uma unidade do produto B.'
		venda.removaItem(produtoB, 1.0)

		then: 'O valor da venda passará a ser R$ 62,50 a venda permanecerá com dois itens.'
		venda.valorTotal == 62.50
		venda.itens.size() == 2

		when: 'Ao remover mais uma unidade do produto B.'
		venda.removaItem(produtoB, 1.0)

		then: 'o item deve ser removido da venda, com a venda passando a ter apenas o Item A no valor de R$ 37,50.'
		venda.valorTotal == 37.50
		venda.itens.size() == 1
		venda.itens[0].produto == produtoA
	}
}
