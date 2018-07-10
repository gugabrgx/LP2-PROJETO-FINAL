package ControllerTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Controllers.Controller;
import entidades.Item;
import entidades.ItemPorQuantidadeFixa;

/**
 * 
 * Laboratório de Programação 2 - Lista pra mim© Project
 *
 * Classe que testa os metodos da classe Controller.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */
public class ControllerTest {

	// Instanciacao de objetos do tipo Controller.
	private Controller controller, outroController;
	// Instanciacao de um objeto Item
	private Item item;
	
	/**
	 * Metodo que inicializa o Controller.
	 * 
	 * Nenhum erro esperado.
	 */
	@Before
	public void inicializa() {
		this.controller = new Controller();
	}
	
	/**
	 * Metodo que testa o metodo construtor de um Controller.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testController() {
		assertTrue(outroController == null);
		outroController = new Controller();
		assertTrue(outroController != null);
	}

	/**
	 * Metodo que testa o metodo adicionaItemPorQtd.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testAdicionaItemPorQtdValido() {
		assertTrue(controller.getItem(1) == null);
		this.controller.adicionaItemPorQtd("Agua Sanitaria Drogon", "limpeza", 1, "l", "Supermercado Excepcional", 2.19);
		assertTrue(controller.getItem(1) != null);
	}

	/**
	 * Metodo que testa o metodo adicionaItemPorQtd.
	 * 
	 * Esperado IllegalArgumentException
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testAdicionaItemPorQtdJaCadastrado() {
		this.controller.adicionaItemPorQtd("Agua Sanitaria Drogon", "limpeza", 1, "l", "Supermercado Excepcional", 2.19);
		this.controller.adicionaItemPorQtd("Agua Sanitaria Drogon", "limpeza", 2, "ml", "Supermercado Excepcional", 2.20);
	}
	
	
	
	
	@Test
	public void testAdicionaItemPorQuilo() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdicionaItemPorUnidade() {
		fail("Not yet implemented");
	}

	@Test
	public void testExibeItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testAtualizaItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdicionaPrecoItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeletaItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetItemPorCategoria() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetItemPorMenorPreco() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetItemPorPesquisa() {
		fail("Not yet implemented");
	}

}
