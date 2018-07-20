package entidades;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Gustavo Luiz Bispo dos Santos - 117210400
 */

public class ListaDeComprasTest {

	// Instanciação de um Objeto ListaDeCompras.
	private ListaDeCompras lista, outraLista;
	// Instanciacao de um Objeto item.
	private Item itemPU, itemPQ;
	
	/**
	 * Metodo que inicializa uma lista e um item.
	 * 
	 * Nenhum erro esperado.
	 */
	@Before
	public void inicializa() {
		lista = new ListaDeCompras("Feira Semanal");
		itemPU = new ItemPorUnidade("Creme dental Oral-C", "higiene pessoal", 3, "Mercadinho Bem Barato", 3.79, 3);
		itemPQ = new ItemPorQuilo("Peito de peru Saara", "alimento industrializado", 1.0, "Mercadinho Bem Barato", 34.49, 2);

	}
	
	/**
	 * Metodo que testa o metodo construtor de uma ListaDeCompras com 
	 * parametros validos.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testListaDeComprasValido() {
		assertTrue(outraLista == null);
		outraLista = new ListaDeCompras("Feira Semanal");
		assertTrue(outraLista != null);
	}

	/**
	 * Metodo que testa o metodo construtor de uma ListaDeCompras com 
	 * parametros invalidos.
	 * 
	 * Esperado IllegalArgumentException
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testListaDeComprasInvalido1() {
		lista = new ListaDeCompras("");
	}
	
	/**
	 * Metodo que testa o metodo construtor de uma ListaDeCompras com 
	 * parametros invalidos.
	 * 
	 * Esperado NullPointerException
	 */
	@Test (expected = NullPointerException.class)
	public void testListaDeComprasInvalido2() {
		lista = new ListaDeCompras(null);
	}
	
	/**
	 * Metodo que testa o metodo adicionaCompraALista com parametros validos
	 * quando a lista esta aberta.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testAdicionaCompraAListaValido() {
		assertTrue(lista.getAberto() == true);
		assertEquals("", lista.getItemLista(0));
		lista.adicionaCompraALista(1, itemPU);
		assertEquals("1 Creme dental Oral-C, higiene pessoal", lista.getItemLista(0));
	}

	/**
	 * Metodo que testa o metodo adicionaCompraALista com parametros invalidos
	 * quando a lista esta aberta.
	 * 
	 * Esperado IllegalArgumentException
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testAdicionaCompraAListaInvalido1() {
		lista.adicionaCompraALista(0, itemPU);
	}
	
	/**
	 * Metodo que testa o metodo adicionaCompraALista com parametros invalidos
	 * quando a lista esta aberta.
	 * 
	 * Esperado IllegalArgumentException
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testAdicionaCompraAListaInvalido2() {
		lista.adicionaCompraALista(-1, itemPU);
	}
	
	/**
	 * Metodo que testa o metodo adicionaCompraALista com parametros validos
	 * quando a lista esta fechada.
	 * 
	 * Esperado IllegalArgumentException
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testAdicionaCompraAListaInvalido3() {
		lista.finalizarListaDeCompras("Mercearia Dona Zefa", 150);
		assertTrue(lista.getAberto() == false);
		lista.adicionaCompraALista(1, itemPU);
	}
	
	/**
	 * Metodo que testa o metodo finalizarListaDeCompras com parametros validos
	 * quando a lista ainda nao foi fechada.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testFinalizarListaDeComprasValido() {
		assertTrue(lista.getAberto() == true);
		lista.finalizarListaDeCompras("Mercearia Dona Zefa", 150);
		assertTrue(lista.getAberto() == false);
	}

	/**
	 * Metodo que testa o metodo finalizarListaDeCompras com parametros invalidos
	 * quando a lista ainda nao foi fechada.
	 * 
	 * Esperado IllegalArgumentException
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testFinalizarListaDeComprasInvalido1() {
		lista.finalizarListaDeCompras("", 150);
	}
	
	/**
	 * Metodo que testa o metodo finalizarListaDeCompras com parametros invalidos
	 * quando a lista ainda nao foi fechada.
	 * 
	 * Esperado NullPointerException
	 */
	@Test (expected = NullPointerException.class)
	public void testFinalizarListaDeComprasInvalido2() {
		lista.finalizarListaDeCompras(null, 150);
	}
	
	/**
	 * Metodo que testa o metodo finalizarListaDeCompras com parametros invalidos
	 * quando a lista ainda nao foi fechada.
	 * 
	 * Esperado IllegalArgumentException
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testFinalizarListaDeComprasInvalido3() {
		lista.finalizarListaDeCompras("Mercearia Dona Zefa", 0);
	}
	
	/**
	 * Metodo que testa o metodo finalizarListaDeCompras com parametros invalidos
	 * quando a lista ainda nao foi fechada.
	 * 
	 * Esperado IllegalArgumentException
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testFinalizarListaDeComprasInvalido4() {
		lista.finalizarListaDeCompras("Mercearia Dona Zefa", -1);
	}
	
	/**
	 * Metodo que testa o metodo finalizarListaDeCompras com parametros validos
	 * quando a lista ja foi fechada.
	 * 
	 * Esperado IllegalArgumentException
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testFinalizarListaDeComprasInvalido5() {
		assertTrue(lista.getAberto() == true);
		lista.finalizarListaDeCompras("Mercearia Dona Zefa", 150);
		assertTrue(lista.getAberto() == false);
		lista.finalizarListaDeCompras("Mercearia Dona Zefa", 150);
	}
	
	/**
	 * Metodo que testa o metodo pesquisaCompraEmLista com parametros validos.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testPesquisaCompraEmListaValido() {
		lista.adicionaCompraALista(1, itemPQ);
		assertEquals("1 Peito de peru Saara, alimento industrializado", lista.pesquisaCompraEmLista(itemPQ));
	}

	/**
	 * Metodo que testa o metodo pesquisaCompraEmLista com parametros invalidos.
	 * 
	 * Esperado IllegalArgumentException
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testPesquisaCompraEmListaInvalido() {
		lista.adicionaCompraALista(1, itemPQ);
		lista.pesquisaCompraEmLista(itemPU);
	}
	
	/**
	 * Metodo que testa o metodo atualizaCompraDeLista com parametros validos
	 * quando a lista esta aberta.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testAtualizaCompraDeListaValido1() {
		lista.adicionaCompraALista(1, itemPQ);
		assertEquals("1 Peito de peru Saara, alimento industrializado", lista.getItemLista(0));
		lista.atualizaCompraDeLista("adiciona", itemPQ, 1);
		assertEquals("2 Peito de peru Saara, alimento industrializado", lista.getItemLista(0));
	}

	/**
	 * Metodo que testa o metodo atualizaCompraDeLista com parametros validos
	 * quando a lista esta aberta.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testAtualizaCompraDeListaValido2() {
		lista.adicionaCompraALista(2, itemPQ);
		assertEquals("2 Peito de peru Saara, alimento industrializado", lista.getItemLista(0));
		lista.atualizaCompraDeLista("diminui", itemPQ, 1);
		assertEquals("1 Peito de peru Saara, alimento industrializado", lista.getItemLista(0));
	}
	
	/**
	 * Metodo que testa o metodo atualizaCompraDeLista com parametros validos
	 * quando a lista esta aberta.
	 * 
	 * Nenhum erro esperado.
	 */
	@Test
	public void testAtualizaCompraDeListaValido3() {
		lista.adicionaCompraALista(1, itemPQ);
		assertEquals("1 Peito de peru Saara, alimento industrializado", lista.getItemLista(0));
		lista.atualizaCompraDeLista("diminui", itemPQ, 1);
		assertEquals("", lista.getItemLista(0));
	}
	
	/**
	 * Metodo que testa o metodo atualizaCompraDeLista com parametros invalidos
	 * quando a lista esta aberta.
	 * 
	 * Esperado IllegalArgumentException
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testAtualizaCompraDeListaInvalido1() {
		lista.adicionaCompraALista(1, itemPQ);
		lista.atualizaCompraDeLista("multiplica", itemPQ, 1);
	}
	
	/**
	 * Metodo que testa o metodo atualizaCompraDeLista com parametros invalidos
	 * quando a lista esta aberta.
	 * 
	 * Esperado IllegalArgumentException
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testAtualizaCompraDeListaInvalido2() {
		lista.adicionaCompraALista(1, itemPQ);
		lista.atualizaCompraDeLista("adiciona", itemPU, 1);
	}
	
	/**
	 * Metodo que testa o metodo atualizaCompraDeLista com parametros invalidos
	 * quando a lista esta aberta.
	 * 
	 * Esperado IllegalArgumentException
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testAtualizaCompraDeListaInvalido3() {
		lista.adicionaCompraALista(1, itemPQ);
		lista.atualizaCompraDeLista("adiciona", itemPQ, 0);
	}
	
	/**
	 * Metodo que testa o metodo atualizaCompraDeLista com parametros invalidos
	 * quando a lista esta aberta.
	 * 
	 * Esperado IllegalArgumentException
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testAtualizaCompraDeListaInvalido4() {
		lista.adicionaCompraALista(1, itemPQ);
		lista.atualizaCompraDeLista("adiciona", itemPQ, -1);
	}
	
	/**
	 * Metodo que testa o metodo atualizaCompraDeLista com parametros validos
	 * quando a lista esta fechada.
	 * 
	 * Esperado IllegalArgumentException
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testAtualizaCompraDeListaInvalido5() {
		lista.adicionaCompraALista(1, itemPQ);
		lista.finalizarListaDeCompras("Mercearia Dona Zefa", 150);
		lista.atualizaCompraDeLista("adiciona", itemPQ, 1);
	}
	
	/**
	 * Metodo que testa o metodo deletaCompraDeLista com parametros validos
	 * quando a lista esta aberta.
	 * 
	 * Nenhum erro esperado. 
	 */
	@Test
	public void testDeletaCompraDeListaValido() {
		lista.adicionaCompraALista(1, itemPQ);
		assertEquals("1 Peito de peru Saara, alimento industrializado", lista.getItemLista(0));
		lista.deletaCompraDeLista(itemPQ);
		assertEquals("", lista.getItemLista(0));
	}

	/**
	 * Metodo que testa o metodo deletaCompraDeLista com parametros invalidos
	 * quando a lista esta aberta.
	 * 
	 * Esperado IllegalArgumentException 
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testDeletaCompraDeListaInvalido1() {
		lista.adicionaCompraALista(1, itemPQ);
		assertEquals("1 Peito de peru Saara, alimento industrializado", lista.getItemLista(0));
		lista.deletaCompraDeLista(itemPQ);
		assertEquals("", lista.getItemLista(0));
	}
	
	/**
	 * Metodo que testa o metodo deletaCompraDeLista com parametros invalidos
	 * quando a lista esta aberta.
	 * 
	 * Esperado IllegalArgumentException 
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testDeletaCompraDeListaInvalido2() {
		lista.adicionaCompraALista(1, itemPQ);
		lista.deletaCompraDeLista(itemPU);
	}
	
	
	// TERMINAR OS TESTES
	// TERMINAR OS TESTES
	// TERMINAR OS TESTES
	// TERMINAR OS TESTES
	// TERMINAR OS TESTES
	// TERMINAR OS TESTES
	// TERMINAR OS TESTES
	// TERMINAR OS TESTES
	// TERMINAR OS TESTES
	// TERMINAR OS TESTES
	// TERMINAR OS TESTES
	
	
	
	
	
	@Test
	public void testGetAberto() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDescritorLista() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetData() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHora() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLocalDeCompra() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPrecoTotal() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetItemLista() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testHasItem() {
		fail("Not yet implemented");
	}

}
