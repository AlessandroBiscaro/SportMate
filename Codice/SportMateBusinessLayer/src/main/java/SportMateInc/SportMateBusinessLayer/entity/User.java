package SportMateInc.SportMateBusinessLayer.entity;

import java.time.LocalDate;
import java.util.Set;


public class User {

    private String mail;
    private String name;
    private String cognome;
    private LocalDate dataNascita;
    private String telefono;
    private String password;
    private double credito;
    private Livello livello;
    
    
	public User(String mail, String name, String cognome, LocalDate dataNascita, String telefono, String password,
			double credito,Livello livello) {
	
		this.mail = mail;
		this.name = name;
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
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public double getCredito() {
		return credito;
	}


	public void setCredito(double credito) {
		this.credito = credito;
	}


	
	  public Livello getLivello() { 
		  return livello; 
	  }
	  
	  
	  public void setLivello(Livello livello) { 
		  this.livello = livello; 
		  }
	 
	

   
}
