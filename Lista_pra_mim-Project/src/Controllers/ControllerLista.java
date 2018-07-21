package Controllers;

import java.util.*;

import Comparators.ComparaDescritor;
import entidades.Item;
import entidades.ListaDeCompras;

/**
 * Laboratorio de Programacao 2 - Lab 1 Classe que representa o Controller.
 * Nesta classe e possivel realizar operacoes como: adicionar itens na lista de
 * compras, exibir listas, atualizar listas, etc.
 * 
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Luiz Bispo dos Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 */
public class ControllerLista {

	// Um Mapa que mapeia uma String descritor da lista para uma lista de compras.
	private Map<String, ListaDeCompras> listasDeCompras;
	// Este atributo reprsenta o controller de item.
	private ControllerItem controllerItem;
	// Este atributo representa um comparador de compras
	private Comparator<ListaDeCompras> comparador;

	/**
	 * Constroi um controller de lista, e inicializa o Mapa, e o controller de item.
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
	 * @param itemID
	 *            O item a ser adicionado na lista.
	 */
	public void adicionaCompraALista(String descritorLista, int quantidade, int itemId) {
		this.listasDeCompras.get(descritorLista).adicionaCompraALista(quantidade,
				this.pegaItem(itemId, "Erro na compra de item: "));
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
		return this.listasDeCompras.get(descritorLista)
				.pesquisaCompraEmLista(this.pegaItem(itemId, "Erro na pesquisa de compra: "));
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
	 * @param operacao
	 *            A operacao de diminuir ou aumentar a quantidade do item.
	 */
	public void atualizaCompraDeLista(String descritorLista, int itemId, int quantidade, String operacao) {
		if (!(operacao.equals("adiciona")) && !(operacao.equals("diminui"))) {
			throw new IllegalArgumentException("Erro na atualizacao de compra: operacao invalida para atualizacao.");
		}
		this.listasDeCompras.get(descritorLista).atualizaCompraDeLista(operacao,
				this.pegaItem(itemId, "Erro na exclusao de compra: "), quantidade);

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
		this.listasDeCompras.get(descritorLista)
				.deletaCompraDeLista(this.pegaItem(itemId, "Erro na exclusao de compra: "));

	}

	/**
	 * Este metodo recupera uma lista a partir de sua desccricao.
	 * 
	 * @param descritorLista
	 *            O descritor da lista.
	 * @return em String a representacao de uma lista.
	 */
	public String pesquisaListaDeCompras(String descritorLista) {
		if (descritorLista == null)
			throw new NullPointerException("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo.");
		if ("".equals(descritorLista.trim()))
			throw new IllegalArgumentException("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo.");

		if (!this.listasDeCompras.containsKey(descritorLista.toLowerCase()))
			throw new IllegalArgumentException("Erro na pesquisa de compra: lista de compras nao existe.");

		return this.listasDeCompras.get(descritorLista.toLowerCase()).getDescritorLista();
	}

	/**
	 * Metodo que retorna as listas a partir do dia.
	 * 
	 * @param data
	 *            A data da lista.
	 * @return As listas de compra do dia.
	 */
	private List<ListaDeCompras> getListasDoDia(String data) {
		if (data == null)
			throw new NullPointerException("Erro na pesquisa de compra: data nao pode ser vazia ou nula.");

		if ("".equals(data.trim())) {
			throw new IllegalArgumentException("Erro na pesquisa de compra: data nao pode ser vazia ou nula.");
		}

		if (data.length() < 10 || !(data.charAt(2) == data.charAt(5) && data.charAt(2) == '/')) {
			throw new IllegalArgumentException(
					"Erro na pesquisa de compra: data em formato invalido, tente dd/MM/yyyy");
		}

		List<ListaDeCompras> listasDoDia = new ArrayList<>();
		this.comparador = new ComparaDescritor();

		for (ListaDeCompras listaDeCompra : this.listasDeCompras.values()) {
			if (data.equals(listaDeCompra.getData()))
				listasDoDia.add(listaDeCompra);
		}

		listasDoDia.sort(this.comparador);

		return listasDoDia;
	}

	/**
	 * Metodo que retorna listas de compra pela data passa como parametro.
	 * 
	 * @param data
	 *            A data.
	 * @return em String a representacao contendo a(s) lista(s) com a data passada
	 *         como parametro.
	 */
	public String pesquisaListasDeComprasPorData(String data) {
		StringBuilder saida = new StringBuilder();

		for (ListaDeCompras lista : this.getListasDoDia(data)) {
			saida.append(lista.getDescritorLista()).append(System.lineSeparator());
		}

		return saida.toString().trim();
	}

	/**
	 * Metodo que retorna as listas que contem determinado item.
	 * 
	 * @param id
	 *            O id do item.
	 * @return A representacao de varias listas que contem o item.
	 */
	public String pesquisaListasDeComprasPorItem(int id) {
		StringBuilder saida = new StringBuilder();

		for (ListaDeCompras lista : this.listasDeCompras.values()) {
			if (lista.hasItem(id))
				saida.append(lista.getDescritorLista()).append(System.lineSeparator());
		}

		if ("".equals(saida.toString()))
			throw new NullPointerException("Erro na pesquisa de compra: compra nao encontrada na lista.");

		return saida.toString().trim();
	}

	/**
	 * Este metodo recupera uma lista de compras a partir de sua data, e sua
	 * posicao.
	 * 
	 * @param data
	 *            A data da lista.
	 * @param posicaoLista
	 *            A posicao da Lista
	 * @return em String o nome da lista de compras.
	 */
	public String getItemListaPorData(String data, int posicaoLista) {
		if (posicaoLista < 0)
			throw new ArrayIndexOutOfBoundsException("Erro na pesquisa de compra: posicao nao pode ser menor que zero");

		return this.getListasDoDia(data).get(posicaoLista).getDescritorLista();

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
		List<ListaDeCompras> listasComItem = new ArrayList<>();

		this.comparador = new ComparaDescritor();

		for (ListaDeCompras lista : this.listasDeCompras.values()) {
			if (lista.hasItem(id))
				listasComItem.add(lista);
		}
		listasComItem.sort(this.comparador);

		return listasComItem.get(posicaoLista).toString();
	}

	/**
	 * Este metodo recupera um item.
	 * 
	 * @param id
	 *            O id do item.
	 * @param msg
	 *            A mensagem
	 * @return O objeto item.
	 */
	private Item pegaItem(int id, String msg) {
        return this.controllerItem.pegaItem(id, msg);
	}
 }

