package SportMateInc.SportMateBusinessLayer.services;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record2;
import org.jooq.Result;

import SportMateInc.SportMateBusinessLayer.entity.Livello;
import sportmateinc.sportmatedblayer.SportMateDB;
import static SportMateInc.SportMateBusinessLayer.tables.Livelli.LIVELLI;

import java.util.ArrayList;
import java.util.List;

public class LivelliService {
	
	private LivelliService() {}
	
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
	
	public static List<Livello> findAll() {
		SportMateDB db = SportMateDB.getInstance();
		List<Livello> list = new ArrayList<>();
		db.apriConnessione();
		DSLContext create = db.getContext();
		Result<Record2<Integer, String>> result = create.select(LIVELLI.IDLIVELLO, LIVELLI.NOMELIVELLO).from(LIVELLI).fetch();
		db.chiudiConnessione();
		for (Record2<Integer, String> livello : result) {
			list.add(new Livello(livello.get(LIVELLI.IDLIVELLO), livello.get(LIVELLI.NOMELIVELLO)));
		}
		return list;
	}
}
