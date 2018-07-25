package comparators;

import java.io.Serializable;
import java.util.Comparator;

import entidades.Item;
import entidades.ListaDeCompras;

/**
 * Laboratório de Programação 2 - Lista pra mim© Project
 *
 * Classe de comparação de itens a partir dos seus preço. Implementa o
 * Comparator.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Dantas Santos de Azevedo - 117210382
 */
public class ComparaTempo implements Comparator<ListaDeCompras>, Serializable{

    /**
     * Comparara dois objetos do tipo Item, tomando como base o menor preço dos
     * itens comparados.
     *
     * @param l1
     *            o primeiro item.
     * @param l2
     *            o segundo item.
     * @return um inteiro que indica a posição relativa dos itens de acordo com o
     *         preco.
     */
    @Override
    public int compare(ListaDeCompras l1, ListaDeCompras l2) {
        return Double.compare(l1.getMili(), l2.getMili());
    }

}
