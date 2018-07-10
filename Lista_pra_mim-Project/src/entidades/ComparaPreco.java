package entidades;
import java.util.Comparator;
/**
*Esta classe ira usar o comparator para comparar os itens.
*/
public class ComparaPreco implements Comparator<Item> {
	
	/**
	*Este metodo compara os itens pelo seu preco.
	*/
	@Override
	public int compare(Item i1, Item i2) {
		return (int) Math.ceil(i1.getMenorPreco() - i2.getMenorPreco());
	}

}