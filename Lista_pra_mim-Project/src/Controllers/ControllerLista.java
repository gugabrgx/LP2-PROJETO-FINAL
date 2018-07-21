package Controllers;

import java.util.*;

import Comparators.ComparaDescritor;
import entidades.Item;
import entidades.ListaDeCompras;

/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Luiz Bispo dos Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 */
public class ControllerLista {


    private Map<String, ListaDeCompras> listasDeCompras;
    private ControllerItem controllerItem;
    private Comparator<ListaDeCompras> comparador;

    public ControllerLista(ControllerItem controllerItem) {
        this.listasDeCompras = new HashMap<>();
        this.controllerItem = controllerItem;
    }

    public String adicionaListaDeCompras(String descritorLista) {
        if (descritorLista == null) {
            throw new NullPointerException("Erro na criacao de lista de compras: descritor nao pode ser vazio ou nulo.");
        }

        if ("".equals(descritorLista.trim())) {
            throw new IllegalArgumentException("Erro na criacao de lista de compras: descritor nao pode ser vazio ou nulo.");
        }

        if (listasDeCompras.containsKey(descritorLista)) {
            throw new IllegalArgumentException("Erro na criacao de lista de compras: lista ja cadastrada no sistema.");
        }

        this.listasDeCompras.put(descritorLista, new ListaDeCompras(descritorLista));
        return descritorLista;
    }

    public void adicionaCompraALista(String descritorLista, int quantidade, int itemId) {
        this.verificaDescritor(descritorLista, "Erro na adicao de item na lista de compras");

        this.listasDeCompras.get(descritorLista).adicionaCompraALista(quantidade,
                this.pegaItem(itemId, "Erro na compra de item: "));
    }

    public void finalizarListaDeCompras(String descritorLista, String localDaCompra, int valorFinalDaCompra) {
        this.verificaDescritor(descritorLista, "Erro na finalizacao de lista de compras");

        if (localDaCompra == null) {
            throw new NullPointerException(
                    "Erro na finalizacao de lista de compras: local nao pode ser vazio ou nulo.");
        }

        if ("".equals(localDaCompra.trim())) {
            throw new IllegalArgumentException(
                    "Erro na finalizacao de lista de compras: local nao pode ser vazio ou nulo.");
        }

        if (valorFinalDaCompra < 1) {
            throw new IllegalArgumentException(
                    "Erro na finalizacao de lista de compras: valor final da lista invalido.");
        }

        listasDeCompras.get(descritorLista).finalizarListaDeCompras(localDaCompra, valorFinalDaCompra);
    }

    public String pesquisaCompraEmLista(String descritorLista, int itemId) {
        if (itemId < 1) throw new IllegalArgumentException("Erro na pesquisa de compra: item id invalido.");

        this.verificaDescritor(descritorLista, "Erro na pesquisa de compra");

        return this.listasDeCompras.get(descritorLista)
                .pesquisaCompraEmLista(this.pegaItem(itemId, "Erro na pesquisa de compra: "));
    }

    public void atualizaCompraDeLista(String descritorLista, int itemId, int quantidade, String operacao) {
        this.verificaDescritor(descritorLista, "Erro na atualizacao de compra");

        if (!(operacao.equals("adiciona") || (operacao.equals("diminui")))) {
            throw new IllegalArgumentException("Erro na atualizacao de compra: operacao invalida para atualizacao.");
        }

        this.listasDeCompras.get(descritorLista).atualizaCompraDeLista(operacao,
                this.pegaItem(itemId, "Erro na exclusao de compra: "), quantidade);

    }

    public String getItemLista(String descritorLista, int posicaoItem) {
        this.verificaDescritor(descritorLista, "Erro na pesquisa de compra");
        return this.listasDeCompras.get(descritorLista).getItemLista(posicaoItem);

    }

    public void deletaCompraDeLista(String descritorLista, int itemId) {
        this.verificaDescritor(descritorLista, "Erro na exclusao de compra");

        this.listasDeCompras.get(descritorLista)
                .deletaCompraDeLista(this.pegaItem(itemId, "Erro na exclusao de compra: "));
    }

    public String pesquisaListaDeCompras(String descritorLista) {
        this.verificaDescritor(descritorLista, "Erro na pesquisa de compra");

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

    private List<ListaDeCompras> getListasPorItem(int id) {
        if (id < 1) throw new IllegalArgumentException("Erro na pesquisa de compra: id nao pode ser menor que um");

        List<ListaDeCompras> listasComItem = new ArrayList<>();
        this.comparador = new ComparaDescritor();

        for (ListaDeCompras listaDeCompra : this.listasDeCompras.values()) {
            if (listaDeCompra.hasItem(id)) listasComItem.add(listaDeCompra);
        }

        listasComItem.sort(this.comparador);

        return listasComItem;

    }

    public String pesquisaListasDeComprasPorItem(int id) {
        StringBuilder saida = new StringBuilder();

        for (ListaDeCompras lista : this.getListasPorItem(id)) {
            saida.append(lista.getDescritorLista()).append(System.lineSeparator());
        }

        if ("".equals(saida.toString()))
            throw new NullPointerException("Erro na pesquisa de compra: compra nao encontrada na lista.");

        return saida.toString().trim();
    }

    public String getItemListaPorItem(int id, int posicaoLista) {
        if (posicaoLista < 0)
            throw new ArrayIndexOutOfBoundsException("Erro na pesquisa de compra: posicao nao pode ser menor que zero");

        return this.getListasPorItem(id).get(posicaoLista).toString();
    }

    private Item pegaItem(int id, String msg) {
        return this.controllerItem.pegaItem(id, msg);
    }

    private void verificaDescritor(String descritorLista, String erro) {
        if (descritorLista == null) {
            throw new NullPointerException(erro + ": descritor nao pode ser vazio ou nulo.");
        }

        if ("".equals(descritorLista.trim())) {
            throw new IllegalArgumentException(erro + ": descritor nao pode ser vazio ou nulo.");
        }

        if (!listasDeCompras.containsKey(descritorLista)) {
            throw new IllegalArgumentException(erro + ": lista de compras nao existe.");
        }
    }
}
