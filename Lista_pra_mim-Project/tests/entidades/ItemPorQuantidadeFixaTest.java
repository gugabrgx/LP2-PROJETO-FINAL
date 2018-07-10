package entidades;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joaopbb on 10/07/18.
 */
public class ItemPorQuantidadeFixaTest {

    private Item item;

    @Before
    public void construtorIdeal() {
        this.item = new ItemPorQuantidadeFixa("Capsula Dois Coracoes", "alimento industrializado", 3,
                "capsulas", "Mercadinho++", 2.99, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nomeVazio() {
        this.item = new ItemPorQuantidadeFixa("", "alimento industrializado", 3,
                "capsulas", "Mercadinho++", 2.99, 1);
    }

    @Test(expected = NullPointerException.class)
    public void nomeNulo() {
        this.item = new ItemPorQuantidadeFixa(null, "alimento industrializado", 3,
                "capsulas", "Mercadinho++", 2.99, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void categoriaVazia() {
        this.item = new ItemPorQuantidadeFixa("Queijo ralado Python", "", 3,
                "capsulas", "Mercadinho++", 2.99, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void categoriaInvalida() {
        this.item = new ItemPorQuantidadeFixa("Queijo ralado Python", "suco", 3,
                "capsulas", "Mercadinho++", 2.99, 1);
    }

    @Test(expected = NullPointerException.class)
    public void categoriaNula() {
        this.item = new ItemPorQuantidadeFixa("Queijo ralado Python", null, 3,
                "capsulas", "Mercadinho++", 2.99, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void localDeCompraVazia() {
        this.item = new ItemPorQuantidadeFixa("Queijo ralado Python", "alimento industrializado", 3,
                "capsulas", "", 2.99, 1);
    }

    @Test(expected = NullPointerException.class)
    public void localDeCompraNula() {
        this.item = new ItemPorQuantidadeFixa("Queijo ralado Python", "alimento industrializado", 3,
                "capsulas", null, 2.99, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void quantidadeInvalida() {
        this.item = new ItemPorQuantidadeFixa("Esponja de Aco da Solange", "limpeza", -1,
                "capsulas", "Mercadinho++", 2.99, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void precoInvalido() {
        this.item = new ItemPorQuantidadeFixa("Esponja de Aco da Solange", "limpeza", -1,
                "capsulas", "Mercadinho++", 2.99, 1);
    }

    @Test
    public void atualizaNomeQuantidadeCategoria() {
        this.item.atualizaItem("quantidade", "20");
        assertEquals("1. Capsula Dois Coracoes, alimento industrializado, 20 capsulas, Preco: <Mercadinho++, R$ 2,99;>",
                this.item.toString());

        this.item.atualizaItem("categoria", "alimento nao industrializado");
        assertEquals("1. Capsula Dois Coracoes, alimento nao industrializado, 20 capsulas, Preco: <Mercadinho++, R$ 2,99;>",
                this.item.toString());

        this.item.atualizaItem("nome", "Capsula Dois Pulmoes");

        assertEquals("1. Capsula Dois Pulmoes, alimento nao industrializado, 20 capsulas, Preco: <Mercadinho++, R$ 2,99;>",
                this.item.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void atualizaItemCategoriaInvalida() {
        this.item.atualizaItem("categoria", "kg");
    }

    @Test(expected = IllegalArgumentException.class)
    public void atualizaItemQuantidadeInvalido() {
        this.item.atualizaItem("quantidade", "kg");
    }

    @Test(expected = IllegalArgumentException.class)
    public void atualizaItemQuantidadeMenorQueZero() {
        this.item.atualizaItem("quantidade", "-1");
    }

    @Test
    public void atualizaItemUnidadeDeMedida() {
        this.item.atualizaItem("unidade de medida", "kg");
        assertEquals("1. Capsula Dois Coracoes, alimento industrializado, 3 kg, Preco: <Mercadinho++, R$ 2,99;>", this.item.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void atualizaItemUnidadeDeMedidaVazio() {
        this.item.atualizaItem("unidade de medida", "");
    }

    @Test(expected = NullPointerException.class)
    public void atualizaItemUnidadeDeMedidaNula() {
        this.item.atualizaItem("unidade de medida", null);
    }
}