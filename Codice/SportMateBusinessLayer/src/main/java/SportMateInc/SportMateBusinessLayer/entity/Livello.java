package SportMateInc.SportMateBusinessLayer.entity;

public class Livello {

	private int idLivello;
	private String nomeLivello;
	public Livello(int idLivello, String nomeLivello) {
		
		this.idLivello = idLivello;
		this.nomeLivello = nomeLivello;
	}
	public int getIdLivello() {
		return idLivello;
	}
	public void setIdLivello(int idLivello) {
		this.idLivello = idLivello;
	}
	public String getNomeLivello() {
		return nomeLivello;
	}
	public void setNomeLivello(String nomeLivello) {
		this.nomeLivello = nomeLivello;
	}
	
	
}
