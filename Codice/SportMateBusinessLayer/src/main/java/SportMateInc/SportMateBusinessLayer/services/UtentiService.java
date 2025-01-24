package SportMateInc.SportMateBusinessLayer.services;

import org.jooq.DSLContext;
import SportMateInc.SportMateBusinessLayer.entity.Utente;
import sportmateinc.sportmatedblayer.SportMateDB;

import org.jooq.Record;
import org.jooq.impl.DSL;
import org.jooq.exception.DataAccessException;
import org.jooq.exception.IntegrityConstraintViolationException;

import java.sql.SQLException;
import java.time.LocalDate;

import static SportMateInc.SportMateBusinessLayer.tables.Utenti.UTENTI;

public class UtentiService {
	
	public UtentiService() {}
 	
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
		int res = create.insertInto(UTENTI, UTENTI.NOME, UTENTI.COGNOME, UTENTI.DATANASCITA, UTENTI.MAIL, UTENTI.TELEFONO, UTENTI.PASSWORD, UTENTI.LIVELLO)
					.values(user.getNome(), 
							user.getCognome(), 
							user.getDataNascita().toString(), 
							user.getMail(), 
							user.getTelefono(), 
							user.getPassword(), 
							user.getLivello().getIdLivello()).returning(UTENTI.IDUTENTE)
					.execute();
		db.chiudiConnessione();
		return res;
	}
	
	
	public static int aggiornaDatiUtente(Utente user) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create =  db.getContext();
		int res = create.update(UTENTI)
	            .set(UTENTI.NOME, user.getNome())
	            .set(UTENTI.COGNOME, user.getCognome())
	            .set(UTENTI.MAIL, user.getMail())
	            .set(UTENTI.DATANASCITA, user.getDataNascita().toString()) 
	            .set(UTENTI.TELEFONO, user.getTelefono())
	            .set(UTENTI.PASSWORD, user.getPassword())
	            .set(UTENTI.LIVELLO, user.getLivello().getIdLivello())
	            .where(UTENTI.IDUTENTE.eq(user.getIdUtente())) 
	            .execute(); 
		db.chiudiConnessione();
		return res;
	}

	public static Utente findById(Integer id) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create = db.getContext();
		Record result = create.select()
				.from(UTENTI)
		.where(UTENTI.IDUTENTE.eq(id))
		.fetchOne();
		db.chiudiConnessione();
		return new Utente(result.get(UTENTI.IDUTENTE),result.get(UTENTI.MAIL), result.get(UTENTI.NOME),result.get(UTENTI.COGNOME), LocalDate.parse(result.get(UTENTI.DATANASCITA)), result.get(UTENTI.TELEFONO), result.get(UTENTI.PASSWORD),
				result.get(UTENTI.CREDITO), LivelliService.findLivello(result.get(UTENTI.LIVELLO)));
	}
	
	public static boolean isCellulareUnique(String cellulare) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create = db.getContext();
		int count = create.fetchCount(DSL.selectFrom(UTENTI).where(UTENTI.TELEFONO.eq(cellulare)));
		return count == 0;
	}
	
	public static boolean isMailUnique(String mail) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create = db.getContext();
		int count = create.fetchCount(DSL.selectFrom(UTENTI).where(UTENTI.MAIL.eq(mail)));
		return count == 0;
	}
}
