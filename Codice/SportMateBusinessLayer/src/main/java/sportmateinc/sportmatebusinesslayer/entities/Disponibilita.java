package sportmateinc.sportmatebusinesslayer.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Disponibilita implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idDisp;
	private LocalDateTime dataOra;
	private BigDecimal prezzo;
	private TipoCampo tipoCampo;
	private CentroSportivo centro;
	private int prenotato;

	public Disponibilita(int idDisp, LocalDateTime localDateTime, BigDecimal prezzo, TipoCampo tipoCampo,
			CentroSportivo centro, int prenotato) {

		this.idDisp = idDisp;
		this.dataOra = localDateTime;
		this.prezzo = prezzo;
		this.tipoCampo = tipoCampo;
		this.centro = centro;
		this.prenotato = prenotato;
	}

	public Disponibilita() {
	}

	public int getIdDisp() {
		return idDisp;
	}

	public void setIdDisp(int idDisp) {
		this.idDisp = idDisp;
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

	public TipoCampo getTipoCampo() {
		return tipoCampo;
	}

	public void setTipoCampo(TipoCampo tipoCampo) {
		this.tipoCampo = tipoCampo;
	}

	public CentroSportivo getCentro() {
		return centro;
	}

	public void setCentro(CentroSportivo centro) {
		this.centro = centro;
	}

	public int getPrenotato() {
		return prenotato;
	}

	public void setPrenotato(int prenotato) {
		this.prenotato = prenotato;
	}

	public boolean getPrenotatoBoolean() {
		return prenotato == 1;
	}

	public void setPrenotatoBoolean(boolean prenotato) {
		if (prenotato)
			this.prenotato = 1;
		else
			this.prenotato = 0;
	}

}
