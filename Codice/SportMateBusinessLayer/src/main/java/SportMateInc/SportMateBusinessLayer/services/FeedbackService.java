package SportMateInc.SportMateBusinessLayer.services;

import static SportMateInc.SportMateBusinessLayer.tables.Feedback.FEEDBACK;
import static SportMateInc.SportMateBusinessLayer.tables.Utenti.UTENTI;

import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record3;

import sportmateinc.sportmatedblayer.SportMateDB;

public class FeedbackService {
	
	public static List<Record3<String, String, String>> findAll() {
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext create = db.getContext();
		List<Record3<String, String, String>> result = create.select(FEEDBACK.TESTO, UTENTI.NOME, UTENTI.COGNOME).from(FEEDBACK)
				.join(UTENTI).on(FEEDBACK.IDUTENTE.eq(UTENTI.IDUTENTE)).fetch();
		db.chiudiConnessione();
		return result;
	}
}
