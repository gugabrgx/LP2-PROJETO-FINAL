package Comparators;

import java.util.Comparator;

import entidades.Item;

/**
 * Laboratório de Programação 2 - Lista pra mim© Project
 * 
 * Classe de comparação de itens a partir dos seus preço. Implementa o
 * Comparator.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */
public class ComparaPreco implements Comparator<Item> {

	/**
	 * Comparara dois objetos do tipo Item, tomando como base o menor preço dos
	 * itens comparados.
	 * 
	 * @param i1
	 *            o primeiro item.
	 * @param i2
	 *            o segundo item.
	 * @return um inteiro que indica a posição relativa dos itens de acordo com o
	 *         preco.
	 */
	@Override
	public int compare(Item i1, Item i2) {
		return (int) (i1.getMenorPreco() * 100 - i2.getMenorPreco() * 100);
	}

}
