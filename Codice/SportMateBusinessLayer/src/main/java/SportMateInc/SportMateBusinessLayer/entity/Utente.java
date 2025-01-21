package SportMateInc.SportMateBusinessLayer.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Utente {

	private String mail;
	private String nome;
	private String cognome;
	private LocalDate dataNascita;
	private String telefono;
	private String password;
	private BigDecimal credito;
	private Livello livello;

	public Utente(String mail, String name, String cognome, LocalDate dataNascita, String telefono, String password,
			BigDecimal credito, Livello livello) {

		this.mail = mail;
		this.nome = name;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.telefono = telefono;
		this.password = password;
		this.credito = credito;
		this.livello = livello;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return nome;
	}

	public void setName(String name) {
		this.nome = name;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getCredito() {
		return credito;
	}

	public void setCredito(BigDecimal credito) {
		this.credito = credito;
	}

	public Livello getLivello() {
		return livello;
	}

	public void setLivello(Livello livello) {
		this.livello = livello;
	}

}
