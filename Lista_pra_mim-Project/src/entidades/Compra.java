package entidades;

import Enum.Categoria;

/**
 * Laboratório de Programação 2 - 2018.1
 *
 * @author Gustavo Luiz Bispo dos Santos - 117210400
 * @lab Lab0
 */
public class Compra {

	private int quantidade;
	private Item item;

	public Compra(int qnt, Item item) {
		if (qnt <= 0)
			throw new IllegalArgumentException("Erro na compra de item: quantidade invalida.");
		this.item = item;
		this.quantidade = qnt;
	}

	public void atualizaCompra(String operacao, int quantidade) {
		if (quantidade <= 0)
			throw new IllegalArgumentException("Erro na atualizacao de compra: quantidade invalida para atualizacao.");
		switch (operacao.trim().toLowerCase()) {
		case "adiciona":
			this.quantidade += quantidade;
			break;
		case "diminui":
			this.quantidade -= quantidade;
			break;
		}
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public Item getItem() {
		return this.item;
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
