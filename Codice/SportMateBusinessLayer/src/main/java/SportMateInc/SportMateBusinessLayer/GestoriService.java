package SportMateInc.SportMateBusinessLayer;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import sportmateinc.sportmatebusinesslayer.generated.tables.Gestori;
import sportmateinc.sportmatedblayer.SportMateDB;

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
