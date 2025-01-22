package SportMateInc.SportMateBusinessLayer.services;

import sportmateinc.sportmatedblayer.SportMateDB;

import org.jooq.DSLContext;

import SportMateInc.SportMateBusinessLayer.entity.Gestore;
import SportMateInc.SportMateBusinessLayer.entity.Utente;

import org.jooq.Record;

import static SportMateInc.SportMateBusinessLayer.tables.Gestori.GESTORI;
import static SportMateInc.SportMateBusinessLayer.tables.Utenti.UTENTI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class UtentiService {
	
	private UtentiService() {}
 	
	public static Utente findByUsername(String username) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create = db.getContext();
		Record result = create.select()
				.from(UTENTI)
		.where(UTENTI.MAIL.eq(username))
		.fetchOne();
		db.chiudiConnessione();
		return new Utente(result.get(UTENTI.IDUTENTE),result.get(UTENTI.MAIL), result.get(UTENTI.NOME),result.get(UTENTI.COGNOME), LocalDate.parse(result.get(UTENTI.DATANASCITA)), result.get(UTENTI.TELEFONO), result.get(UTENTI.PASSWORD),
				result.get(UTENTI.CREDITO), LivelliService.findLivello(result.get(UTENTI.LIVELLO)));
	}

	
	public static int aggiungiUtente(Utente user) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		
		DSLContext create =  db.getContext();
				
		return create.insertInto(UTENTI, UTENTI.IDUTENTE, UTENTI.NOME, UTENTI.COGNOME, UTENTI.DATANASCITA, UTENTI.MAIL, UTENTI.TELEFONO, UTENTI.PASSWORD, UTENTI.LIVELLO)
		.values(user.getIdUtente(), 
				user.getNome(), 
				user.getCognome(), 
				DateTimeFormatter.ofPattern("YYYY/MM/DD").format(user.getDataNascita()), 
				user.getMail(), 
				user.getTelefono(), 
				user.getPassword(), 
				user.getLivello().getIdLivello())
		.execute();
	}
	
	
	public static int AggiornaDatiUtente(Utente user) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create =  db.getContext();
		return create.update(UTENTI)
	            .set(UTENTI.NOME, user.getNome())
	            .set(UTENTI.COGNOME, user.getCognome())
	            .set(UTENTI.MAIL, user.getMail())
	            .set(UTENTI.DATANASCITA, DateTimeFormatter.ofPattern("YYYY/MM/DD").format(user.getDataNascita())) 
	            .set(UTENTI.TELEFONO, user.getTelefono())
	            .set(UTENTI.PASSWORD, user.getPassword())
	            .set(UTENTI.LIVELLO, user.getLivello().getIdLivello())
	            .where(UTENTI.IDUTENTE.eq(user.getIdUtente())) 
	            .execute(); 
	}
}
