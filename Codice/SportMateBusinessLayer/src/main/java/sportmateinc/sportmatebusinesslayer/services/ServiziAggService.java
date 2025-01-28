package sportmateinc.sportmatebusinesslayer.services;

import static sportmateinc.sportmatebusinesslayergenerated.tables.Dettaglioservizicentri.DETTAGLIOSERVIZICENTRI;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Serviziaggiuntivi.SERVIZIAGGIUNTIVI;

import java.util.ArrayList;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record3;
import org.jooq.Result;

import sportmateinc.sportmatebusinesslayer.entities.ServiziAggiuntivi;
import sportmateinc.sportmatedblayer.SportMateDB;

public class ServiziAggService {
	
private ServiziAggService() {}
	
	public static ServiziAggiuntivi findServizi(Integer idServizio) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create = db.getContext();
		Record result = create.select()
				.from(SERVIZIAGGIUNTIVI)
		.where(SERVIZIAGGIUNTIVI.IDSERVIZIO.eq(idServizio))
		.fetchOne();
		db.chiudiConnessione();
		return new ServiziAggiuntivi(result.get(SERVIZIAGGIUNTIVI.IDSERVIZIO), result.get(SERVIZIAGGIUNTIVI.NOMESERVIZIO), result.get(SERVIZIAGGIUNTIVI.DESCRIZIONE));
	}
	
	public static List<ServiziAggiuntivi> findAll() {
		SportMateDB db = SportMateDB.getInstance();
		List<ServiziAggiuntivi> list = new ArrayList<>();
		db.apriConnessione();
		DSLContext create = db.getContext();
		Result<Record3<Integer, String, String>> result = create.select(SERVIZIAGGIUNTIVI.IDSERVIZIO, SERVIZIAGGIUNTIVI.NOMESERVIZIO, SERVIZIAGGIUNTIVI.DESCRIZIONE).from(SERVIZIAGGIUNTIVI).fetch();
		db.chiudiConnessione();
		for (Record3<Integer, String, String> servizi : result) {
			list.add(new ServiziAggiuntivi(servizi.get(SERVIZIAGGIUNTIVI.IDSERVIZIO), servizi.get(SERVIZIAGGIUNTIVI.NOMESERVIZIO), servizi.get(SERVIZIAGGIUNTIVI.DESCRIZIONE)));
		}
		return list;
	}
	
	public static int aggiungiServizioAgg(int idCentro, int idServizio) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create = db.getContext();
		int result = create.insertInto(DETTAGLIOSERVIZICENTRI, DETTAGLIOSERVIZICENTRI.IDCENTRO, DETTAGLIOSERVIZICENTRI.IDSERVIZIO)
					.values(idCentro, idServizio).execute();
		db.chiudiConnessione();
		return result;
	}

}
