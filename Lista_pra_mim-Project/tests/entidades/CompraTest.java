package entidades;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/** 
 * Laboratório de Programação 2
 * 
 * @author Gustavo Santos - 117210400
 * @lab Laboratório 
 */
public class CompraTest {

	private Compra compra;
	private Item itempqf;
	private Item itempq;
	private Item itempu;
	
	@Before
	public void inicializa() {
		itempqf = new ItemPorQuantidadeFixa("Agua Sanitaria Drogon", "limpeza", 1, "l", "Supermercado Excepcional", 2.19, 1);
		itempq = new ItemPorQuilo("Peito de peru Saara", "alimento industrializado", 1.0, "Mercadinho Bem Barato", 34.49, 2);
		itempu = new ItemPorUnidade("Creme dental Oral-C", "higiene pessoal", 3, "Mercadinho Bem Barato", 3.79, 3);
	}
	
	@Test
	public void testConstrutorValido() {
		compra = new Compra(1, itempqf);
	}
	
	
	

	
}
