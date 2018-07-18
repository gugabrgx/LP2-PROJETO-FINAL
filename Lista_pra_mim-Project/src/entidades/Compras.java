package entidades;

import Enum.Categoria;

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

	public Categoria getItemCategoria() {
		return item.getCategoria();
	}
	
	public String getItemDescricao() {
		return item.getDescricao();
	}

	@Override
	public String toString() {
		return String.format("%d %s", this.quantidade, this.item.getDescricao());
	}

}
