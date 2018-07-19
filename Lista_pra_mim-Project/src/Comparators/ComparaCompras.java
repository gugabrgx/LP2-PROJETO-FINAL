package Comparators;

import java.util.Comparator;

import entidades.Compra;

/**
 * Laboratório de Programação 2 - Lab 2
 * 
 * 
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public class ComparaCompras implements Comparator<Compra> {

	@Override
	public int compare(Compra c1, Compra c2) {
		if (c1.getItemCategoria().equals(c2.getItemCategoria())) {
			return c1.getItemDescricao().compareTo(c2.getItemDescricao());

		}
		return c1.getItemCategoria().compareTo(c2.getItemCategoria());
	}

}
