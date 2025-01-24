package SportMateInc.SportMateBusinessLayer.services;

import static SportMateInc.SportMateBusinessLayer.tables.Serviziaggiuntivi.SERVIZIAGGIUNTIVI;

import java.util.ArrayList;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record3;
import org.jooq.Result;

import SportMateInc.SportMateBusinessLayer.entity.ServiziAgg;
import sportmateinc.sportmatedblayer.SportMateDB;

public class ServiziAggService {
	
private ServiziAggService() {}
	
	public static ServiziAgg findServizi(Integer idServizio) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create = db.getContext();
		Record result = create.select()
				.from(SERVIZIAGGIUNTIVI)
		.where(SERVIZIAGGIUNTIVI.IDSERVIZIO.eq(idServizio))
		.fetchOne();
		db.chiudiConnessione();
		return new ServiziAgg(result.get(SERVIZIAGGIUNTIVI.IDSERVIZIO), result.get(SERVIZIAGGIUNTIVI.NOMESERVIZIO), result.get(SERVIZIAGGIUNTIVI.DESCRIZIONE));
	}
	
	public static List<ServiziAgg> findAll() {
		SportMateDB db = SportMateDB.getInstance();
		List<ServiziAgg> list = new ArrayList<>();
		db.apriConnessione();
		DSLContext create = db.getContext();
		Result<Record3<Integer, String, String>> result = create.select(SERVIZIAGGIUNTIVI.IDSERVIZIO, SERVIZIAGGIUNTIVI.NOMESERVIZIO, SERVIZIAGGIUNTIVI.DESCRIZIONE).from(SERVIZIAGGIUNTIVI).fetch();
		db.chiudiConnessione();
		for (Record3<Integer, String, String> servizi : result) {
			list.add(new ServiziAgg(servizi.get(SERVIZIAGGIUNTIVI.IDSERVIZIO), servizi.get(SERVIZIAGGIUNTIVI.NOMESERVIZIO), servizi.get(SERVIZIAGGIUNTIVI.DESCRIZIONE)));
		}
		return list;
	}

}
