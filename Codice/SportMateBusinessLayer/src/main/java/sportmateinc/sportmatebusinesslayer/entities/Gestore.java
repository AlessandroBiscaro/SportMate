package sportmateinc.sportmatebusinesslayer.entities;

import java.time.LocalDate;

public class Gestore extends Persona {

	private static final long serialVersionUID = 1L;

	public Gestore(Integer id, String mail, String nome, String cognome, LocalDate dataNascita, String telefono,
			String password) {
		super(id, mail, nome, cognome, dataNascita, telefono, password);
	}

}
