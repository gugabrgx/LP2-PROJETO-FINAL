package comparatorsTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import comparators.ComparaDescritor;
import entidades.ListaDeCompras;

/**
 * Laboratório de Programação 2 - Lista pra mim© Project
 * 
 * Rotina de testes da classe comparaDescritor.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */

public class ComparaDescritorTest {

	/**
	 * Lista de Compras criado para testes.
	 */
	private ListaDeCompras lista1;
	/**
	 * Lista de Compras criado para testes.
	 */
	private ListaDeCompras lista2;
	/**
	 * Lista de Compras criado para testes.
	 */
	private ListaDeCompras lista3;
	/**
	 * Lista de Compras criado para testes.
	 */
	private ComparaDescritor comparador;
	/**
	 * Comparador criado para testes.
	 */
	private ComparaDescritor comparador2;

	/**
	 * Método que cria Lista de Compras para testes.
	 */
	@Before
	public void PreparaCenario() {
		this.comparador = new ComparaDescritor();
		this.lista1 = new ListaDeCompras("aaah", 0);
		this.lista2 = new ListaDeCompras("beeh", 1);
		this.lista3 = new ListaDeCompras("aah", 2);
	}

	/**
	 * Método que testa Compare quando a lista1 vem primeiro que a lista2.
	 */
	@Test
	public void testComparePrimeiro() {
		assertTrue(this.comparador.compare(lista1, lista2) < 0);
	}

	/**
	 * Método que testa Compare quando a lista2 vem depois que a lista3.
	 */
	@Test
	public void testCompareSegundo() {
		assertTrue(this.comparador.compare(lista2, lista3) > 0);
	}

	/**
	 * Método que testa Compare quando as listas são iguais.
	 */
	@Test
	public void testCompareIgual() {
		assertTrue(this.comparador.compare(lista3, lista3) == 0);
	}

	/**
	 * Testa o construtor de um comparador de Descricoes de listas.
	 */
	@Test
	public void testConstrutor() {
		assertTrue(comparador2 == null);
		comparador2 = new ComparaDescritor();
		assertFalse(comparador2 == null);
	}

}
