package comparators;

import entidades.ListaDeCompras;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Laboratório de Programação 2 - Lista pra mim© Project
 * 
 * Classe de comparação de descritores de lista. Implementa o Comparator.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Dantas Santos de Azevedo - 117210382
 */
public class ComparaDescritor implements Comparator<ListaDeCompras>, Serializable {

	/**
	 * Comparara duas Strings, estas representam as horas em que as listas foram
	 * criadas.
	 *
	 * @param listaDeCompras1 a primeira lista de compras.
	 * @param listaDeCompras2 a segunda lista de compras.
	 * @return um inteiro que indica a posição relativa dos itens de acordo com o
	 *         preco.
	 */
	@Override
	public int compare(ListaDeCompras listaDeCompras1, ListaDeCompras listaDeCompras2) {
		return listaDeCompras1.getDescritorLista().toLowerCase()
				.compareTo(listaDeCompras2.getDescritorLista().toLowerCase());
	}
}
