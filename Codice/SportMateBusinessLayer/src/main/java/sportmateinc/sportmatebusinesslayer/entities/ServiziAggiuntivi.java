package sportmateinc.sportmatebusinesslayer.entities;

public class ServiziAggiuntivi {
	
	private final int idServizio;
	private final String nomeServizio;
	private final String descrizione;
	public ServiziAggiuntivi(int idServizio, String nomeServizio, String descrizione) {
		this.idServizio = idServizio;
		this.nomeServizio = nomeServizio;
		this.descrizione = descrizione;
	}
	public int getIdServizio() {
		return idServizio;
	}
	public String getNomeServizio() {
		return nomeServizio;
	}
	public String getDescrizione() {
		return descrizione;
	}
	

	
	
}
