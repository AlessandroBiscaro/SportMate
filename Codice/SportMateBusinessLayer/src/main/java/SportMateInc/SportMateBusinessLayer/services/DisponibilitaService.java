package SportMateInc.SportMateBusinessLayer.services;


import static SportMateInc.SportMateBusinessLayer.tables.Disponibilita.DISPONIBILITA;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record4;
import org.jooq.Record6;
import org.jooq.Result;
import org.jooq.impl.DSL;


import SportMateInc.SportMateBusinessLayer.entity.CentriSportivi;
import SportMateInc.SportMateBusinessLayer.entity.Disponibilita;
import SportMateInc.SportMateBusinessLayer.entity.DisponibilitaUtente;
import SportMateInc.SportMateBusinessLayer.entity.ServiziAgg;
import SportMateInc.SportMateBusinessLayer.entity.TipoCampo;
import sportmateinc.sportmatedblayer.SportMateDB;


public class DisponibilitaService {

	public DisponibilitaService() {}
	
	public static int aggiungiDisponibilita(Disponibilita disponibilita) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create =  db.getContext();	
		return create.insertInto(DISPONIBILITA, DISPONIBILITA.DATAORA, 
				DISPONIBILITA.PREZZO, DISPONIBILITA.TIPOCAMPO,
				DISPONIBILITA.IDCENTRO)
		.values( disponibilita.getDataOra().toString(), 
				disponibilita.getPrezzo(), disponibilita.getTipoCampo().getIdCampo(),
				disponibilita.getCentro().getIdCentro())
		.returning(DISPONIBILITA.IDDISPONIBILITA)
		.execute();
	}
	
	public static int aggiornaDisponibilita(Disponibilita disponibilita) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create =  db.getContext();
		int result = create.update(DISPONIBILITA)
	            .set(DISPONIBILITA.DATAORA, disponibilita.getDataOra().toString())
	            .set(DISPONIBILITA.PREZZO, disponibilita.getPrezzo())
	            .set(DISPONIBILITA.TIPOCAMPO, disponibilita.getTipoCampo().getIdCampo()) 
	            .set(DISPONIBILITA.IDCENTRO, disponibilita.getCentro().getIdCentro())
	            .set(DISPONIBILITA.PRENOTATO, disponibilita.getPrenotato())
	            .where(DISPONIBILITA.IDCENTRO.eq(disponibilita.getIdDisp())) 
	            .execute(); 
		db.chiudiConnessione();
		return result;
	}
	
	
	public static List<Disponibilita> findAll() {
		SportMateDB db = SportMateDB.getInstance();
		List<Disponibilita> list = new ArrayList<>();
		db.apriConnessione();
		DSLContext create = db.getContext();
		Result<Record6<Integer, String, BigDecimal, Integer , Integer, Integer>> result = create.select(DISPONIBILITA.IDDISPONIBILITA, DISPONIBILITA.DATAORA, DISPONIBILITA.PREZZO, DISPONIBILITA.TIPOCAMPO, DISPONIBILITA.IDCENTRO, DISPONIBILITA.PRENOTATO).from(DISPONIBILITA).fetch();
		db.chiudiConnessione();
		for (Record6<Integer, String, BigDecimal, Integer , Integer, Integer> disp : result) {
			TipoCampo tipo = TipoCampoService.findTipoCampo(disp.get(DISPONIBILITA.TIPOCAMPO));
			CentriSportivi centro = CentriSportiviService.findByIdCentro(disp.get(DISPONIBILITA.IDCENTRO));
			list.add(new Disponibilita(disp.get(DISPONIBILITA.IDDISPONIBILITA),LocalDateTime.parse(disp.get(DISPONIBILITA.DATAORA)), disp.get(DISPONIBILITA.PREZZO), tipo, centro , disp.get(DISPONIBILITA.PRENOTATO)));
		}
		return list;
	}
	
	public static List<DisponibilitaUtente> findAllUtente() {
		SportMateDB db = SportMateDB.getInstance();
		List<DisponibilitaUtente> list = new ArrayList<>();
		db.apriConnessione();
		DSLContext create = db.getContext();
		Result<Record4<Integer, String, BigDecimal, Integer >> result = create.select( DISPONIBILITA.IDCENTRO, DISPONIBILITA.DATAORA, DISPONIBILITA.PREZZO, DISPONIBILITA.TIPOCAMPO).from(DISPONIBILITA).fetch();
		// .where(DSL.timestamp(DISPONIBILITA.DATAORA.toString()).greaterThan(DSL.currentTimestamp()))
		db.chiudiConnessione();
		for (Record4<Integer, String, BigDecimal, Integer > disp : result) {
			TipoCampo tipo = TipoCampoService.findTipoCampo(disp.get(DISPONIBILITA.TIPOCAMPO));
			CentriSportivi centro = CentriSportiviService.findByIdCentro(disp.get(DISPONIBILITA.IDCENTRO));
			list.add(new DisponibilitaUtente(centro.getNomeComm(),LocalDateTime.parse(disp.get(DISPONIBILITA.DATAORA)), tipo.getNomeCampo(), disp.get(DISPONIBILITA.PREZZO)));
		}
		return list;
	}
	

	
}
