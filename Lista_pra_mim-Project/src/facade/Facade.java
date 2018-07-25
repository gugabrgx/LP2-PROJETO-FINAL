package facade;

import easyaccept.EasyAccept;

import java.text.SimpleDateFormat;
import java.util.Date;
import controllers.ControllerItem;
import controllers.ControllerLista;

/**
 * Laboratorio de Programacao 2 - Lista pra mim© Project
 * 
 * Representacao de uma Facade. A facade delega os metodos de um Sistema.
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */
public class Facade {

	/**
	 * Este atributo representa o objeto Controller.
	 */
	private ControllerItem controllerItem;
	private ControllerLista controllerLista;

	public static void main(String[] args) {
		args = new String[] { "facade.Facade", "acceptance_tests/use_case1.txt",
				"acceptance_tests/use_case1_exception.txt", "acceptance_tests/use_case2.txt",
				"acceptance_tests/use_case2_exception.txt", "acceptance_tests/use_case3.txt",
				"acceptance_tests/use_case3_exception.txt", "acceptance_tests/use_case4.txt",
				"acceptance_tests/use_case4_exception.txt", "acceptance_tests/use_case5.txt",
				"acceptance_tests/use_case7.txt" };

		EasyAccept.main(args);
	}

	/**
	 * Constroi o objeto Facade, e inicializa o objeto Controller.
	 */
	public Facade() {
		this.controllerItem = new ControllerItem();
		this.controllerLista = new ControllerLista(controllerItem);
	}

	/**
	 * Metodo que cria e adiciona um novo ItemPorQuantidade a uma lista que contem
	 * todos os itens.
	 *
	 * @param nome            Uma String que representa o nome do produto.
	 * @param categoria       Uma String que representa a categoria do item.
	 * @param qnt             Um inteiro que representa a quantidade de produtos que
	 *                        se encontram na embalagem do item.
	 * @param unidadeDeMedida Uma String que representa a unidade de medida do
	 *                        produto (gramas, litros, etc.).
	 * @param localDeCompra   Uma String que representa onde o item foi comprado.
	 * @param preco           Um double que representa o valor do produto.
	 * @return Um inteiro que representa o identificador do produto.
	 */
	public int adicionaItemPorQtd(String nome, String categoria, int qnt, String unidadeDeMedida, String localDeCompra,
			double preco) {
		return this.controllerItem.adicionaItemPorQtd(nome, categoria, qnt, unidadeDeMedida, localDeCompra, preco);
	}

	/**
	 * Metodo que cria e adiciona um novo ItemPorQuilo a uma lista que contem todos
	 * os itens.
	 *
	 * @param nome          Uma String que representa o nome do produto.
	 * @param categoria     Uma String que representa a categoria do item.
	 * @param kg            Um double que representa o peso do item.
	 * @param localDeCompra Uma String que representa onde o item foi comprado.
	 * @param preco         Um double que representa o valor do produto.
	 * @return Um inteiro que representa o identificador do produto.
	 */
	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		return this.controllerItem.adicionaItemPorQuilo(nome, categoria, kg, localDeCompra, preco);
	}

	/**
	 * Metodo que cria e adiciona um novo ItemPorUnidade a uma lista que contem
	 * todos os itens.
	 *
	 * @param nome          Uma String que representa o nome do produto.
	 * @param categoria     Uma String que representa a categoria do item.
	 * @param qnt           Um inteiro que representa a quantidade de produtos que
	 *                      se encontram na embalagem do item.
	 * @param localDeCompra Uma String que representa onde o item foi comprado.
	 * @param preco         Um double que representa o valor do produto.
	 * @return Um inteiro que representa o identificador do produto.
	 */
	public int adicionaItemPorUnidade(String nome, String categoria, int qnt, String localDeCompra, double preco) {
		return this.controllerItem.adicionaItemPorUnidade(nome, categoria, qnt, localDeCompra, preco);
	}

	/**
	 * Metodo que retorna uma String contendo a exibicao de um item.
	 *
	 * @param id Um inteiro que representa o identificador de um item.
	 * @return Uma String que contem a exibicao de um item.
	 */
	public String exibeItem(int id) {
		return this.controllerItem.exibeItem(id);
	}

	/**
	 * Metodo que atualiza o atributo de um item passando um novo valor para o
	 * atributo.
	 *
	 * @param id        Um inteiro que representa o identificador unico de um item.
	 * @param atributo  Uma String que representa o atributo a ser modificado.
	 * @param novoValor Uma String que representa o novo valor para o item.
	 *
	 *                  Este metodo nao retorna nenhum valor.
	 */
	public void atualizaItem(int id, String atributo, String novoValor) {
		this.controllerItem.atualizaItem(id, atributo, novoValor);
	}

	/**
	 * Metodo que adiciona um preco a um item.
	 *
	 * @param id            Um inteiro que representa o identificador de um item.
	 * @param localDeCompra Uma String que representa o local de compra do item.
	 * @param preco         Um double que representa o valor do preco que será
	 *                      adicionado.
	 *
	 *                      Este método não retorna nenhum valor.
	 */
	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		this.controllerItem.adicionaPrecoItem(id, localDeCompra, preco);
	}

	/**
	 * Metodo que remove um item a partir de seu id.
	 *
	 * @param id Um inteiro que representa o identificador de um item.
	 *
	 *           Este metodo nao retorna nenhum valor.
	 */
	public void deletaItem(int id) {
		this.controllerItem.deletaItem(id);
	}

	/**
	 * Metodo que ordena os itens por ordem alfabetica.
	 *
	 * @param posicao A posicao em que o item esta posicionado ordenadamente.
	 * @return Uma String que contem a exibicao de um item.
	 */
	public String getItem(int posicao) {
		return this.controllerItem.getItem(posicao);
	}

	/**
	 * Metodo que lista em ordem alfabetica os itens de uma dada categoria.
	 * 
	 * @param posicao   A posicao em que o item esta posicionado ordenadamente.
	 * @param categoria catergoria que sera realizada a pesquisa.
	 * @return Uma String que contem a exibicao de um item.
	 */
	public String getItemPorCategoria(String categoria, int posicao) {
		return this.controllerItem.getItemPorCategoria(categoria, posicao);
	}

	/**
	 * Metodo que ordena os itens por preco.
	 *
	 * @param posicao A posicao em que o item esta posicionado ordenadamente.
	 * @return Uma String que contem a exibicao de um item.
	 */
	public String getItemPorMenorPreco(int posicao) {
		return this.controllerItem.getItemPorMenorPreco(posicao);
	}

	/**
	 * Metodo que ordena os itens relacionados a uma dada string de pesquisa e a
	 * listagem deve ocorrer em ordem alfabética considerando a representação em
	 * string do item.
	 * 
	 * @param posicao       A posicao em que o item esta posicionado ordenadamente.
	 * @param strPesquisada parametro de pesquisa.
	 * @return Uma String que contem a exibicao de um item.
	 */
	public String getItemPorPesquisa(String strPesquisada, int posicao) {
		return this.controllerItem.getItemPorPesquisa(strPesquisada, posicao);
	}

	/**
	 * Cria uma nova lista de compras.
	 * 
	 * @param descritorLista O descritor da lista.
	 * @return em String o descritor da lista.
	 */
	public String adicionaListaDeCompras(String descritorLista) {
		return this.controllerLista.adicionaListaDeCompras(descritorLista);
	}

	/**
	 * Este metodo adiciona um item com sua quantidade, em uma determinada lista.
	 * 
	 * @param descritorLista O descritor da lista.
	 * @param quantidade     A quantidade do item.
	 * @param itemId         O item a ser adicionado na lista.
	 */
	public void adicionaCompraALista(String descritorLista, int quantidade, int itemId) {
		this.controllerLista.adicionaCompraALista(descritorLista, quantidade, itemId);
	}

	/**
	 * Este metodo finaliza uma lista de compras.
	 * 
	 * @param descritorLista     O descritor da lista.
	 * @param localDaCompra      O local de compra da lista.
	 * @param valorFinalDaCompra O valor final da compra.
	 */
	public void finalizarListaDeCompras(String descritorLista, String localDaCompra, int valorFinalDaCompra) {
		this.controllerLista.finalizarListaDeCompras(descritorLista, localDaCompra, valorFinalDaCompra);
	}

	/**
	 * Este metodo recupera uma lista a partir de sua desccricao.
	 * 
	 * @param descritorLista O descritor da lista.
	 * @return em String a representacao de uma lista.
	 */
	public String pesquisaListaDeCompras(String descritorLista) {
		return this.controllerLista.pesquisaListaDeCompras(descritorLista);

	}

	/**
	 * Este metodo pesquisa uma item em uma lista.
	 * 
	 * @param descritorLista O descritor da lista.
	 * @param itemId         o ID do item.
	 * @return em String o item pesquisado na lista.
	 */
	public String pesquisaCompraEmLista(String descritorLista, int itemId) {
		return this.controllerLista.pesquisaCompraEmLista(descritorLista, itemId);
	}

	/**
	 * Este metodo atualiza a quantidade de um item, emm uma determinada lista.
	 * 
	 * @param descritorLista O descritor da lista.
	 * @param itemId         O ID do item.
	 * @param quantidade     A quantidade nova do item.
	 * @param operacao       A operacao de diminuir ou aumentar a quantidade do
	 *                       item.
	 */
	public void atualizaCompraDeLista(String descritorLista, int itemId, String operacao, int quantidade) {
		this.controllerLista.atualizaCompraDeLista(descritorLista, itemId, quantidade, operacao);
	}

	/**
	 * Este metodo recupra um item de uma lsita, a partir de sua posicao.
	 * 
	 * @param descritorLista O descritor da lista.
	 * @param posicaoItem    A posicao do Item.
	 * @return em String a representacao de um item.
	 */
	public String getItemLista(String descritorLista, int posicaoItem) {
		return this.controllerLista.getItemLista(descritorLista, posicaoItem);
	}

	/**
	 * Este metodo deleta uma compra de uma lista, pelo id do item.
	 * 
	 * @param descritorLista O descritor da lista.
	 * @param itemId         O ID do item.
	 */
	public void deletaCompraDeLista(String descritorLista, int itemId) {
		this.controllerLista.deletaCompraDeLista(descritorLista, itemId);
	}

	/**
	 * Este metodo recupera uma lista de compras a partir de sua data, e sua
	 * posicao.
	 * 
	 * @param data         A data da lista.
	 * @param posicaoLista A posicao da Lista
	 * @return em String o nome da lista de compras.
	 */
	public String getItemListaPorData(String data, int posicaoLista) {
		return this.controllerLista.getItemListaPorData(data, posicaoLista);
	}

	/**
	 * Recupera lista de compra a partir do id de um item, e tambem a partir da
	 * posicao.
	 * 
	 * @param id           O id do item.
	 * @param posicaoLista A posicao da lista.
	 * @return em String a representacao de umal ista de compras.
	 */
	public String getItemListaPorItem(int id, int posicaoLista) {
		return this.controllerLista.getItemListaPorItem(id, posicaoLista);
	}

	/**
	 * Metodo que retorna listas de compra pela data passa como parametro.
	 * 
	 * 
	 * @param data A data.
	 * @return em String a representacao contendo a(s) lista(s) com a data passada
	 *         como parametro.
	 */
	public String pesquisaListasDeComprasPorData(String data) {
		return this.controllerLista.pesquisaListasDeComprasPorData(data);
	}

	/**
	 * Metodo que retorna as listas que contem determinado item.
	 * 
	 * @param id O id do item.
	 * @return A representacao de varias listas que contem o item.
	 */
	public String pesquisaListasDeComprasPorItem(int id) {
		return this.controllerLista.pesquisaListasDeComprasPorItem(id);
	}

	/**
	 * MEtodo que retorna a data atual.
	 * 
	 * @return em String a representacao da data atual.
	 */
	public String dataAtual() {
		return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	}

	public String geraAutomaticaUltimaLista() {
		return this.controllerLista.geraAutomaticaUltimaLista();
	}

	public String geraAutomaticaItem(String descritorItem) {
		return this.controllerLista.geraAutomaticaItem(descritorItem);
	}

	public String geraAutomaticaItensMaisPresentes() {
		return this.controllerLista.geraAutomaticaItensMaisPresentes();
	}

}
