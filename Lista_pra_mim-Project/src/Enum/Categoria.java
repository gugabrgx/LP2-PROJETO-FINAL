package Enum;

/**
 * Laboratório de Programação 2 - Lab 2
 * 
 * 
 * 
 * @author Eduardo Henrique Pontes Silva - 117210360
 */

public enum Categoria {

	HIGIENEPESSOAL("higiene pessoal"), LIMPEZA("limpeza"), ALIMENTOSINDUSTRIALIZADOS("alimento industrializado"),
	ALIMENTOSNAOINDUSTRIALIZADOS("alimento nao industrializado");

	private String descricao;

	Categoria(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
