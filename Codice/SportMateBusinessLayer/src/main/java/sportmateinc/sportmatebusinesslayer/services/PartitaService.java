package sportmateinc.sportmatebusinesslayer.services;


import static sportmateinc.sportmatebusinesslayergenerated.tables.Partite.PARTITE;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record3;
import org.jooq.Record9;
import org.jooq.Result;

import sportmateinc.sportmatebusinesslayer.entities.CentroSportivo;
import sportmateinc.sportmatebusinesslayer.entities.Disponibilita;
import sportmateinc.sportmatebusinesslayer.entities.Partita;
import sportmateinc.sportmatebusinesslayer.entities.InfoPartita;
import sportmateinc.sportmatebusinesslayer.entities.TipoCampo;
import sportmateinc.sportmatedblayer.SportMateDB;

public class PartitaService {

	private PartitaService() {
		//Utility class
	}

	public static int aggiungiPartita(Partita partita) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create =  db.getContext();	
		return create.insertInto(PARTITE, PARTITE.POSTITOTALI, 
				PARTITE.PUBBLICA, PARTITE.STATO,
				PARTITE.MODPAGAMENTO,
				PARTITE.IDORGANIZZATORE,
				PARTITE.IDDISPONIBILITA,
				PARTITE.GOALSQUADRACASA,
				PARTITE.GOALSQUADRATRASFERTA)
				.values( partita.getPostiTot(), 
						partita.getPubblica(),
						partita.getStato(), partita.getModPagamento(),
						partita.getIdOrgan(),
						partita.getIdDisp(),
						partita.getGoalCasa(),
						partita.getGoalFuori())
				.returning(PARTITE.IDPARTITA)
				.execute();
	}

	public static int aggiornaPartita(Partita partita) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create =  db.getContext();
		int result = create.update(PARTITE)
				.set(PARTITE.POSTITOTALI, partita.getPostiTot())
				.set(PARTITE.PUBBLICA, partita.getPubblica())
				.set(PARTITE.STATO, partita.getStato()) 
				.set(PARTITE.MODPAGAMENTO, partita.getModPagamento())
				.set(PARTITE.IDORGANIZZATORE, partita.getIdOrgan())
				.set(PARTITE.IDDISPONIBILITA, partita.getIdDisp())
				.set(PARTITE.GOALSQUADRACASA, partita.getGoalCasa())
				.set(PARTITE.GOALSQUADRATRASFERTA, partita.getGoalFuori())
				.where(PARTITE.IDDISPONIBILITA.eq(partita.getIdDisp())) 
				.execute(); 
		db.chiudiConnessione();
		return result;
	}

	public static List<Partita> findAll() {
		SportMateDB db = SportMateDB.getInstance();
		List<Partita> list = new ArrayList<>();
		db.apriConnessione();
		DSLContext create = db.getContext();
		Result<Record9<Integer, Integer, Integer, Integer , String, Integer,Integer,Integer,Integer>> result =
				create.select(PARTITE.IDPARTITA, PARTITE.POSTITOTALI, PARTITE.PUBBLICA, 
						PARTITE.STATO, PARTITE.MODPAGAMENTO, PARTITE.IDORGANIZZATORE,
						PARTITE.IDDISPONIBILITA, PARTITE.GOALSQUADRACASA, 
						PARTITE.GOALSQUADRATRASFERTA).
				from(PARTITE).fetch();
		db.chiudiConnessione();
		for (Record9<Integer, Integer, Integer, Integer , String, Integer,Integer,Integer,Integer> partita : result) {
			list.add(new Partita(partita.get(PARTITE.IDPARTITA),
					(partita.get(PARTITE.POSTITOTALI)),partita.get(PARTITE.PUBBLICA),
					partita.get(PARTITE.STATO),
					partita.get(PARTITE.MODPAGAMENTO) , 
					partita.get(PARTITE.IDORGANIZZATORE),
					partita.get(PARTITE.IDDISPONIBILITA)
					));
		}
		return list;
	}
	
	public static Partita findByDisponibilita(Integer idDisponibilita) {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create = db.getContext();
		Record9<Integer, Integer, Integer, Integer, String, Integer, Integer, Integer, Integer> partita =
				create.select(PARTITE.IDPARTITA, PARTITE.POSTITOTALI, PARTITE.PUBBLICA, 
						PARTITE.STATO, PARTITE.MODPAGAMENTO, PARTITE.IDORGANIZZATORE,
						PARTITE.IDDISPONIBILITA, PARTITE.GOALSQUADRACASA, 
						PARTITE.GOALSQUADRATRASFERTA).
				from(PARTITE).where(PARTITE.IDDISPONIBILITA.eq(idDisponibilita)).fetchOne();
		db.chiudiConnessione();
		return new Partita(partita.get(PARTITE.IDPARTITA),
					(partita.get(PARTITE.POSTITOTALI)),partita.get(PARTITE.PUBBLICA),
					partita.get(PARTITE.STATO),
					partita.get(PARTITE.MODPAGAMENTO) , 
					partita.get(PARTITE.IDORGANIZZATORE),
					partita.get(PARTITE.IDDISPONIBILITA));
	}
	
	
	public static List<InfoPartita> findAllPubbliche() {
		SportMateDB db = SportMateDB.getInstance();
		List<InfoPartita> list = new ArrayList<>();
		db.apriConnessione();
		DSLContext create = db.getContext();
		Result<Record3<Integer,Integer, Integer >> result = create.select(PARTITE.IDPARTITA,PARTITE.POSTITOTALI, PARTITE.IDDISPONIBILITA ).from(PARTITE).where(PARTITE.PUBBLICA.eq(1)).fetch();
		// .where(DSL.timestamp(DISPONIBILITA.DATAORA.toString()).greaterThan(DSL.currentTimestamp()))
		db.chiudiConnessione();
		for (Record3<Integer, Integer, Integer > partPubb : result) {
			Disponibilita disp = DisponibilitaService.findById(partPubb.get(PARTITE.IDPARTITA));
			TipoCampo tipo = TipoCampoService.findTipoCampo(disp.getTipoCampo().getIdCampo());
			CentroSportivo centro = CentriSportiviService.findByIdCentro(disp.getCentro().getIdCentro());
			BigDecimal prezzo = (disp.getPrezzo().divide(new BigDecimal("10"), RoundingMode.HALF_UP));
			list.add(new InfoPartita(partPubb.get(PARTITE.IDPARTITA),centro.getNomeComm(),disp.getDataOra(), tipo.getNomeCampo(), prezzo, partPubb.get(PARTITE.POSTITOTALI)));
		}
		return list;
	}

}
