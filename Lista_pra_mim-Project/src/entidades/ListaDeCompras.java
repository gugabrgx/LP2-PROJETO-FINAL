package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

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

	public ListaDeCompras(String descritorLista) {
		this.descritorLista = descritorLista;
		this.data = new SimpleDateFormat("dd/MM/yyyy").format(horario);
		this.hora = new SimpleDateFormat("HH:mm:ss").format(horario);
		this.aberto = true;
		this.compras = new HashSet<>();
	}

	public void adicionaCompraALista(int quantidade, Item item) {
		Compras compra = new Compras(quantidade, item);
		compras.add(compra);
	}

	public void finalizarListaDeCompras(String localDaCompra, int valorFinalDaCompra) {
		if (aberto == false)
			throw new IllegalArgumentException("Erro na finalizacao de lista de compras: lista ja finalizada");
		this.localDaCompra = localDaCompra;
		this.precoTotal = valorFinalDaCompra;
		this.aberto = false;
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

	@Override
	public String toString() {
		return String.format("%s %s", this.descritorLista, this.data);
	}

}
