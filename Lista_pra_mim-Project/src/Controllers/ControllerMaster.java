package Controllers;

import entidades.Item;

/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class ControllerMaster {

	private ControllerItem controllerItem;
	private ControllerLista controllerLista;

	/**
	 * Constroi o objeto Facade, e inicializa o objeto Controller.
	 */
	public ControllerMaster() {
		this.controllerItem = new ControllerItem();
		this.controllerLista = new ControllerLista(controllerItem);
	}

	/**
	 * Metodo que cria e adiciona um novo ItemPorQuantidade a uma lista que contem
	 * todos os itens.
	 *
	 * @param nome            Uma String que representa o nome do produto.
	 * @param categoria       Uma String que representa a categoria do item.
	 * @param qnt             Um inteiro que representa a quantidade de produtos que
	 *                        se encontram na embalagem do item.
	 * @param unidadeDeMedida Uma String que representa a unidade de medida do
	 *                        produto (gramas, litros, etc.).
	 * @param localDeCompra   Uma String que representa onde o item foi comprado.
	 * @param preco           Um double que representa o valor do produto.
	 * @return Um inteiro que representa o identificador do produto.
	 */
	public int adicionaItemPorQtd(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra,
			double preco) {
		return this.controllerItem.adicionaItemPorQtd(nome, categoria, qnt, unidadeDeMedida, localDeCompra, preco);
	}

	/**
	 * Metodo que cria e adiciona um novo ItemPorQuilo a uma lista que contem todos
	 * os itens.
	 *
	 * @param nome          Uma String que representa o nome do produto.
	 * @param categoria     Uma String que representa a categoria do item.
	 * @param kg            Um double que representa o peso do item.
	 * @param localDeCompra Uma String que representa onde o item foi comprado.
	 * @param preco         Um double que representa o valor do produto.
	 * @return Um inteiro que representa o identificador do produto.
	 */
	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		return this.controllerItem.adicionaItemPorQuilo(nome, categoria, kg, localDeCompra, preco);
	}

	/**
	 * Metodo que cria e adiciona um novo ItemPorUnidade a uma lista que contem
	 * todos os itens.
	 *
	 * @param nome          Uma String que representa o nome do produto.
	 * @param categoria     Uma String que representa a categoria do item.
	 * @param qnt           Um inteiro que representa a quantidade de produtos que
	 *                      se encontram na embalagem do item.
	 * @param localDeCompra Uma String que representa onde o item foi comprado.
	 * @param preco         Um double que representa o valor do produto.
	 * @return Um inteiro que representa o identificador do produto.
	 */
	public int adicionaItemPorUnidade(String nome, String categoria, int qnt, String localDeCompra, double preco) {
		return this.controllerItem.adicionaItemPorUnidade(nome, categoria, qnt, localDeCompra, preco);
	}

	/**
	 * Metodo que retorna uma String contendo a exibicao de um item.
	 *
	 * @param id Um inteiro que representa o identificador de um item.
	 * @return Uma String que contem a exibicao de um item.
	 */
	public String exibeItem(int id) {
		return this.controllerItem.exibeItem(id);
	}

	/**
	 * Metodo que atualiza o atributo de um item passando um novo valor para o
	 * atributo.
	 *
	 * @param id        Um inteiro que representa o identificador unico de um item.
	 * @param atributo  Uma String que representa o atributo a ser modificado.
	 * @param novoValor Uma String que representa o novo valor para o item.
	 *
	 *                  Este metodo nao retorna nenhum valor.
	 */
	public void atualizaItem(int id, String atributo, String novoValor) {
		this.controllerItem.atualizaItem(id, atributo, novoValor);
	}

	/**
	 * Metodo que adiciona um preco a um item.
	 *
	 * @param id            Um inteiro que representa o identificador de um item.
	 * @param localDeCompra Uma String que representa o local de compra do item.
	 * @param preco         Um double que representa o valor do preco que será
	 *                      adicionado.
	 *
	 *                      Este método não retorna nenhum valor.
	 */
	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		this.controllerItem.adicionaPrecoItem(id, localDeCompra, preco);
	}

	/**
	 * Metodo que remove um item a partir de seu id.
	 *
	 * @param id Um inteiro que representa o identificador de um item.
	 *
	 *           Este metodo nao retorna nenhum valor.
	 */
	public void deletaItem(int id) {
		this.controllerItem.deletaItem(id);
	}

	/**
	 * Metodo que ordena os itens por ordem alfabetica.
	 *
	 * @param posicao A posicao em que o item esta posicionado ordenadamente.
	 * @return Uma String que contem a exibicao de um item.
	 */
	public String getItem(int posicao) {
		return this.controllerItem.getItem(posicao);
	}

	/**
	 * Metodo que lista em ordem alfabetica os itens de uma dada categoria.
	 * 
	 * @param posicao   A posicao em que o item esta posicionado ordenadamente.
	 * @param categoria catergoria que sera realizada a pesquisa.
	 * @return Uma String que contem a exibicao de um item.
	 */
	public String getItemPorCategoria(String categoria, int posicao) {
		return this.controllerItem.getItemPorCategoria(categoria, posicao);
	}

	/**
	 * Metodo que ordena os itens por preco.
	 *
	 * @param posicao A posicao em que o item esta posicionado ordenadamente.
	 * @return Uma String que contem a exibicao de um item.
	 */
	public String getItemPorMenorPreco(int posicao) {
		return this.controllerItem.getItemPorMenorPreco(posicao);
	}

	/**
	 * Metodo que ordena os itens relacionados a uma dada string de pesquisa e a
	 * listagem deve ocorrer em ordem alfabética considerando a representação em
	 * string do item.
	 * 
	 * @param posicao       A posicao em que o item esta posicionado ordenadamente.
	 * @param strPesquisada parametro de pesquisa.
	 * @return Uma String que contem a exibicao de um item.
	 */
	public String getItemPorPesquisa(String strPesquisada, int posicao) {
		return this.controllerItem.getItemPorPesquisa(strPesquisada, posicao);
	}

	// Caso 3
	public String adicionaListaDeCompras(String descritorLista) {
		return this.controllerLista.adicionaListaDeCompras(descritorLista);
	}

	public void adicionaCompraALista(String descritorLista, int quantidade, int itemId) {
		Item item;
		try {
			item = this.pegaItem(itemId);
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro na compra de item: " + e.getMessage());
		}
		this.controllerLista.adicionaCompraALista(descritorLista, quantidade, item);
	}

	public void finalizarListaDeCompras(String descritorLista, String localDaCompra, int valorFinalDaCompra) {
		this.controllerLista.finalizarListaDeCompras(descritorLista, localDaCompra, valorFinalDaCompra);
	}

	public String pesquisaCompraEmLista(String descritorLista, int itemId) {
		Item item;
		try {
			item = this.pegaItem(itemId);
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro na pesquisa de compra: " + e.getMessage());
		}
		return this.controllerLista.pesquisaCompraEmLista(descritorLista, item);
	}

	public void atualizaCompraDeLista(String descritorLista, int itemId, int quantidade, String operacao) {
		if (!(operacao.equals("adiciona")) && !(operacao.equals("diminui"))) {
			throw new IllegalArgumentException("Erro na atualizacao de compra: operacao invalida para atualizacao.");
		}
		this.controllerLista.atualizaCompraDeLista(descritorLista, this.pegaItem(itemId), quantidade, operacao);
	}

	public String getItemLista(String descritorLista, int posicaoItem) {
		return this.controllerLista.getItemLista(descritorLista, posicaoItem);
	}

	public void deletaCompraDeLista(String descritorLista, int itemId) {
		Item item;
		try {
			item = this.pegaItem(itemId);
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro na exclusao de compra: " + e.getMessage());
		}
		this.controllerLista.deletaCompraDeLista(descritorLista, item);
	}

	public String pesquisaListaDeCompras(String descritorLista) {
		return this.controllerLista.pesquisaListaDeCompras(descritorLista);
	}
	// Caso 4

	public String getItemListaPorData(String data, int posicaoLista) {
		return this.controllerLista.getItemListaPorData(data, posicaoLista);
	}

	public String getItemListaPorItem(int id, int posicaoLista) {
		return this.controllerLista.getItemListaPorItem(id, posicaoLista);
	}

	// Metodo Extra
	public Item pegaItem(int id) {
		return this.controllerItem.pegaItem(id);
	}

}
