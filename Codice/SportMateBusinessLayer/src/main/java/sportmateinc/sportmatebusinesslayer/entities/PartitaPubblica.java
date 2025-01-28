package sportmateinc.sportmatebusinesslayer.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PartitaPubblica {
	
	private int idPartita;
	private LocalDateTime dataOra;
	private BigDecimal prezzo;
	private String tipoCampo;
	private String nomecentro;
	private int postiTotali;

	
	public PartitaPubblica(int idPartita, String nomecentro, LocalDateTime dataOra, String tipoCampo
			, BigDecimal prezzo,int postiTotali) {
		this.idPartita = idPartita;
		this.dataOra = dataOra;
		this.prezzo = prezzo;
		this.tipoCampo = tipoCampo;
		this.nomecentro = nomecentro;
		this.postiTotali = postiTotali;
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
		return nomecentro;
	}
	public void setNomecentro(String nomecentro) {
		this.nomecentro = nomecentro;
	}
	public int getIdPartita() {
		return idPartita;
	}
	public void setIdPartita(int idPartita) {
		this.idPartita = idPartita;
	}
	public int getPostiTotali() {
		return postiTotali;
	}
	public void setPostiTotali(int postiTotali) {
		this.postiTotali = postiTotali;
	}
	
	

}
