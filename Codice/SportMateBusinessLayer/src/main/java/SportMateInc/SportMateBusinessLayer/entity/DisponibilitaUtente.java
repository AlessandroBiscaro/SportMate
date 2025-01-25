package SportMateInc.SportMateBusinessLayer.entity;



public class DisponibilitaUtente {
	
	private String dataOra;
	private String prezzo;
	private String tipoCampo;
	private String nomecentro;
	public DisponibilitaUtente(String dataOra, String prezzo, String tipoCampo, String nomecentro) {
		
		this.dataOra = dataOra;
		this.prezzo = prezzo;
		this.tipoCampo = tipoCampo;
		this.nomecentro = nomecentro;
	}
	public String getDataOra() {
		return dataOra;
	}
	public void setDataOra(String dataOra) {
		this.dataOra = dataOra;
	}
	public String getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(String prezzo) {
		this.prezzo = prezzo;
	}
	public String getTipoCampo() {
		return tipoCampo;
	}
	public void setTipoCampo(String tipoCampo) {
		this.tipoCampo = tipoCampo;
	}
	public String getNomecentro() {
		return nomecentro;
	}
	public void setNomecentro(String nomecentro) {
		this.nomecentro = nomecentro;
	}

	
}
