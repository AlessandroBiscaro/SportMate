package sportmateinc.sportmatebusinesslayer.entities;

public class Livello {

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
