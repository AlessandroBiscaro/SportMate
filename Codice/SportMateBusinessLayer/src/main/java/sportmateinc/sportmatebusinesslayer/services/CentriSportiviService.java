package sportmateinc.sportmatebusinesslayer.services;

import static sportmateinc.sportmatebusinesslayergenerated.tables.Centrisportivi.CENTRISPORTIVI;

import org.jooq.DSLContext;
import org.jooq.Record;

import sportmateinc.sportmatebusinesslayer.entities.CentroSportivo;
import sportmateinc.sportmatedblayer.SportMateDB;

public class CentriSportiviService {
	
	private CentriSportiviService() {}
	
	public static CentroSportivo findByIdGest(int idGest) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create = db.getContext();
		Record result = create.select()
				.from(CENTRISPORTIVI)
		.where(CENTRISPORTIVI.IDGESTORE.eq(idGest))
		.fetchOne();
		db.chiudiConnessione();
		return new CentroSportivo(result.get(CENTRISPORTIVI.IDCENTRO), 
						   result.get(CENTRISPORTIVI.NOMECOMMERCIALE),
						   result.get(CENTRISPORTIVI.INDIRIZZO),
						   result.get(CENTRISPORTIVI.LATITUDINE),
						   result.get(CENTRISPORTIVI.LONGITUDINE), 
						   result.get(CENTRISPORTIVI.CREDITO), 
						   result.get(CENTRISPORTIVI.ORARIOAPERTURA),
						   result.get(CENTRISPORTIVI.ORARIOCHIUSURA),
						   result.get(CENTRISPORTIVI.IDGESTORE));
	}
	
	public static CentroSportivo findByIdCentro(int idCentro) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create = db.getContext();
		Record result = create.select()
				.from(CENTRISPORTIVI)
		.where(CENTRISPORTIVI.IDCENTRO.eq(idCentro))
		.fetchOne();
		db.chiudiConnessione();
		return new CentroSportivo(result.get(CENTRISPORTIVI.IDCENTRO), 
						   result.get(CENTRISPORTIVI.NOMECOMMERCIALE),
						   result.get(CENTRISPORTIVI.INDIRIZZO),
						   result.get(CENTRISPORTIVI.LATITUDINE),
						   result.get(CENTRISPORTIVI.LONGITUDINE), 
						   result.get(CENTRISPORTIVI.CREDITO), 
						   result.get(CENTRISPORTIVI.ORARIOAPERTURA),
						   result.get(CENTRISPORTIVI.ORARIOCHIUSURA),
						   result.get(CENTRISPORTIVI.IDGESTORE));
	}
	
	public static int aggiungiCentro(CentroSportivo centro) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create =  db.getContext();	
		Record res= create.insertInto(CENTRISPORTIVI, CENTRISPORTIVI.NOMECOMMERCIALE, 
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
		.fetchOne();
		db.chiudiConnessione();
		return res.get(CENTRISPORTIVI.IDCENTRO);
	}
	
	public static int aggiornaDatiCentro(CentroSportivo centro) {
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
