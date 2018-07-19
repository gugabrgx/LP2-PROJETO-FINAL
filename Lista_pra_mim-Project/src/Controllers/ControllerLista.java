package Controllers;

import java.util.HashMap;

import entidades.Item;
import entidades.ListaDeCompras;

/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Luiz Bispo dos Santos - 117210400
 */
public class ControllerLista {

	private HashMap<String, ListaDeCompras> listasDeCompras;
	private ControllerItem controllerItem;

	public ControllerLista(ControllerItem controllerItem) {
		this.listasDeCompras = new HashMap<>();
		this.controllerItem = controllerItem;
	}

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

	public void adicionaCompraALista(String descritorLista, int quantidade, int itemId) {
		this.listasDeCompras.get(descritorLista).adicionaCompraALista(quantidade,
				this.pegaItem(itemId, "Erro na compra de item: "));
	}

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

	public void atualizaCompraDeLista(String descritorLista, int itemId, int quantidade, String operacao) {
		if (!(operacao.equals("adiciona")) && !(operacao.equals("diminui"))) {
			throw new IllegalArgumentException("Erro na atualizacao de compra: operacao invalida para atualizacao.");
		}
		this.listasDeCompras.get(descritorLista).atualizaCompraDeLista(operacao,
				this.pegaItem(itemId, "Erro na exclusao de compra: "), quantidade);

	}

	public String getItemLista(String descritorLista, int posicaoItem) {
		if (descritorLista == null) {
			throw new NullPointerException("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo.");
		}

		if (descritorLista.trim().equals("")) {
			throw new IllegalArgumentException("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo.");
		}
		return this.listasDeCompras.get(descritorLista).getItemLista(posicaoItem);

	}

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

	public String pesquisaListaDeCompras(String descritorLista) {
		return this.listasDeCompras.get(descritorLista).getDescritorLista();
	}

	public String getItemListaPorData(String data, int posicaoLista) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getItemListaPorItem(int id, int posicaoLista) {
		// TODO Auto-generated method stub
		return null;
	}

	private Item pegaItem(int id, String msg) {
		return this.controllerItem.pegaItem(id, msg);
	}
}
