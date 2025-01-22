package SportMateInc.SportMateBusinessLayer.services;

import static org.junit.Assert.*;

import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record3;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sportmateinc.sportmatedblayer.SportMateDB;
import static SportMateInc.SportMateBusinessLayer.tables.Feedback.FEEDBACK;
import static SportMateInc.SportMateBusinessLayer.tables.Utenti.UTENTI;

public class FeedbackServiceTest {

    private static final String TEST_NOME = "Elena";
    private static final String TEST_COGNOME = "Presciani";
    private static final String TEST_EMAIL = "elena.presciani@test.com";
    private static final String TEST_FEEDBACK = "Ottimo servizio!";
    private static final String TEST_OGGETTO_FEEDBACK = "Recensione SportMate";
    private static final Integer TEST_NUMLIKE = 0;
    
    private Integer testUserId;
    private SportMateDB db;
    private DSLContext create;

    @Before
    public void setUp() {
        db = SportMateDB.getInstance();
        db.apriConnessione();
        create = db.getContext();

        // Inserimento di un utente di test
        testUserId = create.insertInto(UTENTI)
            .set(UTENTI.MAIL, TEST_EMAIL)
            .set(UTENTI.NOME, TEST_NOME)
            .set(UTENTI.COGNOME, TEST_COGNOME)
            .set(UTENTI.DATANASCITA, "1990-01-01")
            .set(UTENTI.TELEFONO, "1234567890")
            .set(UTENTI.PASSWORD, "password123")
            .returning(UTENTI.IDUTENTE)
            .fetchOne()
            .getValue(UTENTI.IDUTENTE);

        // Inserimento di un feedback di test
        create.insertInto(FEEDBACK)
            .set(FEEDBACK.TESTO, TEST_FEEDBACK)
            .set(FEEDBACK.IDUTENTE, testUserId)
            .set(FEEDBACK.OGGETTO, TEST_OGGETTO_FEEDBACK)
            .set(FEEDBACK.NUMLIKE, TEST_NUMLIKE)
            .execute();

        db.chiudiConnessione();
    }

    @Test
    public void testFindAll_shouldContainInsertedFeedback() {
        List<Record3<String, String, String>> feedbackList = FeedbackService.findAll();

        assertNotNull("La lista dei feedback non dovrebbe essere null", feedbackList);
        assertFalse("La lista dei feedback non dovrebbe essere vuota", feedbackList.isEmpty());

        boolean feedbackTrovato = false;
        for (Record3<String, String, String> feedback : feedbackList) {
            if (TEST_FEEDBACK.equals(feedback.get(FEEDBACK.TESTO)) &&
                TEST_NOME.equals(feedback.get(UTENTI.NOME)) &&
                TEST_COGNOME.equals(feedback.get(UTENTI.COGNOME))) {
                feedbackTrovato = true;
                break;
            }
        }

        assertTrue("Il feedback di test dovrebbe essere presente nella lista", feedbackTrovato);
    }

    @After
    public void tearDown() {
        db.apriConnessione();
        create = db.getContext();

        // Eliminazione del feedback di test
        create.deleteFrom(FEEDBACK)
            .where(FEEDBACK.IDUTENTE.eq(testUserId))
            .execute();

        // Eliminazione dell'utente di test
        create.deleteFrom(UTENTI)
            .where(UTENTI.IDUTENTE.eq(testUserId))
            .execute();

        db.chiudiConnessione();
    }
}
