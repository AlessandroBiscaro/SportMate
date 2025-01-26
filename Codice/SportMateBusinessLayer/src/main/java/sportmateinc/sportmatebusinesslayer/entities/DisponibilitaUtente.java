package sportmateinc.sportmatebusinesslayer.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DisponibilitaUtente {
	
	private LocalDateTime dataOra;
	private BigDecimal prezzo;
	private String tipoCampo;
	private String nomecentro;
	public DisponibilitaUtente(String nomecentro, LocalDateTime dataOra, String tipoCampo, BigDecimal prezzo ) {
		this.nomecentro = nomecentro;
		this.dataOra = dataOra;
		this.prezzo = prezzo;
		this.tipoCampo = tipoCampo;
		
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

	
}
