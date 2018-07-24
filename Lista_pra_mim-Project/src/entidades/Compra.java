package entidades;

import Enum.Categoria;

/**
 * Laboratorio de Programacao 2 - 2018.1
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */
public class Compra {

	// Este atributo representa a quantidade de um item.
	private int quantidade;
	// Este atributo representa um objeto Item.
	private Item item;

	/**
	 * Constroi o objeto Compras.
	 * 
	 * @param qnt  A quantidade do item.
	 * @param item O item a ser comprado.
	 */
	public Compra(int qnt, Item item) {
		if (qnt <= 0)
			throw new IllegalArgumentException("Erro na compra de item: quantidade invalida.");
		this.item = item;
		this.quantidade = qnt;
	}

	/**
	 * Este atributo atualiza a quantidade de compra de um item.
	 * 
	 * @param operacao   A operacao a ser feita, adiciona ou diminui.
	 * @param quantidade A quantidade do item a ser acrescida ou diminuida.
	 */
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
		default:
			throw new IllegalArgumentException("Erro na atualizacao de compra: operacao invalida para atualizacao.");
		}
	}

	/**
	 * Metodo acessorio que retorna a quantidade de um item.
	 * 
	 * @return Um inteiro que representa a quantidade de um item.
	 */
	public int getQuantidade() {
		return this.quantidade;
	}

	/**
	 * Metodo acessorio que retorna um item.
	 * 
	 * @return Um objeto do tipo item.
	 */
	public Item getItem() {
		return this.item;
	}

	/**
	 * Metodo acessorio que retorna a categoria do item.
	 * 
	 * @return A categoria do item.
	 */
	public Categoria getItemCategoria() {
		return item.getCategoria();
	}

	/**
	 * Metodo acessorio que retorna a descricao do item.
	 * 
	 * @return em String a descricao de um determinado item.
	 */
	public String getItemDescricao() {
		return item.getDescricao();
	}

	/**
	 * Metodo que retorna a representacao em String de uma compra.
	 */
	@Override
	public String toString() {
		return String.format("%d %s", this.quantidade, this.item.getDescricao());
	}

}