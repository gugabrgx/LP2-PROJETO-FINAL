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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compras other = (Compras) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%d %s", this.quantidade, this.item.getDescricao());
	}

}
