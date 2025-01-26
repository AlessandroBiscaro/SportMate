package sportmateinc.sportmatebusinesslayer.services;

import static sportmateinc.sportmatebusinesslayergenerated.tables.Centrisportivi.CENTRISPORTIVI;

import org.jooq.DSLContext;
import org.jooq.Record;

import sportmateinc.sportmatebusinesslayer.entity.CentriSportivi;
import sportmateinc.sportmatedblayer.SportMateDB;

public class CentriSportiviService {
	
	private CentriSportiviService() {}
	
	public static CentriSportivi findByIdGest(int idGest) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create = db.getContext();
		Record result = create.select()
				.from(CENTRISPORTIVI)
		.where(CENTRISPORTIVI.IDGESTORE.eq(idGest))
		.fetchOne();
		db.chiudiConnessione();
		return new CentriSportivi(result.get(CENTRISPORTIVI.IDCENTRO), 
						   result.get(CENTRISPORTIVI.NOMECOMMERCIALE),
						   result.get(CENTRISPORTIVI.INDIRIZZO),
						   result.get(CENTRISPORTIVI.LATITUDINE),
						   result.get(CENTRISPORTIVI.LONGITUDINE), 
						   result.get(CENTRISPORTIVI.CREDITO), 
						   result.get(CENTRISPORTIVI.ORARIOAPERTURA).toString(),
						   result.get(CENTRISPORTIVI.ORARIOCHIUSURA).toString(),
						   result.get(CENTRISPORTIVI.IDGESTORE));
	}
	
	public static CentriSportivi findByIdCentro(int idCentro) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create = db.getContext();
		Record result = create.select()
				.from(CENTRISPORTIVI)
		.where(CENTRISPORTIVI.IDCENTRO.eq(idCentro))
		.fetchOne();
		db.chiudiConnessione();
		return new CentriSportivi(result.get(CENTRISPORTIVI.IDCENTRO), 
						   result.get(CENTRISPORTIVI.NOMECOMMERCIALE),
						   result.get(CENTRISPORTIVI.INDIRIZZO),
						   result.get(CENTRISPORTIVI.LATITUDINE),
						   result.get(CENTRISPORTIVI.LONGITUDINE), 
						   result.get(CENTRISPORTIVI.CREDITO), 
						   result.get(CENTRISPORTIVI.ORARIOAPERTURA).toString(),
						   result.get(CENTRISPORTIVI.ORARIOCHIUSURA).toString(),
						   result.get(CENTRISPORTIVI.IDGESTORE));
	}
	
	public static int aggiungiCentro(CentriSportivi centro) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create =  db.getContext();	
		return create.insertInto(CENTRISPORTIVI, CENTRISPORTIVI.NOMECOMMERCIALE, 
				CENTRISPORTIVI.INDIRIZZO, CENTRISPORTIVI.LATITUDINE,
				CENTRISPORTIVI.LONGITUDINE, CENTRISPORTIVI.CREDITO,
				CENTRISPORTIVI.ORARIOAPERTURA,CENTRISPORTIVI.ORARIOCHIUSURA,
				CENTRISPORTIVI.IDGESTORE)
		.values( centro.getNomeComm(), 
				centro.getIndirizzo(), centro.getLatitudine(),
				centro.getLongitudine(), centro.getCredito(),
				centro.getOrarioApertura(),centro.getOrarioChiusura(),
				centro.getIdGestore())
		.returning(CENTRISPORTIVI.IDCENTRO)
		.execute();
	}
	
	public static int aggiornaDatiCentro(CentriSportivi centro) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create =  db.getContext();
		int result = create.update(CENTRISPORTIVI)
	            .set(CENTRISPORTIVI.NOMECOMMERCIALE, centro.getNomeComm())
	            .set(CENTRISPORTIVI.INDIRIZZO, centro.getIndirizzo())
	            .set(CENTRISPORTIVI.LATITUDINE, centro.getLatitudine()) 
	            .set(CENTRISPORTIVI.LONGITUDINE, centro.getLongitudine())
	            .set(CENTRISPORTIVI.CREDITO, centro.getCredito())
	            .set(CENTRISPORTIVI.ORARIOAPERTURA, centro.getOrarioApertura())
	            .set(CENTRISPORTIVI.ORARIOCHIUSURA, centro.getOrarioChiusura())
	            .set(CENTRISPORTIVI.IDGESTORE, centro.getIdGestore())
	            .where(CENTRISPORTIVI.IDCENTRO.eq(centro.getIdCentro())) 
	            .execute(); 
		db.chiudiConnessione();
		return result;
	}
	

}
