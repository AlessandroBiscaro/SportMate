package sportmateinc.sportmatebusinesslayer.entities;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Persona implements Serializable{

	private static final long serialVersionUID = 1L;
	protected Integer id;
	protected String mail;
	protected String nome;
	protected String cognome;
	protected LocalDate dataNascita;
	protected String telefono;
	protected String password;

	protected Persona(Integer id, String mail, String nome, String cognome, LocalDate dataNascita, String telefono,
			String password) {
		this.id = id;
		this.mail = mail;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.telefono = telefono;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer idUtente) {
		this.id = idUtente;
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

}