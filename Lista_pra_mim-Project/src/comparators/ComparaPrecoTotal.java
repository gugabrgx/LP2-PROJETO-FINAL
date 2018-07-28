package comparators;

import java.util.Comparator;

import entidades.ListaDeCompras;

/**
 * Laboratório de Programação 2 - Lab 2
 * 
 * 
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class ComparaPrecoTotal implements Comparator<ListaDeCompras> {

	@Override
	public int compare(ListaDeCompras o1, ListaDeCompras o2) {
		return  o1.getPrecoTotal() - o2.getPrecoTotal();
	}

}
