package Controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import Comparators.ComparaCompras;
import Comparators.ComparaNome;
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

	public ControllerLista() {
		this.listasDeCompras = new HashMap<>();
	}

	public String adicionaListaDeCompras(String descritorLista) {
		if (descritorLista == null || descritorLista.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro na criacao de lista de compras: descritor nao pode ser vazio ou nulo.");
		}
		listasDeCompras.put(descritorLista, new ListaDeCompras(descritorLista));
		return descritorLista;
	}

	public void adicionaCompraALista(String descritorLista, int quantidade, Item item) {
		listasDeCompras.get(descritorLista).adicionaCompraALista(quantidade, item);
	}

	public void finalizarListaDeCompras(String descritorLista, String localDaCompra, int valorFinalDaCompra) {
		if (descritorLista == null || descritorLista.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro na finalizacao de lista de compras: descritor nao pode ser vazio ou nulo.");
		}
		if (localDaCompra == null || localDaCompra.trim().equals("")) {
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
		if (descritorLista == null || descritorLista.trim().equals("")) {
			throw new IllegalArgumentException("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo.");
		}
		// TODO Auto-generated method stub
		return null;
	}

	public void atualizaCompraDeLista(String descritorLista, int itemId, int quantidade) {
		// TODO Auto-generated method stub

	}

	public String getItemLista(String descritorLista, int posicaoItem) {
		if (descritorLista == null || descritorLista.trim().equals("")) {
			throw new IllegalArgumentException("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo.");
		}
		return this.listasDeCompras.get(descritorLista).getItemLista(posicaoItem);

	}

	public void deletaCompraDeLista(String descritorLista, int itemId) {
		if (descritorLista == null || descritorLista.trim().equals("")) {
			throw new IllegalArgumentException("Erro na exclusao de compra: descritor nao pode ser vazio ou nulo.");
		}
		// TODO Auto-generated method stub

	}

	public String getItemListaPorData(String data, int posicaoLista) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getItemListaPorItem(int id, int posicaoLista) {
		// TODO Auto-generated method stub
		return null;
	}

}
