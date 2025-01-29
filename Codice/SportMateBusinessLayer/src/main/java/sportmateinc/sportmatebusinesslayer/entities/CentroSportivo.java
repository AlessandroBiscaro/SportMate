package sportmateinc.sportmatebusinesslayer.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class CentroSportivo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idCentro;
	private String nomeComm;
	private String indirizzo;
	private BigDecimal latitudine;
	private BigDecimal longitudine;
	private BigDecimal credito;
	private String orarioApertura;
	private String orarioChiusura;
	private int idGestore;

	public CentroSportivo(int idCentro, String nomeCommerciale, String indirizzo, BigDecimal latitudine,
			BigDecimal longitudine, BigDecimal credito, String orarioApertura, String orarioChiusura, int idGestore) {
		this.idCentro = idCentro;
		this.nomeComm = nomeCommerciale;
		this.indirizzo = indirizzo;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		this.credito = credito;
		this.orarioApertura = orarioApertura;
		this.orarioChiusura = orarioChiusura;
		this.idGestore = idGestore;
	}

	public int getIdCentro() {
		return idCentro;
	}

	public void setIdCentro(int idCentro) {
		this.idCentro = idCentro;
	}

	public String getNomeComm() {
		return nomeComm;
	}

	public void setNomeComm(String nomeComm) {
		this.nomeComm = nomeComm;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public BigDecimal getLatitudine() {
		return latitudine;
	}

	public void setLatitudine(BigDecimal latitudine) {
		this.latitudine = latitudine;
	}

	public BigDecimal getLongitudine() {
		return longitudine;
	}

	public void setLongitudine(BigDecimal longitudine) {
		this.longitudine = longitudine;
	}

	public BigDecimal getCredito() {
		return credito;
	}

	public void setCredito(BigDecimal credito) {
		this.credito = credito;
	}

	public String getOrarioApertura() {
		return orarioApertura;
	}

	public void setOrarioApertura(String orarioApertura) {
		this.orarioApertura = orarioApertura;
	}

	public String getOrarioChiusura() {
		return orarioChiusura;
	}

	public void setOrarioChiusura(String orarioChiusura) {
		this.orarioChiusura = orarioChiusura;
	}

	public int getIdGestore() {
		return idGestore;
	}

	public void setIdGestore(int idGestore) {
		this.idGestore = idGestore;
	}

}
