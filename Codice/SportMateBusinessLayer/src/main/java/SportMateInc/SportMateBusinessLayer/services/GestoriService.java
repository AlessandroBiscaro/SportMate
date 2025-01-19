package SportMateInc.SportMateBusinessLayer.services;

import sportmateinc.sportmatedblayer.SportMateDB;


import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.Record;

import SportMateInc.SportMateBusinessLayer.tables.Gestori;
public class GestoriService {
	
	public static Record findByUsername(String username) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create = DSL.using(db.getConnectionDetails(), SQLDialect.SQLITE);
		Record result = create.select()
		.from(Gestori.GESTORI)
		.where(Gestori.GESTORI.MAIL.eq(username)).fetchOne();
		db.chiudiConnessione();
		return result;
	}
}
