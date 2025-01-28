package sportmateinc.sportmatebusinesslayer.entities;

import java.io.Serializable;

public class Livello implements Serializable{

	private static final long serialVersionUID = 1L;
	private final int idLivello;
	private final String nomeLivello;
	
	public Livello(int idLivello, String nomeLivello) {
		this.idLivello = idLivello;
		this.nomeLivello = nomeLivello;
	}
	
	public int getIdLivello() {
		return idLivello;
	}
	public String getNomeLivello() {
		return nomeLivello;
	}
}
