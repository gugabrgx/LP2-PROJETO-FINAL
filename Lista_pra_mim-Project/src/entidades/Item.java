package entidades;

import java.util.Map;

/**
 * Laboratório de Programação 2 - Lista pra mim© Project
*Classe abstrata que representa um Item. Cada item base tem um nome, uma categoria
 * e precos. Nesta classe e possivel adicionar um preco a um item, pegar o nome do item,
 * pegar a categoria de um item, etc.
 *
 * @author Eduardo Henrique Pontes Silva - 117210360
 * @author Gustavo Santos - 117210400
 * @author Joao Pedro de Barros - 117210327
 * @author Rafael Azevedo - 117210382
 */
public abstract class Item {


    // Uma String que representa o nome de um item.
    protected String nome;
    // Uma String que representa a categoria de um item.
    protected String categoria;
    // Um Mapa que mapeia um valor em ponto flutuante a uma String.
    protected Map<String, Double> precos;
    private double menorPreco;


    /**
     * Testa os valors comuns entre os tipos de itens repassados pelo usuario e as atribui a suas devidas variaveis.
     *
     * @param nome          String que representa o nome do item;
     * @param categoria     String que representa a categoria do item;
     * @param localDeCompra String que representa o local de compra do item;
     * @param preco         Double que representa o preco do item no local de compra acima deifinido.
     */
    protected void itemGenerico(String nome, String categoria, String localDeCompra, double preco) {

        if (nome == null) throw new NullPointerException("Erro no cadastro de item: nome nao pode ser vazio ou nulo.");
        if (nome.trim().equals(""))
            throw new IllegalArgumentException("Erro no cadastro de item: nome nao pode ser vazio ou nulo.");

        if (categoria == null)
            throw new NullPointerException("Erro no cadastro de item: categoria nao pode ser vazia ou nula.");
        if (categoria.trim().equals(""))
            throw new IllegalArgumentException("Erro no cadastro de item: categoria nao pode ser vazia ou nula.");
        if (!(categoria.trim().toLowerCase().equals("alimento industrializado") ||
                categoria.trim().toLowerCase().equals("alimento nao industrializado") ||
                categoria.trim().toLowerCase().equals("higiene pessoal") || categoria.trim().toLowerCase().equals("limpeza"))) {
            throw new IllegalArgumentException("Erro no cadastro de item: categoria nao existe.");
        }

        if (localDeCompra == null)
            throw new NullPointerException("Erro no cadastro de item: local de compra nao pode ser vazio ou nulo.");
        if (localDeCompra.trim().length() == 0)
            throw new IllegalArgumentException("Erro no cadastro de item: local de compra nao pode ser vazio ou nulo.");

        if (preco < 0)
            throw new IllegalArgumentException("Erro no cadastro de item: preco de item invalido.");

        this.nome = nome;
        this.categoria = categoria;
        this.precos.put(localDeCompra, preco);

        this.menorPreco = preco;

    }

    /**
     * Metodo que atualiza os dados de um item de acordo com o solicitado pelo
     * usuario.
     *
     * @param atributo  Uma String que representa o atributo que sera atualizado.
     * @param novoValor Uma String que representa o novo valor para o atributo.
     *
     *                  Este metodo nao retorna nenhum valor.
     */
    public void atualizaItem(String atributo, String novoValor) {
        if (atributo.trim().toLowerCase().equals("nome")) {
            this.nome = novoValor;
        }

        if (atributo.trim().toLowerCase().equals("categoria")) {
            if (!(novoValor.trim().toLowerCase().equals("alimento industrializado") ||
                    novoValor.trim().toLowerCase().equals("alimento nao industrializado") ||
                    novoValor.trim().toLowerCase().equals("higiene pessoal") || novoValor.trim().toLowerCase().equals("limpeza"))) {
                throw new IllegalArgumentException("Erro na atualizacao de item: categoria nao existe.");
            }
            this.categoria = novoValor;
        }
    }

    /**
     * Metodo que adiciona um preco ao Mapa de precos.
     *
     * @param localDeCompra Uma String que representa o local de compra do produto.
     * @param preco         Um double que representa o valor de compra do produto.
     *                      <p>
     *                      Este metodo nao retorna nenhum valor.
     */
    public void adicionaPrecoItem(String localDeCompra, double preco) {
        if (localDeCompra == null)
            throw new NullPointerException("Erro no cadastro de preco: local de compra nao pode ser vazio ou nulo.");
        if (localDeCompra.trim().length() == 0)
            throw new IllegalArgumentException("Erro no cadastro de preco: local de compra nao pode ser vazio ou nulo.");
        if (preco <= 0) throw new IllegalArgumentException("Erro no cadastro de preco: preco de item invalido.");
        precos.put(localDeCompra, preco);
        if (preco < menorPreco) 
        	this.menorPreco = preco;

    }

    /**
     * Metodo que gera uma String contendo todos os precos de um determinado item.
     * <p>
     * Este metodo nao utiliza parametros.
     *
     * @return Uma String contendo todos os precos de um item.
     */
    protected String getListaPrecos() {
        StringBuilder listaDePrecos = new StringBuilder("<");
        for (String localDeCompra : precos.keySet()) {
            listaDePrecos.append(String.format("%s, R$ %.2f;", localDeCompra, precos.get(localDeCompra)));
        }
        return listaDePrecos.toString() + ">";
    }

    /**
     * Metodo que retorna o nome do item.
     * <p>
     * Este metodo nao utiliza parametros.
     *
     * @return Uma String que representa o nome do item.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Metodo que retorna a categoria do item.
     * <p>
     * Este metodo nao utiliza parametros.
     *
     * @return Uma String que representa a categoria do item.
     */
    public String getCategoria() {
        return this.categoria;
    }

    public double getMenorPreco() {
        return this.menorPreco;
    }

    /**
     * Metodo que retorna uma string contendo nome e categoria de um item.
     * <p>
     * Este metodo nao utiliza parametros.
     *
     * @return Uma String contendo nome e categoria de um item.
     */
    @Override
    public String toString() {
        return String.format(". %s, %s,", this.nome, this.categoria);
    }

    /**
     * Metodo hashCode que gera um inteiro que representa o hashcode de um Item
     * a partir de sua categoria e nome.
     * <p>
     * Este metodo nao utiliza parametros.
     *
     * @return Um inteiro que representa o hashcode de um Item.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    /**
     * Metodo equals que compara o objeto com outro a partir de sua categoria
     * e nome.
     *
     * @param obj Um objeto a ser comparado.
     * @return Um valor booleano que indica se os objetos sao iguais ou nao.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item other = (Item) obj;
        if (categoria == null) {
            if (other.categoria != null)
                return false;
        } else if (!categoria.equals(other.categoria))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }
}
