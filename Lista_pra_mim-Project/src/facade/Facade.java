package facade;

import Controllers.Controller;
import easyaccept.EasyAccept;

/**
 * Laboratório de Programação 2 - Lista pra mim© Project
 * 
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */
public class Facade {
	/**
	 * Este atributo representa o objeto Controller.
	 */
	private Controller controller;

	public static void main(String[] args) {
		args = new String[] { "facade.Facade", "acceptance_tests/use_case1.txt",
				"acceptance_tests/use_case1_exception.txt", "acceptance_tests/use_case2.txt",
				"acceptance_tests/use_case2_exception.txt" };

		EasyAccept.main(args);
	}

	/**
	 * Constroi o objeto Facade, e inicializa o objeto Controller.
	 */
	public Facade() {
		this.controller = new Controller();
	}

	/**
	 * Metodo que cria e adiciona um novo ItemPorQuantidade a uma lista que contem
	 * todos os itens.
	 *
	 * @param nome
	 *            Uma String que representa o nome do produto.
	 * @param categoria
	 *            Uma String que representa a categoria do item.
	 * @param qnt
	 *            Um inteiro que representa a quantidade de produtos que se
	 *            encontram na embalagem do item.
	 * @param unidadeDeMedida
	 *            Uma String que representa a unidade de medida do produto (gramas,
	 *            litros, etc.).
	 * @param localDeCompra
	 *            Uma String que representa onde o item foi comprado.
	 * @param preco
	 *            Um double que representa o valor do produto.
	 * @return Um inteiro que representa o identificador do produto.
	 */
	public int adicionaItemPorQtd(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra,
			double preco) {
		return this.controller.adicionaItemPorQtd(nome, categoria, qnt, unidadeDeMedida, localDeCompra, preco);
	}

	/**
	 * Metodo que cria e adiciona um novo ItemPorQuilo a uma lista que contem todos
	 * os itens.
	 *
	 * @param nome
	 *            Uma String que representa o nome do produto.
	 * @param categoria
	 *            Uma String que representa a categoria do item.
	 * @param kg
	 *            Um double que representa o peso do item.
	 * @param localDeCompra
	 *            Uma String que representa onde o item foi comprado.
	 * @param preco
	 *            Um double que representa o valor do produto.
	 * @return Um inteiro que representa o identificador do produto.
	 */
	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		return this.controller.adicionaItemPorQuilo(nome, categoria, kg, localDeCompra, preco);
	}

	/**
	 * Metodo que cria e adiciona um novo ItemPorUnidade a uma lista que contem
	 * todos os itens.
	 *
	 * @param nome
	 *            Uma String que representa o nome do produto.
	 * @param categoria
	 *            Uma String que representa a categoria do item.
	 * @param qnt
	 *            Um inteiro que representa a quantidade de produtos que se
	 *            encontram na embalagem do item.
	 * @param localDeCompra
	 *            Uma String que representa onde o item foi comprado.
	 * @param preco
	 *            Um double que representa o valor do produto.
	 * @return Um inteiro que representa o identificador do produto.
	 */
	public int adicionaItemPorUnidade(String nome, String categoria, int qnt, String localDeCompra, double preco) {
		return this.controller.adicionaItemPorUnidade(nome, categoria, qnt, localDeCompra, preco);
	}

	/**
	 * Metodo que retorna uma String contendo a exibicao de um item.
	 *
	 * @param id
	 *            Um inteiro que representa o identificador de um item.
	 * @return Uma String que contem a exibicao de um item.
	 */
	public String exibeItem(int id) {
		return this.controller.exibeItem(id);
	}

	/**
	 * Metodo que atualiza o atributo de um item passando um novo valor para o
	 * atributo.
	 *
	 * @param id
	 *            Um inteiro que representa o identificador unico de um item.
	 * @param atributo
	 *            Uma String que representa o atributo a ser modificado.
	 * @param novoValor
	 *            Uma String que representa o novo valor para o item.
	 * 
	 *            Este metodo nao retorna nenhum valor.
	 */
	public void atualizaItem(int id, String atributo, String novoValor) {
		this.controller.atualizaItem(id, atributo, novoValor);
	}

	/**
	 * Metodo que adiciona um preco a um item.
	 *
	 * @param id
	 *            Um inteiro que representa o identificador de um item.
	 * @param localDeCompra
	 *            Uma String que representa o local de compra do item.
	 * @param preco
	 *            Um double que representa o valor do preco que será adicionado.
	 * 
	 *            Este método não retorna nenhum valor.
	 */
	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		this.controller.adicionaPrecoItem(id, localDeCompra, preco);
	}

	/**
	 * Metodo que remove um item a partir de seu id.
	 *
	 * @param id
	 *            Um inteiro que representa o identificador de um item.
	 * 
	 *            Este metodo nao retorna nenhum valor.
	 */
	public void deletaItem(int id) {
		this.controller.deletaItem(id);
	}

	/**
	 * Metodo que ordena os itens por ordem alfabetica..
	 * 
	 * @param posicao
	 *            A posicao em que o item esta posicionado ordenadamente.
	 * @return Uma String que contem a exibicao de um item.
	 */
	public String getItem(int posicao) {
		return this.controller.getItem(posicao);
	}

	/**
	 * Metodo que ordena os itens por categoria.
	 * 
	 * @param posicao
	 *            A posicao em que o item esta posicionado ordenadamente.
	 * @return Uma String que contem a exibicao de um item.
	 */
	public String getItemPorCategoria(String categoria, int posicao) {
		return this.controller.getItemPorCategoria(categoria, posicao);
	}

	/**
	 * Metodo que ordena os itens por preco.
	 * 
	 * @param posicao
	 *            A posicao em que o item esta posicionado ordenadamente.
	 * @return Uma String que contem a exibicao de um item.
	 */
	public String getItemPorMenorPreco(int posicao) {
		return this.controller.getItemPorMenorPreco(posicao);
	}

	/**
	 * Metodo que ordena os itens relacionados a uma dada string de pesquisa e a
	 * listagem deve ocorrer em ordem alfabética considerando a representação em
	 * string do item.
	 * 
	 * @param posicao
	 *            A posicao em que o item esta posicionado ordenadamente.
	 * @return Uma String que contem a exibicao de um item.
	 */
	public String getItemPorPesquisa(String strPesquisada, int posicao) {
		return this.controller.getItemPorPesquisa(strPesquisada, posicao);
	}

}
