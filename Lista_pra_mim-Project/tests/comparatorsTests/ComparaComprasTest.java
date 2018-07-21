package comparatorsTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import comparators.ComparaCompras;
import entidades.Compra;
import entidades.ItemPorQuantidadeFixa;
import entidades.ItemPorQuilo;
import entidades.ItemPorUnidade;

/**
 * Laboratório de Programação 2 - Lista pra mim© Project
 * 
 * Rotina de testes da classe comparaCompras.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */

public class ComparaComprasTest {

	/**
	 * Compra criado para testes.
	 */
	private Compra compra;
	/**
	 * Compra criado para testes.
	 */
	private Compra compra2;
	/**
	 * Compra criado para testes.
	 */
	private Compra compra3;
	/**
	 * item criado para testes.
	 */
	private ComparaCompras comparador;
	/**
	 * Comparador criado para testes.
	 */
	private ComparaCompras comparador2;

	/**
	 * Método que cria itens para testes.
	 */
	@Before
	public void PreparaCenario() {
		this.comparador = new ComparaCompras();
		this.compra = new Compra(2, new ItemPorQuantidadeFixa("Capsula Dois Coracoes", "alimento industrializado", 3,
				"capsulas", "Mercadinho++", 2.99, 1));
		this.compra2 = new Compra(2,
				new ItemPorQuilo("Feijao Hulk", "alimento industrializado", 3.0, "Mercadinho#", 8.99, 1));
		this.compra3 = new Compra(2,
				new ItemPorUnidade("Batata Roffles", "alimento industrializado", 1, "Mercadinho", 4.99, 1));
	}

	/**
	 * Método que testa Compare quando compra1 vem primeiro que a compra2.
	 */
	@Test
	public void testComparePrimeiro() {
		assertTrue(this.comparador.compare(compra, compra2) < 0);
	}

	/**
	 * Método que testa Compare quando compra2 vem primeiro que a compra3.
	 */
	@Test
	public void testCompareSegundo() {
		assertTrue(this.comparador.compare(compra2, compra3) > 0);
	}

	/**
	 * Método que testa Compare quando as compras são iguais.
	 */
	@Test
	public void testCompareIgual() {
		assertTrue(this.comparador.compare(compra2, compra2) == 0);
	}

	/**
	 * Testa o construtor de um comparador de compras.
	 */
	@Test
	public void testConstrutor() {
		assertTrue(comparador2 == null);
		comparador2 = new ComparaCompras();
		assertFalse(comparador2 == null);
	}

}
