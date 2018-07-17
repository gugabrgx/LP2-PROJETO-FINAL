package entidades;

/**
 * Laboratório de Programação 2 - 2018.1
 *
 * @author Gustavo Luiz Bispo dos Santos - 117210400
 * @lab Lab0
 */
public class Compras {

	private int quantidade;
	private Item item;

	public Compras(int qnt, Item item) {
		this.item = item;
		this.quantidade = qnt;
	}

	@Override
	public String toString() {
		return String.format("%d %s", this.quantidade, this.item);
	}

}
