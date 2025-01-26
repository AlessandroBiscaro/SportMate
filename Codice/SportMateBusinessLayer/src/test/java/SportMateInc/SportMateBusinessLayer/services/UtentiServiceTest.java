package SportMateInc.SportMateBusinessLayer.services;
import static org.junit.Assert.*;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Utenti.UTENTI;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sportmateinc.sportmatebusinesslayer.entity.Livello;
import sportmateinc.sportmatebusinesslayer.entity.Utente;
import sportmateinc.sportmatebusinesslayer.services.LivelliService;
import sportmateinc.sportmatebusinesslayer.services.UtentiService;
import sportmateinc.sportmatedblayer.SportMateDB;

public class UtentiServiceTest {

    private Utente testUtente;
    private SportMateDB db;
    private DSLContext create;

    @Before
    public void setUp() {
        db = SportMateDB.getInstance();
        db.apriConnessione();
        create = db.getContext();

        // Creazione di un livello di test esistente
        Livello livelloBase = LivelliService.findLivello(1); 

        // Creazione di un utente di test con valori casuali
        testUtente = new Utente(
        	0,
            "testuser" + new Random().nextInt(10000) + "@mail.com",
            "Mario",
            "Rossi",
            LocalDate.of(1990, 5, 20),
            "1234567890",
            "password123",
            BigDecimal.valueOf(100.0),
            livelloBase
        );

        int result = UtentiService.aggiungiUtente(testUtente);
        assertEquals("Inserimento utente fallito", 1, result);

        // Recuperiamo l'utente inserito per ottenere il suo ID
        Record record = create.select().from(UTENTI).where(UTENTI.MAIL.eq(testUtente.getMail())).fetchOne();
        testUtente.setIdUtente(record.get(UTENTI.IDUTENTE));
    }

    @Test
    public void testFindByUsernameExistingUser() {
        Utente foundUser = UtentiService.findByUsername(testUtente.getMail());

        assertNotNull("L'utente non dovrebbe essere null", foundUser);
        assertEquals("L'email non corrisponde", testUtente.getMail(), foundUser.getMail());
        assertEquals("Il nome non corrisponde", testUtente.getNome(), foundUser.getNome());
        assertEquals("Il cognome non corrisponde", testUtente.getCognome(), foundUser.getCognome());
        assertEquals("La data di nascita non corrisponde", testUtente.getDataNascita(), foundUser.getDataNascita());
    }

    @Test
    public void testAggiornaDatiUtente() {
        // Modifica di alcuni dati dell'utente
        testUtente.setNome("Luca");
        testUtente.setCognome("Bianchi");
        testUtente.setTelefono("0987654321");

        int updateResult = UtentiService.aggiornaDatiUtente(testUtente);
        assertEquals("Aggiornamento utente fallito", 1, updateResult);

        // Recuperiamo l'utente aggiornato e verifichiamo i nuovi dati
        Utente updatedUser = UtentiService.findByUsername(testUtente.getMail());
        assertEquals("Il nome aggiornato non corrisponde", "Luca", updatedUser.getNome());
        assertEquals("Il cognome aggiornato non corrisponde", "Bianchi", updatedUser.getCognome());
        assertEquals("Il telefono aggiornato non corrisponde", "0987654321", updatedUser.getTelefono());
    }

    @Test
    public void testFindByUsernameNonExistingUser() {
        Utente foundUser = null;
        try {
        	 foundUser = UtentiService.findByUsername("nonexistentuser@mail.com");
        	 fail("NullPointerException dovrebbe essere sollevata!");
        }
        catch(NullPointerException e) {}
        assertNull("L'utente inesistente dovrebbe essere null", foundUser);
    }

    @After
    public void tearDown() {
        // Eliminazione utente di test
        int deleteResult = create.deleteFrom(UTENTI).where(UTENTI.IDUTENTE.eq(testUtente.getIdUtente())).execute();
        assertEquals("Eliminazione utente fallita", 1, deleteResult);

        db.chiudiConnessione();
    }
}
