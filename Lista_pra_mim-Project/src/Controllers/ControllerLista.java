package Controllers;

import java.util.HashMap;

import entidades.Item;
import entidades.ListaDeCompras;

/**
 * Laboratório de Programação 2 - Lab 1 Classe que representa o Controller.
 * Nesta classe e possivel realizar operacoes como: adicionar itens na lista de
 * compras, exibir listas, atualizar listas, etc.
 * 
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Luiz Bispo dos Santos - 117210400
 */
public class ControllerLista {

	// Um Mapa que mapeia uma String descritor da lista para uma lista de compras.
	private HashMap<String, ListaDeCompras> listasDeCompras;
	private ControllerItem controllerItem;

	/**
	 * Constroi um controller de lista, e inicializa o Mapa.
	 */
	public ControllerLista(ControllerItem controllerItem) {
		this.listasDeCompras = new HashMap<>();
		this.controllerItem = controllerItem;
	}

	/**
	 * Cria uma nova lista de compras.
	 * 
	 * @param descritorLista
	 *            O descritor da lista.
	 * @return em String o descritor da lista.
	 */
	public String adicionaListaDeCompras(String descritorLista) {
		if (descritorLista == null) {
			throw new NullPointerException(
					"Erro na criacao de lista de compras: descritor nao pode ser vazio ou nulo.");
		}

		if (descritorLista.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro na criacao de lista de compras: descritor nao pode ser vazio ou nulo.");
		}
		this.listasDeCompras.put(descritorLista, new ListaDeCompras(descritorLista));
		return descritorLista;
	}

	/**
	 * Este metodo adiciona um item com sua quantidade, em uma determinada lista.
	 * 
	 * @param descritorLista
	 *            O descritor da lista.
	 * @param quantidade
	 *            A quantidade do item.
	 * @param item
	 *            O item a ser adicionado na lista.
	 */
	public void adicionaCompraALista(String descritorLista, int quantidade, int itemId) {
		Item item;
		try {
			item = this.pegaItem(itemId);
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro na compra de item: " + e.getMessage());
		}
		this.listasDeCompras.get(descritorLista).adicionaCompraALista(quantidade, item);
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
		if (descritorLista == null) {
			throw new NullPointerException(
					"Erro na finalizacao de lista de compras: descritor nao pode ser vazio ou nulo.");
		}

		if (descritorLista.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro na finalizacao de lista de compras: descritor nao pode ser vazio ou nulo.");
		}
		if (localDaCompra == null) {
			throw new NullPointerException(
					"Erro na finalizacao de lista de compras: local nao pode ser vazio ou nulo.");
		}

		if (localDaCompra.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro na finalizacao de lista de compras: local nao pode ser vazio ou nulo.");
		}
		if (valorFinalDaCompra < 1) {
			throw new IllegalArgumentException(
					"Erro na finalizacao de lista de compras: valor final da lista invalido.");
		}
		listasDeCompras.get(descritorLista).finalizarListaDeCompras(localDaCompra, valorFinalDaCompra);
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
		if (descritorLista == null) {
			throw new NullPointerException("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo.");
		}

		if (descritorLista.trim().equals("")) {
			throw new IllegalArgumentException("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo.");
		}
		Item item;
		try {
			item = this.pegaItem(itemId);
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro na pesquisa de compra: " + e.getMessage());
		}
		return this.listasDeCompras.get(descritorLista).pesquisaCompraEmLista(item);
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
	public void atualizaCompraDeLista(String descritorLista, int itemId, int quantidade, String operacao) {
		if (!(operacao.equals("adiciona")) && !(operacao.equals("diminui"))) {
			throw new IllegalArgumentException("Erro na atualizacao de compra: operacao invalida para atualizacao.");
		}
		this.listasDeCompras.get(descritorLista).atualizaCompraDeLista(operacao, this.pegaItem(itemId), quantidade);
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
		if (descritorLista == null) {
			throw new NullPointerException("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo.");
		}

		if (descritorLista.trim().equals("")) {
			throw new IllegalArgumentException("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo.");
		}
		return this.listasDeCompras.get(descritorLista).getItemLista(posicaoItem);

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
		if (descritorLista == null) {
			throw new NullPointerException("Erro na exclusao de compra: descritor nao pode ser vazio ou nulo.");
		}

		if (descritorLista.trim().equals("")) {
			throw new IllegalArgumentException("Erro na exclusao de compra: descritor nao pode ser vazio ou nulo.");
		}
		Item item;
		try {
			item = this.pegaItem(itemId);
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro na exclusao de compra: " + e.getMessage());
		}
		this.listasDeCompras.get(descritorLista).deletaCompraDeLista(item);

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
	public String pesquisaListaDeCompras(String descritorLista) {
		return this.listasDeCompras.get(descritorLista).getDescritorLista();
	}

	public String getItemListaPorData(String data, int posicaoLista) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	public Item pegaItem(int id) {
		return this.controllerItem.pegaItem(id);
	}
}
