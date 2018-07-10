package Controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import Comparators.ComparaNome;
import Comparators.ComparaPreco;
import entidades.Item;
import entidades.ItemPorQuantidadeFixa;
import entidades.ItemPorQuilo;
import entidades.ItemPorUnidade;

/**
 * 
 * Laboratório de Programação 2 - Lista pra mim© Project
 *
 * Classe que representa o Controller. Nesta classe e possivel realizar
 * operacoes como: adicionar itens, exibir itens, atualizar itens, etc.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */
public class Controller {

	// Um inteiro que representa o id de um Item.
	private int id;
	// Um Mapa que mapeia um Objeto Item para um inteiro.
	private Map<Integer, Item> itens;
	private Comparator<Item> comparador;

	/**
	 * Metodo que inicializa um Controller.
	 * 
	 * Este metodo nao utiliza parametros.
	 * 
	 * Este metodo nao retorna nenhum valor.
	 */
	public Controller() {
		this.id = 1;
		this.itens = new HashMap<>();
		this.comparador = new ComparaNome();
	}

	/**
	 * Metodo que cria e adiciona um novo ItemPorQuantidade a uma lista que contem
	 * todos os itens.
	 *
	 * @param nome
	 *            Uma String que representa o nome do produto.
	 * @param categoria
	 *            Uma String que representa a categoria do item.
	 * @param qnt
	 *            Um inteiro que representa a quantidade de produtos que se
	 *            encontram na embalagem do item.
	 * @param unidadeDeMedida
	 *            Uma String que representa a unidade de medida do produto (gramas,
	 *            litros, etc.).
	 * @param localDeCompra
	 *            Uma String que representa onde o item foi comprado.
	 * @param preco
	 *            Um double que representa o valor do produto.
	 * @return Um inteiro que representa o identificador do produto.
	 */
	public int adicionaItemPorQtd(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra,
			double preco) {
		Item item = new ItemPorQuantidadeFixa(nome, categoria, qnt, unidadeDeMedida, localDeCompra, preco, this.id);
		itens.put(this.id, item);
		return this.id++;
	}

	/**
	 * Metodo que cria e adiciona um novo ItemPorQuilo a uma lista que contem todos
	 * os itens.
	 *
	 * @param nome
	 *            Uma String que representa o nome do produto.
	 * @param categoria
	 *            Uma String que representa a categoria do item.
	 * @param kg
	 *            Um double que representa o peso do item.
	 * @param localDeCompra
	 *            Uma String que representa onde o item foi comprado.
	 * @param preco
	 *            Um double que representa o valor do produto.
	 * @return Um inteiro que representa o identificador do produto.
	 */
	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		Item item = new ItemPorQuilo(nome, categoria, kg, localDeCompra, preco, this.id);
		itens.put(this.id, item);
		return this.id++;
	}

	/**
	 * Metodo que cria e adiciona um novo ItemPorUnidade a uma lista que contem
	 * todos os itens.
	 *
	 * @param nome
	 *            Uma String que representa o nome do produto.
	 * @param categoria
	 *            Uma String que representa a categoria do item.
	 * @param qnt
	 *            Um inteiro que representa a quantidade de produtos que se
	 *            encontram na embalagem do item.
	 * @param localDeCompra
	 *            Uma String que representa onde o item foi comprado.
	 * @param preco
	 *            Um double que representa o valor do produto.
	 * @return Um inteiro que representa o identificador do produto.
	 */
	public int adicionaItemPorUnidade(String nome, String categoria, int qnt, String localDeCompra, double preco) {
		Item item = new ItemPorUnidade(nome, categoria, qnt, localDeCompra, preco, this.id);
		itens.put(this.id, item);
		return this.id++;
	}

	/**
	 * Metodo que retorna uma String contendo a exibicao de um item.
	 *
	 * @param id
	 *            Um inteiro que representa o identificador de um item.
	 * @return Uma String que contem a exibicao de um item.
	 */
	public String exibeItem(int id) {
		if (id <= 0)
			throw new ArrayIndexOutOfBoundsException("Erro na listagem de item: id invalido.");
		if (!itens.containsKey(id))
			throw new NullPointerException("Erro na listagem de item: item nao existe.");
		return String.format("%d%s", id, itens.get(id).toString());
	}

	/**
	 * Metodo que atualiza o atributo de um item passando um novo valor para o
	 * atributo.
	 *
	 * @param id
	 *            Um inteiro que representa o identificador unico de um item.
	 * @param atributo
	 *            Uma String que representa o atributo a ser modificado.
	 * @param novoValor
	 *            Uma String que representa o novo valor para o item.
	 * 
	 *            Este metodo nao retorna nenhum valor.
	 */
	public void atualizaItem(int id, String atributo, String novoValor) {
		if (atributo == null)
			throw new NullPointerException("Erro na atualizacao de item: atributo nao pode ser vazio ou nulo.");

		if (atributo.trim().equals(""))
			throw new IllegalArgumentException("Erro na atualizacao de item: atributo nao pode ser vazio ou nulo.");

		if (novoValor == null)
			throw new NullPointerException(
					"Erro na atualizacao de item: novo valor de atributo nao pode ser vazio ou nulo.");

		if (novoValor.trim().equals(""))
			throw new IllegalArgumentException(
					"Erro na atualizacao de item: novo valor de atributo nao pode ser vazio ou nulo.");

		if (id <= 0)
			throw new ArrayIndexOutOfBoundsException("Erro na atualizacao de item: id invalido.");
		if (!itens.containsKey(id))
			throw new NullPointerException("Erro na atualizacao de item: item nao existe.");
		itens.get(id).atualizaItem(atributo, novoValor);
	}

	/**
	 * Metodo que adiciona um preco a um item.
	 *
	 * @param id
	 *            Um inteiro que representa o identificador de um item.
	 * @param localDeCompra
	 *            Uma String que representa o local de compra do item.
	 * @param preco
	 *            Um double que representa o valor do preco que será adicionado.
	 * 
	 *            Este método não retorna nenhum valor.
	 */
	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		if (id <= 0)
			throw new ArrayIndexOutOfBoundsException("Erro no cadastro de preco: id de item invalido.");
		if (!this.itens.containsKey(id))
			throw new NullPointerException("Erro no cadastro de preco: item nao existe.");
		itens.get(id).adicionaPrecoItem(localDeCompra, preco);
	}

	/**
	 * Metodo que remove um item a partir de seu id.
	 *
	 * @param id
	 *            Um inteiro que representa o identificador de um item.
	 * 
	 *            Este metodo nao retorna nenhum valor.
	 */
	public void deletaItem(int id) {
		if (id <= 0)
			throw new ArrayIndexOutOfBoundsException("Erro na remocao de item: id invalido.");
		if (!itens.containsKey(id))
			throw new IllegalArgumentException("Erro na remocao de item: item ja removido.");
		itens.remove(id);
	}

	// falta documentar daqui para baixo

	public String getItem(int posicao) {
		if (posicao < 0)
			throw new ArrayIndexOutOfBoundsException("Erro no cadastro de preco: id de item invalido.");
		ArrayList<Item> itensOrdenados = new ArrayList<>();
		for (Item item : this.itens.values()) {
			itensOrdenados.add(item);
		}

		Collections.sort(itensOrdenados, this.comparador);
		if (itensOrdenados.size() <= posicao) {
			return "";
		}
		return (itensOrdenados.get(posicao).getId()) + itensOrdenados.get(posicao).toString();
	}

	public String getItemPorCategoria(String categoria, int posicao) {
		if (posicao < 0)
			throw new ArrayIndexOutOfBoundsException("Erro no cadastro de preco: id de item invalido.");
		if (!(categoria.trim().toLowerCase().equals("alimento industrializado")
				|| categoria.trim().toLowerCase().equals("alimento nao industrializado")
				|| categoria.trim().toLowerCase().equals("higiene pessoal")
				|| categoria.trim().toLowerCase().equals("limpeza"))) {
			throw new IllegalArgumentException("Erro na listagem de item: categoria nao existe.");
		}
		ArrayList<Item> itensOrdenados = new ArrayList<>();
		for (Item item : this.itens.values()) {
			if (item.getCategoria().equals(categoria)) {
				itensOrdenados.add(item);
			}
		}
		Collections.sort(itensOrdenados, this.comparador);
		if (itensOrdenados.size() <= posicao) {
			return "";
		}
		return (itensOrdenados.get(posicao).getId()) + itensOrdenados.get(posicao).toString();
	}

	public String getItemPorMenorPreco(int posicao) {
		if (posicao < 0)
			throw new ArrayIndexOutOfBoundsException("Erro na listagem de item: id de item invalido.");
		this.comparador = new ComparaPreco();
		ArrayList<Item> itensOrdenados = new ArrayList<>();
		for (Item item : this.itens.values()) {
			itensOrdenados.add(item);
		}
		Collections.sort(itensOrdenados, this.comparador);
		if (itensOrdenados.size() <= posicao) {
			return "";
		}
		return (itensOrdenados.get(posicao).getId()) + itensOrdenados.get(posicao).toString();
	}

	public String getItemPorPesquisa(String strPesquisada, int posicao) {
		if (posicao < 0)
			throw new ArrayIndexOutOfBoundsException("Erro no cadastro de preco: id de item invalido.");
		this.comparador = new ComparaPreco();
		ArrayList<Item> itensOrdenados = new ArrayList<>();
		for (Item item : this.itens.values()) {
			for (String s : item.getNome().split(" ")) {
				if (s.toLowerCase().equals(strPesquisada.toLowerCase())) {
					itensOrdenados.add(item);
					break;
				}
			}
		}
		Collections.sort(itensOrdenados, this.comparador);
		if (itensOrdenados.size() <= posicao) {
			return "";
		}
		return (itensOrdenados.get(posicao).getId()) + itensOrdenados.get(posicao).toString();
	}

}
