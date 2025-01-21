package SportMateInc.SportMateBusinessLayer.services;

import org.jooq.DSLContext;
import org.jooq.Record;

import SportMateInc.SportMateBusinessLayer.entity.Livello;
import sportmateinc.sportmatedblayer.SportMateDB;
import static SportMateInc.SportMateBusinessLayer.tables.Livelli.LIVELLI;;

public class LivelliService {
	
	public static Livello findLivello(Integer idLivello) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create = db.getContext();
		Record result = create.select()
				.from(LIVELLI)
		.where(LIVELLI.IDLIVELLO.eq(idLivello))
		.fetchOne();
		db.chiudiConnessione();
		return new Livello(result.get(LIVELLI.IDLIVELLO), result.get(LIVELLI.NOMELIVELLO));
	}
}
