package entidades;

/**
 * 
 * Laboratorio de Programacaoo 2 - Lista pra mim© Project
 *
 * Classe que representa um Item comercializado por quilo. Este tipo de item
 * base possui nome, categoria, peso e precos. Nesta classe e possivel crir um
 * item, adicionar um preco a um item, recuperar o nome do item, recuperar a
 * categoria de um item, etc.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */

public class ItemPorQuilo extends Item {

	/**
	 * Double que representa o peso do item;
	 */
	private double kg;

	/**
	 * Método que cria um item comercializado por quilo.
	 *
	 * @param nome
	 *            String que representa o nome do item;
	 * @param categoria
	 *            String que representa a categoria do item;
	 * @param kg
	 *            Double que representa o peso do item;
	 * @param localDeCompra
	 *            String que representa o local de compra do produto;
	 * @param preco
	 *            Double que representa o valor de compra do produto.
	 * @param id
	 *            Identtficacao unica do item.
	 */
	public ItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco, int id) {
		super(nome, categoria, localDeCompra, preco, id);

		if (kg < 0)
			throw new IllegalArgumentException(
					"Erro no cadastro de item: valor de quilos nao pode ser menor que zero.");

		this.kg = kg;
	}

	/**
	 * Metodo que atualiza os dados de um item de acordo com o solicitado pelo
	 * usuario.
	 *
	 * @param atributo
	 *            Uma String que representa o atributo que sera atualizado.
	 * @param novoValor
	 *            Uma String que representa o novo valor para o atributo.
	 */
	@Override
	public void atualizaItem(String atributo, String novoValor) {
		super.atualizaItem(atributo, novoValor);

		switch (atributo.trim().toLowerCase()) {
		case "nome":
		case "categoria":
			break;

		case "kg":
			double kg = Double.parseDouble(novoValor);

			if (kg < 0)
				throw new IllegalArgumentException(
						"Erro na atualizacao de item: valor de quilos nao pode ser menor que zero.");
			this.kg = kg;
			break;

		default:
			throw new IllegalArgumentException("Erro na atualizacao de item: atributo nao existe.");
		}
	}

	/**
	 * Metodo que retorna uma string contendo nome e categoria de um item.
	 *
	 * @return Uma String contendo nome e categoria de um item.
	 */
	public String toString() {
		return String.format("%s Preco por quilo: %s", super.toString(), super.getListaPrecos());
	}

}
