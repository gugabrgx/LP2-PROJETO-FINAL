package controllersTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controllers.ControllerItem;
import controllers.ControllerLista;
import facade.Facade;

/**
 * Laboratório de Programação 2 - Lista pra mim© Project
 *
 * Classe que testa os metodos da classe ControllerLista.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */
public class ControllerListaTest {

	// Instanciação de um Objeto Facade.
	private Facade facade;
	// Instanciação de um Objeto ControllerItem.
	private ControllerItem cItem;
	// Instanciação de um Objeto ControllerLista.
	private ControllerLista cLista, outraCLista;

	/**
	 * Metodo que inicializa objetos.
	 * 
	 * Nenhum erro esperado.
	 */
	@Before
	public void inicializa() {
		facade = new Facade();
		cItem = new ControllerItem();
		cLista = new ControllerLista(cItem);
		cLista.adicionaListaDeCompras("Feira Semanal");

		cItem.adicionaItemPorUnidade("Creme dental Oral-C", "higiene pessoal", 3, "Mercadinho Bem Barato", 3.79);
		cItem.adicionaItemPorQuilo("Peito de peru Saara", "alimento industrializado", 1.0, "Mercadinho Bem Barato",
				34.49);
	}

	/**
	 * Metodo que testa o metodo construtor de ControllerLista.
	 *
	 * Nenhum erro esperado.
	 */
	@Test
	public void testControllerLista() {
		assertNull(outraCLista);
		outraCLista = new ControllerLista(cItem);
		assertNotNull(outraCLista);
	}

	/**
	 * Metodo que testa o metodo adicionaListaDeCompras com parametros validos.
	 *
	 * Nenhum erro esperado.
	 */
	@Test
	public void testAdicionaListaDeComprasValido() {
		cLista.adicionaListaDeCompras("Feira Semanalal");
		cLista.adicionaListaDeCompras("Feira Semanala2");
	}

	/**
	 * Metodo que testa o metodo adicionaCompraALista com parametros validos.
	 *
	 * Nenhum erro encontrado.
	 */
	@Test
	public void testAdicionaCompraALista() {
		cLista.adicionaCompraALista("Feira Semanal", 1, 1);
		assertEquals("1 Creme dental Oral-C, higiene pessoal", cLista.getItemLista("Feira Semanal", 0));
	}

	/**
	 * Metodo que testa o metodo FinalizarListaDeCompras com parametros validos.
	 *
	 * Nenhum erro encontrado.
	 */
	@Test
	public void testFinalizarListaDeCompras() {
		cLista.adicionaCompraALista("Feira Semanal", 2, 1);

		cLista.finalizarListaDeCompras("Feira Semanal", "Extra", 20);
	}

	/**
	 * Metodo que testa o metodo pesquisaCompraEmLista com parametros validos.
	 *
	 * Nenhum erro esperado.
	 */
	@Test
	public void testPesquisaCompraEmLista() {

		cLista.adicionaCompraALista("Feira Semanal", 3, 1);
		cLista.adicionaCompraALista("Feira Semanal", 2, 2);

		assertEquals("3 Creme dental Oral-C, higiene pessoal", cLista.pesquisaCompraEmLista("Feira Semanal", 1));
		assertEquals("2 Peito de peru Saara, alimento industrializado",
				cLista.pesquisaCompraEmLista("Feira Semanal", 2));
	}

	/**
	 * Metodo que testa o metodo AtualizaCompraDeLista com parametros validos.
	 *
	 * Nenhum erro esperado.
	 */
	@Test
	public void testAtualizaCompraDeLista() {
		cLista.adicionaCompraALista("Feira Semanal", 2, 1);

		cLista.atualizaCompraDeLista("Feira Semanal", 1, 7, "adiciona");
		cLista.atualizaCompraDeLista("Feira Semanal", 1, 5, "diminui");

		assertEquals("4 Creme dental Oral-C, higiene pessoal", cLista.pesquisaCompraEmLista("Feira Semanal", 1));
	}

	/**
	 * Metodo que testa o metodo getItemLista com parametros validos.
	 *
	 * Nenhum erro esperado.
	 */
	@Test
	public void testgetItemLista() {
		cLista.adicionaCompraALista("Feira Semanal", 4, 1);
		cLista.adicionaCompraALista("Feira Semanal", 7, 2);
		assertEquals("4 Creme dental Oral-C, higiene pessoal", cLista.getItemLista("Feira Semanal", 0));
		assertEquals("7 Peito de peru Saara, alimento industrializado", cLista.getItemLista("Feira Semanal", 1));
	}

	@Test
	public void testDeletaCompraDeLista() {
		cLista.adicionaCompraALista("Feira Semanal", 2, 1);
		cLista.adicionaCompraALista("Feira Semanal", 1, 2);

		assertEquals("2 Creme dental Oral-C, higiene pessoal", cLista.getItemLista("Feira Semanal", 0));
		assertEquals("1 Peito de peru Saara, alimento industrializado", cLista.getItemLista("Feira Semanal", 1));

		cLista.deletaCompraDeLista("Feira Semanal", 1);

		assertEquals("1 Peito de peru Saara, alimento industrializado", cLista.getItemLista("Feira Semanal", 0));
		assertEquals("", cLista.getItemLista("Feira Semanal", 1));
	}

	/**
	 * Metodo que testa o metodo PesquisaListaDeCompras com parametros validos.
	 *
	 * Nao esperando erros.
	 */
	@Test
	public void testPesquisaListaDeCompras() {
		assertEquals("Feira Semanal", cLista.pesquisaListaDeCompras("Feira Semanal"));
	}

	/**
	 * Metodo que testa o metodo PesquisaListasDeComprasPorItem com parametros
	 * validos.
	 *
	 * Nao esperando nenhum erro.
	 */
	@Test
	public void testPesquisaListasDeComprasPorItem() {
		cLista.adicionaListaDeCompras("Feira Linda");
		cLista.adicionaListaDeCompras("Feira do Amanha");

		cLista.adicionaCompraALista("Feira do Amanha", 5, 1);
		cLista.adicionaCompraALista("Feira Linda", 4, 1);

		cLista.adicionaCompraALista("Feira Semanal", 2, 1);

		assertEquals(
				"Feira do Amanha" + System.lineSeparator() + "Feira Linda" + System.lineSeparator() + "Feira Semanal",
				cLista.pesquisaListasDeComprasPorItem(1));
	}

	/**
	 * Metodo que testa o metodo PesquisaListasDeComprasPorData com parametros
	 * validos.
	 *
	 * Nao esperando erros.
	 */
	@Test
	public void testPesquisaListasDeComprasPorData() {
		cLista.adicionaListaDeCompras("Feira Linda");

		assertEquals("Feira Linda" + System.lineSeparator() + "Feira Semanal",
				cLista.pesquisaListasDeComprasPorData(facade.dataAtual()));
	}

	/**
	 * Metodo que testa o metodo GetItemListaPorData com parametros validos.
	 *
	 * Nao esperando erro
	 */
	@Test
	public void testGetItemListaPorData() {
		cLista.adicionaListaDeCompras("Feira Linda");

		assertEquals("Feira Linda", cLista.getItemListaPorData(facade.dataAtual(), 0));
		assertEquals("Feira Semanal", cLista.getItemListaPorData(facade.dataAtual(), 1));
	}

	/**
	 * Metodo que testa o metodo GetItemListaPorItem com parametros validos.
	 *
	 * Nao esperando erros
	 */
	@Test
	public void testGetItemListaPorItem() {
		cLista.adicionaListaDeCompras("Feira Linda");

		cLista.adicionaCompraALista("Feira Semanal", 7, 1);
		cLista.adicionaCompraALista("Feira Linda", 2, 1);

		assertEquals(facade.dataAtual() + " - Feira Linda", cLista.getItemListaPorItem(1, 0));
		assertEquals(facade.dataAtual() + " - Feira Semanal", cLista.getItemListaPorItem(1, 1));
	}

}
