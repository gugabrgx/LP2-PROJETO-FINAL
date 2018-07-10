package entidades;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joaopbb on 10/07/18.
 */
public class ItemPorUnidadeTest {

    private Item item;

    @Before
    public void construtorIdeal() {
        this.item = new ItemPorUnidade("Batata Roffles", "alimento industrializado", 1, "Mercadinho", 4.99, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nomeVazio() {
        this.item = new ItemPorUnidade("", "alimento industrializado", 1, "Mercadinho", 4.99, 1);
    }

    @Test(expected = NullPointerException.class)
    public void nomeNulo() {
        this.item = new ItemPorUnidade(null, "alimento industrializado", 1, "Mercadinho", 4.99, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void categoriaVazia() {
        this.item = new ItemPorUnidade("Batata Roffles", "", 1, "Mercadinho", 4.99, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void categoriaInvalida() {
        this.item = new ItemPorUnidade("Batata Roffles", "ar", 1, "Mercadinho", 4.99, 1);
    }

    @Test(expected = NullPointerException.class)
    public void categoriaNula() {
        this.item = new ItemPorUnidade("Batata Roffles", null, 1, "Mercadinho", 4.99, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void localDeCompraVazia() {
        this.item = new ItemPorUnidade("Batata Roffles", "alimento industrializado", 1, "", 4.99, 1);
    }

    @Test(expected = NullPointerException.class)
    public void localDeCompraNula() {
        this.item = new ItemPorUnidade("Batata Roffles", "alimento industrializado", 1, null, 4.99, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void precoInvalido() {
        this.item = new ItemPorUnidade("Batata Roffles", "alimento industrializado", 1, "Mercadinho", -1.99, 1);
    }

    @Test
    public void atualizaNomeECategoria() {
        this.item.atualizaItem("categoria", "alimento nao industrializado");
        assertEquals("1. Batata Roffles, alimento nao industrializado, Preco: <Mercadinho, R$ 4,99;>", this.item.toString());

        this.item.atualizaItem("nome", "Carne de elefante");

        assertEquals("1. Carne de elefante, alimento nao industrializado, Preco: <Mercadinho, R$ 4,99;>", this.item.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void atualizaItemCategoriaInvalida() {
        this.item.atualizaItem("categoria", "kg");
    }

    @Test(expected = IllegalArgumentException.class)
    public void atualizaItemQntInvalido() {
        this.item.atualizaItem("unidades", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void atualizaItemQntMenorQueZero() {
        this.item.atualizaItem("quantidade", "-1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void atualizaItemAtributoInvalido() {
        this.item.atualizaItem("kg", "10");
    }

    @Test
    public void adicionaPrecoCorreto() {
        this.item.adicionaPrecoItem("Supermercado Concha", 5.89);
        assertEquals("1. Batata Roffles, alimento industrializado, Preco: <Supermercado Concha, R$ 5,89;Mercadinho, R$ 4,99;>", this.item.toString());
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

}