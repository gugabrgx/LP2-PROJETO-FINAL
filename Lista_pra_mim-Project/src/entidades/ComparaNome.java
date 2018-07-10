package entidades;
import java.util.Comparator;
/**
*Esta classe ira usar o comparator para comparar os itens.
*/
public class ComparaNome implements Comparator<Item> {
	
	/**
	*Este metodo compara os itens pelo seu nome.
	*/
	@Override
	public int compare(Item i1, Item i2) {
		return i1.getNome().compareTo(i2.getNome());
	}

}
