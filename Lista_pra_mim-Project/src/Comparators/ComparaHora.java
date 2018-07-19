package Comparators;

import entidades.Item;
import entidades.ListaDeCompras;

import java.util.Comparator;

public class ComparaHora implements Comparator<ListaDeCompras> {

    /**
     * Comparara duas Strings, estas representam as horas em que as listas foram criadas.
     *
     * @param listaDeCompras1
     *            a primeira lista de compras.
     * @param listaDeCompras2
     *            a segunda lista de compras.
     * @return um inteiro que indica a posição relativa dos itens de acordo com o
     *         preco.
     */
    @Override
    public int compare(ListaDeCompras listaDeCompras1, ListaDeCompras listaDeCompras2) {
        return listaDeCompras1.getHora().compareTo(listaDeCompras2.getHora());
    }
}
