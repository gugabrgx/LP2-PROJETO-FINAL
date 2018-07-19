package Comparators;

import java.util.Comparator;

import entidades.Compras;

/**
 * Laboratório de Programação 2 - Lab 2
 * 
 * 
 * @author Rafael Dantas Santos de Azevedo - 117210382
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class ComparaCompras implements Comparator<Compras> {

	/**
	 * Metodo que compara a descricao das compras, e depois a categoria do item.
	 */
	@Override
	public int compare(Compras c1, Compras c2) {
		if (c1.getItemCategoria().equals(c2.getItemCategoria())) {
			return c1.getItemDescricao().compareTo(c2.getItemDescricao());

		}
		return c1.getItemCategoria().compareTo(c2.getItemCategoria());
	}

}
