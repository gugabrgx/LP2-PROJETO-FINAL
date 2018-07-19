package Controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import Comparators.ComparaDescritor;
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
    private ControllerItem controllerItem;
    private Comparator<ListaDeCompras> comparador;

    public ControllerLista(ControllerItem controllerItem) {
        this.listasDeCompras = new HashMap<>();
        this.controllerItem = controllerItem;
    }

    public String adicionaListaDeCompras(String descritorLista) {

        if (descritorLista == null) {
            throw new NullPointerException(
                    "Erro na criacao de lista de compras: descritor nao pode ser vazio ou nulo.");
        }

        if (descritorLista.trim().equals("")) {
            throw new IllegalArgumentException(
                    "Erro na criacao de lista de compras: descritor nao pode ser vazio ou nulo.");
        }

        this.listasDeCompras.put(descritorLista.toLowerCase(), new ListaDeCompras(descritorLista));
        return descritorLista;
    }

    public void adicionaCompraALista(String descritorLista, int quantidade, int itemId) {
        Item item;
        try {
            item = this.pegaItem(itemId);
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro na compra de item: " + e.getMessage());
        }
        this.listasDeCompras.get(descritorLista.toLowerCase()).adicionaCompraALista(quantidade, item);
    }

    public void finalizarListaDeCompras(String descritorLista, String localDaCompra, int valorFinalDaCompra) {
        if (descritorLista == null) {
            throw new NullPointerException(
                    "Erro na finalizacao de lista de compras: descritor nao pode ser vazio ou nulo.");
        }

        if (descritorLista.trim().equals("")) {
            throw new IllegalArgumentException(
                    "Erro na finalizacao de lista de compras: descritor nao pode ser vazio ou nulo.");
        }
        if (localDaCompra == null) {
            throw new NullPointerException(
                    "Erro na finalizacao de lista de compras: local nao pode ser vazio ou nulo.");
        }

        if (localDaCompra.trim().equals("")) {
            throw new IllegalArgumentException(
                    "Erro na finalizacao de lista de compras: local nao pode ser vazio ou nulo.");
        }
        if (valorFinalDaCompra < 1) {
            throw new IllegalArgumentException(
                    "Erro na finalizacao de lista de compras: valor final da lista invalido.");
        }
        listasDeCompras.get(descritorLista.toLowerCase()).finalizarListaDeCompras(localDaCompra, valorFinalDaCompra);
    }

    public String pesquisaCompraEmLista(String descritorLista, int itemId) {
        if (descritorLista == null) {
            throw new NullPointerException("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo.");
        }

        if (descritorLista.trim().equals("")) {
            throw new IllegalArgumentException("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo.");
        }
        Item item;
        try {
            item = this.pegaItem(itemId);
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro na pesquisa de compra: " + e.getMessage());
        }
        return this.listasDeCompras.get(descritorLista.toLowerCase()).pesquisaCompraEmLista(item);
    }

    public void atualizaCompraDeLista(String descritorLista, int itemId, int quantidade, String operacao) {
        if (!(operacao.equals("adiciona")) && !(operacao.equals("diminui"))) {
            throw new IllegalArgumentException("Erro na atualizacao de compra: operacao invalida para atualizacao.");
        }
        this.listasDeCompras.get(descritorLista.toLowerCase()).atualizaCompraDeLista(operacao, this.pegaItem(itemId), quantidade);

    }

    public String getItemLista(String descritorLista, int posicaoItem) {
        if (descritorLista == null) {
            throw new NullPointerException("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo.");
        }

        if (descritorLista.trim().equals("")) {
            throw new IllegalArgumentException("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo.");
        }
        return this.listasDeCompras.get(descritorLista.toLowerCase()).getItemLista(posicaoItem);

    }

    public void deletaCompraDeLista(String descritorLista, int itemId) {
        if (descritorLista == null) {
            throw new NullPointerException("Erro na exclusao de compra: descritor nao pode ser vazio ou nulo.");
        }

        if (descritorLista.trim().equals("")) {
            throw new IllegalArgumentException("Erro na exclusao de compra: descritor nao pode ser vazio ou nulo.");
        }

        Item item;
        try {
            item = this.pegaItem(itemId);
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro na exclusao de compra: " + e.getMessage());
        }
        this.listasDeCompras.get(descritorLista.toLowerCase()).deletaCompraDeLista(item);

    }

    public String pesquisaListaDeCompras(String descritorLista) {
        if (descritorLista == null)
            throw new NullPointerException("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo.");
        if ("".equals(descritorLista.trim()))
            throw new IllegalArgumentException("Erro na pesquisa de compra: descritor nao pode ser vazio ou nulo.");

        if (!this.listasDeCompras.containsKey(descritorLista.toLowerCase()))
            throw new IllegalArgumentException("Erro na pesquisa de compra: lista de compras nao existe.");

        return this.listasDeCompras.get(descritorLista.toLowerCase()).getDescritorLista();
    }

    private List<ListaDeCompras> getListasDoDia(String data) {
        if (data == null)
            throw new NullPointerException("Erro na pesquisa de compra: data nao pode ser vazia ou nula.");

        if ("".equals(data.trim())) {
            throw new IllegalArgumentException("Erro na pesquisa de compra: data nao pode ser vazia ou nula.");
        }

        if (data.length() < 10 || !(data.charAt(2) == data.charAt(5) && data.charAt(2) == '/')) {
            throw new IllegalArgumentException("Erro na pesquisa de compra: data em formato invalido, tente dd/MM/yyyy");
        }

        List<ListaDeCompras> listasDoDia = new ArrayList<>();
        this.comparador = new ComparaDescritor();

        for (ListaDeCompras listaDeCompra : this.listasDeCompras.values()) {
            if (data.equals(listaDeCompra.getData())) listasDoDia.add(listaDeCompra);
        }

        listasDoDia.sort(this.comparador);

        return listasDoDia;
    }

    public String pesquisaListasDeComprasPorItem(int id) {
        StringBuilder saida = new StringBuilder();

        for (ListaDeCompras lista : this.listasDeCompras.values()) {
            if (lista.hasItem(id)) saida.append(lista.getDescritorLista()).append(System.lineSeparator());
        }

        if ("".equals(saida.toString())) throw new NullPointerException("Erro na pesquisa de compra: compra nao encontrada na lista.");

        return saida.toString().trim();
    }

    public String pesquisaListasDeComprasPorData(String data) {
        StringBuilder saida = new StringBuilder();

        for (ListaDeCompras lista : this.getListasDoDia(data)) {
            saida.append(lista.getDescritorLista()).append(System.lineSeparator());
        }

        return saida.toString().trim();
    }

    public String getItemListaPorData(String data, int posicaoLista) {
        if (posicaoLista < 0)
            throw new ArrayIndexOutOfBoundsException("Erro na pesquisa de compra: posicao nao pode ser menor que zero");

        return this.getListasDoDia(data).get(posicaoLista).getDescritorLista();

    }

    public String getItemListaPorItem(int id, int posicaoLista) {
        List<ListaDeCompras> listasComItem = new ArrayList<>();

        this.comparador = new ComparaDescritor();

        for (ListaDeCompras lista : this.listasDeCompras.values()) {
            if (lista.hasItem(id)) listasComItem.add(lista);
        }

        listasComItem.sort(this.comparador);

        return listasComItem.get(posicaoLista).toString();
    }

    public Item pegaItem(int id) {
        return this.controllerItem.pegaItem(id);
    }
}
