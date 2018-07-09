package facade;

import Controllers.Controller;
import easyaccept.EasyAccept;

/**
 * Laboratorio de Programacao 2 - Lista pra mim© Project
 * 
 * 
 * (colocar nomes em ordem alfabeticas)
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */
public class Facade {

	private Controller controller;

	public static void main(String[] args) {
		args = new String[] { "facade.Facade", "acceptance_tests/use_case1.txt",
				"acceptance_tests/use_case1_exception.txt" };

		EasyAccept.main(args);
	}

	public Facade() {
		this.controller = new Controller();
	}

	public int adicionaItemPorQtd(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra,
			double preco) {
		return this.controller.adicionaItemPorQtd(nome, categoria, qnt, unidadeDeMedida, localDeCompra, preco);
	}

	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		return this.controller.adicionaItemPorQuilo(nome, categoria, kg, localDeCompra, preco);
	}

	public int adicionaItemPorUnidade(String nome, String categoria, int qnt, String localDeCompra, double preco) {
		return this.controller.adicionaItemPorUnidade(nome, categoria, qnt, localDeCompra, preco);
	}

	public String exibeItem(int id) {
		return this.controller.exibeItem(id);
	}

	public void atualizaItem(int id, String atributo, String novoValor) {
		this.controller.atualizaItem(id, atributo, novoValor);
	}

	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		this.controller.adicionaPrecoItem(id, localDeCompra, preco);
	}

	public void deletaItem(int id) {
		this.controller.deletaItem(id);
	}

	public String getItem(int posicao) {
		return this.controller.getItem(posicao);
	}

	public String getItemPorCategoria(String categoria, int posicao) {
		return this.controller.getItemPorCategoria(categoria, posicao);
	}

	public String getItemPorMenorPreco(int posicao) {
		return this.controller.getItemPorMenorPreco(posicao);
	}

	public String getItemPorPesquisa(String strPesquisada, int posicao) {
		return this.controller.getItemPorPesquisa(strPesquisada, posicao);
	}

}
