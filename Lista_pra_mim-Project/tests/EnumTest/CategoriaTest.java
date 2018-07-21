package EnumTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Enum.Categoria;

/**
 * Laboratório de Programação 2 - Lista pra mim© Project
 *
 * Rotina de testes do Enum Categoria.
 *
 * @author Rafael Dantas Santos de Azevedo - 117210382
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Luiz Bispo dos Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Dantas Santos de Azevedo - 117210382
 */

public class CategoriaTest {

	private Categoria higiene = Categoria.HIGIENEPESSOAL;
	private Categoria limpeza = Categoria.LIMPEZA;
	private Categoria industrialisados = Categoria.ALIMENTOSINDUSTRIALIZADOS;
	private Categoria naoInsdustrializados = Categoria.ALIMENTOSNAOINDUSTRIALIZADOS;

	/**
	 * testa a recuperaco da valor da constante HIGIENEPESSOAL.
	 */
	@Test
	public void testGetDescricao() {
		assertEquals("higiene pessoal", higiene.getDescricao());
	}

	/**
	 * testa a recuperaco da valor da constante LIMPEZA.
	 */
	@Test
	public void testGetDescricao2() {
		assertEquals("limpeza", limpeza.getDescricao());
	}

	/**
	 */
	@Test
	public void testGetDescricao3() {
		assertEquals("alimento industrializado", industrialisados.getDescricao());
	}

	/**
	 * testa a recuperaco da valor da constante ALIMENTOSNAOINDUSTRIALIZADOS.
	 */
	@Test
	public void testGetDescricao4() {
		assertEquals("alimento nao industrializado", naoInsdustrializados.getDescricao());
	}

}
