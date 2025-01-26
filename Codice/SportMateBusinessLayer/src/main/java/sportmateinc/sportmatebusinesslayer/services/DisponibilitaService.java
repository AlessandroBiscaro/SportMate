package sportmateinc.sportmatebusinesslayer.services;


import static sportmateinc.sportmatebusinesslayergenerated.tables.Disponibilita.DISPONIBILITA;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Utenti.UTENTI;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record4;
import org.jooq.Record5;
import org.jooq.Record6;
import org.jooq.Result;

import sportmateinc.sportmatebusinesslayer.entities.CentriSportivi;
import sportmateinc.sportmatebusinesslayer.entities.Disponibilita;
import sportmateinc.sportmatebusinesslayer.entities.DisponibilitaUtente;
import sportmateinc.sportmatebusinesslayer.entities.TipoCampo;
import sportmateinc.sportmatebusinesslayer.entities.Utente;
import sportmateinc.sportmatedblayer.SportMateDB;


public class DisponibilitaService {
	private DisponibilitaService() {
		//Utility class
	}
	
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
	
	public static Disponibilita findById(int idDisp) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create = db.getContext();
		Record result = create.select()
				.from(DISPONIBILITA)
		.where(DISPONIBILITA.IDDISPONIBILITA.eq(idDisp))
		.fetchOne();
		db.chiudiConnessione();
		TipoCampo tipo = TipoCampoService.findTipoCampo(result.get(DISPONIBILITA.TIPOCAMPO));
		CentriSportivi centro = CentriSportiviService.findByIdCentro(result.get(DISPONIBILITA.IDCENTRO));
		return new Disponibilita(result.get(DISPONIBILITA.IDDISPONIBILITA),LocalDateTime.parse(result.get(DISPONIBILITA.DATAORA)), result.get(DISPONIBILITA.PREZZO), tipo, centro , result.get(DISPONIBILITA.PRENOTATO));
	}
	
	public static List<DisponibilitaUtente> findAllUtente() {
		SportMateDB db = SportMateDB.getInstance();
		List<DisponibilitaUtente> list = new ArrayList<>();
		db.apriConnessione();
		DSLContext create = db.getContext();
		Result<Record5<Integer,Integer, String, BigDecimal, Integer >> result = create.select(DISPONIBILITA.IDDISPONIBILITA,DISPONIBILITA.IDCENTRO, DISPONIBILITA.DATAORA, DISPONIBILITA.PREZZO, DISPONIBILITA.TIPOCAMPO).from(DISPONIBILITA).fetch();
		// .where(DSL.timestamp(DISPONIBILITA.DATAORA.toString()).greaterThan(DSL.currentTimestamp()))
		db.chiudiConnessione();
		for (Record5<Integer,Integer, String, BigDecimal, Integer > disp : result) {
			TipoCampo tipo = TipoCampoService.findTipoCampo(disp.get(DISPONIBILITA.TIPOCAMPO));
			CentriSportivi centro = CentriSportiviService.findByIdCentro(disp.get(DISPONIBILITA.IDCENTRO));
			list.add(new DisponibilitaUtente(disp.get(DISPONIBILITA.IDDISPONIBILITA),centro.getNomeComm(),LocalDateTime.parse(disp.get(DISPONIBILITA.DATAORA)), tipo.getNomeCampo(), disp.get(DISPONIBILITA.PREZZO)));
		}
		return list;
	}
	
	public static List<Disponibilita> findByGestore(int idCentro) {
		SportMateDB db = SportMateDB.getInstance();
		List<Disponibilita> list = new ArrayList<>();
		db.apriConnessione();
		DSLContext create = db.getContext();
		Result<Record6<Integer, String, BigDecimal, Integer , Integer, Integer>> result = create.select(DISPONIBILITA.IDDISPONIBILITA, 
				DISPONIBILITA.DATAORA, DISPONIBILITA.PREZZO, DISPONIBILITA.TIPOCAMPO, 
				DISPONIBILITA.IDCENTRO, DISPONIBILITA.PRENOTATO).from(DISPONIBILITA).
				where(DISPONIBILITA.IDCENTRO.equal(idCentro)).fetch();
		db.chiudiConnessione();
		for (Record6<Integer, String, BigDecimal, Integer , Integer, Integer> disp : result) {
			TipoCampo tipo = TipoCampoService.findTipoCampo(disp.get(DISPONIBILITA.TIPOCAMPO));
			CentriSportivi centro = CentriSportiviService.findByIdCentro(disp.get(DISPONIBILITA.IDCENTRO));
			list.add(new Disponibilita(disp.get(DISPONIBILITA.IDDISPONIBILITA),
					LocalDateTime.parse(disp.get(DISPONIBILITA.DATAORA)),
					disp.get(DISPONIBILITA.PREZZO), tipo, centro , disp.get(DISPONIBILITA.PRENOTATO)));
		}
		return list;
	}
	

	
}
