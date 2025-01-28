package sportmateinc.sportmatebusinesslayer.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Utente extends Persona {

	private static final long serialVersionUID = 1L;
	private BigDecimal credito;
	private Livello livello;

	public Utente(int idUtente, String mail, String nome, String cognome, LocalDate dataNascita, String telefono, String password,
			BigDecimal credito, Livello livello) {
		
		super(idUtente, mail, nome, cognome, dataNascita, telefono, password);
		this.credito = credito;
		this.livello = livello;
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
