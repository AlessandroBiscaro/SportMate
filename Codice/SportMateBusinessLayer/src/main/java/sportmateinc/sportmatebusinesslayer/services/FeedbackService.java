package sportmateinc.sportmatebusinesslayer.services;

import static sportmateinc.sportmatebusinesslayergenerated.tables.Feedback.FEEDBACK;

import java.util.ArrayList;
import java.util.List;
import org.jooq.DSLContext;
import org.jooq.Record;

import sportmateinc.sportmatebusinesslayer.entity.Feedback;
import sportmateinc.sportmatebusinesslayer.entity.Utente;
import sportmateinc.sportmatedblayer.SportMateDB;

public class FeedbackService {
	public static List<Feedback> findAll() {
		List<Feedback> risultato = new ArrayList<>();
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create = db.getContext();
		List<Record> records = create.select().from(FEEDBACK)
				.fetch();
		db.chiudiConnessione();
		for(Record r : records) {
			Utente utente = UtentiService.findById(r.get(FEEDBACK.IDUTENTE));
			Feedback feedback = new Feedback(
					r.get(FEEDBACK.IDFEEDBACK), r.get(FEEDBACK.OGGETTO), r.get(FEEDBACK.TESTO), r.get(FEEDBACK.NUMLIKE), utente
			);
			risultato.add(feedback);
		}
		return risultato;
	}
}
