package controllersTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controllers.ControllerItem;
import controllers.ControllerLista;
import entidades.Item;
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
	// Instanciação de um Objeto Item.
	private Item itemPQ, itemPU;

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
	 * Metodo que testa o metodo adicionaListaDeCompras com parametros invalidos.
	 *
	 * Esperado NullPointerException
	 */
	@Test(expected = NullPointerException.class)
	public void testAdicionaListaDeComprasInvalido1() {
		cLista.adicionaListaDeCompras(null);
	}

	/**
	 * Metodo que testa o metodo adicionaListaDeCompras com parametros invalidos.
	 *
	 * Esperado IllegalArgumentException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaListaDeComprasInvalido2() {
		cLista.adicionaListaDeCompras("");
	}

	/**
	 * Metodo que testa o metodo adicionaListaDeCompras com lista ja criada.
	 *
	 * Esperado IllegalArgumentException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaListaDeComprasInvalido3() {
		cLista.adicionaListaDeCompras("Feira Semanalal");

		cLista.adicionaListaDeCompras("Feira Semanalal");
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
	 * Metodo que testa o metodo adicionaCompraALista com parametro descritor nulo.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaCompraAListaInvalido1() {
		cLista.adicionaCompraALista(" ", 1, 1);
	}

	/**
	 * Metodo que testa o metodo adicionaCompraALista com parametro descritor nulo.
	 *
	 * Esperando NullPointerException
	 */
	@Test(expected = NullPointerException.class)
	public void testAdicionaCOmpraAListaInvalido2() {
		cLista.adicionaCompraALista(null, 1, 1);
	}

	/**
	 * Metodo que testa o metodo adicionaCompraALista com descritor de lista
	 * inexistente.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaCompraAListaInvalido3() {
		cLista.adicionaCompraALista("Feira de amanha", 1, 1);
	}

	/**
	 * Metodo que testa o metodo adicionaCompraALista com quantidade invalida.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaCompraAListaInvalido4() {
		cLista.adicionaCompraALista("Feira de Semanal", -1, 1);
	}

	/**
	 * Metodo que testa o metodo adicionaCompraALista com item inexistente.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaCompraAListaInvalido5() {
		cLista.adicionaCompraALista("Feira de Semanal", 1, 42);
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
	 * Metodo que testa o metodo FinalizarListaDeCompras com descritor vazio.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFinalizarListaDeComprasInvalido1() {
		cLista.finalizarListaDeCompras("", "Supermercado Germano", 1);
	}

	/**
	 * Metodo que testa o metodo FinalizarListaDeCompras com descritor nulo.
	 *
	 * Esperando NullPointerException.
	 */
	@Test(expected = NullPointerException.class)
	public void testFinalizarListaDeComprasInvalido2() {
		cLista.finalizarListaDeCompras(null, "Supermercado Germano", 1);
	}

	/**
	 * Metodo que testa o metodo FinalizarListaDeCompras com local de compra vazio.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFinalizarListaDeComprasInvalido3() {
		cLista.finalizarListaDeCompras("Feira Semanal", "", 1);
	}

	/**
	 * Metodo que testa o metodo FinalizarListaDeCompras com local de compra nulo.
	 *
	 * Esperando NullPointerException.
	 */
	@Test(expected = NullPointerException.class)
	public void testFinalizarListaDeComprasInvalido4() {
		cLista.finalizarListaDeCompras("Feira Semanal", null, 1);
	}

	/**
	 * Metodo que testa o metodo FinalizarListaDeCompras com local de compra nulo.
	 *
	 * Esperando NullPointerException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFinalizarListaDeComprasInvalido5() {
		cLista.finalizarListaDeCompras("Feira Semanal", "Supermercado Germano", 0);
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
	 * Metodo que testa o metodo pesquisaCompraEmLista com id de item invalido.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPesquisaCompraEmListaInvalido1() {
		cLista.pesquisaCompraEmLista("Feira Semanal", -2);
	}

	/**
	 * Metodo que testa o metodo pesquisaCompraEmLista com descritor de lista vazio.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPesquisaCompraEmListaInvalido2() {
		cLista.pesquisaCompraEmLista("", 1);
	}

	/**
	 * Metodo que testa o metodo pesquisaCompraEmLista com descritor de lista nulo.
	 *
	 * Esperando NullPointerException.
	 */
	@Test(expected = NullPointerException.class)
	public void testPesquisaCompraEmListaInvalido3() {
		cLista.pesquisaCompraEmLista(null, 1);
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
	 * Metodo que testa o metodo AtualizaCompraDeLista com descritor vazio.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaCompraDeListaInvalido1() {
		cLista.atualizaCompraDeLista("", 1, 1, "aumenta");
	}

	/**
	 * Metodo que testa o metodo AtualizaCompraDeLista com descritor nulo.
	 *
	 * Esperando NullPointerException.
	 */
	@Test(expected = NullPointerException.class)
	public void testAtualizaCompraDeListaInvalido2() {
		cLista.atualizaCompraDeLista(null, 1, 1, "aumenta");
	}

	/**
	 * Metodo que testa o metodo AtualizaCompraDeLista com operacao invalida.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaCompraDeListaInvalido3() {
		cLista.atualizaCompraDeLista("Feira Semanal", 1, 1, "deixa o mesmo");
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

	/**
	 * Metodo que testa o metodo getItemLista com descritor de lista vazia.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testgetItemListaInvalido1() {
		cLista.getItemLista("", 0);
	}

	/**
	 * Metodo que testa o metodo getItemLista com descritor de lista nulo.
	 *
	 * Esperando NullPointerException.
	 */
	@Test(expected = NullPointerException.class)
	public void testgetItemListaInvalido2() {
		cLista.getItemLista(null, 0);
	}

	/**
	 * Metodo que testa o metodo getItemLista com posicao de item invalida.
	 *
	 * Esperando ArrayIndexOutOfBoundsException.
	 */
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testgetItemListaInvalido3() {
		cLista.getItemLista("Feira Semanal", -1);
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
	 * Metodo que testa o metodo deletaCompraDeLista com descritor de lista vazia.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDeletaCompraDeListaInvalido1() {
		cLista.deletaCompraDeLista("", 0);
	}

	/**
	 * Metodo que testa o metodo deletaCompraDeLista com descritor de lista nulo.
	 *
	 * Esperando NullPointerException.
	 */
	@Test(expected = NullPointerException.class)
	public void testDeletaCompraDeListaInvalido2() {
		cLista.deletaCompraDeLista(null, 0);
	}

	/**
	 * Metodo que testa o metodo deletaCompraDeLista com id nao existente.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDeletaCompraDeListaInvalido3() {
		cLista.deletaCompraDeLista("Feira Semanal", 14);
	}

	/**
	 * Metodo que testa o metodo deletaCompraDeLista com id invalido.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testDeletaCompraDeListaInvalido4() {
		cLista.deletaCompraDeLista("Feira Semanal", -1);
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
	 * Metodo que testa o metodo PesquisaListaDeCompras com descritor de lista
	 * vazia.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPesquisaListaDeComprasInvalido1() {
		cLista.pesquisaListaDeCompras("");
	}

	/**
	 * Metodo que testa o metodo PesquisaListaDeCompras com descritor de lista nulo.
	 *
	 * Esperando NullPointerException.
	 */
	@Test(expected = NullPointerException.class)
	public void testPesquisaListaDeComprasInvalido2() {
		cLista.pesquisaListaDeCompras(null);
	}

	/**
	 * Metodo que testa o metodo PesquisaListaDeCompras com descritor de lista nao
	 * existente.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPesquisaListaDeComprasInvalido3() {
		cLista.pesquisaListaDeCompras("Feira do Amanha");
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
	 * Metodo que testa o metodo PesquisaListasDeComprasPorItem com lista sem
	 * compras.
	 *
	 * Esperando NullPointerException
	 */
	@Test(expected = NullPointerException.class)
	public void testPesquisaListasDeComprasPorItemInvalido1() {
		cLista.pesquisaListasDeComprasPorItem(1);
	}

	/**
	 * Metodo que testa o metodo PesquisaListasDeComprasPorItem com id invalido.
	 *
	 * Esperando IllegalArgumentException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPesquisaListasDeComprasPorItemInvalido2() {
		cLista.pesquisaListasDeComprasPorItem(0);
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
	 * Metodo que testa o metodo PesquisaListasDeComprasPorData com data vazia.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPesquisaListasDeComprasPorDataInvalida1() {
		cLista.pesquisaListasDeComprasPorData("");
	}

	/**
	 * Metodo que testa o metodo PesquisaListasDeComprasPorData com data nula.
	 *
	 * Esperando NullPointerException.
	 */
	@Test(expected = NullPointerException.class)
	public void testPesquisaListasDeComprasPorDataInvalida2() {
		cLista.pesquisaListasDeComprasPorData(null);
	}

	/**
	 * Metodo que testa o metodo PesquisaListasDeComprasPorData com data invalida.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPesquisaListasDeComprasPorDataInvalida3() {
		cLista.pesquisaListasDeComprasPorData("11122018");
	}

	/**
	 * Metodo que testa o metodo PesquisaListasDeComprasPorData com data invalida.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPesquisaListasDeComprasPorDataInvalida4() {
		cLista.pesquisaListasDeComprasPorData("2018/07/16");
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
	 * Metodo que testa o metodo GetItemListaPorData com data vazia.
	 *
	 * Esperando IllegalArgumentException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetItemListaPorDataInvalido1() {
		cLista.getItemListaPorData("", 0);
	}

	/**
	 * Metodo que testa o metodo GetItemListaPorData com data nula.
	 *
	 * Esperando NullPointerException
	 */
	@Test(expected = NullPointerException.class)
	public void testGetItemListaPorDataInvalido2() {
		cLista.getItemListaPorData(null, 0);
	}

	/**
	 * Metodo que testa o metodo GetItemListaPorData com data invalida.
	 *
	 * Esperando IllegalArgumentException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetItemListaPorDataInvalido3() {
		cLista.getItemListaPorData("18082018", 0);
	}

	/**
	 * Metodo que testa o metodo GetItemListaPorData com data invalida.
	 *
	 * Esperando ArrayIndexOutOfBoundsException
	 */
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testGetItemListaPorDataInvalido4() {
		cLista.getItemListaPorData(facade.dataAtual(), -1);
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

		assertEquals("21/07/2018 - Feira Linda", cLista.getItemListaPorItem(1, 0));
		assertEquals("21/07/2018 - Feira Semanal", cLista.getItemListaPorItem(1, 1));
	}

	/**
	 * Metodo que testa o metodo GetItemListaPorItem com posicao invalida.
	 *
	 * Esperando ArrayIndexOutOfBoundsException.
	 */
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testGetItemListaPorItemInvalido1() {
		cLista.getItemListaPorItem(1, -1);
	}

	/**
	 * Metodo que testa o metodo GetItemListaPorItem com produto nao cadastrado.
	 *
	 * Esperando IndexOutOfBoundsException.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetItemListaPorItemInvalido2() {
		cLista.getItemListaPorItem(20, 0);
	}

	/**
	 * Metodo que testa o metodo GetItemListaPorItem com produto nao cadastrado.
	 *
	 * Esperando IndexOutOfBoundsException.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetItemListaPorItemInvalido3() {
		cLista.getItemListaPorItem(0, 0);
	}
}
