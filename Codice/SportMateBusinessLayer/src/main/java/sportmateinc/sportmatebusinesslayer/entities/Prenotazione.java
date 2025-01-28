package sportmateinc.sportmatebusinesslayer.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Prenotazione {
	
	private int idPartita;
	private int postiTot;
	private int pubblica;
	private int stato;
	private BigDecimal prezzo;
	private String modPagamento;
	private String nomeCentro;
	private LocalDateTime dataOra;
	private String tipoCampo;
	
	public int getIdPartita() {
		return idPartita;
	}

	public void setIdPartita(int idPartita) {
		this.idPartita = idPartita;
	}


	public int getPostiTot() {
		return postiTot;
	}


	public void setPostiTot(int postiTot) {
		this.postiTot = postiTot;
	}


	public int getPubblica() {
		return pubblica;
	}


	public void setPubblica(int pubblica) {
		this.pubblica = pubblica;
	}


	public int getStato() {
		return stato;
	}


	public void setStato(int stato) {
		this.stato = stato;
	}


	public String getModPagamento() {
		return modPagamento;
	}


	public void setModPagamento(String modPagamento) {
		this.modPagamento = modPagamento;
	}


	public String getNomeCentro() {
		return nomeCentro;
	}


	public void setNomeCentro(String nomeCentro) {
		this.nomeCentro = nomeCentro;
	}


	public LocalDateTime getDataOra() {
		return dataOra;
	}


	public void setDataOra(LocalDateTime dataOra) {
		this.dataOra = dataOra;
	}


	public BigDecimal getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}


	public String getTipoCampo() {
		return tipoCampo;
	}


	public void setTipoCampo(String tipoCampo) {
		this.tipoCampo = tipoCampo;
	}


	public String getNomecentro() {
		return nomeCentro;
	}


	public void setNomecentro(String nomecentro) {
		this.nomeCentro = nomecentro;
	}

	public Prenotazione(DisponibilitaUtente disponibilita, CentriSportivi centro,  Partita partita, TipoCampo tipoCampo) {
		this.idPartita = partita.getIdPartita();
		this.dataOra = disponibilita.getDataOra();
		this.modPagamento = partita.getModPagamento();
		this.nomeCentro = centro.getNomeComm();
		this.postiTot = disponibilita.getIdDisp();
		this.tipoCampo = tipoCampo.getNomeCampo();
	}
	
	
}
