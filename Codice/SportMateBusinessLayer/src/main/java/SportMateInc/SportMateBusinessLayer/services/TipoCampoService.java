package SportMateInc.SportMateBusinessLayer.services;

import static SportMateInc.SportMateBusinessLayer.tables.Tipologiecampo.TIPOLOGIECAMPO;
import static SportMateInc.SportMateBusinessLayer.tables.Dettagliotipologiecentri.DETTAGLIOTIPOLOGIECENTRI;

import java.util.ArrayList;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record2;
import org.jooq.Result;

import SportMateInc.SportMateBusinessLayer.entity.CentriSportivi;
import SportMateInc.SportMateBusinessLayer.entity.TipoCampo;
import sportmateinc.sportmatedblayer.SportMateDB;

public class TipoCampoService {
	
	private TipoCampoService() {}
	
	public static TipoCampo findTipoCampo(Integer idCampo) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create = db.getContext();
		Record result = create.select()
				.from(TIPOLOGIECAMPO)
		.where(TIPOLOGIECAMPO.IDTIPOLOGIA.eq(idCampo))
		.fetchOne();
		db.chiudiConnessione();
		return new TipoCampo(result.get(TIPOLOGIECAMPO.IDTIPOLOGIA), result.get(TIPOLOGIECAMPO.NOMETIPOLOGIA));
	}
	
	public static List<TipoCampo> findAll() {
		SportMateDB db = SportMateDB.getInstance();
		List<TipoCampo> list = new ArrayList<>();
		db.apriConnessione();
		DSLContext create = db.getContext();
		Result<Record2<Integer, String>> result = create.select(TIPOLOGIECAMPO.IDTIPOLOGIA, TIPOLOGIECAMPO.NOMETIPOLOGIA).from(TIPOLOGIECAMPO).fetch();
		db.chiudiConnessione();
		for (Record2<Integer, String> livello : result) {
			list.add(new TipoCampo(livello.get(TIPOLOGIECAMPO.IDTIPOLOGIA), livello.get(TIPOLOGIECAMPO.NOMETIPOLOGIA)));
		}
		return list;
	}
	
	public static int aggiungiTipoCampo(int idCentro, int idTipo) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create = db.getContext();
		int result = create.insertInto(DETTAGLIOTIPOLOGIECENTRI, DETTAGLIOTIPOLOGIECENTRI.IDCENTRO, DETTAGLIOTIPOLOGIECENTRI.IDTIPOLOGIA)
					.values(idCentro, idTipo).execute();
		db.chiudiConnessione();
		return result;
	}

}
