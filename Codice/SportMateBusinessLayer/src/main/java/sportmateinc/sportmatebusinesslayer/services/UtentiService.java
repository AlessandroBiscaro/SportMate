package sportmateinc.sportmatebusinesslayer.services;

import org.jooq.DSLContext;

import sportmateinc.sportmatebusinesslayer.entities.Utente;
import sportmateinc.sportmatedblayer.SportMateDB;

import org.jooq.Record;
import org.jooq.impl.DSL;

import static sportmateinc.sportmatebusinesslayergenerated.tables.Utenti.UTENTI;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

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
		Record res = create.insertInto(UTENTI, UTENTI.NOME, UTENTI.COGNOME, UTENTI.DATANASCITA, UTENTI.MAIL, UTENTI.TELEFONO, UTENTI.PASSWORD, UTENTI.LIVELLO)
					.values(user.getNome(), 
							user.getCognome(), 
							user.getDataNascita().toString(), 
							user.getMail(), 
							user.getTelefono(), 
							user.getPassword(), 
							user.getLivello().getIdLivello()).returning(UTENTI.IDUTENTE)
					.fetchOne();
		db.chiudiConnessione();
		return res.get(UTENTI.IDUTENTE);
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
	            .where(UTENTI.IDUTENTE.eq(user.getId())) 
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
		db.chiudiConnessione();
		return count == 0;
	}
	
	public static boolean isMailUnique(String mail) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create = db.getContext();
		int count = create.fetchCount(DSL.selectFrom(UTENTI).where(UTENTI.MAIL.eq(mail)));
		db.chiudiConnessione();
		return count == 0;
	}

	public static int ricaricaCredito(Utente user , Double value) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create = db.getContext();
		db.chiudiConnessione();
		return create.update(UTENTI)
				.set(UTENTI.CREDITO, user.getCredito().add(BigDecimal.valueOf(value)).setScale(2, RoundingMode.HALF_UP))
				.where(UTENTI.IDUTENTE.eq(user.getId()))
				.execute();
	}
}
