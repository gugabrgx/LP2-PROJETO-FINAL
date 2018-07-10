package Comparators;

import java.util.Comparator;

import entidades.Item;

/**
 * Laboratório de Programação 2 - Lista pra mim© Project
 * 
 * Classe de comparação de itens a partir dos seus nomes. Implementa o
 * Comparator.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */
public class ComparaNome implements Comparator<Item> {

	/**
	 * Comparara dois objetos do tipo Item, tomando como base a ordem lexicográfica
	 * de sua descrição.
	 * 
	 * @param i1
	 *            o primeiro item.
	 * @param i2
	 *            o segundo item.
	 * @return um inteiro que indica a posição relativa dos itens.
	 */
	@Override
	public int compare(Item i1, Item i2) {
		return i1.getNome().compareTo(i2.getNome());
	}

}
