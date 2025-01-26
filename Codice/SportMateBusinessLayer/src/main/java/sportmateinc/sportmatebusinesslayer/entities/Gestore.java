package sportmateinc.sportmatebusinesslayer.entities;

import java.time.LocalDate;

public class Gestore {

	private int idGestore;
	private String mail;
	private String nome;
	private String cognome;
	private LocalDate dataNascita;
	private String telefono;
	private String password;

	public Gestore(int idGestore, String mail, String nome, String cognome, LocalDate dataNascita, String telefono, String password) {
		
		this.idGestore = idGestore;
		this.mail = mail;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.telefono = telefono;
		this.password = password;
		
	}
	
	public int getIdGestore() {
		return idGestore;
	}

	public void setIdGestore(int idGestore) {
		this.idGestore = idGestore;
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

	public void setNome(String nome) {
		this.nome = nome;
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
	
	
	
}
