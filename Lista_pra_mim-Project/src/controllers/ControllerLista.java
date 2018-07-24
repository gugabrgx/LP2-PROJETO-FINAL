package controllers;

import java.util.*;

import comparators.ComparaDescritor;
import entidades.Item;
import entidades.ListaDeCompras;

/**
 * Laboratorio de Programacao 2 - Lab 1 Classe que representa o Controller.
 * Nesta classe e possivel realizar operacoes como: adicionar itens na lista de
 * compras, exibir listas, atualizar listas, etc.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Luiz Bispo dos Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */
public class ControllerLista {

	/**
	 * Um Mapa que mapeia uma String descritor da lista para uma lista de compras.
	 */
	private Map<String, ListaDeCompras> listasDeCompras;

	/**
	 * Atributo que representa o controller de item, e permite este controler
	 * conhecer os itens cadastrados.
	 */
	private ControllerItem controllerItem;

	/**
	 * Atributo que representa um comparador de compras
	 */
	private Comparator<ListaDeCompras> comparador;

	/**
	 * Constroi um controller de lista, e inicializa o Mapa.
	 * 
	 * @param controllerItem Controlador de item.
	 */
	public ControllerLista(ControllerItem controllerItem) {
		this.listasDeCompras = new HashMap<>();
		this.controllerItem = controllerItem;
	}

	/**
	 * Cria uma nova lista de compras.
	 *
	 * @param descritorLista O descritor da lista.
	 * @return em String o descritor da lista.
	 */
	public String adicionaListaDeCompras(String descritorLista) {
		if (descritorLista == null) {
			throw new NullPointerException(
					"Erro na criacao de lista de compras: descritor nao pode ser vazio ou nulo.");
		}

		if ("".equals(descritorLista.trim())) {
			throw new IllegalArgumentException(
					"Erro na criacao de lista de compras: descritor nao pode ser vazio ou nulo.");
		}

		if (listasDeCompras.containsKey(descritorLista)) {
			throw new IllegalArgumentException("Erro na criacao de lista de compras: lista ja cadastrada no sistema.");
		}

		this.listasDeCompras.put(descritorLista, new ListaDeCompras(descritorLista));
		return descritorLista;
	}

	/**
	 * Este metodo adiciona um item com sua quantidade, em uma determinada lista.
	 *
	 * @param descritorLista O descritor da lista.
	 * @param quantidade     A quantidade do item.
	 * @param itemId         O item a ser adicionado na lista.
	 */
	public void adicionaCompraALista(String descritorLista, int quantidade, int itemId) {
		this.verificaDescritor(descritorLista, "Erro na adicao de item na lista de compras");

		this.listasDeCompras.get(descritorLista).adicionaCompraALista(quantidade,
				this.pegaItem(itemId, "Erro na compra de item: "));
	}

	/**
	 * Este metodo finaliza uma lista de compras.
	 *
	 * @param descritorLista     O descritor da lista.
	 * @param localDaCompra      O local de compra da lista.
	 * @param valorFinalDaCompra O valor final da compra.
	 */
	public void finalizarListaDeCompras(String descritorLista, String localDaCompra, int valorFinalDaCompra) {
		this.verificaDescritor(descritorLista, "Erro na finalizacao de lista de compras");

		if (localDaCompra == null) {
			throw new NullPointerException(
					"Erro na finalizacao de lista de compras: local nao pode ser vazio ou nulo.");
		}

		if ("".equals(localDaCompra.trim())) {
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
	 * @param descritorLista O descritor da lista.
	 * @param itemId         o ID do item.
	 * @return em String o item pesquisado na lista.
	 */
	public String pesquisaCompraEmLista(String descritorLista, int itemId) {
		if (itemId < 1)
			throw new IllegalArgumentException("Erro na pesquisa de compra: item id invalido.");

		this.verificaDescritor(descritorLista, "Erro na pesquisa de compra");

		return this.listasDeCompras.get(descritorLista)
				.pesquisaCompraEmLista(this.pegaItem(itemId, "Erro na pesquisa de compra: "));
	}

	/**
	 * Este metodo atualiza a quantidade de um item, emm uma determinada lista.
	 *
	 * @param descritorLista O descritor da lista.
	 * @param itemId         O ID do item.
	 * @param quantidade     A quantidade nova do item.
	 * @param operacao       A operacao de diminuir ou aumentar a quantidade do
	 *                       item.
	 */
	public void atualizaCompraDeLista(String descritorLista, int itemId, int quantidade, String operacao) {
		this.verificaDescritor(descritorLista, "Erro na atualizacao de compra");

		if (!(operacao.equals("adiciona") || (operacao.equals("diminui")))) {
			throw new IllegalArgumentException("Erro na atualizacao de compra: operacao invalida para atualizacao.");
		}

		this.listasDeCompras.get(descritorLista).atualizaCompraDeLista(operacao,
				this.pegaItem(itemId, "Erro na exclusao de compra: "), quantidade);

	}

	/**
	 * Este metodo recupra um item de uma lista, a partir de sua posicao.
	 *
	 * @param descritorLista O descritor da lista.
	 * @param posicaoItem    A posicao do Item.
	 * @return em String a representacao de um item.
	 */
	public String getItemLista(String descritorLista, int posicaoItem) {
		this.verificaDescritor(descritorLista, "Erro na pesquisa de compra");
		return this.listasDeCompras.get(descritorLista).getItemLista(posicaoItem);

	}

	/**
	 * Este metodo deleta uma compra de uma lista, pelo id do item.
	 *
	 * @param descritorLista O descritor da lista.
	 * @param itemId         O ID do item.
	 */
	public void deletaCompraDeLista(String descritorLista, int itemId) {
		this.verificaDescritor(descritorLista, "Erro na exclusao de compra");

		this.listasDeCompras.get(descritorLista)
				.deletaCompraDeLista(this.pegaItem(itemId, "Erro na exclusao de compra: "));
	}

	/**
	 * Este metodo recupera uma lista a partir de sua descricao.
	 *
	 * @param descritorLista O descritor da lista.
	 * @return em String a representacao de uma lista.
	 */
	public String pesquisaListaDeCompras(String descritorLista) {
		this.verificaDescritor(descritorLista, "Erro na pesquisa de compra");

		return this.listasDeCompras.get(descritorLista).getDescritorLista();
	}

	/**
	 * Metodo que retorna uma lista com as listas criadas na data escolhida pelo
	 * usuario.
	 *
	 * @param data A data da criaçao da lista.
	 * @return As listas de compras criadas no data.
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
	 * @param data A data.
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
	 * Este metodo recupera uma lista de compras a partir de sua data, e sua
	 * posicao.
	 *
	 * @param data         A data da lista.
	 * @param posicaoLista A posicao da Lista
	 * @return em String o nome da lista de compras.
	 */

	public String getItemListaPorData(String data, int posicaoLista) {
		if (posicaoLista < 0)
			throw new ArrayIndexOutOfBoundsException("Erro na pesquisa de compra: posicao nao pode ser menor que zero");

		return this.getListasDoDia(data).get(posicaoLista).getDescritorLista();

	}

	/**
	 * Metodo que retorna uma lista com as listas que possuem o item escolhida pelo
	 * usuario.
	 *
	 * @param id O id do item.
	 * @return As listas de compra que possuem o item.
	 */
	private List<ListaDeCompras> getListasPorItem(int id) {
		if (id < 1)
			throw new IllegalArgumentException("Erro na pesquisa de compra: id nao pode ser menor que um");

		List<ListaDeCompras> listasComItem = new ArrayList<>();
		this.comparador = new ComparaDescritor();

		for (ListaDeCompras listaDeCompra : this.listasDeCompras.values()) {
			if (listaDeCompra.hasItem(id))
				listasComItem.add(listaDeCompra);
		}

		listasComItem.sort(this.comparador);

		return listasComItem;

	}

	/**
	 * Metodo que retorna as listas que contem determinado item.
	 *
	 * @param id O id do item.
	 * @return A representacao textual de varias listas que contem o item.
	 */

	public String pesquisaListasDeComprasPorItem(int id) {
		StringBuilder saida = new StringBuilder();

		for (ListaDeCompras lista : this.getListasPorItem(id)) {
			saida.append(lista.getDescritorLista()).append(System.lineSeparator());
		}

		if ("".equals(saida.toString()))
			throw new NullPointerException("Erro na pesquisa de compra: compra nao encontrada na lista.");

		return saida.toString().trim();
	}

	/**
	 * Recupera lista de compra a partir do id de um item, e tambem a partir da
	 * posicao.
	 *
	 * @param id           O id do item.
	 * @param posicaoLista A posicao da lista.
	 * @return A representacao textual da lista de compras escolhida pelo usuario.
	 */
	public String getItemListaPorItem(int id, int posicaoLista) {
		if (posicaoLista < 0)
			throw new ArrayIndexOutOfBoundsException("Erro na pesquisa de compra: posicao nao pode ser menor que zero");

		return this.getListasPorItem(id).get(posicaoLista).toString();
	}

	/**
	 * Este metodo recupera um item.
	 *
	 * @param id  O id do item.
	 * @param msg Parte da mensagem de erro que sera lancada caso alguma excecao
	 *            ocorra.
	 * @return O objeto item.
	 */
	private Item pegaItem(int id, String msg) {
		return this.controllerItem.pegaItem(id, msg);
	}

	/**
	 * Metodo que verifica a validade e checa a existenciado do descritor de uma
	 * lista repassado pelo usuario
	 *
	 * @param descritorLista O descritor de uma lista.
	 * @param erro           Parte da mensagem de erro que sera lancada caso alguma
	 *                       excecao ocorra.
	 */
	private void verificaDescritor(String descritorLista, String erro) {
		if (descritorLista == null) {
			throw new NullPointerException(erro + ": descritor nao pode ser vazio ou nulo.");
		}

		if ("".equals(descritorLista.trim())) {
			throw new IllegalArgumentException(erro + ": descritor nao pode ser vazio ou nulo.");
		}

		if (!listasDeCompras.containsKey(descritorLista)) {
			throw new IllegalArgumentException(erro + ": lista de compras nao existe.");
		}
	}
	
	
}
