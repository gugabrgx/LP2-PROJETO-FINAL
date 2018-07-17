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

	public ControllerLista() {
		this.listasDeCompras = new HashMap<>();
	}
	
	public String adicionaListaDeCompras(String descritorLista) {
		listasDeCompras.put(descritorLista, new ListaDeCompras(descritorLista));
		return descritorLista;
	}

	public void adicionaCompraALista(String descritorLista, int quantidade, Item item) {
		listasDeCompras.get(descritorLista).adicionaCompraALista(quantidade, item);
	}

	public void finalizarListaDeCompras(String descritorLista, String localDaCompra, int valorFinalDaCompra) {
		listasDeCompras.get(descritorLista).finalizarListaDeCompras(localDaCompra, valorFinalDaCompra);
	}

	public String pesquisaCompraEmLista(String descritorLista, int itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void atualizaCompraDeLista(String descritorLista, int itemId, int quantidade) {
		// TODO Auto-generated method stub

	}

	public String getItemLista(String descritorLista, int posicaoItem) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deletaCompraDeLista(String descritorLista, int itemId) {
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
