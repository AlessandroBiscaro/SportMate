package SportMateInc.SportMateBusinessLayer.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Utente {

	private int idUtente;
	private String mail;
	private String nome;
	private String cognome;
	private LocalDate dataNascita;
	private String telefono;
	private String password;
	private BigDecimal credito;
	private Livello livello;

	public Utente(int idUtente, String mail, String nome, String cognome, LocalDate dataNascita, String telefono, String password,
			BigDecimal credito, Livello livello) {
		
		this.idUtente = idUtente;
		this.mail = mail;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.telefono = telefono;
		this.password = password;
		this.credito = credito;
		this.livello = livello;
	}

	
	
	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}



	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String name) {
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
