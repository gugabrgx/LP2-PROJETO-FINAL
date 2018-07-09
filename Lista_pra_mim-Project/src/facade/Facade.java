package facade;

import Controllers.Controller;
import easyaccept.EasyAccept;

/**
 * Laboratório de Programação 2 - Lista pra mim© Project
 * 
 * 
 * (colocar nomes em ordem alfabeticas)
 * @author Eduardo Henrique Pontes Silva - 117210360 
 * @author Gustavo Santos - 117210400
 */
public class Facade {

	// Instanciacao de um Objeto Controller.

	private Controller controller = new Controller();

	public static void main(String[] args) {
		args = new String[] { "facade.Facade", "acceptance_tests/use_case1.txt",  "acceptance_tests/use_case1_exception.txt"};

		EasyAccept.main(args);
	}

	public int adicionaItemPorQtd(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra, double preco) {
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

}
