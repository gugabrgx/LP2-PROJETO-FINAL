package Controllers;

import java.util.HashMap;
import java.util.Map;

import entidades.Item;
import entidades.ItemPorQuantidadeFixa;
import entidades.ItemPorQuilo;
import entidades.ItemPorUnidade;

/**
 * Laboratório de Programação 2 - Lista pra mim© Project
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * 
 * Classe que representa o Controller. Nesta classe e possivel realizar operacoes como:
 * adicionar itens, exibir itens, atualizar itens, etc.
 */
public class Controller {

	// Um inteiro que representa o id de um Item.
	private int id;
	// Instanciacao de um objeto Item.
	private Item item;
	// Um Mapa que mapeia um Objeto Item para um inteiro.
	private Map<Integer, Item> itens;

	/**
	 * Metodo que inicializa um Controller.
	 * 
	 * Este metodo nao utiliza parametros.
	 * 
	 * Este metodo nao retorna nenhum valor.
	 */
	public void Controller() {
		this.id = 1;
		this.itens = new HashMap<>();
	}
	
	/**
	 * Metodo que cria e adiciona um novo ItemPorQuantidade a uma lista que contem todos os itens.
	 * 
	 * @param nome Uma String que representa o nome do produto.
	 * @param categoria Uma String que representa a categoria do item.
	 * @param qnt Um inteiro que representa a quantidade de produtos que se encontram na embalagem do item.
	 * @param unidadeDeMedida Uma String que representa a unidade de medida do produto (gramas, litros, etc.).
	 * @param localDeCompra Uma String que representa onde o item foi comprado.
	 * @param preco Um double que representa o valor do produto.
	 * 
	 * @return Um inteiro que representa o identificador do produto.
	 */
	public int adicionaItemPorQtd(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra, double preco) {
		item = new ItemPorQuantidadeFixa(nome, categoria, qnt, unidadeDeMedida, localDeCompra, preco);
		if (!this.itens.containsValue(item)) {
			itens.put(id, item);
			return this.id++;
		} else {
			throw new IllegalArgumentException("Erro no cadastro de item: item ja cadastrado");
		}
	}

	/**
	 * Metodo que cria e adiciona um novo ItemPorQuilo a uma lista que contem todos os itens.
	 * 
	 * @param nome Uma String que representa o nome do produto.
	 * @param categoria Uma String que representa a categoria do item.
	 * @param kg Um double que representa o peso do item.
	 * @param localDeCompra Uma String que representa onde o item foi comprado.
	 * @param preco Um double que representa o valor do produto.
	 * 
	 * @return Um inteiro que representa o identificador do produto.
	 */
	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		if (!this.itens.containsValue(item)) {
			item = new ItemPorQuilo(nome, categoria, kg, localDeCompra, preco);
			itens.put(id, item);
			return this.id++;
		} else {
			throw new IllegalArgumentException("Erro no cadastro de item: item ja cadastrado");
		}
	}

	/**
	 * Metodo que cria e adiciona um novo ItemPorUnidade a uma lista que contem todos os itens.
	 * 
	 * @param nome Uma String que representa o nome do produto.
	 * @param categoria Uma String que representa a categoria do item.
	 * @param qnt Um inteiro que representa a quantidade de produtos que se encontram na embalagem do item.
	 * @param localDeCompra Uma String que representa onde o item foi comprado.
	 * @param preco Um double que representa o valor do produto.
	 * 
	 * @return Um inteiro que representa o identificador do produto.
	 */
	public int adicionaItemPorUnidade(String nome, String categoria, int qnt, String localDeCompra, double preco) {
		item = new ItemPorUnidade(nome, categoria, qnt, localDeCompra, preco);
		if (!this.itens.containsValue(item)) {
			itens.put(id, item);
			return this.id++;
		} else {
			throw new IllegalArgumentException("Erro no cadastro de item: item ja cadastrado");
		}
	}

	/**
	 * Metodo que retorna uma String contendo a exibicao de um item.
	 * 
	 * @param id Um inteiro que representa o identificador de um item.
	 * 
	 * @return Uma String que contem a exibicao de um item.
	 */
	public String exibeItem(int id) {
		if (id <= 0) throw new ArrayIndexOutOfBoundsException("Erro na listagem de item: id invalido.");
		if (id > itens.size()) throw new ArrayIndexOutOfBoundsException("Erro na listagem de item: item nao existe.");
		if (!itens.containsKey(id)) throw new IllegalArgumentException("Erro na listagem de item: item nao existe.");
		return this.id + itens.get(id).toString();
	}

	/**
	 * Metodo que atualiza o atributo de um item passando um novo valor para o atributo.
	 * 
	 * @param id Um inteiro que representa o identificador unico de um item.
	 * @param atributo Uma String que representa o atributo a ser modificado. 
	 * @param novoValor Uma String que representa o novo valor para o item.
	 * 
	 * Este metodo nao retorna nenhum valor.
	 */
	public void atualizaItem(int id, String atributo, String novoValor) {
		if (id <= 0) throw new ArrayIndexOutOfBoundsException("Erro na atualizacao de item: id invalido.");
		if (id > itens.size()) throw new ArrayIndexOutOfBoundsException("Erro na atualizacao de item: item nao existe.");
		if (!itens.containsKey(id)) throw new IllegalArgumentException("Erro na atualizacao de item: item nao existe.");
		itens.get(id).atualizaItem(atributo, novoValor);
	}

	/**
	 * Metodo que adiciona um preco a um item.
	 * 
	 * @param id Um inteiro que representa o identificador de um item.
	 * @param localDeCompra Uma String que representa o local de compra do item.
	 * @param preco Um double que representa o valor do preco que será adicionado.
	 * 
	 * Este método não retorna nenhum valor.
	 */
	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		if (id <= 0) throw new ArrayIndexOutOfBoundsException("Erro no cadastro de preco: id de item invalido.");
		if (id > itens.size()) throw new ArrayIndexOutOfBoundsException("Erro no cadastro de preco: item nao existe.");
		if (!itens.containsKey(id)) throw new IllegalArgumentException("Erro no cadastro de preco: item nao existe.");
		itens.get(id).adicionaPrecoItem(localDeCompra, preco);
	}

	/**
	 * Metodo que remove um item a partir de seu id.
	 * 
	 * @param id Um inteiro que representa o identificador de um item.
	 * 
	 * Este metodo nao retorna nenhum valor.
	 */
	public void deletaItem(int id) {
		if (id <= 0) throw new ArrayIndexOutOfBoundsException("Erro na remocao de item: id invalido.");
		if (id > itens.size()) throw new ArrayIndexOutOfBoundsException("Erro na remocao de item: item nao existe.");
		if (!itens.containsKey(id)) throw new IllegalArgumentException("Erro na remocao de item: item ja removido.");
		itens.remove(id);
	}
}
