package Enum;

/**
 * Laboratório de Programação 2 - Lab 2
 *
 *
 * @author Rafael Dantas Santos de Azevedo - 117210382
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public enum Categoria {

	// Declaracao de cada enum com sua descricao.
	HIGIENEPESSOAL("higiene pessoal"), LIMPEZA("limpeza"), ALIMENTOSINDUSTRIALIZADOS(
			"alimento industrializado"), ALIMENTOSNAOINDUSTRIALIZADOS("alimento nao industrializado");

	// Atributo que representa a descricao dos enuns.
	private String descricao;

	/**
	 * Constroi o objeto Categoria.
	 *
	 * @param descricao
	 *            A descricao de cada enunm.
	 */
	Categoria(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * Metodo acessorio que retorna a descricao de um enum.
	 *
	 * @return uma String representadno a descricao do enum.
	 */
	public String getDescricao() {
		return descricao;
	}
}
