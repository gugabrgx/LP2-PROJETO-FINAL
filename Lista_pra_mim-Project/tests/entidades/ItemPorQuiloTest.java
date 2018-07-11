package entidades;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ItemPorQuiloTest {

    private Item item;

    @Before
    public void construtorIdeal() {
        this.item = new ItemPorQuilo("Feijao Hulk", "alimento industrializado", 3.0, "Mercadinho#", 8.99, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nomeVazio() {
        this.item = new ItemPorQuilo("", "alimento industrializado", 2.0, "Mercadinho#", 2.99, 1);
    }

    @Test(expected = NullPointerException.class)
    public void nomeNulo() {
        this.item = new ItemPorQuilo(null, "alimento industrializado", 2.0, "Mercadinho#", 2.99, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void categoriaVazia() {
        this.item = new ItemPorQuilo("Feijao Hulk", "", 2.0, "Mercadinho#", 2.99, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void categoriaInvalida() {
        this.item = new ItemPorQuilo("Agua", "liquido", 2.0, "Mercadinho#", 1.0, 1);
    }

    @Test(expected = NullPointerException.class)
    public void categoriaNula() {
        this.item = new ItemPorQuilo("Agua", null, 2.0, "Mercadinho#", 1.0, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void localDeCompraVazia() {
        this.item = new ItemPorQuilo("Agua", "limpeza", 2.0, "", 1.0, 1);
    }

    @Test(expected = NullPointerException.class)
    public void localDeCompraNula() {
        this.item = new ItemPorQuilo("Agua", "limpeza", 2.0, null, 1.0, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void precoInvalido() {
        this.item = new ItemPorQuilo("Agua", "limpeza", 2.0, "Mercadinho#", -3.5, 1);
    }

    @Test
    public void atualizaNomeECategoria() {
        this.item.atualizaItem("kg", "4");
        assertEquals("Feijao Hulk, alimento industrializado, Preco por quilo: <Mercadinho#, R$ 8,99;>", this.item.toString());

        this.item.atualizaItem("nome", "Carne de elefante");

        assertEquals("Carne de elefante, alimento industrializado, Preco por quilo: <Mercadinho#, R$ 8,99;>", this.item.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void atualizaItemCategoriaInvalida() {
        this.item.atualizaItem("categoria", "unidades");
    }

    @Test(expected = IllegalArgumentException.class)
    public void atualizaItemKgInvalido() {
        this.item.atualizaItem("kg", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void atualizaItemKgMenorQueZero() {
        this.item.atualizaItem("kg", "-1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void atualizaItemAtributoInvalido() {
        this.item.atualizaItem("unidades", "10");
    }

    @Test
    public void adicionaPrecoCorreto() {
        this.item.adicionaPrecoItem("Supermercado Concha", 5.89);
        assertEquals("Feijao Hulk, alimento industrializado, Preco por quilo: <Supermercado Concha, R$ 5,89;Mercadinho#, R$ 8,99;>", this.item.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void adicionaPrecoMercadoVazio() {
        this.item.adicionaPrecoItem("", 8.99);
    }

    @Test(expected = NullPointerException.class)
    public void adicionaPrecoMercadoNulo() {
        this.item.adicionaPrecoItem(null, 8.99);
    }

    @Test(expected = IllegalArgumentException.class)
    public void adicionaPrecoInvalido() {
        this.item.adicionaPrecoItem("Supermercado Bonus", -1.99);
    }

    @Test
    public void testeToString() {
        assertEquals("Feijao Hulk, alimento industrializado, Preco por quilo: <Mercadinho#, R$ 8,99;>", this.item.toString());
    }

    @Test
    public void testGetCategoria() {
        assertEquals("alimento industrializado", this.item.getCategoria());
    }

    @Test
    public void testGetId() {
        assertEquals(1, this.item.getId());
    }

    @Test
    public void testGetListaPrecos() {
        assertEquals("<Mercadinho#, R$ 8,99;>", this.item.getListaPrecos());
    }

    @Test
    public void testGetNome() {
        assertEquals("Feijao Hulk", this.item.getNome());
    }
}