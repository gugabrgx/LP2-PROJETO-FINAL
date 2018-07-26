package entidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import controllers.ControllerItem;
import controllers.ControllerLista;

/**
 * Laboratório de Programação 2
 * 
 * @author Gustavo Santos - 117210400
 * @lab Laboratório
 */
public class Persistencia {

	private File diretorio;
	private ControllerItem cItem;
	private ControllerLista cLista;

	public Persistencia(ControllerItem cItem, ControllerLista cLista) {
		this.cItem = cItem;
		this.cLista = cLista;
		this.diretorio = new File("logs");
		diretorio.mkdir();
	}

	@SuppressWarnings("unchecked")
	public void iniciaSistema() throws IOException, ClassNotFoundException {
		FileInputStream ler = null;
		if (diretorio.isDirectory()) {
			try {
				ler = new FileInputStream("logs/system.log");
				ObjectInputStream objeto = new ObjectInputStream(ler);
				cItem.setId(((int) objeto.readObject()));
				cItem.setItens(((Map<Integer, Item>) objeto.readObject()));
				cLista.setListasDeCompras((Map<String, ListaDeCompras>) objeto.readObject());
				
				
				
				
				
				
			} catch (IOException e) {
				throw new IOException("Sistema iniciado pela primeira vez. Arquivo criado.");
			} finally {
				if (ler != null) {
					try {
						ler.close();
					} catch (IOException e) {
						throw new IOException(e);
					}
				}
			}
		}
	}

	public void fechaSistema() throws IOException {
		FileOutputStream salvar = null;
		if (diretorio.isDirectory()) {
			try {
				salvar = new FileOutputStream("logs/system.log");
				ObjectOutputStream objeto = new ObjectOutputStream(salvar);
				objeto.writeObject(cItem.getId());
				objeto.writeObject(cItem.getItens());
				objeto.writeObject(cLista.getListasDeCompras());
			} catch (IOException e) {
				throw new IllegalArgumentException(e.getMessage());
			} finally {
				if (salvar != null) {
					try {
						salvar.close();
					} catch (IOException e) {
						throw new IOException(e);
					}
				}
			}
		}

	}

}
