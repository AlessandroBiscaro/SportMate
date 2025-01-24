package SportMateInc.SportMateBusinessLayer.entity;

public class TipoCampo {
	
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
