package SportMateInc.SportMateBusinessLayer.services;

import sportmateinc.sportmatedblayer.SportMateDB;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.Record;

import static SportMateInc.SportMateBusinessLayer.tables.Utenti.UTENTI;

import java.sql.SQLException;
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
	
}
