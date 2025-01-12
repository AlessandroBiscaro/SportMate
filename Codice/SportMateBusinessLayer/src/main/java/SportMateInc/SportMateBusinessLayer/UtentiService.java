package SportMateInc.SportMateBusinessLayer;

import sportmateinc.sportmatedblayer.SportMateDB;


import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.Record;

import SportMateInc.SportMateBusinessLayer.tables.Utenti;
public class UtentiService {
	
	public static Record findByUsername(String username) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create = DSL.using(db.getConnectionDetails(), SQLDialect.SQLITE);
		Record result = create.select()
		.from(Utenti.UTENTI)
		.where(Utenti.UTENTI.MAIL.eq(username)).fetchOne();
		db.chiudiConnessione();
		return result;
	}
	
	
}
