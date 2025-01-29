package SportMateInc.SportMateBusinessLayer.services;


import static org.junit.Assert.*;

import org.jooq.DSLContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sportmateinc.sportmatebusinesslayer.entities.Feedback;
import sportmateinc.sportmatebusinesslayer.entities.Utente;
import sportmateinc.sportmatebusinesslayer.services.FeedbackService;
import sportmateinc.sportmatebusinesslayer.services.LivelliService;
import sportmateinc.sportmatebusinesslayer.services.UtentiService;
import sportmateinc.sportmatedblayer.SportMateDB;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Utenti.UTENTI;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Feedback.FEEDBACK;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FeedbackServiceTest {

	private SportMateDB db;
	private DSLContext create;
	private  List<Feedback> feedbackListBefore = new ArrayList<>();
	private  List<Feedback> feedbackList = new ArrayList<>();
	private int userId;
	private int sizeBefore;
	@Before
	public void setUp() throws Exception {
		db = SportMateDB.getInstance();
		db.apriConnessione();
		create = db.getContext();


		Utente testUtente = new Utente(0, "testuser@example.com", "Marco", "Verdi",
				LocalDate.of(1992, 8, 15), "3339998888", "testpassword", 
				new BigDecimal("50"), LivelliService.findLivello(1));
		userId = UtentiService.aggiungiUtente(testUtente);
		feedbackListBefore = FeedbackService.findAll();
		sizeBefore = feedbackListBefore.size();

		create.insertInto(FEEDBACK, FEEDBACK.OGGETTO, FEEDBACK.TESTO, FEEDBACK.NUMLIKE, FEEDBACK.IDUTENTE)
		.values("Ottimo servizio", "Esperienza molto positiva!", 10, userId)
		.execute();

		create.insertInto(FEEDBACK, FEEDBACK.OGGETTO, FEEDBACK.TESTO, FEEDBACK.NUMLIKE, FEEDBACK.IDUTENTE)
		.values("Non soddisfatto", "Ho avuto qualche problema con il supporto.", 3, userId)
		.execute();


	}


	@Test
	public void testFindAll() {
		feedbackList = FeedbackService.findAll();


		assertNotNull("La lista dei feedback è nulla", feedbackList);
		assertFalse("La lista dei feedback è vuota", feedbackList.isEmpty());


		assertEquals("Numero di feedback non corrispondente", 2+sizeBefore, feedbackList.size());

		Feedback feedback1 = feedbackList.get(3);
		assertEquals("Oggetto errato per il primo feedback", "Ottimo servizio", feedback1.getOggetto());
		assertEquals("Testo errato per il primo feedback", "Esperienza molto positiva!", feedback1.getTesto());
		assertEquals("Numero di like errato per il primo feedback", 10, feedback1.getNumLike());

		Feedback feedback2 = feedbackList.get(4);
		assertEquals("Oggetto errato per il secondo feedback", "Non soddisfatto", feedback2.getOggetto());
		assertEquals("Testo errato per il secondo feedback", "Ho avuto qualche problema con il supporto.", feedback2.getTesto());
		assertEquals("Numero di like errato per il secondo feedback", 3, feedback2.getNumLike());
	}

	@After
	public void tearDown() throws Exception {

		create.deleteFrom(FEEDBACK).where(FEEDBACK.IDFEEDBACK.eq(feedbackList.get(3).getIdFeedback())).execute();
		create.deleteFrom(FEEDBACK).where(FEEDBACK.IDFEEDBACK.eq(feedbackList.get(4).getIdFeedback())).execute();
		create.deleteFrom(UTENTI).where(UTENTI.IDUTENTE.eq(userId)).execute();
		db.chiudiConnessione();
	}


}


