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
 * @lab Lab0
 */
public class ListaDeCompras {

	private Date horario = new Date();
	private HashSet<Compras> compras;
	private boolean aberto;
	private String descritorLista;
	private String data;
	private String hora;
	private String localDaCompra;
	private int precoTotal;
	private int maiorId;
	private Comparator<Compras> comparaCompras;

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
		if (aberto == false)
			throw new IllegalArgumentException("Erro na compra de item: lista ja finalizada.");
		Compras compra = new Compras(quantidade, item);
		compras.add(compra);
		if (item.getId() > maiorId)
			maiorId = item.getId();
	}

	public void finalizarListaDeCompras(String localDaCompra, int valorFinalDaCompra) {
		if (aberto == false)
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
		for (Compras compra : compras) {
			if (compra.getItem() == item) {
				return compra.toString();
			}
		}
		throw new IllegalArgumentException("Erro na pesquisa de compra: compra nao encontrada na lista.");
	}

	public void atualizaCompraDeLista(String operacao, Item item, int quantidade) {
		if (aberto == false)
			throw new IllegalArgumentException("Erro na atualizacao de compra: lista ja finalizada");
		boolean teste = true;
		for (Compras compra : compras) {
			if (compra.getItem().equals(item)) {
				teste = false;
				break;
			}
		}
		if (teste)
			throw new IllegalArgumentException("Erro na atualizacao de compra: compra nao encontrada na lista.");
		for (Compras compra : compras) {
			if (compra.getItem().equals(item)) {
				compra.atualizaCompra(operacao, quantidade);
				if (compra.getQuantidade() <= 0)
					compras.remove(compra);
				break;
			}
		}
	}

	public void deletaCompraDeLista(Item item) {
		if (aberto == false)
			throw new IllegalArgumentException("Erro na exclusao de compra: lista ja finalizada");
		if (item.getId() > maiorId)
			throw new IllegalArgumentException("Erro na exclusao de compra: item nao existe no sistema.");
		boolean teste = true;
		for (Compras compra : compras) {
			if (compra.getItem().equals(item)) {
				teste = false;
				break;
			}
		}
		if (teste)
			throw new IllegalArgumentException("Erro na exclusao de compra: compra nao encontrada na lista.");
		for (Compras compra : compras) {
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
		ArrayList<Compras> comprasOrdenados = new ArrayList<>(this.compras);

		if (comprasOrdenados.size() <= posicaoItem) {
			return "";
		}

		Collections.sort(comprasOrdenados, comparaCompras);
		return comprasOrdenados.get(posicaoItem).toString();
	}

	@Override
	public String toString() {
		return String.format("%s %s", this.data, this.descritorLista);
	}

}
