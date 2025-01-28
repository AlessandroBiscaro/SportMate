package sportmateinc.sportmatebusinesslayer.entities;

import java.io.Serializable;

public class TipoCampo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private final int idCampo;
	private final String nomeCampo;
	
	public TipoCampo(int idCampo, String nomeCampo) {
		this.idCampo = idCampo;
		this.nomeCampo = nomeCampo;
	}

	public int getIdCampo() {
		return idCampo;
	}

	public String getNomeCampo() {
		return nomeCampo;
	}
	
	

}
