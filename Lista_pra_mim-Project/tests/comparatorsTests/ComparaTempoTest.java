package comparatorsTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import comparators.ComparaTempo;
import entidades.Item;
import entidades.ItemPorQuantidadeFixa;
import entidades.ItemPorQuilo;
import entidades.ItemPorUnidade;
import entidades.ListaDeCompras;

/**
 * Laboratório de Programação 2 - Lista pra mim© Project
 * 
 * Rotina de testes da classe comparaTempo.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */
public class ComparaTempoTest {

	/**
	 * lista criado para testes.
	 */
	private ListaDeCompras lista1;
	/**
	 * lista criado para testes.
	 */
	private ListaDeCompras lista2;
	/**
	 * lista criado para testes.
	 */
	private ListaDeCompras lista3;
	/**
	 * Comparador criado para testes.
	 */
	private ComparaTempo comparador;
	/**
	 * Comparador criado para testes.
	 */
	private ComparaTempo comparador2;

	/**
	 * Método que cria itens para testes.
	 */
	@Before
	public void PreparaCenario() {
		Item item = new ItemPorQuantidadeFixa("Capsula Dois Coracoes", "alimento industrializado", 3, "capsulas",
				"Mercadinho++", 2.99, 1);
		Item item2 = new ItemPorQuilo("Feijao Hulk", "alimento industrializado", 3.0, "Mercadinho#", 8.99, 1);
		Item item3 = new ItemPorUnidade("Batata Roffles", "alimento industrializado", 1, "Mercadinho", 4.99, 1);
		this.comparador = new ComparaTempo();

		this.lista1 = new ListaDeCompras("lista1");
		lista1.adicionaCompraALista(100, item);
		lista1.adicionaCompraALista(100, item2);
		lista1.adicionaCompraALista(100, item3);
		this.lista2 = new ListaDeCompras("lista2");
		lista2.adicionaCompraALista(100, item);
		lista2.adicionaCompraALista(100, item2);
		lista2.adicionaCompraALista(100, item3);
		this.lista3 = new ListaDeCompras("lista3");
		lista3.adicionaCompraALista(100, item);
		lista3.adicionaCompraALista(100, item2);
		lista3.adicionaCompraALista(100, item3);

	}

	/**
	 * Método que testa Compare quando o preco Total da primeira lista é menor que o
	 * da segunda lista.
	 */
	@Test
	public void testComparePrimeiro() {
		assertEquals(99, this.comparador.compare(lista1, lista2) * 100);
	}

	/**
	 * Método que testa Compare quando preco Total da segunda lista é menor que o da
	 * segunda lista.
	 */
	@Test
	public void testCompareSegundo() {
		assertTrue(this.comparador.compare(lista2, lista3) > 0.0);
	}

	/**
	 * Método que testa Compare quando o preco total das listas tem o mesmo preco.
	 */
	@Test
	public void testCompareIgual() {
		assertTrue(this.comparador.compare(lista2, lista2) == 0);
	}

	/**
	 * Testa o construtor de um comparador por preco Total.
	 */
	@Test
	public void testConstrutor() {
		assertTrue(comparador2 == null);
		comparador2 = new ComparaTempo();
		assertFalse(comparador2 == null);
	}

}
