package SportMateInc.SportMateBusinessLayer.services;

import sportmateinc.sportmatedblayer.SportMateDB;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import SportMateInc.SportMateBusinessLayer.entity.Livello;
import SportMateInc.SportMateBusinessLayer.entity.User;

import org.jooq.Record;

import static SportMateInc.SportMateBusinessLayer.tables.Utenti.UTENTI;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
public class UtentiService {
	
	private static final Logger LOGGER = LogManager.getLogger(UtentiService.class);
	
	private UtentiService() {}
 	
	public static Record findByUsername(String username) {
	SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create = DSL.using(db.getConnectionDetails(), SQLDialect.SQLITE);
		Record result = create.select(UTENTI.MAIL, UTENTI.PASSWORD)
				.from(UTENTI)
		.where(UTENTI.MAIL.eq(username))
		.fetchOne();
		db.chiudiConnessione();
		return result;
	}

	public static void main(String[] args) {
		System.out.println(findByUsername("t.fabbris@studenti.unibg.it"));
	}
	
	
	public static int aggiungiUtente(User user) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		
		DSLContext create = DSL.using(db.getConnectionDetails(), SQLDialect.SQLITE);
				
		return create.insertInto(UTENTI, UTENTI.NOME, UTENTI.COGNOME, UTENTI.DATANASCITA, UTENTI.MAIL, UTENTI.TELEFONO, UTENTI.PASSWORD, UTENTI.LIVELLO)
		.values(user.getName(), user.getCognome(), DateTimeFormatter.ofPattern("YYYY/MM/DD").format(user.getDataNascita()), user.getMail(), user.getTelefono(), user.getPassword(), user.getLivello().getIdLivello())
		.execute();
	}
	
}
