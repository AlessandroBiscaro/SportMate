package sportmateinc.sportmatebusinesslayer.services;

import static sportmateinc.sportmatebusinesslayergenerated.tables.Disponibilita.DISPONIBILITA;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Partite.PARTITE;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record5;
import org.jooq.Result;

import sportmateinc.sportmatebusinesslayer.entities.CentriSportivi;
import sportmateinc.sportmatebusinesslayer.entities.DisponibilitaUtente;
import sportmateinc.sportmatebusinesslayer.entities.TipoCampo;
import sportmateinc.sportmatebusinesslayer.entities.Utente;
import sportmateinc.sportmatedblayer.SportMateDB;

public class PrenotazioneService {
	
	private PrenotazioneService() {}
	
	public static List<DisponibilitaUtente> findByUtente(Utente user) {
		SportMateDB db = SportMateDB.getInstance();
		List<DisponibilitaUtente> list = new ArrayList<>();
		db.apriConnessione();
		DSLContext create = db.getContext();
		Result<Record5<Integer, Integer, String, BigDecimal, Integer>> result = create.select(DISPONIBILITA.IDDISPONIBILITA,DISPONIBILITA.IDCENTRO, DISPONIBILITA.DATAORA, DISPONIBILITA.PREZZO, DISPONIBILITA.TIPOCAMPO)
				.from(DISPONIBILITA).join(PARTITE).on(PARTITE.IDDISPONIBILITA.eq(DISPONIBILITA.IDDISPONIBILITA))
				.where(PARTITE.IDORGANIZZATORE.eq(user.getIdUtente()))
				.fetch();
		db.chiudiConnessione();
		for (Record5<Integer,Integer, String, BigDecimal, Integer > disp : result) {
			TipoCampo tipo = TipoCampoService.findTipoCampo(disp.get(DISPONIBILITA.TIPOCAMPO));
			CentriSportivi centro = CentriSportiviService.findByIdCentro(disp.get(DISPONIBILITA.IDCENTRO));
			list.add(new DisponibilitaUtente(disp.get(DISPONIBILITA.IDDISPONIBILITA),centro.getNomeComm(),LocalDateTime.parse(disp.get(DISPONIBILITA.DATAORA)), tipo.getNomeCampo(), disp.get(DISPONIBILITA.PREZZO)));
		}
		return list;
	}
}
