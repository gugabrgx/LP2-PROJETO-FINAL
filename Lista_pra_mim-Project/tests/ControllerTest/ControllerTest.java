package ControllerTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Controllers.Controller;
import entidades.Item;

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
		this.controller.adicionaItemPorQtd("Agua Sanitaria Drogon", "limpeza", 1, "l", "Supermercado Excepcional", 2.19);
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
		this.controller.adicionaItemPorQtd("Agua Sanitaria Dragon", "limpeza", 1, "l", "Supermercado Excepcional", 2.19);
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

	/**
	 * Metodo que testa o metodo adicionaItemPorQuilo.
	 *
	 * Nenhum erro esperado.
	 */
	@Test
	public void testAdicionaItemPorQuiloValido() {
		this.controller.adicionaItemPorQuilo("Peito de peru Saara", "alimento industrializado", 1.0, "Mercadinho Bem Barato", 34.49);
	}

	/**
	 * Metodo que testa o metodo adicionaItemPorQuilo.
	 *
	 * Esperado IllegalArgumentException
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testAdicionaItemPorQuiloJaCadastrado() {
		this.controller.adicionaItemPorQuilo("Peito de peru Saara", "alimento industrializado", 1.0, "Mercadinho Bem Barato", 34.49);
		this.controller.adicionaItemPorQuilo("Peito de peru Saara", "alimento industrializado", 2.0, "Mercadinho Bem Barato", 34.49);
	}

	/**
	 * Metodo que testa o metodo adicionaItemPorUnidade.
	 *
	 * Nenhum erro esperado.
	 */
	@Test
	public void testAdicionaItemPorUnidadeValido() {
		this.controller.adicionaItemPorUnidade("Creme dental Oral-C", "higiene pessoal", 3, "Mercadinho Bem Barato", 3.79);
	}

	/**
	 * Metodo que testa o metodo adicionaItemPorUnidade.
	 *
	 * Esperado IllegalArgumentException
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testAdicionaItemPorUnidadeJaCadastrado() {
		this.controller.adicionaItemPorUnidade("Creme dental Oral-C", "higiene pessoal", 3, "Mercadinho Bem Barato", 3.79);
		this.controller.adicionaItemPorUnidade("Creme dental Oral-C", "higiene pessoal", 8, "Mercadinho Bem Barato", 3.79);
	}

	/**
	 * Metodo que testa o metodo exibeItem.
	 *
	 * Nenhum erro esperado.
	 */
	@Test
	public void testExibeItemValido() {
		assertEquals("1. Agua Sanitaria Drogon, limpeza, 1 l, Preco: <Supermercado Excepcional, R$ 2,19;>", controller.exibeItem(1));
	}

	/**
	 * Metodo que testa o metodo exibeItem.
	 *
	 * Esperado ArrayIndexOutOfBoundsException
	 */
	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void testExibeItemInvalido1() {
		controller.exibeItem(0);
	}

	/**
	 * Metodo que testa o metodo exibeItem.
	 *
	 * Esperado ArrayIndexOutOfBoundsException
	 */
	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void testExibeItemInvalido2() {
		controller.exibeItem(-1);
	}

	/**
	 * Metodo que testa o metodo exibeItem.
	 *
	 * Esperado NullPointerException
	 */
	@Test (expected = NullPointerException.class)
	public void testExibeItemInvalido3() {
		controller.exibeItem(12);
	}

	/**
	 * Metodo que testa o metodo atualizaItem.
	 *
	 * Nenhum erro esperado.
	 */
	@Test
	public void testAtualizaItemValido() {
		assertEquals("1. Agua Sanitaria Drogon, limpeza, 1 l, Preco: <Supermercado Excepcional, R$ 2,19;>", controller.exibeItem(1));
		controller.atualizaItem(1, "nome", "Agua Sanitaria Viserion");
		assertEquals("1. Agua Sanitaria Viserion, limpeza, 1 l, Preco: <Supermercado Excepcional, R$ 2,19;>", controller.exibeItem(1));
	}

	/**
	 * Metodo que testa o metodo atualizaItem.
	 *
	 * Esperado IllegalArgumentException
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testAtualizaItemInvalido1() {
		controller.atualizaItem(1, "", "Agua Sanitaria Viserion");
	}

	/**
	 * Metodo que testa o metodo atualizaItem.
	 *
	 * Esperado NullPointerException
	 */
	@Test (expected = NullPointerException.class)
	public void testAtualizaItemInvalido2() {
		controller.atualizaItem(1, null, "Agua Sanitaria Viserion");
	}

	/**
	 * Metodo que testa o metodo atualizaItem.
	 *
	 * Esperado IllegalArgumentException
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testAtualizaItemInvalido3() {
		controller.atualizaItem(1, "nome", "");
	}

	/**
	 * Metodo que testa o metodo atualizaItem.
	 *
	 * Esperado NullPointerException
	 */
	@Test (expected = NullPointerException.class)
	public void testAtualizaItemInvalido4() {
		controller.atualizaItem(1, "nome", null);
	}

	/**
	 * Metodo que testa o metodo atualizaItem.
	 *
	 * Esperado ArrayIndexOutOfBoundsException
	 */
	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void testAtualizaItemInvalido5() {
		controller.atualizaItem(0, "nome", "Agua Sanitaria Viserion");
	}

	/**
	 * Metodo que testa o metodo atualizaItem.
	 *
	 * Esperado ArrayIndexOutOfBoundsException
	 */
	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void testAtualizaItemInvalido6() {
		controller.atualizaItem(-1, "nome", "Agua Sanitaria Viserion");
	}

	/**
	 * Metodo que testa o metodo atualizaItem.
	 *
	 * Esperado NullPointerException
	 */
	@Test (expected = NullPointerException.class)
	public void testAtualizaItemInvalido7() {
		controller.atualizaItem(12, "nome", "Agua Sanitaria Viserion");
	}

	/**
	 * Metodo que testa o metodo adicionaPrecoItem.
	 *
	 * Nenhum erro esperado.
	 */
	@Test
	public void testAdicionaPrecoItemValido() {
		assertEquals("1. Agua Sanitaria Drogon, limpeza, 1 l, Preco: <Supermercado Excepcional, R$ 2,19;>", controller.exibeItem(1));
		controller.adicionaPrecoItem(1, "Supermercado UauMart", 3.69);
		assertEquals("1. Agua Sanitaria Drogon, limpeza, 1 l, Preco: <Supermercado UauMart, R$ 3,69;Supermercado Excepcional, R$ 2,19;>", controller.exibeItem(1));
	}

	/**
	 * Metodo que testa o metodo adicionaPrecoItem.
	 *
	 * Esperado ArrayIndexOutOfBoundsException
	 */
	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void testAdicionaPrecoItemInvalido1() {
		controller.adicionaPrecoItem(0, "Supermercado UauMart", 3.69);
	}

	/**
	 * Metodo que testa o metodo adicionaPrecoItem.
	 *
	 * Esperado ArrayIndexOutOfBoundsException
	 */
	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void testAdicionaPrecoItemInvalido2() {
		controller.adicionaPrecoItem(-1, "Supermercado UauMart", 3.69);
	}

	/**
	 * Metodo que testa o metodo adicionaPrecoItem.
	 *
	 * Esperado NullPointerException
	 */
	@Test (expected = NullPointerException.class)
	public void testAdicionaPrecoItemInvalido3() {
		controller.adicionaPrecoItem(12, "Supermercado UauMart", 3.69);
	}

	/**
	 * Metodo que testa o metodo deletaItem.
	 *
	 * Esperado NullPointerException
	 */
	@Test (expected = NullPointerException.class)
	public void testDeletaItemValido() {
		assertEquals("1. Agua Sanitaria Drogon, limpeza, 1 l, Preco: <Supermercado Excepcional, R$ 2,19;>", controller.exibeItem(1));
		controller.deletaItem(1);
		controller.exibeItem(1);
	}

	/**
	 * Metodo que testa o metodo deletaItem.
	 *
	 * Esperado ArrayIndexOutOfBoundsException
	 */
	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void testDeletaItemInvalido1() {
		assertEquals("1. Agua Sanitaria Drogon, limpeza, 1 l, Preco: <Supermercado Excepcional, R$ 2,19;>", controller.exibeItem(1));
		controller.deletaItem(0);
	}

	/**
	 * Metodo que testa o metodo deletaItem.
	 *
	 * Esperado ArrayIndexOutOfBoundsException
	 */
	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void testDeletaItemInvalido2() {
		assertEquals("1. Agua Sanitaria Drogon, limpeza, 1 l, Preco: <Supermercado Excepcional, R$ 2,19;>", controller.exibeItem(1));
		controller.deletaItem(-1);
	}

	/**
	 * Metodo que testa o metodo deletaItem.
	 *
	 * Esperado IllegalArgumentException
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testDeletaItemInvalido3() {
		assertEquals("1. Agua Sanitaria Drogon, limpeza, 1 l, Preco: <Supermercado Excepcional, R$ 2,19;>", controller.exibeItem(1));
		controller.deletaItem(12);
	}

	/**
	 * Metodo que testa o metodo getItem.
	 *
	 * Nenhum erro esperado.
	 */
	@Test
	public void testGetItemValido() {
		fail("Not yet implemented");
	}

	/**
	 * Metodo que testa o metodo getItem.
	 *
	 * Esperado IllegalArgumentException
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testGetItemInvalido1() {
		fail("Not yet implemented");
	}

	/**
	 * Metodo que testa o metodo getItemPorCategoria.
	 *
	 * Nenhum erro esperado.
	 */
	@Test
	public void testGetItemPorCategoriaValido() {
		fail("Not yet implemented");
	}

	/**
	 * Metodo que testa o metodo getItemPorCategoria.
	 *
	 * Esperado IllegalArgumentException
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testGetItemPorCategoriaInvalido1() {
		fail("Not yet implemented");
	}

	/**
	 * Metodo que testa o metodo getItemPorMenorPreco.
	 *
	 * Nenhum erro esperado.
	 */
	@Test
	public void testGetItemPorMenorPrecoValido() {
		fail("Not yet implemented");
	}

	/**
	 * Metodo que testa o metodo getItemPorMenorPreco.
	 *
	 * Esperado IllegalArgumentException
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testGetItemPorMenorPrecoInvalido1() {
		fail("Not yet implemented");
	}

	/**
	 * Metodo que testa o metodo getItemPorPesquisa.
	 *
	 * Nenhum erro esperado.
	 */
	@Test
	public void testGetItemPorPesquisaValido() {
		fail("Not yet implemented");
	}

	/**
	 * Metodo que testa o metodo getItemPorPesquisa.
	 *
	 * Esperado IllegalArgumentException
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testGetItemPorPesquisaInvalido1() {
		fail("Not yet implemented");
	}

}