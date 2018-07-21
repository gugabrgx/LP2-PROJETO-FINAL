package Controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import entidades.Item;
import entidades.ItemPorQuilo;
import entidades.ItemPorUnidade;

/**
 * 
 *
 * @author Gustavo Santos - 117210400
 * 
 */
public class ControllerListaTest {

	// Instanciação de um Objeto ControllerItem.
	private ControllerItem cItem;
	// Instanciação de um Objeto ControllerLista.
	private ControllerLista cLista, outraCLista;
	// Instanciação de um Objeto Item.
	private Item itemPQ, itemPU;
	
	/**
	 * Metodo que inicializa objetos.
	 * 
	 * Nenhum erro esperado.
	 */
	@Before
	public void inicializa() {
		cItem = new ControllerItem();
		cLista = new ControllerLista(cItem);
		cLista.adicionaListaDeCompras("Feira Semanal");
		itemPU = new ItemPorUnidade("Creme dental Oral-C", "higiene pessoal", 3, "Mercadinho Bem Barato", 3.79, 2);
		itemPQ = new ItemPorQuilo("Peito de peru Saara", "alimento industrializado", 1.0, "Mercadinho Bem Barato", 34.49, 1);
	}

	/**
	 * Metodo que testa o metodo construtor de ControllerLista.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testControllerLista() {
		assertTrue(outraCLista == null);
		outraCLista = new ControllerLista(cItem);
		assertTrue(outraCLista != null);
	}

	/**
	 * Metodo que testa o metodo adicionaListaDeCompras com parametros validos.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testAdicionaListaDeComprasValido() {
		cLista.adicionaListaDeCompras("Feira Semanalal");
		cLista.adicionaListaDeCompras("Feira Semanalal");

	}

	/**
	 * Metodo que testa o metodo adicionaListaDeCompras com parametros invalidos.
	 * 
	 * Esperado NullPointerException
	 */
	@Test (expected = NullPointerException.class)
	public void testAdicionaListaDeComprasInvalido1() {
		cLista.adicionaListaDeCompras(null);
	}
	
	/**
	 * Metodo que testa o metodo adicionaListaDeCompras com parametros invalidos.
	 * 
	 * Esperado IllegalArgumentException
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testAdicionaListaDeComprasInvalido2() {
		cLista.adicionaListaDeCompras("");
	}
	
	/**
	 * Metodo que testa o metodo adicionaCompraALista com parametros validos.
	 * 
	 * Nenhum erro encontrado.
	 */
	@Test
	public void testAdicionaCompraALista() {
		cLista.adicionaCompraALista("Feira Semanal", 1, 1);
	}

	
	
	
	
	@Test
	public void testFinalizarListaDeCompras() {
		fail("Not yet implemented");
	}

	
	
	
	@Test
	public void testPesquisaCompraEmLista() {
		fail("Not yet implemented");
	}

	
	
	
	@Test
	public void testAtualizaCompraDeLista() {
		fail("Not yet implemented");
	}

	
	
	
	
	@Test
	public void testGetItemLista() {
		fail("Not yet implemented");
	}

	
	
	
	@Test
	public void testDeletaCompraDeLista() {
		fail("Not yet implemented");
	}

	
	
	
	@Test
	public void testPesquisaListaDeCompras() {
		fail("Not yet implemented");
	}

	
	
	
	@Test
	public void testPesquisaListasDeComprasPorItem() {
		fail("Not yet implemented");
	}

	
	
	
	@Test
	public void testPesquisaListasDeComprasPorData() {
		fail("Not yet implemented");
	}

	
	
	
	@Test
	public void testGetItemListaPorData() {
		fail("Not yet implemented");
	}

	
	
	
	@Test
	public void testGetItemListaPorItem() {
		fail("Not yet implemented");
	}

}
