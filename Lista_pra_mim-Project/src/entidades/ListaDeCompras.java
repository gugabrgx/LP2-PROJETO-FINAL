package entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;

import Comparators.ComparaCompras;

/**
 * Laboratório de Programação 2 - 2018.1
 *
 * @author Gustavo Luiz Bispo dos Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 */
public class ListaDeCompras {

    private Date horario = new Date();
    private HashSet<Compra> compras;
    private boolean aberto;
    private String descritorLista;
    private String data;
    private String hora;
    private String localDaCompra;
    private int precoTotal;
    private int maiorId;
    private Comparator<Compra> comparaCompras;

    public ListaDeCompras(String descritorLista) {
        if (descritorLista == null)
            throw new NullPointerException(
                    "Erro na criacao de lista de compras: descritor nao pode ser vazio ou nulo.");
        if (descritorLista.trim().isEmpty())
            throw new IllegalArgumentException(
                    "Erro na criacao de lista de compras: descritor nao pode ser vazio ou nulo.");
        this.descritorLista = descritorLista;
        this.data = new SimpleDateFormat("dd/MM/yyyy").format(horario);
        this.hora = new SimpleDateFormat("HH:mm:ss").format(horario);
        this.aberto = true;
        this.compras = new HashSet<>();
        this.comparaCompras = new ComparaCompras();
    }

    public void adicionaCompraALista(int quantidade, Item item) {
        if (!aberto)
            throw new IllegalArgumentException("Erro na compra de item: lista ja finalizada.");
        Compra compra = new Compra(quantidade, item);
        compras.add(compra);
        if (item.getId() > maiorId)
            maiorId = item.getId();
    }

    public void finalizarListaDeCompras(String localDaCompra, int valorFinalDaCompra) {
        if (!aberto)
            throw new IllegalArgumentException("Erro na finalizacao de lista de compras: lista ja finalizada");
        if (localDaCompra == null)
            throw new NullPointerException(
                    "Erro na finalizacao de lista de compras: local nao pode ser vazio ou nulo.");
        if (localDaCompra.trim().isEmpty())
            throw new IllegalArgumentException(
                    "Erro na finalizacao de lista de compras: local nao pode ser vazio ou nulo.");
        if (valorFinalDaCompra <= 0)
            throw new IllegalArgumentException(
                    "Erro na finalizacao de lista de compras: valor final da lista invalido.");
        this.localDaCompra = localDaCompra;
        this.precoTotal = valorFinalDaCompra;
        this.aberto = false;
    }

    public String pesquisaCompraEmLista(Item item) {
        for (Compra compra : compras) {
            if (compra.getItem() == item) {
                return compra.toString();
            }
        }
        throw new IllegalArgumentException("Erro na pesquisa de compra: compra nao encontrada na lista.");
    }

    public void atualizaCompraDeLista(String operacao, Item item, int quantidade) {
        if (!aberto)
            throw new IllegalArgumentException("Erro na atualizacao de compra: lista ja finalizada");
        if (!hasItem(item.getId()))
            throw new IllegalArgumentException("Erro na atualizacao de compra: compra nao encontrada na lista.");
        for (Compra compra : compras) {
            if (compra.getItem().equals(item)) {
                compra.atualizaCompra(operacao, quantidade);
                if (compra.getQuantidade() <= 0)
                    compras.remove(compra);
                break;
            }
        }
    }

    public void deletaCompraDeLista(Item item) {
        if (!aberto)
            throw new IllegalArgumentException("Erro na exclusao de compra: lista ja finalizada");
        if (item.getId() > maiorId)
            throw new IllegalArgumentException("Erro na exclusao de compra: item nao existe no sistema.");
        if (!hasItem(item.getId()))
            throw new IllegalArgumentException("Erro na exclusao de compra: compra nao encontrada na lista.");
        for (Compra compra : compras) {
            if (compra.getItem() == item) {
                compras.remove(compra);
                break;
            }
        }

    }

    public boolean getAberto() {
        return this.aberto;
    }

    public String getDescritorLista() {
        return this.descritorLista;
    }

    public String getData() {
        return this.data;
    }

    public String getHora() {
        return this.hora;
    }

    public String getLocalDeCompra() {
        return this.localDaCompra;
    }

    public int getPrecoTotal() {
        return this.precoTotal;
    }

    public String getItemLista(int posicaoItem) {
        if (posicaoItem < 0)
            throw new ArrayIndexOutOfBoundsException("Erro no cadastro de preco: id de item invalido.");
        ArrayList<Compra> comprasOrdenadas = new ArrayList<>(this.compras);

        if (comprasOrdenadas.size() <= posicaoItem) {
            return "";
        }

        Collections.sort(comprasOrdenadas, comparaCompras);
        return comprasOrdenadas.get(posicaoItem).toString();
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.data, this.descritorLista);
    }

    public boolean hasItem(int id) {
        for (Compra compra : compras) {
            if (compra.getItem().getId() == id) return true;
        }
        return false;
    }
}
