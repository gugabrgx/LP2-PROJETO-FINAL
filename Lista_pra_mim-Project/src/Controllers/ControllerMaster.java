package Controllers;

import entidades.Item;

/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Rafael Dantas Santos de Azevedo - 117210382
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class ControllerMaster {

	// Este atributo representa um controller de Item.
	private ControllerItem controllerItem;
	// Este atributo representa um controller de lista.
	private ControllerLista controllerLista;

	/**
	 * Constroi o objeto Facade, e inicializa o objeto Controller.
	 */
	public ControllerMaster() {
		this.controllerItem = new ControllerItem();
		this.controllerLista = new ControllerLista();
	}

	/**
	 * Metodo que cria e adiciona um novo ItemPorQuantidade a uma lista que contem
	 * todos os itens.
	 *
	 * @param nome
	 *            Uma String que representa o nome do produto.
	 * @param categoria
	 *            Uma String que representa a categoria do item.
	 * @param qnt
	 *            Um inteiro que representa a quantidade de produtos que se
	 *            encontram na embalagem do item.
	 * @param unidadeDeMedida
	 *            Uma String que representa a unidade de medida do produto (gramas,
	 *            litros, etc.).
	 * @param localDeCompra
	 *            Uma String que representa onde o item foi comprado.
	 * @param preco
	 *            Um double que representa o valor do produto.
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
	 * @param nome
	 *            Uma String que representa o nome do produto.
	 * @param categoria
	 *            Uma String que representa a categoria do item.
	 * @param kg
	 *            Um double que representa o peso do item.
	 * @param localDeCompra
	 *            Uma String que representa onde o item foi comprado.
	 * @param preco
	 *            Um double que representa o valor do produto.
	 * @return Um inteiro que representa o identificador do produto.
	 */
	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		return this.controllerItem.adicionaItemPorQuilo(nome, categoria, kg, localDeCompra, preco);
	}

	/**
	 * Metodo que cria e adiciona um novo ItemPorUnidade a uma lista que contem
	 * todos os itens.
	 *
	 * @param nome
	 *            Uma String que representa o nome do produto.
	 * @param categoria
	 *            Uma String que representa a categoria do item.
	 * @param qnt
	 *            Um inteiro que representa a quantidade de produtos que se
	 *            encontram na embalagem do item.
	 * @param localDeCompra
	 *            Uma String que representa onde o item foi comprado.
	 * @param preco
	 *            Um double que representa o valor do produto.
	 * @return Um inteiro que representa o identificador do produto.
	 */
	public int adicionaItemPorUnidade(String nome, String categoria, int qnt, String localDeCompra, double preco) {
		return this.controllerItem.adicionaItemPorUnidade(nome, categoria, qnt, localDeCompra, preco);
	}

	/**
	 * Metodo que retorna uma String contendo a exibicao de um item.
	 *
	 * @param id
	 *            Um inteiro que representa o identificador de um item.
	 * @return Uma String que contem a exibicao de um item.
	 */
	public String exibeItem(int id) {
		return this.controllerItem.exibeItem(id);
	}

	/**
	 * Metodo que atualiza o atributo de um item passando um novo valor para o
	 * atributo.
	 *
	 * @param id
	 *            Um inteiro que representa o identificador unico de um item.
	 * @param atributo
	 *            Uma String que representa o atributo a ser modificado.
	 * @param novoValor
	 *            Uma String que representa o novo valor para o item.
	 *
	 *            Este metodo nao retorna nenhum valor.
	 */
	public void atualizaItem(int id, String atributo, String novoValor) {
		this.controllerItem.atualizaItem(id, atributo, novoValor);
	}

	/**
	 * Metodo que adiciona um preco a um item.
	 *
	 * @param id
	 *            Um inteiro que representa o identificador de um item.
	 * @param localDeCompra
	 *            Uma String que representa o local de compra do item.
	 * @param preco
	 *            Um double que representa o valor do preco que será adicionado.
	 *
	 *            Este método não retorna nenhum valor.
	 */
	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		this.controllerItem.adicionaPrecoItem(id, localDeCompra, preco);
	}

	/**
	 * Metodo que remove um item a partir de seu id.
	 *
	 * @param id
	 *            Um inteiro que representa o identificador de um item.
	 *
	 *            Este metodo nao retorna nenhum valor.
	 */
	public void deletaItem(int id) {
		this.controllerItem.deletaItem(id);
	}

	/**
	 * Metodo que ordena os itens por ordem alfabetica.
	 *
	 * @param posicao
	 *            A posicao em que o item esta posicionado ordenadamente.
	 * @return Uma String que contem a exibicao de um item.
	 */
	public String getItem(int posicao) {
		return this.controllerItem.getItem(posicao);
	}

	/**
	 * Metodo que lista em ordem alfabetica os itens de uma dada categoria.
	 * 
	 * @param posicao
	 *            A posicao em que o item esta posicionado ordenadamente.
	 * @param categoria
	 *            catergoria que sera realizada a pesquisa.
	 * @return Uma String que contem a exibicao de um item.
	 */
	public String getItemPorCategoria(String categoria, int posicao) {
		return this.controllerItem.getItemPorCategoria(categoria, posicao);
	}

	/**
	 * Metodo que ordena os itens por preco.
	 *
	 * @param posicao
	 *            A posicao em que o item esta posicionado ordenadamente.
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
	 * @param posicao
	 *            A posicao em que o item esta posicionado ordenadamente.
	 * @param strPesquisada
	 *            parametro de pesquisa.
	 * @return Uma String que contem a exibicao de um item.
	 */
	public String getItemPorPesquisa(String strPesquisada, int posicao) {
		return this.controllerItem.getItemPorPesquisa(strPesquisada, posicao);
	}

	/**
	 * Cria uma nova lista de compras.
	 * 
	 * @param descritorLista
	 *            O descritor da lista.
	 * @return em String o descritor da lista.
	 */
	public String adicionaListaDeCompras(String descritorLista) {
		return this.controllerLista.adicionaListaDeCompras(descritorLista);
	}

	/**
	 * Este metodo adiciona um item com sua quantidade, em uma determinada lista.
	 * 
	 * @param descritorLista
	 *            O descritor da lista.
	 * @param quantidade
	 *            A quantidade do item.
	 * @param itemID
	 *            O item a ser adicionado na lista.
	 */
	public void adicionaCompraALista(String descritorLista, int quantidade, int itemId) {
		this.controllerLista.adicionaCompraALista(descritorLista, quantidade, this.pegaItem(itemId));
	}

	/**
	 * Este metodo finaliza uma lista de compras.
	 * 
	 * @param descritorLista
	 *            O descritor da lista.
	 * @param localDaCompra
	 *            O local de compra da lista.
	 * @param valorFinalDaCompra
	 *            O valor final da compra.
	 */
	public void finalizarListaDeCompras(String descritorLista, String localDaCompra, int valorFinalDaCompra) {
		this.controllerLista.finalizarListaDeCompras(descritorLista, localDaCompra, valorFinalDaCompra);
	}

	/**
	 * Este metodo pesquisa uma item em uma lista.
	 * 
	 * @param descritorLista
	 *            O descritor da lista.
	 * @param itemId
	 *            o ID do item.
	 * @return em String o item pesquisado na lista.
	 */
	public String pesquisaCompraEmLista(String descritorLista, int itemId) {
		return this.controllerLista.pesquisaCompraEmLista(descritorLista, itemId);
	}

	/**
	 * Este metodo atualiza a quantidade de um item, emm uma determinada lista.
	 * 
	 * @param descritorLista
	 *            O descritor da lista.
	 * @param itemId
	 *            O ID do item.
	 * @param quantidade
	 *            A quantidade nova do item.
	 */
	public void atualizaCompraDeLista(String descritorLista, int itemId, int quantidade) {
		this.controllerLista.atualizaCompraDeLista(descritorLista, itemId, quantidade);
	}

	/**
	 * Este metodo recupra um item de uma lsita, a partir de sua posicao.
	 * 
	 * @param descritorLista
	 *            O descritor da lista.
	 * @param posicaoItem
	 *            A posicao do Item.
	 * @return em String a representacao de um item.
	 */
	public String getItemLista(String descritorLista, int posicaoItem) {
		return this.controllerLista.getItemLista(descritorLista, posicaoItem);
	}

	/**
	 * Este metodo deleta uma compra de uma lista, pelo id do item.
	 * 
	 * @param descritorLista
	 *            O descritor da lista.
	 * @param itemId
	 *            O ID do item.
	 */
	public void deletaCompraDeLista(String descritorLista, int itemId) {
		this.controllerLista.deletaCompraDeLista(descritorLista, itemId);
	}

	/**
	 * Este metodo recupera uma lista de compras a partir de sua data.
	 * 
	 * @param data
	 *            A data da lista.
	 * @param posicaoLista
	 *            A posicao da lista.
	 * @return em String o nome da lista de compras.
	 */
	public String getItemListaPorData(String data, int posicaoLista) {
		return this.controllerLista.getItemListaPorData(data, posicaoLista);
	}

	/**
	 * Recupera lista de compra a partir do id de um item, e tambem a partir da
	 * posicao.
	 * 
	 * @param id
	 *            O id do item.
	 * @param posicaoLista
	 *            A posicao da lista.
	 * @return em String a representacao de umal ista de compras.
	 */
	public String getItemListaPorItem(int id, int posicaoLista) {
		return this.controllerLista.getItemListaPorItem(id, posicaoLista);
	}

	// Metodo Extra
	public Item pegaItem(int id) {
		try {
			return this.controllerItem.pegaItem(id);
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro na compra de item: item nao existe no sistema.");
		}
	}

}
